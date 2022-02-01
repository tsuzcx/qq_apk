package com.tencent.mm.plugin.hp.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.e;
import com.tencent.mm.autogen.a.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tinkerboots.sdk.a;

public class TinkerBootsActivateListener
  extends IListener<e>
{
  private static long mpK = 0L;
  
  public TinkerBootsActivateListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161184);
    this.__eventId = e.class.getName().hashCode();
    AppMethodBeat.o(161184);
  }
  
  private static boolean b(e parame)
  {
    AppMethodBeat.i(117435);
    if (parame.hyJ.hyK)
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (!h.baz())
    {
      AppMethodBeat.o(117435);
      return false;
    }
    if (mpK == 0L) {
      mpK = ((Long)h.baE().ban().get(at.a.acTb, Long.valueOf(0L))).longValue();
    }
    long l = System.currentTimeMillis();
    if ((l - mpK >= 21600000L) && (a.kkr() != null))
    {
      a.kkr().Pi(false);
      Log.i("MicroMsg.Tinker.TinkerBootsActivateListener", "callback post task and fetchPatchUpdate false");
      mpK = l;
      h.baE().ban().set(at.a.acTb, Long.valueOf(l));
    }
    AppMethodBeat.o(117435);
    return false;
  }
  
  public static void sa(long paramLong)
  {
    mpK = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.model.TinkerBootsActivateListener
 * JD-Core Version:    0.7.0.1
 */