package com.tencent.midas.plugin;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class APPluginProxyActivity
  extends HellActivity
{
  private static final String TAG = "APPluginProxyActivity";
  private static boolean cutOutEnable;
  private static String gPluginApkFilePath;
  protected static String gPluginName;
  public static boolean mAppForground = true;
  private static Field sMMapField = null;
  private static Method sUnparcelMethod;
  protected String mCreateErrorInfo = null;
  private String mLaunchActivity = null;
  private IAPPluginActivity mPluginActivity = null;
  private String mPluginApkFilePath = null;
  private String mPluginName = null;
  protected int mStopFlag = 0;
  
  static
  {
    gPluginName = "MidasPay";
    gPluginApkFilePath = null;
    cutOutEnable = false;
    sUnparcelMethod = null;
  }
  
  /* Error */
  private String initPlugin()
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 76	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   8: aload_0
    //   9: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   12: invokevirtual 82	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 84	android/content/pm/PackageInfo
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +248 -> 268
    //   23: aload_0
    //   24: aload_0
    //   25: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   28: iconst_1
    //   29: invokestatic 90	com/tencent/midas/plugin/APApkFileParser:getPackageInfo	(Landroid/content/Context;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   32: astore_1
    //   33: aload_1
    //   34: ifnonnull +11 -> 45
    //   37: ldc 64
    //   39: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: ldc 95
    //   44: areturn
    //   45: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   48: bipush 28
    //   50: if_icmplt +15 -> 65
    //   53: aload_0
    //   54: invokestatic 106	com/tencent/midas/plugin/APPluginUtils:isInNewProcess	(Landroid/content/Context;)Z
    //   57: ifeq +8 -> 65
    //   60: ldc 108
    //   62: invokestatic 114	android/webkit/WebView:setDataDirectorySuffix	(Ljava/lang/String;)V
    //   65: new 110	android/webkit/WebView
    //   68: dup
    //   69: aload_0
    //   70: invokespecial 117	android/webkit/WebView:<init>	(Landroid/content/Context;)V
    //   73: pop
    //   74: aload_1
    //   75: getfield 121	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   78: aload_0
    //   79: invokevirtual 125	com/tencent/midas/plugin/APPluginProxyActivity:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   82: getfield 131	android/content/pm/ApplicationInfo:sharedLibraryFiles	[Ljava/lang/String;
    //   85: putfield 131	android/content/pm/ApplicationInfo:sharedLibraryFiles	[Ljava/lang/String;
    //   88: aload_1
    //   89: getfield 121	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   92: aload_0
    //   93: invokevirtual 125	com/tencent/midas/plugin/APPluginProxyActivity:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   96: getfield 134	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   99: putfield 134	android/content/pm/ApplicationInfo:sourceDir	Ljava/lang/String;
    //   102: aload_1
    //   103: getfield 121	android/content/pm/PackageInfo:applicationInfo	Landroid/content/pm/ApplicationInfo;
    //   106: aload_0
    //   107: invokevirtual 125	com/tencent/midas/plugin/APPluginProxyActivity:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   110: getfield 137	android/content/pm/ApplicationInfo:publicSourceDir	Ljava/lang/String;
    //   113: putfield 137	android/content/pm/ApplicationInfo:publicSourceDir	Ljava/lang/String;
    //   116: getstatic 76	com/tencent/midas/plugin/APPluginStatic:sPackageInfoMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   119: aload_0
    //   120: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   123: aload_1
    //   124: invokevirtual 141	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   127: pop
    //   128: aload_0
    //   129: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   132: ifnull +13 -> 145
    //   135: aload_0
    //   136: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   139: invokevirtual 147	java/lang/String:length	()I
    //   142: ifne +39 -> 181
    //   145: aload_1
    //   146: getfield 151	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   149: ifnull +11 -> 160
    //   152: aload_1
    //   153: getfield 151	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   156: arraylength
    //   157: ifne +11 -> 168
    //   160: ldc 64
    //   162: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: ldc 153
    //   167: areturn
    //   168: aload_0
    //   169: aload_1
    //   170: getfield 151	android/content/pm/PackageInfo:activities	[Landroid/content/pm/ActivityInfo;
    //   173: iconst_0
    //   174: aaload
    //   175: getfield 158	android/content/pm/ActivityInfo:name	Ljava/lang/String;
    //   178: putfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   181: aload_0
    //   182: aload_0
    //   183: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   186: aload_0
    //   187: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   190: invokestatic 164	com/tencent/midas/plugin/APPluginLoader:getOrCreateClassLoaderByPath	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ldalvik/system/DexClassLoader;
    //   193: astore_2
    //   194: aload_0
    //   195: invokevirtual 168	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   198: aload_2
    //   199: invokevirtual 174	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   202: aload_0
    //   203: aload_2
    //   204: aload_0
    //   205: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   208: invokevirtual 180	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   211: invokevirtual 186	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   214: checkcast 188	com/tencent/midas/plugin/IAPPluginActivity
    //   217: putfield 51	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   220: aload_0
    //   221: getfield 51	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   224: aload_0
    //   225: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   228: aload_0
    //   229: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   232: aload_0
    //   233: aload_2
    //   234: aload_1
    //   235: invokeinterface 192 6 0
    //   240: aload_0
    //   241: getfield 51	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   244: aload_0
    //   245: invokevirtual 168	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   248: invokeinterface 196 2 0
    //   253: ldc 64
    //   255: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   258: aconst_null
    //   259: areturn
    //   260: astore_2
    //   261: goto -145 -> 116
    //   264: astore_2
    //   265: goto -200 -> 65
    //   268: goto -140 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	271	0	this	APPluginProxyActivity
    //   18	217	1	localPackageInfo	android.content.pm.PackageInfo
    //   193	41	2	localDexClassLoader	dalvik.system.DexClassLoader
    //   260	1	2	localException	Exception
    //   264	1	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   65	116	260	java/lang/Exception
    //   60	65	264	finally
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(217584);
    if (paramIntent.getComponent() == null)
    {
      AppMethodBeat.o(217584);
      return true;
    }
    if (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName()))
    {
      AppMethodBeat.o(217584);
      return true;
    }
    AppMethodBeat.o(217584);
    return false;
  }
  
  private boolean isStart3rdApp(Intent paramIntent)
  {
    AppMethodBeat.i(217574);
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE")))
    {
      AppMethodBeat.o(217574);
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")))
    {
      AppMethodBeat.o(217574);
      return true;
    }
    paramIntent = paramIntent.getComponent();
    if (paramIntent != null)
    {
      str = paramIntent.getPackageName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.midas.pay")))
      {
        AppMethodBeat.o(217574);
        return true;
      }
      paramIntent = paramIntent.getClassName();
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.qzone")))
      {
        AppMethodBeat.o(217574);
        return true;
      }
    }
    AppMethodBeat.o(217574);
    return false;
  }
  
  private void logStartPluginErrInfo(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(217614);
    if ((paramString.contains("permission")) || (paramString.contains("filenotfoundexception")))
    {
      APLog.i("logStartPluginErrInfo", "mPluginApkFilePath" + this.mPluginApkFilePath);
      paramString = getApplicationInfo();
      boolean bool1;
      if (paramString != null)
      {
        if ((paramString.flags & 0x1) <= 0) {
          break label132;
        }
        bool1 = true;
        if ((paramString.flags & 0x80) <= 0) {
          break label137;
        }
      }
      for (;;)
      {
        APLog.d("", "UID: " + paramString.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        AppMethodBeat.o(217614);
        return;
        label132:
        bool1 = false;
        break;
        label137:
        bool2 = false;
      }
    }
    if ((!paramString.contains("resources$notfoundexception")) && (!paramString.contains("resourcesnotfoundexception"))) {
      paramString.contains("classnotfoundexception");
    }
    AppMethodBeat.o(217614);
  }
  
  /* Error */
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt)
  {
    // Byte code:
    //   0: ldc_w 299
    //   3: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc_w 301
    //   9: ldc_w 303
    //   12: aload_1
    //   13: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   16: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   19: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc_w 301
    //   25: ldc_w 313
    //   28: aload_0
    //   29: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: ldc_w 301
    //   41: ldc_w 315
    //   44: aload_2
    //   45: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   48: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   51: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: ldc_w 301
    //   57: new 250	java/lang/StringBuilder
    //   60: dup
    //   61: ldc_w 317
    //   64: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload 4
    //   69: invokevirtual 323	java/lang/Object:getClass	()Ljava/lang/Class;
    //   72: invokevirtual 326	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   75: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: ldc_w 301
    //   87: new 250	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 317
    //   94: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload 4
    //   99: invokevirtual 323	java/lang/Object:getClass	()Ljava/lang/Class;
    //   102: invokevirtual 329	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   105: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   114: ldc_w 301
    //   117: new 250	java/lang/StringBuilder
    //   120: dup
    //   121: ldc_w 317
    //   124: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   127: aload 4
    //   129: invokevirtual 323	java/lang/Object:getClass	()Ljava/lang/Class;
    //   132: invokevirtual 333	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   135: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: aload_1
    //   145: putstatic 35	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   148: aload_0
    //   149: aload_1
    //   150: invokestatic 342	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   153: invokevirtual 347	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   156: putstatic 37	com/tencent/midas/plugin/APPluginProxyActivity:gPluginApkFilePath	Ljava/lang/String;
    //   159: aload 4
    //   161: ldc_w 349
    //   164: aload_1
    //   165: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   168: pop
    //   169: aload 4
    //   171: ldc_w 355
    //   174: aload_3
    //   175: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   178: pop
    //   179: aload 4
    //   181: ldc_w 357
    //   184: aload_2
    //   185: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   188: pop
    //   189: ldc_w 301
    //   192: new 250	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 359
    //   199: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: getstatic 364	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   205: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   208: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 367	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   214: ldc_w 301
    //   217: new 250	java/lang/StringBuilder
    //   220: dup
    //   221: ldc_w 369
    //   224: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: invokestatic 373	com/tencent/midas/control/APMidasPayHelper:isLogEnable	()Z
    //   230: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   233: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 367	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: aload 4
    //   241: ldc_w 375
    //   244: getstatic 364	com/tencent/midas/control/APMidasPayHelper:isNewProcess	Z
    //   247: invokevirtual 378	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   250: pop
    //   251: aload 4
    //   253: ldc_w 380
    //   256: invokestatic 373	com/tencent/midas/control/APMidasPayHelper:isLogEnable	()Z
    //   259: invokevirtual 378	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   262: pop
    //   263: aload 4
    //   265: ldc_w 382
    //   268: invokestatic 385	com/tencent/midas/control/APMidasPayHelper:getLogCallbackClassName	()Ljava/lang/String;
    //   271: invokevirtual 353	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   274: pop
    //   275: aload 4
    //   277: ldc_w 387
    //   280: getstatic 390	com/tencent/midas/control/APMidasPayHelper:cutoutEnable	Z
    //   283: invokevirtual 378	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   286: pop
    //   287: invokestatic 395	com/tencent/tauth/Tencent:isPermissionNotGranted	()Z
    //   290: ifne +67 -> 357
    //   293: iconst_1
    //   294: istore 6
    //   296: aload 4
    //   298: ldc_w 397
    //   301: iload 6
    //   303: invokevirtual 378	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   306: pop
    //   307: aload_0
    //   308: iload 5
    //   310: new 399	com/tencent/mm/hellhoundlib/b/a
    //   313: dup
    //   314: invokespecial 400	com/tencent/mm/hellhoundlib/b/a:<init>	()V
    //   317: invokestatic 406	com/tencent/mm/hellhoundlib/b/c:a	(ILcom/tencent/mm/hellhoundlib/b/a;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   320: aload 4
    //   322: invokevirtual 410	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
    //   325: invokevirtual 414	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
    //   328: ldc_w 415
    //   331: ldc_w 416
    //   334: ldc_w 417
    //   337: ldc_w 419
    //   340: ldc_w 421
    //   343: ldc_w 423
    //   346: invokestatic 428	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   349: pop
    //   350: ldc_w 299
    //   353: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   356: return
    //   357: iconst_0
    //   358: istore 6
    //   360: goto -64 -> 296
    //   363: astore_0
    //   364: ldc_w 301
    //   367: new 250	java/lang/StringBuilder
    //   370: dup
    //   371: ldc_w 430
    //   374: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: aload_0
    //   378: invokevirtual 433	java/lang/Throwable:toString	()Ljava/lang/String;
    //   381: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   390: ldc_w 299
    //   393: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   396: return
    //   397: astore_1
    //   398: goto -91 -> 307
    //   401: astore 7
    //   403: goto -244 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramActivity	Activity
    //   0	406	1	paramString1	String
    //   0	406	2	paramString2	String
    //   0	406	3	paramString3	String
    //   0	406	4	paramIntent	Intent
    //   0	406	5	paramInt	int
    //   294	65	6	bool	boolean
    //   401	1	7	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   307	350	363	finally
    //   287	293	397	finally
    //   296	307	397	finally
    //   148	159	401	java/io/IOException
  }
  
  private static void setClassLoaderToEveryBundle(Bundle paramBundle, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(217599);
    if (paramBundle == null)
    {
      AppMethodBeat.o(217599);
      return;
    }
    paramBundle.setClassLoader(paramClassLoader);
    Object localObject;
    if ((sUnparcelMethod == null) || (sMMapField == null))
    {
      localObject = paramBundle.getClass();
      Method localMethod = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
      sUnparcelMethod = localMethod;
      localMethod.setAccessible(true);
      localObject = ((Class)localObject).getDeclaredField("mMap");
      sMMapField = (Field)localObject;
      ((Field)localObject).setAccessible(true);
    }
    sUnparcelMethod.invoke(paramBundle, new Object[0]);
    paramBundle = (Map)sMMapField.get(paramBundle);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.values().iterator();
      while (paramBundle.hasNext())
      {
        localObject = paramBundle.next();
        if ((localObject instanceof Bundle)) {
          setClassLoaderToEveryBundle((Bundle)localObject, paramClassLoader);
        }
      }
    }
    AppMethodBeat.o(217599);
  }
  
  private void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(217512);
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity startPluginActivityForResult.private");
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.mPluginName);
    localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity setExtrasClassLoader before");
    localIntent.setExtrasClassLoader(paramIntent.getExtras().getClassLoader());
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity setExtrasClassLoader after");
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtras(paramIntent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/midas/plugin/APPluginProxyActivity", "startPluginActivityForResult", "(Landroid/app/Activity;Ljava/lang/String;Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(217512);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217915);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(217915);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217915);
    return bool;
  }
  
  protected Class<? extends APPluginProxyActivity> getProxyActivity(String paramString)
  {
    AppMethodBeat.i(217925);
    paramString = getClass();
    AppMethodBeat.o(217925);
    return paramString;
  }
  
  protected boolean isWrapContent()
  {
    AppMethodBeat.i(217670);
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    AppMethodBeat.o(217670);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217828);
    APLog.i("APPLuginProxyActivity", "onActivityResult requestCode:" + paramInt1 + " resultCode:" + paramInt2 + " mPluginActivity:" + this.mPluginActivity);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.mPluginActivity != null) {
      try
      {
        Object localObject = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath());
        localObject = APPluginLoader.getClassLoader(this.mPluginName, (String)localObject);
        if ((localObject != null) && (paramIntent != null)) {
          paramIntent.setExtrasClassLoader((ClassLoader)localObject);
        }
        this.mPluginActivity.IOnActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(217828);
        return;
      }
      catch (Exception paramIntent)
      {
        APLog.w("APPLuginProxyActivity onActivityResult", paramIntent.toString());
      }
    }
    AppMethodBeat.o(217828);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(217658);
    super.onAttachedToWindow();
    if ((cutOutEnable) && (Build.VERSION.SDK_INT >= 28)) {
      try
      {
        DisplayCutout localDisplayCutout = getWindow().getDecorView().getRootWindowInsets().getDisplayCutout();
        if (localDisplayCutout != null)
        {
          ViewGroup localViewGroup = (ViewGroup)((ViewGroup)findViewById(16908290)).getChildAt(0);
          if (localViewGroup != null) {
            localViewGroup.setPadding(localDisplayCutout.getSafeInsetLeft(), localDisplayCutout.getSafeInsetTop(), localDisplayCutout.getSafeInsetRight(), localDisplayCutout.getSafeInsetBottom());
          }
        }
        AppMethodBeat.o(217658);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(217658);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(217849);
    try
    {
      super.onBackPressed();
      AppMethodBeat.o(217849);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
      AppMethodBeat.o(217849);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(217787);
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnConfigurationChanged(paramConfiguration);
        AppMethodBeat.o(217787);
        return;
      }
      catch (Exception paramConfiguration) {}
    }
    AppMethodBeat.o(217787);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc_w 639
    //   7: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 301
    //   13: new 250	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 641
    //   20: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: getstatic 35	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   26: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 643
    //   32: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 37	com/tencent/midas/plugin/APPluginProxyActivity:gPluginApkFilePath	Ljava/lang/String;
    //   38: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: getstatic 35	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   50: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +31 -> 84
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial 645	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   61: ldc_w 301
    //   64: ldc_w 647
    //   67: invokestatic 565	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 628	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   74: invokestatic 650	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   77: ldc_w 639
    //   80: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: getstatic 35	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   88: invokestatic 654	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPathString	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 553	com/tencent/midas/plugin/APPluginUtils:getMD5FromPath	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 6
    //   96: getstatic 35	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   99: aload 6
    //   101: invokestatic 556	com/tencent/midas/plugin/APPluginLoader:getClassLoader	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   104: astore 6
    //   106: aload_1
    //   107: ifnull +48 -> 155
    //   110: aload 6
    //   112: ifnull +43 -> 155
    //   115: ldc_w 301
    //   118: new 250	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 656
    //   125: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc_w 658
    //   135: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_1
    //   150: aload 6
    //   152: invokevirtual 441	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   155: aload_0
    //   156: invokevirtual 168	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   159: astore 7
    //   161: aload_1
    //   162: ifnull +330 -> 492
    //   165: aload_1
    //   166: astore 7
    //   168: aload_0
    //   169: aload 7
    //   171: ldc_w 349
    //   174: invokevirtual 661	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   180: aload_0
    //   181: aload 7
    //   183: ldc_w 355
    //   186: invokevirtual 661	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   192: aload_0
    //   193: aload 7
    //   195: ldc_w 357
    //   198: invokevirtual 661	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: putfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   204: aload 7
    //   206: ldc_w 375
    //   209: invokevirtual 665	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   212: istore 5
    //   214: ldc_w 301
    //   217: ldc_w 667
    //   220: iload 5
    //   222: invokestatic 670	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   225: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   228: invokestatic 288	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 7
    //   233: ldc_w 380
    //   236: invokevirtual 665	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   239: istore 4
    //   241: ldc_w 301
    //   244: ldc_w 672
    //   247: iload 4
    //   249: invokestatic 670	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   252: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 288	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 7
    //   260: ldc_w 382
    //   263: invokevirtual 661	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 6
    //   268: ldc_w 301
    //   271: ldc_w 674
    //   274: aload 6
    //   276: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokestatic 288	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: ldc_w 676
    //   288: aload_0
    //   289: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   292: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifne +16 -> 311
    //   298: ldc_w 678
    //   301: aload_0
    //   302: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   305: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   308: ifeq +210 -> 518
    //   311: aload 7
    //   313: ldc_w 387
    //   316: invokevirtual 665	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   319: putstatic 39	com/tencent/midas/plugin/APPluginProxyActivity:cutOutEnable	Z
    //   322: ldc_w 301
    //   325: new 250	java/lang/StringBuilder
    //   328: dup
    //   329: ldc_w 680
    //   332: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   335: getstatic 39	com/tencent/midas/plugin/APPluginProxyActivity:cutOutEnable	Z
    //   338: invokevirtual 283	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   341: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 288	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: iload 5
    //   349: ifeq +169 -> 518
    //   352: aload 7
    //   354: ldc_w 397
    //   357: invokevirtual 665	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   360: ifeq +7 -> 367
    //   363: iconst_1
    //   364: invokestatic 683	com/tencent/tauth/Tencent:setIsPermissionGranted	(Z)V
    //   367: aload_0
    //   368: iload 5
    //   370: iload 4
    //   372: aload 6
    //   374: invokestatic 689	com/tencent/midas/comm/APLogUtil:initAPLogIfNewProcess	(Landroid/content/Context;ZZLjava/lang/String;)V
    //   377: ldc_w 301
    //   380: new 250	java/lang/StringBuilder
    //   383: dup
    //   384: ldc_w 691
    //   387: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   390: aload_0
    //   391: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   394: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: ldc_w 693
    //   400: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   407: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: ldc_w 695
    //   413: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: aload_0
    //   417: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   420: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 265	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   429: aload_0
    //   430: getfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   433: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   436: ifeq +18 -> 454
    //   439: aload_0
    //   440: aload_0
    //   441: aload_0
    //   442: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   445: invokestatic 342	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   448: invokevirtual 347	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   451: putfield 53	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   454: aload_0
    //   455: getfield 49	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   458: invokestatic 227	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +110 -> 571
    //   464: ldc_w 697
    //   467: ldc_w 699
    //   470: invokestatic 367	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   473: aload_0
    //   474: aload_1
    //   475: invokespecial 645	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   478: aload_0
    //   479: invokevirtual 628	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   482: invokestatic 650	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   485: ldc_w 639
    //   488: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   491: return
    //   492: aload 6
    //   494: ifnull +10 -> 504
    //   497: aload 7
    //   499: aload 6
    //   501: invokevirtual 174	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   504: aload_0
    //   505: invokevirtual 168	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   508: invokevirtual 506	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   511: astore 7
    //   513: goto -345 -> 168
    //   516: astore 7
    //   518: goto -151 -> 367
    //   521: astore 7
    //   523: ldc_w 270
    //   526: astore 6
    //   528: iconst_1
    //   529: istore 4
    //   531: iconst_0
    //   532: istore 5
    //   534: ldc_w 301
    //   537: new 250	java/lang/StringBuilder
    //   540: dup
    //   541: ldc_w 701
    //   544: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   547: aload 7
    //   549: invokevirtual 562	java/lang/Exception:toString	()Ljava/lang/String;
    //   552: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 565	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   561: aload_0
    //   562: invokevirtual 628	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   565: invokestatic 650	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   568: goto -201 -> 367
    //   571: aload_0
    //   572: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   575: ifnull +13 -> 588
    //   578: aload_0
    //   579: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   582: invokevirtual 147	java/lang/String:length	()I
    //   585: ifne +158 -> 743
    //   588: ldc_w 703
    //   591: astore 6
    //   593: iload_2
    //   594: ifne +8 -> 602
    //   597: aload_0
    //   598: aload_1
    //   599: invokespecial 645	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   602: aload 6
    //   604: ifnull +77 -> 681
    //   607: aload_0
    //   608: aload 6
    //   610: putfield 59	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   613: ldc_w 697
    //   616: ldc_w 705
    //   619: aload 6
    //   621: invokestatic 307	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   624: invokevirtual 311	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   627: invokestatic 367	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   630: aload_0
    //   631: aload_0
    //   632: getfield 59	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   635: invokespecial 707	com/tencent/midas/plugin/APPluginProxyActivity:logStartPluginErrInfo	(Ljava/lang/String;)V
    //   638: aload_0
    //   639: aload_0
    //   640: getfield 59	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   643: invokevirtual 710	com/tencent/midas/plugin/APPluginProxyActivity:shouldHandleStartPluginFailed	(Ljava/lang/String;)Z
    //   646: ifne +35 -> 681
    //   649: invokestatic 716	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   652: ldc_w 718
    //   655: ldc_w 720
    //   658: aload_0
    //   659: getfield 55	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   662: aload 6
    //   664: invokevirtual 724	com/tencent/midas/data/APPluginReportManager:insertData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   667: aload_0
    //   668: aload 6
    //   670: iconst_1
    //   671: invokestatic 728	com/tencent/midas/plugin/APPluginUtils:showLaunchPluginFail	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   674: aload_0
    //   675: invokevirtual 628	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   678: invokestatic 650	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   681: getstatic 39	com/tencent/midas/plugin/APPluginProxyActivity:cutOutEnable	Z
    //   684: ifeq +162 -> 846
    //   687: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   690: bipush 28
    //   692: if_icmplt +154 -> 846
    //   695: aload_0
    //   696: invokevirtual 573	com/tencent/midas/plugin/APPluginProxyActivity:getWindow	()Landroid/view/Window;
    //   699: ldc_w 729
    //   702: invokevirtual 731	android/view/Window:addFlags	(I)V
    //   705: aload_0
    //   706: invokevirtual 573	com/tencent/midas/plugin/APPluginProxyActivity:getWindow	()Landroid/view/Window;
    //   709: sipush 1024
    //   712: invokevirtual 731	android/view/Window:addFlags	(I)V
    //   715: aload_0
    //   716: invokevirtual 573	com/tencent/midas/plugin/APPluginProxyActivity:getWindow	()Landroid/view/Window;
    //   719: invokevirtual 735	android/view/Window:getAttributes	()Landroid/view/WindowManager$LayoutParams;
    //   722: astore_1
    //   723: aload_1
    //   724: iconst_1
    //   725: putfield 740	android/view/WindowManager$LayoutParams:layoutInDisplayCutoutMode	I
    //   728: aload_0
    //   729: invokevirtual 573	com/tencent/midas/plugin/APPluginProxyActivity:getWindow	()Landroid/view/Window;
    //   732: aload_1
    //   733: invokevirtual 744	android/view/Window:setAttributes	(Landroid/view/WindowManager$LayoutParams;)V
    //   736: ldc_w 639
    //   739: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   742: return
    //   743: aload_0
    //   744: invokespecial 746	com/tencent/midas/plugin/APPluginProxyActivity:initPlugin	()Ljava/lang/String;
    //   747: astore 6
    //   749: aload 6
    //   751: ifnonnull +142 -> 893
    //   754: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   757: bipush 11
    //   759: if_icmplt +25 -> 784
    //   762: getstatic 100	android/os/Build$VERSION:SDK_INT	I
    //   765: bipush 30
    //   767: if_icmpge +17 -> 784
    //   770: aload_0
    //   771: invokevirtual 750	com/tencent/midas/plugin/APPluginProxyActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   774: new 752	com/tencent/midas/plugin/APLayoutInflaterFactory
    //   777: dup
    //   778: invokespecial 753	com/tencent/midas/plugin/APLayoutInflaterFactory:<init>	()V
    //   781: invokevirtual 759	android/view/LayoutInflater:setFactory2	(Landroid/view/LayoutInflater$Factory2;)V
    //   784: aload_0
    //   785: aload_1
    //   786: invokespecial 645	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   789: aload_0
    //   790: getfield 51	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   793: aload_1
    //   794: invokeinterface 762 2 0
    //   799: iconst_1
    //   800: istore_2
    //   801: goto -208 -> 593
    //   804: astore 6
    //   806: iload_3
    //   807: istore_2
    //   808: ldc_w 697
    //   811: new 250	java/lang/StringBuilder
    //   814: dup
    //   815: ldc_w 764
    //   818: invokespecial 253	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   821: aload 6
    //   823: invokevirtual 562	java/lang/Exception:toString	()Ljava/lang/String;
    //   826: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: invokevirtual 260	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   832: invokestatic 367	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   835: aload 6
    //   837: invokestatic 768	com/tencent/midas/plugin/APPluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   840: astore 6
    //   842: goto -249 -> 593
    //   845: astore_1
    //   846: ldc_w 639
    //   849: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   852: return
    //   853: astore 6
    //   855: iconst_1
    //   856: istore_2
    //   857: goto -49 -> 808
    //   860: astore 6
    //   862: goto -408 -> 454
    //   865: astore 7
    //   867: ldc_w 270
    //   870: astore 6
    //   872: iconst_1
    //   873: istore 4
    //   875: goto -341 -> 534
    //   878: astore 7
    //   880: ldc_w 270
    //   883: astore 6
    //   885: goto -351 -> 534
    //   888: astore 7
    //   890: goto -356 -> 534
    //   893: iconst_0
    //   894: istore_2
    //   895: goto -94 -> 801
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	898	0	this	APPluginProxyActivity
    //   0	898	1	paramBundle	Bundle
    //   3	892	2	i	int
    //   1	806	3	j	int
    //   239	635	4	bool1	boolean
    //   212	321	5	bool2	boolean
    //   94	656	6	localObject1	Object
    //   804	32	6	localException1	Exception
    //   840	1	6	str1	String
    //   853	1	6	localException2	Exception
    //   860	1	6	localException3	Exception
    //   870	14	6	str2	String
    //   159	353	7	localObject2	Object
    //   516	1	7	localObject3	Object
    //   521	27	7	localException4	Exception
    //   865	1	7	localException5	Exception
    //   878	1	7	localException6	Exception
    //   888	1	7	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   352	367	516	finally
    //   168	214	521	java/lang/Exception
    //   743	749	804	java/lang/Exception
    //   754	784	804	java/lang/Exception
    //   784	789	804	java/lang/Exception
    //   695	736	845	java/lang/Exception
    //   789	799	853	java/lang/Exception
    //   439	454	860	java/lang/Exception
    //   214	241	865	java/lang/Exception
    //   241	268	878	java/lang/Exception
    //   268	311	888	java/lang/Exception
    //   311	347	888	java/lang/Exception
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(217867);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
      AppMethodBeat.o(217867);
      return bool;
    }
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(217867);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(217760);
    super.onDestroy();
    APLog.i("APPluginProxyActivity", "onDestroy mPluginActivity:" + this.mPluginActivity);
    APLogUtil.flushIfNewProcess();
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnDestroy();
        AppMethodBeat.o(217760);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(217760);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217699);
    boolean bool1 = false;
    if (this.mPluginActivity != null) {
      bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    AppMethodBeat.o(217699);
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(217891);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
      AppMethodBeat.o(217891);
      return bool;
    }
    boolean bool = super.onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(217891);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(217681);
    super.onNewIntent(paramIntent);
    Object localObject = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName));
    localObject = APPluginLoader.getClassLoader(this.mPluginName, (String)localObject);
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onNewIntent mPluginName:" + this.mPluginName + " classLoader: " + localObject);
    if (localObject != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
    }
    if ((this.mPluginActivity != null) && (paramIntent.getBooleanExtra("cleartop", false))) {
      this.mPluginActivity.IOnNewIntent(paramIntent);
    }
    AppMethodBeat.o(217681);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(217882);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(217882);
      return bool;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(217882);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217747);
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    AppMethodBeat.o(217747);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(217874);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(217874);
      return bool;
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(217874);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217840);
    APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + paramInt + " permissions:" + paramArrayOfString + " grantResults:" + paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.mPluginActivity != null) {
      try
      {
        String str = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath());
        APPluginLoader.getClassLoader(this.mPluginName, str);
        this.mPluginActivity.IOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(217840);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        APLog.w("APPLuginProxyActivity onRequestPermissionsResult", paramArrayOfString.toString());
      }
    }
    AppMethodBeat.o(217840);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(217896);
    Object localObject = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName));
    localObject = APPluginLoader.getClassLoader(this.mPluginName, (String)localObject);
    if (localObject != null) {}
    try
    {
      setClassLoaderToEveryBundle(paramBundle, (ClassLoader)localObject);
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          super.onRestoreInstanceState(paramBundle);
          label41:
          if (this.mPluginActivity != null) {
            this.mPluginActivity.IOnRestoreInstanceState(paramBundle);
          }
          AppMethodBeat.o(217896);
          return;
          localException1 = localException1;
        }
      }
      catch (Exception localException2)
      {
        break label41;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(217724);
    super.onResume();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnResume();
    }
    AppMethodBeat.o(217724);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(217904);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnSaveInstanceState(paramBundle);
    }
    paramBundle.putString("pluginsdk_pluginName", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginLocation", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
    paramBundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(217904);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(217710);
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    AppMethodBeat.o(217710);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(217735);
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    AppMethodBeat.o(217735);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217912);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
      AppMethodBeat.o(217912);
      return bool;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217912);
    return bool;
  }
  
  public void onUserInteraction()
  {
    AppMethodBeat.i(217921);
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      AppMethodBeat.o(217921);
      return;
    }
    super.onUserInteraction();
    AppMethodBeat.o(217921);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(217690);
    super.onUserLeaveHint();
    AppMethodBeat.o(217690);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(217857);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(217857);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(217771);
    APLog.i("APPluginProxyActivity", "setRequestedOrientation requestedOrientation:".concat(String.valueOf(paramInt)));
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(217771);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    AppMethodBeat.i(217933);
    boolean bool = false;
    if ((paramString.contains("permission")) || (paramString.contains("filenotfoundexception"))) {
      showNeedUninstanllAndInstallDialog();
    }
    for (bool = true;; bool = true)
    {
      do
      {
        AppMethodBeat.o(217933);
        return bool;
      } while ((!paramString.contains("resources$notfoundexception")) && (!paramString.contains("resourcesnotfoundexception")));
      showNeedUninstanllAndInstallDialog();
    }
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    AppMethodBeat.i(217941);
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("系统繁忙" + this.mPluginName + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(217522);
        APPluginProxyActivity.this.finish();
        AppMethodBeat.o(217522);
      }
    });
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      ((Dialog)localObject).show();
      AppMethodBeat.o(217941);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(217941);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(217799);
    if (paramIntent.getBooleanExtra("pluginsdk_IsPluginActivity", false))
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0)) {
        startPluginActivityForResult(this, str, paramIntent, paramInt);
      }
    }
    for (;;)
    {
      this.mStopFlag = 2;
      AppMethodBeat.o(217799);
      return;
      super.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217816);
    APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
    this.mStopFlag = 2;
    isStart3rdApp(paramIntent);
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    super.startActivityForResult(paramIntent, paramInt1);
    AppMethodBeat.o(217816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */