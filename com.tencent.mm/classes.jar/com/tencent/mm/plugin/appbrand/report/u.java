package com.tencent.mm.plugin.appbrand.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.platform.window.a.j;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.appbrand.report.model.l;
import com.tencent.mm.sdk.platformtools.Log;

public final class u
  implements j
{
  public final void a(e.b paramb1, e.b paramb2)
  {
    AppMethodBeat.i(321518);
    l locall = new l();
    locall.tPI = paramb2.tLn;
    locall.tPJ = paramb1.tLn;
    Log.d("MicroMsg.report.ReportReqOrientationFunction", "reportFailed: req[%d] current[%d]", new Object[] { Integer.valueOf(locall.tPI), Integer.valueOf(locall.tPJ) });
    locall.bMH();
    AppMethodBeat.o(321518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.u
 * JD-Core Version:    0.7.0.1
 */