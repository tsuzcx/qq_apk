package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21548);
    try
    {
      if ((b.a(this.oOj) != null) && (b.a(this.oOj).isHeld())) {
        b.a(this.oOj).release();
      }
      AppMethodBeat.o(21548);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(21548);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.2
 * JD-Core Version:    0.7.0.1
 */