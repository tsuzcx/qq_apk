package midas.x;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.pay.api.request.APBaseRequest;
import com.pay.module.push.APCloudWaitActivity;
import com.pay.tool.APTools;
import com.pay.ui.common.APAlertDialog;
import com.pay.ui.common.APAlertDialog.a;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;

public class bt
{
  public static bt a()
  {
    return c.a();
  }
  
  private void a(Context paramContext, ff paramff, fe paramfe, fd paramfd)
  {
    if (paramfe != null) {
      paramfe.a();
    }
    b(paramContext, paramff, paramfe, paramfd);
    b(paramContext, paramff, paramfe);
    paramff.a(paramContext, paramfe, paramfd);
  }
  
  private void a(br parambr, Context paramContext, ff paramff, fe paramfe, fd paramfd)
  {
    paramfd = APTools.q(parambr.c);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receivedData() bundle 00 = ");
    ((StringBuilder)localObject).append(paramfd);
    APLog.d("MidasPushCloud", ((StringBuilder)localObject).toString());
    if (paramfd == null)
    {
      APLog.w("MidasPushCloud", "addListener.onMessage() bundle = Null");
      return;
    }
    localObject = paramfd.getString("cloudCallback_resultChannel");
    if ((!TextUtils.isEmpty(paramff.e)) && (!paramff.e.equalsIgnoreCase((String)localObject))) {
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receivedData() data = ");
    ((StringBuilder)localObject).append(parambr);
    ((StringBuilder)localObject).append(", bundle = ");
    ((StringBuilder)localObject).append(paramfd);
    APLog.d("MidasPushCloud", ((StringBuilder)localObject).toString());
    parambr = paramfd.getString("cloudCallback_resultIdentify");
    localObject = fy.a().ap();
    if ((parambr != null) && (parambr.equals(localObject)))
    {
      APCloudWaitActivity.a();
      int i = paramfd.getInt("cloudCallback_resultCode");
      localObject = paramfd.getBundle("cloudCallback_resultData");
      int j = paramfd.getInt("cloudCallback_resultState");
      if (j == -2)
      {
        APLog.i("MidasPushCloud", "received callback state is state_unknown");
        c(paramContext, paramff, paramfe);
        return;
      }
      if (j == -3)
      {
        APLog.i("MidasPushCloud", "received callback state is state_close");
        c(paramContext, paramff, paramfe);
        return;
      }
      if ((paramff.e.equals("qqwallet")) && (i == -11))
      {
        paramff = ((Bundle)localObject).getString("retMsg");
        parambr = paramff;
        if (paramff == null) {
          parambr = "no retMsg";
        }
        paramff = new StringBuilder();
        paramff.append("QQ拉起失败或未安装: ");
        paramff.append(parambr);
        APLog.e("MidasPushCloud", paramff.toString());
        APUICommonMethod.a(paramContext, "QQ拉起失败或未安装");
        return;
      }
      if ((paramff.e.equals("wechat")) && (i == -10))
      {
        parambr = "no retMsg";
        if (localObject != null)
        {
          paramff = ((Bundle)localObject).getString("retMsg");
          parambr = paramff;
          if (paramff == null) {
            parambr = "no retMsg";
          }
        }
        paramff = new StringBuilder();
        paramff.append("WeChat拉起失败或未安装: ");
        paramff.append(parambr);
        APLog.e("MidasPushCloud", paramff.toString());
        APUICommonMethod.a(paramContext, "WeChat拉起失败或未安装");
        return;
      }
      paramff.a(i, (Bundle)localObject);
      return;
    }
    APLog.w("MidasPushCloud", String.format("receivedData() savedIdentify(%s) != receivedIdentify(%s) , so return", new Object[] { localObject, parambr }));
  }
  
  private void b(Context paramContext, ff paramff, fe paramfe)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("channelId", paramff.e);
    localIntent.putExtra("receiver", new b(paramContext, new Handler(), paramff, paramfe));
    localIntent.setClass(paramContext, APCloudWaitActivity.class);
    paramContext.startActivity(localIntent);
  }
  
  private void b(final Context paramContext, final ff paramff, final fe paramfe, final fd paramfd)
  {
    Math.random();
    bu.a().a("listen_cloud_message", new bu.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(br paramAnonymousbr)
      {
        if (paramAnonymousbr.a() == 3) {
          bt.a(bt.this, paramAnonymousbr, paramContext, paramff, paramfe, paramfd);
        }
      }
      
      public void a(jn paramAnonymousjn)
      {
        if (paramAnonymousjn != null)
        {
          Context localContext = paramContext;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("网络异常断开，请重新拉起支付：");
          localStringBuilder.append(paramAnonymousjn.a);
          APUICommonMethod.a(localContext, localStringBuilder.toString());
          return;
        }
        APUICommonMethod.a(paramContext, "网络异常断开, 请重新拉起支付");
      }
      
      public void b(int paramAnonymousInt, String paramAnonymousString) {}
    });
  }
  
  private void c()
  {
    final int i = (int)(Math.random() * 10000.0D);
    bu.a().a("listen_cloud_detect", new bu.a()
    {
      public void a(int paramAnonymousInt, String paramAnonymousString) {}
      
      public void a(br paramAnonymousbr)
      {
        if ((paramAnonymousbr.a() == 2) && (paramAnonymousbr.c() == i + 1)) {
          fy.a().v(true);
        }
      }
      
      public void a(jn paramAnonymousjn) {}
      
      public void b(int paramAnonymousInt, String paramAnonymousString)
      {
        fy.a().v(false);
        paramAnonymousString = br.a(i, bq.e(), bq.f(), bq.h());
        bu.a().a(paramAnonymousString);
      }
    });
  }
  
  private static void c(final Context paramContext, final ff paramff, fe paramfe)
  {
    paramff.a(paramff.e, new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        if (this.a != null) {
          this.a.a();
        }
        paramAnonymouslh = (dn)paramAnonymouslh;
        if ((paramAnonymouslh.T() == 0) && (paramAnonymouslh.a() == 1))
        {
          paramff.a(null);
          return;
        }
        int i = bq.c(paramff.e);
        paramff.a(paramContext, i);
      }
      
      public void b(lh paramAnonymouslh)
      {
        if (this.a != null) {
          this.a.a();
        }
        paramff.a(paramContext, 5, "支付结果未知", this.a);
      }
      
      public void c(lh paramAnonymouslh)
      {
        if (this.a != null) {
          this.a.a();
        }
        paramff.a(paramContext, this.a);
      }
    });
  }
  
  public void a(Context paramContext, APBaseRequest paramAPBaseRequest)
  {
    bq.a().b(paramAPBaseRequest);
    if (bq.c())
    {
      c();
      bu.a().a(bq.h(), new a());
    }
  }
  
  public void a(final Context paramContext, final ff paramff, Bundle paramBundle, final fe paramfe, final fd paramfd)
  {
    if (!fy.a().ao())
    {
      paramBundle = new APAlertDialog.a(paramContext);
      paramBundle.a("网络异常，请更换其他非微信/非QQ钱包的支付方式");
      paramBundle.a("继续支付", new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          paramAnonymousAPAlertDialog.a();
          bt.a(bt.this, paramContext, paramff, paramfe, paramfd);
        }
      });
      paramBundle.b("更换", new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if (paramfe != null) {
            paramfe.a();
          }
          paramAnonymousAPAlertDialog.a();
          if (!a.a().f)
          {
            paramAnonymousAPAlertDialog.a();
            APUICommonMethod.b();
            fv.a(2, "");
            return;
          }
          paramAnonymousAPAlertDialog.a();
        }
      });
      paramBundle.b(new gy()
      {
        public void a(APAlertDialog paramAnonymousAPAlertDialog, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
        {
          if ((paramAnonymousInt == 4) && (paramAnonymousKeyEvent.getAction() == 0))
          {
            if (paramfe != null) {
              paramfe.a();
            }
            paramAnonymousAPAlertDialog.a();
            if (!a.a().f)
            {
              APUICommonMethod.b();
              fv.a(2, "");
              return;
            }
            paramAnonymousAPAlertDialog.a();
          }
        }
      });
      try
      {
        paramBundle.c();
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    a(paramContext, paramff, paramfe, paramfd);
  }
  
  public boolean a(Context paramContext, dt paramdt, String paramString)
  {
    if ((paramdt.T() == 0) && (bq.c()) && (bq.b(paramString)))
    {
      paramContext = new StringBuilder();
      paramContext.append("progressSaveAns() is CloudSide, So return!  channelId = ");
      paramContext.append(paramString);
      APLog.w("MidasPushCloud", paramContext.toString());
      return true;
    }
    APCloudWaitActivity.a();
    return false;
  }
  
  public void b()
  {
    bu.a().a("listen_cloud_detect");
    bu.a().a("listen_cloud_message");
    bu.a().a("key_test_message");
    if (bu.a().b() <= 0) {
      bu.a().e();
    }
  }
  
  class a
    implements jo.c
  {
    private volatile long b = 0L;
    private volatile long c = 3L;
    
    public a() {}
    
    public boolean a(Runnable paramRunnable)
    {
      try
      {
        this.b += 1L;
        if (this.c > 0L)
        {
          long l1 = this.b;
          long l2 = this.c;
          if (l1 > l2) {
            return false;
          }
        }
        paramRunnable.run();
        return true;
      }
      finally {}
    }
    
    public void b(Runnable paramRunnable)
    {
      try
      {
        this.b = 0L;
        return;
      }
      finally
      {
        paramRunnable = finally;
        throw paramRunnable;
      }
    }
  }
  
  static class b
    extends ResultReceiver
  {
    private final WeakReference<Context> a;
    private final WeakReference<ff> b;
    private final WeakReference<fe> c;
    
    public b(Context paramContext, Handler paramHandler, ff paramff, fe paramfe)
    {
      super();
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(paramff);
      this.c = new WeakReference(paramfe);
    }
    
    protected void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      ff localff;
      Context localContext;
      StringBuilder localStringBuilder;
      if (paramInt == 1)
      {
        paramBundle = (fe)this.c.get();
        if (paramBundle != null) {
          paramBundle.a();
        }
        localff = (ff)this.b.get();
        localContext = (Context)this.a.get();
        if ((localff != null) && (localContext != null))
        {
          localff.a(localContext, paramBundle);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResult CODE_CANCEL weakRef null : context=");
        localStringBuilder.append(localContext);
        localStringBuilder.append(", payChannel=");
        localStringBuilder.append(localff);
        localStringBuilder.append(", callback=");
        localStringBuilder.append(paramBundle);
        APLog.e("MidasPushCloud", localStringBuilder.toString());
        return;
      }
      if (paramInt == 2)
      {
        paramBundle = (fe)this.c.get();
        localff = (ff)this.b.get();
        localContext = (Context)this.a.get();
        if ((paramBundle != null) && (localff != null) && (localContext != null))
        {
          bt.a(localContext, localff, paramBundle);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceiveResult CODE_QUERY weakRef null : context=");
        localStringBuilder.append(localContext);
        localStringBuilder.append(", payChannel=");
        localStringBuilder.append(localff);
        localStringBuilder.append(", callback=");
        localStringBuilder.append(paramBundle);
        APLog.e("MidasPushCloud", localStringBuilder.toString());
      }
    }
  }
  
  static class c
  {
    private static bt a = new bt(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.bt
 * JD-Core Version:    0.7.0.1
 */