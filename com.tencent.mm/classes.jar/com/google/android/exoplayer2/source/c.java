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
  public final h bcV;
  private a[] bvA;
  private boolean bvB;
  private h.a bvx;
  private long bvy;
  private long bvz;
  
  public c(h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.bcV = paramh;
    this.bvy = -9223372036854775807L;
    this.bvz = -9223372036854775807L;
    this.bvA = new a[0];
    this.bvB = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.bcV.V(this.bvy + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long W(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    a[] arrayOfa = this.bvA;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.bvD = false;
      }
      i += 1;
    }
    long l = this.bcV.W(this.bvy + paramLong);
    if (l != this.bvy + paramLong)
    {
      bool1 = bool2;
      if (l < this.bvy) {
        break label122;
      }
      if (this.bvz != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.bvz) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.bvy;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.bcV.X(this.bvy + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, l[] paramArrayOfl, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.bvA = new a[paramArrayOfl.length];
    l[] arrayOfl = new l[paramArrayOfl.length];
    int i = 0;
    if (i < paramArrayOfl.length)
    {
      this.bvA[i] = ((a)paramArrayOfl[i]);
      if (this.bvA[i] != null) {}
      for (l locall = this.bvA[i].bbI;; locall = null)
      {
        arrayOfl[i] = locall;
        i += 1;
        break;
      }
    }
    long l = this.bcV.a(paramArrayOff, paramArrayOfBoolean1, arrayOfl, paramArrayOfBoolean2, paramLong + this.bvy);
    label170:
    boolean bool;
    if (this.bvB)
    {
      if (this.bvy == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!j.bx(paramArrayOfBoolean1.wu().bdt)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.bvB = bool;
      }
    }
    else
    {
      if ((l != this.bvy + paramLong) && ((l < this.bvy) || ((this.bvz != -9223372036854775808L) && (l > this.bvz)))) {
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
      this.bvA[i] = null;
    }
    for (;;)
    {
      paramArrayOfl[i] = this.bvA[i];
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
      if ((paramArrayOfl[i] == null) || (this.bvA[i].bbI != arrayOfl[i])) {
        this.bvA[i] = new a(this, arrayOfl[i], this.bvy, this.bvz, this.bvB);
      }
    }
    label369:
    paramLong = this.bvy;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(h.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.bvx = parama;
    this.bcV.a(this, this.bvy + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(h paramh)
  {
    AppMethodBeat.i(92626);
    if ((this.bvy != -9223372036854775807L) && (this.bvz != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bvx.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final void h(long paramLong1, long paramLong2)
  {
    this.bvy = paramLong1;
    this.bvz = paramLong2;
  }
  
  public final void vh()
  {
    AppMethodBeat.i(92617);
    this.bcV.vh();
    AppMethodBeat.o(92617);
  }
  
  public final p vi()
  {
    AppMethodBeat.i(92618);
    p localp = this.bcV.vi();
    AppMethodBeat.o(92618);
    return localp;
  }
  
  public final long vj()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.bvB)
    {
      a[] arrayOfa = this.bvA;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.bvC = false;
        }
        i += 1;
      }
      this.bvB = false;
      l1 = vj();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.bcV.vj();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.bvy) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.bvz != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.bvz) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.bvy;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long vk()
  {
    AppMethodBeat.i(92622);
    long l = this.bcV.vk();
    if ((l == -9223372036854775808L) || ((this.bvz != -9223372036854775808L) && (l >= this.bvz)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.bvy);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long vl()
  {
    AppMethodBeat.i(92624);
    long l1 = this.bcV.vl();
    if ((l1 == -9223372036854775808L) || ((this.bvz != -9223372036854775808L) && (l1 >= this.bvz)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.bvy;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  static final class a
    implements l
  {
    final l bbI;
    private final h bcV;
    boolean bvC;
    boolean bvD;
    private final long bvy;
    private final long bvz;
    
    public a(h paramh, l paraml, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.bcV = paramh;
      this.bbI = paraml;
      this.bvy = paramLong1;
      this.bvz = paramLong2;
      this.bvC = paramBoolean;
    }
    
    public final void Y(long paramLong)
    {
      AppMethodBeat.i(92614);
      this.bbI.Y(this.bvy + paramLong);
      AppMethodBeat.o(92614);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92613);
      if (this.bvC)
      {
        AppMethodBeat.o(92613);
        return -3;
      }
      if (this.bvD)
      {
        parame.flags = 4;
        AppMethodBeat.o(92613);
        return -4;
      }
      int i = this.bbI.b(paramk, parame, paramBoolean);
      if ((this.bvz != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.bvz)) || ((i == -3) && (this.bcV.vk() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.bvD = true;
        AppMethodBeat.o(92613);
        return -4;
      }
      if ((i == -4) && (!parame.tY())) {
        parame.timeUs -= this.bvy;
      }
      AppMethodBeat.o(92613);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92611);
      boolean bool = this.bbI.isReady();
      AppMethodBeat.o(92611);
      return bool;
    }
    
    public final void vm()
    {
      AppMethodBeat.i(92612);
      this.bbI.vm();
      AppMethodBeat.o(92612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.7.0.1
 */