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
  private static final a bcE;
  public volatile long bcD;
  private final HandlerThread bcF;
  private int bcG;
  private Choreographer choreographer;
  final Handler handler;
  
  static
  {
    AppMethodBeat.i(96034);
    bcE = new a();
    AppMethodBeat.o(96034);
  }
  
  private d$a()
  {
    AppMethodBeat.i(96031);
    this.bcF = new HandlerThread("ChoreographerOwner:Handler");
    this.bcF.start();
    this.handler = new Handler(this.bcF.getLooper(), this);
    this.handler.sendEmptyMessage(0);
    AppMethodBeat.o(96031);
  }
  
  public static a rk()
  {
    return bcE;
  }
  
  public final void doFrame(long paramLong)
  {
    AppMethodBeat.i(96032);
    this.bcD = paramLong;
    this.choreographer.postFrameCallbackDelayed(this, 500L);
    AppMethodBeat.o(96032);
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(96033);
    switch (paramMessage.what)
    {
    default: 
      AppMethodBeat.o(96033);
      return false;
    case 0: 
      this.choreographer = Choreographer.getInstance();
      AppMethodBeat.o(96033);
      return true;
    case 1: 
      this.bcG += 1;
      if (this.bcG == 1) {
        this.choreographer.postFrameCallback(this);
      }
      AppMethodBeat.o(96033);
      return true;
    }
    this.bcG -= 1;
    if (this.bcG == 0)
    {
      this.choreographer.removeFrameCallback(this);
      this.bcD = 0L;
    }
    AppMethodBeat.o(96033);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d.a
 * JD-Core Version:    0.7.0.1
 */