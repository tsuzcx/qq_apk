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
    AppMethodBeat.i(252440);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(252440);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(252440);
      return paramDrawable;
    }
    AppMethodBeat.o(252440);
    return null;
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252532);
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
    AppMethodBeat.o(252532);
    return bool1;
  }
  
  public void IFinish()
  {
    AppMethodBeat.i(252535);
    finish();
    AppMethodBeat.o(252535);
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
    AppMethodBeat.i(252504);
    if (this.mContext != null)
    {
      localResources = this.mContext.getResources();
      AppMethodBeat.o(252504);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(252504);
    return localResources;
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo)
  {
    AppMethodBeat.i(252502);
    this.mIsRunInPlugin = true;
    this.mDexClassLoader = paramClassLoader;
    this.mProxyActivity = paramActivity;
    this.mPluginName = paramString1;
    this.mApkFilePath = paramString2;
    this.mPackageInfo = paramPackageInfo;
    this.mContext = new APPluginContext(paramActivity, 0, this.mApkFilePath, this.mDexClassLoader);
    attachBaseContext(this.mContext);
    AppMethodBeat.o(252502);
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252495);
    onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(252495);
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(252537);
    onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(252537);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252443);
    onCreate(paramBundle);
    AppMethodBeat.o(252443);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(252524);
    boolean bool = onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(252524);
    return bool;
  }
  
  public void IOnDestroy()
  {
    AppMethodBeat.i(252461);
    onDestroy();
    AppMethodBeat.o(252461);
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252468);
    boolean bool = onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(252468);
    return bool;
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252472);
    boolean bool = onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(252472);
    return bool;
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252470);
    boolean bool = onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(252470);
    return bool;
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(252536);
    boolean bool = onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(252536);
    return bool;
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252444);
    onNewIntent(paramIntent);
    AppMethodBeat.o(252444);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(252529);
    boolean bool = onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(252529);
    return bool;
  }
  
  public void IOnPause()
  {
    AppMethodBeat.i(252456);
    onPause();
    AppMethodBeat.o(252456);
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(252527);
    boolean bool = onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(252527);
    return bool;
  }
  
  @TargetApi(23)
  public void IOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252501);
    onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(252501);
  }
  
  public void IOnRestart()
  {
    AppMethodBeat.i(252463);
    onRestart();
    AppMethodBeat.o(252463);
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    AppMethodBeat.i(252452);
    onResume();
    AppMethodBeat.o(252452);
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnStart()
  {
    AppMethodBeat.i(252448);
    onStart();
    AppMethodBeat.o(252448);
  }
  
  public void IOnStop()
  {
    AppMethodBeat.i(252459);
    onStop();
    AppMethodBeat.o(252459);
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252531);
    boolean bool = onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(252531);
    return bool;
  }
  
  public void IOnUserInteraction()
  {
    AppMethodBeat.i(252533);
    onUserInteraction();
    AppMethodBeat.o(252533);
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(252479);
    onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(252479);
  }
  
  @TargetApi(23)
  public void IRequestPermissions(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(252498);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).bm(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aFh(), "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    requestPermissions((String[])locala.sf(0), ((Integer)locala.sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + paramArrayOfString + ", requestCode=" + paramInt);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252498);
      return;
    }
    super.requestPermissions(paramArrayOfString, paramInt);
    AppMethodBeat.o(252498);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    AppMethodBeat.i(252475);
    setIntent(paramIntent);
    AppMethodBeat.o(252475);
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public View findViewById(int paramInt)
  {
    AppMethodBeat.i(252466);
    if ((this.mIsRunInPlugin) && (this.mProxyContentView != null))
    {
      View localView2 = this.mProxyContentView.findViewById(paramInt);
      localView1 = localView2;
      if (localView2 == null) {
        localView1 = super.findViewById(paramInt);
      }
      AppMethodBeat.o(252466);
      return localView1;
    }
    View localView1 = super.findViewById(paramInt);
    AppMethodBeat.o(252466);
    return localView1;
  }
  
  public void finish()
  {
    AppMethodBeat.i(252491);
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
        AppMethodBeat.o(252491);
      }
      this.mProxyActivity.setResult(i, (Intent)localObject1);
      this.mProxyActivity.finish();
      this.mFinished = true;
      AppMethodBeat.o(252491);
      return;
    }
    super.finish();
    AppMethodBeat.o(252491);
  }
  
  public Context getApplicationContext()
  {
    AppMethodBeat.i(252489);
    APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
    if (this.mIsRunInPlugin)
    {
      localContext = this.mProxyActivity.getApplicationContext();
      AppMethodBeat.o(252489);
      return localContext;
    }
    Context localContext = super.getApplicationContext();
    AppMethodBeat.o(252489);
    return localContext;
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    AppMethodBeat.i(252520);
    if (this.mIsRunInPlugin)
    {
      localApplicationInfo = this.mPackageInfo.applicationInfo;
      AppMethodBeat.o(252520);
      return localApplicationInfo;
    }
    ApplicationInfo localApplicationInfo = super.getApplicationInfo();
    AppMethodBeat.o(252520);
    return localApplicationInfo;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(252509);
    if (this.mIsRunInPlugin)
    {
      i = this.mProxyActivity.getChangingConfigurations();
      AppMethodBeat.o(252509);
      return i;
    }
    int i = super.getChangingConfigurations();
    AppMethodBeat.o(252509);
    return i;
  }
  
  public Resources getHostResources()
  {
    AppMethodBeat.i(252522);
    Resources localResources = this.mProxyActivity.getResources();
    AppMethodBeat.o(252522);
    return localResources;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(252503);
    if (this.mContext != null)
    {
      localLayoutInflater = LayoutInflater.from(this.mContext);
      AppMethodBeat.o(252503);
      return localLayoutInflater;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
    AppMethodBeat.o(252503);
    return localLayoutInflater;
  }
  
  public Activity getOutActivity()
  {
    return this.mProxyActivity;
  }
  
  public Resources getOutResources()
  {
    AppMethodBeat.i(252506);
    if (this.mIsRunInPlugin == true)
    {
      localResources = this.mProxyActivity.getResources();
      AppMethodBeat.o(252506);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(252506);
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
    AppMethodBeat.i(252514);
    if (this.mIsRunInPlugin)
    {
      str = this.mPackageInfo.packageName;
      AppMethodBeat.o(252514);
      return str;
    }
    String str = super.getPackageName();
    AppMethodBeat.o(252514);
    return str;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(252507);
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin)
      {
        paramString = this.mProxyActivity.getSystemService(paramString);
        AppMethodBeat.o(252507);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(252507);
      return paramString;
    }
    if (this.mContext != null)
    {
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(252507);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(252507);
    return paramString;
  }
  
  public Window getWindow()
  {
    AppMethodBeat.i(252510);
    if (this.mIsRunInPlugin)
    {
      localWindow = this.mProxyActivity.getWindow();
      AppMethodBeat.o(252510);
      return localWindow;
    }
    Window localWindow = super.getWindow();
    AppMethodBeat.o(252510);
    return localWindow;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(252508);
    if (this.mIsRunInPlugin)
    {
      localWindowManager = this.mProxyActivity.getWindowManager();
      AppMethodBeat.o(252508);
      return localWindowManager;
    }
    WindowManager localWindowManager = super.getWindowManager();
    AppMethodBeat.o(252508);
    return localWindowManager;
  }
  
  public boolean isFinishing()
  {
    AppMethodBeat.i(252493);
    if (this.mIsRunInPlugin)
    {
      bool = this.mFinished;
      AppMethodBeat.o(252493);
      return bool;
    }
    boolean bool = super.isFinishing();
    AppMethodBeat.o(252493);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252494);
    APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252494);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(252494);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252442);
    if (this.mIsRunInPlugin)
    {
      this.mActivity = this.mProxyActivity;
      APPluginStatic.add(this);
      AppMethodBeat.o(252442);
      return;
    }
    super.onCreate(paramBundle);
    this.mActivity = this;
    AppMethodBeat.o(252442);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(252460);
    APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
    if (this.mIsRunInPlugin)
    {
      this.mDexClassLoader = null;
      APPluginStatic.remove(this);
      AppMethodBeat.o(252460);
      return;
    }
    super.onDestroy();
    AppMethodBeat.o(252460);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252481);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252481);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(252481);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252485);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252485);
      return false;
    }
    boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(252485);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252483);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252483);
      return false;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(252483);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(252454);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252454);
      return;
    }
    super.onPause();
    AppMethodBeat.o(252454);
  }
  
  @TargetApi(23)
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252500);
    APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=".concat(String.valueOf(paramInt)));
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252500);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(252500);
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(252462);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252462);
      return;
    }
    super.onRestart();
    AppMethodBeat.o(252462);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(252450);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252450);
      return;
    }
    super.onResume();
    AppMethodBeat.o(252450);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(252446);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252446);
      return;
    }
    super.onStart();
    AppMethodBeat.o(252446);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(252458);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252458);
      return;
    }
    super.onStop();
    AppMethodBeat.o(252458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252488);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252488);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(252488);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(252478);
    AppMethodBeat.at(this, paramBoolean);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(252478);
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(252478);
  }
  
  public void openOptionsMenu()
  {
    AppMethodBeat.i(252487);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.openOptionsMenu();
      AppMethodBeat.o(252487);
      return;
    }
    super.openOptionsMenu();
    AppMethodBeat.o(252487);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252505);
    if (this.mIsRunInPlugin)
    {
      this.mActivity.overridePendingTransition(paramInt1, paramInt2);
      AppMethodBeat.o(252505);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(252505);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(252464);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = LayoutInflater.from(this).inflate(paramInt, null);
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(252464);
      return;
    }
    super.setContentView(paramInt);
    AppMethodBeat.o(252464);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(252465);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = paramView;
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(252465);
      return;
    }
    super.setContentView(paramView);
    AppMethodBeat.o(252465);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(252513);
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(252513);
  }
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(252511);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.setTheme(paramInt);
      AppMethodBeat.o(252511);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(252511);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(252467);
    if (this.mIsRunInPlugin)
    {
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {}
      for (bool = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false); !bool; bool = true)
      {
        label34:
        this.mActivity.startActivityForResult(paramIntent, paramInt);
        AppMethodBeat.o(252467);
        return;
        List localList = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
        if ((localList != null) && (localList.size() != 0)) {
          break label34;
        }
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      this.mActivity.startActivityForResult(paramIntent, paramInt);
      AppMethodBeat.o(252467);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(252467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginActivity
 * JD-Core Version:    0.7.0.1
 */