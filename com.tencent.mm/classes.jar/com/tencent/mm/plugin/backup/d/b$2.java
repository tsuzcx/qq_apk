package com.tencent.mm.plugin.backup.d;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.ae;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    try
    {
      if (b.a(this.hHG) == null)
      {
        PowerManager localPowerManager = (PowerManager)ae.getContext().getSystemService("power");
        b.a(this.hHG, localPowerManager.newWakeLock(26, "BackupMove Lock"));
      }
      if (!b.a(this.hHG).isHeld()) {
        b.a(this.hHG).acquire();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.2
 * JD-Core Version:    0.7.0.1
 */