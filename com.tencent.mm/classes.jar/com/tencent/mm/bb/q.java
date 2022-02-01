package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class q
  extends c<pa>
{
  public q()
  {
    AppMethodBeat.i(161779);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(150852);
    if (bu.rZ(bu.a((Long)g.ajR().ajA().get(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = bu.a((Integer)g.ajR().ajA().get(66820, null), -99999);
        if (i != -99999)
        {
          cb.F(9, String.valueOf(i));
          g.ajR().ajA().set(66820, Integer.valueOf(-99999));
        }
        g.ajR().ajA().set(66818, Long.valueOf(bu.aRi()));
      }
      AppMethodBeat.o(150852);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.q
 * JD-Core Version:    0.7.0.1
 */