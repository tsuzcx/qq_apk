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
  private h.a aOX;
  private long aOY;
  private long aOZ;
  private a[] aPa;
  private boolean aPb;
  public final h awn;
  
  public c(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(95449);
    this.awn = paramh;
    this.aOY = -9223372036854775807L;
    this.aOZ = -9223372036854775807L;
    this.aPa = new a[0];
    this.aPb = paramBoolean;
    AppMethodBeat.o(95449);
  }
  
  public final void O(long paramLong)
  {
    AppMethodBeat.i(95454);
    this.awn.O(this.aOY + paramLong);
    AppMethodBeat.o(95454);
  }
  
  public final long P(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(95457);
    a[] arrayOfa = this.aPa;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.aPd = false;
      }
      i += 1;
    }
    long l = this.awn.P(this.aOY + paramLong);
    if (l != this.aOY + paramLong)
    {
      bool1 = bool2;
      if (l < this.aOY) {
        break label122;
      }
      if (this.aOZ != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.aOZ) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.aOY;
    AppMethodBeat.o(95457);
    return l - paramLong;
  }
  
  public final boolean Q(long paramLong)
  {
    AppMethodBeat.i(95459);
    boolean bool = this.awn.Q(this.aOY + paramLong);
    AppMethodBeat.o(95459);
    return bool;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(95453);
    this.aPa = new a[paramArrayOfl.length];
    l[] arrayOfl = new l[paramArrayOfl.length];
    int i = 0;
    if (i < paramArrayOfl.length)
    {
      this.aPa[i] = ((a)paramArrayOfl[i]);
      if (this.aPa[i] != null) {}
      for (l locall = this.aPa[i].auZ;; locall = null)
      {
        arrayOfl[i] = locall;
        i += 1;
        break;
      }
    }
    long l = this.awn.a(paramArrayOff, paramArrayOfBoolean1, arrayOfl, paramArrayOfBoolean2, paramLong + this.aOY);
    label170:
    boolean bool;
    if (this.aPb)
    {
      if (this.aOY == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!j.aG(paramArrayOfBoolean1.qh().awK)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.aPb = bool;
      }
    }
    else
    {
      if ((l != this.aOY + paramLong) && ((l < this.aOY) || ((this.aOZ != -9223372036854775808L) && (l > this.aOZ)))) {
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
      this.aPa[i] = null;
    }
    for (;;)
    {
      paramArrayOfl[i] = this.aPa[i];
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
      if ((paramArrayOfl[i] == null) || (this.aPa[i].auZ != arrayOfl[i])) {
        this.aPa[i] = new a(this, arrayOfl[i], this.aOY, this.aOZ, this.aPb);
      }
    }
    label369:
    paramLong = this.aOY;
    AppMethodBeat.o(95453);
    return l - paramLong;
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(95450);
    this.aOX = parama;
    this.awn.a(this, this.aOY + paramLong);
    AppMethodBeat.o(95450);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(95460);
    if ((this.aOY != -9223372036854775807L) && (this.aOZ != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.aOX.a(this);
      AppMethodBeat.o(95460);
      return;
    }
  }
  
  public final void i(long paramLong1, long paramLong2)
  {
    this.aOY = paramLong1;
    this.aOZ = paramLong2;
  }
  
  public final void oS()
  {
    AppMethodBeat.i(95451);
    this.awn.oS();
    AppMethodBeat.o(95451);
  }
  
  public final p oT()
  {
    AppMethodBeat.i(95452);
    p localp = this.awn.oT();
    AppMethodBeat.o(95452);
    return localp;
  }
  
  public final long oU()
  {
    boolean bool2 = false;
    AppMethodBeat.i(95455);
    if (this.aPb)
    {
      a[] arrayOfa = this.aPa;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.aPc = false;
        }
        i += 1;
      }
      this.aPb = false;
      l1 = oU();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(95455);
        return l1;
      }
      AppMethodBeat.o(95455);
      return 0L;
    }
    long l1 = this.awn.oU();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(95455);
      return -9223372036854775807L;
    }
    if (l1 >= this.aOY) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.aOZ != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.aOZ) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.aOY;
      AppMethodBeat.o(95455);
      return l1 - l2;
    }
  }
  
  public final long oV()
  {
    AppMethodBeat.i(95456);
    long l = this.awn.oV();
    if ((l == -9223372036854775808L) || ((this.aOZ != -9223372036854775808L) && (l >= this.aOZ)))
    {
      AppMethodBeat.o(95456);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.aOY);
    AppMethodBeat.o(95456);
    return l;
  }
  
  public final long oW()
  {
    AppMethodBeat.i(95458);
    long l1 = this.awn.oW();
    if ((l1 == -9223372036854775808L) || ((this.aOZ != -9223372036854775808L) && (l1 >= this.aOZ)))
    {
      AppMethodBeat.o(95458);
      return -9223372036854775808L;
    }
    long l2 = this.aOY;
    AppMethodBeat.o(95458);
    return l1 - l2;
  }
  
  static final class a
    implements l
  {
    private final long aOY;
    private final long aOZ;
    boolean aPc;
    boolean aPd;
    final l auZ;
    private final h awn;
    
    public a(h paramh, l paraml, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.awn = paramh;
      this.auZ = paraml;
      this.aOY = paramLong1;
      this.aOZ = paramLong2;
      this.aPc = paramBoolean;
    }
    
    public final void R(long paramLong)
    {
      AppMethodBeat.i(95448);
      this.auZ.R(this.aOY + paramLong);
      AppMethodBeat.o(95448);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(95447);
      if (this.aPc)
      {
        AppMethodBeat.o(95447);
        return -3;
      }
      if (this.aPd)
      {
        parame.flags = 4;
        AppMethodBeat.o(95447);
        return -4;
      }
      int i = this.auZ.b(paramk, parame, paramBoolean);
      if ((this.aOZ != -9223372036854775808L) && (((i == -4) && (parame.aAT >= this.aOZ)) || ((i == -3) && (this.awn.oV() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.aPd = true;
        AppMethodBeat.o(95447);
        return -4;
      }
      if ((i == -4) && (!parame.nE())) {
        parame.aAT -= this.aOY;
      }
      AppMethodBeat.o(95447);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(95445);
      boolean bool = this.auZ.isReady();
      AppMethodBeat.o(95445);
      return bool;
    }
    
    public final void oX()
    {
      AppMethodBeat.i(95446);
      this.auZ.oX();
      AppMethodBeat.o(95446);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.7.0.1
 */