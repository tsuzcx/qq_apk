package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
final class h$g
  implements MTimerHandler.CallBack
{
  public static final g pnK;
  
  static
  {
    AppMethodBeat.i(50690);
    pnK = new g();
    AppMethodBeat.o(50690);
  }
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(50689);
    h.a(h.pnu, h.c.pnB);
    AppMethodBeat.o(50689);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.h.g
 * JD-Core Version:    0.7.0.1
 */