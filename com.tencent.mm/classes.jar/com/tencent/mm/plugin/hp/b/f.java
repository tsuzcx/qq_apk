package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tinkerboots.sdk.a;

public final class f
  extends IListener<d>
{
  private static long dfO = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  public static void GQ(long paramLong)
  {
    dfO = paramLong;
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.dBP.dBQ)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!g.aAc())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (dfO == 0L) {
      dfO = ((Long)g.aAh().azQ().get(ar.a.Odn, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - dfO >= 21600000L) && (a.hvX() != null))
    {
      a.hvX().Ey(false);
      Log.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      dfO = l;
      g.aAh().azQ().set(ar.a.Odn, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */