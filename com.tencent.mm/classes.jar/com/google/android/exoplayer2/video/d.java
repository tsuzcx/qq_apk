package com.google.android.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

@TargetApi(16)
public final class d
{
  long bAA;
  long bAB;
  long bAC;
  final a bAs;
  final boolean bAt;
  final long bAu;
  final long bAv;
  long bAw;
  long bAx;
  long bAy;
  boolean bAz;
  
  public d()
  {
    this(-1.0D);
  }
  
  private d(double paramDouble)
  {
    AppMethodBeat.i(93307);
    if (paramDouble != -1.0D) {}
    for (boolean bool = true;; bool = false)
    {
      this.bAt = bool;
      if (!this.bAt) {
        break;
      }
      this.bAs = a.wj();
      this.bAu = ((1000000000.0D / paramDouble));
      this.bAv = (this.bAu * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.bAs = null;
    this.bAu = -1L;
    this.bAv = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean p(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.bAB;
    if (Math.abs(paramLong2 - this.bAA - (paramLong1 - l)) > 20000000L)
    {
      AppMethodBeat.o(93308);
      return true;
    }
    AppMethodBeat.o(93308);
    return false;
  }
  
  static final class a
    implements Handler.Callback, Choreographer.FrameCallback
  {
    private static final a bAE;
    public volatile long bAD;
    private final HandlerThread bAF;
    private int bAG;
    private Choreographer choreographer;
    final Handler handler;
    
    static
    {
      AppMethodBeat.i(93305);
      bAE = new a();
      AppMethodBeat.o(93305);
    }
    
    private a()
    {
      AppMethodBeat.i(93302);
      this.bAF = new HandlerThread("ChoreographerOwner:Handler");
      this.bAF.start();
      this.handler = new Handler(this.bAF.getLooper(), this);
      this.handler.sendEmptyMessage(0);
      AppMethodBeat.o(93302);
    }
    
    public static a wj()
    {
      return bAE;
    }
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(93303);
      this.bAD = paramLong;
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
        this.bAG += 1;
        if (this.bAG == 1) {
          this.choreographer.postFrameCallback(this);
        }
        AppMethodBeat.o(93304);
        return true;
      }
      this.bAG -= 1;
      if (this.bAG == 0)
      {
        this.choreographer.removeFrameCallback(this);
        this.bAD = 0L;
      }
      AppMethodBeat.o(93304);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */