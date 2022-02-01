package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class g
  extends com.tencent.mm.sdk.b.c<oz>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean aJX()
  {
    AppMethodBeat.i(26363);
    if (!ba.ajx())
    {
      ad.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dkU();
    ba.aBQ();
    if (bt.Df(bt.a((Long)com.tencent.mm.model.c.ajl().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dkU().dkP();
    h.dkU();
    c.xX(bt.flT());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */