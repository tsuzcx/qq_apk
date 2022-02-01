package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class n
{
  private static long fni = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    az.ayM();
    if (bs.pN(bs.g((Long)c.agA().get(81944, null))) * 1000L > fni) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.aIe();
        d.aIf();
        if (!((d)localObject).fRX)
        {
          com.tencent.mm.kernel.g.agS();
          if (com.tencent.mm.kernel.g.agR().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).fRX = true;
            com.tencent.mm.kernel.g.agi().a(159, (com.tencent.mm.ak.g)localObject);
            localObject = new l(9);
            com.tencent.mm.kernel.g.agi().a((com.tencent.mm.ak.n)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(19898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */