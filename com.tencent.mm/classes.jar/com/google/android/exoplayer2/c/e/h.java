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
  private g biu;
  private com.google.android.exoplayer2.c.m bkD;
  private final d bpE = new d();
  private f bpF;
  long bpG;
  private long bpH;
  private a bpI;
  private long bpJ;
  private boolean bpK;
  private boolean bpL;
  private long bpb;
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
    this.bpH = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.biu = paramg;
    this.bkD = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.bpF.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      U(-(l1 + 2L));
    }
    if (!this.bpK)
    {
      paramk = this.bpF.uC();
      this.biu.a(paramk);
      this.bpK = true;
    }
    if ((this.bpJ > 0L) || (this.bpE.k(paramf)))
    {
      this.bpJ = 0L;
      paramf = this.bpE.bpo;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.bpH + l1 >= this.bpb))
      {
        long l2 = S(this.bpH);
        this.bkD.a(paramf, paramf.limit);
        this.bkD.a(l2, 1, paramf.limit, 0, null);
        this.bpb = -1L;
      }
      this.bpH += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void f(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.bpE;
    locald.boW.reset();
    locald.bpo.reset();
    locald.bpp = -1;
    locald.bpr = false;
    if (paramLong1 == 0L)
    {
      if (!this.bpK) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.bpb = this.bpF.R(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.bpE.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.bpJ = (paramf.getPosition() - this.bpG);
      boolean bool = a(this.bpE.bpo, this.bpG, this.bpI);
      j = bool;
      if (bool)
      {
        this.bpG = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.bpI.bdI.sampleRate;
    if (!this.bpL)
    {
      this.bkD.f(this.bpI.bdI);
      this.bpL = true;
    }
    if (this.bpI.bpF != null) {
      this.bpF = this.bpI.bpF;
    }
    for (;;)
    {
      this.bpI = null;
      this.state = 2;
      paramf = this.bpE;
      if (paramf.bpo.data.length == 65025) {
        break;
      }
      paramf.bpo.data = Arrays.copyOf(paramf.bpo.data, Math.max(65025, paramf.bpo.limit));
      return 0;
      if (paramf.getLength() == -1L)
      {
        this.bpF = new b((byte)0);
      }
      else
      {
        e locale = this.bpE.boW;
        this.bpF = new a(this.bpG, paramf.getLength(), this, locale.bkN + locale.bpz, locale.bpu);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.bpI = new a();
      this.bpG = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.bpb = -1L;
      this.bpH = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format bdI;
    f bpF;
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
    
    public final l uC()
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