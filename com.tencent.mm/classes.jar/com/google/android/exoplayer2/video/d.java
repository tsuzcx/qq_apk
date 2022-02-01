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
  final a bIo;
  final boolean bIp;
  final long bIq;
  final long bIr;
  long bIs;
  long bIt;
  long bIu;
  boolean bIv;
  long bIw;
  long bIx;
  long bIy;
  
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
      this.bIp = bool;
      if (!this.bIp) {
        break;
      }
      this.bIo = a.xt();
      this.bIq = ((1000000000.0D / paramDouble));
      this.bIr = (this.bIq * 80L / 100L);
      AppMethodBeat.o(93307);
      return;
    }
    this.bIo = null;
    this.bIq = -1L;
    this.bIr = -1L;
    AppMethodBeat.o(93307);
  }
  
  public d(Context paramContext) {}
  
  final boolean m(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(93308);
    long l = this.bIx;
    if (Math.abs(paramLong2 - this.bIw - (paramLong1 - l)) > 20000000L)
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
    private static final a bIA;
    private final HandlerThread bIB;
    private int bIC;
    public volatile long bIz;
    private Choreographer choreographer;
    final Handler handler;
    
    static
    {
      AppMethodBeat.i(93305);
      bIA = new a();
      AppMethodBeat.o(93305);
    }
    
    private a()
    {
      AppMethodBeat.i(93302);
      this.bIB = new HandlerThread("ChoreographerOwner:Handler");
      this.bIB.start();
      this.handler = new Handler(this.bIB.getLooper(), this);
      this.handler.sendEmptyMessage(0);
      AppMethodBeat.o(93302);
    }
    
    public static a xt()
    {
      return bIA;
    }
    
    public final void doFrame(long paramLong)
    {
      AppMethodBeat.i(93303);
      this.bIz = paramLong;
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
        this.bIC += 1;
        if (this.bIC == 1) {
          this.choreographer.postFrameCallback(this);
        }
        AppMethodBeat.o(93304);
        return true;
      }
      this.bIC -= 1;
      if (this.bIC == 0)
      {
        this.choreographer.removeFrameCallback(this);
        this.bIz = 0L;
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