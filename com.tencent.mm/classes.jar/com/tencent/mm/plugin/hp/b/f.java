package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.d;
import com.tencent.mm.f.a.d.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tinkerboots.sdk.a;

public final class f
  extends IListener<d>
{
  private static long jQC = 0L;
  
  public f()
  {
    AppMethodBeat.i(161184);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  public static void Of(long paramLong)
  {
    jQC = paramLong;
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(117435);
    if (paramd.fur.fus)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!h.aHB())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (jQC == 0L) {
      jQC = ((Long)h.aHG().aHp().get(ar.a.Vrx, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - jQC >= 21600000L) && (a.izW() != null))
    {
      a.izW().Jb(false);
      Log.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      jQC = l;
      h.aHG().aHp().set(ar.a.Vrx, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */