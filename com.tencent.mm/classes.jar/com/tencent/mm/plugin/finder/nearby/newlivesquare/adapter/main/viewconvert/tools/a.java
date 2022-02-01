package com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI15;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/adapter/main/viewconvert/tools/SampleLifecycleCallbacks;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "isTargetActivity", "", "activity", "Landroid/app/Activity;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
  implements Application.ActivityLifecycleCallbacks
{
  public static boolean aH(Activity paramActivity)
  {
    AppMethodBeat.i(340484);
    s.u(paramActivity, "activity");
    boolean bool = paramActivity instanceof OccupyFinderUI15;
    AppMethodBeat.o(340484);
    return bool;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(340493);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340493);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(340532);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340532);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(340511);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340511);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(340508);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340508);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(340523);
    s.u(paramActivity, "activity");
    s.u(paramBundle, "outState");
    AppMethodBeat.o(340523);
  }
  
  public void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(340497);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340497);
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(340515);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(340515);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.adapter.main.viewconvert.tools.a
 * JD-Core Version:    0.7.0.1
 */