package com.tencent.mm.plugin.appbrand.report;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.aa;
import d.g.b.k;
import d.l;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReportProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasAddActivityLifecycleCallbacks", "", "reporters", "", "Landroid/support/v4/app/FragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "of", "activity", "onActivityCreated", "", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-appbrand-integration_release"})
public final class d
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean lRh;
  private static final Map<FragmentActivity, AppBrandLauncherDesktopReporter> lRi;
  public static final d lRj;
  
  static
  {
    AppMethodBeat.i(180644);
    lRj = new d();
    lRi = (Map)new LinkedHashMap();
    AppMethodBeat.o(180644);
  }
  
  public static AppBrandLauncherDesktopReporter b(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(180642);
    k.h(paramFragmentActivity, "activity");
    synchronized (lRi)
    {
      if (!lRh)
      {
        paramFragmentActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)lRj);
        lRh = true;
      }
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter2 = (AppBrandLauncherDesktopReporter)lRi.get(paramFragmentActivity);
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter1 = localAppBrandLauncherDesktopReporter2;
      if (localAppBrandLauncherDesktopReporter2 == null)
      {
        localAppBrandLauncherDesktopReporter1 = new AppBrandLauncherDesktopReporter();
        lRi.put(paramFragmentActivity, localAppBrandLauncherDesktopReporter1);
      }
      AppMethodBeat.o(180642);
      return localAppBrandLauncherDesktopReporter1;
    }
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    AppMethodBeat.i(180643);
    Map localMap2;
    synchronized (lRi)
    {
      localMap2 = lRi;
      if (localMap2 == null)
      {
        paramActivity = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(180643);
        throw paramActivity;
      }
    }
    aa.eS(localMap2).remove(paramActivity);
    AppMethodBeat.o(180643);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.d
 * JD-Core Version:    0.7.0.1
 */