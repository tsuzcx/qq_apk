package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class g
  extends com.tencent.mm.sdk.b.c<mv>
{
  public g()
  {
    AppMethodBeat.i(22741);
    this.__eventId = mv.class.getName().hashCode();
    AppMethodBeat.o(22741);
  }
  
  private static boolean aiN()
  {
    AppMethodBeat.i(22742);
    if (!aw.RG())
    {
      ab.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(22742);
      return false;
    }
    h.bPd();
    aw.aaz();
    if (bo.hl(bo.a((Long)com.tencent.mm.model.c.Ru().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      ab.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(22742);
      return false;
    }
    h.bPd().bOY();
    h.bPd();
    c.kA(bo.aoy());
    AppMethodBeat.o(22742);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */