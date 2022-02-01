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
  private g bir;
  private com.google.android.exoplayer2.c.m bky;
  private long boW;
  private f bpA;
  long bpB;
  private long bpC;
  private a bpD;
  private long bpE;
  private boolean bpF;
  private boolean bpG;
  private final d bpz = new d();
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
    this.bpC = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.bir = paramg;
    this.bky = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.bpA.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      U(-(l1 + 2L));
    }
    if (!this.bpF)
    {
      paramk = this.bpA.uH();
      this.bir.a(paramk);
      this.bpF = true;
    }
    if ((this.bpE > 0L) || (this.bpz.k(paramf)))
    {
      this.bpE = 0L;
      paramf = this.bpz.bpj;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.bpC + l1 >= this.boW))
      {
        long l2 = S(this.bpC);
        this.bky.a(paramf, paramf.limit);
        this.bky.a(l2, 1, paramf.limit, 0, null);
        this.boW = -1L;
      }
      this.bpC += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void f(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.bpz;
    locald.boR.reset();
    locald.bpj.reset();
    locald.bpk = -1;
    locald.bpm = false;
    if (paramLong1 == 0L)
    {
      if (!this.bpF) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.boW = this.bpA.R(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.bpz.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.bpE = (paramf.getPosition() - this.bpB);
      boolean bool = a(this.bpz.bpj, this.bpB, this.bpD);
      j = bool;
      if (bool)
      {
        this.bpB = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.bpD.bdF.sampleRate;
    if (!this.bpG)
    {
      this.bky.f(this.bpD.bdF);
      this.bpG = true;
    }
    if (this.bpD.bpA != null) {
      this.bpA = this.bpD.bpA;
    }
    for (;;)
    {
      this.bpD = null;
      this.state = 2;
      paramf = this.bpz;
      if (paramf.bpj.data.length == 65025) {
        break;
      }
      paramf.bpj.data = Arrays.copyOf(paramf.bpj.data, Math.max(65025, paramf.bpj.limit));
      return 0;
      if (paramf.getLength() == -1L)
      {
        this.bpA = new b((byte)0);
      }
      else
      {
        e locale = this.bpz.boR;
        this.bpA = new a(this.bpB, paramf.getLength(), this, locale.bkI + locale.bpu, locale.bpp);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bpD = new a();
      this.bpB = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.boW = -1L;
      this.bpC = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format bdF;
    f bpA;
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
    
    public final l uH()
    {
      AppMethodBeat.i(92166);
      l.a locala = new l.a(-9223372036854775807L);
      AppMethodBeat.o(92166);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.h
 * JD-Core Version:    0.7.0.1
 */