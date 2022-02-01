package com.tencent.mm.modelvoiceaddr;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

final class c$1
  implements Runnable
{
  c$1(c paramc, h.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(148513);
    ad.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { this.ixO.iyH, Integer.valueOf(this.ixO.iyK), Integer.valueOf(this.ixP.hashCode()) });
    g.aiU().a(this.ixP, 0);
    AppMethodBeat.o(148513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.1
 * JD-Core Version:    0.7.0.1
 */