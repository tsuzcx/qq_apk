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
  private final k cFj;
  private final long cFk;
  private final long cFl;
  private final long cFm;
  private final long cFn;
  private final p cFo;
  private int cFp;
  private boolean cFq;
  
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
    this.cFj = paramk;
    this.cFk = (paramInt1 * 1000L);
    this.cFl = (paramInt2 * 1000L);
    this.cFm = (paramLong1 * 1000L);
    this.cFn = (paramLong2 * 1000L);
    this.cFo = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.cFp = 0;
    if ((this.cFo != null) && (this.cFq))
    {
      AppMethodBeat.o(91864);
      throw null;
    }
    this.cFq = false;
    if (paramBoolean) {
      this.cFj.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final void QA()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b QB()
  {
    return this.cFj;
  }
  
  public final void Qv()
  {
    AppMethodBeat.i(91861);
    reset(true);
    AppMethodBeat.o(91861);
  }
  
  public final void Qz()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.cFp = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.dhY[i] != null) {
        this.cFp += x.iQ(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.cFj.iD(this.cFp);
    AppMethodBeat.o(91860);
  }
  
  public final boolean bO(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    if (paramLong > this.cFl)
    {
      i = 0;
      if (this.cFj.Uk() < this.cFp) {
        break label134;
      }
    }
    label134:
    for (int j = 1;; j = 0)
    {
      boolean bool3 = this.cFq;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.cFq)
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
      this.cFq = bool1;
      if ((this.cFo == null) || (this.cFq == bool3)) {
        break label147;
      }
      if (!this.cFq) {
        break label140;
      }
      AppMethodBeat.o(91863);
      throw null;
      if (paramLong < this.cFk)
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
    boolean bool1 = this.cFq;
    AppMethodBeat.o(91863);
    return bool1;
  }
  
  public final boolean g(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.cFn; (l <= 0L) || (paramLong >= l); l = this.cFm) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */