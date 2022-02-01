package mqq.app;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import com.tencent.mobileqq.utils.FileProvider7Helper;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.permission.PermissionManager;
import mqq.util.WeakReference;

@TargetApi(16)
public class AppActivity
  extends BasePadActivity
{
  protected static int sResumeCount = 0;
  private boolean mIsFinishingInOnCreate = false;
  private boolean mIsResultWaiting;
  protected boolean mIsResume = false;
  private boolean mIsSplashing = false;
  private boolean mIsStartSkipped = false;
  private Intent mNewIntent;
  private Bundle mOnCreateBundle = null;
  private Bundle mOnRestoreBundle;
  private Bundle mPostCreateBundle = null;
  private int mRequestCode;
  private int mResultCode;
  private Intent mResultData;
  protected AppRuntime mRuntime = null;
  private int mWindowFocusState = -1;
  public PermissionManager permissionManager = PermissionManager.init(this);
  
  @Deprecated
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doDispatchKeyEvent(paramKeyEvent);
  }
  
  protected boolean doDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void doOnBackPressed()
  {
    try
    {
      super.onBackPressed();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("qqBaseActivity", 2, "", localThrowable);
    }
  }
  
  protected void doOnConfigurationChanged(Configuration paramConfiguration) {}
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    MobileQQ.sMobileQQ.appActivities.add(new WeakReference(this));
    this.mOnCreateBundle = null;
    this.mRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if ((this.mRuntime != null) && (getClass().getName().endsWith("SplashActivity"))) {
      this.mRuntime.onRunningForeground();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    MobileQQ.sMobileQQ.appActivities.remove(new WeakReference(this));
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnNewIntent(Intent paramIntent) {}
  
  protected void doOnPause() {}
  
  protected void doOnPostCreate(Bundle paramBundle)
  {
    this.mPostCreateBundle = null;
  }
  
  protected void doOnPostResume() {}
  
  protected void doOnRestoreInstanceState(Bundle paramBundle) {}
  
  protected void doOnResume() {}
  
  protected void doOnSaveInstanceState(Bundle paramBundle) {}
  
  protected void doOnStart() {}
  
  protected void doOnStop() {}
  
  protected void doOnUserLeaveHint() {}
  
  protected void doOnWindowFocusChanged(boolean paramBoolean) {}
  
  public final AppRuntime getAppRuntime()
  {
    return this.mRuntime;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  public final boolean isResume()
  {
    return this.mIsResume;
  }
  
  protected void onAccountChanged() {}
  
  protected void onAccoutChangeFailed() {}
  
  @Deprecated
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.e("appap", "onActivityResultrequestCode" + paramInt1 + "resultCode" + paramInt2 + "data" + paramIntent);
    if (!this.mIsSplashing) {
      doOnActivityResult(paramInt1, paramInt2, paramIntent);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      Log.e("appap", "onActivityResult222222222");
      this.mIsResultWaiting = true;
      this.mRequestCode = paramInt1;
      this.mResultCode = paramInt2;
      this.mResultData = paramIntent;
    }
  }
  
  @Deprecated
  public void onBackPressed()
  {
    if (this.mIsSplashing) {
      return;
    }
    doOnBackPressed();
  }
  
  @Deprecated
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (!this.mIsSplashing) {
      doOnConfigurationChanged(paramConfiguration);
    }
    super.onConfigurationChanged(paramConfiguration);
  }
  
  @Deprecated
  protected void onCreate(Bundle paramBundle)
  {
    Intent localIntent = getIntent();
    requestWindowFeature(localIntent);
    this.mIsSplashing = MobileQQ.sMobileQQ.onActivityCreate(this, localIntent);
    super.onCreate(paramBundle);
    if (this.mIsSplashing)
    {
      this.mOnCreateBundle = paramBundle;
      return;
    }
    doOnCreate(paramBundle);
  }
  
  @Deprecated
  protected void onDestroy()
  {
    if ((!this.mIsSplashing) || (this.mIsFinishingInOnCreate)) {
      doOnDestroy();
    }
    super.onDestroy();
  }
  
  @Deprecated
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.mIsSplashing) {
      return false;
    }
    return doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onLogout(Constants.LogoutReason paramLogoutReason)
  {
    finish();
  }
  
  @Deprecated
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (!this.mIsSplashing)
    {
      doOnNewIntent(paramIntent);
      return;
    }
    this.mNewIntent = paramIntent;
  }
  
  @Deprecated
  protected void onPause()
  {
    if (!this.mIsSplashing) {
      doOnPause();
    }
    int i = sResumeCount - 1;
    sResumeCount = i;
    if ((i <= 0) && (this.mRuntime != null)) {
      this.mRuntime.isBackground_Pause = true;
    }
    this.mIsResume = false;
    super.onPause();
  }
  
  @Deprecated
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnPostCreate(paramBundle);
      return;
    }
    this.mPostCreateBundle = paramBundle;
  }
  
  @Deprecated
  protected void onPostResume()
  {
    super.onPostResume();
    if (!this.mIsSplashing) {
      doOnPostResume();
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.permissionManager.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  @Deprecated
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (!this.mIsSplashing)
    {
      doOnRestoreInstanceState(paramBundle);
      return;
    }
    this.mOnRestoreBundle = paramBundle;
  }
  
  @Deprecated
  protected void onResume()
  {
    super.onResume();
    this.mIsResume = true;
    int i = sResumeCount + 1;
    sResumeCount = i;
    if ((i > 0) && (this.mRuntime != null)) {
      this.mRuntime.isBackground_Pause = false;
    }
    if (!this.mIsSplashing) {
      doOnResume();
    }
  }
  
  @Deprecated
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (!this.mIsSplashing) {
      doOnSaveInstanceState(paramBundle);
    }
  }
  
  @Deprecated
  protected void onStart()
  {
    super.onStart();
    ApplicationLifeController.getController().getVisibleActivityCount();
    ApplicationLifeController.getController().onActivityStart(this);
    try
    {
      if ((this.mRuntime != null) && (getClass().getName().endsWith("SplashActivity")))
      {
        if (this.mRuntime.getApplication() != null) {
          this.mRuntime.getApplication().delStateFile();
        }
        this.mRuntime.onRunningForeground();
      }
    }
    catch (Exception localException)
    {
      label67:
      break label67;
    }
    if (!this.mIsSplashing)
    {
      doOnStart();
      return;
    }
    this.mIsStartSkipped = true;
  }
  
  @Deprecated
  protected void onStop()
  {
    ApplicationLifeController.getController().onActivityStop(this);
    ApplicationLifeController.getController().getVisibleActivityCount();
    if ((this.mRuntime != null) && (getClass().getName().endsWith("SplashActivity")))
    {
      this.mRuntime.saveLastAccountState();
      this.mRuntime.onRunningBackground(null);
    }
    if (!this.mIsSplashing) {
      doOnStop();
    }
    for (;;)
    {
      super.onStop();
      return;
      this.mIsStartSkipped = false;
    }
  }
  
  @Deprecated
  protected void onUserLeaveHint()
  {
    if (!this.mIsSplashing) {
      doOnUserLeaveHint();
    }
    super.onUserLeaveHint();
  }
  
  @Deprecated
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    MobileQQ.sMobileQQ.onActivityFocusChanged(this, paramBoolean);
    super.onWindowFocusChanged(paramBoolean);
    if (!this.mIsSplashing)
    {
      doOnWindowFocusChanged(paramBoolean);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.mWindowFocusState = i;
      return;
    }
  }
  
  public boolean preloadData(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    return false;
  }
  
  public void preloadUi() {}
  
  public void realOnCreate()
  {
    boolean bool = true;
    if (this.mIsSplashing)
    {
      this.mIsSplashing = false;
      Log.e("appap", "realOnCreaterealOnCreate");
      if ((!doOnCreate(this.mOnCreateBundle)) || (isFinishing())) {
        break label233;
      }
      if (this.mIsStartSkipped)
      {
        doOnStart();
        this.mIsStartSkipped = false;
        if (this.mOnRestoreBundle != null)
        {
          doOnRestoreInstanceState(this.mOnRestoreBundle);
          this.mOnRestoreBundle = null;
        }
        doOnPostCreate(this.mPostCreateBundle);
        if (this.mIsResultWaiting)
        {
          Log.e("appap", "realOnCreatemIsResultWaitingrequestCode" + this.mRequestCode + "resultCode" + this.mResultCode + "data" + this.mResultData);
          doOnActivityResult(this.mRequestCode, this.mResultCode, this.mResultData);
          this.mIsResultWaiting = false;
          this.mResultData = null;
        }
        if (this.mNewIntent != null)
        {
          doOnNewIntent(this.mNewIntent);
          this.mNewIntent = null;
        }
        if (isResume())
        {
          doOnResume();
          doOnPostResume();
        }
        if (this.mWindowFocusState != -1)
        {
          if (this.mWindowFocusState != 1) {
            break label228;
          }
          doOnWindowFocusChanged(bool);
        }
      }
    }
    label228:
    label233:
    while (!isFinishing()) {
      for (;;)
      {
        return;
        bool = false;
      }
    }
    this.mIsSplashing = true;
    this.mIsFinishingInOnCreate = true;
  }
  
  protected void requestWindowFeature(Intent paramIntent) {}
  
  void setAppRuntime(AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public boolean showPreview()
  {
    return false;
  }
  
  public void superFinish()
  {
    super.finish();
  }
  
  public final void superStartActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    FileProvider7Helper.intentCompatForN(getApplicationContext(), paramIntent);
    if (Build.VERSION.SDK_INT >= 16)
    {
      super.startActivityForResult(paramIntent, -1, paramBundle);
      return;
    }
    super.startActivityForResult(paramIntent, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.AppActivity
 * JD-Core Version:    0.7.0.1
 */