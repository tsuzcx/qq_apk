package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;

final class i$10
  implements Runnable
{
  i$10(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(86662);
    if (this.gPY.mFinished)
    {
      AppMethodBeat.o(86662);
      return;
    }
    i.d(this.gPY);
    this.gPY.mInitialized = true;
    i locali = this.gPY;
    while (!locali.gPX.isEmpty()) {
      locali.k((Runnable)locali.gPX.removeFirst(), 0L);
    }
    locali = this.gPY;
    locali.gPx.removeCallbacks(locali.gPW);
    AppMethodBeat.o(86662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.i.10
 * JD-Core Version:    0.7.0.1
 */