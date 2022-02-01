package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.l;

public abstract class a
  implements r, s
{
  protected t bbH;
  protected l bbI;
  protected long bbJ;
  protected boolean bbK;
  protected boolean bbL;
  protected int index;
  protected int state;
  private final int trackType;
  
  public a(int paramInt)
  {
    this.trackType = paramInt;
    this.bbK = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.bbI.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.tY())
      {
        this.bbK = true;
        if (this.bbL) {
          return -4;
        }
        return -3;
      }
      parame.timeUs += this.bbJ;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.bdI;
        if (parame.bdF != 9223372036854775807L) {
          paramk.bdI = parame.D(parame.bdF + this.bbJ);
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
      this.bbH = paramt;
      this.state = 1;
      aO(paramBoolean);
      a(paramArrayOfFormat, paraml, paramLong2);
      a(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, l paraml, long paramLong)
  {
    if (!this.bbL) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.bbI = paraml;
      this.bbK = false;
      this.bbJ = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  protected void aO(boolean paramBoolean) {}
  
  public void c(int paramInt, Object paramObject) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 0;
      this.bbI = null;
      this.bbL = false;
      sZ();
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
  
  public final s sR()
  {
    return this;
  }
  
  public i sS()
  {
    return null;
  }
  
  public final l sT()
  {
    return this.bbI;
  }
  
  public final boolean sU()
  {
    return this.bbK;
  }
  
  public final void sV()
  {
    this.bbL = true;
  }
  
  public final boolean sW()
  {
    return this.bbL;
  }
  
  public final void sX()
  {
    this.bbI.vm();
  }
  
  public int sY()
  {
    return 0;
  }
  
  protected void sZ() {}
  
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
    this.bbL = false;
    this.bbK = false;
    a(paramLong, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */