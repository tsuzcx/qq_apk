package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class n
{
  private static long fHu = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    bc.aCg();
    if (bu.rZ(bu.i((Long)c.ajA().get(81944, null))) * 1000L > fHu) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.aLM();
        d.aLN();
        if (!((d)localObject).gnW)
        {
          g.ajS();
          if (g.ajR().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).gnW = true;
            g.ajj().a(159, (f)localObject);
            localObject = new l(9);
            g.ajj().a((com.tencent.mm.ak.n)localObject, 0);
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