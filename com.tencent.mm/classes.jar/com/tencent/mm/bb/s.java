package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class s
  extends com.tencent.mm.sdk.b.c<oq>
{
  private static long fni = 86400000L;
  
  public s()
  {
    AppMethodBeat.i(161781);
    this.__eventId = oq.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean UA()
  {
    AppMethodBeat.i(150857);
    if (bs.pN(bs.g((Long)g.agR().agA().get(81938, null))) * 1000L > fni)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean aGM()
  {
    AppMethodBeat.i(150856);
    ac.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + UA());
    if (UA()) {
      c.aGH().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.s
 * JD-Core Version:    0.7.0.1
 */