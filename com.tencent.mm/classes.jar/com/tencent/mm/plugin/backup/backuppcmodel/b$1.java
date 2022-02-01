package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21547);
    try
    {
      if (b.a(this.oOj) == null)
      {
        PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        b.a(this.oOj, localPowerManager.newWakeLock(26, "BackupPc Lock"));
      }
      if (!b.a(this.oOj).isHeld()) {
        b.a(this.oOj).acquire();
      }
      AppMethodBeat.o(21547);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(21547);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */