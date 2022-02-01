package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.q;
import com.tencent.mm.bc.l;
import com.tencent.mm.bh.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class n
{
  private static long fFq = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    ba.aBQ();
    if (bt.rM(bt.g((Long)c.ajl().get(81944, null))) * 1000L > fFq) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.aLp();
        d.aLq();
        if (!((d)localObject).glB)
        {
          g.ajD();
          if (g.ajC().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).glB = true;
            g.aiU().a(159, (f)localObject);
            localObject = new l(9);
            g.aiU().a((com.tencent.mm.al.n)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(19898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */