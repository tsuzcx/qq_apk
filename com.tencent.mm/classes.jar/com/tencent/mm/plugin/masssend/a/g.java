package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class g
  extends IListener<qq>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = qq.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean bnS()
  {
    AppMethodBeat.i(26363);
    if (!bh.aHB())
    {
      Log.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.eRn();
    bh.beI();
    if (Util.milliSecondsToNow(Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.eRn().eRi();
    h.eRn();
    c.Op(Util.nowMilliSecond());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */