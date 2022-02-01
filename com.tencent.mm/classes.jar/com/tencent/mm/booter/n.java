package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class n
{
  private static long fjO = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    az.arV();
    if (bt.lZ(bt.f((Long)c.afk().get(81944, null))) * 1000L > fjO) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.aBo();
        d.aBp();
        if (!((d)localObject).fOm)
        {
          com.tencent.mm.kernel.g.afC();
          if (com.tencent.mm.kernel.g.afB().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).fOm = true;
            com.tencent.mm.kernel.g.aeS().a(159, (com.tencent.mm.al.g)localObject);
            localObject = new l(9);
            com.tencent.mm.kernel.g.aeS().a((com.tencent.mm.al.n)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(19898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */