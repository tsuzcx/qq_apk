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
  final a bya;
  final boolean byb;
  final long byc;
  final long byd;
  long bye;
  long byf;
  long byg;
  boolean byh;
  long byi;
  long byj;
  long byk;
  
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
      this.byb = bool;
      if (!this.byb) {
        break;
      }
      this.bya = a.vW();
      this.byc = ((1000000000.0D / paramDouble));
      this.byd = (this.byc * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.bya = null;
    this.byc = -1L;
    this.byd = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean m(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.byj;
    if (Math.abs(paramLong2 - this.byi - (paramLong1 - l)) > 20000000L)
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
    private static final a bym;
    public volatile long byl;
    private final HandlerThread byn;
    private int byo;
    private Choreographer choreographer;
    final Handler handler;
    
    static
    {
      AppMethodBeat.i(93305);
      bym = new a();
      AppMethodBeat.o(93305);
    }
    
    private a()
    {
      AppMethodBeat.i(93302);
      this.byn = new HandlerThread("ChoreographerOwner:Handler");
      this.byn.start();
      this.handler = new Handler(this.byn.getLooper(), this);
      this.handler.sendEmptyMessage(0);
      AppMethodBeat.o(93302);
    }
    
    public static a vW()
    {
      return bym;
    }
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(93303);
      this.byl = paramLong;
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
        this.byo += 1;
        if (this.byo == 1) {
          this.choreographer.postFrameCallback(this);
        }
        AppMethodBeat.o(93304);
        return true;
      }
      this.byo -= 1;
      if (this.byo == 0)
      {
        this.choreographer.removeFrameCallback(this);
        this.byl = 0L;
      }
      AppMethodBeat.o(93304);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.video.d
 * JD-Core Version:    0.7.0.1
 */