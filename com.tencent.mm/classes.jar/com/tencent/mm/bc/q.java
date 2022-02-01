package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.by;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class q
  extends c<oh>
{
  public q()
  {
    AppMethodBeat.i(161779);
    this.__eventId = oh.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean azW()
  {
    AppMethodBeat.i(150852);
    if (bt.lZ(bt.a((Long)g.afB().afk().get(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = bt.a((Integer)g.afB().afk().get(66820, null), -99999);
        if (i != -99999)
        {
          by.E(9, String.valueOf(i));
          g.afB().afk().set(66820, Integer.valueOf(-99999));
        }
        g.afB().afk().set(66818, Long.valueOf(bt.aGK()));
      }
      AppMethodBeat.o(150852);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.q
 * JD-Core Version:    0.7.0.1
 */