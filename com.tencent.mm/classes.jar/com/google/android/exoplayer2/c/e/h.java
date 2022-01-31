package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import java.util.Arrays;

abstract class h
{
  private g aBV;
  private com.google.android.exoplayer2.c.m aEe;
  private long aIC;
  private final d aJe = new d();
  private f aJf;
  long aJg;
  private long aJh;
  private h.a aJi;
  private long aJj;
  private boolean aJk;
  private boolean aJl;
  private int sampleRate;
  int state;
  
  protected final long L(long paramLong)
  {
    return 1000000L * paramLong / this.sampleRate;
  }
  
  protected final long M(long paramLong)
  {
    return this.sampleRate * paramLong / 1000000L;
  }
  
  protected void N(long paramLong)
  {
    this.aJh = paramLong;
  }
  
  final void a(g paramg, com.google.android.exoplayer2.c.m paramm)
  {
    this.aBV = paramg;
    this.aEe = paramm;
    reset(true);
  }
  
  protected abstract boolean a(com.google.android.exoplayer2.i.m paramm, long paramLong, h.a parama);
  
  final int b(com.google.android.exoplayer2.c.f paramf, k paramk)
  {
    long l1 = this.aJf.i(paramf);
    if (l1 >= 0L)
    {
      paramk.position = l1;
      return 1;
    }
    if (l1 < -1L) {
      N(-(l1 + 2L));
    }
    if (!this.aJk)
    {
      paramk = this.aJf.oi();
      this.aBV.a(paramk);
      this.aJk = true;
    }
    if ((this.aJj > 0L) || (this.aJe.k(paramf)))
    {
      this.aJj = 0L;
      paramf = this.aJe.aIP;
      l1 = s(paramf);
      if ((l1 >= 0L) && (this.aJh + l1 >= this.aIC))
      {
        long l2 = L(this.aJh);
        this.aEe.a(paramf, paramf.limit);
        this.aEe.a(l2, 1, paramf.limit, 0, null);
        this.aIC = -1L;
      }
      this.aJh += l1;
      return 0;
    }
    this.state = 3;
    return -1;
  }
  
  final void g(long paramLong1, long paramLong2)
  {
    boolean bool = false;
    d locald = this.aJe;
    locald.aIx.reset();
    locald.aIP.reset();
    locald.aIQ = -1;
    locald.aIR = false;
    if (paramLong1 == 0L)
    {
      if (!this.aJk) {
        bool = true;
      }
      reset(bool);
    }
    while (this.state == 0) {
      return;
    }
    this.aIC = this.aJf.K(paramLong2);
    this.state = 2;
  }
  
  final int l(com.google.android.exoplayer2.c.f paramf)
  {
    int i = 0;
    int j = 1;
    while (j != 0)
    {
      if (!this.aJe.k(paramf))
      {
        this.state = 3;
        i = -1;
        return i;
      }
      this.aJj = (paramf.getPosition() - this.aJg);
      boolean bool = a(this.aJe.aIP, this.aJg, this.aJi);
      j = bool;
      if (bool)
      {
        this.aJg = paramf.getPosition();
        j = bool;
      }
    }
    this.sampleRate = this.aJi.axd.sampleRate;
    if (!this.aJl)
    {
      this.aEe.f(this.aJi.axd);
      this.aJl = true;
    }
    if (this.aJi.aJf != null) {
      this.aJf = this.aJi.aJf;
    }
    for (;;)
    {
      this.aJi = null;
      this.state = 2;
      paramf = this.aJe;
      if (paramf.aIP.data.length == 65025) {
        break;
      }
      paramf.aIP.data = Arrays.copyOf(paramf.aIP.data, Math.max(65025, paramf.aIP.limit));
      return 0;
      if (paramf.getLength() == -1L)
      {
        this.aJf = new h.b((byte)0);
      }
      else
      {
        e locale = this.aJe.aIx;
        this.aJf = new a(this.aJg, paramf.getLength(), this, locale.aEo + locale.aIZ, locale.aIU);
      }
    }
  }
  
  protected void reset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.aJi = new h.a();
      this.aJg = 0L;
    }
    for (this.state = 0;; this.state = 1)
    {
      this.aIC = -1L;
      this.aJh = 0L;
      return;
    }
  }
  
  protected abstract long s(com.google.android.exoplayer2.i.m paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.e.h
 * JD-Core Version:    0.7.0.1
 */