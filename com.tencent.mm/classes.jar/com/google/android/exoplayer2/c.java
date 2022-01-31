package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.j;
import com.google.android.exoplayer2.i.t;
import java.util.PriorityQueue;

public final class c
  implements m
{
  private final j asQ;
  private final long asR;
  private final long asS;
  private final long asT;
  private final long asU;
  private final com.google.android.exoplayer2.i.m asV;
  private int asW;
  private boolean asX;
  
  public c()
  {
    this(new j());
  }
  
  private c(j paramj)
  {
    this(paramj, (byte)0);
  }
  
  private c(j paramj, byte paramByte)
  {
    this(paramj, '\000');
  }
  
  private c(j paramj, char paramChar)
  {
    this.asQ = paramj;
    this.asR = 15000000L;
    this.asS = 30000000L;
    this.asT = 2500000L;
    this.asU = 5000000L;
    this.asV = null;
  }
  
  private void reset(boolean paramBoolean)
  {
    this.asW = 0;
    if ((this.asV != null) && (this.asX)) {
      this.asV.oo();
    }
    this.asX = false;
    if (paramBoolean) {
      this.asQ.reset();
    }
  }
  
  public final void a(r[] paramArrayOfr, f paramf)
  {
    int i = 0;
    this.asW = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramf.aQG[i] != null) {
        this.asW += t.dG(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.asQ.dw(this.asW);
  }
  
  public final boolean c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.asU; (l <= 0L) || (paramLong >= l); l = this.asT) {
      return true;
    }
    return false;
  }
  
  public final void kA()
  {
    reset(false);
  }
  
  public final void kB()
  {
    reset(true);
  }
  
  public final b kC()
  {
    return this.asQ;
  }
  
  public final void onStopped()
  {
    reset(true);
  }
  
  public final boolean s(long paramLong)
  {
    boolean bool2 = false;
    int i;
    int j;
    com.google.android.exoplayer2.i.m localm;
    if (paramLong > this.asS)
    {
      i = 0;
      if (this.asQ.nS() < this.asW) {
        break label173;
      }
      j = 1;
      boolean bool3 = this.asX;
      boolean bool1;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.asX)
          {
            bool1 = bool2;
            if (j != 0) {}
          }
        }
      }
      else
      {
        bool1 = true;
      }
      this.asX = bool1;
      if ((this.asV != null) && (this.asX != bool3))
      {
        if (!this.asX) {
          break label187;
        }
        localm = this.asV;
      }
    }
    for (;;)
    {
      synchronized (localm.lock)
      {
        localm.aSD.add(Integer.valueOf(0));
        localm.aSE = Math.max(localm.aSE, 0);
        return this.asX;
        if (paramLong < this.asR)
        {
          i = 2;
          break;
        }
        i = 1;
        break;
        label173:
        j = 0;
      }
      label187:
      this.asV.oo();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */