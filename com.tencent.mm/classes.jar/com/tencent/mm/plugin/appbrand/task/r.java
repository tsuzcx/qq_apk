package com.tencent.mm.plugin.appbrand.task;

import com.tencent.luggage.sdk.processes.LuggageServiceType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/task/WrongServiceTypeException;", "Ljava/lang/IllegalStateException;", "Lkotlin/IllegalStateException;", "type", "Lcom/tencent/luggage/sdk/processes/LuggageServiceType;", "(Lcom/tencent/luggage/sdk/processes/LuggageServiceType;)V", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class r
  extends IllegalStateException
{
  public r(LuggageServiceType paramLuggageServiceType)
  {
    super(s.X("unexpected service type:", paramLuggageServiceType.name()));
    AppMethodBeat.i(318539);
    AppMethodBeat.o(318539);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.r
 * JD-Core Version:    0.7.0.1
 */