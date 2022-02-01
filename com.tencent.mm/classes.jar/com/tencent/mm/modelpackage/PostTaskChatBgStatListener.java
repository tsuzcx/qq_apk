package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public class PostTaskChatBgStatListener
  extends IListener<se>
{
  public PostTaskChatBgStatListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161779);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161779);
  }
  
  private static boolean bLF()
  {
    AppMethodBeat.i(150852);
    if (Util.secondsToNow(Util.nullAs((Long)h.baE().ban().d(66818, null), 0L)) * 1000L > 1800000L) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        i = Util.nullAs((Integer)h.baE().ban().d(66820, null), -99999);
        if (i != -99999)
        {
          ch.P(9, String.valueOf(i));
          h.baE().ban().B(66820, Integer.valueOf(-99999));
        }
        h.baE().ban().B(66818, Long.valueOf(Util.nowSecond()));
      }
      AppMethodBeat.o(150852);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelpackage.PostTaskChatBgStatListener
 * JD-Core Version:    0.7.0.1
 */