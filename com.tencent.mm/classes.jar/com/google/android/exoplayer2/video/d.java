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
  final a bso;
  final boolean bsp;
  final long bsq;
  final long bsr;
  long bss;
  long bst;
  long bsu;
  boolean bsv;
  long bsw;
  long bsx;
  long bsy;
  
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
      this.bsp = bool;
      if (!this.bsp) {
        break;
      }
      this.bso = a.vE();
      this.bsq = ((1000000000.0D / paramDouble));
      this.bsr = (this.bsq * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.bso = null;
    this.bsq = -1L;
    this.bsr = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean n(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.bsx;
    if (Math.abs(paramLong2 - this.bsw - (paramLong1 - l)) > 20000000L)
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
    private static final a bsA;
    private final HandlerThread bsB;
    private int bsC;
    public volatile long bsz;
    private Choreographer choreographer;
    final Handler handler;
    
    static
    {
      AppMethodBeat.i(93305);
      bsA = new a();
      AppMethodBeat.o(93305);
    }
    
    private a()
    {
      AppMethodBeat.i(93302);
      this.bsB = new HandlerThread("ChoreographerOwner:Handler");
      this.bsB.start();
      this.handler = new Handler(this.bsB.getLooper(), this);
      this.handler.sendEmptyMessage(0);
      AppMethodBeat.o(93302);
    }
    
    public static a vE()
    {
      return bsA;
    }
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(93303);
      this.bsz = paramLong;
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
        this.bsC += 1;
        if (this.bsC == 1) {
          this.choreographer.postFrameCallback(this);
        }
        AppMethodBeat.o(93304);
        return true;
      }
      this.bsC -= 1;
      if (this.bsC == 0)
      {
        this.choreographer.removeFrameCallback(this);
        this.bsz = 0L;
      }
      AppMethodBeat.o(93304);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */