package com.tencent.midas.control;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.widget.Toast;
import com.pay.tool.APMidasTools;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.midas.api.APMidasResponse;
import com.tencent.midas.api.IAPMidasNetCallBack;
import com.tencent.midas.api.IAPMidasPayCallBack;
import com.tencent.midas.api.IAPWebView;
import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasNetRequest;
import com.tencent.midas.api.request.APPurchase;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.data.APDataId;
import com.tencent.midas.data.APMultiProcessData;
import com.tencent.midas.data.APPluginDataInterface;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.midas.jsbridge.APWebJSBridgeActivity;
import com.tencent.midas.plugin.APPluginChecker;
import com.tencent.midas.plugin.APPluginInstallerAndUpdater;
import com.tencent.midas.plugin.APPluginInterfaceManager;
import com.tencent.midas.plugin.APPluginLoader;
import com.tencent.midas.plugin.APPluginUtils;
import org.json.JSONException;

public class APMidasPayHelper
  implements APCallBackResultReceiver.Receiver
{
  public static String MED_DISTRIBUTE_CALL;
  public static String MED_DISTRIBUTE_CALL2;
  public static final String MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY = "callbackFromMidasPay";
  public static String MED_DISTRIBUTE_H5PAY;
  public static String MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT;
  public static String MED_DISTRIBUTE_HANDLE_WX_INTENT;
  public static final String MED_DISTRIBUTE_HF_COUPONS_ROLLBACK = "hfCouponsRollBack";
  public static String MED_DISTRIBUTE_INFO;
  public static String MED_DISTRIBUTE_INIT;
  public static String MED_DISTRIBUTE_NET;
  public static String MED_DISTRIBUTE_PAY;
  public static String MED_DISTRIBUTE_RECEIVE;
  public static String MED_DISTRIBUTE_RELEASE;
  public static String MED_DISTRIBUTE_WEB;
  public static final String MED_DISTRIBUTE_WX_MINIPROGRAM = "launchWXMiniProgram";
  public static final String MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE = "launchWXMiniProgram_OnResponse";
  public static final String MED_DISTRIBUTE_XGAME_CONSUME = "consumeAsync";
  public static final String MED_DISTRIBUTE_XGAME_QUERY = "queryInventoryAsync";
  public static int MIDAS_INNER_WEBVIEW = 0;
  public static int MIDAS_OUT_WEBVIEW = 0;
  public static String MIDAS_PLUGIN_NAME;
  public static final String MIDAS_PLUGIN_VERSION = "1.7.1f";
  public static int MIDAS_WEBVIEW = 0;
  public static String PKG_DISTRIBUTE;
  public static final int PLUGIN_INITFAIL = 2;
  private static final int PLUGIN_INITIDLE = -1;
  public static final int PLUGIN_INITING = 0;
  public static final int PLUGIN_INITSUCC = 1;
  private static final int RET_CHANGE_H5 = -100011;
  private static final String RET_MSG_CHANGE_H5 = "needChangeH5";
  private static final String TAG = "APMidasPayHelper";
  private static Object dexloadObject;
  private static String env;
  private static int initCount;
  private static Object initObject;
  private static APMidasBaseRequest initRequest;
  public static int initState;
  private static boolean isInitSucc;
  private static boolean isNeedLocalUpdate;
  public static boolean isNewProcess;
  private static Object loadingObject;
  private static boolean logEnable;
  public static IAPMidasPayCallBack midasCallBack;
  public static IAPMidasNetCallBack netCallBack;
  private static String netCallBack_ReqType;
  private static APCallBackResultReceiver remotRecevier;
  public static APMidasBaseRequest requestObject;
  public static IAPWebView sIWebView;
  public static Activity staticActivityContext;
  public static android.webkit.WebView webview;
  public static com.tencent.smtt.sdk.WebView x5Webview;
  private byte _hellAccFlag_;
  Object retobj = null;
  public int saveType = 0;
  public int screenType = 0;
  
  static
  {
    AppMethodBeat.i(192994);
    MIDAS_PLUGIN_NAME = "MidasPay";
    PKG_DISTRIBUTE = "com.tencent.midas.pay.APMidasDistribute";
    MED_DISTRIBUTE_INIT = "golbalInit";
    MED_DISTRIBUTE_RELEASE = "release";
    MED_DISTRIBUTE_PAY = "openMidasPay";
    MED_DISTRIBUTE_NET = "openMidasNet";
    MED_DISTRIBUTE_INFO = "openMidasInfo";
    MED_DISTRIBUTE_CALL = "openMidasCall";
    MED_DISTRIBUTE_CALL2 = "openMidasCall2";
    MED_DISTRIBUTE_RECEIVE = "receiveMidas";
    MED_DISTRIBUTE_H5PAY = "openMidasH5Pay";
    MED_DISTRIBUTE_WEB = "openMidasWeb";
    MED_DISTRIBUTE_HANDLE_WX_INTENT = "handleWXIntent";
    MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT = "handleQQWalletIntent";
    MIDAS_WEBVIEW = 0;
    MIDAS_INNER_WEBVIEW = 0;
    MIDAS_OUT_WEBVIEW = 1;
    env = "release";
    midasCallBack = null;
    netCallBack = null;
    netCallBack_ReqType = "";
    initCount = 0;
    initState = -1;
    initObject = new Object();
    dexloadObject = new Object();
    loadingObject = new Object();
    isInitSucc = false;
    initRequest = null;
    isNeedLocalUpdate = false;
    remotRecevier = null;
    isNewProcess = false;
    requestObject = null;
    staticActivityContext = null;
    AppMethodBeat.o(192994);
  }
  
  public static String getJSContent(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(192957);
      APLog.i("APMidasPayHelper", "getJSContent");
      init(paramContext, null);
      paramContext = (String)new APMidasPayHelper().callWithContext(paramContext, "getH5JS", new Object[] { paramContext });
      AppMethodBeat.o(192957);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static void h5Init(Activity paramActivity, android.webkit.WebView paramWebView, com.tencent.smtt.sdk.WebView paramWebView1)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 316
    //   6: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 84
    //   11: ldc_w 317
    //   14: invokestatic 295	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: putstatic 319	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   21: aload_1
    //   22: putstatic 321	com/tencent/midas/control/APMidasPayHelper:webview	Landroid/webkit/WebView;
    //   25: aload_0
    //   26: invokestatic 324	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   29: putstatic 223	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   32: getstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   35: ifgt +31 -> 66
    //   38: invokestatic 328	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   41: aload_0
    //   42: ldc_w 329
    //   45: new 22	com/tencent/midas/control/APMidasPayHelper$4
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 332	com/tencent/midas/control/APMidasPayHelper$4:<init>	(Landroid/app/Activity;)V
    //   53: invokestatic 335	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   56: ldc_w 316
    //   59: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: new 2	com/tencent/midas/control/APMidasPayHelper
    //   69: dup
    //   70: invokespecial 300	com/tencent/midas/control/APMidasPayHelper:<init>	()V
    //   73: aload_0
    //   74: ldc_w 302
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: invokevirtual 339	com/tencent/midas/control/APMidasPayHelper:call	(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 308	java/lang/String
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic 345	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifne +86 -> 184
    //   101: getstatic 321	com/tencent/midas/control/APMidasPayHelper:webview	Landroid/webkit/WebView;
    //   104: ifnull +17 -> 121
    //   107: aload_1
    //   108: ldc_w 347
    //   111: aload_0
    //   112: invokestatic 351	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 354	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokevirtual 360	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   121: getstatic 319	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   124: ifnull +19 -> 143
    //   127: getstatic 319	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   130: ldc_w 347
    //   133: aload_0
    //   134: invokestatic 351	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokevirtual 354	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 363	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   143: ldc_w 316
    //   146: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -87 -> 62
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: ldc 84
    //   161: new 365	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 367
    //   168: invokespecial 369	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 372	java/lang/Exception:toString	()Ljava/lang/String;
    //   175: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 380	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: ldc_w 316
    //   187: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: goto -128 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	193	0	paramActivity	Activity
    //   0	193	1	paramWebView	android.webkit.WebView
    //   0	193	2	paramWebView1	com.tencent.smtt.sdk.WebView
    //   96	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	62	152	finally
    //   66	97	152	finally
    //   101	121	152	finally
    //   121	143	152	finally
    //   143	149	152	finally
    //   159	184	152	finally
    //   184	190	152	finally
    //   101	121	158	java/lang/Exception
    //   121	143	158	java/lang/Exception
  }
  
  /* Error */
  @android.annotation.SuppressLint({"NewApi"})
  public static void h5InitUnifier(Activity paramActivity, IAPWebView paramIAPWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 384
    //   6: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 84
    //   11: ldc_w 385
    //   14: invokestatic 295	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: putstatic 387	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   21: aload_0
    //   22: invokestatic 324	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   25: putstatic 223	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   28: getstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   31: ifgt +31 -> 62
    //   34: invokestatic 328	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   37: aload_0
    //   38: ldc_w 329
    //   41: new 20	com/tencent/midas/control/APMidasPayHelper$3
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 388	com/tencent/midas/control/APMidasPayHelper$3:<init>	(Landroid/app/Activity;)V
    //   49: invokestatic 335	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   52: ldc_w 384
    //   55: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: new 2	com/tencent/midas/control/APMidasPayHelper
    //   65: dup
    //   66: invokespecial 300	com/tencent/midas/control/APMidasPayHelper:<init>	()V
    //   69: aload_0
    //   70: ldc_w 302
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: invokevirtual 339	com/tencent/midas/control/APMidasPayHelper:call	(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 308	java/lang/String
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 345	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: istore_2
    //   93: iload_2
    //   94: ifne +68 -> 162
    //   97: getstatic 387	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   100: ifnull +21 -> 121
    //   103: getstatic 387	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   106: ldc_w 347
    //   109: aload_0
    //   110: invokestatic 351	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 354	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokeinterface 391 2 0
    //   121: ldc_w 384
    //   124: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: goto -69 -> 58
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: ldc 84
    //   139: new 365	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 393
    //   146: invokespecial 369	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 372	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 376	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 380	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc_w 384
    //   165: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   168: goto -110 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	paramActivity	Activity
    //   0	171	1	paramIAPWebView	IAPWebView
    //   92	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	58	130	finally
    //   62	93	130	finally
    //   97	121	130	finally
    //   121	127	130	finally
    //   137	162	130	finally
    //   162	168	130	finally
    //   97	121	136	java/lang/Exception
  }
  
  /* Error */
  public static void init(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 394
    //   6: invokestatic 128	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 84
    //   11: new 365	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 396
    //   18: invokespecial 369	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: getstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   24: invokevirtual 399	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 377	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 295	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokestatic 324	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   37: putstatic 223	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   40: aload_1
    //   41: putstatic 217	com/tencent/midas/control/APMidasPayHelper:initRequest	Lcom/tencent/midas/api/request/APMidasBaseRequest;
    //   44: getstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   47: ifgt +53 -> 100
    //   50: getstatic 215	com/tencent/midas/control/APMidasPayHelper:isInitSucc	Z
    //   53: ifne +47 -> 100
    //   56: invokestatic 328	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   59: aload_0
    //   60: ldc_w 329
    //   63: new 8	com/tencent/midas/control/APMidasPayHelper$1
    //   66: dup
    //   67: invokespecial 400	com/tencent/midas/control/APMidasPayHelper$1:<init>	()V
    //   70: invokestatic 335	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   73: invokestatic 406	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   76: ldc_w 329
    //   79: invokevirtual 409	com/tencent/midas/data/APPluginReportManager:dataReport	(Ljava/lang/String;)V
    //   82: getstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   85: iconst_1
    //   86: iadd
    //   87: putstatic 202	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   90: ldc_w 394
    //   93: invokestatic 230	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: getstatic 215	com/tencent/midas/control/APMidasPayHelper:isInitSucc	Z
    //   103: ifeq -30 -> 73
    //   106: aload_0
    //   107: checkcast 411	android/app/Activity
    //   110: new 18	com/tencent/midas/control/APMidasPayHelper$2
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 414	com/tencent/midas/control/APMidasPayHelper$2:<init>	(Landroid/content/Context;)V
    //   118: invokevirtual 418	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   121: goto -48 -> 73
    //   124: astore_0
    //   125: ldc 2
    //   127: monitorexit
    //   128: aload_0
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramContext	Context
    //   0	130	1	paramAPMidasBaseRequest	APMidasBaseRequest
    // Exception table:
    //   from	to	target	type
    //   3	73	124	finally
    //   73	96	124	finally
    //   100	121	124	finally
  }
  
  public static boolean isLogEnable()
  {
    return logEnable;
  }
  
  public static boolean isNewProcess(Context paramContext)
  {
    AppMethodBeat.i(192989);
    try
    {
      Object localObject = paramContext.getApplicationContext().getPackageManager();
      paramContext = ((PackageManager)localObject).getPackageInfo(((PackageManager)localObject).getPackageInfo(paramContext.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
      int i = 0;
      while (i < paramContext.length)
      {
        localObject = paramContext[i];
        if (((ActivityInfo)localObject).name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity"))
        {
          localObject = ((ActivityInfo)localObject).processName;
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            boolean bool = ((String)localObject).contains("midasPay");
            if (bool)
            {
              AppMethodBeat.o(192989);
              return true;
            }
          }
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramContext)
    {
      AppMethodBeat.o(192989);
    }
  }
  
  public static void midasCallBack(APMidasResponse paramAPMidasResponse)
  {
    AppMethodBeat.i(192981);
    if ((paramAPMidasResponse != null) && (paramAPMidasResponse.resultCode == -100011) && ("needChangeH5".equals(paramAPMidasResponse.resultMsg)) && (APWebJSBridgeActivity.startPureH5Pay(staticActivityContext, "", "change_h5_from_cgi")))
    {
      staticActivityContext = null;
      AppMethodBeat.o(192981);
      return;
    }
    APLog.i("APMidasPayHelper", "midasCallBack resultCode :" + paramAPMidasResponse.resultCode + " midasCallBack:" + midasCallBack);
    if (midasCallBack != null)
    {
      midasCallBack.MidasPayCallBack(paramAPMidasResponse);
      midasCallBack = null;
    }
    if (remotRecevier != null)
    {
      remotRecevier.setReceiver(null);
      remotRecevier = null;
    }
    APPluginReportManager.getInstance().dataReport("launchpay");
    requestObject = null;
    APPluginUtils.release();
    APLog.closeLog();
    staticActivityContext = null;
    AppMethodBeat.o(192981);
  }
  
  public static void midasH5CallBack(String paramString)
  {
    AppMethodBeat.i(192983);
    APLog.i("APMidasPayHelper", "midasH5CallBack params:" + paramString + " webview:" + webview + " x5Webview:" + x5Webview);
    if (webview != null) {}
    try
    {
      webview.loadUrl(paramString);
      if (x5Webview == null) {}
    }
    catch (Exception localException)
    {
      try
      {
        x5Webview.loadUrl(paramString);
        if (remotRecevier != null)
        {
          remotRecevier.setReceiver(null);
          remotRecevier = null;
        }
        APPluginReportManager.getInstance().dataReport("launchpay");
        APPluginUtils.release();
        APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
        AppMethodBeat.o(192983);
        return;
        localException = localException;
        APLog.w("APMidasPayHelper", "midasH5CallBack error:" + localException.toString());
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          APLog.w("APMidasPayHelper", "midasH5CallBack error:" + paramString.toString());
        }
      }
    }
  }
  
  public static void midasLoginExpire()
  {
    AppMethodBeat.i(192982);
    if (midasCallBack != null)
    {
      midasCallBack.MidasPayNeedLogin();
      midasCallBack = null;
    }
    if (remotRecevier != null)
    {
      remotRecevier.setReceiver(null);
      remotRecevier = null;
    }
    APPluginReportManager.getInstance().dataReport("launchpay");
    APPluginUtils.release();
    APLog.closeLog();
    staticActivityContext = null;
    requestObject = null;
    AppMethodBeat.o(192982);
  }
  
  public static void onNetError(String paramString1, Integer paramInteger, String paramString2)
  {
    AppMethodBeat.i(192984);
    if (netCallBack != null)
    {
      netCallBack.MidasNetError(paramString1, paramInteger.intValue(), paramString2);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(192984);
  }
  
  public static void onNetFinish(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192986);
    if (netCallBack != null)
    {
      netCallBack.MidasNetFinish(paramString1, paramString2);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(192986);
  }
  
  public static void onNetStop(String paramString)
  {
    AppMethodBeat.i(192985);
    if (netCallBack != null)
    {
      netCallBack.MidasNetStop(paramString);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(192985);
  }
  
  private void openPlugin(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(192978);
    APLog.d("APMidasPayHelper", "Calling into openPlugin, method = " + paramString + " caller = " + Thread.currentThread().getStackTrace()[3].toString());
    try
    {
      paramActivity = APPluginInterfaceManager.initPluginInterface(paramActivity, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, paramString, new Object[] { paramActivity, paramIntent });
    }
    catch (Exception paramActivity)
    {
      try
      {
        for (;;)
        {
          APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
          APLog.i("APMidasPayHelper", "openPlugin obj:".concat(String.valueOf(paramActivity)));
          AppMethodBeat.o(192978);
          return;
          paramActivity = paramActivity;
          paramActivity = null;
        }
      }
      catch (Exception paramIntent)
      {
        for (;;)
        {
          APLog.i("APMidasPayHelper", "openPlugin dataReport:" + paramIntent.toString());
        }
      }
    }
  }
  
  private void pluginInitErrCallBack(final Activity paramActivity)
  {
    AppMethodBeat.i(192987);
    APLog.i("APMidasPayHelper", "pluginInitErrCallBack" + midasCallBack);
    if (APWebJSBridgeActivity.startPureH5Pay(paramActivity, APPluginUtils.getInitErrorMsg(), "pluginInitErrCallBack"))
    {
      AppMethodBeat.o(192987);
      return;
    }
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(192943);
        APPluginReportManager.getInstance().insertData(APPluginDataInterface.singleton().getLaunchInterface(), "sdk.loadapk_error", "", APPluginUtils.getInitErrorMsg());
        Toast.makeText(paramActivity, "腾讯支付服务加载失败，请退出重试", 1).show();
        APMidasResponse localAPMidasResponse = new APMidasResponse();
        localAPMidasResponse.resultCode = -100;
        if (APMidasPayHelper.midasCallBack != null)
        {
          APMidasPayHelper.midasCallBack.MidasPayCallBack(localAPMidasResponse);
          APMidasPayHelper.midasCallBack = null;
          APMidasPayHelper.requestObject = null;
          APMidasPayHelper.staticActivityContext = null;
        }
        if (APMidasPayHelper.netCallBack != null)
        {
          APMidasPayHelper.netCallBack.MidasNetError(APMidasPayHelper.netCallBack_ReqType, -100, "腾讯支付服务加载失败，请退出重试");
          APMidasPayHelper.netCallBack = null;
          APMidasPayHelper.access$802("");
          APMidasPayHelper.requestObject = null;
          APMidasPayHelper.staticActivityContext = null;
        }
        APPluginReportManager.getInstance().dataReport(APPluginDataInterface.singleton().getLaunchInterface());
        AppMethodBeat.o(192943);
      }
    });
    AppMethodBeat.o(192987);
  }
  
  private static void preLoadMidasPay(Context arg0, final String paramString, final IAPInitCallBack paramIAPInitCallBack)
  {
    int i = 0;
    AppMethodBeat.i(192980);
    APLog.d("APMidasPayHelper", "Calling into preLoadMidasPay " + Thread.currentThread().getStackTrace()[3].toString());
    System.currentTimeMillis();
    long l;
    Object localObject;
    if (isNeedLocalUpdate)
    {
      APLog.d("APMidasPayHelper", "Calling into preLoadMidasPay isNeedLocalUpdate == true");
      APPluginInstallerAndUpdater.installFromLocal(???);
      l = System.currentTimeMillis();
      APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.installFromLocal.time", l);
      isNeedLocalUpdate = false;
      l = System.currentTimeMillis();
      int j = APPluginInstallerAndUpdater.isNeedUpdateFromAssets(???);
      APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.isNeedAssetsUpdate.time", l);
      APLog.d("APMidasPayHelper", "preLoadMidasPay isNeedUpdateFromAssets = ".concat(String.valueOf(j)));
      if (j > 0)
      {
        l = System.currentTimeMillis();
        i = APPluginInstallerAndUpdater.installPlugin(???, j);
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.installFromAssets.time", l);
      }
      APLog.i("APMidasPayHelper", "preLoadMidasPay installPlugin ret:" + i + " initRequest:" + initRequest);
      localObject = initObject;
      if (i == 0) {
        break label258;
      }
    }
    for (;;)
    {
      try
      {
        initCount = 0;
        initState = 2;
        if (paramIAPInitCallBack != null) {
          paramIAPInitCallBack.result(-1, APPluginUtils.getInitErrorMsg(), paramString, null);
        }
        return;
      }
      finally
      {
        label258:
        boolean bool;
        AppMethodBeat.o(192980);
      }
      APLog.d("APMidasPayHelper", "Calling into preLoadMidasPay isNeedLocalUpdate == false");
      break;
      l = System.currentTimeMillis();
      bool = APPluginChecker.isPluginValid(???);
      APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.pluginvalid.time", l);
      if (!bool)
      {
        APLog.i("APMidasPayHelper", "preLoadMidasPay isPluginValid false");
        APPluginInstallerAndUpdater.unInstallPlugin(???);
        initState = -1;
        if (paramIAPInitCallBack != null)
        {
          initCount = 0;
          paramIAPInitCallBack.result(-1, "支付插件校验失败", paramString, null);
        }
        synchronized (loadingObject)
        {
          loadingObject.notifyAll();
        }
      }
      try
      {
        l = System.currentTimeMillis();
        APPluginLoader.preCreateClassLoaderByPath(???);
        APPluginReportManager.getInstance().insertTimeDataEx(APMidasTools.getCurrentThreadName(Thread.currentThread()), "sdk.plugin.init.loadDex.time", l);
        String str = Thread.currentThread().getName();
        if ((??? instanceof Activity)) {
          ((Activity)???).runOnUiThread(new Runnable()
          {
            /* Error */
            public final void run()
            {
              // Byte code:
              //   0: ldc 36
              //   2: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
              //   5: new 44	android/content/Intent
              //   8: dup
              //   9: invokespecial 45	android/content/Intent:<init>	()V
              //   12: astore_3
              //   13: aload_3
              //   14: ldc 47
              //   16: ldc 49
              //   18: invokevirtual 53	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
              //   21: pop
              //   22: aload_3
              //   23: ldc 55
              //   25: invokestatic 59	com/tencent/midas/control/APMidasPayHelper:access$200	()Lcom/tencent/midas/api/request/APMidasBaseRequest;
              //   28: invokevirtual 62	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;
              //   31: pop
              //   32: aload_3
              //   33: ldc 64
              //   35: invokestatic 68	com/tencent/midas/control/APMidasPayHelper:access$300	()Ljava/lang/String;
              //   38: invokevirtual 53	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
              //   41: pop
              //   42: aload_3
              //   43: ldc 70
              //   45: invokestatic 74	com/tencent/midas/control/APMidasPayHelper:access$400	()Z
              //   48: invokevirtual 77	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
              //   51: pop
              //   52: aload_3
              //   53: ldc 79
              //   55: aload_0
              //   56: getfield 22	com/tencent/midas/control/APMidasPayHelper$13:val$launchInterfaceName	Ljava/lang/String;
              //   59: invokevirtual 53	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
              //   62: pop
              //   63: aload_0
              //   64: getfield 24	com/tencent/midas/control/APMidasPayHelper$13:val$context	Landroid/content/Context;
              //   67: checkcast 81	android/app/Activity
              //   70: astore 4
              //   72: invokestatic 87	java/lang/System:currentTimeMillis	()J
              //   75: lstore_1
              //   76: aload 4
              //   78: getstatic 90	com/tencent/midas/control/APMidasPayHelper:MIDAS_PLUGIN_NAME	Ljava/lang/String;
              //   81: getstatic 93	com/tencent/midas/control/APMidasPayHelper:PKG_DISTRIBUTE	Ljava/lang/String;
              //   84: getstatic 96	com/tencent/midas/control/APMidasPayHelper:MED_DISTRIBUTE_INIT	Ljava/lang/String;
              //   87: iconst_2
              //   88: anewarray 4	java/lang/Object
              //   91: dup
              //   92: iconst_0
              //   93: aload 4
              //   95: aastore
              //   96: dup
              //   97: iconst_1
              //   98: aload_3
              //   99: aastore
              //   100: invokestatic 102	com/tencent/midas/plugin/APPluginInterfaceManager:initPluginInterface	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
              //   103: astore_3
              //   104: invokestatic 108	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
              //   107: aload_0
              //   108: getfield 22	com/tencent/midas/control/APMidasPayHelper$13:val$launchInterfaceName	Ljava/lang/String;
              //   111: ldc 110
              //   113: lload_1
              //   114: invokevirtual 114	com/tencent/midas/data/APPluginReportManager:insertTimeDataEx	(Ljava/lang/String;Ljava/lang/String;J)V
              //   117: aload_3
              //   118: astore 4
              //   120: aload_0
              //   121: getfield 26	com/tencent/midas/control/APMidasPayHelper$13:val$initCallback	Lcom/tencent/midas/control/IAPInitCallBack;
              //   124: ifnull +23 -> 147
              //   127: aload_0
              //   128: getfield 26	com/tencent/midas/control/APMidasPayHelper$13:val$initCallback	Lcom/tencent/midas/control/IAPInitCallBack;
              //   131: iconst_0
              //   132: ldc 116
              //   134: aload_0
              //   135: getfield 28	com/tencent/midas/control/APMidasPayHelper$13:val$from	Ljava/lang/String;
              //   138: aconst_null
              //   139: invokeinterface 122 5 0
              //   144: aload_3
              //   145: astore 4
              //   147: ldc 124
              //   149: ldc 126
              //   151: aload 4
              //   153: invokestatic 132	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
              //   156: invokevirtual 136	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
              //   159: invokestatic 141	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   162: invokestatic 108	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
              //   165: aload_0
              //   166: getfield 22	com/tencent/midas/control/APMidasPayHelper$13:val$launchInterfaceName	Ljava/lang/String;
              //   169: ldc 143
              //   171: invokevirtual 146	com/tencent/midas/data/APPluginReportManager:insertTimeData	(Ljava/lang/String;Ljava/lang/String;)V
              //   174: ldc 124
              //   176: ldc 148
              //   178: invokestatic 141	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
              //   181: iconst_1
              //   182: putstatic 152	com/tencent/midas/control/APMidasPayHelper:initState	I
              //   185: invokestatic 156	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
              //   188: astore_3
              //   189: aload_3
              //   190: monitorenter
              //   191: invokestatic 156	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
              //   194: invokevirtual 159	java/lang/Object:notifyAll	()V
              //   197: aload_3
              //   198: monitorexit
              //   199: ldc 36
              //   201: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   204: return
              //   205: astore 5
              //   207: aconst_null
              //   208: astore_3
              //   209: aload_3
              //   210: astore 4
              //   212: aload_0
              //   213: getfield 26	com/tencent/midas/control/APMidasPayHelper$13:val$initCallback	Lcom/tencent/midas/control/IAPInitCallBack;
              //   216: ifnull -69 -> 147
              //   219: aload_0
              //   220: getfield 26	com/tencent/midas/control/APMidasPayHelper$13:val$initCallback	Lcom/tencent/midas/control/IAPInitCallBack;
              //   223: bipush 254
              //   225: aload 5
              //   227: invokevirtual 165	java/lang/Exception:toString	()Ljava/lang/String;
              //   230: aload_0
              //   231: getfield 28	com/tencent/midas/control/APMidasPayHelper$13:val$from	Ljava/lang/String;
              //   234: aconst_null
              //   235: invokeinterface 122 5 0
              //   240: aload_3
              //   241: astore 4
              //   243: goto -96 -> 147
              //   246: astore 4
              //   248: aload_3
              //   249: monitorexit
              //   250: ldc 36
              //   252: invokestatic 162	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
              //   255: aload 4
              //   257: athrow
              //   258: astore 5
              //   260: goto -51 -> 209
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	263	0	this	13
              //   75	39	1	l	long
              //   70	172	4	localObject2	Object
              //   246	10	4	localObject3	Object
              //   205	21	5	localException1	Exception
              //   258	1	5	localException2	Exception
              // Exception table:
              //   from	to	target	type
              //   72	104	205	java/lang/Exception
              //   191	199	246	finally
              //   248	250	246	finally
              //   104	117	258	java/lang/Exception
              //   120	144	258	java/lang/Exception
            }
          });
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          APLog.e("APMidasPayHelper", "preLoadMidasPay preCreateClassLoaderByPath e: " + localException.toString());
        }
        initState = 1;
        synchronized (loadingObject)
        {
          loadingObject.notifyAll();
        }
      }
    }
  }
  
  private static void preLoadPlugin(Context paramContext, final String paramString, final IAPInitCallBack paramIAPInitCallBack)
  {
    AppMethodBeat.i(192979);
    synchronized (initObject)
    {
      initState = 0;
      paramContext = new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192941);
          APMidasPayHelper.access$1200(this.val$context, paramString, paramIAPInitCallBack);
          AppMethodBeat.o(192941);
        }
      });
      paramContext.setName(APPluginDataInterface.singleton().getLaunchInterface());
      paramContext.start();
      AppMethodBeat.o(192979);
      return;
    }
  }
  
  public static void release(Context arg0)
  {
    AppMethodBeat.i(192988);
    APLog.d("APMidasPayHelper", "release");
    APPluginInstallerAndUpdater.unInstallPlugin(???);
    synchronized (initObject)
    {
      initState = -1;
      AppMethodBeat.o(192988);
      return;
    }
  }
  
  public static void setEnv(String paramString)
  {
    AppMethodBeat.i(192958);
    String str = paramString;
    if (!"release".equals(paramString))
    {
      str = paramString;
      if (!"test".equals(paramString))
      {
        str = paramString;
        if (!"dev".equals(paramString))
        {
          str = paramString;
          if (!"debug".equals(paramString))
          {
            str = paramString;
            if (!"testing".equals(paramString)) {
              str = "release";
            }
          }
        }
      }
    }
    env = str;
    AppMethodBeat.o(192958);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    logEnable = paramBoolean;
  }
  
  private int toH5Midas(Activity paramActivity, android.webkit.WebView arg2, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(192976);
    APLog.i("APMidasPayHelper", "toH5Midas initState: " + initState);
    ProgressDialog localProgressDialog;
    int i;
    synchronized (initObject)
    {
      localProgressDialog = new ProgressDialog(paramActivity);
      localProgressDialog.setIndeterminate(false);
      localProgressDialog.setProgressStyle(0);
      localProgressDialog.setTitle("温馨提示");
      localProgressDialog.setMessage("腾讯支付服务初始化中");
      if (initState != -1)
      {
        i = initState;
        if (i != 0) {
          break label96;
        }
      }
    }
    try
    {
      localProgressDialog.show();
      label96:
      if (initState == -1) {
        preLoadPlugin(paramActivity, paramString4, null);
      }
      if (initState == 0)
      {
        new Thread(new APMidasPayHelper.10(this, localProgressDialog, paramActivity, paramString1, paramString2, paramString3)).start();
        AppMethodBeat.o(192976);
        return 0;
      }
      i = toH5MidasPay(paramActivity, paramString1, paramString2, paramString3);
      AppMethodBeat.o(192976);
      return i;
      paramActivity = finally;
      AppMethodBeat.o(192976);
      throw paramActivity;
    }
    catch (Throwable localThrowable)
    {
      break label96;
    }
  }
  
  private int toH5MidasPay(final Activity paramActivity, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(192977);
    synchronized (initObject)
    {
      if (initState == 2)
      {
        APLog.i("APMidasPayHelper", "toH5MidasPay plugin init error");
        pluginInitErrCallBack(paramActivity);
        initState = -1;
        AppMethodBeat.o(192977);
        return -1;
      }
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(192946);
          Intent localIntent = new Intent();
          localIntent.putExtra("version", APMidasPayAPI.getMidasPluginVersion());
          localIntent.putExtra("env", APMidasPayHelper.env);
          localIntent.putExtra("screenType", APMidasPayHelper.this.screenType);
          localIntent.putExtra("logEnable", APMidasPayHelper.logEnable);
          localIntent.putExtra("req", "H5Pay");
          localIntent.putExtra("url", paramString1);
          localIntent.putExtra("message", paramString2);
          localIntent.putExtra("reqType", APMidasPayHelper.netCallBack_ReqType);
          try
          {
            APMultiProcessData localAPMultiProcessData = APPluginDataInterface.singleton().getProcessData();
            if (localAPMultiProcessData != null)
            {
              localIntent.putExtra("launchPayGUID", localAPMultiProcessData.getGuid());
              localIntent.putExtra("launchPayTime", localAPMultiProcessData.getPayInterfaceTime());
              localIntent.putExtra("launchPayDataid", APDataId.getDataId());
              localIntent.putExtra("launchIntervalTime", localAPMultiProcessData.getIntervalTime());
            }
          }
          catch (Exception localException)
          {
            label152:
            break label152;
          }
          if (APMidasPayHelper.isNewProcess)
          {
            APMidasPayHelper.access$902(new APCallBackResultReceiver(new Handler()));
            APMidasPayHelper.remotRecevier.setReceiver(APMidasPayHelper.this);
            localIntent.putExtra("remoteReceiver", APMidasPayHelper.remotRecevier);
          }
          APMidasPayHelper.access$1000(APMidasPayHelper.this, paramActivity, localIntent, paramString3);
          AppMethodBeat.o(192946);
        }
      });
      AppMethodBeat.o(192977);
      return 0;
    }
  }
  
  private int toMidas(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192974);
    if (paramAPMidasBaseRequest == null)
    {
      APLog.w("APMidasPayHelper", "toMidas pay request is null");
      AppMethodBeat.o(192974);
      return -1;
    }
    requestObject = paramAPMidasBaseRequest;
    staticActivityContext = paramActivity;
    APLog.i("APMidasPayHelper", "ToMidas initState = " + initState);
    ProgressDialog localProgressDialog;
    long l;
    synchronized (initObject)
    {
      localProgressDialog = new ProgressDialog(paramActivity);
      localProgressDialog.setIndeterminate(false);
      localProgressDialog.setProgressStyle(0);
      localProgressDialog.setTitle("温馨提示");
      localProgressDialog.setMessage("腾讯支付服务初始化中");
      l = System.currentTimeMillis();
      boolean bool = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(paramActivity);
      isNeedLocalUpdate = bool;
      if (bool) {}
      synchronized (initObject)
      {
        initState = -1;
        if (((initState == -1) || (initState == 0)) && (!MED_DISTRIBUTE_NET.equals(paramString1)))
        {
          bool = MED_DISTRIBUTE_INFO.equals(paramString1);
          if (bool) {}
        }
      }
    }
    try
    {
      localProgressDialog.show();
      label182:
      if (initState == -1)
      {
        if (isNeedLocalUpdate) {
          release(paramActivity);
        }
        preLoadPlugin(paramActivity, paramString2, null);
      }
      if (initState == 0)
      {
        new Thread(new APMidasPayHelper.8(this, localProgressDialog, l, paramActivity, paramAPMidasBaseRequest, paramString1, paramString2)).start();
        AppMethodBeat.o(192974);
        return 0;
        paramActivity = finally;
        AppMethodBeat.o(192974);
        throw paramActivity;
        paramActivity = finally;
        AppMethodBeat.o(192974);
        throw paramActivity;
      }
      int i = toMidasPay(paramActivity, paramAPMidasBaseRequest, paramString1, paramString2);
      AppMethodBeat.o(192974);
      return i;
    }
    catch (Throwable localThrowable)
    {
      break label182;
    }
  }
  
  private int toMidasPay(final Activity paramActivity, final APMidasBaseRequest paramAPMidasBaseRequest, final String paramString1, String arg4)
  {
    AppMethodBeat.i(192975);
    synchronized (initObject)
    {
      if (initState == 2)
      {
        APLog.i("APMidasPayHelper", "toMidasPay plugin init error");
        pluginInitErrCallBack(paramActivity);
        initState = -1;
        AppMethodBeat.o(192975);
        return -1;
      }
      requestObject = paramAPMidasBaseRequest;
      staticActivityContext = paramActivity;
    }
    try
    {
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(192939);
          Intent localIntent = new Intent();
          localIntent.putExtra("version", APMidasPayAPI.getMidasPluginVersion());
          localIntent.putExtra("env", APMidasPayHelper.env);
          localIntent.putExtra("screenType", APMidasPayHelper.this.screenType);
          localIntent.putExtra("logEnable", APMidasPayHelper.logEnable);
          localIntent.putExtra("req", paramAPMidasBaseRequest);
          localIntent.putExtra("reqType", APMidasPayHelper.netCallBack_ReqType);
          localIntent.putExtra("method", paramString1);
          if (APMidasPayHelper.isNewProcess)
          {
            APMidasPayHelper.access$902(new APCallBackResultReceiver(new Handler()));
            APMidasPayHelper.remotRecevier.setReceiver(APMidasPayHelper.this);
            localIntent.putExtra("remoteReceiver", APMidasPayHelper.remotRecevier);
          }
          localIntent.putExtra("launchInterfaceName", APPluginDataInterface.singleton().getLaunchInterface());
          try
          {
            APMultiProcessData localAPMultiProcessData = APPluginDataInterface.singleton().getProcessData();
            if (localAPMultiProcessData != null)
            {
              localIntent.putExtra("launchPayGUID", localAPMultiProcessData.getGuid());
              localIntent.putExtra("launchPayTime", localAPMultiProcessData.getPayInterfaceTime());
              localIntent.putExtra("launchPayDataid", APDataId.getDataId());
              localIntent.putExtra("launchIntervalTime", localAPMultiProcessData.getIntervalTime());
            }
          }
          catch (Exception localException)
          {
            label200:
            break label200;
          }
          APMidasPayHelper.access$1000(APMidasPayHelper.this, paramActivity, localIntent, paramString1);
          AppMethodBeat.o(192939);
        }
      });
      label75:
      AppMethodBeat.o(192975);
      return 0;
      paramActivity = finally;
      AppMethodBeat.o(192975);
      throw paramActivity;
    }
    catch (Exception paramActivity)
    {
      break label75;
    }
  }
  
  private void waitingPluginReady(Context paramContext, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(192971);
    if (("test".equals(env)) && (initCount <= 0)) {
      Toast.makeText(paramContext, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
    }
    if (isNewProcess)
    {
      ??? = paramContext.getApplicationContext().getSharedPreferences("TencentUnipay", 4).edit();
      ((SharedPreferences.Editor)???).putString("launchpaycalling", "1");
      ((SharedPreferences.Editor)???).commit();
    }
    APLog.i("APMidasPayHelper", "ToMidas initState = " + initState);
    ProgressDialog localProgressDialog;
    long l;
    synchronized (initObject)
    {
      localProgressDialog = new ProgressDialog(paramContext);
      localProgressDialog.setIndeterminate(false);
      localProgressDialog.setProgressStyle(0);
      localProgressDialog.setTitle("温馨提示");
      localProgressDialog.setMessage("腾讯支付服务初始化中");
      l = System.currentTimeMillis();
      boolean bool = APPluginInstallerAndUpdater.isNeedUpdateFromLocal(paramContext);
      isNeedLocalUpdate = bool;
      if (bool) {}
      synchronized (initObject)
      {
        initState = -1;
        if (((initState == -1) || (initState == 0)) && (!MED_DISTRIBUTE_NET.equals("launchFunction")))
        {
          bool = MED_DISTRIBUTE_INFO.equals("launchFunction");
          if (bool) {}
        }
      }
    }
    try
    {
      localProgressDialog.show();
      label232:
      if (initState == -1)
      {
        if (isNeedLocalUpdate) {
          release(paramContext);
        }
        preLoadPlugin(paramContext, "launchFunction", null);
      }
      if (initState == 0) {
        new Thread(new APMidasPayHelper.6(this, localProgressDialog, l, paramResultReceiver)).start();
      }
      for (;;)
      {
        AppMethodBeat.o(192971);
        return;
        paramContext = finally;
        AppMethodBeat.o(192971);
        throw paramContext;
        paramContext = finally;
        AppMethodBeat.o(192971);
        throw paramContext;
        paramResultReceiver.send(0, new Bundle());
      }
    }
    catch (Throwable localThrowable)
    {
      break label232;
    }
  }
  
  public Object call(Activity paramActivity, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(192968);
    paramActivity = callWithContext(paramActivity, paramString, paramArrayOfObject);
    AppMethodBeat.o(192968);
    return paramActivity;
  }
  
  public Object call(Activity paramActivity, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(192969);
    paramActivity = callWithContext(paramActivity, paramString, paramArrayOfObject, paramArrayOfClass);
    AppMethodBeat.o(192969);
    return paramActivity;
  }
  
  public Object call(Context paramContext, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(192970);
    paramContext = callWithContext(paramContext, paramString, paramArrayOfObject, paramArrayOfClass);
    AppMethodBeat.o(192970);
    return paramContext;
  }
  
  public Object callWithContext(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(192972);
    Object localObject = null;
    try
    {
      paramContext = APPluginInterfaceManager.initPluginInterface(paramContext, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL, new Object[] { paramString, paramArrayOfObject });
      AppMethodBeat.o(192972);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        APLog.i("APMidasPayHelper", "callWithContext error:" + paramContext.toString());
        paramContext = localObject;
      }
    }
  }
  
  public Object callWithContext(final Context paramContext, final String paramString, final Object[] paramArrayOfObject, final Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(192973);
    synchronized (initObject)
    {
      APLog.i("callWithContext ", "initState:" + initState);
      if (initState == 0) {
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(192937);
            try
            {
              APLog.d("callWithContext ", "PLUGIN_INITING wait");
              synchronized (APMidasPayHelper.dexloadObject)
              {
                APMidasPayHelper.dexloadObject.wait();
                APLog.d("callWithContext ", "PLUGIN_INITING go");
                ((Activity)paramContext).runOnUiThread(new Runnable()
                {
                  public void run()
                  {
                    AppMethodBeat.i(192938);
                    try
                    {
                      APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface2(APMidasPayHelper.7.this.val$context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALL2, new Object[] { APMidasPayHelper.7.this.val$methodName, APMidasPayHelper.7.this.val$params, APMidasPayHelper.7.this.val$paramsType });
                      AppMethodBeat.o(192938);
                      return;
                    }
                    catch (Exception localException)
                    {
                      APLog.e("callWithContext", "error1 " + localException.toString());
                      AppMethodBeat.o(192938);
                    }
                  }
                });
                AppMethodBeat.o(192937);
                return;
              }
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              APLog.e("callWithContext", "error2 " + localInterruptedException.toString());
              AppMethodBeat.o(192937);
              return;
            }
            catch (Throwable localThrowable)
            {
              APLog.e("callWithContext", "error3 " + localThrowable.toString());
              AppMethodBeat.o(192937);
            }
          }
        }).start();
      }
      for (;;)
      {
        paramContext = this.retobj;
        AppMethodBeat.o(192973);
        return paramContext;
        try
        {
          this.retobj = APPluginInterfaceManager.initPluginInterface2(paramContext, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL2, new Object[] { paramString, paramArrayOfObject, paramArrayOfClass });
        }
        catch (Exception paramContext)
        {
          APLog.e("callWithContext", "error3 " + paramContext.toString());
        }
      }
    }
  }
  
  public int getInfo(Activity paramActivity, String paramString, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(192964);
    netCallBack = paramIAPMidasNetCallBack;
    netCallBack_ReqType = paramString;
    int i = toMidas(paramActivity, paramAPMidasBaseRequest, MED_DISTRIBUTE_INFO, "getInfo");
    AppMethodBeat.o(192964);
    return i;
  }
  
  public int h5Pay(Activity paramActivity, android.webkit.WebView paramWebView, com.tencent.smtt.sdk.WebView paramWebView1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192962);
    webview = paramWebView;
    x5Webview = paramWebView1;
    APLog.i("APMidasPayHelper", "h5Pay webview:" + webview + " x5Webview:" + x5Webview + " msg:" + paramString2);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("midas_js_bridge_")))
    {
      int i = toH5Midas(paramActivity, paramWebView, paramString1, paramString2, MED_DISTRIBUTE_H5PAY, "h5Pay");
      AppMethodBeat.o(192962);
      return i;
    }
    AppMethodBeat.o(192962);
    return -2;
  }
  
  public void launchWXMiniProgram(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(192965);
    call(paramContext, "launchWXMiniProgram", new Class[] { Context.class, Bundle.class, ResultReceiver.class }, new Object[] { paramContext, paramBundle, paramResultReceiver });
    AppMethodBeat.o(192965);
  }
  
  public void launchWXMiniProgram_OnResponse(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(192966);
    call(paramContext, "launchWXMiniProgram_OnResponse", new Class[] { Integer.TYPE, Bundle.class }, new Object[] { Integer.valueOf(paramInt), paramBundle });
    AppMethodBeat.o(192966);
  }
  
  public void launchWeb(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(192961);
    paramAPMidasBaseRequest = new Intent();
    paramAPMidasBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
    paramAPMidasBaseRequest = new com.tencent.mm.hellhoundlib.b.a().bl(paramAPMidasBaseRequest);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramAPMidasBaseRequest.axQ(), "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramAPMidasBaseRequest.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(192961);
  }
  
  public int net(Activity paramActivity, APMidasNetRequest paramAPMidasNetRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(192963);
    netCallBack = paramIAPMidasNetCallBack;
    netCallBack_ReqType = paramAPMidasNetRequest.reqType;
    int i = toMidas(paramActivity, paramAPMidasNetRequest, MED_DISTRIBUTE_NET, "net");
    AppMethodBeat.o(192963);
    return i;
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(192952);
    APLog.i("APMidasPayHelper", "remotRecevier payHelper resultCode:".concat(String.valueOf(paramInt)));
    if (paramInt == 0) {
      progressRemoteInfo(paramBundle);
    }
    AppMethodBeat.o(192952);
  }
  
  public int pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(192959);
    APLog.d("APMidasPayHelper", "Calling into pay, caller = " + Thread.currentThread().getStackTrace()[3].toString());
    if (("test".equals(env)) && (initCount <= 0)) {
      Toast.makeText(paramActivity, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
    }
    midasCallBack = paramIAPMidasPayCallBack;
    if (isNewProcess)
    {
      paramIAPMidasPayCallBack = paramActivity.getApplicationContext().getSharedPreferences("TencentUnipay", 4).edit();
      paramIAPMidasPayCallBack.putString("launchpaycalling", "1");
      paramIAPMidasPayCallBack.commit();
    }
    int i = toMidas(paramActivity, paramAPMidasBaseRequest, MED_DISTRIBUTE_PAY, "pay");
    AppMethodBeat.o(192959);
    return i;
  }
  
  public void progressRemoteInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(192953);
    Object localObject = paramBundle.getString("type");
    APLog.i("APMidasPayHelper", "progressRemoteInfo type:".concat(String.valueOf(localObject)));
    if ("callback".equals(localObject))
    {
      localObject = new APMidasResponse();
      ((APMidasResponse)localObject).resultCode = paramBundle.getInt("resultCode", -1);
      ((APMidasResponse)localObject).resultInerCode = paramBundle.getInt("resultInerCode");
      ((APMidasResponse)localObject).realSaveNum = paramBundle.getInt("realSaveNum");
      ((APMidasResponse)localObject).payChannel = paramBundle.getInt("payChannel");
      ((APMidasResponse)localObject).payState = paramBundle.getInt("payState");
      ((APMidasResponse)localObject).provideState = paramBundle.getInt("provideState");
      ((APMidasResponse)localObject).resultMsg = paramBundle.getString("resultMsg");
      ((APMidasResponse)localObject).extendInfo = paramBundle.getString("extendInfo");
      ((APMidasResponse)localObject).payReserve1 = paramBundle.getString("payReserve1");
      ((APMidasResponse)localObject).payReserve2 = paramBundle.getString("payReserve2");
      ((APMidasResponse)localObject).payReserve3 = paramBundle.getString("payReserve3");
      String str = paramBundle.getString("purchaseJson");
      paramBundle = paramBundle.getString("purchaseSign");
      try
      {
        paramBundle = new APPurchase(str, paramBundle);
        ((APMidasResponse)localObject).mAPPurchase = paramBundle;
        midasCallBack((APMidasResponse)localObject);
        AppMethodBeat.o(192953);
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          paramBundle = new APPurchase();
          APLog.w("progressRemoteInfo", "purchase creat fail1 " + localJSONException.toString());
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramBundle = new APPurchase();
          APLog.w("progressRemoteInfo", "purchase creat fail2 " + localException.toString());
        }
      }
    }
    if ("h5callback".equals(localObject))
    {
      midasH5CallBack(paramBundle.getString("callbackinfo"));
      AppMethodBeat.o(192953);
      return;
    }
    if ("needlogin".equals(localObject)) {
      midasLoginExpire();
    }
    AppMethodBeat.o(192953);
  }
  
  public void sendMidas(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(192967);
    waitingPluginReady(paramContext, new APMidasPayHelper.5(this, new Handler(Looper.getMainLooper()), paramContext, paramBundle, paramResultReceiver));
    AppMethodBeat.o(192967);
  }
  
  public void setScreenType(int paramInt)
  {
    this.screenType = paramInt;
  }
  
  public void web(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(192960);
    midasCallBack = paramIAPMidasPayCallBack;
    launchWeb(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
    AppMethodBeat.o(192960);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.midas.control.APMidasPayHelper
 * JD-Core Version:    0.7.0.1
 */