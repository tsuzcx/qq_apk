package com.tencent.mm.plugin.appbrand.report;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.ae;
import d.g.b.p;
import d.l;
import d.v;
import java.util.LinkedHashMap;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReportProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasAddActivityLifecycleCallbacks", "", "reporters", "", "Landroid/support/v4/app/FragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "of", "activity", "onActivityCreated", "", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-appbrand-integration_release"})
public final class e
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean mvV;
  private static final Map<FragmentActivity, AppBrandLauncherDesktopReporter> mvW;
  public static final e mvX;
  
  static
  {
    AppMethodBeat.i(180644);
    mvX = new e();
    mvW = (Map)new LinkedHashMap();
    AppMethodBeat.o(180644);
  }
  
  public static AppBrandLauncherDesktopReporter b(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(180642);
    p.h(paramFragmentActivity, "activity");
    synchronized (mvW)
    {
      if (!mvV)
      {
        paramFragmentActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)mvX);
        mvV = true;
      }
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter2 = (AppBrandLauncherDesktopReporter)mvW.get(paramFragmentActivity);
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter1 = localAppBrandLauncherDesktopReporter2;
      if (localAppBrandLauncherDesktopReporter2 == null)
      {
        localAppBrandLauncherDesktopReporter1 = new AppBrandLauncherDesktopReporter();
        mvW.put(paramFragmentActivity, localAppBrandLauncherDesktopReporter1);
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
    synchronized (mvW)
    {
      localMap2 = mvW;
      if (localMap2 == null)
      {
        paramActivity = new v("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(180643);
        throw paramActivity;
      }
    }
    ae.eY(localMap2).remove(paramActivity);
    AppMethodBeat.o(180643);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.e
 * JD-Core Version:    0.7.0.1
 */