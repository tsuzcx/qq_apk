package com.tencent.mm.plugin.appbrand.report;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReportProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasAddActivityLifecycleCallbacks", "", "reporters", "", "Landroidx/fragment/app/FragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "of", "activity", "onActivityCreated", "", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements Application.ActivityLifecycleCallbacks
{
  public static final f tNH;
  private static boolean tNI;
  private static final Map<FragmentActivity, AppBrandLauncherDesktopReporter> tNJ;
  
  static
  {
    AppMethodBeat.i(180644);
    tNH = new f();
    tNJ = (Map)new LinkedHashMap();
    AppMethodBeat.o(180644);
  }
  
  public final AppBrandLauncherDesktopReporter a(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(321365);
    s.u(paramFragmentActivity, "activity");
    synchronized (tNJ)
    {
      if (!tNI)
      {
        paramFragmentActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
        tNI = true;
      }
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter2 = (AppBrandLauncherDesktopReporter)tNJ.get(paramFragmentActivity);
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter1 = localAppBrandLauncherDesktopReporter2;
      if (localAppBrandLauncherDesktopReporter2 == null)
      {
        localAppBrandLauncherDesktopReporter1 = new AppBrandLauncherDesktopReporter();
        tNJ.put(paramFragmentActivity, localAppBrandLauncherDesktopReporter1);
      }
      AppMethodBeat.o(321365);
      return localAppBrandLauncherDesktopReporter1;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(321388);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(321388);
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(180643);
    s.u(paramActivity, "activity");
    Map localMap2;
    synchronized (tNJ)
    {
      localMap2 = tNJ;
      if (localMap2 == null)
      {
        paramActivity = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(180643);
        throw paramActivity;
      }
    }
    an.hJ(localMap2).remove(paramActivity);
    AppMethodBeat.o(180643);
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    AppMethodBeat.i(321367);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(321367);
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    AppMethodBeat.i(321371);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(321371);
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    AppMethodBeat.i(321381);
    s.u(paramActivity, "activity");
    s.u(paramBundle, "outState");
    AppMethodBeat.o(321381);
  }
  
  public final void onActivityStarted(Activity paramActivity)
  {
    AppMethodBeat.i(321376);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(321376);
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    AppMethodBeat.i(321385);
    s.u(paramActivity, "activity");
    AppMethodBeat.o(321385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */