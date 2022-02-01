package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class g
  extends IListener<ps>
{
  public g()
  {
    AppMethodBeat.i(161392);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(26363);
    if (!bg.aAc())
    {
      Log.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    h.ehG();
    bg.aVF();
    if (Util.milliSecondsToNow(Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    h.ehG().ehB();
    h.ehG();
    c.Ha(Util.nowMilliSecond());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.g
 * JD-Core Version:    0.7.0.1
 */