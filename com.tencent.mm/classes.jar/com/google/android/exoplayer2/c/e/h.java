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
  private g aXn;
  private com.google.android.exoplayer2.c.m aZw;
  private long bdU;
  private long beA;
  private a beB;
  private long beC;
  private boolean beD;
  private boolean beE;
  private final d bex = new d();
  private f bey;
  long bez;
  private int sampleRate;
  int state;
  
  protected final long R(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  protected final long S(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  protected void T(long paramLong)
  {
    this.beA = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.aXn = paramg;
    this.aZw = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.bey.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      T(-(l1 + 2L));
    }
    if (!this.beD)
    {
      paramk = this.bey.sU();
      this.aXn.a(paramk);
      this.beD = true;
    }
    if ((this.beC > 0L) || (this.bex.k(paramf)))
    {
      this.beC = 0L;
      paramf = this.bex.beh;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.beA + l1 >= this.bdU))
      {
        long l2 = R(this.beA);
        this.aZw.a(paramf, paramf.limit);
        this.aZw.a(l2, 1, paramf.limit, 0, null);
        this.bdU = -1L;
      }
      this.beA += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void f(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.bex;
    locald.bdP.reset();
    locald.beh.reset();
    locald.bei = -1;
    locald.bek = false;
    if (paramLong1 == 0L)
    {
      if (!this.beD) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.bdU = this.bey.Q(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.bex.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.beC = (paramf.getPosition() - this.bez);
      boolean bool = a(this.bex.beh, this.bez, this.beB);
      j = bool;
      if (bool)
      {
        this.bez = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.beB.aSv.sampleRate;
    if (!this.beE)
    {
      this.aZw.f(this.beB.aSv);
      this.beE = true;
    }
    if (this.beB.bey != null) {
      this.bey = this.beB.bey;
    }
    for (;;)
    {
      this.beB = null;
      this.state = 2;
      paramf = this.bex;
      if (paramf.beh.data.length == 65025) {
        break;
      }
      paramf.beh.data = Arrays.copyOf(paramf.beh.data, Math.max(65025, paramf.beh.limit));
      return 0;
      if (paramf.getLength() == -1L)
      {
        this.bey = new b((byte)0);
      }
      else
      {
        e locale = this.bex.bdP;
        this.bey = new a(this.bez, paramf.getLength(), this, locale.aZG + locale.bes, locale.ben);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.beB = new a();
      this.bez = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.bdU = -1L;
      this.beA = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
  
  static final class a
  {
    Format aSv;
    f bey;
  }
  
  static final class b
    implements f
  {
    public final long Q(long paramLong)
    {
      return 0L;
    }
    
    public final long i(com.google.android.exoplayer2.c.f paramf)
    {
      return -1L;
    }
    
    public final l sU()
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