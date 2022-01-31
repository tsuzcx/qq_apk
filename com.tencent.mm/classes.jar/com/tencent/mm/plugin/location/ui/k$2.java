package com.tencent.mm.plugin.location.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class k$2
  implements ap.a
{
  k$2(k paramk) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(113531);
    ab.i("MicroMsg.TalkMgr", "seizeMicTimer reach");
    k.a(this.oeg);
    AppMethodBeat.o(113531);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.k.2
 * JD-Core Version:    0.7.0.1
 */