package com.tencent.mm.plugin.masssend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public class PostTaskMassSendListener
  extends IListener<se>
{
  public PostTaskMassSendListener()
  {
    super(f.hfK);
    AppMethodBeat.i(161392);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161392);
  }
  
  private static boolean bLF()
  {
    AppMethodBeat.i(26363);
    if (!bh.baz())
    {
      Log.e("MicroMsg.PostTaskMassSendListener", "has not set uin");
      AppMethodBeat.o(26363);
      return false;
    }
    g.fZW();
    bh.bCz();
    if (Util.milliSecondsToNow(Util.nullAs((Long)com.tencent.mm.model.c.ban().d(102409, null), 0L)) > 900000L) {}
    for (int i = 1; i == 0; i = 0)
    {
      Log.d("MicroMsg.PostTaskMassSendListener", "time limit");
      AppMethodBeat.o(26363);
      return false;
    }
    g.fZW().fZR();
    g.fZW();
    c.sk(Util.nowMilliSecond());
    AppMethodBeat.o(26363);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.model.PostTaskMassSendListener
 * JD-Core Version:    0.7.0.1
 */