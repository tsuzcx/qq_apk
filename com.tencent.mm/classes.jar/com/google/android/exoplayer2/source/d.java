package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  implements j, j.a
{
  public final j aMs;
  private j.a beU;
  private long beV;
  private long beW;
  private a[] beX;
  private boolean beY;
  
  public d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.aMs = paramj;
    this.beV = -9223372036854775807L;
    this.beW = -9223372036854775807L;
    this.beX = new a[0];
    this.beY = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void Y(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.aMs.Y(this.beV + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long Z(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    a[] arrayOfa = this.beX;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.bfa = false;
      }
      i += 1;
    }
    long l = this.aMs.Z(this.beV + paramLong);
    if (l != this.beV + paramLong)
    {
      bool1 = bool2;
      if (l < this.beV) {
        break label122;
      }
      if (this.beW != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.beW) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.beV;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.beX = new a[paramArrayOfn.length];
    n[] arrayOfn = new n[paramArrayOfn.length];
    int i = 0;
    if (i < paramArrayOfn.length)
    {
      this.beX[i] = ((a)paramArrayOfn[i]);
      if (this.beX[i] != null) {}
      for (n localn = this.beX[i].aLd;; localn = null)
      {
        arrayOfn[i] = localn;
        i += 1;
        break;
      }
    }
    long l = this.aMs.a(paramArrayOff, paramArrayOfBoolean1, arrayOfn, paramArrayOfBoolean2, paramLong + this.beV);
    label170:
    boolean bool;
    if (this.beY)
    {
      if (this.beV == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!com.google.android.exoplayer2.i.j.bI(paramArrayOfBoolean1.uA().aMQ)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.beY = bool;
      }
    }
    else
    {
      if ((l != this.beV + paramLong) && ((l < this.beV) || ((this.beW != -9223372036854775808L) && (l > this.beW)))) {
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
      this.beX[i] = null;
    }
    for (;;)
    {
      paramArrayOfn[i] = this.beX[i];
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
      if ((paramArrayOfn[i] == null) || (this.beX[i].aLd != arrayOfn[i])) {
        this.beX[i] = new a(this, arrayOfn[i], this.beV, this.beW, this.beY);
      }
    }
    label369:
    paramLong = this.beV;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(j.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.beU = parama;
    this.aMs.a(this, this.beV + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(92626);
    if ((this.beV != -9223372036854775807L) && (this.beW != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.beU.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final boolean aa(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.aMs.aa(this.beV + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
  
  public final void i(long paramLong1, long paramLong2)
  {
    this.beV = paramLong1;
    this.beW = paramLong2;
  }
  
  public final void tl()
  {
    AppMethodBeat.i(92617);
    this.aMs.tl();
    AppMethodBeat.o(92617);
  }
  
  public final r tm()
  {
    AppMethodBeat.i(92618);
    r localr = this.aMs.tm();
    AppMethodBeat.o(92618);
    return localr;
  }
  
  public final long tn()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.beY)
    {
      a[] arrayOfa = this.beX;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.beZ = false;
        }
        i += 1;
      }
      this.beY = false;
      l1 = tn();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.aMs.tn();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.beV) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.beW != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.beW) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.beV;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long to()
  {
    AppMethodBeat.i(92622);
    long l = this.aMs.to();
    if ((l == -9223372036854775808L) || ((this.beW != -9223372036854775808L) && (l >= this.beW)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.beV);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long tp()
  {
    AppMethodBeat.i(92624);
    long l1 = this.aMs.tp();
    if ((l1 == -9223372036854775808L) || ((this.beW != -9223372036854775808L) && (l1 >= this.beW)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.beV;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  static final class a
    implements n
  {
    final n aLd;
    private final j aMs;
    private final long beV;
    private final long beW;
    boolean beZ;
    boolean bfa;
    
    public a(j paramj, n paramn, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.aMs = paramj;
      this.aLd = paramn;
      this.beV = paramLong1;
      this.beW = paramLong2;
      this.beZ = paramBoolean;
    }
    
    public final void ab(long paramLong)
    {
      AppMethodBeat.i(92614);
      this.aLd.ab(this.beV + paramLong);
      AppMethodBeat.o(92614);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92613);
      if (this.beZ)
      {
        AppMethodBeat.o(92613);
        return -3;
      }
      if (this.bfa)
      {
        parame.flags = 4;
        AppMethodBeat.o(92613);
        return -4;
      }
      int i = this.aLd.b(paramk, parame, paramBoolean);
      if ((this.beW != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.beW)) || ((i == -3) && (this.aMs.to() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.bfa = true;
        AppMethodBeat.o(92613);
        return -4;
      }
      if ((i == -4) && (!parame.rV())) {
        parame.timeUs -= this.beV;
      }
      AppMethodBeat.o(92613);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92611);
      boolean bool = this.aLd.isReady();
      AppMethodBeat.o(92611);
      return bool;
    }
    
    public final void tq()
    {
      AppMethodBeat.i(92612);
      this.aLd.tq();
      AppMethodBeat.o(92612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */