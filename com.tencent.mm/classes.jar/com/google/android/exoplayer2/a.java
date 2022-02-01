package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;

public abstract class a
  implements r, s
{
  private t aLc;
  private n aLd;
  private long aLe;
  private boolean aLf;
  private boolean aLg;
  private int index;
  private int state;
  private final int trackType;
  
  public a(int paramInt)
  {
    this.trackType = paramInt;
    this.aLf = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.aLd.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.rV())
      {
        this.aLf = true;
        if (this.aLg) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.aLe;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.aNg;
        if (parame.aNc != 9223372036854775807L) {
          paramk.aNg = parame.G(parame.aNc + this.aLe);
        }
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  public final void a(t paramt, Format[] paramArrayOfFormat, n paramn, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aLc = paramt;
      this.state = 1;
      aL(paramBoolean);
      a(paramArrayOfFormat, paramn, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, n paramn, long paramLong)
  {
    if (!this.aLg) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aLd = paramn;
      this.aLf = false;
      this.aLe = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  protected void aL(boolean paramBoolean) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 0;
      this.aLd = null;
      this.aLg = false;
      qU();
      return;
      bool = false;
    }
  }
  
  public void e(int paramInt, Object paramObject) {}
  
  protected final int getIndex()
  {
    return this.index;
  }
  
  public final int getState()
  {
    return this.state;
  }
  
  public final int getTrackType()
  {
    return this.trackType;
  }
  
  public final s qK()
  {
    return this;
  }
  
  public i qL()
  {
    return null;
  }
  
  public final n qM()
  {
    return this.aLd;
  }
  
  public final boolean qN()
  {
    return this.aLf;
  }
  
  public final void qO()
  {
    this.aLg = true;
  }
  
  public final boolean qP()
  {
    return this.aLg;
  }
  
  public final void qQ()
  {
    this.aLd.tq();
  }
  
  public int qR()
  {
    return 0;
  }
  
  protected void qS() {}
  
  protected void qT() {}
  
  protected void qU() {}
  
  protected final t qV()
  {
    return this.aLc;
  }
  
  protected final boolean qW()
  {
    if (this.aLf) {
      return this.aLg;
    }
    return this.aLd.isReady();
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
      qS();
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
      qT();
      return;
    }
  }
  
  public final void w(long paramLong)
  {
    this.aLg = false;
    this.aLf = false;
    a(paramLong, false);
  }
  
  protected final void x(long paramLong)
  {
    this.aLd.ab(paramLong - this.aLe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */