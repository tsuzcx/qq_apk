package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21291);
    try
    {
      if ((b.a(this.oLr) != null) && (b.a(this.oLr).isHeld())) {
        b.a(this.oLr).release();
      }
      AppMethodBeat.o(21291);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(21291);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.3
 * JD-Core Version:    0.7.0.1
 */