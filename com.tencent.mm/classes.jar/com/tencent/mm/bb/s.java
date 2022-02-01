package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class s
  extends IListener<ps>
{
  public s()
  {
    AppMethodBeat.i(161779);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(150852);
    if (Util.secondsToNow(Util.nullAs((Long)g.aAh().azQ().get(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = Util.nullAs((Integer)g.aAh().azQ().get(66820, null), -99999);
        if (i != -99999)
        {
          cf.I(9, String.valueOf(i));
          g.aAh().azQ().set(66820, Integer.valueOf(-99999));
        }
        g.aAh().azQ().set(66818, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(150852);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.s
 * JD-Core Version:    0.7.0.1
 */