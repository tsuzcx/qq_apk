package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.i.p;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.PriorityQueue;

public final class c
  implements m
{
  private final p aRA;
  private int aRB;
  private boolean aRC;
  private final k aRv;
  private final long aRw;
  private final long aRx;
  private final long aRy;
  private final long aRz;
  
  public c()
  {
    this(new k());
    AppMethodBeat.i(91857);
    AppMethodBeat.o(91857);
  }
  
  public c(k paramk)
  {
    this(paramk, 15000, 30000, 2500L, 5000L);
  }
  
  public c(k paramk, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this(paramk, paramInt1, paramInt2, paramLong1, paramLong2, (byte)0);
  }
  
  private c(k paramk, int paramInt1, int paramInt2, long paramLong1, long paramLong2, byte paramByte)
  {
    AppMethodBeat.i(91858);
    this.aRv = paramk;
    this.aRw = (paramInt1 * 1000L);
    this.aRx = (paramInt2 * 1000L);
    this.aRy = (paramLong1 * 1000L);
    this.aRz = (paramLong2 * 1000L);
    this.aRA = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.aRB = 0;
    if ((this.aRA != null) && (this.aRC)) {
      this.aRA.vM();
    }
    this.aRC = false;
    if (paramBoolean) {
      this.aRv.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.aRB = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.bum[i] != null) {
        this.aRB += x.fe(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.aRv.eU(this.aRB);
    AppMethodBeat.o(91860);
  }
  
  public final boolean b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.aRz; (l <= 0L) || (paramLong >= l); l = this.aRy) {
      return true;
    }
    return false;
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(91861);
    reset(true);
    AppMethodBeat.o(91861);
  }
  
  public final void rB()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void rC()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b rD()
  {
    return this.aRv;
  }
  
  public final boolean x(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    int j;
    boolean bool1;
    p localp;
    if (paramLong > this.aRx)
    {
      i = 0;
      if (this.aRv.vd() < this.aRB) {
        break label187;
      }
      j = 1;
      boolean bool3 = this.aRC;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.aRC)
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
      this.aRC = bool1;
      if ((this.aRA != null) && (this.aRC != bool3))
      {
        if (!this.aRC) {
          break label206;
        }
        localp = this.aRA;
      }
    }
    for (;;)
    {
      synchronized (localp.lock)
      {
        localp.bwN.add(Integer.valueOf(0));
        localp.bwO = Math.max(localp.bwO, 0);
        bool1 = this.aRC;
        AppMethodBeat.o(91863);
        return bool1;
        if (paramLong < this.aRw)
        {
          i = 2;
          break;
        }
        i = 1;
        break;
        label187:
        j = 0;
      }
      label206:
      this.aRA.vM();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */