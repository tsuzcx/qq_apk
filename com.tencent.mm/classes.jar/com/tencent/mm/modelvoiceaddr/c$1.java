package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements Runnable
{
  c$1(c paramc, h.a parama) {}
  
  public final void run()
  {
    y.i("MicroMsg.NetSceneNewVoiceInput", "real doLastScene voiceId:%s, voiceFileMarkEnd:%s,hashCode:%s", new Object[] { this.eLy.eMn, Integer.valueOf(this.eLy.eMq), Integer.valueOf(this.eLz.hashCode()) });
    g.Dk().a(this.eLz, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoiceaddr.c.1
 * JD-Core Version:    0.7.0.1
 */