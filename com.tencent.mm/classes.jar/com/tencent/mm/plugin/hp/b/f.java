package com.tencent.mm.plugin.hp.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.a.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tinkerboots.sdk.a;

public final class f
  extends c<d>
{
  private static long bUI = 0L;
  
  public f()
  {
    AppMethodBeat.i(90607);
    this.__eventId = d.class.getName().hashCode();
    AppMethodBeat.o(90607);
  }
  
  private static boolean a(d paramd)
  {
    AppMethodBeat.i(138235);
    if (paramd.cmd.cme)
    {
      AppMethodBeat.o(138235);
      return false;
    }
    if (!g.RG())
    {
      AppMethodBeat.o(138235);
      return false;
    }
    if (bUI == 0L) {
      bUI = ((Long)g.RL().Ru().get(ac.a.yHs, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - bUI >= 21600000L) && (a.eaJ() != null))
    {
      a.eaJ().sm(false);
      ab.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      bUI = l;
      g.RL().Ru().set(ac.a.yHs, Long.valueOf(l));
    }
    AppMethodBeat.o(138235);
    return false;
  }
  
  public static void kp(long paramLong)
  {
    bUI = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.b.f
 * JD-Core Version:    0.7.0.1
 */