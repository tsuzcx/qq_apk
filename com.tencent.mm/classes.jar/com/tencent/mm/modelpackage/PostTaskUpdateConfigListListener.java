package com.tencent.mm.modelpackage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.se;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;

public class PostTaskUpdateConfigListListener
  extends IListener<se>
{
  private static long lsK = 86400000L;
  
  public PostTaskUpdateConfigListListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(161781);
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean aKG()
  {
    AppMethodBeat.i(150857);
    if (Util.secondsToNow(Util.nullAsNil((Long)h.baE().ban().d(81938, null))) * 1000L > lsK)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean bLF()
  {
    AppMethodBeat.i(150856);
    Log.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + aKG());
    if (aKG()) {
      c.bLz().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelpackage.PostTaskUpdateConfigListListener
 * JD-Core Version:    0.7.0.1
 */