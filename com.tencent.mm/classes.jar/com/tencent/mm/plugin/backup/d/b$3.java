package com.tencent.mm.plugin.backup.d;

import android.os.PowerManager.WakeLock;

final class b$3
  implements Runnable
{
  b$3(b paramb) {}
  
  public final void run()
  {
    try
    {
      if ((b.a(this.hHG) != null) && (b.a(this.hHG).isHeld())) {
        b.a(this.hHG).release();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.b.3
 * JD-Core Version:    0.7.0.1
 */