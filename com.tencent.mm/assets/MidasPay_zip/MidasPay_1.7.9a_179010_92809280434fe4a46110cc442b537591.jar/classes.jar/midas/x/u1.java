package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.data.report.APDataReportManager;
import com.pay.module.push.APCloudWaitActivity;
import com.pay.tool.APTools;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.f;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;

public class u1
{
  public static u1 c()
  {
    return i.a();
  }
  
  public static void c(final Context paramContext, final i5 parami5, h5 paramh5)
  {
    parami5.a(parami5.d, new f(paramh5, parami5, paramContext));
  }
  
  public void a()
  {
    v1.e().a("listen_cloud_detect");
    v1.e().a("listen_cloud_message");
    v1.e().a("key_test_message");
    if (v1.e().c() <= 0) {
      v1.e().a();
    }
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    r1.d().b(paramAPBaseRequest);
    if ((r1.i()) && (!r1.h()))
    {
      try
      {
        if (!c6.s0().g0()) {
          c().a();
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
      b();
      v1.e().a(r1.e(), new g(), paramAPBaseRequest);
    }
  }
  
  public void a(final Context paramContext, final i5 parami5, Bundle paramBundle, final h5 paramh5, final g5 paramg5)
  {
    APDataReportManager.getInstance().insertData("sdk.cloudgame.enter", p4.p().e().b.saveType);
    if (!c6.s0().g0())
    {
      paramBundle = new APAlertDialog.f(paramContext);
      paramBundle.a("网络异常，请更换其他非微信/非QQ钱包的支付方式");
      paramBundle.b("继续支付", new a(paramContext, parami5, paramh5, paramg5));
      paramBundle.a("更换", new b(paramh5));
      paramBundle.b(new c(paramh5));
      try
      {
        paramBundle.b();
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    a(paramContext, parami5, paramh5, paramg5);
  }
  
  public final void a(Context paramContext, i5 parami5, h5 paramh5)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("channelId", parami5.d);
    localIntent.putExtra("receiver", new h(paramContext, new Handler(), parami5, paramh5));
    localIntent.setClass(paramContext, APCloudWaitActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  public final void a(Context paramContext, i5 parami5, h5 paramh5, g5 paramg5)
  {
    if (paramh5 != null) {
      paramh5.a();
    }
    b(paramContext, parami5, paramh5, paramg5);
    a(paramContext, parami5, paramh5);
    parami5.a(paramContext, paramh5, paramg5);
  }
  
  public final void a(s1 params1, Context paramContext, i5 parami5, h5 paramh5, g5 paramg5)
  {
    paramg5 = APTools.m(params1.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receivedData() bundle 00 = ");
    ((StringBuilder)localObject).append(paramg5);
    APLog.d("MidasPushCloud", ((StringBuilder)localObject).toString());
    if (paramg5 == null)
    {
      APLog.w("MidasPushCloud", "addListener.onMessage() bundle = Null");
      return;
    }
    localObject = paramg5.getString("cloudCallback_resultChannel");
    if ((!TextUtils.isEmpty(parami5.d)) && (!parami5.d.equalsIgnoreCase((String)localObject))) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receivedData() data = ");
    ((StringBuilder)localObject).append(params1);
    ((StringBuilder)localObject).append(", bundle = ");
    ((StringBuilder)localObject).append(paramg5);
    APLog.d("MidasPushCloud", ((StringBuilder)localObject).toString());
    params1 = paramg5.getString("cloudCallback_resultIdentify");
    localObject = c6.s0().h();
    if ((params1 != null) && (params1.equals(localObject)))
    {
      APCloudWaitActivity.l();
      int i = paramg5.getInt("cloudCallback_resultCode");
      localObject = paramg5.getBundle("cloudCallback_resultData");
      int j = paramg5.getInt("cloudCallback_resultState");
      if (j == -2)
      {
        APLog.i("MidasPushCloud", "received callback state is state_unknown");
        c(paramContext, parami5, paramh5);
        return;
      }
      if (j == -3)
      {
        APLog.i("MidasPushCloud", "received callback state is state_close");
        c(paramContext, parami5, paramh5);
        return;
      }
      boolean bool = parami5.d.equals("qqwallet");
      paramh5 = "no retMsg";
      if ((bool) && (i == -11))
      {
        parami5 = ((Bundle)localObject).getString("retMsg");
        params1 = parami5;
        if (parami5 == null) {
          params1 = "no retMsg";
        }
        parami5 = new StringBuilder();
        parami5.append("QQ拉起失败或未安装: ");
        parami5.append(params1);
        APLog.e("MidasPushCloud", parami5.toString());
        APUICommonMethod.a(paramContext, "QQ拉起失败或未安装");
        return;
      }
      if ((parami5.d.equals("wechat")) && (i == -10))
      {
        params1 = paramh5;
        if (localObject != null)
        {
          params1 = ((Bundle)localObject).getString("retMsg");
          if (params1 == null) {
            params1 = paramh5;
          }
        }
        parami5 = new StringBuilder();
        parami5.append("WeChat拉起失败或未安装: ");
        parami5.append(params1);
        APLog.e("MidasPushCloud", parami5.toString());
        APUICommonMethod.a(paramContext, "WeChat拉起失败或未安装");
        return;
      }
      params1 = APDataReportManager.getInstance();
      j = p4.p().e().b.saveType;
      paramContext = p4.p().e().f.k;
      paramh5 = new StringBuilder();
      paramh5.append("channelid=");
      paramh5.append(parami5.d);
      params1.insertData("sdk.cloudgame.pay.success", j, paramContext, null, paramh5.toString());
      parami5.a(i, (Bundle)localObject);
      return;
    }
    APLog.w("MidasPushCloud", String.format("receivedData() savedIdentify(%s) != receivedIdentify(%s) , so return", new Object[] { localObject, params1 }));
  }
  
  public boolean a(Context paramContext, w3 paramw3, String paramString)
  {
    if ((paramw3.d() == 0) && (r1.i()) && (r1.d(paramString)))
    {
      paramContext = new StringBuilder();
      paramContext.append("progressSaveAns() is CloudSide, So return!  channelId = ");
      paramContext.append(paramString);
      APLog.w("MidasPushCloud", paramContext.toString());
      return true;
    }
    APCloudWaitActivity.l();
    return false;
  }
  
  public final void b()
  {
    final int i = (int)(Math.random() * 10000.0D);
    v1.e().a("listen_cloud_detect", new d(i));
  }
  
  public final void b(final Context paramContext, final i5 parami5, final h5 paramh5, final g5 paramg5)
  {
    Math.random();
    v1.e().a("listen_cloud_message", new e(paramContext, parami5, paramh5, paramg5));
  }
  
  public class a
    implements c7
  {
    public a(Context paramContext, i5 parami5, h5 paramh5, g5 paramg5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramAPAlertDialog.f();
      u1.a(u1.this, paramContext, parami5, paramh5, paramg5);
    }
  }
  
  public class b
    implements c7
  {
    public b(h5 paramh5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      paramKeyEvent = paramh5;
      if (paramKeyEvent != null) {
        paramKeyEvent.a();
      }
      paramAPAlertDialog.f();
      if (!a.r().f)
      {
        paramAPAlertDialog.f();
        APUICommonMethod.f();
        z5.a(2, "");
        return;
      }
      paramAPAlertDialog.f();
    }
  }
  
  public class c
    implements c7
  {
    public c(h5 paramh5) {}
    
    public void a(APAlertDialog paramAPAlertDialog, int paramInt, KeyEvent paramKeyEvent)
    {
      if ((paramInt == 4) && (paramKeyEvent.getAction() == 0))
      {
        paramKeyEvent = paramh5;
        if (paramKeyEvent != null) {
          paramKeyEvent.a();
        }
        paramAPAlertDialog.f();
        if (!a.r().f)
        {
          APUICommonMethod.f();
          z5.a(2, "");
          return;
        }
        paramAPAlertDialog.f();
      }
    }
  }
  
  public class d
    implements v1.d
  {
    public d(int paramInt) {}
    
    public void a(int paramInt, String paramString) {}
    
    public void a(s1 params1)
    {
      if ((params1.b() == 2) && (params1.a() == i + 1)) {
        c6.s0().b(true);
      }
    }
    
    public void a(t9 paramt9)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("detectOnFailure");
      localStringBuilder.append(paramt9.b);
      APLog.w("MidasPushCloud", localStringBuilder.toString());
    }
    
    public void b(int paramInt, String paramString)
    {
      c6.s0().b(false);
      paramString = s1.a(i, r1.a(), r1.b(), r1.e());
      v1.e().a(paramString);
    }
  }
  
  public class e
    implements v1.d
  {
    public e(Context paramContext, i5 parami5, h5 paramh5, g5 paramg5) {}
    
    public void a(int paramInt, String paramString) {}
    
    public void a(s1 params1)
    {
      if (params1.b() == 3) {
        u1.a(u1.this, params1, paramContext, parami5, paramh5, paramg5);
      }
    }
    
    public void a(t9 paramt9)
    {
      if (paramt9 != null)
      {
        Context localContext = paramContext;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("网络异常断开，请重新拉起支付：");
        localStringBuilder.append(paramt9.a);
        APUICommonMethod.a(localContext, localStringBuilder.toString());
        return;
      }
      APUICommonMethod.a(paramContext, "网络异常断开, 请重新拉起支付");
    }
    
    public void b(int paramInt, String paramString) {}
  }
  
  public static final class f
    implements fc
  {
    public f(h5 paramh5, i5 parami5, Context paramContext) {}
    
    public void a(ob paramob)
    {
      Object localObject = this.a;
      if (localObject != null) {
        ((h5)localObject).a();
      }
      paramob = (q3)paramob;
      if ((paramob.d() == 0) && (paramob.g() == 1))
      {
        paramob = APDataReportManager.getInstance();
        i = p4.p().e().b.saveType;
        localObject = p4.p().e().f.k;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("channelid=");
        localStringBuilder.append(parami5.d);
        paramob.insertData("sdk.cloudgame.pay.success", i, (String)localObject, null, localStringBuilder.toString());
        parami5.a(null);
        return;
      }
      int i = r1.c(parami5.d);
      parami5.a(paramContext, i);
    }
    
    public void b(ob paramob)
    {
      paramob = this.a;
      if (paramob != null) {
        paramob.a();
      }
      parami5.a(paramContext, 5, "支付结果未知", this.a);
    }
    
    public void c(ob paramob)
    {
      paramob = this.a;
      if (paramob != null) {
        paramob.a();
      }
      parami5.b(paramContext, this.a);
    }
  }
  
  public class g
    implements u9.d
  {
    public volatile long a = 0L;
    public volatile long b = 3L;
    
    public g() {}
    
    public void a(Runnable paramRunnable)
    {
      try
      {
        this.a = 0L;
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
    
    public boolean b(Runnable paramRunnable)
    {
      try
      {
        this.a += 1L;
        if (this.b > 0L)
        {
          long l1 = this.a;
          long l2 = this.b;
          if (l1 > l2) {
            return false;
          }
        }
        paramRunnable.run();
        return true;
      }
      finally {}
    }
  }
  
  public static class h
    extends ResultReceiver
  {
    public final WeakReference<Context> a;
    public final WeakReference<i5> b;
    public final WeakReference<h5> c;
    
    public h(Context paramContext, Handler paramHandler, i5 parami5, h5 paramh5)
    {
      super();
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(parami5);
      this.c = new WeakReference(paramh5);
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      i5 locali5;
      Context localContext;
      StringBuilder localStringBuilder;
      if (paramInt == 1)
      {
        paramBundle = (h5)this.c.get();
        if (paramBundle != null) {
          paramBundle.a();
        }
        locali5 = (i5)this.b.get();
        localContext = (Context)this.a.get();
        if ((locali5 != null) && (localContext != null))
        {
          locali5.b(localContext, paramBundle);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResult CODE_CANCEL weakRef null : context=");
        localStringBuilder.append(localContext);
        localStringBuilder.append(", payChannel=");
        localStringBuilder.append(locali5);
        localStringBuilder.append(", callback=");
        localStringBuilder.append(paramBundle);
        APLog.e("MidasPushCloud", localStringBuilder.toString());
        return;
      }
      if (paramInt == 2)
      {
        paramBundle = (h5)this.c.get();
        locali5 = (i5)this.b.get();
        localContext = (Context)this.a.get();
        if ((paramBundle != null) && (locali5 != null) && (localContext != null))
        {
          u1.b(localContext, locali5, paramBundle);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResult CODE_QUERY weakRef null : context=");
        localStringBuilder.append(localContext);
        localStringBuilder.append(", payChannel=");
        localStringBuilder.append(locali5);
        localStringBuilder.append(", callback=");
        localStringBuilder.append(paramBundle);
        APLog.e("MidasPushCloud", localStringBuilder.toString());
      }
    }
  }
  
  public static class i
  {
    public static u1 a = new u1(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.u1
 * JD-Core Version:    0.7.0.1
 */