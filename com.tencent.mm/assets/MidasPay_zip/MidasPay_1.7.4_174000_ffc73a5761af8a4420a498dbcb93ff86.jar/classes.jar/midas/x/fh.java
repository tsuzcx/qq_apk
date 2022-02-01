package midas.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APBaseRequest.APExtendInfo;
import com.pay.data.report.APDataReportManager;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.permission.APPermissionActivity;
import com.pay.tool.APAppDataInterface;
import com.pay.ui.channel.APGoldCouponsDeductSelectValueActivity;
import com.pay.ui.channel.APPluginContainerActivity;
import com.pay.ui.common.APUICommonMethod;
import com.tencent.midas.comm.APLog;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class fh
  extends APHFChannel
{
  public static CountDownLatch G;
  public static long H;
  private static HashMap<String, fh> N = new HashMap();
  public String I;
  public String J;
  public String K;
  public String L;
  public String M;
  
  private fh(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = fk.a(paramString);
    if (paramString != null)
    {
      this.I = paramString.c;
      this.J = paramString.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.a.d);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.d);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.e);
      this.K = localStringBuilder.toString();
      this.L = paramString.a.b;
      this.M = paramString.d;
    }
  }
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if (!c(paramContext, paramIntent.getExtras())) {
      a(250002, "话费渠道暂不可用，请使用其他支付方式。", false);
    }
  }
  
  private void a(fc paramfc)
  {
    if ((o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
    {
      APHFChannel.j = null;
      b(paramfc);
      return;
    }
    paramfc.a();
  }
  
  private void b(int paramInt, Bundle paramBundle)
  {
    int i = em.b().n().a.saveType;
    String str1 = em.b().n().e.m;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operator=");
      ((StringBuilder)localObject1).append(this.L);
      ((StringBuilder)localObject1).append("&base=");
      ((StringBuilder)localObject1).append(this.M);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label82:
      Object localObject2;
      int j;
      String str2;
      StringBuffer localStringBuffer;
      break label82;
    }
    localObject1 = "operator=null&base=null";
    if (paramBundle == null)
    {
      paramBundle = APDataReportManager.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("retbundle=null&code=-100&");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramBundle.insertData("sdk.hf.operatorbase.ret.other", i, str1, null, ((StringBuilder)localObject2).toString());
      return;
    }
    j = paramBundle.getInt("resultCode");
    localObject2 = paramBundle.getString("itemIndex");
    str2 = paramBundle.getString("message");
    switch (paramInt)
    {
    default: 
      paramBundle = "sdk.hf.operatorbase.ret.other";
      break;
    case 0: 
      paramBundle = "sdk.hf.operatorbase.ret.success";
      break;
    case -1: 
      paramBundle = "sdk.hf.operatorbase.ret.initfail";
      break;
    case -2: 
      paramBundle = "sdk.hf.operatorbase.ret.viewfail";
      break;
    case -3: 
      paramBundle = "sdk.hf.operatorbase.ret.failed";
      break;
    case -4: 
      paramBundle = "sdk.hf.operatorbase.ret.cancel";
      break;
    case -5: 
      paramBundle = "sdk.hf.operatorbase.ret.change";
      break;
    case -6: 
      paramBundle = "sdk.hf.operatorbase.ret.paramerror";
      break;
    case -7: 
      paramBundle = "sdk.hf.operatorbase.ret.itemindexerror";
      break;
    case -8: 
      paramBundle = "sdk.hf.operatorbase.ret.keyback";
    }
    localStringBuffer = new StringBuffer();
    localStringBuffer.append("code=");
    localStringBuffer.append(paramInt);
    localStringBuffer.append("&");
    localStringBuffer.append("errorCode=");
    localStringBuffer.append(j);
    localStringBuffer.append("&");
    localStringBuffer.append("errorMsg=");
    localStringBuffer.append(str2);
    localStringBuffer.append("&");
    localStringBuffer.append("itemIndex=");
    localStringBuffer.append((String)localObject2);
    localStringBuffer.append("&");
    localStringBuffer.append((String)localObject1);
    APDataReportManager.getInstance().insertData(paramBundle, i, str1, null, localStringBuffer.toString());
  }
  
  private void b(final fc paramfc)
  {
    APUICommonMethod.b(this.d);
    a.a().a(new lw()
    {
      public void a(lh paramAnonymouslh)
      {
        APUICommonMethod.c(fh.this.d);
        if (((cv)paramAnonymouslh).T() != 0)
        {
          fh.a(fh.this);
          return;
        }
        paramfc.a();
      }
      
      public void b(lh paramAnonymouslh)
      {
        APUICommonMethod.c(fh.this.d);
        fh.a(fh.this);
      }
      
      public void c(lh paramAnonymouslh) {}
    });
  }
  
  public static fh c(String paramString)
  {
    if (!fk.c(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("progressChannelSaveAns subId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" is not isSupportedChannelId");
      APLog.w("APHFChannel", ((StringBuilder)localObject).toString());
      return null;
    }
    fh localfh = (fh)N.get(paramString);
    Object localObject = localfh;
    if (localfh == null)
    {
      localObject = new fh(paramString);
      if (TextUtils.isEmpty(((fh)localObject).I)) {
        return null;
      }
      N.put(paramString, localObject);
    }
    return localObject;
  }
  
  private void c(int paramInt, final Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() ret=");
    ((StringBuilder)localObject1).append(paramInt);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() bundle=");
    ((StringBuilder)localObject1).append(paramBundle);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    b(paramInt, paramBundle);
    localObject1 = paramBundle;
    if (paramBundle == null) {
      localObject1 = new Bundle();
    }
    String str = ((Bundle)localObject1).getString("innerCode");
    localObject1 = ((Bundle)localObject1).getString("message");
    paramBundle = new StringBuilder();
    paramBundle.append("onResult() message=");
    paramBundle.append((String)localObject1);
    APLog.i("APHFPlugin", paramBundle.toString());
    paramBundle = (Bundle)localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      paramBundle = "获取付费信息失败，请稍候重试!";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("107-");
    ((StringBuilder)localObject1).append(String.valueOf(paramInt));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (!TextUtils.isEmpty(str))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append("(");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(")");
    paramBundle = ((StringBuilder)localObject2).toString();
    switch (paramInt)
    {
    default: 
      a(new fc()
      {
        public void a()
        {
          fh.this.a(fh.this.d, paramBundle, false);
        }
      });
      return;
    case 0: 
      a(this.d);
      return;
    case -2: 
      a(this.d, paramBundle, false);
      return;
    case -3: 
      a(this.d);
      return;
    case -5: 
      a(new fc()
      {
        public void a()
        {
          APLog.e("APHFPlugin", "RET_CHANGE is error way");
        }
      });
      return;
    case -7: 
    case -6: 
    case -1: 
      a(new fc()
      {
        public void a()
        {
          fh.this.a(fh.this.d, paramBundle, false);
        }
      });
      return;
    }
    j();
  }
  
  private boolean c(Context paramContext, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchUI() context=");
    ((StringBuilder)localObject).append(paramContext);
    APLog.i("APHFPlugin", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchUI() bundle=");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.i("APHFPlugin", ((StringBuilder)localObject).toString());
    this.d = paramContext;
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    this.z = em.b().n();
    ((Bundle)localObject).putBoolean("isExpress", false);
    b((Bundle)localObject);
    paramBundle = new StringBuilder();
    paramBundle.append("launchUI() pluginName=");
    paramBundle.append(this.J);
    paramBundle.append(", pluginName=");
    paramBundle.append(this.K);
    APLog.i("APHFPlugin", paramBundle.toString());
    boolean bool = APPluginContainerActivity.a(paramContext, this.J, this.K, (Bundle)localObject, new fr()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        fh.a(fh.this, paramAnonymousInt, paramAnonymousBundle);
      }
    });
    if ((!bool) && (o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
    {
      f();
      a(new fc()
      {
        public void a() {}
      });
    }
    return bool;
  }
  
  public static void i()
  {
    if (N != null) {
      N.clear();
    }
    if (G != null) {
      G.countDown();
    }
    APLog.d("APHFPlugin", "release() release finished");
  }
  
  private void j()
  {
    a(new fc()
    {
      public void a() {}
    });
  }
  
  private String k()
  {
    int i = em.b().n().a.saveType;
    String str1 = em.b().n().b.b;
    String str2 = l();
    Object localObject = str1;
    if (APAppDataInterface.singleton().h())
    {
      if ((i != 3) && (i != 2))
      {
        if (APUICommonMethod.h()) {
          return ((eu)em.b().n().b).h();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(em.b().n().a.extendInfo.unit);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  private String l()
  {
    int i = em.b().n().a.saveType;
    String str = this.d.getString(2131230829);
    switch (i)
    {
    default: 
      return "";
    case 5: 
      if (gc.a().f() == gc.a.a) {
        return em.b().n().b.b;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(em.b().n().e.g);
      return localStringBuilder.toString();
    case 4: 
      em.b().n().e.g = "1";
      if (gc.a().f() == gc.a.a) {
        return em.b().n().b.b;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(em.b().n().e.g);
      localStringBuilder.append(((ew)this.z.b).b);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(em.b().n().e.g);
    return localStringBuilder.toString();
  }
  
  private void m()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("resource", "backOrError");
    localIntent.putExtra("toGoldCouponsPage", true);
    localIntent.setClass(this.d, APGoldCouponsDeductSelectValueActivity.class);
    this.d.startActivity(localIntent);
    ((Activity)this.d).overridePendingTransition(fv.a(this.d, "unipay_anim_in_from_right"), fv.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public void b(final Context paramContext, final dt paramdt)
  {
    paramdt = new Intent();
    paramdt.putExtra("phoneNum", APHFChannel.l);
    if (!APPermissionActivity.a(paramContext, "android.permission.SEND_SMS"))
    {
      paramdt = new ResultReceiver(new Handler(Looper.getMainLooper()))
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          paramAnonymousBundle = paramAnonymousBundle.getStringArrayList("receiver_key_grant");
          if ((paramAnonymousBundle != null) && (paramAnonymousBundle.size() <= 0)) {
            APLog.w("APHFPlugin", "progressChannelSaveAns() hfpay(vnet_aigame) need send_sms permission");
          }
          fh.a(fh.this, paramContext, paramdt);
        }
      };
      APPermissionActivity.a(paramContext, new String[] { "android.permission.SEND_SMS" }, paramdt);
      return;
    }
    a(paramContext, paramdt);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putInt("saveType", em.b().n().a.saveType);
    paramBundle.putString("sessionToken", em.b().n().e.l);
    paramBundle.putString("env", "release");
    paramBundle.putString("operatorParams", APHFChannel.y);
    paramBundle.putString("orderId", this.z.e.n);
    paramBundle.putString("phoneNumber", APHFChannel.l);
    paramBundle.putString("phoneFrom", APHFChannel.k);
    paramBundle.putString("itemName", em.b().n().b.b);
    paramBundle.putInt("itemCount", Integer.parseInt(this.z.e.g));
    paramBundle.putString("itemPrice", em.b().n().b.a());
    paramBundle.putString("itemShow", k());
  }
  
  public void d(String paramString)
  {
    APLog.i("APHFPlugin", "preQuery()");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    APLog.i("APHFPlugin", "preQuery() preQueryParams not empty");
    Activity localActivity = (Activity)a.a().c.get();
    Object localObject1 = fq.a(localActivity, this.J, "com.tencent.midas.control.IAPInitCallBack", new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        if (paramAnonymousMethod.getName().equals("result"))
        {
          int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
          paramAnonymousMethod = ((Bundle)paramAnonymousArrayOfObject[3]).getString("preQueryResult");
          APDataReportManager.getInstance().insertData("sdk.hf.prequery.result", fh.this.A, em.b().n().e.l, "", paramAnonymousMethod);
          if ((i == 0) && (!TextUtils.isEmpty(paramAnonymousMethod)))
          {
            paramAnonymousObject = fk.a(fh.this.I);
            if (paramAnonymousObject != null) {
              try
              {
                paramAnonymousObject.h = paramAnonymousMethod;
              }
              finally {}
            }
          }
          if (fh.G != null) {
            fh.G.countDown();
          }
        }
        return null;
      }
    });
    if (localObject1 == null)
    {
      APLog.e("APHFPlugin", "preQuery callbackObj is null");
      return;
    }
    Object localObject2 = a.a().c.get();
    int i = this.A;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("com.tencent.midas.operator.");
    ((StringBuilder)localObject3).append(this.M);
    ((StringBuilder)localObject3).append(".APOperatorHelper");
    localObject3 = ((StringBuilder)localObject3).toString();
    try
    {
      APLog.i("APHFPlugin", "preQuery() invokeMethod preQuery()");
      fq.a(localActivity, this.J, (String)localObject3, "preQuery", new Object[] { localObject2, Integer.valueOf(i), paramString, localObject1 });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.fh
 * JD-Core Version:    0.7.0.1
 */