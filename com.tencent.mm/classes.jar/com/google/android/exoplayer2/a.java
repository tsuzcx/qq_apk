package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.n;

public abstract class a
  implements r, s
{
  protected t bbE;
  protected n bbF;
  protected long bbG;
  protected boolean bbH;
  protected boolean bbI;
  protected int index;
  protected int state;
  private final int trackType;
  
  public a(int paramInt)
  {
    this.trackType = paramInt;
    this.bbH = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.bbF.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.ud())
      {
        this.bbH = true;
        if (this.bbI) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.bbG;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.bdF;
        if (parame.bdC != 9223372036854775807L) {
          paramk.bdF = parame.D(parame.bdC + this.bbG);
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
      this.bbE = paramt;
      this.state = 1;
      aN(paramBoolean);
      a(paramArrayOfFormat, paramn, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, n paramn, long paramLong)
  {
    if (!this.bbI) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bbF = paramn;
      this.bbH = false;
      this.bbG = paramLong;
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
      this.bbF = null;
      this.bbI = false;
      te();
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
  
  public final s sW()
  {
    return this;
  }
  
  public i sX()
  {
    return null;
  }
  
  public final n sY()
  {
    return this.bbF;
  }
  
  public final boolean sZ()
  {
    return this.bbH;
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
  
  public final void ta()
  {
    this.bbI = true;
  }
  
  public final boolean tb()
  {
    return this.bbI;
  }
  
  public final void tc()
  {
    this.bbF.vs();
  }
  
  public int td()
  {
    return 0;
  }
  
  protected void te() {}
  
  public final void u(long paramLong)
  {
    this.bbI = false;
    this.bbH = false;
    a(paramLong, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */