package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tinkerboots.sdk.a;

public final class f
  extends c<d>
{
  private static long cPp = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.dkF.dkG)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!g.ajM())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (cPp == 0L) {
      cPp = ((Long)g.ajR().ajA().get(am.a.IUV, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - cPp >= 21600000L) && (a.gix() != null))
    {
      a.gix().Ai(false);
      ae.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      cPp = l;
      g.ajR().ajA().set(am.a.IUV, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
  
  public static void yg(long paramLong)
  {
    cPp = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */