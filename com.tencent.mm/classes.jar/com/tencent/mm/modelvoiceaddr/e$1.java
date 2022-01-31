package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap.a;

final class e$1
  implements ap.a
{
  e$1(e parame) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(116688);
    long l = com.tencent.mm.vfs.e.avI(this.gbn.filename);
    ab.d("MicroMsg.NetSceneVoiceInput", g.Ml() + " onTimerExpired: file:" + this.gbn.filename + " nowlen:" + l + " oldoff:" + this.gbn.fQS + " isFin:" + this.gbn.fZu);
    if ((l - this.gbn.fQS < 3300L) && (!this.gbn.fZu))
    {
      AppMethodBeat.o(116688);
      return true;
    }
    if (this.gbn.doScene(this.gbn.dispatcher(), this.gbn.callback) == -1)
    {
      this.gbn.retCode = (g.getLine() + 40000);
      this.gbn.callback.onSceneEnd(3, -1, "doScene failed", this.gbn);
    }
    AppMethodBeat.o(116688);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.e.1
 * JD-Core Version:    0.7.0.1
 */