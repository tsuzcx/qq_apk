package com.google.android.exoplayer2.i;

import android.os.SystemClock;
import com.google.android.exoplayer2.b;
import com.google.android.exoplayer2.p;

public final class o
  implements f
{
  private long aSO;
  public long aSP;
  private p atv = p.auS;
  public boolean started;
  
  public final void R(long paramLong)
  {
    this.aSO = paramLong;
    if (this.started) {
      this.aSP = SystemClock.elapsedRealtime();
    }
  }
  
  public final void a(f paramf)
  {
    R(paramf.lo());
    this.atv = paramf.lv();
  }
  
  public final p b(p paramp)
  {
    if (this.started) {
      R(lo());
    }
    this.atv = paramp;
    return paramp;
  }
  
  public final long lo()
  {
    long l2 = this.aSO;
    long l1 = l2;
    if (this.started)
    {
      l1 = SystemClock.elapsedRealtime() - this.aSP;
      if (this.atv.auT == 1.0F) {
        l1 = l2 + b.r(l1);
      }
    }
    else
    {
      return l1;
    }
    return l2 + l1 * this.atv.auU;
  }
  
  public final p lv()
  {
    return this.atv;
  }
  
  public final void stop()
  {
    if (this.started)
    {
      R(lo());
      this.started = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.i.o
 * JD-Core Version:    0.7.0.1
 */