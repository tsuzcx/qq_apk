package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements h, h.a
{
  public final h aSA;
  private h.a blc;
  private long bld;
  private long ble;
  private a[] blf;
  private boolean blg;
  
  public c(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.aSA = paramh;
    this.bld = -9223372036854775807L;
    this.ble = -9223372036854775807L;
    this.blf = new a[0];
    this.blg = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.aSA.V(this.bld + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long W(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    a[] arrayOfa = this.blf;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.bli = false;
      }
      i += 1;
    }
    long l = this.aSA.W(this.bld + paramLong);
    if (l != this.bld + paramLong)
    {
      bool1 = bool2;
      if (l < this.bld) {
        break label122;
      }
      if (this.ble != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.ble) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.bld;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.aSA.X(this.bld + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.blf = new a[paramArrayOfl.length];
    l[] arrayOfl = new l[paramArrayOfl.length];
    int i = 0;
    if (i < paramArrayOfl.length)
    {
      this.blf[i] = ((a)paramArrayOfl[i]);
      if (this.blf[i] != null) {}
      for (l locall = this.blf[i].aRn;; locall = null)
      {
        arrayOfl[i] = locall;
        i += 1;
        break;
      }
    }
    long l = this.aSA.a(paramArrayOff, paramArrayOfBoolean1, arrayOfl, paramArrayOfBoolean2, paramLong + this.bld);
    label170:
    boolean bool;
    if (this.blg)
    {
      if (this.bld == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!j.aE(paramArrayOfBoolean1.uV().aSY)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.blg = bool;
      }
    }
    else
    {
      if ((l != this.bld + paramLong) && ((l < this.bld) || ((this.ble != -9223372036854775808L) && (l > this.ble)))) {
        break label303;
      }
      bool = true;
      label231:
      a.checkState(bool);
      i = 0;
      label239:
      if (i >= paramArrayOfl.length) {
        break label369;
      }
      if (arrayOfl[i] != null) {
        break label309;
      }
      this.blf[i] = null;
    }
    for (;;)
    {
      paramArrayOfl[i] = this.blf[i];
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
      if ((paramArrayOfl[i] == null) || (this.blf[i].aRn != arrayOfl[i])) {
        this.blf[i] = new a(this, arrayOfl[i], this.bld, this.ble, this.blg);
      }
    }
    label369:
    paramLong = this.bld;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.blc = parama;
    this.aSA.a(this, this.bld + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(92626);
    if ((this.bld != -9223372036854775807L) && (this.ble != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.blc.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final void h(long paramLong1, long paramLong2)
  {
    this.bld = paramLong1;
    this.ble = paramLong2;
  }
  
  public final void tI()
  {
    AppMethodBeat.i(92617);
    this.aSA.tI();
    AppMethodBeat.o(92617);
  }
  
  public final p tJ()
  {
    AppMethodBeat.i(92618);
    p localp = this.aSA.tJ();
    AppMethodBeat.o(92618);
    return localp;
  }
  
  public final long tK()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.blg)
    {
      a[] arrayOfa = this.blf;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.blh = false;
        }
        i += 1;
      }
      this.blg = false;
      l1 = tK();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.aSA.tK();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.bld) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.ble != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.ble) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.bld;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long tL()
  {
    AppMethodBeat.i(92622);
    long l = this.aSA.tL();
    if ((l == -9223372036854775808L) || ((this.ble != -9223372036854775808L) && (l >= this.ble)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.bld);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long tM()
  {
    AppMethodBeat.i(92624);
    long l1 = this.aSA.tM();
    if ((l1 == -9223372036854775808L) || ((this.ble != -9223372036854775808L) && (l1 >= this.ble)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.bld;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  static final class a
    implements l
  {
    final l aRn;
    private final h aSA;
    private final long bld;
    private final long ble;
    boolean blh;
    boolean bli;
    
    public a(h paramh, l paraml, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.aSA = paramh;
      this.aRn = paraml;
      this.bld = paramLong1;
      this.ble = paramLong2;
      this.blh = paramBoolean;
    }
    
    public final void Y(long paramLong)
    {
      AppMethodBeat.i(92614);
      this.aRn.Y(this.bld + paramLong);
      AppMethodBeat.o(92614);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92613);
      if (this.blh)
      {
        AppMethodBeat.o(92613);
        return -3;
      }
      if (this.bli)
      {
        parame.flags = 4;
        AppMethodBeat.o(92613);
        return -4;
      }
      int i = this.aRn.b(paramk, parame, paramBoolean);
      if ((this.ble != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.ble)) || ((i == -3) && (this.aSA.tL() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.bli = true;
        AppMethodBeat.o(92613);
        return -4;
      }
      if ((i == -4) && (!parame.sz())) {
        parame.timeUs -= this.bld;
      }
      AppMethodBeat.o(92613);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92611);
      boolean bool = this.aRn.isReady();
      AppMethodBeat.o(92611);
      return bool;
    }
    
    public final void tN()
    {
      AppMethodBeat.i(92612);
      this.aRn.tN();
      AppMethodBeat.o(92612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.7.0.1
 */