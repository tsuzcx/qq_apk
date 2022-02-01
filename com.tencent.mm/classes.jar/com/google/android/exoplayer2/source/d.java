package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements j, j.a
{
  public final j cGp;
  private j.a cYN;
  private long cYO;
  private long cYP;
  private d.a[] cYQ;
  private boolean cYR;
  
  public d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.cGp = paramj;
    this.cYO = -9223372036854775807L;
    this.cYP = -9223372036854775807L;
    this.cYQ = new d.a[0];
    this.cYR = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void E(long paramLong1, long paramLong2)
  {
    this.cYO = paramLong1;
    this.cYP = paramLong2;
  }
  
  public final void SO()
  {
    AppMethodBeat.i(92617);
    this.cGp.SO();
    AppMethodBeat.o(92617);
  }
  
  public final r SP()
  {
    AppMethodBeat.i(92618);
    r localr = this.cGp.SP();
    AppMethodBeat.o(92618);
    return localr;
  }
  
  public final long SQ()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.cYR)
    {
      d.a[] arrayOfa = this.cYQ;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        d.a locala = arrayOfa[i];
        if (locala != null) {
          locala.cYS = false;
        }
        i += 1;
      }
      this.cYR = false;
      l1 = SQ();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.cGp.SQ();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.cYO) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.cYP != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.cYP) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.cYO;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long SR()
  {
    AppMethodBeat.i(92622);
    long l = this.cGp.SR();
    if ((l == -9223372036854775808L) || ((this.cYP != -9223372036854775808L) && (l >= this.cYP)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.cYO);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long SS()
  {
    AppMethodBeat.i(92624);
    long l1 = this.cGp.SS();
    if ((l1 == -9223372036854775808L) || ((this.cYP != -9223372036854775808L) && (l1 >= this.cYP)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.cYO;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.cYQ = new d.a[paramArrayOfn.length];
    n[] arrayOfn = new n[paramArrayOfn.length];
    int i = 0;
    if (i < paramArrayOfn.length)
    {
      this.cYQ[i] = ((d.a)paramArrayOfn[i]);
      if (this.cYQ[i] != null) {}
      for (n localn = this.cYQ[i].cFa;; localn = null)
      {
        arrayOfn[i] = localn;
        i += 1;
        break;
      }
    }
    long l = this.cGp.a(paramArrayOff, paramArrayOfBoolean1, arrayOfn, paramArrayOfBoolean2, paramLong + this.cYO);
    label170:
    boolean bool;
    if (this.cYR)
    {
      if (this.cYO == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!com.google.android.exoplayer2.i.j.df(paramArrayOfBoolean1.Ud().cGN)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.cYR = bool;
      }
    }
    else
    {
      if ((l != this.cYO + paramLong) && ((l < this.cYO) || ((this.cYP != -9223372036854775808L) && (l > this.cYP)))) {
        break label303;
      }
      bool = true;
      label231:
      a.checkState(bool);
      i = 0;
      label239:
      if (i >= paramArrayOfn.length) {
        break label369;
      }
      if (arrayOfn[i] != null) {
        break label309;
      }
      this.cYQ[i] = null;
    }
    for (;;)
    {
      paramArrayOfn[i] = this.cYQ[i];
      i += 1;
      break label239;
      i += 1;
      break;
      label291:
      i = 0;
      break label170;
      label297:
      bool = false;
      break label178;
      label303:
      bool = false;
      break label231;
      label309:
      if ((paramArrayOfn[i] == null) || (this.cYQ[i].cFa != arrayOfn[i])) {
        this.cYQ[i] = new d.a(this, arrayOfn[i], this.cYO, this.cYP, this.cYR);
      }
    }
    label369:
    paramLong = this.cYO;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(j.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.cYN = parama;
    this.cGp.a(this, this.cYO + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(92626);
    if ((this.cYO != -9223372036854775807L) && (this.cYP != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.cYN.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final void cm(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.cGp.cm(this.cYO + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long cn(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    d.a[] arrayOfa = this.cYQ;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      d.a locala = arrayOfa[i];
      if (locala != null) {
        locala.cYT = false;
      }
      i += 1;
    }
    long l = this.cGp.cn(this.cYO + paramLong);
    if (l != this.cYO + paramLong)
    {
      bool1 = bool2;
      if (l < this.cYO) {
        break label122;
      }
      if (this.cYP != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.cYP) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.cYO;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final boolean co(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.cGp.co(this.cYO + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */