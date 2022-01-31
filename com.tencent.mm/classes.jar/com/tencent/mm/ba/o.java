package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bv;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class o
  extends c<mv>
{
  public o()
  {
    AppMethodBeat.i(78498);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(78498);
  }
  
  private static boolean aiN()
  {
    AppMethodBeat.i(78499);
    if (bo.gz(bo.a((Long)g.RL().Ru().get(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = bo.a((Integer)g.RL().Ru().get(66820, null), -99999);
        if (i != -99999)
        {
          bv.v(9, String.valueOf(i));
          g.RL().Ru().set(66820, Integer.valueOf(-99999));
        }
        g.RL().Ru().set(66818, Long.valueOf(bo.aox()));
      }
      AppMethodBeat.o(78499);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.o
 * JD-Core Version:    0.7.0.1
 */