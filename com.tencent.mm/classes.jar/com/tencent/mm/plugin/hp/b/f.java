package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tinkerboots.sdk.a;

public final class f
  extends c<d>
{
  private static long cOF = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.djD.djE)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!g.ajx())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (cOF == 0L) {
      cOF = ((Long)g.ajC().ajl().get(al.a.IAw, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - cOF >= 21600000L) && (a.gdU() != null))
    {
      a.gdU().zV(false);
      ad.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      cOF = l;
      g.ajC().ajl().set(al.a.IAw, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
  
  public static void xM(long paramLong)
  {
    cOF = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */