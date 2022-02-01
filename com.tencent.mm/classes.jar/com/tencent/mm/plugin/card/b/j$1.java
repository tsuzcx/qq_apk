package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class j$1
  implements Runnable
{
  j$1(j paramj, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112671);
    j.k(this.pRG, this.pRH, this.pRI, this.gsA);
    Log.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.pRG + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.j.1
 * JD-Core Version:    0.7.0.1
 */