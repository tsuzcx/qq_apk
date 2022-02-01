package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qq;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class v
  extends IListener<qq>
{
  private static long iQO = 86400000L;
  
  public v()
  {
    AppMethodBeat.i(161781);
    this.__eventId = qq.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean aqI()
  {
    AppMethodBeat.i(150857);
    if (Util.secondsToNow(Util.nullAsNil((Long)h.aHG().aHp().b(81938, null))) * 1000L > iQO)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean bnS()
  {
    AppMethodBeat.i(150856);
    Log.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + aqI());
    if (aqI()) {
      c.bnM().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.be.v
 * JD-Core Version:    0.7.0.1
 */