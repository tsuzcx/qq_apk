package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

final class c$1
  implements Runnable
{
  c$1(c paramc, h.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(148513);
    ae.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { this.iAH.iBA, Integer.valueOf(this.iAH.iBD), Integer.valueOf(this.iAI.hashCode()) });
    g.ajj().a(this.iAI, 0);
    AppMethodBeat.o(148513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.1
 * JD-Core Version:    0.7.0.1
 */