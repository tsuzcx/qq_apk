package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter;", "", "()V", "hadReportFirstUserLaunchAfterPreRender", "", "isCreatedByPreRenderLaunch", "lastVisibleHalfScreenStatus", "onPostInit", "", "initConfig", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "report", "key", "", "reportOnLaunch", "reportOnUpdateConfig", "newConfig", "forceRestartByLaunchModeChanged", "Companion", "plugin-appbrand-integration_release"})
public final class p
{
  public static final a nHL;
  public boolean nHI;
  public boolean nHJ;
  public boolean nHK;
  
  static
  {
    AppMethodBeat.i(229303);
    nHL = new a((byte)0);
    AppMethodBeat.o(229303);
  }
  
  public static void pl(int paramInt)
  {
    AppMethodBeat.i(229302);
    h.CyF.dN(1520, paramInt);
    Log.i("HalfScreenReporter", "[report] key=".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(229302);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/report/HalfScreenReporter$Companion;", "", "()V", "FULL_SCREEN_TO_HALF_SCREEN", "", "HALF_SCREEN_TO_FULL_SCREEN", "RESTART_FOR_LAUNCH_MODE_CHANGE", "STARTUP_COLD", "STARTUP_COLD_USER_ACTION", "STARTUP_HOT", "STARTUP_HOT_USER_ACTION", "STARTUP_HOT_USER_ACTION_RUNTIME_CREATED_BY_PRE_RENDER", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE", "STARTUP_HOT_USER_ACTION_UNIQUE_FOR_PER_INSTANCE_RUNTIME_CREATED_BY_PRE_RENDER", "KEY", "plugin-appbrand-integration_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.p
 * JD-Core Version:    0.7.0.1
 */