package com.tencent.mm.plugin.appbrand.report;

import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/AppBrandLauncherDesktopReporter;", "Landroidx/lifecycle/LifecycleObserver;", "()V", "enterUiTimestamp", "", "historyExposureItemIndexRecorder", "", "", "mSessionId", "onCreate", "", "onDestroy", "onResume", "onStop", "recordHistoryExposure", "indexStart", "indexEnd", "reportClickCollectionHeader", "reportClickEveryoneUsingHeader", "reportClickHistoryWxaItem", "appId", "", "listIndex", "reportClickLiveHeader", "showcaseType", "reportClickNearbyHeader", "reportClickOrderHeader", "reportEnterAppBrandDesktop", "reportHistoryWxaExposure", "count", "reportLeaveAppBrandDesktop", "stayDuration", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandLauncherDesktopReporter
  implements p
{
  public static final AppBrandLauncherDesktopReporter.a tNK;
  public long mSessionId;
  private long tNL;
  public Set<Integer> tNM;
  
  static
  {
    AppMethodBeat.i(180650);
    tNK = new AppBrandLauncherDesktopReporter.a((byte)0);
    AppMethodBeat.o(180650);
  }
  
  public AppBrandLauncherDesktopReporter()
  {
    AppMethodBeat.i(180649);
    this.tNM = ((Set)new LinkedHashSet());
    AppMethodBeat.o(180649);
  }
  
  public final void cIq()
  {
    AppMethodBeat.i(180645);
    h.OAn.b(19468, new Object[] { Integer.valueOf(2), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180645);
  }
  
  @z(Ho=j.a.ON_CREATE)
  public final void onCreate()
  {
    AppMethodBeat.i(180646);
    this.mSessionId = System.currentTimeMillis();
    h.OAn.b(19468, new Object[] { Integer.valueOf(1), "", "", "", "", "", Long.valueOf(this.mSessionId) });
    AppMethodBeat.o(180646);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public final void onDestroy() {}
  
  @z(Ho=j.a.ON_RESUME)
  public final void onResume()
  {
    AppMethodBeat.i(180648);
    this.tNL = System.currentTimeMillis();
    AppMethodBeat.o(180648);
  }
  
  @z(Ho=j.a.ON_STOP)
  public final void onStop()
  {
    AppMethodBeat.i(180647);
    long l1 = System.currentTimeMillis();
    long l2 = this.tNL;
    h.OAn.b(19468, new Object[] { Integer.valueOf(8), "", Long.valueOf(l1 - l2), "", "", Long.valueOf(this.mSessionId) });
    int i = this.tNM.size();
    h.OAn.b(19468, new Object[] { Integer.valueOf(7), "", "", "", "", Integer.valueOf(i), Long.valueOf(this.mSessionId) });
    this.tNM.clear();
    AppMethodBeat.o(180647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.AppBrandLauncherDesktopReporter
 * JD-Core Version:    0.7.0.1
 */