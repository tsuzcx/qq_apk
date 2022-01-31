package com.tencent.matrix.trace.d;

import android.os.Handler;
import android.os.HandlerThread;

public final class a
{
  private final long brn;
  private volatile boolean bro = false;
  private final Handler mHandler;
  
  public a(HandlerThread paramHandlerThread, long paramLong)
  {
    this.brn = paramLong;
    this.mHandler = new Handler(paramHandlerThread.getLooper());
  }
  
  public final void a(a parama, boolean paramBoolean)
  {
    if (this.mHandler != null)
    {
      this.bro = true;
      this.mHandler.removeCallbacksAndMessages(null);
      parama = new b(this.mHandler, this.brn, parama, paramBoolean);
      this.mHandler.postDelayed(parama, this.brn);
    }
  }
  
  public final void cancel()
  {
    if (this.mHandler != null)
    {
      this.bro = false;
      this.mHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public static abstract interface a
  {
    public abstract void rq();
  }
  
  static final class b
    implements Runnable
  {
    private final long brn;
    private final a.a brp;
    private final boolean brq;
    private final Handler handler;
    
    b(Handler paramHandler, long paramLong, a.a parama, boolean paramBoolean)
    {
      this.handler = paramHandler;
      this.brn = paramLong;
      this.brp = parama;
      this.brq = paramBoolean;
    }
    
    public final void run()
    {
      this.brp.rq();
      if (this.brq) {
        this.handler.postDelayed(this, this.brn);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.trace.d.a
 * JD-Core Version:    0.7.0.1
 */