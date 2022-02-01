package com.tencent.mm.plugin.appbrand.report;

import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "enterUiTimestamp", "", "historyExposureItemIndexRecorder", "", "", "mSessionId", "onCreate", "", "onDestroy", "onResume", "onStop", "recordHistoryExposure", "indexStart", "indexEnd", "reportClickCollectionHeader", "reportClickEveryoneUsingHeader", "reportClickHistoryWxaItem", "appId", "", "listIndex", "reportClickLiveHeader", "showcaseType", "reportClickNearbyHeader", "reportClickOrderHeader", "reportEnterAppBrandDesktop", "reportHistoryWxaExposure", "count", "reportLeaveAppBrandDesktop", "stayDuration", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherDesktopReporter
  implements k
{
  public static final AppBrandLauncherDesktopReporter.a qJj;
  public long mSessionId;
  private long qJh;
  public Set<Integer> qJi;
  
  static
  {
    AppMethodBeat.i(180650);
    qJj = new AppBrandLauncherDesktopReporter.a((byte)0);
    AppMethodBeat.o(180650);
  }
  
  public AppBrandLauncherDesktopReporter()
  {
    AppMethodBeat.i(180649);
    this.qJi = ((Set)new LinkedHashSet());
    AppMethodBeat.o(180649);
  }
  
  public final void chw()
  {
    AppMethodBeat.i(180645);
    h.IzE.a(19468, new Object[] { Integer.valueOf(2), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180645);
  }
  
  @t(jl=h.a.ON_CREATE)
  public final void onCreate()
  {
    AppMethodBeat.i(180646);
    this.mSessionId = System.currentTimeMillis();
    h.IzE.a(19468, new Object[] { Integer.valueOf(1), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180646);
  }
  
  @t(jl=h.a.ON_DESTROY)
  public final void onDestroy() {}
  
  @t(jl=h.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(180648);
    this.qJh = System.currentTimeMillis();
    AppMethodBeat.o(180648);
  }
  
  @t(jl=h.a.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(180647);
    long l1 = System.currentTimeMillis();
    long l2 = this.qJh;
    h.IzE.a(19468, new Object[] { Integer.valueOf(8), "", Long.valueOf(l1 - l2), "", "", Long.valueOf(this.mSessionId) });
    int i = this.qJi.size();
    h.IzE.a(19468, new Object[] { Integer.valueOf(7), "", "", "", "", Integer.valueOf(i), Long.valueOf(this.mSessionId) });
    this.qJi.clear();
    AppMethodBeat.o(180647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter
 * JD-Core Version:    0.7.0.1
 */