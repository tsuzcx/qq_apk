package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    if ((!h.a(this.liD)) && ((this.liD.isRunning()) || (h.b(this.liD) == 0)) && (SystemClock.uptimeMillis() >= h.c(this.liD)))
    {
      h.a(this.liD, System.currentTimeMillis());
      h.d(this.liD);
      this.liD.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.h.1
 * JD-Core Version:    0.7.0.1
 */