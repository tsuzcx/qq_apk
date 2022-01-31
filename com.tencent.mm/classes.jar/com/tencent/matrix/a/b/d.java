package com.tencent.matrix.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.g.b;

public final class d
{
  Handler mDetectHandler;
  private boolean started = false;
  
  public final void j(Runnable paramRunnable)
  {
    this.mDetectHandler.post(paramRunnable);
  }
  
  public final void quit()
  {
    if (this.started)
    {
      this.mDetectHandler.removeCallbacksAndMessages(null);
      this.started = false;
    }
  }
  
  public final void start()
  {
    if (this.started) {
      return;
    }
    this.mDetectHandler = new Handler(b.zI().getLooper());
    this.started = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.a.b.d
 * JD-Core Version:    0.7.0.1
 */