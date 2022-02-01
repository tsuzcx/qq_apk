package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.r;
import kotlin.Metadata;
import kotlin.p;

@Metadata(d1={""}, d2={"getAppBrandProcesses", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandProcessesManager;", "maxLimit", "", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  public static final i cJX()
  {
    AppMethodBeat.i(318576);
    if (r.cLs())
    {
      locali = (i)new m();
      AppMethodBeat.o(318576);
      return locali;
    }
    i locali = (i)new g();
    AppMethodBeat.o(318576);
    return locali;
  }
  
  static final int f(LuggageServiceType paramLuggageServiceType)
  {
    AppMethodBeat.i(318575);
    switch (a.$EnumSwitchMapping$0[paramLuggageServiceType.ordinal()])
    {
    default: 
      paramLuggageServiceType = new p();
      AppMethodBeat.o(318575);
      throw paramLuggageServiceType;
    case 1: 
      AppMethodBeat.o(318575);
      return 2147483647;
    case 2: 
      int i = l.cJY();
      AppMethodBeat.o(318575);
      return i;
    }
    AppMethodBeat.o(318575);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.j
 * JD-Core Version:    0.7.0.1
 */