package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.vfs.e;

final class d$1
  implements ap.a
{
  d$1(d paramd) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116683);
    long l = e.avI(this.gbl.filename);
    ab.d("MicroMsg.NetSceneVoiceAddr", g.Ml() + " onTimerExpired: file:" + this.gbl.filename + " nowlen:" + l + " oldoff:" + this.gbl.fQS + " isFin:" + this.gbl.fZu);
    if ((l - this.gbl.fQS < 3300L) && (!this.gbl.fZu))
    {
      AppMethodBeat.o(116683);
      return true;
    }
    if (this.gbl.doScene(this.gbl.dispatcher(), this.gbl.callback) == -1)
    {
      this.gbl.retCode = (g.getLine() + 40000);
      this.gbl.callback.onSceneEnd(3, -1, "doScene failed", this.gbl);
    }
    AppMethodBeat.o(116683);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.d.1
 * JD-Core Version:    0.7.0.1
 */