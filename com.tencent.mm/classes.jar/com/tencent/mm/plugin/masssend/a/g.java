package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class g
  extends com.tencent.mm.sdk.b.c<oq>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = oq.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean aGM()
  {
    AppMethodBeat.i(26363);
    if (!az.agM())
    {
      ac.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dbA();
    az.ayM();
    if (bs.Ap(bs.a((Long)com.tencent.mm.model.c.agA().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      ac.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dbA().dbv();
    h.dbA();
    c.vN(bs.eWj());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */