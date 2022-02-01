package com.tencent.mm.plugin.card.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class g$1
  implements MTimerHandler.CallBack
{
  g$1(g paramg) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(112624);
    Log.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
    g.a(this.tne);
    AppMethodBeat.o(112624);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.b.g.1
 * JD-Core Version:    0.7.0.1
 */