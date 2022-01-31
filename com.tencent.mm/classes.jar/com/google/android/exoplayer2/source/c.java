package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.g;

public final class c
  implements e, e.a
{
  private e.a aId;
  public long aIe;
  public long aIf;
  private c.a[] aIg;
  private boolean aIh;
  public final e atV;
  
  public c(e parame)
  {
    this.atV = parame;
    this.aIe = -9223372036854775807L;
    this.aIf = -9223372036854775807L;
    this.aIg = new c.a[0];
    this.aIh = true;
  }
  
  public final void H(long paramLong)
  {
    this.atV.H(this.aIe + paramLong);
  }
  
  public final long I(long paramLong)
  {
    boolean bool2 = false;
    c.a[] arrayOfa = this.aIg;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      c.a locala = arrayOfa[i];
      if (locala != null) {
        locala.aIj = false;
      }
      i += 1;
    }
    long l = this.atV.I(this.aIe + paramLong);
    if (l != this.aIe + paramLong)
    {
      bool1 = bool2;
      if (l < this.aIe) {
        break label117;
      }
      if (this.aIf != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.aIf) {
          break label117;
        }
      }
    }
    boolean bool1 = true;
    label117:
    a.aC(bool1);
    return l - this.aIe;
  }
  
  public final boolean J(long paramLong)
  {
    return this.atV.J(this.aIe + paramLong);
  }
  
  public final long a(com.google.android.exoplayer2.g.e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, i[] paramArrayOfi, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.aIg = new c.a[paramArrayOfi.length];
    i[] arrayOfi = new i[paramArrayOfi.length];
    int i = 0;
    if (i < paramArrayOfi.length)
    {
      this.aIg[i] = ((c.a)paramArrayOfi[i]);
      if (this.aIg[i] != null) {}
      for (i locali = this.aIg[i].asI;; locali = null)
      {
        arrayOfi[i] = locali;
        i += 1;
        break;
      }
    }
    long l = this.atV.a(paramArrayOfe, paramArrayOfBoolean1, arrayOfi, paramArrayOfBoolean2, paramLong + this.aIe);
    label165:
    boolean bool;
    if (this.aIh)
    {
      if (this.aIe == 0L) {
        break label292;
      }
      int j = paramArrayOfe.length;
      i = 0;
      if (i >= j) {
        break label286;
      }
      paramArrayOfBoolean1 = paramArrayOfe[i];
      if ((paramArrayOfBoolean1 != null) && (!g.av(paramArrayOfBoolean1.nI().aus)))
      {
        i = 1;
        if (i == 0) {
          break label292;
        }
        bool = true;
        label173:
        this.aIh = bool;
      }
    }
    else
    {
      if ((l != this.aIe + paramLong) && ((l < this.aIe) || ((this.aIf != -9223372036854775808L) && (l > this.aIf)))) {
        break label298;
      }
      bool = true;
      label226:
      a.aC(bool);
      i = 0;
      label234:
      if (i >= paramArrayOfi.length) {
        break label364;
      }
      if (arrayOfi[i] != null) {
        break label304;
      }
      this.aIg[i] = null;
    }
    for (;;)
    {
      paramArrayOfi[i] = this.aIg[i];
      i += 1;
      break label234;
      i += 1;
      break;
      label286:
      i = 0;
      break label165;
      label292:
      bool = false;
      break label173;
      label298:
      bool = false;
      break label226;
      label304:
      if ((paramArrayOfi[i] == null) || (this.aIg[i].asI != arrayOfi[i])) {
        this.aIg[i] = new c.a(this, arrayOfi[i], this.aIe, this.aIf, this.aIh);
      }
    }
    label364:
    return l - this.aIe;
  }
  
  public final void a(e.a parama, long paramLong)
  {
    this.aId = parama;
    this.atV.a(this, this.aIe + paramLong);
  }
  
  public final void a(e parame)
  {
    if ((this.aIe != -9223372036854775807L) && (this.aIf != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.aC(bool);
      this.aId.a(this);
      return;
    }
  }
  
  public final long mA()
  {
    boolean bool2 = false;
    if (this.aIh)
    {
      c.a[] arrayOfa = this.aIg;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        c.a locala = arrayOfa[i];
        if (locala != null) {
          locala.aIi = false;
        }
        i += 1;
      }
      this.aIh = false;
      l = mA();
      if (l != -9223372036854775807L) {
        return l;
      }
      return 0L;
    }
    long l = this.atV.mA();
    if (l == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    if (l >= this.aIe) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.aC(bool1);
      if (this.aIf != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.aIf) {}
      }
      else
      {
        bool1 = true;
      }
      a.aC(bool1);
      return l - this.aIe;
    }
  }
  
  public final long mB()
  {
    long l = this.atV.mB();
    if ((l == -9223372036854775808L) || ((this.aIf != -9223372036854775808L) && (l >= this.aIf))) {
      return -9223372036854775808L;
    }
    return Math.max(0L, l - this.aIe);
  }
  
  public final long mC()
  {
    long l = this.atV.mC();
    if ((l == -9223372036854775808L) || ((this.aIf != -9223372036854775808L) && (l >= this.aIf))) {
      return -9223372036854775808L;
    }
    return l - this.aIe;
  }
  
  public final void my()
  {
    this.atV.my();
  }
  
  public final m mz()
  {
    return this.atV.mz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.7.0.1
 */