package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tinkerboots.sdk.a;

public final class f
  extends c<d>
{
  private static long cDA = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.cYl.cYm)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!g.agM())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (cDA == 0L) {
      cDA = ((Long)g.agR().agA().get(ah.a.GOb, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - cDA >= 21600000L) && (a.fMx() != null))
    {
      a.fMx().zh(false);
      ac.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      cDA = l;
      g.agR().agA().set(ah.a.GOb, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
  
  public static void vC(long paramLong)
  {
    cDA = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */