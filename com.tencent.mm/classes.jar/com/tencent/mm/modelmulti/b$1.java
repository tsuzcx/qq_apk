package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$1
  implements ap.a
{
  b$1(b paramb, t.b paramb1) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(58347);
    b.a(this.fIe);
    b.a locala = new b.a(this.fId);
    this.fIe.onGYNetEnd(-1, 0, 0, "", locala, null);
    AppMethodBeat.o(58347);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelmulti.b.1
 * JD-Core Version:    0.7.0.1
 */