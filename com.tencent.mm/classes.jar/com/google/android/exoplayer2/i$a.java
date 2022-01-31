package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i$a
{
  private final s[] avT;
  final m avU;
  private final r[] avx;
  private final com.google.android.exoplayer2.g.h avy;
  private final com.google.android.exoplayer2.source.i awb;
  public final com.google.android.exoplayer2.source.h awn;
  public final Object awo;
  public final l[] awp;
  public final boolean[] awq;
  public final long awr;
  public n.a aws;
  public boolean awt;
  public a awu;
  public com.google.android.exoplayer2.g.i awv;
  private com.google.android.exoplayer2.g.i aww;
  public final int index;
  public boolean prepared;
  
  public i$a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, com.google.android.exoplayer2.g.h paramh, m paramm, com.google.android.exoplayer2.source.i parami, Object paramObject, int paramInt, n.a parama)
  {
    AppMethodBeat.i(94795);
    this.avx = paramArrayOfr;
    this.avT = paramArrayOfs;
    this.awr = paramLong;
    this.avy = paramh;
    this.avU = paramm;
    this.awb = parami;
    this.awo = a.checkNotNull(paramObject);
    this.index = paramInt;
    this.aws = parama;
    this.awp = new l[paramArrayOfr.length];
    this.awq = new boolean[paramArrayOfr.length];
    paramArrayOfr = parami.a(parama.axf, paramm.mI());
    if (parama.axg != -9223372036854775808L)
    {
      paramArrayOfr = new c(paramArrayOfr, true);
      paramArrayOfr.i(0L, parama.axg);
    }
    for (;;)
    {
      this.awn = paramArrayOfr;
      AppMethodBeat.o(94795);
      return;
    }
  }
  
  public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(94801);
    g localg = this.awv.aYn;
    int i = 0;
    if (i < localg.length)
    {
      boolean[] arrayOfBoolean = this.awq;
      if ((!paramBoolean) && (this.awv.a(this.aww, i))) {}
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[i] = j;
        i += 1;
        break;
      }
    }
    paramLong = this.awn.a(localg.qj(), this.awq, this.awp, paramArrayOfBoolean, paramLong);
    this.aww = this.awv;
    this.awt = false;
    i = 0;
    if (i < this.awp.length)
    {
      if (this.awp[i] != null)
      {
        if (localg.aYk[i] != null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.checkState(paramBoolean);
          this.awt = true;
          i += 1;
          break;
        }
      }
      if (localg.aYk[i] == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a.checkState(paramBoolean);
        break;
      }
    }
    this.avU.a(this.avx, localg);
    AppMethodBeat.o(94801);
    return paramLong;
  }
  
  public final long mT()
  {
    if (this.index == 0) {
      return this.awr;
    }
    return this.awr - this.aws.awy;
  }
  
  public final boolean mU()
  {
    AppMethodBeat.i(94796);
    if ((this.prepared) && ((!this.awt) || (this.awn.oV() == -9223372036854775808L)))
    {
      AppMethodBeat.o(94796);
      return true;
    }
    AppMethodBeat.o(94796);
    return false;
  }
  
  public final boolean mV()
  {
    AppMethodBeat.i(94799);
    com.google.android.exoplayer2.g.i locali = this.avy.a(this.avT, this.awn.oT());
    if (locali.a(this.aww))
    {
      AppMethodBeat.o(94799);
      return false;
    }
    this.awv = locali;
    AppMethodBeat.o(94799);
    return true;
  }
  
  public final boolean q(long paramLong)
  {
    AppMethodBeat.i(94797);
    if (!this.prepared) {}
    for (long l1 = 0L; l1 == -9223372036854775808L; l1 = this.awn.oW())
    {
      AppMethodBeat.o(94797);
      return false;
    }
    long l2 = mT();
    boolean bool = this.avU.q(l1 - (paramLong - l2));
    AppMethodBeat.o(94797);
    return bool;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94802);
    try
    {
      if (this.aws.axg != -9223372036854775808L)
      {
        this.awb.b(((c)this.awn).awn);
        AppMethodBeat.o(94802);
        return;
      }
      this.awb.b(this.awn);
      AppMethodBeat.o(94802);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      AppMethodBeat.o(94802);
    }
  }
  
  public final void u(long paramLong)
  {
    AppMethodBeat.i(94798);
    long l = mT();
    this.awn.Q(paramLong - l);
    AppMethodBeat.o(94798);
  }
  
  public final long v(long paramLong)
  {
    AppMethodBeat.i(94800);
    paramLong = a(paramLong, false, new boolean[this.avx.length]);
    AppMethodBeat.o(94800);
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.i.a
 * JD-Core Version:    0.7.0.1
 */