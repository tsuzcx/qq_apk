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

public class k5
  extends APHFChannel
{
  public static CountDownLatch P;
  public static long Q;
  public static HashMap<String, k5> R = new HashMap();
  public String K;
  public String L;
  public String M;
  public String N;
  public String O;
  
  public k5(String paramString)
  {
    if (paramString == null) {
      return;
    }
    paramString = n5.a(paramString);
    if (paramString != null)
    {
      this.K = paramString.b;
      this.L = paramString.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.a.c);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.c);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString.d);
      this.M = localStringBuilder.toString();
      this.N = paramString.a.a;
      this.O = paramString.c;
    }
  }
  
  public static k5 e(String paramString)
  {
    if (!n5.d(paramString))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("progressChannelSaveAns subId=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" is not isSupportedChannelId");
      APLog.w("APHFChannel", ((StringBuilder)localObject).toString());
      return null;
    }
    k5 localk5 = (k5)R.get(paramString);
    Object localObject = localk5;
    if (localk5 == null)
    {
      localObject = new k5(paramString);
      if (TextUtils.isEmpty(((k5)localObject).K)) {
        return null;
      }
      R.put(paramString, localObject);
    }
    return localObject;
  }
  
  public static void o()
  {
    Object localObject = R;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    localObject = P;
    if (localObject != null) {
      ((CountDownLatch)localObject).countDown();
    }
    APLog.d("APHFPlugin", "release() release finished");
  }
  
  public final void a(Context paramContext, Intent paramIntent)
  {
    if (!c(paramContext, paramIntent.getExtras())) {
      a(250002, "话费渠道暂不可用，请使用其他支付方式。", false);
    }
  }
  
  public void a(final Context paramContext, final w3 paramw3)
  {
    paramw3 = new Intent();
    paramw3.putExtra("phoneNum", APHFChannel.s);
    if (!APPermissionActivity.c(paramContext, "android.permission.SEND_SMS"))
    {
      paramw3 = new a(new Handler(Looper.getMainLooper()), paramContext, paramw3);
      APPermissionActivity.b(paramContext, new String[] { "android.permission.SEND_SMS" }, paramw3);
      return;
    }
    a(paramContext, paramw3);
  }
  
  public final void a(final f5 paramf5)
  {
    APUICommonMethod.c(this.c);
    a.r().a(new i(paramf5));
  }
  
  public final void b(int paramInt, final Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() ret=");
    ((StringBuilder)localObject1).append(paramInt);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onResult() bundle=");
    ((StringBuilder)localObject1).append(paramBundle);
    APLog.i("APHFPlugin", ((StringBuilder)localObject1).toString());
    c(paramInt, paramBundle);
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
      b(new g(paramBundle));
      return;
    case 0: 
      a(this.c);
      return;
    case -2: 
      a(this.c, paramBundle, false);
      return;
    case -3: 
      a(this.c);
      return;
    case -5: 
      b(new e());
      return;
    case -7: 
    case -6: 
    case -1: 
      b(new f(paramBundle));
      return;
    }
    k();
  }
  
  public final void b(f5 paramf5)
  {
    if ((p.o().h()) && (p.o().f()) && (p.o().j()) && (p.o().i()))
    {
      APHFChannel.q = null;
      a(paramf5);
      return;
    }
    paramf5.a();
  }
  
  public final void c(int paramInt, Bundle paramBundle)
  {
    int i = p4.p().e().b.saveType;
    String str1 = p4.p().e().f.l;
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operator=");
      ((StringBuilder)localObject1).append(this.N);
      ((StringBuilder)localObject1).append("&base=");
      ((StringBuilder)localObject1).append(this.O);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label84:
      Object localObject2;
      int j;
      String str2;
      StringBuffer localStringBuffer;
      break label84;
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
  
  public void c(Bundle paramBundle)
  {
    paramBundle.putInt("saveType", p4.p().e().b.saveType);
    paramBundle.putString("sessionToken", p4.p().e().f.k);
    paramBundle.putString("env", "release");
    paramBundle.putString("operatorParams", APHFChannel.E);
    paramBundle.putString("orderId", this.o.f.m);
    paramBundle.putString("phoneNumber", APHFChannel.s);
    paramBundle.putString("phoneFrom", APHFChannel.r);
    paramBundle.putString("itemName", p4.p().e().c.b);
    paramBundle.putInt("itemCount", Integer.parseInt(this.o.f.f));
    paramBundle.putString("itemPrice", p4.p().e().c.a());
    paramBundle.putString("itemShow", l());
  }
  
  public final boolean c(Context paramContext, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchUI() context=");
    ((StringBuilder)localObject).append(paramContext);
    APLog.i("APHFPlugin", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("launchUI() bundle=");
    ((StringBuilder)localObject).append(paramBundle);
    APLog.i("APHFPlugin", ((StringBuilder)localObject).toString());
    this.c = paramContext;
    localObject = paramBundle;
    if (paramBundle == null) {
      localObject = new Bundle();
    }
    this.o = p4.p().e();
    ((Bundle)localObject).putBoolean("isExpress", false);
    c((Bundle)localObject);
    paramBundle = new StringBuilder();
    paramBundle.append("launchUI() pluginName=");
    paramBundle.append(this.L);
    paramBundle.append(", pluginName=");
    paramBundle.append(this.M);
    APLog.i("APHFPlugin", paramBundle.toString());
    boolean bool = APPluginContainerActivity.a(paramContext, this.L, this.M, (Bundle)localObject, new c());
    if ((!bool) && (p.o().h()) && (p.o().f()) && (p.o().j()) && (p.o().i()))
    {
      APHFChannel.j();
      b(new d());
    }
    return bool;
  }
  
  public void d(String paramString)
  {
    APLog.i("APHFPlugin", "preQuery()");
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    APLog.i("APHFPlugin", "preQuery() preQueryParams not empty");
    Activity localActivity = (Activity)a.r().c.get();
    Object localObject1 = u5.a(localActivity, this.L, "com.tencent.midas.control.IAPInitCallBack", new b());
    if (localObject1 == null)
    {
      APLog.e("APHFPlugin", "preQuery callbackObj is null");
      return;
    }
    Object localObject2 = a.r().c.get();
    int i = this.p;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("com.tencent.midas.operator.");
    ((StringBuilder)localObject3).append(this.O);
    ((StringBuilder)localObject3).append(".APOperatorHelper");
    localObject3 = ((StringBuilder)localObject3).toString();
    try
    {
      APLog.i("APHFPlugin", "preQuery() invokeMethod preQuery()");
      u5.a(localActivity, this.L, (String)localObject3, "preQuery", new Object[] { localObject2, Integer.valueOf(i), paramString, localObject1 });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public final void k()
  {
    b(new h());
  }
  
  public final String l()
  {
    int i = p4.p().e().b.saveType;
    String str1 = p4.p().e().c.b;
    String str2 = m();
    Object localObject = str1;
    if (APAppDataInterface.singleton().n())
    {
      if ((i != 3) && (i != 2))
      {
        if (APUICommonMethod.e()) {
          return ((x4)p4.p().e().c).h();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append(str2);
        ((StringBuilder)localObject).append(p4.p().e().b.extendInfo.unit);
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(str2);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public final String m()
  {
    int i = p4.p().e().b.saveType;
    String str = this.c.getString(2131230829);
    if ((i != 0) && (i != 1) && (i != 2) && (i != 3))
    {
      if (i != 4)
      {
        if (i != 5) {
          return "";
        }
        if (g6.k().e() == g6.a.a) {
          return p4.p().e().c.b;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(p4.p().e().f.f);
        return localStringBuilder.toString();
      }
      p4.p().e().f.f = "1";
      if (g6.k().e() == g6.a.a) {
        return p4.p().e().c.b;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(" ");
      localStringBuilder.append(p4.p().e().f.f);
      localStringBuilder.append(((z4)this.o.c).b);
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(p4.p().e().f.f);
    return localStringBuilder.toString();
  }
  
  public final void n()
  {
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("resource", "backOrError");
    ((Intent)localObject).putExtra("toGoldCouponsPage", true);
    ((Intent)localObject).setClass(this.c, APGoldCouponsDeductSelectValueActivity.class);
    this.c.startActivity((Intent)localObject);
    localObject = this.c;
    ((Activity)localObject).overridePendingTransition(z5.a((Context)localObject, "unipay_anim_in_from_right"), z5.a(this.c, "unipay_anim_out_to_left"));
  }
  
  public class a
    extends ResultReceiver
  {
    public a(Handler paramHandler, Context paramContext, Intent paramIntent)
    {
      super();
    }
    
    public void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = paramBundle.getStringArrayList("receiver_key_grant");
      if ((paramBundle != null) && (paramBundle.size() <= 0)) {
        APLog.w("APHFPlugin", "progressChannelSaveAns() hfpay(vnet_aigame) need send_sms permission");
      }
      k5.a(k5.this, paramContext, paramw3);
    }
  }
  
  public class b
    implements InvocationHandler
  {
    public b() {}
    
    public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
      throws Throwable
    {
      if (paramMethod.getName().equals("result"))
      {
        int i = ((Integer)paramArrayOfObject[0]).intValue();
        paramMethod = ((Bundle)paramArrayOfObject[3]).getString("preQueryResult");
        APDataReportManager.getInstance().insertData("sdk.hf.prequery.result", k5.this.p, p4.p().e().f.k, "", paramMethod);
        if ((i == 0) && (!TextUtils.isEmpty(paramMethod)))
        {
          paramObject = n5.a(k5.this.K);
          if (paramObject != null) {
            try
            {
              paramObject.g = paramMethod;
            }
            finally {}
          }
        }
        paramObject = k5.P;
        if (paramObject != null) {
          paramObject.countDown();
        }
      }
      return null;
    }
  }
  
  public class c
    implements v5
  {
    public c() {}
    
    public void a(int paramInt, Bundle paramBundle)
    {
      k5.a(k5.this, paramInt, paramBundle);
    }
  }
  
  public class d
    implements f5
  {
    public d() {}
    
    public void a() {}
  }
  
  public class e
    implements f5
  {
    public e() {}
    
    public void a()
    {
      APLog.e("APHFPlugin", "RET_CHANGE is error way");
    }
  }
  
  public class f
    implements f5
  {
    public f(String paramString) {}
    
    public void a()
    {
      k5 localk5 = k5.this;
      localk5.a(localk5.c, paramBundle, false);
    }
  }
  
  public class g
    implements f5
  {
    public g(String paramString) {}
    
    public void a()
    {
      k5 localk5 = k5.this;
      localk5.a(localk5.c, paramBundle, false);
    }
  }
  
  public class h
    implements f5
  {
    public h() {}
    
    public void a() {}
  }
  
  public class i
    implements fc
  {
    public i(f5 paramf5) {}
    
    public void a(ob paramob)
    {
      APUICommonMethod.a(k5.this.c);
      if (((w2)paramob).d() != 0)
      {
        k5.a(k5.this);
        return;
      }
      paramf5.a();
    }
    
    public void b(ob paramob)
    {
      APUICommonMethod.a(k5.this.c);
      k5.a(k5.this);
    }
    
    public void c(ob paramob) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.k5
 * JD-Core Version:    0.7.0.1
 */