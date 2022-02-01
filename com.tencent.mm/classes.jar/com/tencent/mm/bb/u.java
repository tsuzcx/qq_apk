package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class u
  extends IListener<ps>
{
  private static long gmF = 86400000L;
  
  public u()
  {
    AppMethodBeat.i(161781);
    this.__eventId = ps.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean akM()
  {
    AppMethodBeat.i(150857);
    if (Util.secondsToNow(Util.nullAsNil((Long)g.aAh().azQ().get(81938, null))) * 1000L > gmF)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean bet()
  {
    AppMethodBeat.i(150856);
    Log.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + akM());
    if (akM()) {
      c.beo().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.u
 * JD-Core Version:    0.7.0.1
 */