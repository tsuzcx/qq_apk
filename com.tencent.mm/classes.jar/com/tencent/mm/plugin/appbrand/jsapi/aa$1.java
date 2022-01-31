package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.report.model.AdReportCgiHelper.a;

final class aa$1
  implements AdReportCgiHelper.a
{
  aa$1(aa paramaa, c paramc, int paramInt) {}
  
  public final void onDone()
  {
    AppMethodBeat.i(130371);
    this.hxi.h(this.bAX, this.hxj.j("ok", null));
    AppMethodBeat.o(130371);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.1
 * JD-Core Version:    0.7.0.1
 */