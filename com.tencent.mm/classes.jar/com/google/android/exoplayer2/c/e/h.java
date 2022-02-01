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
  private g aRV;
  private com.google.android.exoplayer2.c.m aUa;
  private long aYy;
  private final d aZb = new d();
  private f aZc;
  long aZd;
  private long aZe;
  private a aZf;
  private long aZg;
  private boolean aZh;
  private boolean aZi;
  private int sampleRate;
  int state;
  
  protected final long V(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  protected final long W(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  protected void X(long paramLong)
  {
    this.aZe = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.aRV = paramg;
    this.aUa = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.aZc.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      X(-(l1 + 2L));
    }
    if (!this.aZh)
    {
      paramk = this.aZc.sC();
      this.aRV.a(paramk);
      this.aZh = true;
    }
    if ((this.aZg > 0L) || (this.aZb.k(paramf)))
    {
      this.aZg = 0L;
      paramf = this.aZb.aYL;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.aZe + l1 >= this.aYy))
      {
        long l2 = V(this.aZe);
        this.aUa.a(paramf, paramf.limit);
        this.aUa.a(l2, 1, paramf.limit, 0, null);
        this.aYy = -1L;
      }
      this.aZe += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void g(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.aZb;
    locald.aYt.reset();
    locald.aYL.reset();
    locald.aYM = -1;
    locald.aYO = false;
    if (paramLong1 == 0L)
    {
      if (!this.aZh) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.aYy = this.aZc.U(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.aZb.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.aZg = (paramf.getPosition() - this.aZd);
      boolean bool = a(this.aZb.aYL, this.aZd, this.aZf);
      j = bool;
      if (bool)
      {
        this.aZd = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.aZf.aNg.sampleRate;
    if (!this.aZi)
    {
      this.aUa.f(this.aZf.aNg);
      this.aZi = true;
    }
    if (this.aZf.aZc != null) {
      this.aZc = this.aZf.aZc;
    }
    for (;;)
    {
      this.aZf = null;
      this.state = 2;
      paramf = this.aZb;
      if (paramf.aYL.data.length == 65025) {
        break;
      }
      paramf.aYL.data = Arrays.copyOf(paramf.aYL.data, Math.max(65025, paramf.aYL.limit));
      return 0;
      if (paramf.sr() == -1L)
      {
        this.aZc = new b((byte)0);
      }
      else
      {
        e locale = this.aZb.aYt;
        this.aZc = new a(this.aZd, paramf.sr(), this, locale.aUk + locale.aYW, locale.aYR);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aZf = new a();
      this.aZd = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.aYy = -1L;
      this.aZe = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format aNg;
    f aZc;
  }
  
  static final class b
    implements f
  {
    public final long U(long paramLong)
    {
      return 0L;
    }
    
    public final long i(com.google.android.exoplayer2.c.f paramf)
    {
      return -1L;
    }
    
    public final l sC()
    {
      AppMethodBeat.i(92166);
      l.a locala = new l.a(-9223372036854775807L);
      AppMethodBeat.o(92166);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.h
 * JD-Core Version:    0.7.0.1
 */