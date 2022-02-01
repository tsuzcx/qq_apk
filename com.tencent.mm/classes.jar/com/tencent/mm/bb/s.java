package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class s
  extends com.tencent.mm.sdk.b.c<pa>
{
  private static long fHu = 86400000L;
  
  public s()
  {
    AppMethodBeat.i(161781);
    this.__eventId = pa.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean WZ()
  {
    AppMethodBeat.i(150857);
    if (bu.rZ(bu.i((Long)g.ajR().ajA().get(81938, null))) * 1000L > fHu)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean aKq()
  {
    AppMethodBeat.i(150856);
    ae.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + WZ());
    if (WZ()) {
      c.aKl().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.s
 * JD-Core Version:    0.7.0.1
 */