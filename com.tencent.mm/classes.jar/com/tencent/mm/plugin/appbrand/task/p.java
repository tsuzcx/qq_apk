package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/AppBrandStartParams;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "cfg", "Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "stat", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "(Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;)V", "getCfg$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/config/AppBrandInitConfigWC;", "getStat$plugin_appbrand_integration_release", "()Lcom/tencent/mm/plugin/appbrand/report/AppBrandStatObject;", "plugin-appbrand-integration_release"})
public final class p
  extends g
{
  final AppBrandInitConfigWC nCs;
  final AppBrandStatObject nyh;
  
  public p(AppBrandInitConfigWC paramAppBrandInitConfigWC, AppBrandStatObject paramAppBrandStatObject)
  {
    super(str, paramAppBrandInitConfigWC.Qv(), paramAppBrandInitConfigWC.bLh());
    AppMethodBeat.i(274562);
    this.nCs = paramAppBrandInitConfigWC;
    this.nyh = paramAppBrandStatObject;
    AppMethodBeat.o(274562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.p
 * JD-Core Version:    0.7.0.1
 */