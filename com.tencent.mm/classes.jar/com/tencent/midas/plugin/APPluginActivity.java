package com.tencent.midas.plugin;

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
    AppMethodBeat.i(217518);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(217518);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(217518);
      return paramDrawable;
    }
    AppMethodBeat.o(217518);
    return null;
  }
  
  public boolean IDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217920);
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
    AppMethodBeat.o(217920);
    return bool1;
  }
  
  public void IFinish()
  {
    AppMethodBeat.i(217927);
    finish();
    AppMethodBeat.o(217927);
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
    AppMethodBeat.i(217841);
    if (this.mContext != null)
    {
      localResources = this.mContext.getResources();
      AppMethodBeat.o(217841);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(217841);
    return localResources;
  }
  
  public void IInit(String paramString1, String paramString2, Activity paramActivity, ClassLoader paramClassLoader, PackageInfo paramPackageInfo)
  {
    AppMethodBeat.i(217827);
    this.mIsRunInPlugin = true;
    this.mDexClassLoader = paramClassLoader;
    this.mProxyActivity = paramActivity;
    this.mPluginName = paramString1;
    this.mApkFilePath = paramString2;
    this.mPackageInfo = paramPackageInfo;
    this.mContext = new APPluginContext(paramActivity, 0, this.mApkFilePath, this.mDexClassLoader);
    attachBaseContext(this.mContext);
    AppMethodBeat.o(217827);
  }
  
  public boolean IIsWrapContent()
  {
    return true;
  }
  
  public void IOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217793);
    onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(217793);
  }
  
  public void IOnConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(217935);
    onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(217935);
  }
  
  public void IOnCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217532);
    onCreate(paramBundle);
    AppMethodBeat.o(217532);
  }
  
  public boolean IOnCreateOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(217908);
    boolean bool = onCreateOptionsMenu(paramMenu);
    AppMethodBeat.o(217908);
    return bool;
  }
  
  public void IOnDestroy()
  {
    AppMethodBeat.i(217612);
    onDestroy();
    AppMethodBeat.o(217612);
  }
  
  public boolean IOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217667);
    boolean bool = onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(217667);
    return bool;
  }
  
  public boolean IOnKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217678);
    boolean bool = onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(217678);
    return bool;
  }
  
  public boolean IOnKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217673);
    boolean bool = onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(217673);
    return bool;
  }
  
  public boolean IOnMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(217930);
    boolean bool = onMenuItemSelected(paramInt, paramMenuItem);
    AppMethodBeat.o(217930);
    return bool;
  }
  
  public void IOnNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(217542);
    onNewIntent(paramIntent);
    AppMethodBeat.o(217542);
  }
  
  public boolean IOnOptionsItemSelected(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(217914);
    boolean bool = onOptionsItemSelected(paramMenuItem);
    AppMethodBeat.o(217914);
    return bool;
  }
  
  public void IOnPause()
  {
    AppMethodBeat.i(217585);
    onPause();
    AppMethodBeat.o(217585);
  }
  
  public boolean IOnPrepareOptionsMenu(Menu paramMenu)
  {
    AppMethodBeat.i(217913);
    boolean bool = onPrepareOptionsMenu(paramMenu);
    AppMethodBeat.o(217913);
    return bool;
  }
  
  public void IOnRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217821);
    onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(217821);
  }
  
  public void IOnRestart()
  {
    AppMethodBeat.i(217621);
    onRestart();
    AppMethodBeat.o(217621);
  }
  
  public void IOnRestoreInstanceState(Bundle paramBundle) {}
  
  public void IOnResume()
  {
    AppMethodBeat.i(217572);
    onResume();
    AppMethodBeat.o(217572);
  }
  
  public void IOnSaveInstanceState(Bundle paramBundle) {}
  
  public void IOnStart()
  {
    AppMethodBeat.i(217553);
    onStart();
    AppMethodBeat.o(217553);
  }
  
  public void IOnStop()
  {
    AppMethodBeat.i(217598);
    onStop();
    AppMethodBeat.o(217598);
  }
  
  public boolean IOnTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217917);
    boolean bool = onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217917);
    return bool;
  }
  
  public void IOnUserInteraction()
  {
    AppMethodBeat.i(217923);
    onUserInteraction();
    AppMethodBeat.o(217923);
  }
  
  public void IOnWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(217713);
    onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(217713);
  }
  
  public void IRequestPermissions(String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(217802);
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramArrayOfString);
    com.tencent.mm.hellhoundlib.a.a.b(this, locala.aYi(), "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    requestPermissions((String[])locala.sb(0), ((Integer)locala.sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/midas/plugin/APPluginActivity", "IRequestPermissions", "([Ljava/lang/String;I)V", "Undefined", "requestPermissions", "([Ljava/lang/String;I)V");
    APLog.i("APPluginActivity", "IRequestPermissions() permissions=" + paramArrayOfString + ", requestCode=" + paramInt);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217802);
      return;
    }
    super.requestPermissions(paramArrayOfString, paramInt);
    AppMethodBeat.o(217802);
  }
  
  public void ISetIntent(Intent paramIntent)
  {
    AppMethodBeat.i(217694);
    setIntent(paramIntent);
    AppMethodBeat.o(217694);
  }
  
  public void ISetOutHandler(Handler paramHandler) {}
  
  public View findViewById(int paramInt)
  {
    AppMethodBeat.i(217649);
    if ((this.mIsRunInPlugin) && (this.mProxyContentView != null))
    {
      View localView2 = this.mProxyContentView.findViewById(paramInt);
      localView1 = localView2;
      if (localView2 == null) {
        localView1 = super.findViewById(paramInt);
      }
      AppMethodBeat.o(217649);
      return localView1;
    }
    View localView1 = super.findViewById(paramInt);
    AppMethodBeat.o(217649);
    return localView1;
  }
  
  public void finish()
  {
    AppMethodBeat.i(217766);
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
        AppMethodBeat.o(217766);
      }
      this.mProxyActivity.setResult(i, (Intent)localObject1);
      this.mProxyActivity.finish();
      this.mFinished = true;
      AppMethodBeat.o(217766);
      return;
    }
    super.finish();
    AppMethodBeat.o(217766);
  }
  
  public Context getApplicationContext()
  {
    AppMethodBeat.i(217758);
    APLog.i("APPluginActivity", "APPluginActivity getApplicationContext mProxyActivity:" + this.mProxyActivity);
    if (this.mIsRunInPlugin)
    {
      localContext = this.mProxyActivity.getApplicationContext();
      AppMethodBeat.o(217758);
      return localContext;
    }
    Context localContext = super.getApplicationContext();
    AppMethodBeat.o(217758);
    return localContext;
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    AppMethodBeat.i(217898);
    if (this.mIsRunInPlugin)
    {
      localApplicationInfo = this.mPackageInfo.applicationInfo;
      AppMethodBeat.o(217898);
      return localApplicationInfo;
    }
    ApplicationInfo localApplicationInfo = super.getApplicationInfo();
    AppMethodBeat.o(217898);
    return localApplicationInfo;
  }
  
  public int getChangingConfigurations()
  {
    AppMethodBeat.i(217872);
    if (this.mIsRunInPlugin)
    {
      i = this.mProxyActivity.getChangingConfigurations();
      AppMethodBeat.o(217872);
      return i;
    }
    int i = super.getChangingConfigurations();
    AppMethodBeat.o(217872);
    return i;
  }
  
  public Resources getHostResources()
  {
    AppMethodBeat.i(217902);
    Resources localResources = this.mProxyActivity.getResources();
    AppMethodBeat.o(217902);
    return localResources;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    AppMethodBeat.i(217832);
    if (this.mContext != null)
    {
      localLayoutInflater = LayoutInflater.from(this.mContext);
      AppMethodBeat.o(217832);
      return localLayoutInflater;
    }
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.mActivity);
    AppMethodBeat.o(217832);
    return localLayoutInflater;
  }
  
  public Activity getOutActivity()
  {
    return this.mProxyActivity;
  }
  
  public Resources getOutResources()
  {
    AppMethodBeat.i(217851);
    if (this.mIsRunInPlugin == true)
    {
      localResources = this.mProxyActivity.getResources();
      AppMethodBeat.o(217851);
      return localResources;
    }
    Resources localResources = this.mActivity.getResources();
    AppMethodBeat.o(217851);
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
    AppMethodBeat.i(217892);
    if (this.mIsRunInPlugin)
    {
      str = this.mPackageInfo.packageName;
      AppMethodBeat.o(217892);
      return str;
    }
    String str = super.getPackageName();
    AppMethodBeat.o(217892);
    return str;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(217862);
    if (("window".equals(paramString)) || ("search".equals(paramString)))
    {
      if (this.mIsRunInPlugin)
      {
        paramString = this.mProxyActivity.getSystemService(paramString);
        AppMethodBeat.o(217862);
        return paramString;
      }
      paramString = super.getSystemService(paramString);
      AppMethodBeat.o(217862);
      return paramString;
    }
    if (this.mContext != null)
    {
      paramString = this.mContext.getSystemService(paramString);
      AppMethodBeat.o(217862);
      return paramString;
    }
    paramString = super.getSystemService(paramString);
    AppMethodBeat.o(217862);
    return paramString;
  }
  
  public Window getWindow()
  {
    AppMethodBeat.i(217876);
    if (this.mIsRunInPlugin)
    {
      localWindow = this.mProxyActivity.getWindow();
      AppMethodBeat.o(217876);
      return localWindow;
    }
    Window localWindow = super.getWindow();
    AppMethodBeat.o(217876);
    return localWindow;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(217868);
    if (this.mIsRunInPlugin)
    {
      localWindowManager = this.mProxyActivity.getWindowManager();
      AppMethodBeat.o(217868);
      return localWindowManager;
    }
    WindowManager localWindowManager = super.getWindowManager();
    AppMethodBeat.o(217868);
    return localWindowManager;
  }
  
  public boolean isFinishing()
  {
    AppMethodBeat.i(217777);
    if (this.mIsRunInPlugin)
    {
      bool = this.mFinished;
      AppMethodBeat.o(217777);
      return bool;
    }
    boolean bool = super.isFinishing();
    AppMethodBeat.o(217777);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(217784);
    APLog.i("APPluginActivity", "APPluginActivity onActivityResult");
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217784);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(217784);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217526);
    if (this.mIsRunInPlugin)
    {
      this.mActivity = this.mProxyActivity;
      APPluginStatic.add(this);
      AppMethodBeat.o(217526);
      return;
    }
    super.onCreate(paramBundle);
    this.mActivity = this;
    AppMethodBeat.o(217526);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(217605);
    APLog.i("APPluginActivity", "onDestroy mIsRunInPlugin:" + this.mIsRunInPlugin);
    if (this.mIsRunInPlugin)
    {
      this.mDexClassLoader = null;
      APPluginStatic.remove(this);
      AppMethodBeat.o(217605);
      return;
    }
    super.onDestroy();
    AppMethodBeat.o(217605);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217718);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217718);
      return false;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(217718);
    return bool;
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217734);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217734);
      return false;
    }
    boolean bool = super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
    AppMethodBeat.o(217734);
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(217727);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217727);
      return false;
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(217727);
    return bool;
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217579);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217579);
      return;
    }
    super.onPause();
    AppMethodBeat.o(217579);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(217812);
    APLog.i("APPluginActivity", "onRequestPermissionsResult() requestCode=".concat(String.valueOf(paramInt)));
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217812);
      return;
    }
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(217812);
  }
  
  protected void onRestart()
  {
    AppMethodBeat.i(217616);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217616);
      return;
    }
    super.onRestart();
    AppMethodBeat.o(217616);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(217565);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217565);
      return;
    }
    super.onResume();
    AppMethodBeat.o(217565);
  }
  
  protected void onStart()
  {
    AppMethodBeat.i(217549);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217549);
      return;
    }
    super.onStart();
    AppMethodBeat.o(217549);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(217591);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217591);
      return;
    }
    super.onStop();
    AppMethodBeat.o(217591);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(217750);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217750);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(217750);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(217705);
    AppMethodBeat.at(this, paramBoolean);
    if (this.mIsRunInPlugin)
    {
      AppMethodBeat.o(217705);
      return;
    }
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.o(217705);
  }
  
  public void openOptionsMenu()
  {
    AppMethodBeat.i(217741);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.openOptionsMenu();
      AppMethodBeat.o(217741);
      return;
    }
    super.openOptionsMenu();
    AppMethodBeat.o(217741);
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217848);
    if (this.mIsRunInPlugin)
    {
      this.mActivity.overridePendingTransition(paramInt1, paramInt2);
      AppMethodBeat.o(217848);
      return;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(217848);
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(217634);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = LayoutInflater.from(this).inflate(paramInt, null);
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(217634);
      return;
    }
    super.setContentView(paramInt);
    AppMethodBeat.o(217634);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(217639);
    if (this.mIsRunInPlugin)
    {
      this.mProxyContentView = paramView;
      this.mActivity.setContentView(this.mProxyContentView);
      AppMethodBeat.o(217639);
      return;
    }
    super.setContentView(paramView);
    AppMethodBeat.o(217639);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(217887);
    super.setRequestedOrientation(paramInt);
    AppMethodBeat.o(217887);
  }
  
  public void setTheme(int paramInt)
  {
    AppMethodBeat.i(217881);
    if (this.mIsRunInPlugin)
    {
      this.mProxyActivity.setTheme(paramInt);
      AppMethodBeat.o(217881);
      return;
    }
    super.setTheme(paramInt);
    AppMethodBeat.o(217881);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    boolean bool = false;
    AppMethodBeat.i(217659);
    if (this.mIsRunInPlugin)
    {
      if (paramIntent.hasExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY")) {}
      for (bool = paramIntent.getBooleanExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false); !bool; bool = true)
      {
        label34:
        com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/midas/plugin/APPluginActivity", "startActivityForResult", "(Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
        AppMethodBeat.o(217659);
        return;
        List localList = this.mActivity.getPackageManager().queryIntentActivities(paramIntent, 65536);
        if ((localList != null) && (localList.size() != 0)) {
          break label34;
        }
      }
      paramIntent.putExtra("pluginsdk_IsPluginActivity", true);
      com.tencent.mm.hellhoundlib.a.a.a(this.mActivity, c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/midas/plugin/APPluginActivity", "startActivityForResult", "(Landroid/content/Intent;I)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
      AppMethodBeat.o(217659);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(217659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.plugin.APPluginActivity
 * JD-Core Version:    0.7.0.1
 */