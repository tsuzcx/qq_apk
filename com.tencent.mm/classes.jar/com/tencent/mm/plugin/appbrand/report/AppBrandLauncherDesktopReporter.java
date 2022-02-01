package com.tencent.mm.plugin.appbrand.report;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import d.l;
import java.util.LinkedHashSet;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "enterUiTimestamp", "", "historyExposureItemIndexRecorder", "", "", "mSessionId", "onCreate", "", "onDestroy", "onResume", "onStop", "recordHistoryExposure", "indexStart", "indexEnd", "reportClickCollectionHeader", "reportClickEveryoneUsingHeader", "reportClickHistoryWxaItem", "appId", "", "listIndex", "reportClickLiveHeader", "showcaseType", "reportClickNearbyHeader", "reportClickOrderHeader", "reportEnterAppBrandDesktop", "reportHistoryWxaExposure", "count", "reportLeaveAppBrandDesktop", "stayDuration", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherDesktopReporter
  implements LifecycleObserver
{
  public static final AppBrandLauncherDesktopReporter.a mwa;
  public long mSessionId;
  private long mvY;
  public Set<Integer> mvZ;
  
  static
  {
    AppMethodBeat.i(180650);
    mwa = new AppBrandLauncherDesktopReporter.a((byte)0);
    AppMethodBeat.o(180650);
  }
  
  public AppBrandLauncherDesktopReporter()
  {
    AppMethodBeat.i(180649);
    this.mvZ = ((Set)new LinkedHashSet());
    AppMethodBeat.o(180649);
  }
  
  public final void bya()
  {
    AppMethodBeat.i(180645);
    g.yxI.f(19468, new Object[] { Integer.valueOf(2), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180645);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  public final void onCreate()
  {
    AppMethodBeat.i(180646);
    this.mSessionId = System.currentTimeMillis();
    g.yxI.f(19468, new Object[] { Integer.valueOf(1), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180646);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public final void onDestroy() {}
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(180648);
    this.mvY = System.currentTimeMillis();
    AppMethodBeat.o(180648);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(180647);
    long l1 = System.currentTimeMillis();
    long l2 = this.mvY;
    g.yxI.f(19468, new Object[] { Integer.valueOf(8), "", Long.valueOf(l1 - l2), "", "", Long.valueOf(this.mSessionId) });
    int i = this.mvZ.size();
    g.yxI.f(19468, new Object[] { Integer.valueOf(7), "", "", "", "", Integer.valueOf(i), Long.valueOf(this.mSessionId) });
    this.mvZ.clear();
    AppMethodBeat.o(180647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter
 * JD-Core Version:    0.7.0.1
 */