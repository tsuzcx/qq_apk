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
  private final k bbN;
  private final long bbO;
  private final long bbP;
  private final long bbQ;
  private final long bbR;
  private final p bbS;
  private int bbT;
  private boolean bbU;
  
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
    this.bbN = paramk;
    this.bbO = (paramInt1 * 1000L);
    this.bbP = (paramInt2 * 1000L);
    this.bbQ = (paramLong1 * 1000L);
    this.bbR = (paramLong2 * 1000L);
    this.bbS = null;
    AppMethodBeat.o(91858);
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(91864);
    this.bbT = 0;
    if ((this.bbS != null) && (this.bbU)) {
      this.bbS.xr();
    }
    this.bbU = false;
    if (paramBoolean) {
      this.bbN.reset();
    }
    AppMethodBeat.o(91864);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(91860);
    this.bbT = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.bED[i] != null) {
        this.bbT += x.fi(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.bbN.eX(this.bbT);
    AppMethodBeat.o(91860);
  }
  
  public final boolean b(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.bbR; (l <= 0L) || (paramLong >= l); l = this.bbQ) {
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
  
  public final void tf()
  {
    AppMethodBeat.i(91859);
    reset(false);
    AppMethodBeat.o(91859);
  }
  
  public final void tg()
  {
    AppMethodBeat.i(91862);
    reset(true);
    AppMethodBeat.o(91862);
  }
  
  public final b th()
  {
    return this.bbN;
  }
  
  public final boolean x(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(91863);
    int i;
    int j;
    boolean bool1;
    p localp;
    if (paramLong > this.bbP)
    {
      i = 0;
      if (this.bbN.wI() < this.bbT) {
        break label187;
      }
      j = 1;
      boolean bool3 = this.bbU;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.bbU)
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
      this.bbU = bool1;
      if ((this.bbS != null) && (this.bbU != bool3))
      {
        if (!this.bbU) {
          break label206;
        }
        localp = this.bbS;
      }
    }
    for (;;)
    {
      synchronized (localp.lock)
      {
        localp.bHs.add(Integer.valueOf(0));
        localp.bHt = Math.max(localp.bHt, 0);
        bool1 = this.bbU;
        AppMethodBeat.o(91863);
        return bool1;
        if (paramLong < this.bbO)
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
      this.bbS.xr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */