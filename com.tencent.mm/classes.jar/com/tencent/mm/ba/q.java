package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class q
  extends com.tencent.mm.sdk.b.c<mv>
{
  private static long dZF = 86400000L;
  
  public q()
  {
    AppMethodBeat.i(78504);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(78504);
  }
  
  private static boolean Iu()
  {
    AppMethodBeat.i(78506);
    if (bo.gz(bo.c((Long)g.RL().Ru().get(81938, null))) * 1000L > dZF)
    {
      AppMethodBeat.o(78506);
      return true;
    }
    AppMethodBeat.o(78506);
    return false;
  }
  
  private static boolean aiN()
  {
    AppMethodBeat.i(78505);
    ab.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + Iu());
    if (Iu()) {
      c.aiI().update();
    }
    AppMethodBeat.o(78505);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.q
 * JD-Core Version:    0.7.0.1
 */