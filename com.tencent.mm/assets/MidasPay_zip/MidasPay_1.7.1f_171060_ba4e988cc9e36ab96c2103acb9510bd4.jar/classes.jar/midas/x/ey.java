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

public class ey
  extends APHFChannel
{
  public static CountDownLatch B;
  public static long C;
  private static HashMap<String, ey> I = new HashMap();
  public String D;
  public String E;
  public String F;
  public String G;
  public String H;
  
  private ey(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = fb.a(paramString);
    if (paramString != null)
    {
      this.D = paramString.c;
      this.E = paramString.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.a.d);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.d);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.e);
      this.F = localStringBuilder.toString();
      this.G = paramString.a.b;
      this.H = paramString.d;
    }
  }
  
  private void a(int paramInt, Bundle paramBundle)
  {
    int i = ed.b().n().a.saveType;
    String str1 = ed.b().n().e.m;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operator=");
      ((StringBuilder)localObject1).append(this.G);
      ((StringBuilder)localObject1).append("&base=");
      ((StringBuilder)localObject1).append(this.H);
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
  
  private void a(Context paramContext, Intent paramIntent)
  {
    if (!c(paramContext, paramIntent.getExtras())) {
      a(250002, "话费渠道暂不可用，请使用其他支付方式。", false);
    }
  }
  
  private void a(et paramet)
  {
    if ((o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
    {
      APHFChannel.i = null;
      b(paramet);
      return;
    }
    paramet.a();
  }
  
  private void b(int paramInt, final Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() ret=");
    ((StringBuilder)localObject1).append(paramInt);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() bundle=");
    ((StringBuilder)localObject1).append(paramBundle);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    a(paramInt, paramBundle);
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
      a(new et()
      {
        public void a()
        {
          ey.this.a(ey.b(ey.this), paramBundle, false);
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
      a(new et()
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
      a(new et()
      {
        public void a()
        {
          ey.this.a(ey.a(ey.this), paramBundle, false);
        }
      });
      return;
    }
    j();
  }
  
  private void b(final et paramet)
  {
    APUICommonMethod.b(this.d);
    a.a().a(new kl()
    {
      public void a(jw paramAnonymousjw)
      {
        APUICommonMethod.c(ey.c(ey.this));
        if (((cp)paramAnonymousjw).R() != 0)
        {
          ey.d(ey.this);
          return;
        }
        paramet.a();
      }
      
      public void b(jw paramAnonymousjw)
      {
        APUICommonMethod.c(ey.e(ey.this));
        ey.d(ey.this);
      }
      
      public void c(jw paramAnonymousjw) {}
    });
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
    this.z = ed.b().n();
    ((Bundle)localObject).putBoolean("isExpress", false);
    b((Bundle)localObject);
    paramBundle = new StringBuilder();
    paramBundle.append("launchUI() pluginName=");
    paramBundle.append(this.E);
    paramBundle.append(", pluginName=");
    paramBundle.append(this.F);
    APLog.i("APHFPlugin", paramBundle.toString());
    boolean bool = APPluginContainerActivity.a(paramContext, this.E, this.F, (Bundle)localObject, new fi()
    {
      public void a(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        ey.a(ey.this, paramAnonymousInt, paramAnonymousBundle);
      }
    });
    if ((!bool) && (o.a().b()) && (o.a().c()) && (o.a().o()) && (o.a().d()))
    {
      f();
      a(new et()
      {
        public void a() {}
      });
    }
    return bool;
  }
  
  public static ey d(String paramString)
  {
    ey localey2 = (ey)I.get(paramString);
    ey localey1 = localey2;
    if (localey2 == null)
    {
      localey1 = new ey(paramString);
      if (TextUtils.isEmpty(localey1.D)) {
        return null;
      }
      I.put(paramString, localey1);
    }
    return localey1;
  }
  
  public static void i()
  {
    if (I != null) {
      I.clear();
    }
    if (B != null) {
      B.countDown();
    }
    APLog.d("APHFPlugin", "release() release finished");
  }
  
  private void j()
  {
    a(new et()
    {
      public void a() {}
    });
  }
  
  private String k()
  {
    int i = ed.b().n().a.saveType;
    String str1 = ed.b().n().b.b;
    String str2 = l();
    Object localObject = str1;
    if (APAppDataInterface.singleton().h())
    {
      if ((i != 3) && (i != 2))
      {
        if (APUICommonMethod.h()) {
          return ((el)ed.b().n().b).h();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(ed.b().n().a.extendInfo.unit);
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
    int i = ed.b().n().a.saveType;
    String str = this.d.getString(2131230828);
    switch (i)
    {
    default: 
      return "";
    case 5: 
      if (fs.a().f() == fs.a.a) {
        return ed.b().n().b.b;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(ed.b().n().e.g);
      return localStringBuilder.toString();
    case 4: 
      ed.b().n().e.g = "1";
      if (fs.a().f() == fs.a.a) {
        return ed.b().n().b.b;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(ed.b().n().e.g);
      localStringBuilder.append(((en)this.z.b).b);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(ed.b().n().e.g);
    return localStringBuilder.toString();
  }
  
  private void m()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("resource", "backOrError");
    localIntent.putExtra("toGoldCouponsPage", true);
    localIntent.setClass(this.d, APGoldCouponsDeductSelectValueActivity.class);
    this.d.startActivity(localIntent);
    ((Activity)this.d).overridePendingTransition(fm.a(this.d, "unipay_anim_in_from_right"), fm.a(this.d, "unipay_anim_out_to_left"));
  }
  
  public void b(final Context paramContext, final dl paramdl)
  {
    paramdl = new Intent();
    paramdl.putExtra("phoneNum", APHFChannel.k);
    if ((fb.j(this.D)) && (!APPermissionActivity.a(paramContext, "android.permission.SEND_SMS")))
    {
      paramdl = new ResultReceiver(new Handler(Looper.getMainLooper()))
      {
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          paramAnonymousBundle = paramAnonymousBundle.getStringArrayList("receiver_key_grant");
          if ((paramAnonymousBundle != null) && (paramAnonymousBundle.size() <= 0)) {
            APLog.w("APHFPlugin", "progressChannelSaveAns() hfpay(vnet_aigame) need send_sms permission");
          }
          ey.a(ey.this, paramContext, paramdl);
        }
      };
      APPermissionActivity.a(paramContext, new String[] { "android.permission.SEND_SMS" }, paramdl);
      return;
    }
    a(paramContext, paramdl);
  }
  
  public void b(Bundle paramBundle)
  {
    paramBundle.putInt("saveType", ed.b().n().a.saveType);
    paramBundle.putString("sessionToken", ed.b().n().e.l);
    paramBundle.putString("env", "release");
    paramBundle.putString("operatorParams", APHFChannel.y);
    paramBundle.putString("orderId", this.z.e.n);
    paramBundle.putString("phoneNumber", APHFChannel.k);
    paramBundle.putString("phoneFrom", APHFChannel.j);
    paramBundle.putString("itemName", ed.b().n().b.b);
    paramBundle.putInt("itemCount", Integer.parseInt(this.z.e.g));
    paramBundle.putString("itemPrice", ed.b().n().b.a());
    paramBundle.putString("itemShow", k());
  }
  
  public void e(String paramString)
  {
    APLog.i("APHFPlugin", "preQuery()");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    APLog.i("APHFPlugin", "preQuery() preQueryParams not empty");
    Activity localActivity = (Activity)a.a().c.get();
    Object localObject1 = fh.a(localActivity, this.E, "com.tencent.midas.control.IAPInitCallBack", new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        if (paramAnonymousMethod.getName().equals("result"))
        {
          int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
          paramAnonymousMethod = ((Bundle)paramAnonymousArrayOfObject[3]).getString("preQueryResult");
          APDataReportManager.getInstance().insertData("sdk.hf.prequery.result", ey.this.A, ed.b().n().e.l, "", paramAnonymousMethod);
          if ((i == 0) && (!TextUtils.isEmpty(paramAnonymousMethod)))
          {
            paramAnonymousObject = fb.a(ey.this.D);
            if (paramAnonymousObject != null) {
              try
              {
                paramAnonymousObject.h = paramAnonymousMethod;
              }
              finally {}
            }
          }
          if (ey.B != null) {
            ey.B.countDown();
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
    ((StringBuilder)localObject3).append(this.H);
    ((StringBuilder)localObject3).append(".APOperatorHelper");
    localObject3 = ((StringBuilder)localObject3).toString();
    try
    {
      APLog.i("APHFPlugin", "preQuery() invokeMethod preQuery()");
      fh.a(localActivity, this.E, (String)localObject3, "preQuery", new Object[] { localObject2, Integer.valueOf(i), paramString, localObject1 });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ey
 * JD-Core Version:    0.7.0.1
 */