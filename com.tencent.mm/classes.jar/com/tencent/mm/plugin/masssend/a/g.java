package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oh;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class g
  extends com.tencent.mm.sdk.b.c<oh>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = oh.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean azW()
  {
    AppMethodBeat.i(26363);
    if (!az.afw())
    {
      ad.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.cNT();
    az.arV();
    if (bt.vM(bt.a((Long)com.tencent.mm.model.c.afk().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      ad.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.cNT().cNO();
    h.cNT();
    c.rk(bt.eGO());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */