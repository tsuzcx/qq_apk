package com.tencent.mm.app;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;

final class ToolsProfile$2
  implements Application.ActivityLifecycleCallbacks
{
  private Set<Activity> dmF;
  
  ToolsProfile$2(ToolsProfile paramToolsProfile)
  {
    AppMethodBeat.i(231394);
    this.dmF = new HashSet();
    AppMethodBeat.o(231394);
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(231395);
    ToolsProfile.a(this.dmE);
    this.dmF.add(paramActivity);
    AppMethodBeat.o(231395);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(231396);
    ToolsProfile.b(this.dmE);
    Log.d(ToolsProfile.access$100(), "onActivityDestroyed, after destroy, activityInstanceNum = %d", new Object[] { Integer.valueOf(ToolsProfile.c(this.dmE)) });
    if (ToolsProfile.c(this.dmE) == 0)
    {
      ToolsProfile.a.access$200();
      boolean bool = WebView.getCanReboot();
      Log.i(ToolsProfile.access$100(), "onActivityDestroyed, xwebCanReboot = %b", new Object[] { Boolean.valueOf(bool) });
      if ((bool) && (!ToolsProfile.a.isLocked()))
      {
        com.tencent.mm.hellhoundlib.b.a locala = c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
        Process.killProcess(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/app/ToolsProfile$2", "onActivityDestroyed", "(Landroid/app/Activity;)V", "android/os/Process_EXEC_", "killProcess", "(I)V");
      }
    }
    this.dmF.remove(paramActivity);
    AppMethodBeat.o(231396);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(231397);
    this.dmF.remove(paramActivity);
    ToolsProfile.a.access$300();
    AppMethodBeat.o(231397);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(231398);
    if (!this.dmF.contains(paramActivity)) {
      ToolsProfile.a.Wz();
    }
    AppMethodBeat.o(231398);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.ToolsProfile.2
 * JD-Core Version:    0.7.0.1
 */