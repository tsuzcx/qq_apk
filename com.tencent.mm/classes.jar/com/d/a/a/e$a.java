package com.d.a.a;

import android.os.Handler;

final class e$a
  implements Runnable
{
  private boolean aVP;
  private boolean started;
  
  private e$a(e parame) {}
  
  public final void run()
  {
    if (this.aVP) {
      return;
    }
    this.aVQ.pb();
    this.aVQ.handler.postDelayed(this, this.aVQ.aVO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.d.a.a.e.a
 * JD-Core Version:    0.7.0.1
 */