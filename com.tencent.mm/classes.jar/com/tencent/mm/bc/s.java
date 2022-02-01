package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class s
  extends com.tencent.mm.sdk.b.c<oh>
{
  private static long fjO = 86400000L;
  
  public s()
  {
    AppMethodBeat.i(161781);
    this.__eventId = oh.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean TG()
  {
    AppMethodBeat.i(150857);
    if (bt.lZ(bt.f((Long)g.afB().afk().get(81938, null))) * 1000L > fjO)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean azW()
  {
    AppMethodBeat.i(150856);
    ad.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + TG());
    if (TG()) {
      c.azR().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.s
 * JD-Core Version:    0.7.0.1
 */