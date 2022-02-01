package com.pay.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.pay.api.ability.MidasBaseAbility;
import com.pay.api.request.APBaseRequest;
import com.pay.api.request.APNetRequest;
import com.pay.paychannel.hfpay.APHFChannel;
import com.pay.tool.APAppDataInterface;
import com.pay.tool.APTools;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.pay.APMidasDistribute;
import java.util.List;
import midas.x.a;
import midas.x.bs;
import midas.x.bt;
import midas.x.bv;
import midas.x.by;
import midas.x.bz;
import midas.x.fy;
import midas.x.fz;
import midas.x.gf;
import midas.x.k;
import midas.x.n;
import midas.x.o;
import org.json.JSONObject;

public class APAndroidPayAPI
{
  public static final String PAY_CHANNEL_BANK = "bank";
  public static final String PAY_CHANNEL_QQWALLET = "qqwallet";
  public static final String PAY_CHANNEL_WECHAT = "wechat";
  private static boolean a = true;
  public static String env = "release";
  public static int launchPayTimeCount = 1;
  
  private static void a(Context paramContext)
  {
    a.a().d = paramContext;
    by.a().c();
  }
  
  public static int consumeAsync(List<APPurchase> paramList, OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener)
  {
    APLog.i("APAndroidPayAPI", "consumeAsync enter");
    a.a().a(paramList, paramOnAPConsumeFinishedListener);
    return 0;
  }
  
  public static String getH5JS(Activity paramActivity)
  {
    paramActivity = paramActivity.getApplicationContext();
    return k.a(paramActivity).b(paramActivity);
  }
  
  public static String getH5JS(Context paramContext)
  {
    return k.a(paramContext.getApplicationContext()).b(paramContext.getApplicationContext());
  }
  
  public static String getH5JSWithVersion(Activity paramActivity, String paramString)
  {
    APAppDataInterface.singleton().d(paramString);
    paramActivity = paramActivity.getApplicationContext();
    return k.a(paramActivity).b(paramActivity);
  }
  
  public static String getMidasSDKVersion()
  {
    return "1.7.4";
  }
  
  public static void globalInit(Activity paramActivity, APBaseRequest paramAPBaseRequest)
  {
    globalInit(paramActivity, paramAPBaseRequest, null);
  }
  
  public static void globalInit(Activity paramActivity, APBaseRequest paramAPBaseRequest, ResultReceiver paramResultReceiver)
  {
    if (paramAPBaseRequest != null) {
      APLog.i("globalInit", paramAPBaseRequest.toString());
    }
    launchPayTimeCount = 1;
    new fz().a(paramActivity.getApplicationContext(), "TencentUnipay", "intCt", "0");
    a.a(env);
    a.a(a);
    System.currentTimeMillis();
    a.a().a(paramActivity, paramAPBaseRequest, paramResultReceiver);
    if (paramAPBaseRequest != null) {
      a(paramActivity.getApplicationContext());
    }
  }
  
  public static int hfCouponsRollBack(String paramString)
  {
    APLog.i("话费券回滚2", "话费券回滚hfCouponsRollBack");
    return a.a().d(paramString);
  }
  
  public static void launchAbility(Context paramContext, MidasBaseAbility paramMidasBaseAbility, ResultReceiver paramResultReceiver)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("launchAbility enter : ");
    localStringBuilder.append(paramMidasBaseAbility.toString());
    APLog.i("APAndroidPayAPI", localStringBuilder.toString());
    a.a().a(paramContext, paramMidasBaseAbility, paramResultReceiver);
  }
  
  public static void launchInfo(Activity paramActivity, String paramString, APBaseRequest paramAPBaseRequest, IAPNetCallBack paramIAPNetCallBack)
  {
    APLog.e("launchNet request=", paramAPBaseRequest.toString());
    if (env.equals("debug"))
    {
      env = "custom";
      a.b("dev");
    }
    a.a(env);
    a(paramActivity.getApplicationContext());
    a.a(a);
    a.a().a(paramActivity, paramString, paramAPBaseRequest, paramIAPNetCallBack);
  }
  
  public static void launchNet(Activity paramActivity, APNetRequest paramAPNetRequest, IAPNetCallBack paramIAPNetCallBack)
  {
    APLog.e("launchNet request=", paramAPNetRequest.toString());
    if (env.equals("debug"))
    {
      env = "custom";
      a.b("dev");
    }
    a.a(env);
    a(paramActivity.getApplicationContext());
    a.a(a);
    a.a().a(paramActivity, paramAPNetRequest, paramIAPNetCallBack);
  }
  
  public static void launchPay(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (APTools.j())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("launchPay enter fast:");
      paramActivity.append(paramIAPPayCallBack);
      APLog.w("APAndrodiPayAPI", paramActivity.toString());
      paramActivity = new APPayResponse();
      paramActivity.resultCode = -1;
      paramActivity.payChannel = -1;
      paramActivity.payState = 2;
      paramActivity.provideState = -1;
      paramActivity.resultMsg = "fast click";
      paramIAPPayCallBack.MidasPayCallBack(paramActivity);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("env:");
    localStringBuilder.append(env);
    APLog.d("APAndroidPayAPI", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("logEnable:");
    localStringBuilder.append(a);
    APLog.d("APAndroidPayAPI", localStringBuilder.toString());
    if (env.equals("debug"))
    {
      env = "custom";
      a.b("dev");
    }
    gf.a();
    APHFChannel.m = APTools.h(paramActivity);
    APHFChannel.l = APHFChannel.m;
    APHFChannel.k = "1";
    APHFChannel.n = APTools.g(paramActivity);
    o.a().i();
    o.a().a(false);
    o.a().f();
    n.b();
    a.a(env);
    a.a(a);
    a.a().a(paramActivity, paramAPBaseRequest, paramIAPPayCallBack);
  }
  
  public static void launchSign(Activity paramActivity, JSONObject paramJSONObject)
  {
    a.a().a(paramActivity, paramJSONObject);
  }
  
  public static void launchWXMiniProgram(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    APLog.d("APAndroidPayAPI", "launchWXMiniProgram enter");
    a.a().a(paramContext, paramBundle, paramResultReceiver);
  }
  
  public static void launchWXMiniProgram(Context paramContext, final String paramString, final ResultReceiver paramResultReceiver)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("launchH5Feature enter: context=");
    ((StringBuilder)localObject1).append(paramContext);
    ((StringBuilder)localObject1).append(", jsonParams=");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", resultReceiver=");
    ((StringBuilder)localObject1).append(paramResultReceiver);
    APLog.d("APAndroidPayAPI", ((StringBuilder)localObject1).toString());
    Object localObject4 = null;
    Object localObject2;
    try
    {
      localObject1 = new JSONObject(paramString);
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
      localObject2 = null;
    }
    if (localObject2 == null)
    {
      paramContext = new Bundle();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("jsonParams is not json string : ");
      ((StringBuilder)localObject2).append(paramString);
      paramContext.putString("resultMsg", ((StringBuilder)localObject2).toString());
      paramResultReceiver.send(-1, paramContext);
      return;
    }
    Object localObject3;
    try
    {
      localObject2 = new JSONObject(paramString);
    }
    catch (Exception localException2)
    {
      localException2.printStackTrace();
      localObject3 = localObject4;
    }
    launchWXMiniProgram(paramContext, APTools.a(localObject3), new ResultReceiver(new Handler())
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        paramAnonymousBundle = APTools.a(paramAnonymousBundle).toString();
        paramAnonymousBundle = APMidasDistribute.buildCallBackInfo(paramString, paramAnonymousBundle);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", "h5callback");
        localBundle.putString("callbackinfo", paramAnonymousBundle);
        paramResultReceiver.send(0, localBundle);
      }
    });
  }
  
  public static void launchWXMiniProgram_OnResponse(int paramInt, Bundle paramBundle)
  {
    APLog.d("APAndroidPayAPI", "launchWXMiniProgram_OnResponse() enter");
    a.a().a(paramInt, paramBundle);
  }
  
  public static void launchWeChatPay(Activity paramActivity, JSONObject paramJSONObject, IAPPayCallBack paramIAPPayCallBack)
  {
    a.a().a(paramActivity, paramJSONObject, paramIAPPayCallBack);
  }
  
  public static void launchWeb(Activity paramActivity, APBaseRequest paramAPBaseRequest, IAPPayCallBack paramIAPPayCallBack)
  {
    if (APTools.j())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("launchWeb enter fast:");
      paramActivity.append(paramIAPPayCallBack);
      APLog.w("APAndrodiPayAPI", paramActivity.toString());
      paramActivity = new APPayResponse();
      paramActivity.resultCode = -1;
      paramActivity.payChannel = -1;
      paramActivity.payState = 2;
      paramActivity.provideState = -1;
      paramActivity.resultMsg = "fast click";
      paramIAPPayCallBack.MidasPayCallBack(paramActivity);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("env:");
    localStringBuilder.append(env);
    APLog.d("APAndroidPayAPI", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("logEnable:");
    localStringBuilder.append(a);
    APLog.d("APAndroidPayAPI", localStringBuilder.toString());
    if (env.equals("debug"))
    {
      env = "custom";
      a.b("dev");
    }
    a.a(env);
    a(paramActivity.getApplicationContext());
    a.a(a);
    a.a().b(paramActivity, paramAPBaseRequest, paramIAPPayCallBack);
  }
  
  public static int queryInventoryAsync(Boolean paramBoolean, List<?> paramList, APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    if (env.equals("debug"))
    {
      env = "custom";
      a.b("dev");
    }
    a.a(env);
    a.a(a);
    a.a().a(paramBoolean.booleanValue(), paramList, paramAPQueryInventoryFinishedListener);
    a(a.a().d);
    return 0;
  }
  
  public static void queryUnfinishedReceipt() {}
  
  public static void release()
  {
    APLog.w("APAndroidPayAPI", "release()...............");
    bz.a();
    bv.a().b();
    bt.a().b();
    bs.a().b();
  }
  
  public static void setCallPackageName(Context paramContext, String paramString)
  {
    paramContext = paramContext.getApplicationContext().getPackageName();
    if ("com.tencent.unipay".equals(paramContext)) {
      fy.a().A(paramContext);
    }
  }
  
  public static void setCallPackageSign(Context paramContext, String paramString)
  {
    if ("com.tencent.unipay".equals(paramContext.getApplicationContext().getPackageName())) {
      fy.a().B(paramString);
    }
  }
  
  public static void setEnv(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setEnv:");
    localStringBuilder.append(paramString);
    APLog.i("APAndroidPayAPI", localStringBuilder.toString());
    env = paramString;
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    a = paramBoolean;
  }
  
  public static void setLongConnection(Context paramContext, boolean paramBoolean)
  {
    a.a().a(paramContext, paramBoolean);
  }
  
  public static void setMidasPluginVersion(String paramString)
  {
    a.c(paramString);
  }
  
  public static void setScreenType(Integer paramInteger)
  {
    a.a(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     com.pay.api.APAndroidPayAPI
 * JD-Core Version:    0.7.0.1
 */