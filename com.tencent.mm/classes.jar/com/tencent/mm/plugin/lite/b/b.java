package com.tencent.mm.plugin.lite.b;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public final class b
  extends IListener<d>
{
  private static long yEy = 0L;
  private static long yEz = 0L;
  
  public b()
  {
    AppMethodBeat.i(198851);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(198851);
  }
  
  private boolean a(d paramd)
  {
    AppMethodBeat.i(198852);
    if (paramd.dBP.dBQ)
    {
      AppMethodBeat.o(198852);
      return false;
    }
    if (!g.aAc())
    {
      Log.w("MicroMsg.AppLite.LiteAppCheckerListener", "callback fail. account not ready.");
      AppMethodBeat.o(198852);
      return false;
    }
    if (yEy == 0L) {
      yEy = ((Long)g.aAh().azQ().get(ar.a.Oor, Long.valueOf(0L))).longValue();
    }
    if (yEz == 0L) {
      yEz = ((Long)g.aAh().azQ().get(ar.a.Oos, Long.valueOf(0L))).longValue();
    }
    long l1 = System.currentTimeMillis();
    long l2 = l1 - yEy;
    if (l2 >= 43200000L)
    {
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to update lite app.");
      yEy = l1;
      g.aAh().azQ().set(ar.a.Oor, Long.valueOf(l1));
      h.RTc.aX(new b.1(this));
      if (l1 - yEz < 86400000L) {
        break label265;
      }
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's time to clean lite app.");
      yEz = l1;
      g.aAh().azQ().set(ar.a.Oos, Long.valueOf(l1));
      h.RTc.aX(new b.2(this));
    }
    for (;;)
    {
      AppMethodBeat.o(198852);
      return false;
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to update lite app. please wait %d second", new Object[] { Long.valueOf((43200000L - l2) / 100L) });
      break;
      label265:
      Log.i("MicroMsg.AppLite.LiteAppCheckerListener", "It's not time to clean lite app. please wait %d second", new Object[] { Long.valueOf((86400000L - l2) / 100L) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.b.b
 * JD-Core Version:    0.7.0.1
 */