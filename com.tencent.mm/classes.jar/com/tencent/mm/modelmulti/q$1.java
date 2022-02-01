package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;

final class q$1
  extends n.a
{
  q$1(q paramq) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(132586);
    ad.i("MicroMsg.SyncService", "SyncService onAppForeground %s", new Object[] { paramString });
    if ((g.ajx()) && (g.ajA().gAD))
    {
      g.ajA();
      if (!a.aiE()) {
        this.igv.pM(3);
      }
    }
    AppMethodBeat.o(132586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q.1
 * JD-Core Version:    0.7.0.1
 */