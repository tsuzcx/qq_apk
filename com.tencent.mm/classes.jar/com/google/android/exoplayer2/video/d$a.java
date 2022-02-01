package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d$a
  implements Handler.Callback, Choreographer.FrameCallback
{
  private static final a bIQ;
  public volatile long bIP;
  private final HandlerThread bIR;
  private int bIS;
  private Choreographer choreographer;
  final Handler handler;
  
  static
  {
    AppMethodBeat.i(93305);
    bIQ = new a();
    AppMethodBeat.o(93305);
  }
  
  private d$a()
  {
    AppMethodBeat.i(93302);
    this.bIR = new HandlerThread("ChoreographerOwner:Handler");
    this.bIR.start();
    this.handler = new Handler(this.bIR.getLooper(), this);
    this.handler.sendEmptyMessage(0);
    AppMethodBeat.o(93302);
  }
  
  public static a xB()
  {
    return bIQ;
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(93303);
    this.bIP = paramLong;
    this.choreographer.postFrameCallbackDelayed(this, 500L);
    AppMethodBeat.o(93303);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(93304);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(93304);
      return false;
    case 0: 
      this.choreographer = Choreographer.getInstance();
      AppMethodBeat.o(93304);
      return true;
    case 1: 
      this.bIS += 1;
      if (this.bIS == 1) {
        this.choreographer.postFrameCallback(this);
      }
      AppMethodBeat.o(93304);
      return true;
    }
    this.bIS -= 1;
    if (this.bIS == 0)
    {
      this.choreographer.removeFrameCallback(this);
      this.bIP = 0L;
    }
    AppMethodBeat.o(93304);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d.a
 * JD-Core Version:    0.7.0.1
 */