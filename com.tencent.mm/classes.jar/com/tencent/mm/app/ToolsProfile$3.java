package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

final class ToolsProfile$3
  implements Application.ActivityLifecycleCallbacks
{
  private int bxj = 0;
  private Set<Activity> bxk = new HashSet();
  
  ToolsProfile$3(ToolsProfile paramToolsProfile) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    this.bxj += 1;
    this.bxk.add(paramActivity);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    this.bxj -= 1;
    y.d(ToolsProfile.access$000(), "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(this.bxj) });
    if (this.bxj == 0)
    {
      ToolsProfile.a.te();
      boolean bool = WebView.getCanReboot();
      y.i(ToolsProfile.access$000(), "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        Process.killProcess(Process.myPid());
      }
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    this.bxk.remove(paramActivity);
    ToolsProfile.a.access$100();
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (!this.bxk.contains(paramActivity)) {
      ToolsProfile.a.tf();
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.3
 * JD-Core Version:    0.7.0.1
 */