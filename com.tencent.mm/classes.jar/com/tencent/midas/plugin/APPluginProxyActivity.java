package com.tencent.midas.plugin;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.comm.APLogUtil;
import com.tencent.midas.control.APMidasPayHelper;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class APPluginProxyActivity
  extends HellActivity
{
  private static final String TAG = "APPluginProxyActivity";
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
    sUnparcelMethod = null;
  }
  
  private String initPlugin()
  {
    AppMethodBeat.i(193189);
    PackageInfo localPackageInfo = (PackageInfo)APPluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
    if (localPackageInfo == null)
    {
      localPackageInfo = APApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
      if (localPackageInfo == null)
      {
        AppMethodBeat.o(193189);
        return "Get Package Info Failed!";
      }
      APPluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, localPackageInfo);
    }
    for (;;)
    {
      if ((this.mLaunchActivity == null) || (this.mLaunchActivity.length() == 0))
      {
        if ((localPackageInfo.activities == null) || (localPackageInfo.activities.length == 0))
        {
          AppMethodBeat.o(193189);
          return "Activity Not Found!";
        }
        this.mLaunchActivity = localPackageInfo.activities[0].name;
      }
      DexClassLoader localDexClassLoader = APPluginLoader.getOrCreateClassLoaderByPath(this, this.mPluginName, this.mPluginApkFilePath);
      getIntent().setExtrasClassLoader(localDexClassLoader);
      this.mPluginActivity = ((IAPPluginActivity)localDexClassLoader.loadClass(this.mLaunchActivity).newInstance());
      this.mPluginActivity.IInit(this.mPluginName, this.mPluginApkFilePath, this, localDexClassLoader, localPackageInfo);
      this.mPluginActivity.ISetIntent(getIntent());
      AppMethodBeat.o(193189);
      return null;
    }
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(193201);
    if (paramIntent.getComponent() == null)
    {
      AppMethodBeat.o(193201);
      return true;
    }
    if (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName()))
    {
      AppMethodBeat.o(193201);
      return true;
    }
    AppMethodBeat.o(193201);
    return false;
  }
  
  private boolean isStart3rdApp(Intent paramIntent)
  {
    AppMethodBeat.i(193200);
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE")))
    {
      AppMethodBeat.o(193200);
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")))
    {
      AppMethodBeat.o(193200);
      return true;
    }
    paramIntent = paramIntent.getComponent();
    if (paramIntent != null)
    {
      str = paramIntent.getPackageName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.midas.pay")))
      {
        AppMethodBeat.o(193200);
        return true;
      }
      paramIntent = paramIntent.getClassName();
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.qzone")))
      {
        AppMethodBeat.o(193200);
        return true;
      }
    }
    AppMethodBeat.o(193200);
    return false;
  }
  
  private void logStartPluginErrInfo(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(193204);
    if ((paramString.contains("permission")) || (paramString.contains("filenotfoundexception")))
    {
      APLog.i("logStartPluginErrInfo", "mPluginApkFilePath" + this.mPluginApkFilePath);
      paramString = getApplicationInfo();
      boolean bool1;
      if (paramString != null)
      {
        if ((paramString.flags & 0x1) <= 0) {
          break label128;
        }
        bool1 = true;
        if ((paramString.flags & 0x80) <= 0) {
          break label133;
        }
      }
      for (;;)
      {
        APLog.d("", "UID: " + paramString.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        AppMethodBeat.o(193204);
        return;
        label128:
        bool1 = false;
        break;
        label133:
        bool2 = false;
      }
    }
    if ((!paramString.contains("resources$notfoundexception")) && (!paramString.contains("resourcesnotfoundexception"))) {
      paramString.contains("classnotfoundexception");
    }
    AppMethodBeat.o(193204);
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(193186);
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult pluginName：".concat(String.valueOf(paramString1)));
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult contextActivity：".concat(String.valueOf(paramActivity)));
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult apkFilePath：".concat(String.valueOf(paramString2)));
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + paramIntent.getClass().getSimpleName());
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + paramIntent.getClass().getCanonicalName());
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + paramIntent.getClass().getClassLoader());
    gPluginName = paramString1;
    try
    {
      gPluginApkFilePath = APPluginInstallerAndUpdater.getInstallPath(paramActivity, paramString1).getCanonicalPath();
      label159:
      paramIntent.putExtra("pluginsdk_pluginName", paramString1);
      paramIntent.putExtra("pluginsdk_launchActivity", paramString3);
      paramIntent.putExtra("pluginsdk_pluginpath", paramString2);
      APLog.e("APPLuginProxyActivity", "put is new process: " + APMidasPayHelper.isNewProcess);
      APLog.e("APPLuginProxyActivity", "put is log enable: " + APMidasPayHelper.isLogEnable());
      paramIntent.putExtra("pluginsdk_isNewProcess", APMidasPayHelper.isNewProcess);
      paramIntent.putExtra("pluginsdk_logEnable", APMidasPayHelper.isLogEnable());
      try
      {
        paramActivity.startActivityForResult(paramIntent, paramInt);
        AppMethodBeat.o(193186);
        return;
      }
      catch (Throwable paramActivity)
      {
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult Throwable:" + paramActivity.toString());
        AppMethodBeat.o(193186);
        return;
      }
    }
    catch (IOException localIOException)
    {
      break label159;
    }
  }
  
  private static void setClassLoaderToEveryBundle(Bundle paramBundle, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(193202);
    if (paramBundle == null)
    {
      AppMethodBeat.o(193202);
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
    AppMethodBeat.o(193202);
  }
  
  private void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(193183);
    APLog.i("APPLuginProxyActivity", "APPluginProxyActivity startPluginActivityForResult.private");
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.mPluginName);
    localIntent.putExtra("pluginsdk_pluginpath", this.mPluginApkFilePath);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtras(paramIntent);
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(193183);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193197);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(193197);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(193197);
    return bool;
  }
  
  protected Class<? extends APPluginProxyActivity> getProxyActivity(String paramString)
  {
    AppMethodBeat.i(193199);
    paramString = getClass();
    AppMethodBeat.o(193199);
    return paramString;
  }
  
  protected boolean isWrapContent()
  {
    AppMethodBeat.i(193170);
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    AppMethodBeat.o(193170);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193184);
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
        AppMethodBeat.o(193184);
        return;
      }
      catch (Exception paramIntent)
      {
        APLog.w("APPLuginProxyActivity onActivityResult", paramIntent.toString());
      }
    }
    AppMethodBeat.o(193184);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(193187);
    try
    {
      super.onBackPressed();
      AppMethodBeat.o(193187);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
      AppMethodBeat.o(193187);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(193180);
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnConfigurationChanged(paramConfiguration);
        AppMethodBeat.o(193180);
        return;
      }
      catch (Exception paramConfiguration) {}
    }
    AppMethodBeat.o(193180);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc_w 495
    //   7: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 263
    //   13: new 204	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 497
    //   20: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   26: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 499
    //   32: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 36	com/tencent/midas/plugin/APPluginProxyActivity:gPluginApkFilePath	Ljava/lang/String;
    //   38: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 219	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   50: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +31 -> 84
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial 501	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   61: ldc_w 263
    //   64: ldc_w 503
    //   67: invokestatic 475	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 484	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   74: invokestatic 506	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   77: ldc_w 495
    //   80: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   88: invokestatic 510	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPathString	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 463	com/tencent/midas/plugin/APPluginUtils:getMD5FromPath	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 6
    //   96: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   99: aload 6
    //   101: invokestatic 466	com/tencent/midas/plugin/APPluginLoader:getClassLoader	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   104: astore 6
    //   106: aload_1
    //   107: ifnull +48 -> 155
    //   110: aload 6
    //   112: ifnull +43 -> 155
    //   115: ldc_w 263
    //   118: new 204	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 512
    //   125: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc_w 514
    //   135: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 298	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 219	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_1
    //   150: aload 6
    //   152: invokevirtual 359	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   155: aload_0
    //   156: invokevirtual 121	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   159: astore 7
    //   161: aload_1
    //   162: ifnull +219 -> 381
    //   165: aload_1
    //   166: astore 6
    //   168: aload_0
    //   169: aload 6
    //   171: ldc_w 311
    //   174: invokevirtual 517	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   180: aload_0
    //   181: aload 6
    //   183: ldc_w 317
    //   186: invokevirtual 517	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   192: aload_0
    //   193: aload 6
    //   195: ldc_w 319
    //   198: invokevirtual 517	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: putfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   204: aload 6
    //   206: ldc_w 337
    //   209: invokevirtual 521	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   212: istore 5
    //   214: ldc_w 263
    //   217: ldc_w 523
    //   220: iload 5
    //   222: invokestatic 526	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   225: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   228: invokestatic 329	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 6
    //   233: ldc_w 342
    //   236: invokevirtual 521	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   239: istore 4
    //   241: ldc_w 263
    //   244: ldc_w 528
    //   247: iload 4
    //   249: invokestatic 526	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   252: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 329	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: iload 5
    //   261: iload 4
    //   263: invokestatic 534	com/tencent/midas/comm/APLogUtil:initAPLogIfNewProcess	(Landroid/content/Context;ZZ)V
    //   266: ldc_w 263
    //   269: new 204	java/lang/StringBuilder
    //   272: dup
    //   273: ldc_w 536
    //   276: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   279: aload_0
    //   280: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   283: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: ldc_w 538
    //   289: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_0
    //   293: getfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   296: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: ldc_w 540
    //   302: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload_0
    //   306: getfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   309: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 219	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   318: aload_0
    //   319: getfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   322: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   325: ifeq +18 -> 343
    //   328: aload_0
    //   329: aload_0
    //   330: aload_0
    //   331: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   334: invokestatic 304	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   337: invokevirtual 309	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   340: putfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   343: aload_0
    //   344: getfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   347: invokestatic 180	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   350: ifeq +100 -> 450
    //   353: ldc_w 542
    //   356: ldc_w 544
    //   359: invokestatic 329	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   362: aload_0
    //   363: aload_1
    //   364: invokespecial 501	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   367: aload_0
    //   368: invokevirtual 484	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   371: invokestatic 506	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   374: ldc_w 495
    //   377: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   380: return
    //   381: aload 6
    //   383: ifnull +10 -> 393
    //   386: aload 7
    //   388: aload 6
    //   390: invokevirtual 127	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   393: aload_0
    //   394: invokevirtual 121	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   397: invokevirtual 548	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   400: astore 6
    //   402: goto -234 -> 168
    //   405: astore 6
    //   407: iconst_1
    //   408: istore 4
    //   410: iconst_0
    //   411: istore 5
    //   413: ldc_w 263
    //   416: new 204	java/lang/StringBuilder
    //   419: dup
    //   420: ldc_w 550
    //   423: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   426: aload 6
    //   428: invokevirtual 472	java/lang/Exception:toString	()Ljava/lang/String;
    //   431: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 475	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: aload_0
    //   441: invokevirtual 484	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   444: invokestatic 506	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   447: goto -189 -> 258
    //   450: aload_0
    //   451: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   454: ifnull +13 -> 467
    //   457: aload_0
    //   458: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   461: invokevirtual 100	java/lang/String:length	()I
    //   464: ifne +103 -> 567
    //   467: ldc_w 552
    //   470: astore 6
    //   472: iload_2
    //   473: ifne +8 -> 481
    //   476: aload_0
    //   477: aload_1
    //   478: invokespecial 501	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   481: aload 6
    //   483: ifnull +77 -> 560
    //   486: aload_0
    //   487: aload 6
    //   489: putfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   492: ldc_w 542
    //   495: ldc_w 554
    //   498: aload 6
    //   500: invokestatic 269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   503: invokevirtual 273	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   506: invokestatic 329	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload_0
    //   510: aload_0
    //   511: getfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   514: invokespecial 556	com/tencent/midas/plugin/APPluginProxyActivity:logStartPluginErrInfo	(Ljava/lang/String;)V
    //   517: aload_0
    //   518: aload_0
    //   519: getfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   522: invokevirtual 559	com/tencent/midas/plugin/APPluginProxyActivity:shouldHandleStartPluginFailed	(Ljava/lang/String;)Z
    //   525: ifne +35 -> 560
    //   528: invokestatic 565	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   531: ldc_w 567
    //   534: ldc_w 569
    //   537: aload_0
    //   538: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   541: aload 6
    //   543: invokevirtual 573	com/tencent/midas/data/APPluginReportManager:insertData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   546: aload_0
    //   547: aload 6
    //   549: iconst_1
    //   550: invokestatic 577	com/tencent/midas/plugin/APPluginUtils:showLaunchPluginFail	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   553: aload_0
    //   554: invokevirtual 484	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   557: invokestatic 506	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   560: ldc_w 495
    //   563: invokestatic 88	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   566: return
    //   567: aload_0
    //   568: invokespecial 579	com/tencent/midas/plugin/APPluginProxyActivity:initPlugin	()Ljava/lang/String;
    //   571: astore 6
    //   573: aload 6
    //   575: ifnonnull +111 -> 686
    //   578: getstatic 584	android/os/Build$VERSION:SDK_INT	I
    //   581: bipush 11
    //   583: if_icmplt +17 -> 600
    //   586: aload_0
    //   587: invokevirtual 588	com/tencent/midas/plugin/APPluginProxyActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   590: new 590	com/tencent/midas/plugin/APLayoutInflaterFactory
    //   593: dup
    //   594: invokespecial 591	com/tencent/midas/plugin/APLayoutInflaterFactory:<init>	()V
    //   597: invokevirtual 597	android/view/LayoutInflater:setFactory2	(Landroid/view/LayoutInflater$Factory2;)V
    //   600: aload_0
    //   601: aload_1
    //   602: invokespecial 501	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   605: aload_0
    //   606: getfield 48	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   609: aload_1
    //   610: invokeinterface 600 2 0
    //   615: iconst_1
    //   616: istore_2
    //   617: goto -145 -> 472
    //   620: astore 6
    //   622: iload_3
    //   623: istore_2
    //   624: ldc_w 542
    //   627: new 204	java/lang/StringBuilder
    //   630: dup
    //   631: ldc_w 602
    //   634: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   637: aload 6
    //   639: invokevirtual 472	java/lang/Exception:toString	()Ljava/lang/String;
    //   642: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 329	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: aload 6
    //   653: invokestatic 606	com/tencent/midas/plugin/APPluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   656: astore 6
    //   658: goto -186 -> 472
    //   661: astore 6
    //   663: iconst_1
    //   664: istore_2
    //   665: goto -41 -> 624
    //   668: astore 6
    //   670: goto -327 -> 343
    //   673: astore 6
    //   675: iconst_1
    //   676: istore 4
    //   678: goto -265 -> 413
    //   681: astore 6
    //   683: goto -270 -> 413
    //   686: iconst_0
    //   687: istore_2
    //   688: goto -71 -> 617
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	691	0	this	APPluginProxyActivity
    //   0	691	1	paramBundle	Bundle
    //   3	685	2	i	int
    //   1	622	3	j	int
    //   239	438	4	bool1	boolean
    //   212	200	5	bool2	boolean
    //   94	307	6	localObject	Object
    //   405	22	6	localException1	Exception
    //   470	104	6	str1	String
    //   620	32	6	localException2	Exception
    //   656	1	6	str2	String
    //   661	1	6	localException3	Exception
    //   668	1	6	localException4	Exception
    //   673	1	6	localException5	Exception
    //   681	1	6	localException6	Exception
    //   159	228	7	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   168	214	405	java/lang/Exception
    //   567	573	620	java/lang/Exception
    //   578	600	620	java/lang/Exception
    //   600	605	620	java/lang/Exception
    //   605	615	661	java/lang/Exception
    //   328	343	668	java/lang/Exception
    //   214	241	673	java/lang/Exception
    //   241	258	681	java/lang/Exception
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(193190);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
      AppMethodBeat.o(193190);
      return bool;
    }
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(193190);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193178);
    super.onDestroy();
    APLog.i("APPluginProxyActivity", "onDestroy mPluginActivity:" + this.mPluginActivity);
    APLogUtil.flushIfNewProcess();
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnDestroy();
        AppMethodBeat.o(193178);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(193178);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193173);
    boolean bool1 = false;
    if (this.mPluginActivity != null) {
      bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    AppMethodBeat.o(193173);
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(193193);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
      AppMethodBeat.o(193193);
      return bool;
    }
    boolean bool = super.onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(193193);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193171);
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
    AppMethodBeat.o(193171);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(193192);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(193192);
      return bool;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(193192);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193177);
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    AppMethodBeat.o(193177);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(193191);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(193191);
      return bool;
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(193191);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193185);
    APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + paramInt + " permissions:" + paramArrayOfString + " grantResults:" + paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.mPluginActivity != null) {
      try
      {
        String str = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath());
        APPluginLoader.getClassLoader(this.mPluginName, str);
        this.mPluginActivity.IOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(193185);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        APLog.w("APPLuginProxyActivity onRequestPermissionsResult", paramArrayOfString.toString());
      }
    }
    AppMethodBeat.o(193185);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193194);
    Object localObject = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName));
    localObject = APPluginLoader.getClassLoader(this.mPluginName, (String)localObject);
    if (localObject != null) {}
    try
    {
      setClassLoaderToEveryBundle(paramBundle, (ClassLoader)localObject);
      label36:
      super.onRestoreInstanceState(paramBundle);
      if (this.mPluginActivity != null) {
        this.mPluginActivity.IOnRestoreInstanceState(paramBundle);
      }
      AppMethodBeat.o(193194);
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(193175);
    super.onResume();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnResume();
    }
    AppMethodBeat.o(193175);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(193195);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnSaveInstanceState(paramBundle);
    }
    paramBundle.putString("pluginsdk_pluginName", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginLocation", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
    paramBundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(193195);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(193174);
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    AppMethodBeat.o(193174);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(193176);
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    AppMethodBeat.o(193176);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193196);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
      AppMethodBeat.o(193196);
      return bool;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(193196);
    return bool;
  }
  
  public void onUserInteraction()
  {
    AppMethodBeat.i(193198);
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      AppMethodBeat.o(193198);
      return;
    }
    super.onUserInteraction();
    AppMethodBeat.o(193198);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(193172);
    super.onUserLeaveHint();
    AppMethodBeat.o(193172);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193188);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(193188);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(193179);
    APLog.i("APPluginProxyActivity", "setRequestedOrientation requestedOrientation:".concat(String.valueOf(paramInt)));
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(193179);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    AppMethodBeat.i(193203);
    boolean bool = false;
    if ((paramString.contains("permission")) || (paramString.contains("filenotfoundexception"))) {
      showNeedUninstanllAndInstallDialog();
    }
    for (bool = true;; bool = true)
    {
      do
      {
        AppMethodBeat.o(193203);
        return bool;
      } while ((!paramString.contains("resources$notfoundexception")) && (!paramString.contains("resourcesnotfoundexception")));
      showNeedUninstanllAndInstallDialog();
    }
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    AppMethodBeat.i(193205);
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("系统繁忙" + this.mPluginName + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(193038);
        APPluginProxyActivity.this.finish();
        AppMethodBeat.o(193038);
      }
    });
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      ((Dialog)localObject).show();
      AppMethodBeat.o(193205);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(193205);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(193181);
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
      AppMethodBeat.o(193181);
      return;
      super.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193182);
    APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
    this.mStopFlag = 2;
    isStart3rdApp(paramIntent);
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    super.startActivityForResult(paramIntent, paramInt1);
    AppMethodBeat.o(193182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */