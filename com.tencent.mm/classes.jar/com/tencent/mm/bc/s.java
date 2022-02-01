package com.tencent.mm.bc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;

public final class s
  extends com.tencent.mm.sdk.b.c<oz>
{
  private static long fFq = 86400000L;
  
  public s()
  {
    AppMethodBeat.i(161781);
    this.__eventId = oz.class.getName().hashCode();
    AppMethodBeat.o(161781);
  }
  
  private static boolean WR()
  {
    AppMethodBeat.i(150857);
    if (bt.rM(bt.g((Long)g.ajC().ajl().get(81938, null))) * 1000L > fFq)
    {
      AppMethodBeat.o(150857);
      return true;
    }
    AppMethodBeat.o(150857);
    return false;
  }
  
  private static boolean aJX()
  {
    AppMethodBeat.i(150856);
    ad.d("MicroMsg.PostTaskUpdateConfigListListener", "callback expired : " + WR());
    if (WR()) {
      c.aJS().update();
    }
    AppMethodBeat.o(150856);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bc.s
 * JD-Core Version:    0.7.0.1
 */