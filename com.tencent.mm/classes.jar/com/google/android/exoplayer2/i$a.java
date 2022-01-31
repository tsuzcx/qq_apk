package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.h;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.source.c;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.i;

final class i$a
{
  private final s[] atB;
  final m atC;
  private final com.google.android.exoplayer2.source.f atJ;
  public final e atV;
  public final Object atW;
  public final i[] atX;
  public final boolean[] atY;
  public final long atZ;
  private final r[] atf;
  private final g atg;
  public n.a aua;
  public boolean aub;
  public a auc;
  public h aud;
  private h aue;
  public final int index;
  public boolean prepared;
  
  public i$a(r[] paramArrayOfr, s[] paramArrayOfs, long paramLong, g paramg, m paramm, com.google.android.exoplayer2.source.f paramf, Object paramObject, int paramInt, n.a parama)
  {
    this.atf = paramArrayOfr;
    this.atB = paramArrayOfs;
    this.atZ = paramLong;
    this.atg = paramg;
    this.atC = paramm;
    this.atJ = paramf;
    this.atW = a.E(paramObject);
    this.index = paramInt;
    this.aua = parama;
    this.atX = new i[paramArrayOfr.length];
    this.atY = new boolean[paramArrayOfr.length];
    paramArrayOfr = paramf.a(parama.auN, paramm.kC());
    if (parama.auO != -9223372036854775808L)
    {
      paramArrayOfr = new c(paramArrayOfr);
      paramLong = parama.auO;
      paramArrayOfr.aIe = 0L;
      paramArrayOfr.aIf = paramLong;
    }
    for (;;)
    {
      this.atV = paramArrayOfr;
      return;
    }
  }
  
  public final long a(long paramLong, boolean paramBoolean, boolean[] paramArrayOfBoolean)
  {
    com.google.android.exoplayer2.g.f localf = this.aud.aQJ;
    int i = 0;
    if (i < localf.length)
    {
      boolean[] arrayOfBoolean = this.atY;
      if ((!paramBoolean) && (this.aud.a(this.aue, i))) {}
      for (int j = 1;; j = 0)
      {
        arrayOfBoolean[i] = j;
        i += 1;
        break;
      }
    }
    paramLong = this.atV.a(localf.nL(), this.atY, this.atX, paramArrayOfBoolean, paramLong);
    this.aue = this.aud;
    this.aub = false;
    i = 0;
    if (i < this.atX.length)
    {
      if (this.atX[i] != null)
      {
        if (localf.aQG[i] != null) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a.aC(paramBoolean);
          this.aub = true;
          i += 1;
          break;
        }
      }
      if (localf.aQG[i] == null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a.aC(paramBoolean);
        break;
      }
    }
    this.atC.a(this.atf, localf);
    return paramLong;
  }
  
  public final long kM()
  {
    if (this.index == 0) {
      return this.atZ;
    }
    return this.atZ - this.aua.aug;
  }
  
  public final boolean kN()
  {
    return (this.prepared) && ((!this.aub) || (this.atV.mB() == -9223372036854775808L));
  }
  
  public final boolean kO()
  {
    h localh1 = this.atg.a(this.atB, this.atV.mz());
    h localh2 = this.aue;
    int i;
    if (localh2 == null) {
      i = 0;
    }
    while (i != 0)
    {
      return false;
      i = 0;
      for (;;)
      {
        if (i >= localh1.aQJ.length) {
          break label72;
        }
        if (!localh1.a(localh2, i))
        {
          i = 0;
          break;
        }
        i += 1;
      }
      label72:
      i = 1;
    }
    this.aud = localh1;
    return true;
  }
  
  public final void release()
  {
    try
    {
      if (this.aua.auO != -9223372036854775808L)
      {
        this.atJ.b(((c)this.atV).atV);
        return;
      }
      this.atJ.b(this.atV);
      return;
    }
    catch (RuntimeException localRuntimeException) {}
  }
  
  public final long w(long paramLong)
  {
    return a(paramLong, false, new boolean[this.atf.length]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.i.a
 * JD-Core Version:    0.7.0.1
 */