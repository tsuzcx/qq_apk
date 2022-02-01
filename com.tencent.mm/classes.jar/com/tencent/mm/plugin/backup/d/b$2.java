package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(21290);
    try
    {
      if (b.a(this.oLr) == null)
      {
        PowerManager localPowerManager = (PowerManager)MMApplicationContext.getContext().getSystemService("power");
        b.a(this.oLr, localPowerManager.newWakeLock(26, "BackupMove Lock"));
      }
      if (!b.a(this.oLr).isHeld()) {
        b.a(this.oLr).acquire();
      }
      AppMethodBeat.o(21290);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(21290);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.2
 * JD-Core Version:    0.7.0.1
 */