package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class t
  extends IListener<qq>
{
  public t()
  {
    AppMethodBeat.i(161779);
    this.__eventId = qq.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean bnS()
  {
    AppMethodBeat.i(150852);
    if (Util.secondsToNow(Util.nullAs((Long)h.aHG().aHp().b(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = Util.nullAs((Integer)h.aHG().aHp().b(66820, null), -99999);
        if (i != -99999)
        {
          cg.K(9, String.valueOf(i));
          h.aHG().aHp().i(66820, Integer.valueOf(-99999));
        }
        h.aHG().aHp().i(66818, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(150852);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.t
 * JD-Core Version:    0.7.0.1
 */