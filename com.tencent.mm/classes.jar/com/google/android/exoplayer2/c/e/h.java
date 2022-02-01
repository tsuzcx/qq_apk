package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

abstract class h
{
  private g aXZ;
  private com.google.android.exoplayer2.c.m bai;
  private long beG;
  private final d bfj = new d();
  private f bfk;
  long bfl;
  private long bfm;
  private a bfn;
  private long bfo;
  private boolean bfp;
  private boolean bfq;
  private int sampleRate;
  int state;
  
  protected final long S(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  protected final long T(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  protected void U(long paramLong)
  {
    this.bfm = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.aXZ = paramg;
    this.bai = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.bfk.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      U(-(l1 + 2L));
    }
    if (!this.bfp)
    {
      paramk = this.bfk.td();
      this.aXZ.a(paramk);
      this.bfp = true;
    }
    if ((this.bfo > 0L) || (this.bfj.k(paramf)))
    {
      this.bfo = 0L;
      paramf = this.bfj.beT;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.bfm + l1 >= this.beG))
      {
        long l2 = S(this.bfm);
        this.bai.a(paramf, paramf.limit);
        this.bai.a(l2, 1, paramf.limit, 0, null);
        this.beG = -1L;
      }
      this.bfm += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void f(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.bfj;
    locald.beB.reset();
    locald.beT.reset();
    locald.beU = -1;
    locald.beW = false;
    if (paramLong1 == 0L)
    {
      if (!this.bfp) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.beG = this.bfk.R(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.bfj.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.bfo = (paramf.getPosition() - this.bfl);
      boolean bool = a(this.bfj.beT, this.bfl, this.bfn);
      j = bool;
      if (bool)
      {
        this.bfl = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.bfn.aTo.sampleRate;
    if (!this.bfq)
    {
      this.bai.f(this.bfn.aTo);
      this.bfq = true;
    }
    if (this.bfn.bfk != null) {
      this.bfk = this.bfn.bfk;
    }
    for (;;)
    {
      this.bfn = null;
      this.state = 2;
      paramf = this.bfj;
      if (paramf.beT.data.length == 65025) {
        break;
      }
      paramf.beT.data = Arrays.copyOf(paramf.beT.data, Math.max(65025, paramf.beT.limit));
      return 0;
      if (paramf.getLength() == -1L)
      {
        this.bfk = new b((byte)0);
      }
      else
      {
        e locale = this.bfj.beB;
        this.bfk = new a(this.bfl, paramf.getLength(), this, locale.bas + locale.bfe, locale.beZ);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bfn = new a();
      this.bfl = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.beG = -1L;
      this.bfm = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format aTo;
    f bfk;
  }
  
  static final class b
    implements f
  {
    public final long R(long paramLong)
    {
      return 0L;
    }
    
    public final long i(com.google.android.exoplayer2.c.f paramf)
    {
      return -1L;
    }
    
    public final l td()
    {
      AppMethodBeat.i(92166);
      l.a locala = new l.a(-9223372036854775807L);
      AppMethodBeat.o(92166);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.h
 * JD-Core Version:    0.7.0.1
 */