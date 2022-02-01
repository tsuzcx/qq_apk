package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

final class ToolsProfile$2
  implements Application.ActivityLifecycleCallbacks
{
  private Set<Activity> cWi;
  
  ToolsProfile$2(ToolsProfile paramToolsProfile)
  {
    AppMethodBeat.i(186309);
    this.cWi = new HashSet();
    AppMethodBeat.o(186309);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(186310);
    ToolsProfile.a(this.cWh);
    this.cWi.add(paramActivity);
    AppMethodBeat.o(186310);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(186311);
    ToolsProfile.b(this.cWh);
    ae.d(ToolsProfile.access$100(), "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.c(this.cWh)) });
    if (ToolsProfile.c(this.cWh) == 0)
    {
      ToolsProfile.a.access$200();
      boolean bool = WebView.getCanReboot();
      ae.i(ToolsProfile.access$100(), "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) && (!ToolsProfile.a.isLocked()))
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    this.cWi.remove(paramActivity);
    AppMethodBeat.o(186311);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(186312);
    this.cWi.remove(paramActivity);
    ToolsProfile.a.access$300();
    AppMethodBeat.o(186312);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(186313);
    if (!this.cWi.contains(paramActivity)) {
      ToolsProfile.a.MF();
    }
    AppMethodBeat.o(186313);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.2
 * JD-Core Version:    0.7.0.1
 */