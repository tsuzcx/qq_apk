package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class j$1
  implements ap.a
{
  j$1(j paramj, t.b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58379);
    j.a(this.fIW);
    j.a locala = new j.a(this.fId);
    e.qrI.idkeyStat(99L, 230L, 1L, false);
    this.fIW.onGYNetEnd(-1, 0, 0, "", locala, null);
    AppMethodBeat.o(58379);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.j.1
 * JD-Core Version:    0.7.0.1
 */