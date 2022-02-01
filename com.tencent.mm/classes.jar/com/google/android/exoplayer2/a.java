package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;

public abstract class a
  implements r, s
{
  private t cEZ;
  private n cFa;
  private long cFb;
  private boolean cFc;
  private boolean cFd;
  private int index;
  private int state;
  private final int trackType;
  
  public a(int paramInt)
  {
    this.trackType = paramInt;
    this.cFc = true;
  }
  
  public final s Qm()
  {
    return this;
  }
  
  public i Qn()
  {
    return null;
  }
  
  public final n Qo()
  {
    return this.cFa;
  }
  
  public final boolean Qp()
  {
    return this.cFc;
  }
  
  public final void Qq()
  {
    this.cFd = true;
  }
  
  public final boolean Qr()
  {
    return this.cFd;
  }
  
  public final void Qs()
  {
    this.cFa.ST();
  }
  
  public int Qt()
  {
    return 0;
  }
  
  protected void Qu() {}
  
  protected void Qv() {}
  
  protected void Qw() {}
  
  protected final t Qx()
  {
    return this.cEZ;
  }
  
  protected final boolean Qy()
  {
    if (this.cFc) {
      return this.cFd;
    }
    return this.cFa.isReady();
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.cFa.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.Ry())
      {
        this.cFc = true;
        if (this.cFd) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.cFb;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.cHc;
        if (parame.cGY != 9223372036854775807L) {
          paramk.cHc = parame.bU(parame.cGY + this.cFb);
        }
      }
    }
  }
  
  public final void a(t paramt, Format[] paramArrayOfFormat, n paramn, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.cEZ = paramt;
      this.state = 1;
      bu(paramBoolean);
      a(paramArrayOfFormat, paramn, paramLong2);
      f(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, n paramn, long paramLong)
  {
    if (!this.cFd) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.cFa = paramn;
      this.cFc = false;
      this.cFb = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  public final void bK(long paramLong)
  {
    this.cFd = false;
    this.cFc = false;
    f(paramLong, false);
  }
  
  protected final void bL(long paramLong)
  {
    this.cFa.cp(paramLong - this.cFb);
  }
  
  protected void bu(boolean paramBoolean) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 0;
      this.cFa = null;
      this.cFd = false;
      Qw();
      return;
      bool = false;
    }
  }
  
  protected void f(long paramLong, boolean paramBoolean) {}
  
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
      Qu();
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
      Qv();
      return;
    }
  }
  
  public void u(int paramInt, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */