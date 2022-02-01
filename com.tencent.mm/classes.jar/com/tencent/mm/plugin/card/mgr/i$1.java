package com.tencent.mm.plugin.card.mgr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class i$1
  implements Runnable
{
  i$1(i parami, String paramString, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(112671);
    i.n(this.wsh, this.wsi, this.wsj, this.lyQ);
    Log.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.wsh + " system.time:" + System.currentTimeMillis());
    AppMethodBeat.o(112671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.mgr.i.1
 * JD-Core Version:    0.7.0.1
 */