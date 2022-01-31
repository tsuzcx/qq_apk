package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

final class d$2
  implements Runnable
{
  d$2(d paramd) {}
  
  public final void run()
  {
    if (((this.lil.isRunning()) || (d.b(this.lil) == 0)) && (SystemClock.uptimeMillis() >= d.c(this.lil)))
    {
      d.a(this.lil, System.currentTimeMillis());
      d.d(this.lil);
      this.lil.invalidateSelf();
      if (d.a(this.lil) != null) {
        d.a(this.lil).invalidate();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.d.2
 * JD-Core Version:    0.7.0.1
 */