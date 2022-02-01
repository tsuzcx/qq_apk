package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter;", "", "()V", "hadReportFirstUserLaunchAfterPreRender", "", "isCreatedByPreRenderLaunch", "lastVisibleHalfScreenStatus", "onPostInit", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "report", "key", "", "reportOnLaunch", "reportOnUpdateConfig", "newConfig", "forceRestartByLaunchModeChanged", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
{
  public static final a tOA;
  public boolean tOB;
  public boolean tOC;
  public boolean tOD;
  
  static
  {
    AppMethodBeat.i(321514);
    tOA = new a((byte)0);
    AppMethodBeat.o(321514);
  }
  
  public static void rG(int paramInt)
  {
    AppMethodBeat.i(321511);
    h.OAn.kJ(1520, paramInt);
    Log.i("HalfScreenReporter", s.X("[report] key=", Integer.valueOf(paramInt)));
    AppMethodBeat.o(321511);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter$Companion;", "", "()V", "FULL_SCREEN_TO_HALF_SCREEN", "", "HALF_SCREEN_TO_FULL_SCREEN", "RESTART_FOR_LAUNCH_MODE_CHANGE", "STARTUP_COLD", "STARTUP_COLD_USER_ACTION", "STARTUP_HOT", "STARTUP_HOT_USER_ACTION", "STARTUP_HOT_USER_ACTION_RUNTIME_CREATED_BY_PRE_RENDER", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE_RUNTIME_CREATED_BY_PRE_RENDER", "KEY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.r
 * JD-Core Version:    0.7.0.1
 */