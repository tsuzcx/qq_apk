package com.tencent.liteav.basic.d;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class f$1$1
  implements Runnable
{
  f$1$1(f.1 param1) {}
  
  public void run()
  {
    AppMethodBeat.i(146562);
    if (this.a.a != null) {
      this.a.a.removeCallbacksAndMessages(null);
    }
    if (this.a.b != null)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.a.b.quitSafely();
        AppMethodBeat.o(146562);
        return;
      }
      this.a.b.quit();
    }
    AppMethodBeat.o(146562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.basic.d.f.1.1
 * JD-Core Version:    0.7.0.1
 */