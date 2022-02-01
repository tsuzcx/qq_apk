package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.m;

public abstract class a
  implements r, s
{
  private final int aQq;
  protected t aQr;
  protected m aQs;
  protected long aQt;
  protected boolean aQu;
  protected boolean aQv;
  protected int index;
  protected int state;
  
  public a(int paramInt)
  {
    this.aQq = paramInt;
    this.aQu = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.aQs.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.sq())
      {
        this.aQu = true;
        if (this.aQv) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.aQt;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.aSv;
        if (parame.aSr != 9223372036854775807L) {
          paramk.aSv = parame.B(parame.aSr + this.aQt);
        }
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean) {}
  
  public final void a(t paramt, Format[] paramArrayOfFormat, m paramm, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aQr = paramt;
      this.state = 1;
      aN(paramBoolean);
      a(paramArrayOfFormat, paramm, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, m paramm, long paramLong)
  {
    if (!this.aQv) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.aQs = paramm;
      this.aQu = false;
      this.aQt = paramLong;
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
      this.aQs = null;
      this.aQv = false;
      rp();
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
    return this.aQq;
  }
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
  public final s rh()
  {
    return this;
  }
  
  public i ri()
  {
    return null;
  }
  
  public final m rj()
  {
    return this.aQs;
  }
  
  public final boolean rk()
  {
    return this.aQu;
  }
  
  public final void rl()
  {
    this.aQv = true;
  }
  
  public final boolean rm()
  {
    return this.aQv;
  }
  
  public final void rn()
  {
    this.aQs.tF();
  }
  
  public int ro()
  {
    return 0;
  }
  
  protected void rp() {}
  
  public final void s(long paramLong)
  {
    this.aQv = false;
    this.aQu = false;
    a(paramLong, false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */