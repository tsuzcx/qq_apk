package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(17236);
    try
    {
      if (b.a(this.jBc) == null)
      {
        PowerManager localPowerManager = (PowerManager)ah.getContext().getSystemService("power");
        b.a(this.jBc, localPowerManager.newWakeLock(26, "BackupMove Lock"));
      }
      if (!b.a(this.jBc).isHeld()) {
        b.a(this.jBc).acquire();
      }
      AppMethodBeat.o(17236);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(17236);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.2
 * JD-Core Version:    0.7.0.1
 */