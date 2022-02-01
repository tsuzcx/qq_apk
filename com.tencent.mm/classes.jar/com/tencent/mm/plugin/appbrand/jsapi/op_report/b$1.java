package com.tencent.mm.plugin.appbrand.jsapi.op_report;

import com.tencent.luggage.sdk.b.a.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.d.a;

final class b$1
  implements d.a
{
  b$1(b paramb, d paramd, int paramInt) {}
  
  public final void cm(Object paramObject)
  {
    AppMethodBeat.i(147209);
    Log.e("Luggage.JsApiReportPageData", "reportwxaappexpose cgi failed, message = %s", new Object[] { paramObject });
    this.pcN.j(this.cuf, this.phK.h("fail:cgi fail", null));
    AppMethodBeat.o(147209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.op_report.b.1
 * JD-Core Version:    0.7.0.1
 */