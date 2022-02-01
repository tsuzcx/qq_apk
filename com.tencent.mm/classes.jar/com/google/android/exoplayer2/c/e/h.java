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
  private g cLR;
  private com.google.android.exoplayer2.c.m cNW;
  private final d cSW = new d();
  private f cSX;
  long cSY;
  private long cSZ;
  private long cSu;
  private a cTa;
  private long cTb;
  private boolean cTc;
  private boolean cTd;
  private int sampleRate;
  int state;
  
  final void C(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.cSW;
    locald.cSp.reset();
    locald.cSG.reset();
    locald.cSH = -1;
    locald.cSJ = false;
    if (paramLong1 == 0L)
    {
      if (!this.cTc) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.cSu = this.cSX.ci(paramLong2);
    this.state = 2;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.cLR = paramg;
    this.cNW = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.cSX.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      cl(-(l1 + 2L));
    }
    if (!this.cTc)
    {
      paramk = this.cSX.Sf();
      this.cLR.a(paramk);
      this.cTc = true;
    }
    if ((this.cTb > 0L) || (this.cSW.k(paramf)))
    {
      this.cTb = 0L;
      paramf = this.cSW.cSG;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.cSZ + l1 >= this.cSu))
      {
        long l2 = cj(this.cSZ);
        this.cNW.a(paramf, paramf.limit);
        this.cNW.a(l2, 1, paramf.limit, 0, null);
        this.cSu = -1L;
      }
      this.cSZ += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  protected final long cj(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  protected final long ck(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  protected void cl(long paramLong)
  {
    this.cSZ = paramLong;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.cSW.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.cTb = (paramf.getPosition() - this.cSY);
      boolean bool = a(this.cSW.cSG, this.cSY, this.cTa);
      j = bool;
      if (bool)
      {
        this.cSY = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.cTa.cHc.sampleRate;
    if (!this.cTd)
    {
      this.cNW.f(this.cTa.cHc);
      this.cTd = true;
    }
    if (this.cTa.cSX != null) {
      this.cSX = this.cTa.cSX;
    }
    for (;;)
    {
      this.cTa = null;
      this.state = 2;
      paramf = this.cSW;
      if (paramf.cSG.data.length == 65025) {
        break;
      }
      paramf.cSG.data = Arrays.copyOf(paramf.cSG.data, Math.max(65025, paramf.cSG.limit));
      return 0;
      if (paramf.RU() == -1L)
      {
        this.cSX = new b((byte)0);
      }
      else
      {
        e locale = this.cSW.cSp;
        this.cSX = new a(this.cSY, paramf.RU(), this, locale.cOg + locale.cSR, locale.cSM);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.cTa = new a();
      this.cSY = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.cSu = -1L;
      this.cSZ = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format cHc;
    f cSX;
  }
  
  static final class b
    implements f
  {
    public final l Sf()
    {
      AppMethodBeat.i(92166);
      l.a locala = new l.a(-9223372036854775807L);
      AppMethodBeat.o(92166);
      return locala;
    }
    
    public final long ci(long paramLong)
    {
      return 0L;
    }
    
    public final long i(com.google.android.exoplayer2.c.f paramf)
    {
      return -1L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.h
 * JD-Core Version:    0.7.0.1
 */