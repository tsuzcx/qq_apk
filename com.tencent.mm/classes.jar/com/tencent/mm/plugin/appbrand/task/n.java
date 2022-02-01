package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandStartParams;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getCfg$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getStat$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends g
{
  final AppBrandInitConfigWC qBH;
  final AppBrandStatObject qxv;
  
  public n(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    super(str, paramAppBrandInitConfigWC.aqJ(), paramAppBrandInitConfigWC.eul);
    AppMethodBeat.i(318533);
    this.qBH = paramAppBrandInitConfigWC;
    this.qxv = paramAppBrandStatObject;
    AppMethodBeat.o(318533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.n
 * JD-Core Version:    0.7.0.1
 */