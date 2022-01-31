package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

final class ToolsProfile$4
  implements Application.ActivityLifecycleCallbacks
{
  private Set<Activity> bZk;
  
  ToolsProfile$4(ToolsProfile paramToolsProfile)
  {
    AppMethodBeat.i(15409);
    this.bZk = new HashSet();
    AppMethodBeat.o(15409);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(15410);
    ToolsProfile.b(this.bZj);
    this.bZk.add(paramActivity);
    AppMethodBeat.o(15410);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(15411);
    ToolsProfile.c(this.bZj);
    ab.d(ToolsProfile.access$000(), "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.a(this.bZj)) });
    if (ToolsProfile.a(this.bZj) == 0)
    {
      ToolsProfile.a.access$200();
      boolean bool = WebView.getCanReboot();
      ab.i(ToolsProfile.access$000(), "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) && (!ToolsProfile.a.isLocked())) {
        Process.killProcess(Process.myPid());
      }
    }
    this.bZk.remove(paramActivity);
    AppMethodBeat.o(15411);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(15412);
    this.bZk.remove(paramActivity);
    ToolsProfile.a.access$300();
    AppMethodBeat.o(15412);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(15413);
    if (!this.bZk.contains(paramActivity)) {
      ToolsProfile.a.BI();
    }
    AppMethodBeat.o(15413);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.4
 * JD-Core Version:    0.7.0.1
 */