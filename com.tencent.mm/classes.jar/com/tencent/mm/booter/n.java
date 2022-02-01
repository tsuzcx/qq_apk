package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.be.o;
import com.tencent.mm.bi.d;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class n
{
  private static long iQO = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    bh.beI();
    if (Util.secondsToNow(Util.nullAsNil((Long)c.aHp().b(81944, null))) * 1000L > iQO) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.bpf();
        d.bpg();
        if (!((d)localObject).jJQ)
        {
          h.aHH();
          if (h.aHG().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).jJQ = true;
            h.aGY().a(159, (i)localObject);
            localObject = new o(9);
            h.aGY().a((q)localObject, 0);
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