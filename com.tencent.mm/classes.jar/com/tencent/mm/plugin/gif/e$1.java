package com.tencent.mm.plugin.gif;

import android.os.SystemClock;

final class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public final void run()
  {
    if (SystemClock.uptimeMillis() >= e.a(this.liw)) {
      this.liw.invalidateSelf();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gif.e.1
 * JD-Core Version:    0.7.0.1
 */