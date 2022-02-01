package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.performance.b;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

final class w$15
  implements MTimerHandler.CallBack
{
  w$15(w paramw) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(316558);
    b.n(this.qvY);
    AppMethodBeat.o(316558);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.w.15
 * JD-Core Version:    0.7.0.1
 */