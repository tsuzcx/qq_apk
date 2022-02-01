package com.tencent.midas.plugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.APLog;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.hellhoundlib.b.c;
import java.lang.reflect.Field;
import java.util.List;

public class APPluginActivity
  extends HellActivity
  implements IAPPluginActivity
{
  private byte _hellAccFlag_;
  public Activity mActivity = null;
  protected String mApkFilePath = "";
  public Context mContext = null;
  private ClassLoader mDexClassLoader = null;
  private boolean mFinished = false;
  protected boolean mIsRunInPlugin = false;
  protected PackageInfo mPackageInfo = null;
  protected String mPluginName = "";
  public Activity mProxyActivity = null;
  protected View mProxyContentView = null;
  
  public static final Bitmap getDrawableBitmap(Drawable paramDrawable)
  {
    AppMethodBeat.i(193046);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(193046);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(193046);
      return paramDrawable;
    }
    AppMethodBeat.o(193046);
    return null;
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193103);
    boolean bool1 = true;
    try
    {
      boolean bool2 = dispatchTouchEvent(paramMotionEvent);
      bool1 = bool2;
    }
    catch (Exception paramMotionEvent)
    {
      label15:
      break label15;
    }
    AppMethodBeat.o(193103);
    return bool1;
  }
  
  public void IFinish()
  {
    AppMethodBeat.i(193105);
    finish();
    AppMethodBeat.o(193105);
  }
  
  public View IGetContentView()
  {
    return this.mProxyContentView;
  }
  
  public Handler IGetInHandler()
  {
    return null;
  }
  
  public Resources IGetResource()
  {
    AppMethodBeat.i(193087);
    if (this.mContext != null)
    {
      localResources = this.mContext.getResources();
      AppMethodBeat.o(193087);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(193087);
    return localResources;
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo)
  {
    AppMethodBeat.i(193085);
    this.mIsRunInPlugin = true;
    this.mDexClassLoader = paramClassLoader;
    this.mProxyActivity = paramActivity;
    this.mPluginName = paramString1;
    this.mApkFilePath = paramString2;
    this.mPackageInfo = paramPackageInfo;
    this.mContext = new APPluginContext(paramActivity, 0, this.mApkFilePath, this.mDexClassLoader);
    attachBaseContext(this.mContext);
    AppMethodBeat.o(193085);
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193081);
    onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(193081);
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(193107);
    onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(193107);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193048);
    onCreate(paramBundle);
    AppMethodBeat.o(193048);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(193099);
    boolean bool = onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(193099);
    return bool;
  }
  
  public void IOnDestroy()
  {
    AppMethodBeat.i(193059);
    onDestroy();
    AppMethodBeat.o(193059);
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193066);
    boolean bool = onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(193066);
    return bool;
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193068);
    boolean bool = onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(193068);
    return bool;
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193067);
    boolean bool = onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(193067);
    return bool;
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(193106);
    boolean bool = onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(193106);
    return bool;
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193049);
    onNewIntent(paramIntent);
    AppMethodBeat.o(193049);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(193101);
    boolean bool = onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(193101);
    return bool;
  }
  
  public void IOnPause()
  {
    AppMethodBeat.i(193055);
    onPause();
    AppMethodBeat.o(193055);
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(193100);
    boolean bool = onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(193100);
    return bool;
  }
  
  @TargetApi(23)
  public void IOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193084);
    onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(193084);
  }
  
  public void IOnRestart()
  {
    AppMethodBeat.i(193061);
    onRestart();
    AppMethodBeat.o(193061);
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    AppMethodBeat.i(193053);
    onResume();
    AppMethodBeat.o(193053);
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnStart()
  {
    AppMethodBeat.i(193051);
    onStart();
    AppMethodBeat.o(193051);
  }
  
  public void IOnStop()
  {
    AppMethodBeat.i(193057);
    onStop();
    AppMethodBeat.o(193057);
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193102);
    boolean bool = onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(193102);
    return bool;
  }
  
  public void IOnUserInteraction()
  {
    AppMethodBeat.i(193104);
    onUserInteraction();
    AppMethodBeat.o(193104);
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193071);
    onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(193071);
  }
  
  @TargetApi(23)
  public void IRequestPermissions(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(193082);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).bl(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.a(this, locala.axQ(), "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    requestPermissions((String[])locala.pG(0), ((Integer)locala.pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + paramArrayOfString + ", requestCode=" + paramInt);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193082);
      return;
    }
    super.requestPermissions(paramArrayOfString, paramInt);
    AppMethodBeat.o(193082);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    AppMethodBeat.i(193069);
    setIntent(paramIntent);
    AppMethodBeat.o(193069);
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public View findViewById(int paramInt)
  {
    AppMethodBeat.i(193064);
    if ((this.mIsRunInPlugin) && (this.mProxyContentView != null))
    {
      View localView2 = this.mProxyContentView.findViewById(paramInt);
      localView1 = localView2;
      if (localView2 == null) {
        localView1 = super.findViewById(paramInt);
      }
      AppMethodBeat.o(193064);
      return localView1;
    }
    View localView1 = super.findViewById(paramInt);
    AppMethodBeat.o(193064);
    return localView1;
  }
  
  public void finish()
  {
    AppMethodBeat.i(193078);
    APLog.i("APPluginActivity", "APPluginActivity finish");
    if (this.mIsRunInPlugin)
    {
      int j = 0;
      int i = j;
      try
      {
        localObject1 = Activity.class.getDeclaredField("mResultCode");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        j = ((Integer)((Field)localObject1).get(this)).intValue();
        i = j;
        localObject1 = Activity.class.getDeclaredField("mResultData");
        i = j;
        ((Field)localObject1).setAccessible(true);
        i = j;
        localObject1 = (Intent)((Field)localObject1).get(this);
        i = j;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          new StringBuilder("APPluginActivity finish Exception:").append(localException.toString());
          Object localObject2 = null;
        }
      }
      finally
      {
        AppMethodBeat.o(193078);
      }
      this.mProxyActivity.setResult(i, (Intent)localObject1);
      this.mProxyActivity.finish();
      this.mFinished = true;
      AppMethodBeat.o(193078);
      return;
    }
    super.finish();
    AppMethodBeat.o(193078);
  }
  
  public Context getApplicationContext()
  {
    AppMethodBeat.i(193077);
    APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
    if (this.mIsRunInPlugin)
    {
      localContext = this.mProxyActivity.getApplicationContext();
      AppMethodBeat.o(193077);
      return localContext;
    }
    Context localContext = super.getApplicationContext();
    AppMethodBeat.o(193077);
    return localContext;
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    AppMethodBeat.i(193097);
    if (this.mIsRunInPlugin)
    {
      localApplicationInfo = this.mPackageInfo.applicationInfo;
      AppMethodBeat.o(193097);
      return localApplicationInfo;
    }
    ApplicationInfo localApplicationInfo = super.getApplicationInfo();
    AppMethodBeat.o(193097);
    return localApplicationInfo;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(193092);
    if (this.mIsRunInPlugin)
    {
      i = this.mProxyActivity.getChangingConfigurations();
      AppMethodBeat.o(193092);
      return i;
    }
    int i = super.getChangingConfigurations();
    AppMethodBeat.o(193092);
    return i;
  }
  
  public Resources getHostResources()
  {
    AppMethodBeat.i(193098);
    Resources localResources = this.mProxyActivity.getResources();
    AppMethodBeat.o(193098);
    return localResources;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(193086);
    if (this.mContext != null)
    {
      localLayoutInflater = LayoutInflater.from(this.mContext);
      AppMethodBeat.o(193086);
      return localLayoutInflater;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
    AppMethodBeat.o(193086);
    return localLayoutInflater;
  }
  
  public Activity getOutActivity()
  {
    return this.mProxyActivity;
  }
  
  public Resources getOutResources()
  {
    AppMethodBeat.i(193089);
    if (this.mIsRunInPlugin == true)
    {
      localResources = this.mProxyActivity.getResources();
      AppMethodBeat.o(193089);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(193089);
    return localResources;
  }
  
  public PackageInfo getPackageInfo()
  {
    if (this.mIsRunInPlugin) {
      return this.mPackageInfo;
    }
    return null;
  }
  
  public String getPackageName()
  {
    AppMethodBeat.i(193096);
    if (this.mIsRunInPlugin)
    {
      str = this.mPackageInfo.packageName;
      AppMethodBeat.o(193096);
      return str;
    }
    String str = super.getPackageName();
    AppMethodBeat.o(193096);
    return str;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(193090);
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin)
      {
        paramString = this.mProxyActivity.getSystemService(paramString);
        AppMethodBeat.o(193090);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(193090);
      return paramString;
    }
    if (this.mContext != null)
    {
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(193090);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(193090);
    return paramString;
  }
  
  public Window getWindow()
  {
    AppMethodBeat.i(193093);
    if (this.mIsRunInPlugin)
    {
      localWindow = this.mProxyActivity.getWindow();
      AppMethodBeat.o(193093);
      return localWindow;
    }
    Window localWindow = super.getWindow();
    AppMethodBeat.o(193093);
    return localWindow;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(193091);
    if (this.mIsRunInPlugin)
    {
      localWindowManager = this.mProxyActivity.getWindowManager();
      AppMethodBeat.o(193091);
      return localWindowManager;
    }
    WindowManager localWindowManager = super.getWindowManager();
    AppMethodBeat.o(193091);
    return localWindowManager;
  }
  
  public boolean isFinishing()
  {
    AppMethodBeat.i(193079);
    if (this.mIsRunInPlugin)
    {
      bool = this.mFinished;
      AppMethodBeat.o(193079);
      return bool;
    }
    boolean bool = super.isFinishing();
    AppMethodBeat.o(193079);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193080);
    APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193080);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(193080);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193047);
    if (this.mIsRunInPlugin)
    {
      this.mActivity = this.mProxyActivity;
      APPluginStatic.add(this);
      AppMethodBeat.o(193047);
      return;
    }
    super.onCreate(paramBundle);
    this.mActivity = this;
    AppMethodBeat.o(193047);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(193058);
    APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
    if (this.mIsRunInPlugin)
    {
      this.mDexClassLoader = null;
      APPluginStatic.remove(this);
      AppMethodBeat.o(193058);
      return;
    }
    super.onDestroy();
    AppMethodBeat.o(193058);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193072);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193072);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(193072);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193074);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193074);
      return false;
    }
    boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(193074);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193073);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193073);
      return false;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(193073);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(193054);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193054);
      return;
    }
    super.onPause();
    AppMethodBeat.o(193054);
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193083);
    APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=".concat(String.valueOf(paramInt)));
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193083);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(193083);
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(193060);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193060);
      return;
    }
    super.onRestart();
    AppMethodBeat.o(193060);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(193052);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193052);
      return;
    }
    super.onResume();
    AppMethodBeat.o(193052);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(193050);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193050);
      return;
    }
    super.onStart();
    AppMethodBeat.o(193050);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(193056);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193056);
      return;
    }
    super.onStop();
    AppMethodBeat.o(193056);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193076);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193076);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(193076);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(193070);
    AppMethodBeat.at(this, paramBoolean);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(193070);
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(193070);
  }
  
  public void openOptionsMenu()
  {
    AppMethodBeat.i(193075);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.openOptionsMenu();
      AppMethodBeat.o(193075);
      return;
    }
    super.openOptionsMenu();
    AppMethodBeat.o(193075);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193088);
    if (this.mIsRunInPlugin)
    {
      this.mActivity.overridePendingTransition(paramInt1, paramInt2);
      AppMethodBeat.o(193088);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(193088);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(193062);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = LayoutInflater.from(this).inflate(paramInt, null);
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(193062);
      return;
    }
    super.setContentView(paramInt);
    AppMethodBeat.o(193062);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(193063);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = paramView;
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(193063);
      return;
    }
    super.setContentView(paramView);
    AppMethodBeat.o(193063);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(193095);
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(193095);
  }
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(193094);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.setTheme(paramInt);
      AppMethodBeat.o(193094);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(193094);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(193065);
    if (this.mIsRunInPlugin)
    {
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {}
      for (bool = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false); !bool; bool = true)
      {
        label34:
        this.mActivity.startActivityForResult(paramIntent, paramInt);
        AppMethodBeat.o(193065);
        return;
        List localList = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
        if ((localList != null) && (localList.size() != 0)) {
          break label34;
        }
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      this.mActivity.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(193065);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(193065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginActivity
 * JD-Core Version:    0.7.0.1
 */