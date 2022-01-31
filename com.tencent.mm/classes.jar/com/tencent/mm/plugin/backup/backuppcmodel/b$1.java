package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.sdk.platformtools.ae;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    try
    {
      if (b.a(this.hKw) == null)
      {
        PowerManager localPowerManager = (PowerManager)ae.getContext().getSystemService("power");
        b.a(this.hKw, localPowerManager.newWakeLock(26, "BackupPc Lock"));
      }
      if (!b.a(this.hKw).isHeld()) {
        b.a(this.hKw).acquire();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.1
 * JD-Core Version:    0.7.0.1
 */