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
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.webkit.WebView;
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
    AppMethodBeat.i(252724);
    PackageInfo localPackageInfo = (PackageInfo)APPluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
    if (localPackageInfo == null)
    {
      localPackageInfo = APApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
      if (localPackageInfo == null)
      {
        AppMethodBeat.o(252724);
        return "Get Package Info Failed!";
      }
      if ((Build.VERSION.SDK_INT < 28) || (!APPluginUtils.isInNewProcess(this))) {}
    }
    for (;;)
    {
      try
      {
        WebView.setDataDirectorySuffix("midaspay");
        try
        {
          new WebView(this);
          localPackageInfo.applicationInfo.sharedLibraryFiles = getApplicationInfo().sharedLibraryFiles;
          localPackageInfo.applicationInfo.sourceDir = getApplicationInfo().sourceDir;
          localPackageInfo.applicationInfo.publicSourceDir = getApplicationInfo().publicSourceDir;
          APPluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, localPackageInfo);
          if ((this.mLaunchActivity == null) || (this.mLaunchActivity.length() == 0))
          {
            if ((localPackageInfo.activities == null) || (localPackageInfo.activities.length == 0))
            {
              AppMethodBeat.o(252724);
              return "Activity Not Found!";
            }
            this.mLaunchActivity = localPackageInfo.activities[0].name;
          }
          DexClassLoader localDexClassLoader = APPluginLoader.getOrCreateClassLoaderByPath(this, this.mPluginName, this.mPluginApkFilePath);
          getIntent().setExtrasClassLoader(localDexClassLoader);
          this.mPluginActivity = ((IAPPluginActivity)localDexClassLoader.loadClass(this.mLaunchActivity).newInstance());
          this.mPluginActivity.IInit(this.mPluginName, this.mPluginApkFilePath, this, localDexClassLoader, localPackageInfo);
          this.mPluginActivity.ISetIntent(getIntent());
          AppMethodBeat.o(252724);
          return null;
        }
        catch (Exception localException) {}
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(252740);
    if (paramIntent.getComponent() == null)
    {
      AppMethodBeat.o(252740);
      return true;
    }
    if (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName()))
    {
      AppMethodBeat.o(252740);
      return true;
    }
    AppMethodBeat.o(252740);
    return false;
  }
  
  private boolean isStart3rdApp(Intent paramIntent)
  {
    AppMethodBeat.i(252739);
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE")))
    {
      AppMethodBeat.o(252739);
      return true;
    }
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")))
    {
      AppMethodBeat.o(252739);
      return true;
    }
    paramIntent = paramIntent.getComponent();
    if (paramIntent != null)
    {
      str = paramIntent.getPackageName();
      if ((!TextUtils.isEmpty(str)) && (str.equals("com.tencent.midas.pay")))
      {
        AppMethodBeat.o(252739);
        return true;
      }
      paramIntent = paramIntent.getClassName();
      if ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.qzone")))
      {
        AppMethodBeat.o(252739);
        return true;
      }
    }
    AppMethodBeat.o(252739);
    return false;
  }
  
  private void logStartPluginErrInfo(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(252743);
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
        AppMethodBeat.o(252743);
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
    AppMethodBeat.o(252743);
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(252717);
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
      paramIntent.putExtra("pluginsdk_logCallbackClassName", APMidasPayHelper.getLogCallbackClassName());
      try
      {
        paramActivity.startActivityForResult(paramIntent, paramInt);
        AppMethodBeat.o(252717);
        return;
      }
      catch (Throwable paramActivity)
      {
        APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult Throwable:" + paramActivity.toString());
        AppMethodBeat.o(252717);
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
    AppMethodBeat.i(252741);
    if (paramBundle == null)
    {
      AppMethodBeat.o(252741);
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
    AppMethodBeat.o(252741);
  }
  
  private void startPluginActivityForResult(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(252711);
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
    paramActivity.startActivityForResult(localIntent, paramInt);
    AppMethodBeat.o(252711);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252733);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IDispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(252733);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(252733);
    return bool;
  }
  
  protected Class<? extends APPluginProxyActivity> getProxyActivity(String paramString)
  {
    AppMethodBeat.i(252737);
    paramString = getClass();
    AppMethodBeat.o(252737);
    return paramString;
  }
  
  protected boolean isWrapContent()
  {
    AppMethodBeat.i(252687);
    boolean bool = true;
    if (this.mPluginActivity != null) {
      bool = this.mPluginActivity.IIsWrapContent();
    }
    AppMethodBeat.o(252687);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252713);
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
        AppMethodBeat.o(252713);
        return;
      }
      catch (Exception paramIntent)
      {
        APLog.w("APPLuginProxyActivity onActivityResult", paramIntent.toString());
      }
    }
    AppMethodBeat.o(252713);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(252719);
    try
    {
      super.onBackPressed();
      AppMethodBeat.o(252719);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
      AppMethodBeat.o(252719);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(252704);
    super.onConfigurationChanged(paramConfiguration);
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnConfigurationChanged(paramConfiguration);
        AppMethodBeat.o(252704);
        return;
      }
      catch (Exception paramConfiguration) {}
    }
    AppMethodBeat.o(252704);
  }
  
  /* Error */
  public void onCreate(Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: ldc_w 542
    //   7: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: ldc_w 300
    //   13: new 249	java/lang/StringBuilder
    //   16: dup
    //   17: ldc_w 544
    //   20: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   23: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   26: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 546
    //   32: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 36	com/tencent/midas/plugin/APPluginProxyActivity:gPluginApkFilePath	Ljava/lang/String;
    //   38: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 264	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   50: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +31 -> 84
    //   56: aload_0
    //   57: aload_1
    //   58: invokespecial 548	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   61: ldc_w 300
    //   64: ldc_w 550
    //   67: invokestatic 522	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 531	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   74: invokestatic 553	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   77: ldc_w 542
    //   80: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: return
    //   84: aload_0
    //   85: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   88: invokestatic 557	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPathString	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   91: invokestatic 510	com/tencent/midas/plugin/APPluginUtils:getMD5FromPath	(Ljava/lang/String;)Ljava/lang/String;
    //   94: astore 6
    //   96: getstatic 34	com/tencent/midas/plugin/APPluginProxyActivity:gPluginName	Ljava/lang/String;
    //   99: aload 6
    //   101: invokestatic 513	com/tencent/midas/plugin/APPluginLoader:getClassLoader	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/ClassLoader;
    //   104: astore 6
    //   106: aload_1
    //   107: ifnull +48 -> 155
    //   110: aload 6
    //   112: ifnull +43 -> 155
    //   115: ldc_w 300
    //   118: new 249	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 559
    //   125: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_1
    //   129: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   132: ldc_w 561
    //   135: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: aload 6
    //   140: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 264	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_1
    //   150: aload 6
    //   152: invokevirtual 401	android/os/Bundle:setClassLoader	(Ljava/lang/ClassLoader;)V
    //   155: aload_0
    //   156: invokevirtual 167	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   159: astore 7
    //   161: aload_1
    //   162: ifnull +248 -> 410
    //   165: aload_1
    //   166: astore 6
    //   168: aload_0
    //   169: aload 6
    //   171: ldc_w 348
    //   174: invokevirtual 564	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   177: putfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   180: aload_0
    //   181: aload 6
    //   183: ldc_w 354
    //   186: invokevirtual 564	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: putfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   192: aload_0
    //   193: aload 6
    //   195: ldc_w 356
    //   198: invokevirtual 564	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   201: putfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   204: aload 6
    //   206: ldc_w 374
    //   209: invokevirtual 568	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   212: istore 5
    //   214: ldc_w 300
    //   217: ldc_w 570
    //   220: iload 5
    //   222: invokestatic 573	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   225: invokevirtual 310	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   228: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   231: aload 6
    //   233: ldc_w 379
    //   236: invokevirtual 568	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   239: istore 4
    //   241: ldc_w 300
    //   244: ldc_w 575
    //   247: iload 4
    //   249: invokestatic 573	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   252: invokevirtual 310	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload 6
    //   260: ldc_w 381
    //   263: invokevirtual 564	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   266: astore 6
    //   268: ldc_w 300
    //   271: ldc_w 577
    //   274: aload 6
    //   276: invokestatic 306	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   279: invokevirtual 310	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   282: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload_0
    //   286: iload 5
    //   288: iload 4
    //   290: aload 6
    //   292: invokestatic 583	com/tencent/midas/comm/APLogUtil:initAPLogIfNewProcess	(Landroid/content/Context;ZZLjava/lang/String;)V
    //   295: ldc_w 300
    //   298: new 249	java/lang/StringBuilder
    //   301: dup
    //   302: ldc_w 585
    //   305: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload_0
    //   309: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   312: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc_w 587
    //   318: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   325: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: ldc_w 589
    //   331: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: aload_0
    //   335: getfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   338: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 264	com/tencent/midas/comm/APLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   347: aload_0
    //   348: getfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   351: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifeq +18 -> 372
    //   357: aload_0
    //   358: aload_0
    //   359: aload_0
    //   360: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   363: invokestatic 341	com/tencent/midas/plugin/APPluginInstallerAndUpdater:getInstallPath	(Landroid/content/Context;Ljava/lang/String;)Ljava/io/File;
    //   366: invokevirtual 346	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   369: putfield 50	com/tencent/midas/plugin/APPluginProxyActivity:mPluginApkFilePath	Ljava/lang/String;
    //   372: aload_0
    //   373: getfield 46	com/tencent/midas/plugin/APPluginProxyActivity:mLaunchActivity	Ljava/lang/String;
    //   376: invokestatic 226	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   379: ifeq +105 -> 484
    //   382: ldc_w 591
    //   385: ldc_w 593
    //   388: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   391: aload_0
    //   392: aload_1
    //   393: invokespecial 548	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   396: aload_0
    //   397: invokevirtual 531	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   400: invokestatic 553	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   403: ldc_w 542
    //   406: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: return
    //   410: aload 6
    //   412: ifnull +10 -> 422
    //   415: aload 7
    //   417: aload 6
    //   419: invokevirtual 173	android/content/Intent:setExtrasClassLoader	(Ljava/lang/ClassLoader;)V
    //   422: aload_0
    //   423: invokevirtual 167	com/tencent/midas/plugin/APPluginProxyActivity:getIntent	()Landroid/content/Intent;
    //   426: invokevirtual 466	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   429: astore 6
    //   431: goto -263 -> 168
    //   434: astore 7
    //   436: ldc_w 269
    //   439: astore 6
    //   441: iconst_1
    //   442: istore 4
    //   444: iconst_0
    //   445: istore 5
    //   447: ldc_w 300
    //   450: new 249	java/lang/StringBuilder
    //   453: dup
    //   454: ldc_w 595
    //   457: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   460: aload 7
    //   462: invokevirtual 519	java/lang/Exception:toString	()Ljava/lang/String;
    //   465: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 522	com/tencent/midas/comm/APLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: aload_0
    //   475: invokevirtual 531	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   478: invokestatic 553	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   481: goto -196 -> 285
    //   484: aload_0
    //   485: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   488: ifnull +13 -> 501
    //   491: aload_0
    //   492: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   495: invokevirtual 146	java/lang/String:length	()I
    //   498: ifne +103 -> 601
    //   501: ldc_w 597
    //   504: astore 6
    //   506: iload_2
    //   507: ifne +8 -> 515
    //   510: aload_0
    //   511: aload_1
    //   512: invokespecial 548	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   515: aload 6
    //   517: ifnull +77 -> 594
    //   520: aload_0
    //   521: aload 6
    //   523: putfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   526: ldc_w 591
    //   529: ldc_w 599
    //   532: aload 6
    //   534: invokestatic 306	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   537: invokevirtual 310	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   540: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   543: aload_0
    //   544: aload_0
    //   545: getfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   548: invokespecial 601	com/tencent/midas/plugin/APPluginProxyActivity:logStartPluginErrInfo	(Ljava/lang/String;)V
    //   551: aload_0
    //   552: aload_0
    //   553: getfield 56	com/tencent/midas/plugin/APPluginProxyActivity:mCreateErrorInfo	Ljava/lang/String;
    //   556: invokevirtual 604	com/tencent/midas/plugin/APPluginProxyActivity:shouldHandleStartPluginFailed	(Ljava/lang/String;)Z
    //   559: ifne +35 -> 594
    //   562: invokestatic 610	com/tencent/midas/data/APPluginReportManager:getInstance	()Lcom/tencent/midas/data/APPluginReportManager;
    //   565: ldc_w 612
    //   568: ldc_w 614
    //   571: aload_0
    //   572: getfield 52	com/tencent/midas/plugin/APPluginProxyActivity:mPluginName	Ljava/lang/String;
    //   575: aload 6
    //   577: invokevirtual 618	com/tencent/midas/data/APPluginReportManager:insertData	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   580: aload_0
    //   581: aload 6
    //   583: iconst_1
    //   584: invokestatic 622	com/tencent/midas/plugin/APPluginUtils:showLaunchPluginFail	(Landroid/content/Context;Ljava/lang/String;Z)V
    //   587: aload_0
    //   588: invokevirtual 531	com/tencent/midas/plugin/APPluginProxyActivity:finish	()V
    //   591: invokestatic 553	com/tencent/midas/plugin/APPluginStatic:removeAll	()V
    //   594: ldc_w 542
    //   597: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   600: return
    //   601: aload_0
    //   602: invokespecial 624	com/tencent/midas/plugin/APPluginProxyActivity:initPlugin	()Ljava/lang/String;
    //   605: astore 6
    //   607: aload 6
    //   609: ifnonnull +126 -> 735
    //   612: getstatic 99	android/os/Build$VERSION:SDK_INT	I
    //   615: bipush 11
    //   617: if_icmplt +17 -> 634
    //   620: aload_0
    //   621: invokevirtual 628	com/tencent/midas/plugin/APPluginProxyActivity:getLayoutInflater	()Landroid/view/LayoutInflater;
    //   624: new 630	com/tencent/midas/plugin/APLayoutInflaterFactory
    //   627: dup
    //   628: invokespecial 631	com/tencent/midas/plugin/APLayoutInflaterFactory:<init>	()V
    //   631: invokevirtual 637	android/view/LayoutInflater:setFactory2	(Landroid/view/LayoutInflater$Factory2;)V
    //   634: aload_0
    //   635: aload_1
    //   636: invokespecial 548	android/app/Activity:onCreate	(Landroid/os/Bundle;)V
    //   639: aload_0
    //   640: getfield 48	com/tencent/midas/plugin/APPluginProxyActivity:mPluginActivity	Lcom/tencent/midas/plugin/IAPPluginActivity;
    //   643: aload_1
    //   644: invokeinterface 640 2 0
    //   649: iconst_1
    //   650: istore_2
    //   651: goto -145 -> 506
    //   654: astore 6
    //   656: iload_3
    //   657: istore_2
    //   658: ldc_w 591
    //   661: new 249	java/lang/StringBuilder
    //   664: dup
    //   665: ldc_w 642
    //   668: invokespecial 252	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   671: aload 6
    //   673: invokevirtual 519	java/lang/Exception:toString	()Ljava/lang/String;
    //   676: invokevirtual 256	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 259	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 366	com/tencent/midas/comm/APLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: aload 6
    //   687: invokestatic 646	com/tencent/midas/plugin/APPluginUtils:getExceptionInfo	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   690: astore 6
    //   692: goto -186 -> 506
    //   695: astore 6
    //   697: iconst_1
    //   698: istore_2
    //   699: goto -41 -> 658
    //   702: astore 6
    //   704: goto -332 -> 372
    //   707: astore 7
    //   709: ldc_w 269
    //   712: astore 6
    //   714: iconst_1
    //   715: istore 4
    //   717: goto -270 -> 447
    //   720: astore 7
    //   722: ldc_w 269
    //   725: astore 6
    //   727: goto -280 -> 447
    //   730: astore 7
    //   732: goto -285 -> 447
    //   735: iconst_0
    //   736: istore_2
    //   737: goto -86 -> 651
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	740	0	this	APPluginProxyActivity
    //   0	740	1	paramBundle	Bundle
    //   3	734	2	i	int
    //   1	656	3	j	int
    //   239	477	4	bool1	boolean
    //   212	234	5	bool2	boolean
    //   94	514	6	localObject	Object
    //   654	32	6	localException1	Exception
    //   690	1	6	str1	String
    //   695	1	6	localException2	Exception
    //   702	1	6	localException3	Exception
    //   712	14	6	str2	String
    //   159	257	7	localIntent	Intent
    //   434	27	7	localException4	Exception
    //   707	1	7	localException5	Exception
    //   720	1	7	localException6	Exception
    //   730	1	7	localException7	Exception
    // Exception table:
    //   from	to	target	type
    //   168	214	434	java/lang/Exception
    //   601	607	654	java/lang/Exception
    //   612	634	654	java/lang/Exception
    //   634	639	654	java/lang/Exception
    //   639	649	695	java/lang/Exception
    //   357	372	702	java/lang/Exception
    //   214	241	707	java/lang/Exception
    //   241	268	720	java/lang/Exception
    //   268	285	730	java/lang/Exception
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(252725);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnCreateOptionsMenu(paramMenu);
      AppMethodBeat.o(252725);
      return bool;
    }
    boolean bool = super.onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(252725);
    return bool;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(252702);
    super.onDestroy();
    APLog.i("APPluginProxyActivity", "onDestroy mPluginActivity:" + this.mPluginActivity);
    APLogUtil.flushIfNewProcess();
    if (this.mPluginActivity != null) {
      try
      {
        this.mPluginActivity.IOnDestroy();
        AppMethodBeat.o(252702);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(252702);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252693);
    boolean bool1 = false;
    if (this.mPluginActivity != null) {
      bool1 = this.mPluginActivity.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    AppMethodBeat.o(252693);
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(252728);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnMenuItemSelected(paramInt, paramMenuItem);
      AppMethodBeat.o(252728);
      return bool;
    }
    boolean bool = super.onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(252728);
    return bool;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252689);
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
    AppMethodBeat.o(252689);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(252727);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnOptionsItemSelected(paramMenuItem);
      AppMethodBeat.o(252727);
      return bool;
    }
    boolean bool = super.onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(252727);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(252700);
    super.onPause();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnPause();
    }
    AppMethodBeat.o(252700);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(252726);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnPrepareOptionsMenu(paramMenu);
      AppMethodBeat.o(252726);
      return bool;
    }
    boolean bool = super.onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(252726);
    return bool;
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252715);
    APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + paramInt + " permissions:" + paramArrayOfString + " grantResults:" + paramArrayOfInt);
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    if (this.mPluginActivity != null) {
      try
      {
        String str = APPluginUtils.getMD5FromPath(APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath());
        APPluginLoader.getClassLoader(this.mPluginName, str);
        this.mPluginActivity.IOnRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        AppMethodBeat.o(252715);
        return;
      }
      catch (Exception paramArrayOfString)
      {
        APLog.w("APPLuginProxyActivity onRequestPermissionsResult", paramArrayOfString.toString());
      }
    }
    AppMethodBeat.o(252715);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(252729);
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
      AppMethodBeat.o(252729);
      return;
    }
    catch (Exception localException)
    {
      break label36;
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(252696);
    super.onResume();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnResume();
    }
    AppMethodBeat.o(252696);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(252730);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnSaveInstanceState(paramBundle);
    }
    paramBundle.putString("pluginsdk_pluginName", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginLocation", this.mPluginName);
    paramBundle.putString("pluginsdk_pluginpath", this.mPluginApkFilePath);
    paramBundle.putString("pluginsdk_launchActivity", this.mLaunchActivity);
    super.onSaveInstanceState(paramBundle);
    AppMethodBeat.o(252730);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(252694);
    super.onStart();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStart();
    }
    AppMethodBeat.o(252694);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(252697);
    super.onStop();
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnStop();
    }
    AppMethodBeat.o(252697);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252731);
    if (this.mPluginActivity != null)
    {
      bool = this.mPluginActivity.IOnTouchEvent(paramMotionEvent);
      AppMethodBeat.o(252731);
      return bool;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(252731);
    return bool;
  }
  
  public void onUserInteraction()
  {
    AppMethodBeat.i(252735);
    if (this.mPluginActivity != null)
    {
      this.mPluginActivity.IOnUserInteraction();
      AppMethodBeat.o(252735);
      return;
    }
    super.onUserInteraction();
    AppMethodBeat.o(252735);
  }
  
  protected void onUserLeaveHint()
  {
    AppMethodBeat.i(252691);
    super.onUserLeaveHint();
    AppMethodBeat.o(252691);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(252721);
    AppMethodBeat.at(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (this.mPluginActivity != null) {
      this.mPluginActivity.IOnWindowFocusChanged(paramBoolean);
    }
    AppMethodBeat.o(252721);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(252703);
    APLog.i("APPluginProxyActivity", "setRequestedOrientation requestedOrientation:".concat(String.valueOf(paramInt)));
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(252703);
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    AppMethodBeat.i(252742);
    boolean bool = false;
    if ((paramString.contains("permission")) || (paramString.contains("filenotfoundexception"))) {
      showNeedUninstanllAndInstallDialog();
    }
    for (bool = true;; bool = true)
    {
      do
      {
        AppMethodBeat.o(252742);
        return bool;
      } while ((!paramString.contains("resources$notfoundexception")) && (!paramString.contains("resourcesnotfoundexception")));
      showNeedUninstanllAndInstallDialog();
    }
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    AppMethodBeat.i(252744);
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("系统繁忙" + this.mPluginName + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(252649);
        APPluginProxyActivity.this.finish();
        AppMethodBeat.o(252649);
      }
    });
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      ((Dialog)localObject).show();
      AppMethodBeat.o(252744);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(252744);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(252707);
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
      AppMethodBeat.o(252707);
      return;
      super.startActivityForResult(paramIntent, paramInt);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252708);
    APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
    this.mStopFlag = 2;
    isStart3rdApp(paramIntent);
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    super.startActivityForResult(paramIntent, paramInt1);
    AppMethodBeat.o(252708);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */