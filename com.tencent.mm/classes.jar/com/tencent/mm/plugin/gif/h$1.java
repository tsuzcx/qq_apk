package com.tencent.mm.plugin.gif;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    AppMethodBeat.i(62425);
    if ((!h.a(this.nFY)) && ((this.nFY.isRunning()) || (h.b(this.nFY) == 0)) && (SystemClock.uptimeMillis() >= h.c(this.nFY)))
    {
      h.a(this.nFY, System.currentTimeMillis());
      h.d(this.nFY);
      this.nFY.invalidateSelf();
    }
    AppMethodBeat.o(62425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h.1
 * JD-Core Version:    0.7.0.1
 */