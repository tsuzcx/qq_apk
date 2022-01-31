package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

final class d$a
  implements Handler.Callback, Choreographer.FrameCallback
{
  private static final a aUg = new a();
  public volatile long aUf;
  private final HandlerThread aUh = new HandlerThread("ChoreographerOwner:Handler");
  private Choreographer aUi;
  private int aUj;
  final Handler handler;
  
  private d$a()
  {
    this.aUh.start();
    this.handler = new Handler(this.aUh.getLooper(), this);
    this.handler.sendEmptyMessage(0);
  }
  
  public static a oy()
  {
    return aUg;
  }
  
  public final void doFrame(long paramLong)
  {
    this.aUf = paramLong;
    this.aUi.postFrameCallbackDelayed(this, 500L);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    boolean bool = true;
    switch (paramMessage.what)
    {
    default: 
      bool = false;
    }
    do
    {
      do
      {
        return bool;
        this.aUi = Choreographer.getInstance();
        return true;
        this.aUj += 1;
      } while (this.aUj != 1);
      this.aUi.postFrameCallback(this);
      return true;
      this.aUj -= 1;
    } while (this.aUj != 0);
    this.aUi.removeFrameCallback(this);
    this.aUf = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d.a
 * JD-Core Version:    0.7.0.1
 */