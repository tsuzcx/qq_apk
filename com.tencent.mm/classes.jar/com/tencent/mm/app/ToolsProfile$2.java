package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

final class ToolsProfile$2
  implements Application.ActivityLifecycleCallbacks
{
  private Set<Activity> ckH;
  
  ToolsProfile$2(ToolsProfile paramToolsProfile)
  {
    AppMethodBeat.i(210111);
    this.ckH = new HashSet();
    AppMethodBeat.o(210111);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(210112);
    ToolsProfile.a(this.cJX);
    this.ckH.add(paramActivity);
    AppMethodBeat.o(210112);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(210113);
    ToolsProfile.b(this.cJX);
    ac.d(ToolsProfile.access$100(), "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.c(this.cJX)) });
    if (ToolsProfile.c(this.cJX) == 0)
    {
      ToolsProfile.a.access$200();
      boolean bool = WebView.getCanReboot();
      ac.i(ToolsProfile.access$100(), "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) && (!ToolsProfile.a.isLocked())) {
        Process.killProcess(Process.myPid());
      }
    }
    this.ckH.remove(paramActivity);
    AppMethodBeat.o(210113);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(210114);
    this.ckH.remove(paramActivity);
    ToolsProfile.a.access$300();
    AppMethodBeat.o(210114);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(210115);
    if (!this.ckH.contains(paramActivity)) {
      ToolsProfile.a.Lc();
    }
    AppMethodBeat.o(210115);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.2
 * JD-Core Version:    0.7.0.1
 */