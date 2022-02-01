package com.tencent.mm.plugin.appbrand.report;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReportProvider;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "hasAddActivityLifecycleCallbacks", "", "reporters", "", "Landroid/support/v4/app/FragmentActivity;", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "of", "activity", "onActivityCreated", "", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "plugin-appbrand-integration_release"})
public final class f
  implements Application.ActivityLifecycleCallbacks
{
  private static boolean nGT;
  private static final Map<FragmentActivity, AppBrandLauncherDesktopReporter> nGU;
  public static final f nGV;
  
  static
  {
    AppMethodBeat.i(180644);
    nGV = new f();
    nGU = (Map)new LinkedHashMap();
    AppMethodBeat.o(180644);
  }
  
  public static AppBrandLauncherDesktopReporter b(FragmentActivity paramFragmentActivity)
  {
    AppMethodBeat.i(180642);
    p.h(paramFragmentActivity, "activity");
    synchronized (nGU)
    {
      if (!nGT)
      {
        paramFragmentActivity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)nGV);
        nGT = true;
      }
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter2 = (AppBrandLauncherDesktopReporter)nGU.get(paramFragmentActivity);
      AppBrandLauncherDesktopReporter localAppBrandLauncherDesktopReporter1 = localAppBrandLauncherDesktopReporter2;
      if (localAppBrandLauncherDesktopReporter2 == null)
      {
        localAppBrandLauncherDesktopReporter1 = new AppBrandLauncherDesktopReporter();
        nGU.put(paramFragmentActivity, localAppBrandLauncherDesktopReporter1);
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
    synchronized (nGU)
    {
      localMap2 = nGU;
      if (localMap2 == null)
      {
        paramActivity = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(180643);
        throw paramActivity;
      }
    }
    af.fd(localMap2).remove(paramActivity);
    AppMethodBeat.o(180643);
  }
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity) {}
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.f
 * JD-Core Version:    0.7.0.1
 */