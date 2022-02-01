package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class j$1
  implements Runnable
{
  j$1(j paramj, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112671);
    j.k(this.nra, this.nrb, this.nrc, this.fpl);
    ad.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.nra + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j.1
 * JD-Core Version:    0.7.0.1
 */