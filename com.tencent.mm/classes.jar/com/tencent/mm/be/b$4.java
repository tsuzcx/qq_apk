package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class b$4
  implements ap.a
{
  b$4(b paramb) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(78531);
    ab.i("MicroMsg.SenseWhereHelper", "time up, stop sense where sdk.");
    b.ajd();
    this.fNW.aiX();
    AppMethodBeat.o(78531);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.be.b.4
 * JD-Core Version:    0.7.0.1
 */