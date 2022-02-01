package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebViewDatabase;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.sdk.ui.dialog.d;
import com.tencent.smtt.sdk.ui.dialog.e;
import com.tencent.smtt.utils.FileProvider;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.i;
import com.tencent.smtt.utils.m;
import com.tencent.smtt.utils.q;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressLint({"NewApi"})
public class QbSdk
{
  private static int A = 0;
  private static String B;
  private static String C;
  private static boolean D = false;
  private static boolean E = false;
  public static final int EXTENSION_INIT_FAILURE = -99999;
  private static TbsListener F;
  public static final String FILERADER_MENUDATA = "menuData";
  private static TbsListener G;
  private static boolean H = false;
  private static boolean I = false;
  private static boolean J = true;
  private static boolean K = true;
  public static final String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
  private static boolean L = true;
  public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
  public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
  public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
  public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
  public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
  public static final int QBMODE = 2;
  public static final String SHARE_PREFERENCES_NAME = "tbs_file_open_dialog_config";
  public static final String SVNVERSION = "jnizz";
  public static final int TBSMODE = 1;
  public static final String TID_QQNumber_Prefix = "QQ:";
  public static final int VERSION = 1;
  static boolean a;
  static boolean b;
  static boolean c;
  static String d;
  static boolean e;
  static long f;
  static long g;
  static Object h;
  static boolean i;
  public static boolean isDefaultDialog;
  static boolean j;
  static boolean k;
  static boolean l;
  static volatile boolean m;
  public static boolean mDisableUseHostBackupCore;
  static TbsListener n;
  static Map<String, Object> o;
  private static int p;
  private static String q;
  private static Class<?> r;
  private static Object s;
  public static boolean sIsVersionPrinted = false;
  private static boolean t;
  private static String[] u;
  private static String v;
  private static String w;
  private static boolean x;
  private static boolean y;
  private static int z;
  
  static
  {
    p = 0;
    q = "";
    r = null;
    s = null;
    a = false;
    b = false;
    c = true;
    t = false;
    v = "NULL";
    w = "UNKNOWN";
    e = false;
    f = 0L;
    g = 0L;
    h = new Object();
    isDefaultDialog = false;
    x = false;
    i = true;
    y = true;
    j = true;
    k = false;
    l = false;
    z = 0;
    A = 170;
    B = null;
    C = null;
    m = a;
    mDisableUseHostBackupCore = false;
    D = false;
    E = true;
    F = null;
    G = null;
    H = false;
    I = false;
    n = new TbsListener()
    {
      public void onDownloadFinish(int paramAnonymousInt)
      {
        if (TbsDownloader.needDownloadDecoupleCore())
        {
          TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
          TbsDownloader.a = true;
        }
        do
        {
          return;
          TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
          TbsDownloader.a = false;
          if ((paramAnonymousInt != 100) || (QbSdk.c() != null)) {
            QbSdk.c().onDownloadFinish(paramAnonymousInt);
          }
        } while (QbSdk.d() == null);
        QbSdk.d().onDownloadFinish(paramAnonymousInt);
      }
      
      public void onDownloadProgress(int paramAnonymousInt)
      {
        if (QbSdk.d() != null) {
          QbSdk.d().onDownloadProgress(paramAnonymousInt);
        }
        if (QbSdk.c() != null) {
          QbSdk.c().onDownloadProgress(paramAnonymousInt);
        }
      }
      
      public void onInstallFinish(int paramAnonymousInt)
      {
        if ((paramAnonymousInt != 200) && (paramAnonymousInt == 220)) {}
        TbsLog.i("QbSdk", "onInstallFinish errCode is " + paramAnonymousInt, true);
        QbSdk.setTBSInstallingStatus(false);
        TbsDownloader.a = false;
        if (TbsDownloader.startDecoupleCoreIfNeeded()) {}
        for (TbsDownloader.a = true;; TbsDownloader.a = false)
        {
          if (QbSdk.c() != null) {
            QbSdk.c().onInstallFinish(paramAnonymousInt);
          }
          if (QbSdk.d() != null) {
            QbSdk.d().onInstallFinish(paramAnonymousInt);
          }
          return;
        }
      }
    };
    o = null;
  }
  
  static Bundle a(Context paramContext, Bundle paramBundle)
    throws Exception
  {
    if (!a(paramContext))
    {
      TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "initForPatch return false!");
      return null;
    }
    paramBundle = i.a(s, "incrUpdate", new Class[] { Context.class, Bundle.class }, new Object[] { paramContext, paramBundle });
    if (paramBundle != null) {
      return (Bundle)paramBundle;
    }
    TbsLogReport.getInstance(paramContext).setInstallErrorCode(216, "incrUpdate return null!");
    return null;
  }
  
  /* Error */
  private static Bundle a(Context paramContext, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 237	android/os/Bundle
    //   9: dup
    //   10: invokespecial 247	android/os/Bundle:<init>	()V
    //   13: astore 5
    //   15: aload_1
    //   16: ldc 249
    //   18: invokeinterface 255 2 0
    //   23: ifnonnull +166 -> 189
    //   26: ldc_w 257
    //   29: astore 4
    //   31: aload 5
    //   33: ldc 249
    //   35: aload 4
    //   37: invokevirtual 261	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload 5
    //   42: ldc_w 263
    //   45: aload_1
    //   46: ldc_w 263
    //   49: invokeinterface 255 2 0
    //   54: checkcast 265	java/lang/String
    //   57: invokestatic 271	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   60: invokevirtual 275	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   63: aload_1
    //   64: ifnull +162 -> 226
    //   67: aload_1
    //   68: ldc 48
    //   70: invokeinterface 279 2 0
    //   75: ifeq +151 -> 226
    //   78: new 281	org/json/JSONObject
    //   81: dup
    //   82: aload_1
    //   83: ldc 48
    //   85: invokeinterface 255 2 0
    //   90: checkcast 265	java/lang/String
    //   93: invokespecial 284	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   96: astore_1
    //   97: aload_1
    //   98: ldc_w 286
    //   101: invokevirtual 290	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   104: astore 4
    //   106: aload 4
    //   108: ifnull +107 -> 215
    //   111: new 292	java/util/ArrayList
    //   114: dup
    //   115: invokespecial 293	java/util/ArrayList:<init>	()V
    //   118: astore 6
    //   120: iconst_0
    //   121: istore_2
    //   122: aload 4
    //   124: invokevirtual 299	org/json/JSONArray:length	()I
    //   127: istore_3
    //   128: iload_2
    //   129: iload_3
    //   130: if_icmpge +75 -> 205
    //   133: iload_2
    //   134: iconst_5
    //   135: if_icmpge +70 -> 205
    //   138: aload 4
    //   140: iload_2
    //   141: invokevirtual 302	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   144: checkcast 281	org/json/JSONObject
    //   147: astore 7
    //   149: aload 7
    //   151: ldc_w 304
    //   154: invokevirtual 307	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   157: istore_3
    //   158: aload 6
    //   160: iload_2
    //   161: aload_0
    //   162: invokevirtual 311	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   165: iload_3
    //   166: invokestatic 317	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   169: invokevirtual 321	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   172: aload 7
    //   174: ldc_w 304
    //   177: iload_2
    //   178: invokevirtual 325	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   181: pop
    //   182: iload_2
    //   183: iconst_1
    //   184: iadd
    //   185: istore_2
    //   186: goto -64 -> 122
    //   189: aload_1
    //   190: ldc 249
    //   192: invokeinterface 255 2 0
    //   197: checkcast 265	java/lang/String
    //   200: astore 4
    //   202: goto -171 -> 31
    //   205: aload 5
    //   207: ldc_w 327
    //   210: aload 6
    //   212: invokevirtual 331	android/os/Bundle:putParcelableArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   215: aload 5
    //   217: ldc 48
    //   219: aload_1
    //   220: invokevirtual 335	org/json/JSONObject:toString	()Ljava/lang/String;
    //   223: invokevirtual 261	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 5
    //   228: areturn
    //   229: astore_0
    //   230: aload_0
    //   231: invokevirtual 338	java/lang/Exception:printStackTrace	()V
    //   234: aconst_null
    //   235: areturn
    //   236: astore 7
    //   238: goto -56 -> 182
    //   241: astore 4
    //   243: goto -180 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	paramContext	Context
    //   0	246	1	paramMap	Map<String, String>
    //   121	65	2	i1	int
    //   127	39	3	i2	int
    //   29	172	4	localObject	Object
    //   241	1	4	localException1	Exception
    //   13	214	5	localBundle	Bundle
    //   118	93	6	localArrayList	java.util.ArrayList
    //   147	26	7	localJSONObject	org.json.JSONObject
    //   236	1	7	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   6	26	229	java/lang/Exception
    //   31	40	229	java/lang/Exception
    //   67	106	229	java/lang/Exception
    //   111	120	229	java/lang/Exception
    //   122	128	229	java/lang/Exception
    //   189	202	229	java/lang/Exception
    //   205	215	229	java/lang/Exception
    //   215	226	229	java/lang/Exception
    //   138	182	236	java/lang/Exception
    //   40	63	241	java/lang/Exception
  }
  
  static Object a(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (!a(paramContext)) {
      paramContext = Integer.valueOf(-99999);
    }
    do
    {
      return paramContext;
      paramString = i.a(s, "miscCall", new Class[] { String.class, Bundle.class }, new Object[] { paramString, paramBundle });
      paramContext = paramString;
    } while (paramString != null);
    return null;
  }
  
  static String a()
  {
    return q;
  }
  
  static void a(Context paramContext, Integer paramInteger, Map<Integer, String> paramMap)
  {
    if (!a(paramContext)) {
      return;
    }
    i.a(s, "dispatchEmergencyCommand", new Class[] { Integer.class, Map.class }, new Object[] { paramInteger, paramMap });
  }
  
  /* Error */
  static void a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 136	com/tencent/smtt/sdk/QbSdk:a	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: iconst_1
    //   16: putstatic 136	com/tencent/smtt/sdk/QbSdk:a	Z
    //   19: new 356	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   26: ldc_w 359
    //   29: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: putstatic 150	com/tencent/smtt/sdk/QbSdk:w	Ljava/lang/String;
    //   42: ldc_w 366
    //   45: ldc_w 368
    //   48: new 356	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 370
    //   58: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: getstatic 150	com/tencent/smtt/sdk/QbSdk:w	Ljava/lang/String;
    //   64: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   73: ldc_w 366
    //   76: ldc_w 368
    //   79: new 377	java/lang/Throwable
    //   82: dup
    //   83: ldc_w 379
    //   86: invokespecial 380	java/lang/Throwable:<init>	(Ljava/lang/String;)V
    //   89: invokestatic 386	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   92: invokestatic 375	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   95: invokestatic 391	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   98: aload_0
    //   99: sipush 401
    //   102: invokevirtual 394	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   105: goto -94 -> 11
    //   108: astore_0
    //   109: ldc 2
    //   111: monitorexit
    //   112: aload_0
    //   113: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramContext	Context
    //   0	114	1	paramString	String
    //   6	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   3	7	108	finally
    //   15	105	108	finally
  }
  
  static boolean a(Context paramContext)
  {
    try
    {
      if (r != null) {
        return true;
      }
      Object localObject = p.a().r(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
        return false;
      }
      File localFile = new File((File)localObject, "tbs_sdk_extension_dex.jar");
      if (!localFile.exists())
      {
        TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
        return false;
      }
      TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + localFile.getAbsolutePath());
      x.a().b(paramContext);
      m.a(paramContext);
      String str1 = localFile.getParent();
      String str2 = localFile.getAbsolutePath();
      localObject = ((File)localObject).getAbsolutePath();
      Map localMap = getSettings();
      r = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
      if ((!isEnableSensitiveApi()) && (i.a(r, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
      {
        TbsLog.e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
        return false;
      }
      loadTBSSDKExtension(paramContext, localFile.getParent());
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  static boolean a(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 20000);
  }
  
  static boolean a(Context paramContext, int paramInt1, int paramInt2)
  {
    if ((o != null) && (o.containsKey("SET_SENDREQUEST_AND_UPLOAD")) && (o.get("SET_SENDREQUEST_AND_UPLOAD").equals("false"))) {
      TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
    }
    label189:
    do
    {
      return true;
      if ((!isEnableSensitiveApi()) && (i.a(r, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
      {
        TbsLog.e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
        return false;
      }
      p localp = p.a();
      if (g.a == 0) {}
      for (boolean bool = true;; bool = false)
      {
        localp.b(paramContext, bool);
        if (!c(paramContext)) {
          break;
        }
        paramContext = i.a(s, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(44085), Integer.valueOf(paramInt2) });
        if (paramContext == null) {
          break label189;
        }
        return ((Boolean)paramContext).booleanValue();
      }
      paramContext = i.a(s, "isX5Disabled", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(44085) });
    } while (paramContext == null);
    return ((Boolean)paramContext).booleanValue();
  }
  
  @SuppressLint({"NewApi"})
  private static boolean a(Context paramContext, boolean paramBoolean)
  {
    TbsLog.initIfNeed(paramContext);
    if (!sIsVersionPrinted)
    {
      TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 44085; SDK_VERSION_NAME: 4.3.0.185");
      sIsVersionPrinted = true;
    }
    if ((a) && (!paramBoolean))
    {
      TbsCoreLoadStat.getInstance().a(paramContext, 414);
      TbsLog.e("QbSdk", "init", "Force WebView Inner, " + w);
      return false;
    }
    if (b)
    {
      TbsCoreLoadStat.getInstance().a(paramContext, 402);
      TbsLog.e("QbSdk", "init", "QbSdk init mIsSysWebViewForcedByOuter = true, " + v);
      return false;
    }
    if (!E) {
      d(paramContext);
    }
    for (;;)
    {
      try
      {
        localObject = p.a().r(paramContext);
        if (localObject == null)
        {
          TbsCoreLoadStat.getInstance().a(paramContext, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
          return false;
        }
        if (TbsShareManager.isThirdPartyApp(paramContext))
        {
          if ((p != 0) && (p != TbsShareManager.d(paramContext)))
          {
            r = null;
            s = null;
            TbsCoreLoadStat.getInstance().a(paramContext, 302);
            TbsLog.w("QbSdk", "init", "return false, thirdParty not match TBS core ver, details:sTbsVersion: " + p + "; AvailableTbsCoreVersion: " + TbsShareManager.d(paramContext));
            return false;
          }
          p = TbsShareManager.d(paramContext);
          if (TbsDownloader.a(paramContext, p))
          {
            TbsLog.i("QbSdk", "init", "version " + p + " is in blacklist,can not load! return");
            return false;
          }
        }
        else
        {
          if (p == 0) {
            break label882;
          }
          int i2 = p.a().a(true, paramContext);
          i1 = i2;
          if (p != i2)
          {
            r = null;
            s = null;
            TbsCoreLoadStat.getInstance().a(paramContext, 303, new Throwable("sTbsVersion: " + p + "; tbsCoreInstalledVer: " + i2));
            return false;
          }
          p = i1;
          continue;
        }
        if (r == null) {
          break label464;
        }
      }
      catch (Throwable localThrowable1)
      {
        TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(localThrowable1));
        TbsCoreLoadStat.getInstance().a(paramContext, 306, localThrowable1);
        return false;
      }
      if (s != null) {
        return true;
      }
      label464:
      File localFile;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (TbsShareManager.j(paramContext)) {
          localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        }
      }
      for (;;)
      {
        paramBoolean = localFile.exists();
        if (!paramBoolean) {
          try
          {
            i1 = p.a().j(paramContext);
            localObject = new File(localFile.getParentFile(), "tbs_jars_fusion_dex.jar");
            TbsCoreLoadStat.getInstance().a(paramContext, 403);
            TbsLog.w("QbSdk", "init", "[loadMsg] extension is miss, fusion exist is " + ((File)localObject).exists() + ", core is " + i1 + ", dexPath is " + localFile.getPath());
            return false;
            TbsCoreLoadStat.getInstance().a(paramContext, 304, new Throwable("isShareTbsCoreAvailable false!"));
            return false;
            localFile = new File(p.a().r(paramContext), "tbs_sdk_extension_dex.jar");
          }
          catch (Throwable localThrowable2)
          {
            for (;;)
            {
              localThrowable2.printStackTrace();
            }
          }
        }
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (Object localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "init", "optDirExtension #1 is " + (String)localObject);
        TbsLog.i("QbSdk", "init", "new DexLoader #1 dexFile is " + localThrowable2.getAbsolutePath());
        x.a().b(paramContext);
        m.a(paramContext);
        String str1 = localThrowable2.getParent();
        String str2 = localThrowable2.getAbsolutePath();
        Map localMap = getSettings();
        r = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        if ((isEnableSensitiveApi()) || (i.a(r, "isSuiteableGetSensitative", new Class[0], new Object[0]) != null)) {
          break;
        }
        TbsLog.e("QbSdk", "init", "isSuiteableGetSensitative check failed, can not use x5");
        return false;
      }
      loadTBSSDKExtension(paramContext, localThrowable2.getParent());
      i.a(s, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
      label882:
      int i1 = 0;
    }
  }
  
  static boolean a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 1;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    TbsLog.i("QbSdk", "canLoadX5", "#1# installTbsCoreIfNeeded");
    Object localObject1 = p.a();
    int i1;
    if (g.a == 0)
    {
      paramBoolean2 = true;
      ((p)localObject1).b(paramContext, paramBoolean2);
      i1 = TbsPVConfig.getInstance(paramContext).getDisabledCoreVersion();
      if ((i1 == 0) || (i1 != p.a().j(paramContext))) {
        break label89;
      }
      TbsLog.e("QbSdk", "canLoadX5", "#2-1# force use sys by remote switch");
      paramBoolean1 = bool3;
    }
    for (;;)
    {
      label82:
      return paramBoolean1;
      paramBoolean2 = false;
      break;
      label89:
      if ((!isEnableSensitiveApi()) && (i.a(s, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
      {
        TbsLog.e("QbSdk", "canLoadX5", "[LoadError] sensitiveApi is disabled!");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext))
      {
        TbsLog.i("QbSdk", "canLoadX5", "#2# isThirdPartyApp");
        if (!TbsShareManager.i(paramContext))
        {
          TbsLog.w("QbSdk", "canLoadX5", "#2-3# thirdParty no core available before init");
          TbsCoreLoadStat.getInstance().a(paramContext, 302);
          return false;
        }
      }
      if (!a(paramContext, paramBoolean1))
      {
        TbsLog.e("QbSdk", "canLoadX5", "#2-4# QbSdk.init failure!");
        return false;
      }
      Object localObject4 = i.a(s, "canLoadX5Core", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(44085) });
      localObject1 = new StringBuilder().append("#3# invoke sExtensionObj canLoadX5Core and ret is ");
      if (localObject4 != null) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        TbsLog.i("QbSdk", "canLoadX5", paramBoolean1);
        if (localObject4 == null) {
          break label1314;
        }
        if ((!(localObject4 instanceof String)) || (!((String)localObject4).equalsIgnoreCase("AuthenticationFail"))) {
          break;
        }
        TbsLog.e("QbSdk", "canLoadX5", "[LoadError] authenticationFail");
        return false;
      }
      if (!(localObject4 instanceof Bundle))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 330, new Throwable("" + localObject4));
        TbsLog.e("QbSdk", "canLoadX5", "[LoadError] ret not instance of bundle, ret:" + localObject4);
        return false;
      }
      localObject1 = (Bundle)localObject4;
      if (((Bundle)localObject1).isEmpty())
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 331, new Throwable("" + localObject4));
        TbsLog.e("QbSdk", "canLoadX5", "[LoadError] empty bundle" + localObject4);
        return false;
      }
      try
      {
        i1 = ((Bundle)localObject1).getInt("result_code", -1);
        if (i1 == 0)
        {
          paramBoolean1 = true;
          if (!TbsShareManager.isThirdPartyApp(paramContext)) {
            break label707;
          }
          g.a(TbsShareManager.d(paramContext));
          q = String.valueOf(TbsShareManager.d(paramContext));
          if (q.length() == 5) {
            q = "0" + q;
          }
          if (q.length() != 6) {
            q = "";
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          try
          {
            u = ((Bundle)localObject1).getStringArray("tbs_jarfiles");
            if ((u instanceof String[])) {
              break label971;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sJarFiles not instanceof String[]: " + u));
            TbsLog.e("QbSdk", "canLoadX5", "sJarFiles not instanceof String[]: " + u);
            return false;
          }
          catch (Throwable localThrowable)
          {
            label707:
            TbsCoreLoadStat.getInstance().a(paramContext, 329, localThrowable);
            return false;
          }
          localException2 = localException2;
          TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + localException2.toString());
          i1 = -1;
          continue;
          paramBoolean1 = false;
          continue;
          try
          {
            if (Build.VERSION.SDK_INT >= 12) {
              q = ((Bundle)localObject1).getString("tbs_core_version", "0");
            }
          }
          catch (Exception localException3)
          {
            try
            {
              p = Integer.parseInt(q);
              g.a(p);
              if (p == 0)
              {
                TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("sTbsVersion is 0"));
                TbsLog.e("QbSdk", "canLoadX5", "[LoadError] sTbsVersion is 0");
                return false;
                q = ((Bundle)localObject1).getString("tbs_core_version");
                if (q != null) {
                  continue;
                }
                q = "0";
                continue;
                localException3 = localException3;
                q = "0";
              }
            }
            catch (NumberFormatException localNumberFormatException)
            {
              p = 0;
              continue;
              int i2;
              if (p > 0)
              {
                i2 = i3;
                if (p <= 25442) {}
              }
              else
              {
                if (p != 25472) {
                  continue;
                }
                i2 = i3;
              }
              if (i2 != 0)
              {
                FileUtil.b(p.a().r(paramContext));
                TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("is_obsolete --> delete old core:" + p));
                TbsLog.e("QbSdk", "canLoadX5", "is_obsolete --> delete old core:" + p);
                return false;
                i2 = 0;
              }
            }
          }
        }
      }
      try
      {
        label971:
        d = localThrowable.getString("tbs_librarypath");
        Class localClass = null;
        Object localObject2 = localClass;
        if (i1 != 0) {}
        for (;;)
        {
          try
          {
            localObject2 = i.a(s, "getErrorCodeForLogReport", new Class[0], new Object[0]);
            switch (i1)
            {
            default: 
              TbsCoreLoadStat.getInstance().a(paramContext, 415, new Throwable("detail: " + localObject2 + "errcode" + i1));
            case 0: 
              paramBoolean2 = paramBoolean1;
              paramBoolean1 = paramBoolean2;
              if (paramBoolean2) {
                break label82;
              }
              TbsLog.w("QbSdk", "canLoadX5", "#4# error code: 319");
              return paramBoolean2;
            }
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            localObject3 = localClass;
            continue;
            if ((localObject3 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject3).intValue(), new Throwable("detail: " + localObject3));
              continue;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 307, new Throwable("detail: " + localObject3));
            continue;
            if ((localObject3 instanceof Integer))
            {
              TbsCoreLoadStat.getInstance().a(paramContext, ((Integer)localObject3).intValue(), new Throwable("detail: " + localObject3));
              continue;
            }
            TbsCoreLoadStat.getInstance().a(paramContext, 404, new Throwable("detail: " + localObject3));
            continue;
          }
          label1314:
          Object localObject3 = s;
          localClass = Integer.TYPE;
          i1 = a.a();
          localObject3 = i.a(localObject3, "canLoadX5", new Class[] { localClass }, new Object[] { Integer.valueOf(i1) });
          if (localObject3 != null)
          {
            if ((localObject3 instanceof String))
            {
              paramBoolean1 = bool3;
              if (((String)localObject3).equalsIgnoreCase("AuthenticationFail")) {
                break;
              }
            }
            paramBoolean2 = bool2;
            if (!(localObject3 instanceof Boolean)) {
              continue;
            }
            p = g.d();
            bool2 = a(paramContext, g.d());
            paramBoolean2 = bool1;
            if (((Boolean)localObject3).booleanValue())
            {
              paramBoolean2 = bool1;
              if (!bool2) {
                paramBoolean2 = true;
              }
            }
            paramBoolean1 = paramBoolean2;
            if (paramBoolean2) {
              break;
            }
            TbsLog.e("loaderror", "318");
            TbsLog.w("loaderror", "isX5Disable:" + bool2);
            TbsLog.w("loaderror", "(Boolean) ret:" + (Boolean)localObject3);
            return paramBoolean2;
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 308);
          paramBoolean2 = bool2;
        }
        return false;
      }
      catch (Exception paramContext) {}
    }
  }
  
  protected static String b()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = ((x)localObject).c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
      if ((localObject != null) && ((localObject instanceof String))) {
        return (String)localObject;
      }
    }
    return null;
  }
  
  static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      if (paramContext.getApplicationInfo().packageName.contains("com.tencent.portfolio"))
      {
        TbsLog.i("QbSdk", "clearPluginConfigFile #1");
        String str1 = TbsDownloadConfig.getInstance(paramContext).mPreferences.getString("app_versionname", null);
        String str2 = paramContext.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
        TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + str1 + " newAppVersionName is " + str2);
        if ((str1 != null) && (!str1.contains(str2)))
        {
          paramContext = paramContext.getSharedPreferences("plugin_setting", 0);
          if (paramContext != null)
          {
            paramContext = paramContext.edit();
            paramContext.clear();
            paramContext.commit();
            TbsLog.i("QbSdk", "clearPluginConfigFile done");
          }
        }
      }
    }
    catch (Throwable paramContext)
    {
      TbsLog.i("QbSdk", "clearPluginConfigFile error is " + paramContext.getMessage());
      return false;
    }
    return true;
  }
  
  private static boolean c(Context paramContext)
  {
    try
    {
      if (r != null) {
        return true;
      }
      Object localObject = p.a().r(paramContext);
      if (localObject == null)
      {
        TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
        return false;
      }
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        if (!TbsShareManager.j(paramContext)) {}
      }
      for (File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar"); !localFile.exists(); localFile = new File(p.a().r(paramContext), "tbs_sdk_extension_dex.jar"))
      {
        TbsCoreLoadStat.getInstance().a(paramContext, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
        return false;
        TbsCoreLoadStat.getInstance().a(paramContext, 304);
        return false;
      }
      if (TbsShareManager.getHostCorePathAppDefined() != null) {}
      for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
      {
        TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is " + (String)localObject);
        TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + localFile.getAbsolutePath());
        x.a().b(paramContext);
        m.a(paramContext);
        String str1 = localFile.getParent();
        String str2 = localFile.getAbsolutePath();
        Map localMap = getSettings();
        r = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
        if ((isEnableSensitiveApi()) || (i.a(r, "isSuiteableGetSensitative", new Class[0], new Object[0]) != null)) {
          break;
        }
        TbsLog.e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
        return false;
      }
      loadTBSSDKExtension(paramContext, localFile.getParent());
      i.a(s, "setClientVersion", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(1) });
      return true;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canGetAndroidId(boolean paramBoolean)
  {
    K = paramBoolean;
    Log.d("QbSdk", "CanGetAndroidID is " + paramBoolean);
    TbsLog.i("QbSdk", "CanGetAndroidID is " + paramBoolean);
  }
  
  public static void canGetDeviceId(boolean paramBoolean)
  {
    J = paramBoolean;
    Log.d("QbSdk", "canGetDeviceId is " + paramBoolean);
    TbsLog.i("QbSdk", "canGetDeviceId is " + paramBoolean);
  }
  
  public static void canGetSubscriberId(boolean paramBoolean)
  {
    L = paramBoolean;
    Log.d("QbSdk", "canGetSubscriberId is " + paramBoolean);
    TbsLog.i("QbSdk", "canGetSubscriberId is " + paramBoolean);
  }
  
  public static boolean canLoadVideo(Context paramContext)
  {
    Object localObject = i.a(s, "canLoadVideo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(0) });
    if (localObject != null) {
      if (!((Boolean)localObject).booleanValue()) {
        TbsCoreLoadStat.getInstance().a(paramContext, 313);
      }
    }
    while (localObject == null)
    {
      return false;
      TbsCoreLoadStat.getInstance().a(paramContext, 314);
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public static boolean canLoadX5(Context paramContext)
  {
    return a(paramContext, false, false);
  }
  
  public static boolean canLoadX5FirstTimeThirdApp(Context paramContext)
  {
    try
    {
      if ((paramContext.getApplicationInfo().packageName.contains("com.moji.mjweather")) && (Build.VERSION.SDK_INT == 19)) {
        return true;
      }
      if (r == null)
      {
        Object localObject = p.a().r(paramContext);
        if (localObject == null)
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
          return false;
        }
        File localFile = new File(TbsShareManager.c(paramContext), "tbs_sdk_extension_dex.jar");
        if (!localFile.exists())
        {
          TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
          return false;
        }
        if (TbsShareManager.getHostCorePathAppDefined() != null) {}
        for (localObject = TbsShareManager.getHostCorePathAppDefined();; localObject = ((File)localObject).getAbsolutePath())
        {
          TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is " + (String)localObject);
          TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + localFile.getAbsolutePath());
          x.a().b(paramContext);
          m.a(paramContext);
          String str1 = localFile.getParent();
          String str2 = localFile.getAbsolutePath();
          Map localMap = getSettings();
          r = new DexLoader(str1, paramContext, new String[] { str2 }, (String)localObject, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
          if (s != null) {
            break label305;
          }
          if ((TbsShareManager.e(paramContext) != null) || (TbsShareManager.getHostCorePathAppDefined() != null)) {
            break;
          }
          TbsLogReport.getInstance(paramContext.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
          return false;
        }
        if ((!isEnableSensitiveApi()) && (i.a(r, "isSuiteableGetSensitative", new Class[0], new Object[0]) == null))
        {
          TbsLog.e("QbSdk", "isSuiteableGetSensitative check failed,can not use x5");
          return false;
        }
        loadTBSSDKExtension(paramContext, localFile.getParent());
      }
      label305:
      paramContext = i.a(s, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
      if ((paramContext != null) && ((paramContext instanceof Boolean)))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(paramContext));
    }
    return false;
  }
  
  public static void canOpenFile(Context paramContext, final String paramString, final ValueCallback<Boolean> paramValueCallback)
  {
    new Thread()
    {
      public void run()
      {
        x localx = x.a();
        localx.a(this.a);
        final boolean bool = false;
        if (localx.b()) {
          bool = localx.c().a(this.a, paramString);
        }
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            QbSdk.1.this.c.onReceiveValue(Boolean.valueOf(bool));
          }
        });
      }
    }.start();
  }
  
  public static boolean canOpenMimeFileType(Context paramContext, String paramString)
  {
    if (!a(paramContext, false)) {}
    return false;
  }
  
  /* Error */
  public static boolean canOpenWebPlus(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_1
    //   4: istore 4
    //   6: getstatic 177	com/tencent/smtt/sdk/QbSdk:z	I
    //   9: ifne +9 -> 18
    //   12: invokestatic 726	com/tencent/smtt/sdk/a:a	()I
    //   15: putstatic 177	com/tencent/smtt/sdk/QbSdk:z	I
    //   18: ldc_w 366
    //   21: new 356	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   28: ldc_w 902
    //   31: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: getstatic 177	com/tencent/smtt/sdk/QbSdk:z	I
    //   37: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 429	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 684	android/os/Build$VERSION:SDK_INT	I
    //   49: bipush 7
    //   51: if_icmplt +12 -> 63
    //   54: getstatic 177	com/tencent/smtt/sdk/QbSdk:z	I
    //   57: getstatic 179	com/tencent/smtt/sdk/QbSdk:A	I
    //   60: if_icmpge +5 -> 65
    //   63: iconst_0
    //   64: ireturn
    //   65: aload_0
    //   66: ifnull -3 -> 63
    //   69: new 904	java/io/BufferedInputStream
    //   72: dup
    //   73: new 906	java/io/FileInputStream
    //   76: dup
    //   77: new 408	java/io/File
    //   80: dup
    //   81: invokestatic 399	com/tencent/smtt/sdk/p:a	()Lcom/tencent/smtt/sdk/p;
    //   84: aload_0
    //   85: invokevirtual 402	com/tencent/smtt/sdk/p:r	(Landroid/content/Context;)Ljava/io/File;
    //   88: ldc_w 908
    //   91: invokespecial 413	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   94: invokespecial 910	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   97: invokespecial 913	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   100: astore 6
    //   102: new 915	java/util/Properties
    //   105: dup
    //   106: invokespecial 916	java/util/Properties:<init>	()V
    //   109: astore 8
    //   111: aload 8
    //   113: aload 6
    //   115: invokevirtual 919	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   118: aload 8
    //   120: ldc_w 921
    //   123: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   126: astore 9
    //   128: aload 8
    //   130: ldc_w 926
    //   133: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   136: astore 10
    //   138: aload 9
    //   140: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   143: istore_1
    //   144: aload 10
    //   146: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   149: istore_2
    //   150: getstatic 929	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   153: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   156: istore_3
    //   157: iload_3
    //   158: iload_1
    //   159: if_icmpgt +8 -> 167
    //   162: iload_3
    //   163: iload_2
    //   164: if_icmpge +44 -> 208
    //   167: ldc_w 366
    //   170: new 356	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 931
    //   180: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: iload_3
    //   184: invokevirtual 537	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 429	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 6
    //   195: ifnull -132 -> 63
    //   198: aload 6
    //   200: invokevirtual 934	java/io/BufferedInputStream:close	()V
    //   203: iconst_0
    //   204: ireturn
    //   205: astore_0
    //   206: iconst_0
    //   207: ireturn
    //   208: aload 8
    //   210: ldc_w 686
    //   213: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   216: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_1
    //   220: aload 6
    //   222: ifnull +8 -> 230
    //   225: aload 6
    //   227: invokevirtual 934	java/io/BufferedInputStream:close	()V
    //   230: new 906	java/io/FileInputStream
    //   233: dup
    //   234: new 408	java/io/File
    //   237: dup
    //   238: aload_0
    //   239: invokestatic 936	com/tencent/smtt/sdk/p:t	(Landroid/content/Context;)Ljava/io/File;
    //   242: ldc_w 938
    //   245: invokespecial 413	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   248: invokespecial 910	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   251: astore 6
    //   253: new 915	java/util/Properties
    //   256: dup
    //   257: invokespecial 916	java/util/Properties:<init>	()V
    //   260: astore 7
    //   262: aload 7
    //   264: aload 6
    //   266: invokevirtual 919	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   269: aload 7
    //   271: ldc_w 940
    //   274: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   277: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   280: istore_2
    //   281: aload 7
    //   283: ldc_w 942
    //   286: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   289: invokestatic 693	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   292: istore_3
    //   293: iload_1
    //   294: ldc_w 943
    //   297: if_icmpeq +10 -> 307
    //   300: iload_2
    //   301: ldc_w 943
    //   304: if_icmpne +73 -> 377
    //   307: iconst_0
    //   308: istore_1
    //   309: iload_1
    //   310: istore_2
    //   311: aload 6
    //   313: ifnull +10 -> 323
    //   316: aload 6
    //   318: invokevirtual 946	java/io/InputStream:close	()V
    //   321: iload_1
    //   322: istore_2
    //   323: iload_2
    //   324: ifne +183 -> 507
    //   327: iload 4
    //   329: ireturn
    //   330: astore 6
    //   332: aconst_null
    //   333: astore_0
    //   334: aload 6
    //   336: invokevirtual 590	java/lang/Throwable:printStackTrace	()V
    //   339: ldc_w 366
    //   342: ldc_w 948
    //   345: invokestatic 429	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_0
    //   349: ifnull -286 -> 63
    //   352: aload_0
    //   353: invokevirtual 934	java/io/BufferedInputStream:close	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: iconst_0
    //   360: ireturn
    //   361: astore_0
    //   362: aconst_null
    //   363: astore 6
    //   365: aload 6
    //   367: ifnull +8 -> 375
    //   370: aload 6
    //   372: invokevirtual 934	java/io/BufferedInputStream:close	()V
    //   375: aload_0
    //   376: athrow
    //   377: iload_1
    //   378: iload_2
    //   379: if_icmple +8 -> 387
    //   382: iconst_0
    //   383: istore_1
    //   384: goto -75 -> 309
    //   387: iload_1
    //   388: iload_2
    //   389: if_icmpne +194 -> 583
    //   392: iload_3
    //   393: ifle +16 -> 409
    //   396: iload_3
    //   397: aload_0
    //   398: invokestatic 952	com/tencent/smtt/utils/b:e	(Landroid/content/Context;)I
    //   401: if_icmpeq +8 -> 409
    //   404: iconst_0
    //   405: istore_1
    //   406: goto -97 -> 309
    //   409: aload 7
    //   411: ldc_w 954
    //   414: invokevirtual 924	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   417: invokestatic 957	java/lang/Boolean:parseBoolean	(Ljava/lang/String;)Z
    //   420: ifeq +34 -> 454
    //   423: aload_0
    //   424: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   427: invokestatic 780	com/tencent/smtt/sdk/TbsDownloadConfig:getInstance	(Landroid/content/Context;)Lcom/tencent/smtt/sdk/TbsDownloadConfig;
    //   430: getfield 784	com/tencent/smtt/sdk/TbsDownloadConfig:mPreferences	Landroid/content/SharedPreferences;
    //   433: ldc_w 959
    //   436: iconst_0
    //   437: invokeinterface 963 3 0
    //   442: istore 5
    //   444: iload 5
    //   446: ifne +8 -> 454
    //   449: iconst_1
    //   450: istore_1
    //   451: goto -142 -> 309
    //   454: iconst_0
    //   455: istore_1
    //   456: goto -147 -> 309
    //   459: astore_0
    //   460: aload 7
    //   462: astore_0
    //   463: ldc_w 366
    //   466: ldc_w 965
    //   469: invokestatic 429	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_0
    //   473: ifnull +7 -> 480
    //   476: aload_0
    //   477: invokevirtual 946	java/io/InputStream:close	()V
    //   480: iconst_1
    //   481: istore_2
    //   482: goto -159 -> 323
    //   485: astore_0
    //   486: iconst_1
    //   487: istore_2
    //   488: goto -165 -> 323
    //   491: astore_0
    //   492: aconst_null
    //   493: astore 6
    //   495: aload 6
    //   497: ifnull +8 -> 505
    //   500: aload 6
    //   502: invokevirtual 946	java/io/InputStream:close	()V
    //   505: aload_0
    //   506: athrow
    //   507: iconst_0
    //   508: istore 4
    //   510: goto -183 -> 327
    //   513: astore 6
    //   515: goto -285 -> 230
    //   518: astore 6
    //   520: goto -145 -> 375
    //   523: astore_0
    //   524: iload_1
    //   525: istore_2
    //   526: goto -203 -> 323
    //   529: astore 6
    //   531: goto -26 -> 505
    //   534: astore_0
    //   535: goto -40 -> 495
    //   538: astore 7
    //   540: aload_0
    //   541: astore 6
    //   543: aload 7
    //   545: astore_0
    //   546: goto -51 -> 495
    //   549: astore_0
    //   550: aload 6
    //   552: astore_0
    //   553: goto -90 -> 463
    //   556: astore_0
    //   557: goto -192 -> 365
    //   560: astore 7
    //   562: aload_0
    //   563: astore 6
    //   565: aload 7
    //   567: astore_0
    //   568: goto -203 -> 365
    //   571: astore 7
    //   573: aload 6
    //   575: astore_0
    //   576: aload 7
    //   578: astore 6
    //   580: goto -246 -> 334
    //   583: iconst_0
    //   584: istore_1
    //   585: goto -276 -> 309
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramContext	Context
    //   143	442	1	i1	int
    //   149	377	2	i2	int
    //   156	246	3	i3	int
    //   4	505	4	bool1	boolean
    //   442	3	5	bool2	boolean
    //   100	217	6	localObject1	Object
    //   330	5	6	localThrowable1	Throwable
    //   363	138	6	localObject2	Object
    //   513	1	6	localException1	Exception
    //   518	1	6	localException2	Exception
    //   529	1	6	localException3	Exception
    //   541	38	6	localObject3	Object
    //   1	460	7	localProperties1	java.util.Properties
    //   538	6	7	localObject4	Object
    //   560	6	7	localObject5	Object
    //   571	6	7	localThrowable2	Throwable
    //   109	100	8	localProperties2	java.util.Properties
    //   126	13	9	str1	String
    //   136	9	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   198	203	205	java/lang/Exception
    //   69	102	330	java/lang/Throwable
    //   352	356	358	java/lang/Exception
    //   69	102	361	finally
    //   230	253	459	java/lang/Throwable
    //   476	480	485	java/lang/Exception
    //   230	253	491	finally
    //   225	230	513	java/lang/Exception
    //   370	375	518	java/lang/Exception
    //   316	321	523	java/lang/Exception
    //   500	505	529	java/lang/Exception
    //   253	293	534	finally
    //   396	404	534	finally
    //   409	444	534	finally
    //   463	472	538	finally
    //   253	293	549	java/lang/Throwable
    //   396	404	549	java/lang/Throwable
    //   409	444	549	java/lang/Throwable
    //   102	157	556	finally
    //   167	193	556	finally
    //   208	220	556	finally
    //   334	348	560	finally
    //   102	157	571	java/lang/Throwable
    //   167	193	571	java/lang/Throwable
    //   208	220	571	java/lang/Throwable
  }
  
  public static boolean canUseVideoFeatrue(Context paramContext, int paramInt)
  {
    paramContext = i.a(s, "canUseVideoFeatrue", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(paramInt) });
    if ((paramContext != null) && ((paramContext instanceof Boolean))) {
      return ((Boolean)paramContext).booleanValue();
    }
    return false;
  }
  
  public static boolean checkApkExist(Context paramContext, String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return false;
    }
    try
    {
      paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean checkContentProviderPrivilage(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24) && (!"com.tencent.mobileqq".equals(paramContext.getApplicationInfo().packageName))) {}
    try
    {
      ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "android.support.v4.content.FileProvider");
      boolean bool = TextUtils.isEmpty(paramContext.getPackageManager().getProviderInfo(localComponentName, 0).authority);
      if (bool) {
        break label82;
      }
    }
    catch (Exception localException)
    {
      label82:
      do
      {
        localException.printStackTrace();
        paramContext = paramContext.getPackageManager().resolveContentProvider(paramContext.getApplicationInfo().packageName + ".provider", 128);
        if (paramContext == null) {
          Log.e("QbSdk", "Must declare com.tencent.smtt.utils.FileProvider in AndroidManifest above Android 7.0,please view document in x5.tencent.com");
        }
      } while (paramContext != null);
    }
    return true;
    return false;
  }
  
  public static void checkTbsValidity(Context paramContext)
  {
    if (paramContext == null) {}
    while (m.b(paramContext)) {
      return;
    }
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
    TbsCoreLoadStat.getInstance().a(paramContext, 419);
    forceSysWebView();
  }
  
  public static void clear(Context paramContext) {}
  
  public static void clearAllDefaultBrowser(Context paramContext)
  {
    paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0).edit().clear().commit();
  }
  
  public static void clearAllWebViewCache(Context paramContext, boolean paramBoolean)
  {
    int i2 = 1;
    TbsLog.i("QbSdk", "clearAllWebViewCache(" + paramContext + ", " + paramBoolean + ")");
    int i3 = 0;
    i1 = 0;
    for (;;)
    {
      try
      {
        Object localObject = new WebView(paramContext).getWebViewClientExtension();
        i1 = i3;
        if (localObject != null) {
          TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(localThrowable1));
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject = x.a();
          i1 = i2;
          if (localObject != null)
          {
            i1 = i2;
            if (((x)localObject).b())
            {
              ((x)localObject).c().a(paramContext, paramBoolean);
              i1 = i2;
            }
          }
          if (i1 == 0) {
            break;
          }
          TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            android.webkit.WebView localWebView;
            i1 = 1;
          }
        }
        localThrowable1 = localThrowable1;
      }
    }
    try
    {
      localWebView = new android.webkit.WebView(paramContext);
      if (Build.VERSION.SDK_INT >= 11)
      {
        localWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        localWebView.removeJavascriptInterface("accessibility");
        localWebView.removeJavascriptInterface("accessibilityTraversal");
      }
      localWebView.clearCache(true);
      if (paramBoolean)
      {
        CookieSyncManager.createInstance(paramContext);
        CookieManager.getInstance().removeAllCookie();
      }
      WebViewDatabase.getInstance(paramContext).clearUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearHttpAuthUsernamePassword();
      WebViewDatabase.getInstance(paramContext).clearFormData();
      WebStorage.getInstance().deleteAllData();
      WebIconDatabase.getInstance().removeAllIcons();
      return;
    }
    catch (Throwable paramContext)
    {
      TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(paramContext));
      return;
    }
  }
  
  public static void clearDefaultBrowser(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    localSharedPreferences.edit().remove("key_tbs_picked_default_browser_" + paramContext).commit();
  }
  
  public static void closeFileReader(Context paramContext)
  {
    x localx = x.a();
    localx.a(paramContext);
    if (localx.b()) {
      localx.c().p();
    }
  }
  
  public static String closeNetLogAndSavaToLocal()
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b()))
    {
      localObject = ((x)localObject).c().b();
      try
      {
        localObject = ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "closeNetLogAndSavaToLocal", new Class[0], new Object[0]);
        if ((localObject != null) && ((localObject instanceof String)))
        {
          localObject = (String)localObject;
          return localObject;
        }
      }
      catch (Exception localException) {}
      return "";
    }
    return "";
  }
  
  public static void continueLoadSo(Context paramContext)
  {
    if (("com.tencent.mm".equals(getCurrentProcessName(paramContext))) && (WebView.mWebViewCreated)) {
      i.a(s, "continueLoadSo", new Class[0], new Object[0]);
    }
  }
  
  public static boolean createMiniQBShortCut(Context paramContext, String paramString1, String paramString2, Drawable paramDrawable)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    if (isMiniQBShortCutExist(paramContext, paramString1, paramString2) == true) {
      return false;
    }
    x localx = x.a();
    if ((localx != null) && (localx.b()))
    {
      Bitmap localBitmap = null;
      if ((paramDrawable instanceof BitmapDrawable)) {
        localBitmap = ((BitmapDrawable)paramDrawable).getBitmap();
      }
      paramDrawable = localx.c().b();
      TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
      paramContext = paramDrawable.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[] { Context.class, String.class, String.class, Bitmap.class }, new Object[] { paramContext, paramString1, paramString2, localBitmap });
      TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: " + paramContext);
      return paramContext != null;
    }
    return false;
  }
  
  private static void d(Context paramContext)
  {
    int i6 = -1;
    E = true;
    try
    {
      if (Build.VERSION.SDK_INT >= 11) {
        localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          i3 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_recorder", -1);
          if (i3 < 0) {
            continue;
          }
          i1 = i3 + 1;
          if (i1 > 4)
          {
            return;
            localObject1 = paramContext.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            continue;
          }
          i3 = i1;
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          int i2;
          int i5;
          Object localObject2;
          int i4;
          Object localObject3;
          int i3 = -1;
          int i1 = -1;
          continue;
          i1 = -1;
          continue;
        }
        try
        {
          i2 = p.a().j(paramContext);
          if (i2 <= 0) {
            continue;
          }
          if (i3 > 4) {}
        }
        catch (Throwable localThrowable3)
        {
          i2 = -1;
          i3 = i1;
          i1 = i2;
          continue;
        }
        try
        {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_recorder", i3).commit();
          i5 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
          i3 = i1;
          localObject2 = localObject1;
          i4 = i2;
          if (i5 < 0) {
            continue;
          }
          localObject2 = ((SharedPreferences)localObject1).edit();
          i5 += 1;
          ((SharedPreferences.Editor)localObject2).putInt("tbs_preload_x5_counter", i5).commit();
          if (i5 <= 3) {
            continue;
          }
          try
          {
            i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_version", -1);
            localObject1 = ((SharedPreferences)localObject1).edit();
            if (i1 != i2) {
              continue;
            }
            FileUtil.a(p.a().r(paramContext), false);
            paramContext = n.a(paramContext).a();
            if (paramContext != null) {
              FileUtil.a(paramContext, false);
            }
            TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
            ((SharedPreferences.Editor)localObject1).putInt("tbs_precheck_disable_version", i1);
            ((SharedPreferences.Editor)localObject1).commit();
            return;
          }
          catch (Throwable paramContext)
          {
            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(paramContext));
            return;
          }
          localThrowable1 = localThrowable1;
          localObject1 = null;
          i1 = -1;
          i3 = -1;
        }
        catch (Throwable localThrowable4)
        {
          i3 = i1;
          i1 = i2;
          continue;
        }
        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(localThrowable1));
        i4 = i1;
        localObject3 = localObject1;
        i5 = -1;
        i1 = i3;
        localObject1 = localObject3;
        i2 = i4;
        continue;
        TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i1);
      }
      i2 = i6;
      if (i1 > 0)
      {
        i2 = i6;
        if (i1 <= 3)
        {
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
          x.a().a(paramContext);
          TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
          i2 = 0;
        }
      }
      try
      {
        i1 = ((SharedPreferences)localObject1).getInt("tbs_preload_x5_counter", -1);
        if (i1 > 0) {
          ((SharedPreferences)localObject1).edit().putInt("tbs_preload_x5_counter", i1 - 1).commit();
        }
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(paramContext));
        }
      }
      TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:" + i2);
      return;
    }
  }
  
  public static boolean deleteMiniQBShortCut(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {}
    x localx;
    do
    {
      do
      {
        do
        {
          return false;
        } while (TbsDownloader.getOverSea(paramContext));
        localx = x.a();
      } while ((localx == null) || (!localx.b()));
    } while (localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[] { Context.class, String.class, String.class }, new Object[] { paramContext, paramString1, paramString2 }) == null);
    return true;
  }
  
  public static void disAllowThirdAppDownload()
  {
    c = false;
  }
  
  public static void disableAutoCreateX5Webview()
  {
    j = false;
  }
  
  public static void disableSensitiveApi()
  {
    y = false;
    HashMap localHashMap = new HashMap();
    localHashMap.put("no_sensitive_api", Boolean.valueOf(true));
    initTbsSettings(localHashMap);
  }
  
  public static void fileInfoDetect(Context paramContext, String paramString, android.webkit.ValueCallback<String> paramValueCallback)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {}
    try
    {
      localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[] { Context.class, String.class, android.webkit.ValueCallback.class }, new Object[] { paramContext, paramString, paramValueCallback });
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void forceSysWebView()
  {
    b = true;
    v = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
    TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
  }
  
  public static long getApkFileSize(Context paramContext)
  {
    long l1 = 0L;
    if (paramContext != null) {
      l1 = TbsDownloadConfig.getInstance(paramContext.getApplicationContext()).mPreferences.getLong("tbs_apkfilesize", 0L);
    }
    return l1;
  }
  
  /* Error */
  public static String getCurrentProcessName(Context paramContext)
  {
    // Byte code:
    //   0: new 906	java/io/FileInputStream
    //   3: dup
    //   4: ldc_w 1243
    //   7: invokespecial 1244	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_3
    //   11: aload_3
    //   12: astore_0
    //   13: sipush 256
    //   16: newarray byte
    //   18: astore 4
    //   20: iconst_0
    //   21: istore_1
    //   22: aload_3
    //   23: astore_0
    //   24: aload_3
    //   25: invokevirtual 1247	java/io/FileInputStream:read	()I
    //   28: istore_2
    //   29: iload_2
    //   30: ifle +25 -> 55
    //   33: aload_3
    //   34: astore_0
    //   35: iload_1
    //   36: aload 4
    //   38: arraylength
    //   39: if_icmpge +16 -> 55
    //   42: aload 4
    //   44: iload_1
    //   45: iload_2
    //   46: i2b
    //   47: bastore
    //   48: iload_1
    //   49: iconst_1
    //   50: iadd
    //   51: istore_1
    //   52: goto -30 -> 22
    //   55: iload_1
    //   56: ifle +40 -> 96
    //   59: aload_3
    //   60: astore_0
    //   61: new 265	java/lang/String
    //   64: dup
    //   65: aload 4
    //   67: iconst_0
    //   68: iload_1
    //   69: ldc_w 1249
    //   72: invokespecial 1252	java/lang/String:<init>	([BIILjava/lang/String;)V
    //   75: astore 4
    //   77: aload_3
    //   78: ifnull +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 1253	java/io/FileInputStream:close	()V
    //   85: aload 4
    //   87: areturn
    //   88: astore_0
    //   89: aload_0
    //   90: invokevirtual 1254	java/io/IOException:printStackTrace	()V
    //   93: aload 4
    //   95: areturn
    //   96: aload_3
    //   97: ifnull +7 -> 104
    //   100: aload_3
    //   101: invokevirtual 1253	java/io/FileInputStream:close	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual 1254	java/io/IOException:printStackTrace	()V
    //   111: goto -7 -> 104
    //   114: astore 4
    //   116: aconst_null
    //   117: astore_3
    //   118: aload_3
    //   119: astore_0
    //   120: aload 4
    //   122: invokevirtual 590	java/lang/Throwable:printStackTrace	()V
    //   125: aload_3
    //   126: ifnull -22 -> 104
    //   129: aload_3
    //   130: invokevirtual 1253	java/io/FileInputStream:close	()V
    //   133: goto -29 -> 104
    //   136: astore_0
    //   137: aload_0
    //   138: invokevirtual 1254	java/io/IOException:printStackTrace	()V
    //   141: goto -37 -> 104
    //   144: astore_3
    //   145: aconst_null
    //   146: astore_0
    //   147: aload_0
    //   148: ifnull +7 -> 155
    //   151: aload_0
    //   152: invokevirtual 1253	java/io/FileInputStream:close	()V
    //   155: aload_3
    //   156: athrow
    //   157: astore_0
    //   158: aload_0
    //   159: invokevirtual 1254	java/io/IOException:printStackTrace	()V
    //   162: goto -7 -> 155
    //   165: astore_3
    //   166: goto -19 -> 147
    //   169: astore 4
    //   171: goto -53 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramContext	Context
    //   21	48	1	i1	int
    //   28	18	2	i2	int
    //   10	120	3	localFileInputStream	java.io.FileInputStream
    //   144	12	3	localObject1	Object
    //   165	1	3	localObject2	Object
    //   18	76	4	localObject3	Object
    //   114	7	4	localThrowable1	Throwable
    //   169	1	4	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/io/IOException
    //   100	104	106	java/io/IOException
    //   0	11	114	java/lang/Throwable
    //   129	133	136	java/io/IOException
    //   0	11	144	finally
    //   151	155	157	java/io/IOException
    //   13	20	165	finally
    //   24	29	165	finally
    //   35	42	165	finally
    //   61	77	165	finally
    //   120	125	165	finally
    //   13	20	169	java/lang/Throwable
    //   24	29	169	java/lang/Throwable
    //   35	42	169	java/lang/Throwable
    //   61	77	169	java/lang/Throwable
  }
  
  public static String[] getDexLoaderFileList(Context paramContext1, Context paramContext2, String paramString)
  {
    int i1 = 0;
    if ((u instanceof String[]))
    {
      int i2 = u.length;
      paramContext2 = new String[i2];
      for (;;)
      {
        paramContext1 = paramContext2;
        if (i1 >= i2) {
          break;
        }
        paramContext2[i1] = (paramString + u[i1]);
        i1 += 1;
      }
    }
    paramContext1 = i.a(s, "getJarFiles", new Class[] { Context.class, Context.class, String.class }, new Object[] { paramContext1, paramContext2, paramString });
    if ((paramContext1 instanceof String[])) {}
    for (;;)
    {
      paramContext1 = (String[])paramContext1;
      return paramContext1;
      paramContext1 = new String[1];
      paramContext1[0] = "";
    }
  }
  
  public static boolean getDownloadWithoutWifi()
  {
    return H;
  }
  
  public static boolean getIsInitX5Environment()
  {
    return k;
  }
  
  public static boolean getIsSysWebViewForcedByOuter()
  {
    return b;
  }
  
  public static boolean getJarFilesAndLibraryPath(Context paramContext)
  {
    if (s == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
      return false;
    }
    Bundle localBundle = (Bundle)i.a(s, "canLoadX5CoreAndNotLoadSo", new Class[] { Integer.TYPE }, new Object[] { Integer.valueOf(44085) });
    if (localBundle == null)
    {
      TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + p.a().a(true, paramContext));
      return false;
    }
    u = localBundle.getStringArray("tbs_jarfiles");
    d = localBundle.getString("tbs_librarypath");
    return true;
  }
  
  public static String getMiniQBVersion(Context paramContext)
  {
    x localx = x.a();
    localx.a(paramContext);
    if ((localx != null) && (localx.b())) {
      return localx.c().f();
    }
    return null;
  }
  
  public static boolean getOnlyDownload()
  {
    return l;
  }
  
  public static String getQQBuildNumber()
  {
    return C;
  }
  
  public static Map<String, Object> getSettings()
  {
    return o;
  }
  
  public static boolean getTBSInstalling()
  {
    return I;
  }
  
  public static String getTID()
  {
    return B;
  }
  
  public static File getTbsFolderDir(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (b.b())
      {
        File localFile = paramContext.getDir("tbs_64", 0);
        return localFile;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramContext.getDir("tbs", 0);
  }
  
  public static String getTbsResourcesPath(Context paramContext)
  {
    return TbsShareManager.g(paramContext);
  }
  
  public static int getTbsSdkVersion()
  {
    return 44085;
  }
  
  public static int getTbsVersion(Context paramContext)
  {
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      return TbsShareManager.a(paramContext, false);
    }
    return p.a().j(paramContext);
  }
  
  public static int getTbsVersionForCrash(Context paramContext)
  {
    int i1;
    if (TbsShareManager.isThirdPartyApp(paramContext)) {
      i1 = TbsShareManager.a(paramContext, false);
    }
    int i2;
    do
    {
      do
      {
        return i1;
        i2 = p.a().k(paramContext);
        i1 = i2;
      } while (i2 != 0);
      i1 = i2;
    } while (n.a(paramContext).c() != 3);
    reset(paramContext);
    return i2;
  }
  
  public static int getTmpDirTbsVersion(Context paramContext)
  {
    int i1 = 0;
    if (n.a(paramContext).c() == 2) {
      i1 = p.a().e(paramContext, 0);
    }
    while (n.a(paramContext).b("copy_status") != 1) {
      return i1;
    }
    return p.a().e(paramContext, 1);
  }
  
  public static void initBuglyAsync(boolean paramBoolean)
  {
    i = paramBoolean;
  }
  
  public static void initForinitAndNotLoadSo(Context paramContext)
  {
    if (r == null)
    {
      localObject1 = p.a().r(paramContext);
      if (localObject1 == null) {
        Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo optDir == null");
      }
    }
    else
    {
      return;
    }
    Object localObject2 = new File((File)localObject1, "tbs_sdk_extension_dex.jar");
    if (!((File)localObject2).exists())
    {
      Log.e("QbSdk", "QbSdk initForinitAndNotLoadSo dexFile.exists()=false");
      return;
    }
    Object localObject1 = ((File)localObject1).getAbsolutePath();
    x.a().b(paramContext);
    m.a(paramContext);
    String str = ((File)localObject2).getParent();
    localObject2 = ((File)localObject2).getAbsolutePath();
    Map localMap = getSettings();
    r = new DexLoader(str, paramContext, new String[] { localObject2 }, (String)localObject1, localMap).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
  }
  
  public static void initTbsSettings(Map<String, Object> paramMap)
  {
    if (o == null)
    {
      o = paramMap;
      return;
    }
    try
    {
      o.putAll(paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      paramMap.printStackTrace();
    }
  }
  
  public static void initX5Environment(Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    TbsLog.initIfNeed(paramContext);
    if (paramContext == null)
    {
      TbsLog.e("QbSdk", "initX5Environment,context=null");
      return;
    }
    b(paramContext);
    G = new TbsListener()
    {
      public void onDownloadFinish(int paramAnonymousInt) {}
      
      public void onDownloadProgress(int paramAnonymousInt) {}
      
      public void onInstallFinish(int paramAnonymousInt)
      {
        QbSdk.preInit(this.a, paramPreInitCallback);
      }
    };
    p localp;
    if (TbsShareManager.isThirdPartyApp(paramContext))
    {
      localp = p.a();
      if (g.a != 0) {
        break label82;
      }
    }
    label82:
    for (boolean bool = true;; bool = false)
    {
      localp.b(paramContext, bool);
      TbsDownloader.needDownload(paramContext, false, false, true, new TbsDownloader.TbsDownloaderCallback()
      {
        public void onNeedDownloadFinish(boolean paramAnonymousBoolean, int paramAnonymousInt)
        {
          if ((TbsShareManager.findCoreForThirdPartyApp(this.a) == 0) && (!TbsShareManager.getCoreDisabled())) {
            TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
          }
          if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(this.a))) {
            TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
          }
          QbSdk.preInit(this.a, paramPreInitCallback);
        }
      });
      k = true;
      return;
    }
  }
  
  public static boolean installLocalQbApk(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    boolean bool2 = false;
    g localg = g.a(true);
    localg.a(paramContext, false, false);
    boolean bool1 = bool2;
    if (localg != null)
    {
      bool1 = bool2;
      if (localg.b()) {
        bool1 = localg.a().a(paramContext, paramString1, paramString2, paramBundle);
      }
    }
    return bool1;
  }
  
  public static void installLocalTbsCore(Context paramContext, int paramInt, String paramString)
  {
    p.a().a(paramContext, paramString, paramInt);
  }
  
  public static boolean intentDispatch(WebView paramWebView, Intent paramIntent, String paramString1, String paramString2)
  {
    if (paramWebView == null) {
      return false;
    }
    Context localContext;
    int i1;
    if (paramString1.startsWith("mttbrowser://miniqb/ch=icon?"))
    {
      localContext = paramWebView.getContext();
      i1 = paramString1.indexOf("url=");
      if (i1 <= 0) {
        break label183;
      }
    }
    label183:
    for (paramIntent = paramString1.substring(i1 + 4);; paramIntent = null)
    {
      HashMap localHashMap = new HashMap();
      paramString1 = "unknown";
      try
      {
        String str = localContext.getApplicationInfo().packageName;
        paramString1 = str;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
        paramWebView.loadUrl(paramIntent);
      }
      localHashMap.put("ChannelID", paramString1);
      localHashMap.put("PosID", "14004");
      if ("miniqb://home".equals(paramIntent)) {}
      for (paramString1 = "qb://navicard/addCard?cardId=168&cardName=168";; paramString1 = paramIntent)
      {
        if (MttLoader.loadUrl(localContext, paramString1, localHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0)
        {
          paramString1 = x.a();
          if ((paramString1 != null) && (paramString1.b()) && (paramString1.c().a(localContext, paramIntent, null, paramString2, null) == 0)) {
            return true;
          }
        }
        for (;;)
        {
          return false;
          paramWebView.loadUrl(paramString1);
        }
      }
    }
  }
  
  public static boolean isEnableCanGetSubscriberId()
  {
    return L;
  }
  
  public static boolean isEnableGetAndroidID()
  {
    return K;
  }
  
  public static boolean isEnableGetDeviceID()
  {
    return J;
  }
  
  public static boolean isEnableSensitiveApi()
  {
    return y;
  }
  
  public static boolean isInDefaultBrowser(Context paramContext, String paramString)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("tbs_file_open_dialog_config", 0);
    paramString = e.d(paramString);
    paramContext = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramContext = "*/*";
    }
    return localSharedPreferences.contains("key_tbs_picked_default_browser_" + paramContext);
  }
  
  public static boolean isMiniQBShortCutExist(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return false;
    }
    if (TbsDownloader.getOverSea(paramContext)) {
      return false;
    }
    paramString2 = x.a();
    if ((paramString2 != null) && (paramString2.b()))
    {
      paramContext = paramString2.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[] { Context.class, String.class }, new Object[] { paramContext, paramString1 });
      if (paramContext != null) {
        if (!(paramContext instanceof Boolean)) {
          break label99;
        }
      }
    }
    label99:
    for (paramContext = (Boolean)paramContext;; paramContext = Boolean.valueOf(false))
    {
      return paramContext.booleanValue();
      return false;
      return false;
    }
  }
  
  public static boolean isNeedInitX5FirstTime()
  {
    return x;
  }
  
  public static boolean isSuportOpenFile(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      return Arrays.asList(new String[] { "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub" }).contains(paramString.toLowerCase());
    }
    return Arrays.asList(new String[] { "rar", "zip", "tar", "bz2", "gz", "7z", "doc", "docx", "ppt", "pptx", "xls", "xlsx", "txt", "pdf", "epub", "chm", "html", "htm", "xml", "mht", "url", "ini", "log", "bat", "php", "js", "lrc", "jpg", "jpeg", "png", "gif", "bmp", "tiff", "webp", "mp3", "m4a", "aac", "amr", "wav", "ogg", "mid", "ra", "wma", "mpga", "ape", "flac", "RTSP", "RTP", "SDP", "RTMP", "mp4", "flv", "avi", "3gp", "3gpp", "webm", "ts", "ogv", "m3u8", "asf", "wmv", "rmvb", "rm", "f4v", "dat", "mov", "mpg", "mkv", "mpeg", "mpeg1", "mpeg2", "xvid", "dvd", "vcd", "vob", "divx" }).contains(paramString.toLowerCase());
  }
  
  public static boolean isTbsCoreInited()
  {
    boolean bool2 = false;
    g localg = g.a(false);
    boolean bool1 = bool2;
    if (localg != null)
    {
      bool1 = bool2;
      if (localg.g()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean isX5DisabledSync(Context paramContext)
  {
    if (n.a(paramContext).c() == 2) {}
    for (int i1 = 1; i1 != 0; i1 = 0) {
      return false;
    }
    if (!c(paramContext)) {
      return true;
    }
    i1 = p.a().j(paramContext);
    paramContext = i.a(s, "isX5DisabledSync", new Class[] { Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(i1), Integer.valueOf(44085) });
    if (paramContext != null) {
      return ((Boolean)paramContext).booleanValue();
    }
    return true;
  }
  
  /* Error */
  public static void loadTBSSDKExtension(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: iconst_1
    //   4: istore_2
    //   5: getstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   8: ifnull +4 -> 12
    //   11: return
    //   12: ldc 2
    //   14: monitorenter
    //   15: getstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   18: ifnull +13 -> 31
    //   21: ldc 2
    //   23: monitorexit
    //   24: return
    //   25: astore_0
    //   26: ldc 2
    //   28: monitorexit
    //   29: aload_0
    //   30: athrow
    //   31: getstatic 132	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Class;
    //   34: ifnonnull +12 -> 46
    //   37: ldc_w 366
    //   40: ldc_w 1575
    //   43: invokestatic 429	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: getstatic 132	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Class;
    //   49: iconst_5
    //   50: anewarray 233	java/lang/Class
    //   53: dup
    //   54: iconst_0
    //   55: ldc 235
    //   57: aastore
    //   58: dup
    //   59: iconst_1
    //   60: ldc 235
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: ldc_w 265
    //   68: aastore
    //   69: dup
    //   70: iconst_3
    //   71: ldc_w 265
    //   74: aastore
    //   75: dup
    //   76: iconst_4
    //   77: ldc_w 265
    //   80: aastore
    //   81: invokevirtual 1579	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   84: astore_3
    //   85: aload_0
    //   86: invokestatic 529	com/tencent/smtt/sdk/TbsShareManager:isThirdPartyApp	(Landroid/content/Context;)Z
    //   89: ifeq +257 -> 346
    //   92: aload_0
    //   93: invokestatic 876	com/tencent/smtt/sdk/TbsShareManager:e	(Landroid/content/Context;)Landroid/content/Context;
    //   96: astore 5
    //   98: aload 5
    //   100: ifnonnull +43 -> 143
    //   103: invokestatic 593	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   106: ifnonnull +37 -> 143
    //   109: invokestatic 391	com/tencent/smtt/sdk/TbsCoreLoadStat:getInstance	()Lcom/tencent/smtt/sdk/TbsCoreLoadStat;
    //   112: aload_0
    //   113: sipush 227
    //   116: invokevirtual 394	com/tencent/smtt/sdk/TbsCoreLoadStat:a	(Landroid/content/Context;I)V
    //   119: ldc_w 366
    //   122: ldc_w 1580
    //   125: ldc_w 1582
    //   128: invokestatic 541	com/tencent/smtt/utils/TbsLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   131: ldc 2
    //   133: monitorexit
    //   134: return
    //   135: astore_3
    //   136: iconst_0
    //   137: istore_2
    //   138: aconst_null
    //   139: astore_3
    //   140: goto -55 -> 85
    //   143: aload_0
    //   144: astore 4
    //   146: aload_0
    //   147: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   150: ifnull +9 -> 159
    //   153: aload_0
    //   154: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   157: astore 4
    //   159: iload_2
    //   160: ifne +148 -> 308
    //   163: aload 5
    //   165: ifnonnull +67 -> 232
    //   168: getstatic 132	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Class;
    //   171: iconst_3
    //   172: anewarray 233	java/lang/Class
    //   175: dup
    //   176: iconst_0
    //   177: ldc 235
    //   179: aastore
    //   180: dup
    //   181: iconst_1
    //   182: ldc 235
    //   184: aastore
    //   185: dup
    //   186: iconst_2
    //   187: ldc_w 265
    //   190: aastore
    //   191: invokevirtual 1579	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   194: iconst_5
    //   195: anewarray 4	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: aload 4
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 5
    //   207: aastore
    //   208: dup
    //   209: iconst_2
    //   210: invokestatic 593	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   213: aastore
    //   214: dup
    //   215: iconst_3
    //   216: aload_1
    //   217: aastore
    //   218: dup
    //   219: iconst_4
    //   220: aconst_null
    //   221: aastore
    //   222: invokevirtual 1588	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   225: putstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   228: ldc 2
    //   230: monitorexit
    //   231: return
    //   232: getstatic 132	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Class;
    //   235: iconst_2
    //   236: anewarray 233	java/lang/Class
    //   239: dup
    //   240: iconst_0
    //   241: ldc 235
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: ldc 235
    //   248: aastore
    //   249: invokevirtual 1579	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   252: iconst_2
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload 4
    //   260: aastore
    //   261: dup
    //   262: iconst_1
    //   263: aload 5
    //   265: aastore
    //   266: invokevirtual 1588	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   269: putstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   272: goto -44 -> 228
    //   275: astore_0
    //   276: ldc_w 366
    //   279: new 356	java/lang/StringBuilder
    //   282: dup
    //   283: invokespecial 357	java/lang/StringBuilder:<init>	()V
    //   286: ldc_w 1590
    //   289: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: invokestatic 386	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   296: invokevirtual 363	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 406	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -77 -> 228
    //   308: aload_3
    //   309: iconst_5
    //   310: anewarray 4	java/lang/Object
    //   313: dup
    //   314: iconst_0
    //   315: aload 4
    //   317: aastore
    //   318: dup
    //   319: iconst_1
    //   320: aload 5
    //   322: aastore
    //   323: dup
    //   324: iconst_2
    //   325: invokestatic 593	com/tencent/smtt/sdk/TbsShareManager:getHostCorePathAppDefined	()Ljava/lang/String;
    //   328: aastore
    //   329: dup
    //   330: iconst_3
    //   331: aload_1
    //   332: aastore
    //   333: dup
    //   334: iconst_4
    //   335: aconst_null
    //   336: aastore
    //   337: invokevirtual 1588	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   340: putstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   343: goto -115 -> 228
    //   346: iload_2
    //   347: ifne +60 -> 407
    //   350: getstatic 132	com/tencent/smtt/sdk/QbSdk:r	Ljava/lang/Class;
    //   353: iconst_2
    //   354: anewarray 233	java/lang/Class
    //   357: dup
    //   358: iconst_0
    //   359: ldc 235
    //   361: aastore
    //   362: dup
    //   363: iconst_1
    //   364: ldc 235
    //   366: aastore
    //   367: invokevirtual 1579	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   370: astore_3
    //   371: aload_0
    //   372: astore_1
    //   373: aload_0
    //   374: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   377: ifnull +8 -> 385
    //   380: aload_0
    //   381: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   384: astore_1
    //   385: aload_3
    //   386: iconst_2
    //   387: anewarray 4	java/lang/Object
    //   390: dup
    //   391: iconst_0
    //   392: aload_1
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: aload_1
    //   397: aastore
    //   398: invokevirtual 1588	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   401: putstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   404: goto -176 -> 228
    //   407: aload 5
    //   409: astore 4
    //   411: ldc_w 1127
    //   414: aload_0
    //   415: invokestatic 1130	com/tencent/smtt/sdk/QbSdk:getCurrentProcessName	(Landroid/content/Context;)Ljava/lang/String;
    //   418: invokevirtual 971	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   421: ifeq +18 -> 439
    //   424: aload 5
    //   426: astore 4
    //   428: getstatic 1133	com/tencent/smtt/sdk/WebView:mWebViewCreated	Z
    //   431: ifne +8 -> 439
    //   434: ldc_w 1592
    //   437: astore 4
    //   439: aload_0
    //   440: astore 5
    //   442: aload_0
    //   443: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   446: ifnull +9 -> 455
    //   449: aload_0
    //   450: invokevirtual 880	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   453: astore 5
    //   455: aload_3
    //   456: iconst_5
    //   457: anewarray 4	java/lang/Object
    //   460: dup
    //   461: iconst_0
    //   462: aload 5
    //   464: aastore
    //   465: dup
    //   466: iconst_1
    //   467: aload 5
    //   469: aastore
    //   470: dup
    //   471: iconst_2
    //   472: aconst_null
    //   473: aastore
    //   474: dup
    //   475: iconst_3
    //   476: aload_1
    //   477: aastore
    //   478: dup
    //   479: iconst_4
    //   480: aload 4
    //   482: aastore
    //   483: invokevirtual 1588	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   486: putstatic 134	com/tencent/smtt/sdk/QbSdk:s	Ljava/lang/Object;
    //   489: goto -261 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	492	0	paramContext	Context
    //   0	492	1	paramString	String
    //   4	343	2	i1	int
    //   84	1	3	localConstructor1	java.lang.reflect.Constructor
    //   135	1	3	localThrowable	Throwable
    //   139	317	3	localConstructor2	java.lang.reflect.Constructor
    //   144	337	4	localObject	Object
    //   1	467	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   15	24	25	finally
    //   26	29	25	finally
    //   31	46	25	finally
    //   46	85	25	finally
    //   85	98	25	finally
    //   103	131	25	finally
    //   131	134	25	finally
    //   146	159	25	finally
    //   168	228	25	finally
    //   228	231	25	finally
    //   232	272	25	finally
    //   276	305	25	finally
    //   308	343	25	finally
    //   350	371	25	finally
    //   373	385	25	finally
    //   385	404	25	finally
    //   411	424	25	finally
    //   428	434	25	finally
    //   442	455	25	finally
    //   455	489	25	finally
    //   46	85	135	java/lang/Throwable
    //   85	98	275	java/lang/Throwable
    //   103	131	275	java/lang/Throwable
    //   146	159	275	java/lang/Throwable
    //   168	228	275	java/lang/Throwable
    //   232	272	275	java/lang/Throwable
    //   308	343	275	java/lang/Throwable
    //   350	371	275	java/lang/Throwable
    //   373	385	275	java/lang/Throwable
    //   385	404	275	java/lang/Throwable
    //   411	424	275	java/lang/Throwable
    //   428	434	275	java/lang/Throwable
    //   442	455	275	java/lang/Throwable
    //   455	489	275	java/lang/Throwable
  }
  
  public static void openBrowserList(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
        String str = "";
        if (paramBundle != null) {
          str = paramBundle.getString("ChannelId");
        }
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.addCategory("android.intent.category.DEFAULT");
        localIntent.setData(Uri.parse(paramString));
        paramString = e.d(paramString);
        isDefaultDialog = false;
        paramString = new d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, paramString, str);
        paramBundle = paramString.a();
        if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle))) {
          break;
        }
        if ("com.tencent.mtt".equals(paramBundle))
        {
          localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
          localIntent.putExtra("PosID", "4");
        }
        localIntent.setPackage(paramBundle);
        localIntent.putExtra("big_brother_source_key", str);
        paramContext.startActivity(localIntent);
      } while (paramValueCallback == null);
      paramValueCallback.onReceiveValue("default browser:" + paramBundle);
      return;
      if (!isDefaultDialog) {
        break;
      }
      new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }).show();
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("can not open");
    return;
    paramString.show();
    paramString.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        if (this.a != null) {
          this.a.onReceiveValue("TbsReaderDialogClosed");
        }
      }
    });
  }
  
  public static void openBrowserList(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    openBrowserList(paramContext, paramString, null, paramValueCallback);
  }
  
  public static int openFileReader(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    Object localObject = paramHashMap;
    if (paramHashMap == null) {
      localObject = new HashMap();
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 505);
    if (!checkContentProviderPrivilage(paramContext))
    {
      TbsLog.e("QbSdk", "Got an unexpected result when check content provider privilege above api 24");
      return -5;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      paramHashMap = paramString.substring(paramString.lastIndexOf(".") + 1).toLowerCase();
      String str = (String)((HashMap)localObject).get("fileext");
      if (!TextUtils.isEmpty(str)) {
        paramHashMap = str;
      }
      if (paramHashMap == null) {
        TbsLog.e("QbSdk", "open openFileReader null file type");
      }
      if ("apk".equalsIgnoreCase(paramHashMap))
      {
        paramHashMap = new Intent("android.intent.action.VIEW");
        if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
          paramHashMap.addFlags(1);
        }
        paramString = FileProvider.a(paramContext, paramString);
        if (paramString == null)
        {
          paramValueCallback.onReceiveValue("uri failed");
          return -6;
        }
        paramHashMap.setDataAndType(paramString, "application/vnd.android.package-archive");
        paramContext.startActivity(paramHashMap);
        TbsCoreLoadStat.getInstance().a(paramContext, 506);
        TbsLog.e("QbSdk", "open openFileReader ret = 4");
        return 4;
      }
      if (MttLoader.isBrowserInstalled(paramContext))
      {
        if (!isSuportOpenFile(paramHashMap, 2))
        {
          TbsLog.e("QbSdk", "Open file reader in qq browser, isQBSupport: false  ret = 3");
          openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
          TbsCoreLoadStat.getInstance().a(paramContext, 507);
          return 3;
        }
        if (startQBForDoc(paramContext, paramString, 4, 0, paramHashMap, a(paramContext, (Map)localObject)))
        {
          if (paramValueCallback != null) {
            paramValueCallback.onReceiveValue("open QB");
          }
          TbsCoreLoadStat.getInstance().a(paramContext, 507);
          TbsLog.e("QbSdk", "open openFileReader open QB ret = 1");
          return 1;
        }
      }
    }
    else
    {
      if (paramValueCallback != null) {
        paramValueCallback.onReceiveValue("filepath error");
      }
      TbsCoreLoadStat.getInstance().a(paramContext, 509);
      TbsLog.e("QbSdk", "open openFileReader filepath error ret -1");
      return -1;
    }
    ((HashMap)localObject).put("local", "true");
    TbsLog.setWriteLogJIT(true);
    int i1 = startMiniQBToLoadUrl(paramContext, paramString, (HashMap)localObject, paramValueCallback);
    if (i1 != 0)
    {
      openFileReaderListWithQBDownload(paramContext, paramString, paramValueCallback);
      TbsLogReport.getInstance(paramContext).setLoadErrorCode(511, "" + i1);
      return 3;
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 510);
    return 2;
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, Bundle paramBundle, ValueCallback<String> paramValueCallback)
  {
    if ((paramContext == null) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.qim")) || (paramContext.getApplicationInfo().packageName.equals("com.tencent.androidqqmail"))) {}
    do
    {
      return;
      String str1 = "";
      if (paramBundle != null) {
        str1 = paramBundle.getString("ChannelId");
      }
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addCategory("android.intent.category.DEFAULT");
      String str2 = e.d(paramString);
      if ((paramContext != null) && (paramContext.getApplicationInfo().targetSdkVersion >= 24) && (Build.VERSION.SDK_INT >= 24)) {
        localIntent.addFlags(1);
      }
      Uri localUri = FileProvider.a(paramContext, paramString);
      if (localUri == null)
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,uri failed");
        paramValueCallback.onReceiveValue("uri failed");
        return;
      }
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,fileUri:" + paramString + ",mimeType:" + str2);
      localIntent.setDataAndType(localUri, str2);
      isDefaultDialog = false;
      paramString = new d(paramContext, "选择其它应用打开", localIntent, paramBundle, paramValueCallback, str2, str1);
      paramBundle = paramString.a();
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload,defaultBrowser:" + paramBundle);
      if ((paramBundle != null) && (!TextUtils.isEmpty(paramBundle)) && (paramBundle.startsWith("extraMenuEvent:")))
      {
        TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default extra menu action");
        paramValueCallback.onReceiveValue(paramBundle);
        return;
      }
      if ((paramBundle == null) || (TextUtils.isEmpty(paramBundle)) || (!checkApkExist(paramContext, paramBundle))) {
        break;
      }
      TbsLog.i("QbSdk", "openFileReaderListWithQBDownload, is default normal menu action");
      if ("com.tencent.mtt".equals(paramBundle))
      {
        localIntent.putExtra("ChannelID", paramContext.getApplicationContext().getPackageName());
        localIntent.putExtra("PosID", "4");
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("big_brother_source_key", str1);
      }
      localIntent.setPackage(paramBundle);
      paramContext.startActivity(localIntent);
    } while (paramValueCallback == null);
    paramValueCallback.onReceiveValue("default browser:" + paramBundle);
    return;
    if (("com.tencent.rtxlite".equalsIgnoreCase(paramContext.getApplicationContext().getPackageName())) && (isDefaultDialog))
    {
      new AlertDialog.Builder(paramContext).setTitle("提示").setMessage("此文件无法打开").setPositiveButton("确定", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }).show();
      return;
    }
    if (isDefaultDialog)
    {
      TbsLog.i("QbSdk", "isDefaultDialog=true");
      if (paramValueCallback != null)
      {
        TbsLog.i("QbSdk", "isDefaultDialog=true, can not open");
        paramValueCallback.onReceiveValue("can not open");
      }
    }
    for (;;)
    {
      TbsLog.i("QbSdk", "unexpected return, dialogBuilder not show!");
      return;
      try
      {
        TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog");
        paramString.show();
        paramString.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            if (this.a != null) {
              this.a.onReceiveValue("TbsReaderDialogClosed");
            }
          }
        });
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        TbsLog.i("QbSdk", "isDefaultDialog=false,try to open dialog, but failed");
        paramValueCallback.onReceiveValue("TbsReaderDialogClosed");
      }
    }
  }
  
  public static void openFileReaderListWithQBDownload(Context paramContext, String paramString, ValueCallback<String> paramValueCallback)
  {
    openFileReaderListWithQBDownload(paramContext, paramString, null, paramValueCallback);
  }
  
  public static int openFileWithQB(Context paramContext, String paramString1, String paramString2)
  {
    int i1 = 0;
    TbsLog.i("QbSdk", "open openFileReader startMiniQBToLoadUrl filepath = " + paramString1);
    if (!checkContentProviderPrivilage(paramContext)) {
      i1 = -1;
    }
    String str;
    HashMap localHashMap;
    do
    {
      return i1;
      if (paramString1 == null) {
        break label167;
      }
      str = paramString1.substring(paramString1.lastIndexOf(".") + 1).toLowerCase();
      if (!MttLoader.isBrowserInstalled(paramContext)) {
        break;
      }
      if (!isSuportOpenFile(str, 2))
      {
        TbsLog.i("QbSdk", "openFileReader open in QB isQBSupport: false");
        return -2;
      }
      localHashMap = new HashMap();
      localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
      localHashMap.put("PosID", Integer.toString(4));
    } while (MttLoader.openDocWithQb(paramContext, paramString1, 0, str, paramString2, localHashMap, null));
    TbsLog.i("QbSdk", "openFileReader startQBForDoc return false");
    return -3;
    TbsLog.i("QbSdk", "openFileReader QQ browser not installed");
    return -4;
    label167:
    TbsLog.i("QbSdk", "open openFileReader filepath error");
    return -5;
  }
  
  public static void openNetLog(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "openNetLog", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void pauseDownload() {}
  
  public static void preInit(Context paramContext)
  {
    try
    {
      preInit(paramContext, null);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void preInit(final Context paramContext, final PreInitCallback paramPreInitCallback)
  {
    try
    {
      TbsLog.initIfNeed(paramContext);
      TbsLog.i("QbSdk", "preInit", "processName: " + getCurrentProcessName(paramContext));
      m = a;
      if (!t)
      {
        TbsLog.i("QbSdk", "preInit", "#1# Start new thread to preInit");
        paramContext = new Thread()
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            switch (paramAnonymousMessage.what)
            {
            }
            do
            {
              return;
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(false);
              }
              TbsLog.writeLogToDisk();
              return;
              QbSdk.a(TbsExtensionFunctionManager.getInstance().canUseFunction(paramContext, "disable_unpreinit.txt"));
              if (QbSdk.j)
              {
                paramAnonymousMessage = x.a().c();
                if (paramAnonymousMessage != null) {
                  paramAnonymousMessage.a(paramContext);
                }
              }
              if (paramPreInitCallback != null) {
                paramPreInitCallback.onViewInitFinished(true);
              }
              TbsLog.writeLogToDisk();
              return;
            } while (paramPreInitCallback == null);
            paramPreInitCallback.onCoreInitFinished();
          }
        }
        {
          public void run()
          {
            int i = p.a().a(true, this.a);
            TbsDownloader.setAppContext(this.a);
            TbsLog.i("QbSdk", "QbSdk preinit ver is " + i);
            Object localObject = p.a();
            Context localContext = this.a;
            if (g.a == 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((p)localObject).b(localContext, bool);
              TbsLog.i("QbSdk", "preInit", "#2-1# prepare initAndLoadSo");
              g.a(true).a(this.a, false, false);
              TbsLog.i("QbSdk", "preInit", "#2-2# SDKEngine init finish");
              localObject = x.a();
              ((x)localObject).a(this.a);
              TbsLog.i("QbSdk", "preInit", "#2-3# X5CoreEngine init finish");
              bool = ((x)localObject).b();
              this.b.sendEmptyMessage(3);
              if (bool) {
                break;
              }
              this.b.sendEmptyMessage(2);
              return;
            }
            this.b.sendEmptyMessage(1);
          }
        };
        paramContext.setName("tbs_preinit");
        paramContext.setPriority(10);
        paramContext.start();
        t = true;
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void reset(Context paramContext)
  {
    reset(paramContext, false);
  }
  
  public static void reset(Context paramContext, boolean paramBoolean)
  {
    int i1 = 1;
    TbsLog.e("QbSdk", "QbSdk reset!", true);
    for (;;)
    {
      try
      {
        TbsDownloader.stopDownload();
        if ((paramBoolean) && (!TbsShareManager.isThirdPartyApp(paramContext)))
        {
          int i2 = p.a().i(paramContext);
          int i3 = p.a().j(paramContext);
          if ((i2 > 43300) && (i2 != i3))
          {
            TbsDownloader.c(paramContext);
            FileUtil.a(getTbsFolderDir(paramContext), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            p.a.set(Integer.valueOf(0));
            File localFile = new File(paramContext.getFilesDir(), "bugly_switch.txt");
            if ((localFile != null) && (localFile.exists())) {
              localFile.delete();
            }
            if (i1 != 0)
            {
              FileUtil.b(p.a().q(paramContext), p.a().f(paramContext, 0));
              p.a().c(paramContext);
            }
            return;
          }
        }
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      i1 = 0;
    }
  }
  
  public static void resetDecoupleCore(Context paramContext)
  {
    int i1 = 0;
    TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
    for (;;)
    {
      try
      {
        if (!q.b(paramContext)) {
          break label274;
        }
        Object localObject1 = TbsShareManager.getPackageContext(paramContext, "com.tencent.mm", false);
        if (localObject1 == null)
        {
          paramContext = new File(FileUtil.a(paramContext, "com.tencent.mm", 4, true));
          TbsLog.e("QbSdk", "QbSdk resetDecoupleCore! mFilePathStable is " + paramContext.getAbsolutePath(), true);
          localObject1 = paramContext.listFiles();
          Pattern localPattern = Pattern.compile(com.tencent.smtt.utils.a.a(false));
          int i2 = localObject1.length;
          if (i1 < i2)
          {
            Object localObject2 = localObject1[i1];
            if ((!localPattern.matcher(localObject2.getName()).find()) || (!localObject2.isFile()) || (!localObject2.exists())) {
              break label285;
            }
            TbsLog.i("TbsDownload", "QbSdk resetDecoupleCore file is " + localObject2.getAbsolutePath(), true);
            localObject2.delete();
            break label285;
          }
        }
        else
        {
          paramContext = new File(FileUtil.a((Context)localObject1, 4));
          continue;
        }
        paramContext = new File(paramContext, TbsDownloader.getBackupFileName(false));
      }
      catch (Throwable paramContext)
      {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(paramContext));
        return;
      }
      TbsLog.i("TbsDownload", "QbSdk resetDecoupleCore file is " + paramContext.getAbsolutePath(), true);
      paramContext.delete();
      return;
      label274:
      FileUtil.b(p.a().q(paramContext));
      return;
      label285:
      i1 += 1;
    }
  }
  
  public static void resumeDownload() {}
  
  public static void setCurrentID(String paramString)
  {
    if (paramString == null) {}
    while (!paramString.startsWith("QQ:")) {
      return;
    }
    paramString = paramString.substring("QQ:".length());
    B = "0000000000000000".substring(paramString.length()) + paramString;
  }
  
  public static void setDisableUnpreinitBySwitch(boolean paramBoolean)
  {
    D = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + D);
  }
  
  public static void setDisableUseHostBackupCoreBySwitch(boolean paramBoolean)
  {
    mDisableUseHostBackupCore = paramBoolean;
    TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
  }
  
  public static void setDownloadWithoutWifi(boolean paramBoolean)
  {
    H = paramBoolean;
  }
  
  public static void setNeedInitX5FirstTime(boolean paramBoolean)
  {
    x = paramBoolean;
  }
  
  public static void setNetLogEncryptionKey(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "setNetLogEncryptionKey", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void setNewDnsHostList(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "setNewDnsHostList", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static void setOnlyDownload(boolean paramBoolean)
  {
    l = paramBoolean;
  }
  
  public static void setQQBuildNumber(String paramString)
  {
    C = paramString;
  }
  
  public static void setTBSInstallingStatus(boolean paramBoolean)
  {
    I = paramBoolean;
  }
  
  public static void setTbsListener(TbsListener paramTbsListener)
  {
    F = paramTbsListener;
  }
  
  public static void setTbsLogClient(TbsLogClient paramTbsLogClient)
  {
    TbsLog.setTbsLogClient(paramTbsLogClient);
  }
  
  public static void setUploadCode(Context paramContext, int paramInt)
  {
    if ((paramInt >= 130) && (paramInt <= 139))
    {
      paramContext = TbsDownloadUpload.getInstance(paramContext);
      paramContext.a.put("tbs_needdownload_code", Integer.valueOf(paramInt));
      paramContext.commit();
    }
    while ((paramInt < 150) || (paramInt > 159)) {
      return;
    }
    paramContext = TbsDownloadUpload.getInstance(paramContext);
    paramContext.a.put("tbs_startdownload_code", Integer.valueOf(paramInt));
    paramContext.commit();
  }
  
  public static int startMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, android.webkit.ValueCallback<String> paramValueCallback)
  {
    TbsCoreLoadStat.getInstance().a(paramContext, 501);
    if (paramContext == null) {
      return -100;
    }
    x localx = x.a();
    localx.a(paramContext);
    if (localx.b())
    {
      int i1;
      if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
      {
        i1 = localx.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback);
        if (i1 != 0) {
          break label130;
        }
        TbsCoreLoadStat.getInstance().a(paramContext, 503);
      }
      for (;;)
      {
        Log.e("QbSdk", "startMiniQBToLoadUrl  ret = " + i1);
        return i1;
        return -101;
        label130:
        TbsLogReport.getInstance(paramContext).setLoadErrorCode(504, "" + i1);
      }
    }
    TbsCoreLoadStat.getInstance().a(paramContext, 502);
    Log.e("QbSdk", "startMiniQBToLoadUrl  ret = -102");
    return -102;
  }
  
  public static boolean startQBForDoc(Context paramContext, String paramString1, int paramInt1, int paramInt2, String paramString2, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationContext().getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt1));
    return MttLoader.openDocWithQb(paramContext, paramString1, paramInt2, paramString2, localHashMap, paramBundle);
  }
  
  public static boolean startQBForVideo(Context paramContext, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    return MttLoader.openVideoWithQb(paramContext, paramString, localHashMap);
  }
  
  public static boolean startQBToLoadurl(Context paramContext, String paramString, int paramInt, WebView paramWebView)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ChannelID", paramContext.getApplicationInfo().processName);
    localHashMap.put("PosID", Integer.toString(paramInt));
    WebView localWebView1 = paramWebView;
    if (paramWebView == null) {}
    try
    {
      Object localObject = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).packageName;
      if (localObject != "com.tencent.mm")
      {
        localWebView1 = paramWebView;
        if (localObject != "com.tencent.mobileqq") {}
      }
      else
      {
        localObject = x.a();
        localWebView1 = paramWebView;
        if (localObject != null)
        {
          localWebView1 = paramWebView;
          if (((x)localObject).b())
          {
            localObject = ((x)localObject).c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
            localWebView1 = paramWebView;
            if (localObject != null)
            {
              localObject = (IX5WebViewBase)localObject;
              localWebView1 = paramWebView;
              if (localObject != null) {
                localWebView1 = (WebView)((IX5WebViewBase)localObject).getView().getParent();
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        WebView localWebView2 = paramWebView;
      }
    }
    return MttLoader.loadUrl(paramContext, paramString, localHashMap, "QbSdk.startQBToLoadurl", localWebView1) == 0;
  }
  
  public static boolean startQBWithBrowserlist(Context paramContext, String paramString, int paramInt)
  {
    boolean bool = startQBToLoadurl(paramContext, paramString, paramInt, null);
    if (!bool) {
      openBrowserList(paramContext, paramString, null);
    }
    return bool;
  }
  
  public static boolean startQbOrMiniQBToLoadUrl(Context paramContext, String paramString, HashMap<String, String> paramHashMap, ValueCallback<String> paramValueCallback)
  {
    if (paramContext == null) {
      return false;
    }
    x localx = x.a();
    localx.a(paramContext);
    if (((paramHashMap == null) || (!"5".equals(paramHashMap.get("PosID"))) || (!localx.b()) || ((Bundle)localx.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]) == null)) || (MttLoader.loadUrl(paramContext, paramString, paramHashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0))
    {
      if (localx.b()) {
        if ((paramContext == null) || (!paramContext.getApplicationInfo().packageName.equals("com.nd.android.pandahome2")) || (getTbsVersion(paramContext) >= 25487))
        {
          if (localx.c().a(paramContext, paramString, paramHashMap, null, paramValueCallback) == 0) {
            return true;
          }
        }
        else {
          return false;
        }
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public static void unForceSysWebView()
  {
    b = false;
    TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
  }
  
  public static boolean unPreInit(Context paramContext)
  {
    return true;
  }
  
  public static void uploadNetLog(String paramString)
  {
    Object localObject = x.a();
    if ((localObject != null) && (((x)localObject).b())) {
      localObject = ((x)localObject).c().b();
    }
    try
    {
      ((DexLoader)localObject).invokeStaticMethod("com.tencent.smtt.livelog.NetLogManager", "uploadNetLog", new Class[] { String.class }, new Object[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean useSoftWare()
  {
    if (s == null) {
      return false;
    }
    Object localObject2 = i.a(s, "useSoftWare", new Class[0], new Object[0]);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = s;
      localObject2 = Integer.TYPE;
      int i1 = a.a();
      localObject1 = i.a(localObject1, "useSoftWare", new Class[] { localObject2 }, new Object[] { Integer.valueOf(i1) });
    }
    if (localObject1 == null) {}
    for (boolean bool = false;; bool = ((Boolean)localObject1).booleanValue()) {
      return bool;
    }
  }
  
  public static abstract interface PreInitCallback
  {
    public abstract void onCoreInitFinished();
    
    public abstract void onViewInitFinished(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.QbSdk
 * JD-Core Version:    0.7.0.1
 */