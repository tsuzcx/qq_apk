package com.tencent.midas.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APMidasCommMethod;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.ability.MidasBaseAbility;
import com.tencent.midas.api.request.APIabResult;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.api.request.APQueryInventoryFinishedListener;
import com.tencent.midas.api.request.OnAPConsumeFinishedListener;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginStatic;
import com.tencent.midas.plugin.APPluginUtils;
import dalvik.system.DexClassLoader;
import java.util.ArrayList;
import java.util.List;

public class APMidasPayAPI
{
  public static final String ACCOUNT_TYPE_COMMON = "common";
  public static final String ACCOUNT_TYPE_SECURITY = "secrety";
  public static final String ENV_DEV = "dev";
  public static final String ENV_RELEASE = "release";
  public static final String ENV_TEST = "test";
  public static final String ENV_TESTING = "testing";
  public static final int LANDSCAPE = 0;
  public static final String PAY_CHANNEL_BANK = "bank";
  public static final String PAY_CHANNEL_QQWALLET = "qqwallet";
  public static final String PAY_CHANNEL_WECHAT = "wechat";
  public static final int PORTRAINT = 1;
  private static final String TAG = "APMidasPayAPI";
  public static final String WX_COUPONS = "wechatAddCardToWXCardPackage";
  private static String dataPath = "";
  public static String env = "release";
  public static Context fromContext = null;
  private static boolean logEnable = true;
  private static int screenType = -1;
  
  public static void H5Release()
  {
    if (APMidasPayHelper.x5Webview != null) {
      APMidasPayHelper.x5Webview = null;
    }
    if (APMidasPayHelper.webview != null) {
      APMidasPayHelper.webview = null;
    }
    if (APMidasPayHelper.sIWebView != null) {
      APMidasPayHelper.sIWebView = null;
    }
  }
  
  public static void InnerH5PayInit(Activity paramActivity, android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(192898);
    APLog.i("APMidasPayAPI", "InnerH5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192898);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, paramWebView, null);
    AppMethodBeat.o(192898);
  }
  
  public static void InnerH5PayInitX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView)
  {
    AppMethodBeat.i(192900);
    APLog.i("APMidasPayAPI", "InnerH5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192900);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, null, paramWebView);
    AppMethodBeat.o(192900);
  }
  
  private static boolean checkInitCommParam(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192918);
    if (!env.equals("release")) {
      try
      {
        boolean bool = APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay");
        if (bool)
        {
          AppMethodBeat.o(192918);
          return true;
        }
        if (paramAPMidasBaseRequest == null)
        {
          Toast.makeText(paramContext, "初始化request不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.offerId))
        {
          Toast.makeText(paramContext, "初始化offerid不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.openId))
        {
          Toast.makeText(paramContext, "初始化openId不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.openKey))
        {
          Toast.makeText(paramContext, "初始化openKey不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.sessionId))
        {
          Toast.makeText(paramContext, "初始化sessionId不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.sessionType))
        {
          Toast.makeText(paramContext, "初始化sessionType不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.pf))
        {
          Toast.makeText(paramContext, "初始化pf不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.pfKey))
        {
          Toast.makeText(paramContext, "初始化pfKey不能为空", 1).show();
          AppMethodBeat.o(192918);
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(192918);
    return true;
  }
  
  private static boolean checkParams(Context paramContext)
  {
    AppMethodBeat.i(192895);
    if (paramContext == null)
    {
      APLog.e("APMidasPayAPI", "checkParams() context/activity == Null");
      new Throwable("APMidasPayAPI().checkParams() context/activity == Null");
      AppMethodBeat.o(192895);
      return false;
    }
    AppMethodBeat.o(192895);
    return true;
  }
  
  public static void closeAll()
  {
    AppMethodBeat.i(192917);
    APPluginStatic.removeAll();
    AppMethodBeat.o(192917);
  }
  
  public static void consumeAsync(Activity paramActivity, List<APPurchase> paramList, OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener)
  {
    Object localObject2 = null;
    AppMethodBeat.i(192921);
    APLog.i("APMidasPayAPI", "consumeAsync enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192921);
      return;
    }
    APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
    try
    {
      Class localClass1 = Class.forName(List.class.getName());
      try
      {
        Class localClass2 = Class.forName("com.tencent.midas.api.request.OnAPConsumeFinishedListener");
        localObject2 = localClass2;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          Object localObject1;
          APLog.d("APMidasPayAPI", "consumeAsync OnAPConsumeFinishedListener e:" + localClassNotFoundException2.toString());
        }
      }
      paramActivity = localAPMidasPayHelper.call(paramActivity, "consumeAsync", new Object[] { paramList, paramOnAPConsumeFinishedListener }, new Class[] { localClass1, localObject2 });
      APLog.i("APMidasPayAPI", "consumeAsync ret ".concat(String.valueOf(paramActivity)));
      if (paramActivity == null) {
        paramOnAPConsumeFinishedListener.onConsumeFinished(new ArrayList());
      }
      AppMethodBeat.o(192921);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        APLog.d("APMidasPayAPI", "consumeAsync setEnv e:" + localClassNotFoundException1.toString());
        localObject1 = null;
      }
    }
  }
  
  public static void getInfo(Activity paramActivity, String paramString, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(192912);
    APLog.i("APMidasPayAPI", "getInfo enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192912);
      return;
    }
    try
    {
      fromContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "getinfo");
      APPluginReportManager.getInstance().insertTimeData("getinfo", "timename.launchinfo");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      localAPMidasPayHelper.getInfo(paramActivity, paramString, paramAPMidasBaseRequest, paramIAPMidasNetCallBack);
      AppMethodBeat.o(192912);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromContext", localException.toString());
      }
    }
  }
  
  public static String getJSContent(Context paramContext)
  {
    AppMethodBeat.i(192901);
    APLog.i("APMidasPayAPI", "getJSContent enter");
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(192901);
      return "";
    }
    paramContext = APMidasPayHelper.getJSContent(paramContext);
    AppMethodBeat.o(192901);
    return paramContext;
  }
  
  public static String getMidasCoreVersion(Activity paramActivity)
  {
    AppMethodBeat.i(192906);
    APLog.i("APMidasPayAPI", "getMidasCoreVersion enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192906);
      return "";
    }
    paramActivity = APPluginUtils.getMidasCoreVersionName(paramActivity);
    AppMethodBeat.o(192906);
    return paramActivity;
  }
  
  public static String getMidasPluginVersion()
  {
    AppMethodBeat.i(192905);
    APLog.d("APMidasPayAPI", "getMidasPluginVersion enter " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {}
    for (String str = APMidasCommMethod.getApplicationVersion();; str = "1.7.1f")
    {
      AppMethodBeat.o(192905);
      return str;
    }
  }
  
  public static String getMidasSDKVersion(Activity paramActivity)
  {
    AppMethodBeat.i(192907);
    APLog.i("APMidasPayAPI", "getMidasSDKVersion enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192907);
      return "";
    }
    String str = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
    paramActivity = (String)new APMidasPayHelper().call(paramActivity, str, new Object[0]);
    AppMethodBeat.o(192907);
    return paramActivity;
  }
  
  public static String getPath()
  {
    return dataPath;
  }
  
  public static int h5PayHook(Activity paramActivity, android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    AppMethodBeat.i(192902);
    APLog.i("APMidasPayAPI", "h5PayHook enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192902);
      return -33;
    }
    paramJsResult = new APMidasPayHelper();
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    paramJsResult.setScreenType(screenType);
    int i = paramJsResult.h5Pay(paramActivity, paramWebView, null, paramString1, paramString2);
    AppMethodBeat.o(192902);
    return i;
  }
  
  public static int h5PayHookX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView, String paramString1, String paramString2, com.tencent.smtt.export.external.interfaces.JsResult paramJsResult)
  {
    AppMethodBeat.i(192903);
    APLog.i("APMidasPayAPI", "h5PayHookX5 enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192903);
      return -33;
    }
    paramJsResult = new APMidasPayHelper();
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    paramJsResult.setScreenType(screenType);
    int i = paramJsResult.h5Pay(paramActivity, null, paramWebView, paramString1, paramString2);
    AppMethodBeat.o(192903);
    return i;
  }
  
  public static void h5PayInit(Activity paramActivity, android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(192897);
    APLog.i("APMidasPayAPI", "h5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192897);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, paramWebView, null);
    AppMethodBeat.o(192897);
  }
  
  public static void h5PayInitUnifier(Activity paramActivity, IAPWebView paramIAPWebView)
  {
    AppMethodBeat.i(192896);
    APLog.i("APMidasPayAPI", "h5PayInitUnifier enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192896);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
    APMidasPayHelper.h5InitUnifier(paramActivity, paramIAPWebView);
    AppMethodBeat.o(192896);
  }
  
  public static void h5PayInitX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView)
  {
    AppMethodBeat.i(192899);
    APLog.i("APMidasPayAPI", "h5PayInitX5 enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192899);
      return;
    }
    APMidasPayHelper.h5Init(paramActivity, null, paramWebView);
    AppMethodBeat.o(192899);
  }
  
  public static void hfCouponsRollBack(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(192913);
    APLog.i("APMidasPayAPI", "hfCouponsRollBack enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192913);
      return;
    }
    new APMidasPayHelper().call(paramActivity, "hfCouponsRollBack", new Object[] { paramString });
    AppMethodBeat.o(192913);
  }
  
  public static void init(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(192893);
    APPluginReportManager.initDataRelease();
    APPluginReportManager.getInstance().initInterfaceInit("init", paramAPMidasBaseRequest);
    APLogUtil.initAPLogInPlugin(paramContext.getApplicationContext(), logEnable);
    APLog.i("APMidasPayAPI", "init new enter");
    APPluginReportManager.getInstance().insertTimeData("init", "timename.init");
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    if (checkInitCommParam(paramContext, paramAPMidasBaseRequest))
    {
      APMidasPayHelper.init(paramContext, paramAPMidasBaseRequest);
      AppMethodBeat.o(192893);
      return;
    }
    APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(paramContext);
    AppMethodBeat.o(192893);
  }
  
  public static void launchAbility(Context paramContext, MidasBaseAbility paramMidasBaseAbility, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(192914);
    APLog.i("APMidasPayAPI", "launchAbility enter : " + paramMidasBaseAbility.toString());
    if (APMidasTools.isFastClick())
    {
      APLog.i("launchAbility", "isfast");
      if (paramResultReceiver != null)
      {
        paramContext = new Bundle();
        paramContext.putString("midas_callback_ability_" + "postBack", paramMidasBaseAbility.postBack);
        paramContext.putInt("midas_callback_ability_" + "code", -999);
        paramContext.putString("midas_callback_ability_" + "msg", "fast click");
        paramContext.putBundle("midas_callback_ability_" + "data", new Bundle());
        paramResultReceiver.send(-1, paramContext);
      }
      AppMethodBeat.o(192914);
      return;
    }
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(192914);
      return;
    }
    APPluginReportManager.payDataRelease();
    APMidasGameRequest localAPMidasGameRequest = new APMidasGameRequest();
    localAPMidasGameRequest.offerId = paramMidasBaseAbility.offerId;
    localAPMidasGameRequest.openId = paramMidasBaseAbility.openId;
    localAPMidasGameRequest.openKey = paramMidasBaseAbility.openKey;
    localAPMidasGameRequest.sessionId = paramMidasBaseAbility.sessionId;
    localAPMidasGameRequest.sessionType = paramMidasBaseAbility.sessionType;
    localAPMidasGameRequest.pf = paramMidasBaseAbility.pf;
    localAPMidasGameRequest.pfKey = paramMidasBaseAbility.pfKey;
    APPluginReportManager.getInstance().payInterfaceInit(localAPMidasGameRequest, "launchability");
    APPluginReportManager.getInstance().insertTimeData("launchability", "timename.launchability");
    APPluginReportManager.getInstance().insertData("timename.launchability", "sdk.plugin.enter.ability", "MidasPlugin", paramMidasBaseAbility.toString());
    new APMidasPayHelper().sendMidas(paramContext, paramMidasBaseAbility.toBundle(), new APMidasPayAPI.1(new Handler(), paramResultReceiver));
    AppMethodBeat.o(192914);
  }
  
  public static void launchNet(Activity paramActivity, APMidasNetRequest paramAPMidasNetRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(192911);
    APLog.i("APMidasPayAPI", "launchNet enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192911);
      return;
    }
    try
    {
      fromContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasNetRequest, "launchnet");
      APPluginReportManager.getInstance().insertTimeData("launchnet", "timename.launchnet");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      localAPMidasPayHelper.net(paramActivity, paramAPMidasNetRequest, paramIAPMidasNetCallBack);
      AppMethodBeat.o(192911);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromContext", localException.toString());
      }
    }
  }
  
  public static void launchPay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(192909);
    APLog.i("APMidasPayAPI", "launchPay enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192909);
      return;
    }
    try
    {
      fromContext = paramActivity.getApplicationContext();
      if (APMidasTools.isFastClick())
      {
        APLog.i("launchPay", "isfast");
        APLog.w("APMidasPayAPI", "launchPay enter fast:".concat(String.valueOf(paramIAPMidasPayCallBack)));
        paramActivity = new APMidasResponse();
        paramActivity.resultCode = -1;
        paramActivity.payChannel = -1;
        paramActivity.payState = 2;
        paramActivity.provideState = -1;
        paramActivity.resultMsg = "fast click";
        paramIAPMidasPayCallBack.MidasPayCallBack(paramActivity);
        AppMethodBeat.o(192909);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromContext", localException.toString());
      }
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "launchpay");
      APPluginReportManager.getInstance().insertTimeData("launchpay", "timename.launchpay");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      localAPMidasPayHelper.setScreenType(screenType);
      localAPMidasPayHelper.pay(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
      AppMethodBeat.o(192909);
    }
  }
  
  public static void launchPurchaseFlow(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, APOnIabPurchaseFinished paramAPOnIabPurchaseFinished)
  {
    AppMethodBeat.i(192919);
    APLog.i("APMidasPayAPI", "launchPurchaseFlow enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192919);
      return;
    }
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    if ((paramAPMidasBaseRequest == null) || (!(paramAPMidasBaseRequest instanceof APMidasGoodsRequest)))
    {
      paramAPOnIabPurchaseFinished.onIabPurchaseFinished(new APIabResult(3, ""), null);
      APLog.e("launchPurchaseFlow", "parameter is error");
      AppMethodBeat.o(192919);
      return;
    }
    if ((paramAPMidasBaseRequest instanceof APMidasGoodsRequest)) {
      ((APMidasGoodsRequest)paramAPMidasBaseRequest).mIsReceiptMode = true;
    }
    ((APMidasGoodsRequest)paramAPMidasBaseRequest).isCanChange = false;
    ((APMidasGoodsRequest)paramAPMidasBaseRequest).saveValue = "1";
    ((APMidasGoodsRequest)paramAPMidasBaseRequest).tokenType = 2;
    launchPay(paramActivity, paramAPMidasBaseRequest, new IAPMidasPayCallBack()
    {
      public final void MidasPayCallBack(APMidasResponse paramAnonymousAPMidasResponse)
      {
        AppMethodBeat.i(192936);
        int i = paramAnonymousAPMidasResponse.getResultCode();
        if (paramAnonymousAPMidasResponse.resultCode == 100) {
          i = 101;
        }
        APIabResult localAPIabResult = new APIabResult(i, paramAnonymousAPMidasResponse.getResultMsg());
        this.val$callBack.onIabPurchaseFinished(localAPIabResult, paramAnonymousAPMidasResponse.getReceipt());
        AppMethodBeat.o(192936);
      }
      
      public final void MidasPayNeedLogin()
      {
        AppMethodBeat.i(192935);
        this.val$callBack.onIabyNeedLogin();
        AppMethodBeat.o(192935);
      }
    });
    AppMethodBeat.o(192919);
  }
  
  public static void launchWXMiniProgram(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(192915);
    APLog.i("APMidasPayAPI", "launchWXMiniProgram enter");
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(192915);
      return;
    }
    new APMidasPayHelper().launchWXMiniProgram(paramContext, paramBundle, paramResultReceiver);
    AppMethodBeat.o(192915);
  }
  
  public static void launchWXMiniProgram_OnResponse(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(192916);
    APLog.i("APMidasPayAPI", "launchWXMiniProgram_OnResponse enter");
    APLog.i("APMidasPayAPI", "launchWXMiniProgram_OnResponse enter: bundle = ".concat(String.valueOf(paramBundle)));
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(192916);
      return;
    }
    new APMidasPayHelper().launchWXMiniProgram_OnResponse(paramContext, paramInt, paramBundle);
    AppMethodBeat.o(192916);
  }
  
  public static void launchWeb(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(192910);
    APLog.i("APMidasPayAPI", "launchWeb enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192910);
      return;
    }
    try
    {
      fromContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "launchweb");
      APPluginReportManager.getInstance().insertTimeData("launchweb", "timename.launchweb");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      localAPMidasPayHelper.setScreenType(screenType);
      localAPMidasPayHelper.web(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
      AppMethodBeat.o(192910);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromContext", localException.toString());
      }
    }
  }
  
  public static void queryInventoryAsync(Activity paramActivity, boolean paramBoolean, List<?> paramList, APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    AppMethodBeat.i(192920);
    APLog.i("APMidasPayAPI", "queryInventoryAsync enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(192920);
      return;
    }
    APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
    try
    {
      localClass1 = Class.forName(List.class.getName());
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      try
      {
        for (;;)
        {
          Class localClass1;
          Class localClass2 = Class.forName("com.tencent.midas.api.request.APQueryInventoryFinishedListener");
          paramActivity = localAPMidasPayHelper.call(paramActivity, "queryInventoryAsync", new Object[] { Boolean.valueOf(paramBoolean), paramList, paramAPQueryInventoryFinishedListener }, new Class[] { Boolean.class, localClass1, localClass2 });
          APLog.i("APMidasPayAPI", "queryInventoryAsync ret ".concat(String.valueOf(paramActivity)));
          if (paramActivity == null) {
            paramAPQueryInventoryFinishedListener.onQueryInventoryFinished(new APIabResult(-1, ""), null);
          }
          AppMethodBeat.o(192920);
          return;
          localClassNotFoundException1 = localClassNotFoundException1;
          APLog.d("APMidasPayAPI", "queryInventoryAsync setEnv e:" + localClassNotFoundException1.toString());
          Object localObject1 = null;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        for (;;)
        {
          APLog.d("APMidasPayAPI", "queryInventoryAsync APQueryInventoryFinishedListener e:" + localClassNotFoundException2.toString());
          Object localObject2 = null;
        }
      }
    }
  }
  
  public static void release(Activity paramActivity)
  {
    AppMethodBeat.i(192894);
    APLog.i("APMidasPayAPI", "release() enter");
    String str = APMidasPayHelper.MED_DISTRIBUTE_RELEASE;
    new APMidasPayHelper().call(paramActivity, str, new Object[0]);
    AppMethodBeat.o(192894);
  }
  
  /* Error */
  public static void setEnv(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc_w 702
    //   5: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: putstatic 56	com/tencent/midas/api/APMidasPayAPI:env	Ljava/lang/String;
    //   12: ldc_w 704
    //   15: invokestatic 233	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   18: astore_3
    //   19: aload_3
    //   20: ifnull +58 -> 78
    //   23: aload_3
    //   24: ldc_w 706
    //   27: iconst_0
    //   28: anewarray 226	java/lang/Class
    //   31: invokevirtual 710	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: astore_1
    //   35: aload_1
    //   36: aconst_null
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokevirtual 716	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_3
    //   46: ldc_w 717
    //   49: iconst_1
    //   50: anewarray 226	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc 128
    //   57: aastore
    //   58: invokevirtual 720	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   61: astore_3
    //   62: aload_3
    //   63: astore_2
    //   64: aload_2
    //   65: aload_1
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: aastore
    //   74: invokevirtual 716	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: ldc_w 722
    //   81: new 261	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 724
    //   88: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: getstatic 56	com/tencent/midas/api/APMidasPayAPI:env	Ljava/lang/String;
    //   94: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: ldc_w 702
    //   106: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: return
    //   110: astore_1
    //   111: ldc 42
    //   113: ldc_w 726
    //   116: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -86 -> 35
    //   124: astore_1
    //   125: ldc 42
    //   127: ldc_w 728
    //   130: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aconst_null
    //   134: astore_1
    //   135: goto -90 -> 45
    //   138: astore_3
    //   139: ldc 42
    //   141: ldc_w 730
    //   144: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: goto -83 -> 64
    //   150: astore_0
    //   151: ldc 42
    //   153: new 261	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 732
    //   160: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: aload_0
    //   164: invokevirtual 322	java/lang/Exception:toString	()Ljava/lang/String;
    //   167: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: goto -98 -> 78
    //   179: astore_0
    //   180: ldc 42
    //   182: new 261	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 734
    //   189: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: aload_0
    //   193: invokevirtual 322	java/lang/Exception:toString	()Ljava/lang/String;
    //   196: invokevirtual 271	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: invokevirtual 272	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokestatic 275	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: goto -127 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	208	0	paramString	String
    //   34	32	1	localObject1	Object
    //   110	1	1	localNoSuchMethodException1	java.lang.NoSuchMethodException
    //   120	1	1	localObject2	Object
    //   124	1	1	localException	Exception
    //   134	1	1	localObject3	Object
    //   1	64	2	localObject4	Object
    //   18	45	3	localObject5	Object
    //   138	1	3	localNoSuchMethodException2	java.lang.NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   23	35	110	java/lang/NoSuchMethodException
    //   35	45	124	java/lang/Exception
    //   45	62	138	java/lang/NoSuchMethodException
    //   12	19	150	java/lang/Exception
    //   23	35	150	java/lang/Exception
    //   45	62	150	java/lang/Exception
    //   111	119	150	java/lang/Exception
    //   125	133	150	java/lang/Exception
    //   139	147	150	java/lang/Exception
    //   180	205	150	java/lang/Exception
    //   64	78	179	java/lang/Exception
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    logEnable = paramBoolean;
  }
  
  public static void setParentClassloader(DexClassLoader paramDexClassLoader)
  {
    AppMethodBeat.i(192892);
    APLog.i("APMidasPayAPI", "setParentClassloader enter classLoader:".concat(String.valueOf(paramDexClassLoader)));
    APPluginLoader.setParentClassLoader(paramDexClassLoader);
    AppMethodBeat.o(192892);
  }
  
  public static void setPath(String paramString)
  {
    AppMethodBeat.i(192908);
    APLog.i("APMidasPayAPI", "setPath enter path:".concat(String.valueOf(paramString)));
    dataPath = paramString;
    AppMethodBeat.o(192908);
  }
  
  public static void setScreenType(Activity paramActivity, int paramInt)
  {
    screenType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.api.APMidasPayAPI
 * JD-Core Version:    0.7.0.1
 */