package com.tencent.mm.plugin.gif;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(62381);
    if (((this.nFG.isRunning()) || (d.b(this.nFG) == 0)) && (SystemClock.uptimeMillis() >= d.c(this.nFG)))
    {
      d.a(this.nFG, System.currentTimeMillis());
      d.d(this.nFG);
      this.nFG.invalidateSelf();
      if (d.a(this.nFG) != null) {
        d.a(this.nFG).invalidate();
      }
    }
    AppMethodBeat.o(62381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.2
 * JD-Core Version:    0.7.0.1
 */