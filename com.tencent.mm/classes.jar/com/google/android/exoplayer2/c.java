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
  private final k bbQ;
  private final long bbR;
  private final long bbS;
  private final long bbT;
  private final long bbU;
  private final p bbV;
  private int bbW;
  private boolean bbX;
  
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
    this.bbQ = paramk;
    this.bbR = (paramInt1 * 1000L);
    this.bbS = (paramInt2 * 1000L);
    this.bbT = (paramLong1 * 1000L);
    this.bbU = (paramLong2 * 1000L);
    this.bbV = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.bbW = 0;
    if ((this.bbV != null) && (this.bbX)) {
      this.bbV.xj();
    }
    this.bbX = false;
    if (paramBoolean) {
      this.bbQ.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.bbW = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.bEB[i] != null) {
        this.bbW += x.fh(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.bbQ.eY(this.bbW);
    AppMethodBeat.o(91860);
  }
  
  public final boolean b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.bbU; (l <= 0L) || (paramLong >= l); l = this.bbT) {
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
  
  public final void ta()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void tb()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b tc()
  {
    return this.bbQ;
  }
  
  public final boolean x(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    int j;
    boolean bool1;
    p localp;
    if (paramLong > this.bbS)
    {
      i = 0;
      if (this.bbQ.wC() < this.bbW) {
        break label187;
      }
      j = 1;
      boolean bool3 = this.bbX;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.bbX)
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
      this.bbX = bool1;
      if ((this.bbV != null) && (this.bbX != bool3))
      {
        if (!this.bbX) {
          break label206;
        }
        localp = this.bbV;
      }
    }
    for (;;)
    {
      synchronized (localp.lock)
      {
        localp.bHb.add(Integer.valueOf(0));
        localp.bHc = Math.max(localp.bHc, 0);
        bool1 = this.bbX;
        AppMethodBeat.o(91863);
        return bool1;
        if (paramLong < this.bbR)
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
      this.bbV.xj();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */