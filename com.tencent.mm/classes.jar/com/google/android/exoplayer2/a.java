package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.l;

public abstract class a
  implements r, s
{
  protected t aRm;
  protected l aRn;
  protected long aRo;
  protected boolean aRp;
  protected boolean aRq;
  protected int index;
  protected int state;
  private final int trackType;
  
  public a(int paramInt)
  {
    this.trackType = paramInt;
    this.aRp = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.aRn.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.sz())
      {
        this.aRp = true;
        if (this.aRq) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.aRo;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.aTo;
        if (parame.aTk != 9223372036854775807L) {
          paramk.aTo = parame.D(parame.aTk + this.aRo);
        }
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  public final void a(t paramt, Format[] paramArrayOfFormat, l paraml, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aRm = paramt;
      this.state = 1;
      aN(paramBoolean);
      a(paramArrayOfFormat, paraml, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, l paraml, long paramLong)
  {
    if (!this.aRq) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aRn = paraml;
      this.aRp = false;
      this.aRo = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  protected void aN(boolean paramBoolean) {}
  
  public void c(int paramInt, Object paramObject) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 0;
      this.aRn = null;
      this.aRq = false;
      rA();
      return;
      bool = false;
    }
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public final int getTrackType()
  {
    return this.trackType;
  }
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  protected void rA() {}
  
  public final s rs()
  {
    return this;
  }
  
  public i rt()
  {
    return null;
  }
  
  public final l ru()
  {
    return this.aRn;
  }
  
  public final boolean rv()
  {
    return this.aRp;
  }
  
  public final void rw()
  {
    this.aRq = true;
  }
  
  public final boolean rx()
  {
    return this.aRq;
  }
  
  public final void ry()
  {
    this.aRn.tN();
  }
  
  public int rz()
  {
    return 0;
  }
  
  public final void setIndex(int paramInt)
  {
    this.index = paramInt;
  }
  
  public final void start()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 2;
      onStarted();
      return;
      bool = false;
    }
  }
  
  public final void stop()
  {
    if (this.state == 2) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 1;
      onStopped();
      return;
    }
  }
  
  public final void u(long paramLong)
  {
    this.aRq = false;
    this.aRp = false;
    a(paramLong, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */