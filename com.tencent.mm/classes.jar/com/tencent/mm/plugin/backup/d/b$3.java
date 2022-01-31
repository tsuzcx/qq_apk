package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(17237);
    try
    {
      if ((b.a(this.jBc) != null) && (b.a(this.jBc).isHeld())) {
        b.a(this.jBc).release();
      }
      AppMethodBeat.o(17237);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(17237);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.3
 * JD-Core Version:    0.7.0.1
 */