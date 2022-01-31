package com.tencent.liteav.screencapture;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

class a$3$1
  implements Runnable
{
  a$3$1(a.3 param3) {}
  
  public void run()
  {
    AppMethodBeat.i(66767);
    if (this.a.a != null) {
      this.a.a.removeCallbacksAndMessages(null);
    }
    if (this.a.b != null)
    {
      if (Build.VERSION.SDK_INT >= 18)
      {
        this.a.b.quitSafely();
        AppMethodBeat.o(66767);
        return;
      }
      this.a.b.quit();
    }
    AppMethodBeat.o(66767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.3.1
 * JD-Core Version:    0.7.0.1
 */