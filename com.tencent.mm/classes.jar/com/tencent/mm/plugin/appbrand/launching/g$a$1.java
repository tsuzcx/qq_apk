package com.tencent.mm.plugin.appbrand.launching;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ap.a;

final class g$a$1
  implements ap.a
{
  g$a$1(String paramString) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(131785);
    h.qsU.cT(369, 23);
    g.Dk(this.hpi);
    AppMethodBeat.o(131785);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.g.a.1
 * JD-Core Version:    0.7.0.1
 */