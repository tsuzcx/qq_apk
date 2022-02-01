package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class n
{
  private static long gmF = 86400000L;
  
  public static void run()
  {
    AppMethodBeat.i(19898);
    bg.aVF();
    if (Util.secondsToNow(Util.nullAsNil((Long)c.azQ().get(81944, null))) * 1000L > gmF) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = d.bfP();
        d.bfQ();
        if (!((d)localObject).gYQ)
        {
          g.aAi();
          if (g.aAh().isSDCardAvailable())
          {
            ((d)localObject).release();
            ((d)localObject).gYQ = true;
            g.azz().a(159, (i)localObject);
            localObject = new com.tencent.mm.bb.n(9);
            g.azz().a((q)localObject, 0);
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