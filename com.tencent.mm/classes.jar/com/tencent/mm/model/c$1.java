package com.tencent.mm.model;

import com.tencent.mm.cf.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.m;
import com.tencent.mm.modelstat.q;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.y;

final class c$1
  implements h.a
{
  c$1(c paramc) {}
  
  public final void DG()
  {
    g.DQ();
    if (g.DK())
    {
      m localm = q.RC();
      if (localm != null)
      {
        y.i("MicroMsg.AccountStorage", "summer preCloseCallback netStatStg: " + localm);
        long l = System.currentTimeMillis();
        localm.eEp.mx(true);
        y.i("MicroMsg.NetStat", "summer net appendAllToDisk end takes: " + (System.currentTimeMillis() - l) + " ms");
      }
    }
  }
  
  public final void DH() {}
  
  public final void DI() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.c.1
 * JD-Core Version:    0.7.0.1
 */