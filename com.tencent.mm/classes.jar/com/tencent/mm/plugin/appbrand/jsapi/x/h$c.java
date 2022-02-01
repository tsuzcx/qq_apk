package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "IMMEDIATE", "plugin-appbrand-integration_release"})
 enum h$c
{
  static
  {
    AppMethodBeat.i(50680);
    c localc1 = new c("TIMER_PERIOD", 0);
    pnB = localc1;
    c localc2 = new c("REACH_SLICE_LIMIT", 1);
    pnC = localc2;
    c localc3 = new c("RUNTIME_KILLED", 2);
    pnD = localc3;
    c localc4 = new c("IMMEDIATE", 3);
    pnE = localc4;
    pnF = new c[] { localc1, localc2, localc3, localc4 };
    AppMethodBeat.o(50680);
  }
  
  private h$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.h.c
 * JD-Core Version:    0.7.0.1
 */