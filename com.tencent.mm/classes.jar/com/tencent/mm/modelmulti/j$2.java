package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ap.a;

final class j$2
  implements ap.a
{
  j$2(j paramj, j.a parama) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58380);
    j.a(this.fIW);
    e.qrI.idkeyStat(99L, 231L, 1L, false);
    this.fIW.onGYNetEnd(-1, 0, 0, "", this.fIX, null);
    AppMethodBeat.o(58380);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j.2
 * JD-Core Version:    0.7.0.1
 */