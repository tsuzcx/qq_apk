package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.PowerManager.WakeLock;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    try
    {
      if ((b.a(this.hKw) != null) && (b.a(this.hKw).isHeld())) {
        b.a(this.hKw).release();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.backuppcmodel.b.2
 * JD-Core Version:    0.7.0.1
 */