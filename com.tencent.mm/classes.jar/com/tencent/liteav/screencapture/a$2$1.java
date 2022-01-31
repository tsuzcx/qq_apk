package com.tencent.liteav.screencapture;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;

class a$2$1
  implements Runnable
{
  a$2$1(a.2 param2) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.a.a.removeCallbacksAndMessages(null);
    }
    if (this.a.b != null)
    {
      if (Build.VERSION.SDK_INT >= 18) {
        this.a.b.quitSafely();
      }
    }
    else {
      return;
    }
    this.a.b.quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.a.2.1
 * JD-Core Version:    0.7.0.1
 */