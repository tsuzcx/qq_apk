package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class q
  extends c<oq>
{
  public q()
  {
    AppMethodBeat.i(161779);
    this.__eventId = oq.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean aGM()
  {
    AppMethodBeat.i(150852);
    if (bs.pN(bs.a((Long)g.agR().agA().get(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = bs.a((Integer)g.agR().agA().get(66820, null), -99999);
        if (i != -99999)
        {
          by.F(9, String.valueOf(i));
          g.agR().agA().set(66820, Integer.valueOf(-99999));
        }
        g.agR().agA().set(66818, Long.valueOf(bs.aNx()));
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