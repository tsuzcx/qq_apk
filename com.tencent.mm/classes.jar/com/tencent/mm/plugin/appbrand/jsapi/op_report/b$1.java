package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.luggage.sdk.b.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.d.a;

final class b$1
  implements d.a
{
  b$1(b paramb, c paramc, int paramInt) {}
  
  public final void aX(Object paramObject)
  {
    AppMethodBeat.i(102005);
    ab.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, message = %s", new Object[] { paramObject });
    this.hSU.h(this.bAX, this.hVq.j("fail:cgi fail", null));
    AppMethodBeat.o(102005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.b.1
 * JD-Core Version:    0.7.0.1
 */