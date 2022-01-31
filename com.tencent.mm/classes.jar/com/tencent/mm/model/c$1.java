package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bb;

final class c$1
  implements h.a
{
  c$1(c paramc) {}
  
  public final void RB()
  {
    AppMethodBeat.i(16199);
    g.RM();
    if (g.RG())
    {
      m localm = q.akL();
      if (localm != null)
      {
        ab.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: ".concat(String.valueOf(localm)));
        long l = System.currentTimeMillis();
        localm.fUg.pM(true);
        ab.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
      }
    }
    AppMethodBeat.o(16199);
  }
  
  public final void RC() {}
  
  public final void RD() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.c.1
 * JD-Core Version:    0.7.0.1
 */