package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tinkerboots.sdk.a;

public final class f
  extends c<d>
{
  private static long cGs = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.daP.daQ)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!g.afw())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (cGs == 0L) {
      cGs = ((Long)g.afB().afk().get(ae.a.Fql, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - cGs >= 21600000L) && (a.ftM() != null))
    {
      a.ftM().xP(false);
      ad.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      cGs = l;
      g.afB().afk().set(ae.a.Fql, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
  
  public static void qZ(long paramLong)
  {
    cGs = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */