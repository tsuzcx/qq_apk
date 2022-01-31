package com.tencent.mm.plugin.gif;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    AppMethodBeat.i(62408);
    if (SystemClock.uptimeMillis() >= e.a(this.nFR)) {
      this.nFR.invalidateSelf();
    }
    AppMethodBeat.o(62408);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e.1
 * JD-Core Version:    0.7.0.1
 */