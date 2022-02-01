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
  private final k aQA;
  private final long aQB;
  private final long aQC;
  private final long aQD;
  private final long aQE;
  private final p aQF;
  private int aQG;
  private boolean aQH;
  
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
    this.aQA = paramk;
    this.aQB = (paramInt1 * 1000L);
    this.aQC = (paramInt2 * 1000L);
    this.aQD = (paramLong1 * 1000L);
    this.aQE = (paramLong2 * 1000L);
    this.aQF = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.aQG = 0;
    if ((this.aQF != null) && (this.aQH)) {
      this.aQF.vX();
    }
    this.aQH = false;
    if (paramBoolean) {
      this.aQA.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.aQG = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.bwn[i] != null) {
        this.aQG += x.fs(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.aQA.fi(this.aQG);
    AppMethodBeat.o(91860);
  }
  
  public final boolean b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.aQE; (l <= 0L) || (paramLong >= l); l = this.aQD) {
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
  
  public final void rq()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void rr()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b rs()
  {
    return this.aQA;
  }
  
  public final boolean v(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    int j;
    boolean bool1;
    p localp;
    if (paramLong > this.aQC)
    {
      i = 0;
      if (this.aQA.vk() < this.aQG) {
        break label187;
      }
      j = 1;
      boolean bool3 = this.aQH;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.aQH)
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
      this.aQH = bool1;
      if ((this.aQF != null) && (this.aQH != bool3))
      {
        if (!this.aQH) {
          break label206;
        }
        localp = this.aQF;
      }
    }
    for (;;)
    {
      synchronized (localp.lock)
      {
        localp.bzf.add(Integer.valueOf(0));
        localp.bzg = Math.max(localp.bzg, 0);
        bool1 = this.aQH;
        AppMethodBeat.o(91863);
        return bool1;
        if (paramLong < this.aQB)
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
      this.aQF.vX();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */