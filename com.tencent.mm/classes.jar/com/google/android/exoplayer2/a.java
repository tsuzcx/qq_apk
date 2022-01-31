package com.google.android.exoplayer2;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.source.i;

public abstract class a
  implements r, s
{
  private final int asG;
  public t asH;
  public i asI;
  public long asJ;
  public boolean asK;
  public boolean asL;
  public int index;
  public int state;
  
  public a(int paramInt)
  {
    this.asG = paramInt;
    this.asK = true;
  }
  
  public final int a(k paramk, e parame, boolean paramBoolean)
  {
    int i = this.asI.b(paramk, parame, paramBoolean);
    if (i == -4)
    {
      if (parame.lz())
      {
        this.asK = true;
        if (this.asL) {
          return -4;
        }
        return -3;
      }
      parame.ayE += this.asJ;
    }
    for (;;)
    {
      return i;
      if (i == -5)
      {
        parame = paramk.auL;
        if (parame.auG != 9223372036854775807L) {
          paramk.auL = parame.x(parame.auG + this.asJ);
        }
      }
    }
  }
  
  public final void a(t paramt, Format[] paramArrayOfFormat, i parami, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.state == 0) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.asH = paramt;
      this.state = 1;
      as(paramBoolean);
      a(paramArrayOfFormat, parami, paramLong2);
      b(paramLong1, paramBoolean);
      return;
    }
  }
  
  public void a(Format[] paramArrayOfFormat, long paramLong) {}
  
  public final void a(Format[] paramArrayOfFormat, i parami, long paramLong)
  {
    if (!this.asL) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.asI = parami;
      this.asK = false;
      this.asJ = paramLong;
      a(paramArrayOfFormat, paramLong);
      return;
    }
  }
  
  public void as(boolean paramBoolean) {}
  
  public void b(long paramLong, boolean paramBoolean) {}
  
  public void d(int paramInt, Object paramObject) {}
  
  public final void disable()
  {
    boolean bool = true;
    if (this.state == 1) {}
    for (;;)
    {
      com.google.android.exoplayer2.i.a.aC(bool);
      this.state = 0;
      this.asI = null;
      this.asL = false;
      kz();
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
    return this.asG;
  }
  
  public final s kr()
  {
    return this;
  }
  
  public f ks()
  {
    return null;
  }
  
  public final i kt()
  {
    return this.asI;
  }
  
  public final boolean ku()
  {
    return this.asK;
  }
  
  public final void kv()
  {
    this.asL = true;
  }
  
  public final boolean kw()
  {
    return this.asL;
  }
  
  public final void kx()
  {
    this.asI.mD();
  }
  
  public int ky()
  {
    return 0;
  }
  
  public void kz() {}
  
  public void onStarted() {}
  
  public void onStopped() {}
  
  public final void p(long paramLong)
  {
    this.asL = false;
    this.asK = false;
    b(paramLong, false);
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
      com.google.android.exoplayer2.i.a.aC(bool);
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
      com.google.android.exoplayer2.i.a.aC(bool);
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