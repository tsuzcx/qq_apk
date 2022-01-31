package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class AppBrandGuideUI$a
  implements Application.ActivityLifecycleCallbacks, f
{
  public boolean hcN = false;
  public String hcO;
  
  public static Application aoU()
  {
    return (Application)ae.getContext().getApplicationContext();
  }
  
  public final void aP(String paramString, int paramInt)
  {
    this.hcN = false;
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity instanceof AppBrandGuideUI)) {
      this.hcN = false;
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (((paramActivity instanceof AppBrandGuideUI)) || ((paramActivity instanceof AppBrandLauncherUI))) {
      this.hcN = false;
    }
    ActivityManager.RunningTaskInfo localRunningTaskInfo;
    int i;
    if ((g.DK()) && (this.hcN))
    {
      localRunningTaskInfo = bk.al(paramActivity, paramActivity.getTaskId());
      if ((localRunningTaskInfo != null) && (localRunningTaskInfo.baseActivity != null)) {
        break label78;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        this.hcN = false;
        paramActivity.startActivity(new Intent(paramActivity, AppBrandGuideUI.class));
      }
      return;
      label78:
      if ((!localRunningTaskInfo.baseActivity.getClassName().endsWith(".LauncherUI")) && (localRunningTaskInfo.baseActivity.getClassName().contains(".AppBrandUI"))) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI.a
 * JD-Core Version:    0.7.0.1
 */