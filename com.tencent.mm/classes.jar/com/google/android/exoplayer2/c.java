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
  private final k avi;
  private final long avj;
  private final long avk;
  private final long avl;
  private final long avm;
  private final p avn;
  private int avo;
  private boolean avp;
  
  public c()
  {
    this(new k());
    AppMethodBeat.i(94746);
    AppMethodBeat.o(94746);
  }
  
  private c(k paramk)
  {
    this(paramk, (byte)0);
  }
  
  private c(k paramk, byte paramByte)
  {
    this(paramk, '\000');
  }
  
  private c(k paramk, char paramChar)
  {
    this.avi = paramk;
    this.avj = 15000000L;
    this.avk = 30000000L;
    this.avl = 2500000L;
    this.avm = 5000000L;
    this.avn = null;
  }
  
  private void reset(boolean paramBoolean)
  {
    AppMethodBeat.i(94752);
    this.avo = 0;
    if ((this.avn != null) && (this.avp)) {
      this.avn.ra();
    }
    this.avp = false;
    if (paramBoolean) {
      this.avi.reset();
    }
    AppMethodBeat.o(94752);
  }
  
  public final void a(r[] paramArrayOfr, g paramg)
  {
    int i = 0;
    AppMethodBeat.i(94748);
    this.avo = 0;
    while (i < paramArrayOfr.length)
    {
      if (paramg.aYk[i] != null) {
        this.avo += x.eu(paramArrayOfr[i].getTrackType());
      }
      i += 1;
    }
    this.avi.ek(this.avo);
    AppMethodBeat.o(94748);
  }
  
  public final boolean c(long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (long l = this.avm; (l <= 0L) || (paramLong >= l); l = this.avl) {
      return true;
    }
    return false;
  }
  
  public final void mG()
  {
    AppMethodBeat.i(94747);
    reset(false);
    AppMethodBeat.o(94747);
  }
  
  public final void mH()
  {
    AppMethodBeat.i(94750);
    reset(true);
    AppMethodBeat.o(94750);
  }
  
  public final b mI()
  {
    return this.avi;
  }
  
  public final void onStopped()
  {
    AppMethodBeat.i(94749);
    reset(true);
    AppMethodBeat.o(94749);
  }
  
  public final boolean q(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(94751);
    int i;
    int j;
    boolean bool1;
    p localp;
    if (paramLong > this.avk)
    {
      i = 0;
      if (this.avi.qp() < this.avo) {
        break label187;
      }
      j = 1;
      boolean bool3 = this.avp;
      if (i != 2)
      {
        bool1 = bool2;
        if (i == 1)
        {
          bool1 = bool2;
          if (this.avp)
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
      this.avp = bool1;
      if ((this.avn != null) && (this.avp != bool3))
      {
        if (!this.avp) {
          break label206;
        }
        localp = this.avn;
      }
    }
    for (;;)
    {
      synchronized (localp.lock)
      {
        localp.bbe.add(Integer.valueOf(0));
        localp.bbf = Math.max(localp.bbf, 0);
        bool1 = this.avp;
        AppMethodBeat.o(94751);
        return bool1;
        if (paramLong < this.avj)
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
      this.avn.ra();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c
 * JD-Core Version:    0.7.0.1
 */