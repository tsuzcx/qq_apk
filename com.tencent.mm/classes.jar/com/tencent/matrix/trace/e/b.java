package com.tencent.matrix.trace.e;

import android.os.Handler;
import android.os.HandlerThread;

public class b
{
  private Handler handler;
  public long time;
  
  public void a(String paramString, long paramLong, int paramInt) {}
  
  public Handler getHandler()
  {
    if (this.handler == null) {
      this.handler = new Handler(com.tencent.matrix.g.b.zI().getLooper());
    }
    return this.handler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.e.b
 * JD-Core Version:    0.7.0.1
 */