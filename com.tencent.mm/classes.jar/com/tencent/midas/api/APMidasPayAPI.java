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
  public static Context fromApplicationContext = null;
  private static String logCallbackClassName = "";
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
    AppMethodBeat.i(253407);
    APLog.i("APMidasPayAPI", "InnerH5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253407);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, paramWebView, null);
    AppMethodBeat.o(253407);
  }
  
  public static void InnerH5PayInitX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView)
  {
    AppMethodBeat.i(253410);
    APLog.i("APMidasPayAPI", "InnerH5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253410);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_INNER_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, null, paramWebView);
    AppMethodBeat.o(253410);
  }
  
  private static boolean checkInitCommParam(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(253446);
    if (!env.equals("release")) {
      try
      {
        boolean bool = APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay");
        if (bool)
        {
          AppMethodBeat.o(253446);
          return true;
        }
        if (paramAPMidasBaseRequest == null)
        {
          Toast.makeText(paramContext, "初始化request不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.offerId))
        {
          Toast.makeText(paramContext, "初始化offerid不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.openId))
        {
          Toast.makeText(paramContext, "初始化openId不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.openKey))
        {
          Toast.makeText(paramContext, "初始化openKey不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.sessionId))
        {
          Toast.makeText(paramContext, "初始化sessionId不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.sessionType))
        {
          Toast.makeText(paramContext, "初始化sessionType不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.pf))
        {
          Toast.makeText(paramContext, "初始化pf不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
        if (TextUtils.isEmpty(paramAPMidasBaseRequest.pfKey))
        {
          Toast.makeText(paramContext, "初始化pfKey不能为空", 1).show();
          AppMethodBeat.o(253446);
          return false;
        }
      }
      catch (Exception paramContext) {}
    }
    AppMethodBeat.o(253446);
    return true;
  }
  
  private static boolean checkParams(Context paramContext)
  {
    AppMethodBeat.i(253399);
    if (paramContext == null)
    {
      APLog.e("APMidasPayAPI", "checkParams() context/activity == Null");
      new Throwable("APMidasPayAPI().checkParams() context/activity == Null");
      AppMethodBeat.o(253399);
      return false;
    }
    AppMethodBeat.o(253399);
    return true;
  }
  
  public static void closeAll()
  {
    AppMethodBeat.i(253444);
    APPluginStatic.removeAll();
    AppMethodBeat.o(253444);
  }
  
  public static void consumeAsync(Activity paramActivity, List<APPurchase> paramList, OnAPConsumeFinishedListener paramOnAPConsumeFinishedListener)
  {
    Object localObject2 = null;
    AppMethodBeat.i(253450);
    APLog.i("APMidasPayAPI", "consumeAsync enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253450);
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
      AppMethodBeat.o(253450);
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
    AppMethodBeat.i(253437);
    APLog.i("APMidasPayAPI", "getInfo enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253437);
      return;
    }
    try
    {
      fromApplicationContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "getinfo");
      APPluginReportManager.getInstance().insertTimeData("getinfo", "timename.launchinfo");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
      localAPMidasPayHelper.getInfo(paramActivity, paramString, paramAPMidasBaseRequest, paramIAPMidasNetCallBack);
      AppMethodBeat.o(253437);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromApplicationContext", localException.toString());
      }
    }
  }
  
  public static String getJSContent(Context paramContext)
  {
    AppMethodBeat.i(253412);
    APLog.i("APMidasPayAPI", "getJSContent enter");
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(253412);
      return "";
    }
    paramContext = APMidasPayHelper.getJSContent(paramContext);
    AppMethodBeat.o(253412);
    return paramContext;
  }
  
  public static String getMidasCoreVersion(Activity paramActivity)
  {
    AppMethodBeat.i(253424);
    APLog.i("APMidasPayAPI", "getMidasCoreVersion enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253424);
      return "";
    }
    paramActivity = APPluginUtils.getMidasCoreVersionName(paramActivity);
    AppMethodBeat.o(253424);
    return paramActivity;
  }
  
  public static String getMidasPluginVersion()
  {
    AppMethodBeat.i(253422);
    APLog.d("APMidasPayAPI", "getMidasPluginVersion enter " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
    if (APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {}
    for (String str = APMidasCommMethod.getApplicationVersion();; str = "1.7.4")
    {
      AppMethodBeat.o(253422);
      return str;
    }
  }
  
  public static String getMidasSDKVersion(Activity paramActivity)
  {
    AppMethodBeat.i(253425);
    APLog.i("APMidasPayAPI", "getMidasSDKVersion enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253425);
      return "";
    }
    String str = java.lang.Thread.currentThread().getStackTrace()[2].getMethodName();
    paramActivity = (String)new APMidasPayHelper().call(paramActivity, str, new Object[0]);
    AppMethodBeat.o(253425);
    return paramActivity;
  }
  
  public static String getPath()
  {
    return dataPath;
  }
  
  public static int h5PayHook(Activity paramActivity, android.webkit.WebView paramWebView, String paramString1, String paramString2, android.webkit.JsResult paramJsResult)
  {
    AppMethodBeat.i(253414);
    APLog.i("APMidasPayAPI", "h5PayHook enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253414);
      return -33;
    }
    paramJsResult = new APMidasPayHelper();
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    paramJsResult.setScreenType(screenType);
    int i = paramJsResult.h5Pay(paramActivity, paramWebView, null, paramString1, paramString2);
    AppMethodBeat.o(253414);
    return i;
  }
  
  public static int h5PayHookX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView, String paramString1, String paramString2, com.tencent.smtt.export.external.interfaces.JsResult paramJsResult)
  {
    AppMethodBeat.i(253415);
    APLog.i("APMidasPayAPI", "h5PayHookX5 enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253415);
      return -33;
    }
    paramJsResult = new APMidasPayHelper();
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    paramJsResult.setScreenType(screenType);
    int i = paramJsResult.h5Pay(paramActivity, null, paramWebView, paramString1, paramString2);
    AppMethodBeat.o(253415);
    return i;
  }
  
  public static void h5PayInit(Activity paramActivity, android.webkit.WebView paramWebView)
  {
    AppMethodBeat.i(253405);
    APLog.i("APMidasPayAPI", "h5PayInit enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253405);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
    APMidasPayHelper.h5Init(paramActivity, paramWebView, null);
    AppMethodBeat.o(253405);
  }
  
  public static void h5PayInitUnifier(Activity paramActivity, IAPWebView paramIAPWebView)
  {
    AppMethodBeat.i(253402);
    APLog.i("APMidasPayAPI", "h5PayInitUnifier enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253402);
      return;
    }
    APMidasPayHelper.MIDAS_WEBVIEW = APMidasPayHelper.MIDAS_OUT_WEBVIEW;
    APMidasPayHelper.h5InitUnifier(paramActivity, paramIAPWebView);
    AppMethodBeat.o(253402);
  }
  
  public static void h5PayInitX5(Activity paramActivity, com.tencent.smtt.sdk.WebView paramWebView)
  {
    AppMethodBeat.i(253409);
    APLog.i("APMidasPayAPI", "h5PayInitX5 enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253409);
      return;
    }
    APMidasPayHelper.h5Init(paramActivity, null, paramWebView);
    AppMethodBeat.o(253409);
  }
  
  public static void hfCouponsRollBack(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(253439);
    APLog.i("APMidasPayAPI", "hfCouponsRollBack enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253439);
      return;
    }
    new APMidasPayHelper().call(paramActivity, "hfCouponsRollBack", new Object[] { paramString });
    AppMethodBeat.o(253439);
  }
  
  public static void init(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(253389);
    initCommon(paramContext, paramAPMidasBaseRequest);
    if (checkInitCommParam(paramContext, paramAPMidasBaseRequest))
    {
      APMidasPayHelper.init(paramContext, paramAPMidasBaseRequest);
      AppMethodBeat.o(253389);
      return;
    }
    APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(paramContext);
    AppMethodBeat.o(253389);
  }
  
  public static void init(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(253392);
    initCommon(paramContext, paramAPMidasBaseRequest);
    if (checkInitCommParam(paramContext, paramAPMidasBaseRequest))
    {
      APMidasPayHelper.init(paramContext, paramAPMidasBaseRequest, paramResultReceiver);
      AppMethodBeat.o(253392);
      return;
    }
    APMidasPayHelper.isNewProcess = APMidasPayHelper.isNewProcess(paramContext);
    AppMethodBeat.o(253392);
  }
  
  private static void initCommon(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    AppMethodBeat.i(253386);
    APPluginReportManager.initDataRelease();
    APPluginReportManager.getInstance().initInterfaceInit("init", paramAPMidasBaseRequest);
    APLogUtil.initAPLogInPlugin(paramContext.getApplicationContext(), logEnable, logCallbackClassName);
    APLog.i("APMidasPayAPI", "init new enter");
    APPluginReportManager.getInstance().insertTimeData("init", "timename.init");
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    AppMethodBeat.o(253386);
  }
  
  public static void launchAbility(Context paramContext, MidasBaseAbility paramMidasBaseAbility, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(253440);
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
      AppMethodBeat.o(253440);
      return;
    }
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(253440);
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
    new APMidasPayHelper().sendMidas(paramContext, paramMidasBaseAbility.toBundle(), new ResultReceiver(new Handler())
    {
      protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(253466);
        APLog.i("APMidasPayAPI", "launchAbility.onReceiveResult() resultCode=" + paramAnonymousInt + ", resultData=" + paramAnonymousBundle);
        if (paramResultReceiver != null)
        {
          paramResultReceiver.send(paramAnonymousInt, paramAnonymousBundle);
          APPluginReportManager.getInstance().dataReport("launchAbility");
          APPluginUtils.release();
          APLog.closeLog();
        }
        AppMethodBeat.o(253466);
      }
    });
    AppMethodBeat.o(253440);
  }
  
  public static void launchNet(Activity paramActivity, APMidasNetRequest paramAPMidasNetRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(253435);
    APLog.i("APMidasPayAPI", "launchNet enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253435);
      return;
    }
    try
    {
      fromApplicationContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasNetRequest, "launchnet");
      APPluginReportManager.getInstance().insertTimeData("launchnet", "timename.launchnet");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
      localAPMidasPayHelper.net(paramActivity, paramAPMidasNetRequest, paramIAPMidasNetCallBack);
      AppMethodBeat.o(253435);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromApplicationContext", localException.toString());
      }
    }
  }
  
  public static void launchPay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(253430);
    APLog.i("APMidasPayAPI", "launchPay enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253430);
      return;
    }
    try
    {
      fromApplicationContext = paramActivity.getApplicationContext();
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
        AppMethodBeat.o(253430);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromApplicationContext", localException.toString());
      }
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "launchpay");
      APPluginReportManager.getInstance().insertTimeData("launchpay", "timename.launchpay");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
      localAPMidasPayHelper.setScreenType(screenType);
      localAPMidasPayHelper.pay(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
      AppMethodBeat.o(253430);
    }
  }
  
  public static void launchPurchaseFlow(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, APOnIabPurchaseFinished paramAPOnIabPurchaseFinished)
  {
    AppMethodBeat.i(253447);
    APLog.i("APMidasPayAPI", "launchPurchaseFlow enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253447);
      return;
    }
    APMidasPayHelper.setEnv(env);
    APMidasPayHelper.setLogEnable(logEnable);
    APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    if ((paramAPMidasBaseRequest == null) || (!(paramAPMidasBaseRequest instanceof APMidasGoodsRequest)))
    {
      paramAPOnIabPurchaseFinished.onIabPurchaseFinished(new APIabResult(3, ""), null);
      APLog.e("launchPurchaseFlow", "parameter is error");
      AppMethodBeat.o(253447);
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
        AppMethodBeat.i(253377);
        int i = paramAnonymousAPMidasResponse.getResultCode();
        if (paramAnonymousAPMidasResponse.resultCode == 100) {
          i = 101;
        }
        APIabResult localAPIabResult = new APIabResult(i, paramAnonymousAPMidasResponse.getResultMsg());
        this.val$callBack.onIabPurchaseFinished(localAPIabResult, paramAnonymousAPMidasResponse.getReceipt());
        AppMethodBeat.o(253377);
      }
      
      public final void MidasPayNeedLogin()
      {
        AppMethodBeat.i(253376);
        this.val$callBack.onIabyNeedLogin();
        AppMethodBeat.o(253376);
      }
    });
    AppMethodBeat.o(253447);
  }
  
  public static void launchWXMiniProgram(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(253442);
    APLog.i("APMidasPayAPI", "launchWXMiniProgram enter");
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(253442);
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      APLog.e("launchAbility", "context is not Activity : ".concat(String.valueOf(paramContext)));
      if (!"release".equals(env)) {
        Toast.makeText(paramContext.getApplicationContext(), "Input context must be Activity", 1).show();
      }
      if (paramResultReceiver != null)
      {
        paramContext = new Bundle();
        paramContext.putInt("midas_callback_ability_" + "code", -998);
        paramContext.putString("midas_callback_ability_" + "msg", "context is not Activity ");
        paramContext.putBundle("midas_callback_ability_" + "data", new Bundle());
        paramResultReceiver.send(-101, paramContext);
      }
      AppMethodBeat.o(253442);
      return;
    }
    new APMidasPayHelper().launchWXMiniProgram(paramContext, paramBundle, paramResultReceiver);
    AppMethodBeat.o(253442);
  }
  
  public static void launchWXMiniProgram_OnResponse(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(253443);
    APLog.i("APMidasPayAPI", "launchWXMiniProgram_OnResponse enter");
    APLog.i("APMidasPayAPI", "launchWXMiniProgram_OnResponse enter: bundle = ".concat(String.valueOf(paramBundle)));
    if (!checkParams(paramContext))
    {
      AppMethodBeat.o(253443);
      return;
    }
    if (!(paramContext instanceof Activity))
    {
      APLog.e("launchAbility", "context is not Activity : ".concat(String.valueOf(paramContext)));
      if (!"release".equals(env)) {
        Toast.makeText(paramContext.getApplicationContext(), "Input context must be Activity", 1).show();
      }
      AppMethodBeat.o(253443);
      return;
    }
    new APMidasPayHelper().launchWXMiniProgram_OnResponse(paramContext, paramInt, paramBundle);
    AppMethodBeat.o(253443);
  }
  
  public static void launchWeb(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(253432);
    APLog.i("APMidasPayAPI", "launchWeb enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253432);
      return;
    }
    try
    {
      fromApplicationContext = paramActivity.getApplicationContext();
      APPluginReportManager.payDataRelease();
      APPluginReportManager.getInstance().payInterfaceInit(paramAPMidasBaseRequest, "launchweb");
      APPluginReportManager.getInstance().insertTimeData("launchweb", "timename.launchweb");
      APMidasPayHelper localAPMidasPayHelper = new APMidasPayHelper();
      APMidasPayHelper.setEnv(env);
      APMidasPayHelper.setLogEnable(logEnable);
      APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
      localAPMidasPayHelper.setScreenType(screenType);
      localAPMidasPayHelper.web(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
      AppMethodBeat.o(253432);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        APLog.i("fromApplicationContext", localException.toString());
      }
    }
  }
  
  public static void queryInventoryAsync(Activity paramActivity, boolean paramBoolean, List<?> paramList, APQueryInventoryFinishedListener paramAPQueryInventoryFinishedListener)
  {
    AppMethodBeat.i(253448);
    APLog.i("APMidasPayAPI", "queryInventoryAsync enter");
    if (!checkParams(paramActivity))
    {
      AppMethodBeat.o(253448);
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
          AppMethodBeat.o(253448);
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
    AppMethodBeat.i(253396);
    APLog.i("APMidasPayAPI", "release() enter");
    String str = APMidasPayHelper.MED_DISTRIBUTE_RELEASE;
    new APMidasPayHelper().call(paramActivity, str, new Object[0]);
    AppMethodBeat.o(253396);
  }
  
  public static void setEnv(String paramString)
  {
    AppMethodBeat.i(253418);
    env = paramString;
    APMidasPayHelper.setEnv(paramString);
    if ((fromApplicationContext != null) && ((fromApplicationContext instanceof Activity))) {
      new APMidasPayHelper().call(fromApplicationContext, "setEnv", new Class[] { String.class }, new Object[] { paramString });
    }
    APLog.d("MidasPluginSDK", "env= " + env);
    AppMethodBeat.o(253418);
  }
  
  public static <T extends IMidasLogCallback> void setLogCallback(Class<T> paramClass)
  {
    AppMethodBeat.i(253390);
    logCallbackClassName = paramClass.getName();
    AppMethodBeat.o(253390);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(253419);
    logEnable = paramBoolean;
    APMidasPayHelper.setLogEnable(paramBoolean);
    APMidasPayHelper.setLogCallbackClassName(logCallbackClassName);
    if ((fromApplicationContext != null) && ((fromApplicationContext instanceof Activity))) {
      new APMidasPayHelper().call(fromApplicationContext, "setLogEnable", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
    }
    AppMethodBeat.o(253419);
  }
  
  public static void setLongConnection(Context paramContext, boolean paramBoolean)
  {
    AppMethodBeat.i(253394);
    APMidasPayHelper.setLongConnection(paramContext, paramBoolean);
    AppMethodBeat.o(253394);
  }
  
  public static void setParentClassloader(DexClassLoader paramDexClassLoader)
  {
    AppMethodBeat.i(253385);
    APLog.i("APMidasPayAPI", "setParentClassloader enter classLoader:".concat(String.valueOf(paramDexClassLoader)));
    APPluginLoader.setParentClassLoader(paramDexClassLoader);
    AppMethodBeat.o(253385);
  }
  
  public static void setPath(String paramString)
  {
    AppMethodBeat.i(253428);
    APLog.i("APMidasPayAPI", "setPath enter path:".concat(String.valueOf(paramString)));
    dataPath = paramString;
    AppMethodBeat.o(253428);
  }
  
  public static void setScreenType(Activity paramActivity, int paramInt)
  {
    screenType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.api.APMidasPayAPI
 * JD-Core Version:    0.7.0.1
 */