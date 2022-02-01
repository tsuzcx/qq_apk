package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.m;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"getAppBrandProcesses", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "maxLimit", "", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "plugin-appbrand-integration_release"})
public final class k
{
  public static final i cjd()
  {
    AppMethodBeat.i(282430);
    if (com.tencent.mm.plugin.appbrand.ui.n.cka())
    {
      locali = (i)new o();
      AppMethodBeat.o(282430);
      return locali;
    }
    i locali = (i)new g();
    AppMethodBeat.o(282430);
    return locali;
  }
  
  static final int f(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(282429);
    switch (l.$EnumSwitchMapping$0[paramLuggageServiceType.ordinal()])
    {
    default: 
      paramLuggageServiceType = new m();
      AppMethodBeat.o(282429);
      throw paramLuggageServiceType;
    case 1: 
      AppMethodBeat.o(282429);
      return 2147483647;
    case 2: 
      int i = n.cje();
      AppMethodBeat.o(282429);
      return i;
    }
    AppMethodBeat.o(282429);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.k
 * JD-Core Version:    0.7.0.1
 */