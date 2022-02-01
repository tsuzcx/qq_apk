package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class g
  extends com.tencent.mm.sdk.b.c<pa>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(26363);
    if (!bc.ajM())
    {
      ae.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dnU();
    bc.aCg();
    if (bu.DD(bu.a((Long)com.tencent.mm.model.c.ajA().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      ae.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.dnU().dnP();
    h.dnU();
    c.yr(bu.fpO());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */