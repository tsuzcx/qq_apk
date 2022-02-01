package com.tencent.mm.plugin.appbrand.jsapi.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/report/RealtimeReportQueue$CGIReason;", "", "(Ljava/lang/String;I)V", "TIMER_PERIOD", "REACH_SLICE_LIMIT", "RUNTIME_KILLED", "IMMEDIATE", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
 enum i$c
{
  static
  {
    AppMethodBeat.i(50680);
    sss = new c("TIMER_PERIOD", 0);
    sst = new c("REACH_SLICE_LIMIT", 1);
    ssu = new c("RUNTIME_KILLED", 2);
    ssv = new c("IMMEDIATE", 3);
    ssw = new c[] { sss, sst, ssu, ssv };
    AppMethodBeat.o(50680);
  }
  
  private i$c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.i.c
 * JD-Core Version:    0.7.0.1
 */