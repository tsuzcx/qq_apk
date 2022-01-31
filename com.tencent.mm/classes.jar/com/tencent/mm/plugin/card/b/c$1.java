package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class c$1
  implements ap.a
{
  c$1(c paramc) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(87637);
    ab.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
    this.klg.Hz(this.klg.kkW);
    this.klg.bbt();
    AppMethodBeat.o(87637);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.c.1
 * JD-Core Version:    0.7.0.1
 */