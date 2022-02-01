package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.h.k;
import com.google.android.exoplayer2.i.p;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements m
{
  private final k aLm;
  private final long aLn;
  private final long aLo;
  private final long aLp;
  private final long aLq;
  private final p aLr;
  private int aLs;
  private boolean aLt;
  
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
    this.aLm = paramk;
    this.aLn = (paramInt1 * 1000L);
    this.aLo = (paramInt2 * 1000L);
    this.aLp = (paramLong1 * 1000L);
    this.aLq = (paramLong2 * 1000L);
    this.aLr = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.aLs = 0;
    if ((this.aLr != null) && (this.aLt))
    {
      AppMethodBeat.o(91864);
      throw null;
    }
    this.aLt = false;
    if (paramBoolean) {
      this.aLm.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final boolean A(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    if (paramLong > this.aLo)
    {
      i = 0;
      if (this.aLm.uJ() < this.aLs) {
        break label134;
      }
    }
    label134:
    for (int j = 1;; j = 0)
    {
      boolean bool3 = this.aLt;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.aLt)
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
      this.aLt = bool1;
      if ((this.aLr == null) || (this.aLt == bool3)) {
        break label147;
      }
      if (!this.aLt) {
        break label140;
      }
      AppMethodBeat.o(91863);
      throw null;
      if (paramLong < this.aLn)
      {
        i = 2;
        break;
      }
      i = 1;
      break;
    }
    label140:
    AppMethodBeat.o(91863);
    throw null;
    label147:
    boolean bool1 = this.aLt;
    AppMethodBeat.o(91863);
    return bool1;
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.aLs = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.bof[i] != null) {
        this.aLs += x.fB(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.aLm.fq(this.aLs);
    AppMethodBeat.o(91860);
  }
  
  public final boolean b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.aLq; (l <= 0L) || (paramLong >= l); l = this.aLp) {
      return true;
    }
    return false;
  }
  
  public final void qT()
  {
    AppMethodBeat.i(91861);
    reset(true);
    AppMethodBeat.o(91861);
  }
  
  public final void qX()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void qY()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b qZ()
  {
    return this.aLm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */