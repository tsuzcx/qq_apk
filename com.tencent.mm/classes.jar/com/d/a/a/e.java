package com.d.a.a;

import android.os.Handler;

abstract class e
{
  private e.a aVN;
  long aVO;
  final Handler handler;
  
  e(Handler paramHandler)
  {
    if (paramHandler != null) {}
    for (;;)
    {
      this.handler = paramHandler;
      return;
      paramHandler = new Handler();
    }
  }
  
  final void i(long paramLong1, long paramLong2)
  {
    stop();
    this.aVO = paramLong1;
    this.aVN = new e.a(this, (byte)0);
    e.a.a(this.aVN, paramLong2);
  }
  
  abstract void pb();
  
  final void stop()
  {
    if (this.aVN != null) {
      e.a.a(this.aVN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.d.a.a.e
 * JD-Core Version:    0.7.0.1
 */