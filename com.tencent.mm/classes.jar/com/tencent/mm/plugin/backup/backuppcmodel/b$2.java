package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(17489);
    try
    {
      if ((b.a(this.jDZ) != null) && (b.a(this.jDZ).isHeld())) {
        b.a(this.jDZ).release();
      }
      AppMethodBeat.o(17489);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(17489);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.2
 * JD-Core Version:    0.7.0.1
 */