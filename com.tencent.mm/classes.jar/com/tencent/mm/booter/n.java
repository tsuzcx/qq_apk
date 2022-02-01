package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.bb.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public final class n
{
  private static long lsK = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    bh.bCz();
    if (Util.secondsToNow(Util.nullAsNil((Long)c.ban().d(81944, null))) * 1000L > lsK) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.bMM();
        d.bMN();
        if (!((d)localObject).mjj)
        {
          com.tencent.mm.kernel.h.baF();
          if (com.tencent.mm.kernel.h.baE().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).mjj = true;
            com.tencent.mm.kernel.h.aZW().a(159, (com.tencent.mm.am.h)localObject);
            localObject = new com.tencent.mm.modelpackage.p(9);
            com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
          }
        }
      }
      AppMethodBeat.o(19898);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.booter.n
 * JD-Core Version:    0.7.0.1
 */