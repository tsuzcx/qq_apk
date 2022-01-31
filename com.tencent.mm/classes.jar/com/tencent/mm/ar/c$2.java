package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$2
  implements ap.a
{
  c$2(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(16471);
    ab.d("MicroMsg.GetContactService", "pusherTry onTimerExpired tryStartNetscene");
    this.fCU.ahb();
    AppMethodBeat.o(16471);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ar.c.2
 * JD-Core Version:    0.7.0.1
 */