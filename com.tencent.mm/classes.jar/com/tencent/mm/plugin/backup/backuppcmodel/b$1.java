package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(17488);
    try
    {
      if (b.a(this.jDZ) == null)
      {
        PowerManager localPowerManager = (PowerManager)ah.getContext().getSystemService("power");
        b.a(this.jDZ, localPowerManager.newWakeLock(26, "BackupPc Lock"));
      }
      if (!b.a(this.jDZ).isHeld()) {
        b.a(this.jDZ).acquire();
      }
      AppMethodBeat.o(17488);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(17488);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */