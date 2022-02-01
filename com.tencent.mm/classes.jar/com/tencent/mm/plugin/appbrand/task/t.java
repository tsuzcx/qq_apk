package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/task/WrongServiceTypeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "type", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "plugin-appbrand-integration_release"})
final class t
  extends IllegalStateException
{
  public t(LuggageServiceType paramLuggageServiceType)
  {
    super("unexpected service type:" + paramLuggageServiceType.name());
    AppMethodBeat.i(270700);
    AppMethodBeat.o(270700);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.t
 * JD-Core Version:    0.7.0.1
 */