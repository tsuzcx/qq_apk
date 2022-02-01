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
  public static String MED_DISTRIBUTE_LongConnection;
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
  public static final String MIDAS_PLUGIN_VERSION = "1.7.9a";
  public static int MIDAS_WEBVIEW = 0;
  public static String PKG_DISTRIBUTE;
  public static final int PLUGIN_INITFAIL = 2;
  private static final int PLUGIN_INITIDLE = -1;
  public static final int PLUGIN_INITING = 0;
  public static final int PLUGIN_INITSUCC = 1;
  private static final int RET_CHANGE_H5 = -100011;
  private static final String RET_MSG_CHANGE_H5 = "needChangeH5";
  private static final String TAG = "APMidasPayHelper";
  public static boolean cutoutEnable;
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
  private static String logCallbackClassName;
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
    AppMethodBeat.i(217916);
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
    MED_DISTRIBUTE_LongConnection = "setLongConnection";
    MIDAS_WEBVIEW = 0;
    MIDAS_INNER_WEBVIEW = 0;
    MIDAS_OUT_WEBVIEW = 1;
    env = "release";
    logCallbackClassName = "";
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
    cutoutEnable = false;
    AppMethodBeat.o(217916);
  }
  
  public static String getJSContent(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(217647);
      APLog.i("APMidasPayHelper", "getJSContent");
      init(paramContext, null);
      paramContext = (String)new APMidasPayHelper().callWithContext(paramContext, "getH5JS", new Object[] { paramContext });
      AppMethodBeat.o(217647);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String getLogCallbackClassName()
  {
    return logCallbackClassName;
  }
  
  /* Error */
  public static void h5Init(Activity paramActivity, android.webkit.WebView paramWebView, com.tencent.smtt.sdk.WebView paramWebView1)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 333
    //   6: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 93
    //   11: ldc_w 334
    //   14: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_2
    //   18: putstatic 336	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   21: aload_1
    //   22: putstatic 338	com/tencent/midas/control/APMidasPayHelper:webview	Landroid/webkit/WebView;
    //   25: aload_0
    //   26: invokestatic 341	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   29: putstatic 240	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   32: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   35: ifgt +31 -> 66
    //   38: invokestatic 345	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   41: aload_0
    //   42: ldc_w 346
    //   45: new 24	com/tencent/midas/control/APMidasPayHelper$4
    //   48: dup
    //   49: aload_0
    //   50: invokespecial 349	com/tencent/midas/control/APMidasPayHelper$4:<init>	(Landroid/app/Activity;)V
    //   53: invokestatic 352	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   56: ldc_w 333
    //   59: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: ldc 2
    //   64: monitorexit
    //   65: return
    //   66: new 2	com/tencent/midas/control/APMidasPayHelper
    //   69: dup
    //   70: invokespecial 319	com/tencent/midas/control/APMidasPayHelper:<init>	()V
    //   73: aload_0
    //   74: ldc_w 321
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_0
    //   84: aastore
    //   85: invokevirtual 356	com/tencent/midas/control/APMidasPayHelper:call	(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   88: checkcast 327	java/lang/String
    //   91: astore_0
    //   92: aload_0
    //   93: invokestatic 362	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   96: istore_3
    //   97: iload_3
    //   98: ifne +86 -> 184
    //   101: getstatic 338	com/tencent/midas/control/APMidasPayHelper:webview	Landroid/webkit/WebView;
    //   104: ifnull +17 -> 121
    //   107: aload_1
    //   108: ldc_w 364
    //   111: aload_0
    //   112: invokestatic 368	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   115: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   118: invokevirtual 377	android/webkit/WebView:loadUrl	(Ljava/lang/String;)V
    //   121: getstatic 336	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   124: ifnull +19 -> 143
    //   127: getstatic 336	com/tencent/midas/control/APMidasPayHelper:x5Webview	Lcom/tencent/smtt/sdk/WebView;
    //   130: ldc_w 364
    //   133: aload_0
    //   134: invokestatic 368	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   140: invokevirtual 380	com/tencent/smtt/sdk/WebView:loadUrl	(Ljava/lang/String;)V
    //   143: ldc_w 333
    //   146: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: goto -87 -> 62
    //   152: astore_0
    //   153: ldc 2
    //   155: monitorexit
    //   156: aload_0
    //   157: athrow
    //   158: astore_0
    //   159: ldc 93
    //   161: new 382	java/lang/StringBuilder
    //   164: dup
    //   165: ldc_w 384
    //   168: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   171: aload_0
    //   172: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   175: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 397	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: ldc_w 333
    //   187: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  public static void h5InitUnifier(Activity paramActivity, IAPWebView paramIAPWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 400
    //   6: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 93
    //   11: ldc_w 401
    //   14: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aload_1
    //   18: putstatic 403	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   21: aload_0
    //   22: invokestatic 341	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   25: putstatic 240	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   28: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   31: ifgt +31 -> 62
    //   34: invokestatic 345	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   37: aload_0
    //   38: ldc_w 346
    //   41: new 22	com/tencent/midas/control/APMidasPayHelper$3
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 404	com/tencent/midas/control/APMidasPayHelper$3:<init>	(Landroid/app/Activity;)V
    //   49: invokestatic 352	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   52: ldc_w 400
    //   55: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: ldc 2
    //   60: monitorexit
    //   61: return
    //   62: new 2	com/tencent/midas/control/APMidasPayHelper
    //   65: dup
    //   66: invokespecial 319	com/tencent/midas/control/APMidasPayHelper:<init>	()V
    //   69: aload_0
    //   70: ldc_w 321
    //   73: iconst_1
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: aload_0
    //   80: aastore
    //   81: invokevirtual 356	com/tencent/midas/control/APMidasPayHelper:call	(Landroid/app/Activity;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   84: checkcast 327	java/lang/String
    //   87: astore_0
    //   88: aload_0
    //   89: invokestatic 362	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: istore_2
    //   93: iload_2
    //   94: ifne +68 -> 162
    //   97: getstatic 403	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   100: ifnull +21 -> 121
    //   103: getstatic 403	com/tencent/midas/control/APMidasPayHelper:sIWebView	Lcom/tencent/midas/api/IAPWebView;
    //   106: ldc_w 364
    //   109: aload_0
    //   110: invokestatic 368	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual 371	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   116: invokeinterface 407 2 0
    //   121: ldc_w 400
    //   124: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: goto -69 -> 58
    //   130: astore_0
    //   131: ldc 2
    //   133: monitorexit
    //   134: aload_0
    //   135: athrow
    //   136: astore_0
    //   137: ldc 93
    //   139: new 382	java/lang/StringBuilder
    //   142: dup
    //   143: ldc_w 409
    //   146: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   149: aload_0
    //   150: invokevirtual 389	java/lang/Exception:toString	()Ljava/lang/String;
    //   153: invokevirtual 393	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 397	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: ldc_w 400
    //   165: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void init(Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest)
  {
    try
    {
      AppMethodBeat.i(217613);
      init(paramContext, paramAPMidasBaseRequest, null);
      AppMethodBeat.o(217613);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  public static void init(final Context paramContext, APMidasBaseRequest paramAPMidasBaseRequest, ResultReceiver paramResultReceiver)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 414
    //   6: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: ldc 93
    //   11: new 382	java/lang/StringBuilder
    //   14: dup
    //   15: ldc_w 416
    //   18: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   21: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   24: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload_0
    //   34: invokestatic 341	com/tencent/midas/control/APMidasPayHelper:isNewProcess	(Landroid/content/Context;)Z
    //   37: putstatic 240	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   40: aload_1
    //   41: putstatic 234	com/tencent/midas/control/APMidasPayHelper:initRequest	Lcom/tencent/midas/api/request/APMidasBaseRequest;
    //   44: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   47: ifgt +53 -> 100
    //   50: getstatic 232	com/tencent/midas/control/APMidasPayHelper:isInitSucc	Z
    //   53: ifne +47 -> 100
    //   56: invokestatic 345	com/tencent/midas/plugin/APPluginUtils:release	()V
    //   59: aload_0
    //   60: ldc_w 346
    //   63: new 8	com/tencent/midas/control/APMidasPayHelper$1
    //   66: dup
    //   67: invokespecial 420	com/tencent/midas/control/APMidasPayHelper$1:<init>	()V
    //   70: invokestatic 352	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   73: invokestatic 426	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   76: ldc_w 346
    //   79: invokevirtual 429	com/tencent/midas/data/APPluginReportManager:dataReport	(Ljava/lang/String;)V
    //   82: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   85: iconst_1
    //   86: iadd
    //   87: putstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   90: ldc_w 414
    //   93: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: getstatic 232	com/tencent/midas/control/APMidasPayHelper:isInitSucc	Z
    //   103: ifeq -30 -> 73
    //   106: aload_0
    //   107: checkcast 431	android/app/Activity
    //   110: new 20	com/tencent/midas/control/APMidasPayHelper$2
    //   113: dup
    //   114: aload_2
    //   115: aload_0
    //   116: invokespecial 434	com/tencent/midas/control/APMidasPayHelper$2:<init>	(Landroid/os/ResultReceiver;Landroid/content/Context;)V
    //   119: invokevirtual 438	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   122: goto -49 -> 73
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramContext	Context
    //   0	131	1	paramAPMidasBaseRequest	APMidasBaseRequest
    //   0	131	2	paramResultReceiver	ResultReceiver
    // Exception table:
    //   from	to	target	type
    //   3	73	125	finally
    //   73	96	125	finally
    //   100	122	125	finally
  }
  
  public static boolean isLogEnable()
  {
    return logEnable;
  }
  
  public static boolean isNewProcess(Context paramContext)
  {
    AppMethodBeat.i(217845);
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
              AppMethodBeat.o(217845);
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
      AppMethodBeat.o(217845);
    }
  }
  
  public static void midasCallBack(APMidasResponse paramAPMidasResponse)
  {
    AppMethodBeat.i(217780);
    if ((paramAPMidasResponse != null) && (paramAPMidasResponse.resultCode == -100011) && ("needChangeH5".equals(paramAPMidasResponse.resultMsg)) && (APWebJSBridgeActivity.startPureH5Pay(staticActivityContext, "", "change_h5_from_cgi")))
    {
      staticActivityContext = null;
      AppMethodBeat.o(217780);
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
    AppMethodBeat.o(217780);
  }
  
  public static void midasH5CallBack(String paramString)
  {
    AppMethodBeat.i(217796);
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
        AppMethodBeat.o(217796);
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
    AppMethodBeat.i(217788);
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
    AppMethodBeat.o(217788);
  }
  
  public static void onNetError(String paramString1, Integer paramInteger, String paramString2)
  {
    AppMethodBeat.i(217807);
    if (netCallBack != null)
    {
      netCallBack.MidasNetError(paramString1, paramInteger.intValue(), paramString2);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(217807);
  }
  
  public static void onNetFinish(String paramString1, String paramString2)
  {
    AppMethodBeat.i(217823);
    if (netCallBack != null)
    {
      netCallBack.MidasNetFinish(paramString1, paramString2);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(217823);
  }
  
  public static void onNetStop(String paramString)
  {
    AppMethodBeat.i(217817);
    if (netCallBack != null)
    {
      netCallBack.MidasNetStop(paramString);
      netCallBack = null;
      netCallBack_ReqType = "";
    }
    staticActivityContext = null;
    AppMethodBeat.o(217817);
  }
  
  private void openPlugin(Activity paramActivity, Intent paramIntent, String paramString)
  {
    AppMethodBeat.i(217743);
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
          AppMethodBeat.o(217743);
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
    AppMethodBeat.i(217831);
    APLog.i("APMidasPayHelper", "pluginInitErrCallBack" + midasCallBack);
    if (APWebJSBridgeActivity.startPureH5Pay(paramActivity, APPluginUtils.getInitErrorMsg(), "pluginInitErrCallBack"))
    {
      AppMethodBeat.o(217831);
      return;
    }
    paramActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(217593);
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
        AppMethodBeat.o(217593);
      }
    });
    AppMethodBeat.o(217831);
  }
  
  private static void preLoadMidasPay(Context arg0, final String paramString, final IAPInitCallBack paramIAPInitCallBack)
  {
    int i = 0;
    AppMethodBeat.i(217770);
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
      int j = APPluginInstallerAndUpdater.isNeedUpdateFromAssets(???, env);
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
        break label261;
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
        label261:
        boolean bool;
        AppMethodBeat.o(217770);
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
    AppMethodBeat.i(217751);
    synchronized (initObject)
    {
      initState = 0;
      paramContext = new Thread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(217582);
          APMidasPayHelper.access$1200(this.val$context, paramString, paramIAPInitCallBack);
          AppMethodBeat.o(217582);
        }
      });
      paramContext.setName(APPluginDataInterface.singleton().getLaunchInterface());
      paramContext.start();
      AppMethodBeat.o(217751);
      return;
    }
  }
  
  public static void release(Context arg0)
  {
    AppMethodBeat.i(217837);
    APLog.d("APMidasPayHelper", "release");
    APPluginInstallerAndUpdater.unInstallPlugin(???);
    synchronized (initObject)
    {
      initState = -1;
      AppMethodBeat.o(217837);
      return;
    }
  }
  
  public static void setEnv(String paramString)
  {
    AppMethodBeat.i(217655);
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
    AppMethodBeat.o(217655);
  }
  
  public static void setLogCallbackClassName(String paramString)
  {
    logCallbackClassName = paramString;
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    logEnable = paramBoolean;
  }
  
  public static void setLongConnection(Context paramContext, boolean paramBoolean)
  {
    try
    {
      AppMethodBeat.i(217627);
      APLog.i("APMidasPayHelper", "setLongConnection to open = ".concat(String.valueOf(paramBoolean)));
      Intent localIntent = new Intent();
      localIntent.putExtra("version", "1.7.9a");
      localIntent.putExtra("env", env);
      localIntent.putExtra("logEnable", logEnable);
      localIntent.putExtra("openLongConnection", paramBoolean);
      localIntent.putExtra("launchInterfaceName", Thread.currentThread().getName());
      try
      {
        APPluginInterfaceManager.initPluginInterface(paramContext, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_LongConnection, new Object[] { paramContext, localIntent });
        AppMethodBeat.o(217627);
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          APLog.i("APMidasPayHelper", "initcallback isInitSucc direct call init function e:" + paramContext.toString());
          AppMethodBeat.o(217627);
        }
      }
      return;
    }
    finally {}
  }
  
  private int toH5Midas(final Activity paramActivity, android.webkit.WebView arg2, final String paramString1, final String paramString2, final String paramString3, String paramString4)
  {
    AppMethodBeat.i(217720);
    APLog.i("APMidasPayHelper", "toH5Midas initState: " + initState);
    final ProgressDialog localProgressDialog;
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
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: ldc 43
            //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: invokestatic 53	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
            //   8: astore_1
            //   9: aload_1
            //   10: monitorenter
            //   11: invokestatic 53	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
            //   14: invokevirtual 56	java/lang/Object:wait	()V
            //   17: aload_1
            //   18: monitorexit
            //   19: aload_0
            //   20: getfield 27	com/tencent/midas/control/APMidasPayHelper$10:val$progressDialog	Landroid/app/ProgressDialog;
            //   23: invokevirtual 62	android/app/ProgressDialog:isShowing	()Z
            //   26: ifeq +10 -> 36
            //   29: aload_0
            //   30: getfield 27	com/tencent/midas/control/APMidasPayHelper$10:val$progressDialog	Landroid/app/ProgressDialog;
            //   33: invokevirtual 65	android/app/ProgressDialog:dismiss	()V
            //   36: aload_0
            //   37: getfield 25	com/tencent/midas/control/APMidasPayHelper$10:this$0	Lcom/tencent/midas/control/APMidasPayHelper;
            //   40: aload_0
            //   41: getfield 29	com/tencent/midas/control/APMidasPayHelper$10:val$activity	Landroid/app/Activity;
            //   44: aload_0
            //   45: getfield 31	com/tencent/midas/control/APMidasPayHelper$10:val$url	Ljava/lang/String;
            //   48: aload_0
            //   49: getfield 33	com/tencent/midas/control/APMidasPayHelper$10:val$message	Ljava/lang/String;
            //   52: aload_0
            //   53: getfield 35	com/tencent/midas/control/APMidasPayHelper$10:val$toMethod	Ljava/lang/String;
            //   56: invokestatic 69	com/tencent/midas/control/APMidasPayHelper:access$1100	(Lcom/tencent/midas/control/APMidasPayHelper;Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
            //   59: pop
            //   60: ldc 43
            //   62: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   65: return
            //   66: astore_2
            //   67: aload_1
            //   68: monitorexit
            //   69: ldc 43
            //   71: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   74: aload_2
            //   75: athrow
            //   76: astore_1
            //   77: ldc 74
            //   79: new 76	java/lang/StringBuilder
            //   82: dup
            //   83: ldc 78
            //   85: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
            //   88: aload_1
            //   89: invokevirtual 85	java/lang/InterruptedException:toString	()Ljava/lang/String;
            //   92: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
            //   95: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
            //   98: invokestatic 96	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
            //   101: goto -82 -> 19
            //   104: astore_1
            //   105: goto -69 -> 36
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	108	0	this	10
            //   8	60	1	localObject1	Object
            //   76	13	1	localInterruptedException	InterruptedException
            //   104	1	1	localObject2	Object
            //   66	9	2	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   11	19	66	finally
            //   5	11	76	java/lang/InterruptedException
            //   67	76	76	java/lang/InterruptedException
            //   19	36	104	finally
          }
        }).start();
        AppMethodBeat.o(217720);
        return 0;
      }
      i = toH5MidasPay(paramActivity, paramString1, paramString2, paramString3);
      AppMethodBeat.o(217720);
      return i;
      paramActivity = finally;
      AppMethodBeat.o(217720);
      throw paramActivity;
    }
    finally {}
  }
  
  private int toH5MidasPay(final Activity paramActivity, final String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(217731);
    synchronized (initObject)
    {
      if (initState == 2)
      {
        APLog.i("APMidasPayHelper", "toH5MidasPay plugin init error");
        pluginInitErrCallBack(paramActivity);
        initState = -1;
        AppMethodBeat.o(217731);
        return -1;
      }
      paramActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(217588);
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
          AppMethodBeat.o(217588);
        }
      });
      AppMethodBeat.o(217731);
      return 0;
    }
  }
  
  private int toMidas(Activity paramActivity, final APMidasBaseRequest paramAPMidasBaseRequest, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(217700);
    if (paramAPMidasBaseRequest == null)
    {
      APLog.w("APMidasPayHelper", "toMidas pay request is null");
      AppMethodBeat.o(217700);
      return -1;
    }
    requestObject = paramAPMidasBaseRequest;
    staticActivityContext = paramActivity;
    APLog.i("APMidasPayHelper", "ToMidas initState = " + initState);
    final ProgressDialog localProgressDialog;
    final long l;
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
        new Thread(new Runnable()
        {
          /* Error */
          public void run()
          {
            // Byte code:
            //   0: ldc 48
            //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: invokestatic 58	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
            //   8: astore_1
            //   9: aload_1
            //   10: monitorenter
            //   11: invokestatic 58	com/tencent/midas/control/APMidasPayHelper:access$600	()Ljava/lang/Object;
            //   14: invokevirtual 61	java/lang/Object:wait	()V
            //   17: aload_1
            //   18: monitorexit
            //   19: aload_0
            //   20: getfield 30	com/tencent/midas/control/APMidasPayHelper$8:val$progressDialog	Landroid/app/ProgressDialog;
            //   23: invokevirtual 67	android/app/ProgressDialog:isShowing	()Z
            //   26: ifeq +10 -> 36
            //   29: aload_0
            //   30: getfield 30	com/tencent/midas/control/APMidasPayHelper$8:val$progressDialog	Landroid/app/ProgressDialog;
            //   33: invokevirtual 70	android/app/ProgressDialog:dismiss	()V
            //   36: invokestatic 76	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
            //   39: invokestatic 82	java/lang/Thread:currentThread	()Ljava/lang/Thread;
            //   42: invokestatic 88	com/pay/tool/APMidasTools:getCurrentThreadName	(Ljava/lang/Thread;)Ljava/lang/String;
            //   45: ldc 90
            //   47: aload_0
            //   48: getfield 32	com/tencent/midas/control/APMidasPayHelper$8:val$startTime	J
            //   51: invokevirtual 94	com/tencent/midas/data/APPluginReportManager:insertTimeDataEx	(Ljava/lang/String;Ljava/lang/String;J)V
            //   54: aload_0
            //   55: getfield 28	com/tencent/midas/control/APMidasPayHelper$8:this$0	Lcom/tencent/midas/control/APMidasPayHelper;
            //   58: aload_0
            //   59: getfield 34	com/tencent/midas/control/APMidasPayHelper$8:val$activity	Landroid/app/Activity;
            //   62: aload_0
            //   63: getfield 36	com/tencent/midas/control/APMidasPayHelper$8:val$request	Lcom/tencent/midas/api/request/APMidasBaseRequest;
            //   66: aload_0
            //   67: getfield 38	com/tencent/midas/control/APMidasPayHelper$8:val$toMethod	Ljava/lang/String;
            //   70: aload_0
            //   71: getfield 40	com/tencent/midas/control/APMidasPayHelper$8:val$fromMethod	Ljava/lang/String;
            //   74: invokestatic 98	com/tencent/midas/control/APMidasPayHelper:access$700	(Lcom/tencent/midas/control/APMidasPayHelper;Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Ljava/lang/String;Ljava/lang/String;)I
            //   77: pop
            //   78: ldc 48
            //   80: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   83: return
            //   84: astore_2
            //   85: aload_1
            //   86: monitorexit
            //   87: ldc 48
            //   89: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   92: aload_2
            //   93: athrow
            //   94: astore_1
            //   95: ldc 103
            //   97: aload_1
            //   98: invokevirtual 107	java/lang/InterruptedException:toString	()Ljava/lang/String;
            //   101: invokestatic 113	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
            //   104: goto -85 -> 19
            //   107: astore_1
            //   108: goto -72 -> 36
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	111	0	this	8
            //   8	78	1	localObject1	Object
            //   94	4	1	localInterruptedException	InterruptedException
            //   107	1	1	localObject2	Object
            //   84	9	2	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   11	19	84	finally
            //   5	11	94	java/lang/InterruptedException
            //   85	94	94	java/lang/InterruptedException
            //   19	36	107	finally
          }
        }).start();
        AppMethodBeat.o(217700);
        return 0;
        paramActivity = finally;
        AppMethodBeat.o(217700);
        throw paramActivity;
        paramActivity = finally;
        AppMethodBeat.o(217700);
        throw paramActivity;
      }
      int i = toMidasPay(paramActivity, paramAPMidasBaseRequest, paramString1, paramString2);
      AppMethodBeat.o(217700);
      return i;
    }
    finally
    {
      break label182;
    }
  }
  
  private int toMidasPay(final Activity paramActivity, final APMidasBaseRequest paramAPMidasBaseRequest, final String paramString1, String arg4)
  {
    AppMethodBeat.i(217709);
    synchronized (initObject)
    {
      if (initState == 2)
      {
        APLog.i("APMidasPayHelper", "toMidasPay plugin init error");
        pluginInitErrCallBack(paramActivity);
        initState = -1;
        AppMethodBeat.o(217709);
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
          AppMethodBeat.i(217559);
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
          AppMethodBeat.o(217559);
        }
      });
      label75:
      AppMethodBeat.o(217709);
      return 0;
      paramActivity = finally;
      AppMethodBeat.o(217709);
      throw paramActivity;
    }
    catch (Exception paramActivity)
    {
      break label75;
    }
  }
  
  /* Error */
  private void waitingPluginReady(Context paramContext, ResultReceiver paramResultReceiver)
  {
    // Byte code:
    //   0: ldc_w 825
    //   3: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 726
    //   9: getstatic 207	com/tencent/midas/control/APMidasPayHelper:env	Ljava/lang/String;
    //   12: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +20 -> 35
    //   18: getstatic 219	com/tencent/midas/control/APMidasPayHelper:initCount	I
    //   21: ifgt +14 -> 35
    //   24: aload_1
    //   25: ldc_w 827
    //   28: iconst_1
    //   29: invokestatic 833	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   32: invokevirtual 834	android/widget/Toast:show	()V
    //   35: getstatic 240	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   38: ifeq +43 -> 81
    //   41: aload_1
    //   42: invokevirtual 446	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   45: ldc_w 836
    //   48: iconst_4
    //   49: invokevirtual 840	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   52: invokeinterface 846 1 0
    //   57: astore 6
    //   59: aload 6
    //   61: ldc_w 848
    //   64: ldc_w 850
    //   67: invokeinterface 856 3 0
    //   72: pop
    //   73: aload 6
    //   75: invokeinterface 859 1 0
    //   80: pop
    //   81: ldc 93
    //   83: new 382	java/lang/StringBuilder
    //   86: dup
    //   87: ldc_w 808
    //   90: invokespecial 386	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   93: getstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   96: invokevirtual 419	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 394	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 314	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: getstatic 226	com/tencent/midas/control/APMidasPayHelper:initObject	Ljava/lang/Object;
    //   108: astore 6
    //   110: aload 6
    //   112: monitorenter
    //   113: new 769	android/app/ProgressDialog
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 771	android/app/ProgressDialog:<init>	(Landroid/content/Context;)V
    //   121: astore 7
    //   123: aload 7
    //   125: iconst_0
    //   126: invokevirtual 774	android/app/ProgressDialog:setIndeterminate	(Z)V
    //   129: aload 7
    //   131: iconst_0
    //   132: invokevirtual 777	android/app/ProgressDialog:setProgressStyle	(I)V
    //   135: aload 7
    //   137: ldc_w 779
    //   140: invokevirtual 783	android/app/ProgressDialog:setTitle	(Ljava/lang/CharSequence;)V
    //   143: aload 7
    //   145: ldc_w 785
    //   148: invokevirtual 788	android/app/ProgressDialog:setMessage	(Ljava/lang/CharSequence;)V
    //   151: invokestatic 625	java/lang/System:currentTimeMillis	()J
    //   154: lstore_3
    //   155: aload_1
    //   156: invokestatic 811	com/tencent/midas/plugin/APPluginInstallerAndUpdater:isNeedUpdateFromLocal	(Landroid/content/Context;)Z
    //   159: istore 5
    //   161: iload 5
    //   163: putstatic 236	com/tencent/midas/control/APMidasPayHelper:isNeedLocalUpdate	Z
    //   166: iload 5
    //   168: ifeq +18 -> 186
    //   171: getstatic 226	com/tencent/midas/control/APMidasPayHelper:initObject	Ljava/lang/Object;
    //   174: astore 8
    //   176: aload 8
    //   178: monitorenter
    //   179: iconst_m1
    //   180: putstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   183: aload 8
    //   185: monitorexit
    //   186: getstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   189: iconst_m1
    //   190: if_icmpeq +9 -> 199
    //   193: getstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   196: ifne +36 -> 232
    //   199: getstatic 163	com/tencent/midas/control/APMidasPayHelper:MED_DISTRIBUTE_NET	Ljava/lang/String;
    //   202: ldc_w 861
    //   205: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   208: ifne +24 -> 232
    //   211: getstatic 167	com/tencent/midas/control/APMidasPayHelper:MED_DISTRIBUTE_INFO	Ljava/lang/String;
    //   214: ldc_w 861
    //   217: invokevirtual 479	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   220: istore 5
    //   222: iload 5
    //   224: ifne +8 -> 232
    //   227: aload 7
    //   229: invokevirtual 791	android/app/ProgressDialog:show	()V
    //   232: getstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   235: iconst_m1
    //   236: if_icmpne +21 -> 257
    //   239: getstatic 236	com/tencent/midas/control/APMidasPayHelper:isNeedLocalUpdate	Z
    //   242: ifeq +7 -> 249
    //   245: aload_1
    //   246: invokestatic 813	com/tencent/midas/control/APMidasPayHelper:release	(Landroid/content/Context;)V
    //   249: aload_1
    //   250: ldc_w 861
    //   253: aconst_null
    //   254: invokestatic 352	com/tencent/midas/control/APMidasPayHelper:preLoadPlugin	(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/midas/control/IAPInitCallBack;)V
    //   257: getstatic 221	com/tencent/midas/control/APMidasPayHelper:initState	I
    //   260: ifne +59 -> 319
    //   263: new 574	java/lang/Thread
    //   266: dup
    //   267: new 28	com/tencent/midas/control/APMidasPayHelper$6
    //   270: dup
    //   271: aload_0
    //   272: aload 7
    //   274: lload_3
    //   275: aload_2
    //   276: invokespecial 864	com/tencent/midas/control/APMidasPayHelper$6:<init>	(Lcom/tencent/midas/control/APMidasPayHelper;Landroid/app/ProgressDialog;JLandroid/os/ResultReceiver;)V
    //   279: invokespecial 715	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   282: invokevirtual 721	java/lang/Thread:start	()V
    //   285: aload 6
    //   287: monitorexit
    //   288: ldc_w 825
    //   291: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   294: return
    //   295: astore_1
    //   296: aload 8
    //   298: monitorexit
    //   299: ldc_w 825
    //   302: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aload_1
    //   306: athrow
    //   307: astore_1
    //   308: aload 6
    //   310: monitorexit
    //   311: ldc_w 825
    //   314: invokestatic 249	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: aload_1
    //   318: athrow
    //   319: aload_2
    //   320: iconst_0
    //   321: new 866	android/os/Bundle
    //   324: dup
    //   325: invokespecial 867	android/os/Bundle:<init>	()V
    //   328: invokevirtual 873	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   331: goto -46 -> 285
    //   334: astore 8
    //   336: goto -104 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	APMidasPayHelper
    //   0	339	1	paramContext	Context
    //   0	339	2	paramResultReceiver	ResultReceiver
    //   154	121	3	l	long
    //   159	64	5	bool	boolean
    //   57	252	6	localObject1	Object
    //   121	152	7	localProgressDialog	ProgressDialog
    //   174	123	8	localObject2	Object
    //   334	1	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   179	186	295	finally
    //   113	166	307	finally
    //   171	179	307	finally
    //   186	199	307	finally
    //   199	222	307	finally
    //   232	249	307	finally
    //   249	257	307	finally
    //   257	285	307	finally
    //   285	288	307	finally
    //   296	307	307	finally
    //   319	331	307	finally
    //   227	232	334	finally
  }
  
  public Object call(Activity paramActivity, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(217960);
    paramActivity = callWithContext(paramActivity, paramString, paramArrayOfObject);
    AppMethodBeat.o(217960);
    return paramActivity;
  }
  
  public Object call(Activity paramActivity, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    AppMethodBeat.i(217963);
    paramActivity = callWithContext(paramActivity, paramString, paramArrayOfObject, paramArrayOfClass);
    AppMethodBeat.o(217963);
    return paramActivity;
  }
  
  public Object call(Context paramContext, String paramString, Class<?>[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(217968);
    paramContext = callWithContext(paramContext, paramString, paramArrayOfObject, paramArrayOfClass);
    AppMethodBeat.o(217968);
    return paramContext;
  }
  
  public Object callWithContext(Context paramContext, String paramString, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(217971);
    Object localObject = null;
    try
    {
      paramContext = APPluginInterfaceManager.initPluginInterface(paramContext, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL, new Object[] { paramString, paramArrayOfObject });
      AppMethodBeat.o(217971);
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
    AppMethodBeat.i(217974);
    synchronized (initObject)
    {
      APLog.i("callWithContext ", "initState:" + initState);
      if (initState == 0) {
        new Thread(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(217551);
            try
            {
              APLog.d("callWithContext ", "PLUGIN_INITING wait");
              synchronized (APMidasPayHelper.dexloadObject)
              {
                APMidasPayHelper.dexloadObject.wait();
                APLog.d("callWithContext ", "PLUGIN_INITING go");
                new Handler(Looper.getMainLooper()).post(new Runnable()
                {
                  public void run()
                  {
                    AppMethodBeat.i(217607);
                    try
                    {
                      APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface2(APMidasPayHelper.7.this.val$context, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_CALL2, new Object[] { APMidasPayHelper.7.this.val$methodName, APMidasPayHelper.7.this.val$params, APMidasPayHelper.7.this.val$paramsType });
                      AppMethodBeat.o(217607);
                      return;
                    }
                    catch (Exception localException)
                    {
                      APLog.e("callWithContext", "error1 " + localException.toString());
                      AppMethodBeat.o(217607);
                    }
                  }
                });
                AppMethodBeat.o(217551);
                return;
              }
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              return;
            }
            catch (Exception localException)
            {
              return;
            }
            finally
            {
              APLog.e("callWithContext", "error4 " + localObject2.toString());
              AppMethodBeat.o(217551);
            }
          }
        }).start();
      }
      for (;;)
      {
        paramContext = this.retobj;
        AppMethodBeat.o(217974);
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
    AppMethodBeat.i(217952);
    netCallBack = paramIAPMidasNetCallBack;
    netCallBack_ReqType = paramString;
    int i = toMidas(paramActivity, paramAPMidasBaseRequest, MED_DISTRIBUTE_INFO, "getInfo");
    AppMethodBeat.o(217952);
    return i;
  }
  
  public int h5Pay(Activity paramActivity, android.webkit.WebView paramWebView, com.tencent.smtt.sdk.WebView paramWebView1, String paramString1, String paramString2)
  {
    AppMethodBeat.i(217948);
    webview = paramWebView;
    x5Webview = paramWebView1;
    APLog.i("APMidasPayHelper", "h5Pay webview:" + webview + " x5Webview:" + x5Webview + " msg:" + paramString2);
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.startsWith("midas_js_bridge_")))
    {
      int i = toH5Midas(paramActivity, paramWebView, paramString1, paramString2, MED_DISTRIBUTE_H5PAY, "h5Pay");
      AppMethodBeat.o(217948);
      return i;
    }
    AppMethodBeat.o(217948);
    return -2;
  }
  
  public void launchWXMiniProgram(Context paramContext, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217955);
    call(paramContext, "launchWXMiniProgram", new Class[] { Context.class, Bundle.class, ResultReceiver.class }, new Object[] { paramContext, paramBundle, paramResultReceiver });
    AppMethodBeat.o(217955);
  }
  
  public void launchWXMiniProgram_OnResponse(Context paramContext, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(217957);
    call(paramContext, "launchWXMiniProgram_OnResponse", new Class[] { Integer.TYPE, Bundle.class }, new Object[] { Integer.valueOf(paramInt), paramBundle });
    AppMethodBeat.o(217957);
  }
  
  public void launchWeb(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(217944);
    paramAPMidasBaseRequest = new Intent();
    paramAPMidasBaseRequest.setClass(paramActivity, APWebJSBridgeActivity.class);
    paramAPMidasBaseRequest = new com.tencent.mm.hellhoundlib.b.a().cG(paramAPMidasBaseRequest);
    com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramAPMidasBaseRequest.aYi(), "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramActivity.startActivity((Intent)paramAPMidasBaseRequest.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/midas/control/APMidasPayHelper", "launchWeb", "(Landroid/app/Activity;Lcom/tencent/midas/api/request/APMidasBaseRequest;Lcom/tencent/midas/api/IAPMidasPayCallBack;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(217944);
  }
  
  public int net(Activity paramActivity, APMidasNetRequest paramAPMidasNetRequest, IAPMidasNetCallBack paramIAPMidasNetCallBack)
  {
    AppMethodBeat.i(217951);
    netCallBack = paramIAPMidasNetCallBack;
    netCallBack_ReqType = paramAPMidasNetRequest.reqType;
    int i = toMidas(paramActivity, paramAPMidasNetRequest, MED_DISTRIBUTE_NET, "net");
    AppMethodBeat.o(217951);
    return i;
  }
  
  public void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(217919);
    APLog.i("APMidasPayHelper", "remotRecevier payHelper resultCode:".concat(String.valueOf(paramInt)));
    if (paramInt == 0) {
      progressRemoteInfo(paramBundle);
    }
    AppMethodBeat.o(217919);
  }
  
  public int pay(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(217936);
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
    AppMethodBeat.o(217936);
    return i;
  }
  
  public void progressRemoteInfo(Bundle paramBundle)
  {
    AppMethodBeat.i(217926);
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
        AppMethodBeat.o(217926);
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
      AppMethodBeat.o(217926);
      return;
    }
    if ("needlogin".equals(localObject)) {
      midasLoginExpire();
    }
    AppMethodBeat.o(217926);
  }
  
  public void sendMidas(final Context paramContext, final Bundle paramBundle, final ResultReceiver paramResultReceiver)
  {
    AppMethodBeat.i(217958);
    waitingPluginReady(paramContext, new ResultReceiver(new Handler(Looper.getMainLooper()))
    {
      protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217534);
        if (paramAnonymousInt == 0) {
          try
          {
            APMidasPayHelper.this.retobj = APPluginInterfaceManager.initPluginInterface(paramContext, APMidasPayHelper.MIDAS_PLUGIN_NAME, APMidasPayHelper.PKG_DISTRIBUTE, APMidasPayHelper.MED_DISTRIBUTE_RECEIVE, new Object[] { paramContext, paramBundle, paramResultReceiver }, new Class[] { Context.class, Bundle.class, ResultReceiver.class });
            AppMethodBeat.o(217534);
            return;
          }
          catch (Exception paramAnonymousBundle)
          {
            APLog.e("APMidasPayHelper", "sendMidas() e = " + paramAnonymousBundle.toString());
            AppMethodBeat.o(217534);
            return;
          }
        }
        if (paramResultReceiver != null)
        {
          String str = paramBundle.getString("__midas_ability_baseReq__postBack");
          Bundle localBundle = new Bundle();
          localBundle.putString("midas_callback_ability_postBack", str);
          localBundle.putInt("midas_callback_ability_code", -1999);
          localBundle.putString("midas_callback_ability_msg", "MidasPlugin load failure");
          localBundle.putBundle("midas_callback_ability_data", paramAnonymousBundle);
          paramResultReceiver.send(-1, localBundle);
        }
        AppMethodBeat.o(217534);
      }
    });
    AppMethodBeat.o(217958);
  }
  
  public void setScreenType(int paramInt)
  {
    this.screenType = paramInt;
  }
  
  public void web(Activity paramActivity, APMidasBaseRequest paramAPMidasBaseRequest, IAPMidasPayCallBack paramIAPMidasPayCallBack)
  {
    AppMethodBeat.i(217940);
    midasCallBack = paramIAPMidasPayCallBack;
    launchWeb(paramActivity, paramAPMidasBaseRequest, paramIAPMidasPayCallBack);
    AppMethodBeat.o(217940);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.control.APMidasPayHelper
 * JD-Core Version:    0.7.0.1
 */