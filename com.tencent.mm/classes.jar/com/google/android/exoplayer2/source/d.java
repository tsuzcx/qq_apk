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
  public final j bcS;
  private j.a bvs;
  private long bvt;
  private long bvu;
  private a[] bvv;
  private boolean bvw;
  
  public d(j paramj, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.bcS = paramj;
    this.bvt = -9223372036854775807L;
    this.bvu = -9223372036854775807L;
    this.bvv = new a[0];
    this.bvw = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void V(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.bcS.V(this.bvt + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long W(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    a[] arrayOfa = this.bvv;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.bvy = false;
      }
      i += 1;
    }
    long l = this.bcS.W(this.bvt + paramLong);
    if (l != this.bvt + paramLong)
    {
      bool1 = bool2;
      if (l < this.bvt) {
        break label122;
      }
      if (this.bvu != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.bvu) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.bvt;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final boolean X(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.bcS.X(this.bvt + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, n[] paramArrayOfn, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.bvv = new a[paramArrayOfn.length];
    n[] arrayOfn = new n[paramArrayOfn.length];
    int i = 0;
    if (i < paramArrayOfn.length)
    {
      this.bvv[i] = ((a)paramArrayOfn[i]);
      if (this.bvv[i] != null) {}
      for (n localn = this.bvv[i].bbF;; localn = null)
      {
        arrayOfn[i] = localn;
        i += 1;
        break;
      }
    }
    long l = this.bcS.a(paramArrayOff, paramArrayOfBoolean1, arrayOfn, paramArrayOfBoolean2, paramLong + this.bvt);
    label170:
    boolean bool;
    if (this.bvw)
    {
      if (this.bvt == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!com.google.android.exoplayer2.i.j.bx(paramArrayOfBoolean1.wz().bdq)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.bvw = bool;
      }
    }
    else
    {
      if ((l != this.bvt + paramLong) && ((l < this.bvt) || ((this.bvu != -9223372036854775808L) && (l > this.bvu)))) {
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
      this.bvv[i] = null;
    }
    for (;;)
    {
      paramArrayOfn[i] = this.bvv[i];
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
      if ((paramArrayOfn[i] == null) || (this.bvv[i].bbF != arrayOfn[i])) {
        this.bvv[i] = new a(this, arrayOfn[i], this.bvt, this.bvu, this.bvw);
      }
    }
    label369:
    paramLong = this.bvt;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(j.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.bvs = parama;
    this.bcS.a(this, this.bvt + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(j paramj)
  {
    AppMethodBeat.i(92626);
    if ((this.bvt != -9223372036854775807L) && (this.bvu != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bvs.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final void h(long paramLong1, long paramLong2)
  {
    this.bvt = paramLong1;
    this.bvu = paramLong2;
  }
  
  public final void vn()
  {
    AppMethodBeat.i(92617);
    this.bcS.vn();
    AppMethodBeat.o(92617);
  }
  
  public final r vo()
  {
    AppMethodBeat.i(92618);
    r localr = this.bcS.vo();
    AppMethodBeat.o(92618);
    return localr;
  }
  
  public final long vp()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.bvw)
    {
      a[] arrayOfa = this.bvv;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.bvx = false;
        }
        i += 1;
      }
      this.bvw = false;
      l1 = vp();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.bcS.vp();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.bvt) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.bvu != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.bvu) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.bvt;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long vq()
  {
    AppMethodBeat.i(92622);
    long l = this.bcS.vq();
    if ((l == -9223372036854775808L) || ((this.bvu != -9223372036854775808L) && (l >= this.bvu)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.bvt);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long vr()
  {
    AppMethodBeat.i(92624);
    long l1 = this.bcS.vr();
    if ((l1 == -9223372036854775808L) || ((this.bvu != -9223372036854775808L) && (l1 >= this.bvu)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.bvt;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  static final class a
    implements n
  {
    final n bbF;
    private final j bcS;
    private final long bvt;
    private final long bvu;
    boolean bvx;
    boolean bvy;
    
    public a(j paramj, n paramn, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.bcS = paramj;
      this.bbF = paramn;
      this.bvt = paramLong1;
      this.bvu = paramLong2;
      this.bvx = paramBoolean;
    }
    
    public final void Y(long paramLong)
    {
      AppMethodBeat.i(92614);
      this.bbF.Y(this.bvt + paramLong);
      AppMethodBeat.o(92614);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92613);
      if (this.bvx)
      {
        AppMethodBeat.o(92613);
        return -3;
      }
      if (this.bvy)
      {
        parame.flags = 4;
        AppMethodBeat.o(92613);
        return -4;
      }
      int i = this.bbF.b(paramk, parame, paramBoolean);
      if ((this.bvu != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.bvu)) || ((i == -3) && (this.bcS.vq() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.bvy = true;
        AppMethodBeat.o(92613);
        return -4;
      }
      if ((i == -4) && (!parame.ud())) {
        parame.timeUs -= this.bvt;
      }
      AppMethodBeat.o(92613);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92611);
      boolean bool = this.bbF.isReady();
      AppMethodBeat.o(92611);
      return bool;
    }
    
    public final void vs()
    {
      AppMethodBeat.i(92612);
      this.bbF.vs();
      AppMethodBeat.o(92612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.d
 * JD-Core Version:    0.7.0.1
 */