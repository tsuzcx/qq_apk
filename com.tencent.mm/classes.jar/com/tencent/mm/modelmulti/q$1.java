package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;

final class q$1
  extends o.a
{
  q$1(q paramq) {}
  
  public final void onAppBackground(String paramString) {}
  
  public final void onAppForeground(String paramString)
  {
    AppMethodBeat.i(132586);
    ae.i("MicroMsg.SyncService", "SyncService onAppForeground %s", new Object[] { paramString });
    if ((g.ajM()) && (g.ajP().gDk))
    {
      g.ajP();
      if (!a.aiT()) {
        this.ijo.pP(3);
      }
    }
    AppMethodBeat.o(132586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelmulti.q.1
 * JD-Core Version:    0.7.0.1
 */