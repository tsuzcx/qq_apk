package com.tencent.mobileqq.pluginsdk;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Toast;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.FlingTrackerHandler;
import com.tencent.mobileqq.activity.fling.ScreenCapture;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BasePadActivity;
import mqq.app.permission.PermissionManager;

public abstract class PluginProxyActivity
  extends BasePadActivity
{
  public static final String ACTION_PLUGIN_DIR_INFO_LOG = "com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG";
  public static final String ACTION_PLUGIN_STARTUP_FAILED = "com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED";
  public static final String READER_ID = "qqreaderplugin.apk";
  private static final String a = "PluginProxyActivity";
  private static final String b = "pluginsdk_inner_intent_extras";
  private static final String c = "pluginsdk_inner_bundle";
  public static boolean mAppForground = true;
  public static boolean mGestureLockEnable = false;
  private static String n = "";
  private static Method r = null;
  private static Field s = null;
  private Class d = null;
  private IPluginActivity e = null;
  private boolean f = false;
  private int g;
  private String h = null;
  private String i = null;
  private String j = null;
  private String k = null;
  private String l = null;
  private boolean m = false;
  protected String mCreateErrorInfo = null;
  protected boolean mIsShowQQBackgroundIcon = true;
  protected int mStopFlag = 0;
  private boolean o = true;
  private FlingHandler p;
  public PermissionManager permissionManager = PermissionManager.init(this);
  private BroadcastReceiver q = new g(this);
  
  private void a(Activity paramActivity, String paramString, Intent paramIntent, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, getProxyActivity(paramString));
    localIntent.putExtra("pluginsdk_pluginName", this.i);
    localIntent.putExtra("pluginsdk_pluginLocation", this.j);
    localIntent.putExtra("pluginsdk_pluginpath", this.h);
    localIntent.putExtra("pluginsdk_launchActivity", paramString);
    localIntent.putExtra("useSkinEngine", this.f);
    if ((this.g == 1) || (this.g == -1) || (this.g == 2)) {
      localIntent.putExtra("userQqResources", this.g);
    }
    if (paramIntent != null)
    {
      localIntent.addFlags(paramIntent.getFlags());
      localIntent.putExtra("pluginsdk_inner_intent_extras", new Bundle(paramIntent.getExtras()));
    }
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  private void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setUinForPlugin", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, paramString });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private void a(Context paramContext, String paramString, int paramInt)
  {
    try
    {
      Toast.makeText(paramContext, paramString, paramInt).show();
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext.getMethod("setAppForground", new Class[] { Context.class, Boolean.TYPE }).invoke(paramContext, new Object[] { this, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Bundle paramBundle, ClassLoader paramClassLoader)
    throws Exception
  {
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      paramBundle.setClassLoader(paramClassLoader);
      Object localObject;
      if ((r == null) || (s == null))
      {
        localObject = paramBundle.getClass();
        r = ((Class)localObject).getDeclaredMethod("unparcel", new Class[0]);
        r.setAccessible(true);
        s = ((Class)localObject).getDeclaredField("mMap");
        s.setAccessible(true);
      }
      r.invoke(paramBundle, new Object[0]);
      paramBundle = (Map)s.get(paramBundle);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.values().iterator();
        while (paramBundle.hasNext())
        {
          localObject = paramBundle.next();
          if ((localObject instanceof Bundle)) {
            a((Bundle)localObject, paramClassLoader);
          }
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Object localObject = getIntent();
    String str = ((Intent)localObject).getStringExtra("clsUploader");
    localObject = ((Intent)localObject).getStringExtra("pluginsdk_selfuin");
    if (str != null)
    {
      Intent localIntent = new Intent("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
      localIntent.putExtra("pluginsdk_selfuin", (String)localObject);
      localIntent.putExtra("pluginsdk_pluginName", paramString1);
      localIntent.putExtra("pluginsdk_pluginLocation", paramString2);
      localIntent.putExtra("pluginsdk_pluginpath", this.h);
      localIntent.putExtra("pluginsdk_launchActivity", paramString3);
      localIntent.putExtra("pluginsdk_extraInfo", paramString4);
      localIntent.putExtra("clsUploader", str);
      sendBroadcast(localIntent);
    }
  }
  
  private boolean a(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getAppForground", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return true;
  }
  
  private boolean a(Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ((!TextUtils.isEmpty(str)) && (str.equals("android.media.action.IMAGE_CAPTURE"))) {}
    do
    {
      do
      {
        do
        {
          return true;
        } while ((!TextUtils.isEmpty(str)) && (str.equals("android.intent.action.GET_CONTENT")));
        paramIntent = paramIntent.getComponent();
        if (paramIntent == null) {
          break;
        }
        str = paramIntent.getPackageName();
      } while ((!TextUtils.isEmpty(str)) && (str.equals("com.qzone")));
      paramIntent = paramIntent.getClassName();
    } while ((!TextUtils.isEmpty(paramIntent)) && (paramIntent.equals("com.tencent.mobileqq.activity.QQBrowserDelegationActivity")));
    return false;
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool2 = false;
    if (((paramThrowable instanceof FileNotFoundException)) || ((paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("permission"))))
    {
      QLog.d("plugin_tag", 1, "" + this.h);
      paramThrowable = getApplicationInfo();
      if (paramThrowable != null) {
        if ((paramThrowable.flags & 0x1) <= 0) {
          break label160;
        }
      }
      label160:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((paramThrowable.flags & 0x80) > 0) {
          bool2 = true;
        }
        QLog.d("plugin_tag", 1, "UID: " + paramThrowable.uid + ", IsSystemApp: " + bool1 + ", IsUpdateSystemApp: " + bool2);
        sendBroadcast(new Intent("com.tencent.mobileqq.ACTION_PLUGIN_DIR_INFO_LOG"));
        showNeedUninstanllAndInstallDialog();
        return true;
      }
    }
    if ((paramThrowable instanceof Resources.NotFoundException))
    {
      showNeedUninstanllAndInstallDialog();
      return true;
    }
    if (((paramThrowable instanceof ClassNotFoundException)) || ((paramThrowable instanceof PluginUtils.a)))
    {
      QLog.d("plugin_tag", 1, "" + this.h);
      PluginRecoverReceiver.a(this, this.j);
      return false;
    }
    return shouldHandleStartPluginFailed(this.mCreateErrorInfo);
  }
  
  private void b()
  {
    if (this.mCreateErrorInfo != null)
    {
      if ((this.mCreateErrorInfo.contains("空间")) || (this.mCreateErrorInfo.contains("Space"))) {
        a(BaseApplication.getContext(), "系统可用内存不足，" + this.i + "启动失败!", 0);
      }
    }
    else {
      return;
    }
    a(BaseApplication.getContext(), this.i + "启动失败!", 0);
  }
  
  private boolean b(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("enableGestureLock", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  private String c(Context paramContext)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getUinForPlugin", new Class[] { Context.class }).invoke(paramContext, new Object[] { this });
      if ((paramContext instanceof String))
      {
        paramContext = (String)paramContext;
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private void c()
    throws Exception
  {
    Object localObject1 = (PackageInfo)PluginStatic.d.get(this.h);
    if (localObject1 == null)
    {
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start getPackageInfo");
      }
      localObject1 = ApkFileParser.getPackageInfo(this, this.h, 1);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin end getPackageInfo");
      }
      if (localObject1 == null) {
        throw new PluginUtils.a("Get Package Info Failed!");
      }
      PluginStatic.d.put(this.h, localObject1);
    }
    for (;;)
    {
      if ((this.k == null) || (this.k.length() == 0))
      {
        if ((((PackageInfo)localObject1).activities == null) || (((PackageInfo)localObject1).activities.length == 0)) {
          throw new PluginUtils.b();
        }
        this.k = localObject1.activities[0].name;
      }
      Object localObject2 = PluginStatic.a(this, this.j, this.h);
      getIntent().setExtrasClassLoader((ClassLoader)localObject2);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.d = ((ClassLoader)localObject2).loadClass(this.k);
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity.initPlugin start loadClass");
      }
      this.e = ((IPluginActivity)this.d.newInstance());
      this.e.IInit(this.j, this.h, this, (ClassLoader)localObject2, (PackageInfo)localObject1, this.f, this.g);
      localObject1 = new Intent(getIntent());
      localObject2 = ((Intent)localObject1).getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtras((Bundle)localObject2);
        ((Intent)localObject1).removeExtra("pluginsdk_inner_intent_extras");
      }
      this.e.ISetIntent((Intent)localObject1);
      return;
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent("action_launch_completed");
    localIntent.putExtra("plugin_apk", this.j);
    sendBroadcast(localIntent);
  }
  
  private boolean e()
  {
    try
    {
      Object localObject = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      localObject = ((Class)localObject).getMethod("isAppOnForeground", new Class[] { Context.class }).invoke(localObject, new Object[] { this });
      if ((localObject instanceof Boolean))
      {
        boolean bool = ((Boolean)localObject).booleanValue();
        return bool;
      }
    }
    catch (Exception localException)
    {
      return false;
    }
    return false;
  }
  
  public static boolean isMoveTaskToBack(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getComponent() == null) {}
    while (!paramIntent.getComponent().getPackageName().equals(paramContext.getPackageName())) {
      return true;
    }
    return false;
  }
  
  public static void openActivityForResult(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, Intent paramIntent, int paramInt)
  {
    paramIntent.putExtra("pluginsdk_pluginName", paramString1);
    paramIntent.putExtra("pluginsdk_pluginLocation", paramString2);
    paramIntent.putExtra("pluginsdk_launchActivity", paramString4);
    paramIntent.putExtra("pluginsdk_pluginpath", paramString3);
    try
    {
      paramActivity.startActivityForResult(paramIntent, paramInt);
      return;
    }
    catch (Throwable paramActivity) {}
  }
  
  protected boolean dataEquals(Intent paramIntent)
  {
    Log.i("app2", "PluginProxyActivity dataEquals");
    return false;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
    {
      if (!this.e.IDispatchTouchEvent(paramMotionEvent)) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean getGestureLock(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Class.forName("com.tencent.mobileqq.gesturelock.GesturePWDUtils");
      paramContext = paramContext.getMethod("getJumpLock", new Class[] { Context.class, String.class }).invoke(paramContext, new Object[] { this, n });
      if ((paramContext instanceof Boolean))
      {
        boolean bool = ((Boolean)paramContext).booleanValue();
        return bool;
      }
    }
    catch (Exception paramContext)
    {
      return false;
    }
    return false;
  }
  
  public String getPluginID()
  {
    return null;
  }
  
  protected Class getProxyActivity(String paramString)
  {
    return getClass();
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.e != null) {}
    try
    {
      ClassLoader localClassLoader = PluginStatic.b(this.j);
      if ((localClassLoader != null) && (paramIntent != null)) {
        paramIntent.setExtrasClassLoader(localClassLoader);
      }
      this.e.IOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        paramIntent.printStackTrace();
      }
    }
    this.o = false;
  }
  
  public void onBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      finish();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.e != null) {
      this.e.IOnConfigurationChanged(paramConfiguration);
    }
    if ((isWrapContent()) && (this.p != null)) {
      this.p.onConfigurationChanged(paramConfiguration);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate");
    }
    a.a();
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.registerAccountReceiverIfNeccessary");
    }
    Object localObject1;
    Object localObject2;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.getBundle("pluginsdk_inner_bundle");
      localObject2 = paramBundle;
    }
    while (!PluginStatic.a((Bundle)localObject2))
    {
      super.onCreate(paramBundle);
      finish();
      return;
      localObject2 = getIntent().getExtras();
      localObject1 = null;
    }
    this.i = ((Bundle)localObject2).getString("pluginsdk_pluginName");
    this.j = ((Bundle)localObject2).getString("pluginsdk_pluginLocation");
    this.k = ((Bundle)localObject2).getString("pluginsdk_launchActivity");
    this.f = ((Bundle)localObject2).getBoolean("useSkinEngine", false);
    this.g = ((Bundle)localObject2).getInt("userQqResources", 0);
    this.h = ((Bundle)localObject2).getString("pluginsdk_pluginpath");
    PluginRecoverReceiver.a(this.j);
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity onCreate.fetchParams");
    }
    if (TextUtils.isEmpty(this.h)) {}
    try
    {
      this.h = PluginUtils.getInstalledPluginPath(this, this.j).getCanonicalPath();
      label188:
      this.l = ((Bundle)localObject2).getString("pluginsdk_selfuin");
      if (!TextUtils.isEmpty(this.l))
      {
        n = this.l;
        a(this, this.l);
      }
      for (;;)
      {
        this.m = ((Bundle)localObject2).getBoolean("param_plugin_gesturelock", false);
        if ((this.m) || (b(this))) {
          mGestureLockEnable = true;
        }
        if (DebugHelper.sDebug) {
          DebugHelper.log("PluginProxyActivity onCreate start registerReceiver");
        }
        localObject2 = new IntentFilter();
        ((IntentFilter)localObject2).addAction("android.intent.action.SCREEN_OFF");
        try
        {
          registerReceiver(this.q, (IntentFilter)localObject2);
          if (DebugHelper.sDebug) {
            DebugHelper.log("plugin_tag", "PluginProxyActivity.onCreate Params:" + this.j + ", " + this.k + "mPluginApkFilePath=" + this.h);
          }
          if ((this.j == null) || (this.j.length() == 0))
          {
            localObject1 = new IllegalArgumentException("Param mPluingLocation missing!");
            i1 = 0;
            if (i1 == 0) {
              super.onCreate(paramBundle);
            }
            if (localObject1 == null) {
              break label667;
            }
            this.mCreateErrorInfo = PluginUtils.getExceptionInfo((Throwable)localObject1);
            if (DebugHelper.sDebug) {
              DebugHelper.log("PluginProxyActivity.onCreate startPlugin:" + this.i + ", " + this.mCreateErrorInfo);
            }
            if (!a((Throwable)localObject1))
            {
              b();
              finish();
            }
            a(this.i, this.j, this.k, this.mCreateErrorInfo);
            if (DebugHelper.sDebug) {
              DebugHelper.log("plugin_tag", "PluginProxyActivity onCreate start sendLaunchCompletedBroadcast");
            }
            d();
            return;
            n = c(this);
          }
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            if (DebugHelper.sDebug)
            {
              DebugHelper.log("plugin_tag", "register exception.", localException1);
              continue;
              try
              {
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate start initPlugin");
                }
                c();
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity onCreate end initPlugin");
                }
                this.e.IOnSetTheme();
                super.onCreate(paramBundle);
              }
              catch (Throwable localThrowable1)
              {
                try
                {
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate start IOnCreate");
                  }
                  if (localObject1 != null) {
                    ((Bundle)localObject1).setClassLoader(PluginStatic.b(this.j));
                  }
                  this.e.IOnCreate((Bundle)localObject1);
                  if (DebugHelper.sDebug) {
                    DebugHelper.log("PluginProxyActivity onCreate end IOnCreate");
                  }
                  i1 = 1;
                  localObject1 = localObject3;
                }
                catch (Throwable localThrowable2)
                {
                  for (;;)
                  {
                    i1 = 1;
                  }
                }
                localThrowable1 = localThrowable1;
                i1 = 0;
              }
              this.e = null;
              localThrowable1.printStackTrace();
              PluginRuntime.handleCrash(localThrowable1, this.j, this);
              continue;
              label667:
              this.mCreateErrorInfo = "success";
              if (DebugHelper.sDebug) {
                DebugHelper.log("PluginProxyActivity.onCreate Success");
              }
              paramBundle = getIntent().getExtras();
              if (paramBundle != null)
              {
                i1 = paramBundle.getInt("fling_action_key");
                if (DebugHelper.sDebug) {
                  DebugHelper.log("PluginProxyActivity.onCreate FLING_ACTION_KEY: " + i1 + ", from: " + paramBundle);
                }
                if ((i1 != 0) && (isWrapContent())) {
                  if (1 == i1) {
                    this.p = new FlingTrackerHandler(this);
                  } else {
                    this.p = new FlingGestureHandler(this);
                  }
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException2)
    {
      int i1;
      break label188;
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (this.e != null) {
      return this.e.IOnCreateOptionsMenu(paramMenu);
    }
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.e != null) {}
    try
    {
      this.e.IOnDestroy();
      this.e = null;
      if (DebugHelper.sDebug) {
        DebugHelper.log("PluginProxyActivity onDestroy");
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          unregisterReceiver(this.q);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool1 = false;
    if (this.e != null) {
      bool1 = this.e.IOnKeyDown(paramInt, paramKeyEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.onKeyDown(paramInt, paramKeyEvent);
    }
    return bool2;
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (this.e != null) {
      return this.e.IOnMenuItemSelected(paramInt, paramMenuItem);
    }
    return super.onMenuItemSelected(paramInt, paramMenuItem);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Object localObject = PluginStatic.b(this.j);
    if (localObject != null) {
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
    }
    if (this.e != null)
    {
      paramIntent = new Intent(paramIntent);
      paramIntent.setExtrasClassLoader((ClassLoader)localObject);
      localObject = paramIntent.getBundleExtra("pluginsdk_inner_intent_extras");
      if (localObject != null)
      {
        paramIntent.putExtras((Bundle)localObject);
        paramIntent.removeExtra("pluginsdk_inner_intent_extras");
      }
      this.e.IOnNewIntent(paramIntent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (this.e != null) {
      return this.e.IOnOptionsItemSelected(paramMenuItem);
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.e != null) {
      this.e.IOnPause();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onPause");
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.e != null) {
      return this.e.IOnPrepareOptionsMenu(paramMenu);
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.permissionManager.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    ClassLoader localClassLoader = PluginStatic.b(this.j);
    if (localClassLoader != null) {}
    try
    {
      a(paramBundle, localClassLoader);
      label17:
      super.onRestoreInstanceState(paramBundle);
      if (this.e != null)
      {
        Bundle localBundle = paramBundle.getBundle("pluginsdk_inner_bundle");
        paramBundle = localBundle;
        if (localBundle == null) {
          paramBundle = new Bundle();
        }
        paramBundle.setClassLoader(localClassLoader);
        this.e.IOnRestoreInstanceState(paramBundle);
      }
      return;
    }
    catch (Exception localException)
    {
      break label17;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.e != null) {
      this.e.IOnResume();
    }
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.onResume");
    }
    if (mGestureLockEnable)
    {
      mAppForground = a(this);
      if ((!mAppForground) && (!TextUtils.isEmpty(n)) && (getGestureLock(this, n)) && (this.o)) {
        startUnlockActivity();
      }
      if (!mAppForground)
      {
        mAppForground = true;
        a(this, mAppForground);
      }
      this.mStopFlag = 0;
      this.o = true;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if (this.e != null)
    {
      Bundle localBundle2 = paramBundle.getBundle("pluginsdk_inner_bundle");
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null)
      {
        localBundle1 = new Bundle();
        paramBundle.putBundle("pluginsdk_inner_bundle", localBundle1);
      }
      this.e.IOnSaveInstanceState(localBundle1);
    }
    paramBundle.putString("pluginsdk_pluginName", this.i);
    paramBundle.putString("pluginsdk_pluginLocation", this.j);
    paramBundle.putString("pluginsdk_pluginpath", this.h);
    paramBundle.putString("pluginsdk_launchActivity", this.k);
    paramBundle.putBoolean("useSkinEngine", this.f);
    paramBundle.putInt("userQqResources", this.g);
    paramBundle.putString("pluginsdk_selfuin", this.l);
    paramBundle.putBoolean("param_plugin_gesturelock", this.m);
    super.onSaveInstanceState(paramBundle);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.e != null) {
      this.e.IOnStart();
    }
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.foreground");
      localIntent.putExtra("selfuin", "");
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
    }
    if ((isWrapContent()) && (this.p != null)) {
      this.p.onStart();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.e != null) {
      this.e.IOnStop();
    }
    mAppForground = e();
    if (mGestureLockEnable)
    {
      if (!mAppForground) {
        a(this, mAppForground);
      }
      this.mStopFlag = 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.e != null)
    {
      if (!this.e.IOnTouchEvent(paramMotionEvent)) {
        return super.onTouchEvent(paramMotionEvent);
      }
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onUserInteraction()
  {
    if (this.e != null)
    {
      this.e.IOnUserInteraction();
      return;
    }
    super.onUserInteraction();
  }
  
  protected void onUserLeaveHint()
  {
    super.onUserLeaveHint();
    if (this.mIsShowQQBackgroundIcon)
    {
      Intent localIntent = new Intent("tencent.notify.background");
      localIntent.putExtra("selfuin", "");
      localIntent.putExtra("classname", getClass().getName());
      sendBroadcast(localIntent, "com.tencent.msg.permission.pushnotify2");
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.e != null) {
      this.e.IOnWindowFocusChanged(paramBoolean);
    }
  }
  
  protected boolean shouldHandleStartPluginFailed(String paramString)
  {
    return false;
  }
  
  protected void showNeedUninstanllAndInstallDialog()
  {
    Object localObject = new AlertDialog.Builder(this);
    ((AlertDialog.Builder)localObject).setTitle("温馨提示");
    ((AlertDialog.Builder)localObject).setMessage("启动" + this.i + "失败，请卸载重装~");
    ((AlertDialog.Builder)localObject).setPositiveButton("我知道了", new f(this));
    localObject = ((AlertDialog.Builder)localObject).create();
    try
    {
      ((Dialog)localObject).show();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if (paramIntent.getBooleanExtra("pluginsdk_IsPluginActivity", false))
    {
      String str = null;
      ComponentName localComponentName = paramIntent.getComponent();
      if (localComponentName != null) {
        str = localComponentName.getClassName();
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", false);
      if ((str != null) && (str.length() > 0)) {
        a(this, str, paramIntent, paramInt);
      }
    }
    for (;;)
    {
      this.mStopFlag = 2;
      return;
      startActivityForResult(paramIntent, paramInt, 2);
    }
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt1, int paramInt2)
  {
    this.mStopFlag = 2;
    if (a(paramIntent)) {
      this.o = false;
    }
    if (!isMoveTaskToBack(this, paramIntent)) {
      paramIntent.addFlags(262144);
    }
    switch (paramInt2)
    {
    default: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 0: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    case 1: 
      super.startActivityForResult(paramIntent, paramInt1);
      return;
    }
    startActivityForResultWithGesture(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithGesture(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithGesture(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("fling_action_key", 2);
    paramIntent.putExtra("fling_code_key", paramInt2);
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt)
  {
    startActivityForResultWithSnap(paramIntent, paramInt, hashCode());
  }
  
  public void startActivityForResultWithSnap(Intent paramIntent, int paramInt1, int paramInt2)
  {
    if (DebugHelper.sDebug) {
      DebugHelper.log("PluginProxyActivity.startActivityForResultWithSnap:" + paramInt2);
    }
    String str = ScreenCapture.getSnapPath(this, paramInt2);
    if (str != null)
    {
      ScreenCapture.captureViewToFile(str, getWindow().getDecorView());
      paramIntent.putExtra("fling_action_key", 1);
      paramIntent.putExtra("fling_code_key", paramInt2);
    }
    super.startActivityForResult(paramIntent, paramInt1);
  }
  
  protected void startUnlockActivity()
  {
    try
    {
      startActivity(new Intent(this, Class.forName("com.tencent.mobileqq.activity.GesturePWDUnlockActivity")));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginProxyActivity
 * JD-Core Version:    0.7.0.1
 */