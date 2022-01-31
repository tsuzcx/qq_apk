package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.source.l;

public abstract class a
  implements r, s
{
  private final int auX;
  protected t auY;
  protected l auZ;
  protected long ava;
  protected boolean avb;
  protected boolean avc;
  protected int index;
  protected int state;
  
  public a(int paramInt)
  {
    this.auX = paramInt;
    this.avb = true;
  }
  
  protected final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.auZ.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.nE())
      {
        this.avb = true;
        if (this.avc) {
          return -4;
        }
        return -3;
      }
      parame.aAT += this.ava;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.axd;
        if (parame.awY != 9223372036854775807L) {
          paramk.axd = parame.w(parame.awY + this.ava);
        }
      }
    }
  }
  
  public final void a(t paramt, Format[] paramArrayOfFormat, l paraml, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.auY = paramt;
      this.state = 1;
      aB(paramBoolean);
      a(paramArrayOfFormat, paraml, paramLong2);
      b(paramLong1, paramBoolean);
      return;
    }
  }
  
  protected void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, l paraml, long paramLong)
  {
    if (!this.avc) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.auZ = paraml;
      this.avb = false;
      this.ava = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  protected void aB(boolean paramBoolean) {}
  
  protected void b(long paramLong, boolean paramBoolean) {}
  
  public void d(int paramInt, Object paramObject) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      this.state = 0;
      this.auZ = null;
      this.avc = false;
      mF();
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
    return this.auX;
  }
  
  public final boolean mA()
  {
    return this.avb;
  }
  
  public final void mB()
  {
    this.avc = true;
  }
  
  public final boolean mC()
  {
    return this.avc;
  }
  
  public final void mD()
  {
    this.auZ.oX();
  }
  
  public int mE()
  {
    return 0;
  }
  
  protected void mF() {}
  
  public final s mx()
  {
    return this;
  }
  
  public i my()
  {
    return null;
  }
  
  public final l mz()
  {
    return this.auZ;
  }
  
  public final void n(long paramLong)
  {
    this.avc = false;
    this.avb = false;
    b(paramLong, false);
  }
  
  protected void onStarted() {}
  
  protected void onStopped() {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a
 * JD-Core Version:    0.7.0.1
 */