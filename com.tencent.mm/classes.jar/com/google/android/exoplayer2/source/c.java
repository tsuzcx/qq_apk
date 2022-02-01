package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements i, i.a
{
  public final i aRF;
  private a[] bkA;
  private boolean bkB;
  private i.a bkx;
  private long bky;
  private long bkz;
  
  public c(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(92615);
    this.aRF = parami;
    this.bky = -9223372036854775807L;
    this.bkz = -9223372036854775807L;
    this.bkA = new a[0];
    this.bkB = paramBoolean;
    AppMethodBeat.o(92615);
  }
  
  public final void U(long paramLong)
  {
    AppMethodBeat.i(92620);
    this.aRF.U(this.bky + paramLong);
    AppMethodBeat.o(92620);
  }
  
  public final long V(long paramLong)
  {
    boolean bool2 = false;
    AppMethodBeat.i(92623);
    a[] arrayOfa = this.bkA;
    int j = arrayOfa.length;
    int i = 0;
    while (i < j)
    {
      a locala = arrayOfa[i];
      if (locala != null) {
        locala.bkD = false;
      }
      i += 1;
    }
    long l = this.aRF.V(this.bky + paramLong);
    if (l != this.bky + paramLong)
    {
      bool1 = bool2;
      if (l < this.bky) {
        break label122;
      }
      if (this.bkz != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l > this.bkz) {
          break label122;
        }
      }
    }
    boolean bool1 = true;
    label122:
    a.checkState(bool1);
    paramLong = this.bky;
    AppMethodBeat.o(92623);
    return l - paramLong;
  }
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(92625);
    boolean bool = this.aRF.W(this.bky + paramLong);
    AppMethodBeat.o(92625);
    return bool;
  }
  
  public final long a(f[] paramArrayOff, boolean[] paramArrayOfBoolean1, m[] paramArrayOfm, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(92619);
    this.bkA = new a[paramArrayOfm.length];
    m[] arrayOfm = new m[paramArrayOfm.length];
    int i = 0;
    if (i < paramArrayOfm.length)
    {
      this.bkA[i] = ((a)paramArrayOfm[i]);
      if (this.bkA[i] != null) {}
      for (m localm = this.bkA[i].aQs;; localm = null)
      {
        arrayOfm[i] = localm;
        i += 1;
        break;
      }
    }
    long l = this.aRF.a(paramArrayOff, paramArrayOfBoolean1, arrayOfm, paramArrayOfBoolean2, paramLong + this.bky);
    label170:
    boolean bool;
    if (this.bkB)
    {
      if (this.bky == 0L) {
        break label297;
      }
      int j = paramArrayOff.length;
      i = 0;
      if (i >= j) {
        break label291;
      }
      paramArrayOfBoolean1 = paramArrayOff[i];
      if ((paramArrayOfBoolean1 != null) && (!j.aJ(paramArrayOfBoolean1.vb().aSd)))
      {
        i = 1;
        if (i == 0) {
          break label297;
        }
        bool = true;
        label178:
        this.bkB = bool;
      }
    }
    else
    {
      if ((l != this.bky + paramLong) && ((l < this.bky) || ((this.bkz != -9223372036854775808L) && (l > this.bkz)))) {
        break label303;
      }
      bool = true;
      label231:
      a.checkState(bool);
      i = 0;
      label239:
      if (i >= paramArrayOfm.length) {
        break label369;
      }
      if (arrayOfm[i] != null) {
        break label309;
      }
      this.bkA[i] = null;
    }
    for (;;)
    {
      paramArrayOfm[i] = this.bkA[i];
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
      if ((paramArrayOfm[i] == null) || (this.bkA[i].aQs != arrayOfm[i])) {
        this.bkA[i] = new a(this, arrayOfm[i], this.bky, this.bkz, this.bkB);
      }
    }
    label369:
    paramLong = this.bky;
    AppMethodBeat.o(92619);
    return l - paramLong;
  }
  
  public final void a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(92616);
    this.bkx = parama;
    this.aRF.a(this, this.bky + paramLong);
    AppMethodBeat.o(92616);
  }
  
  public final void a(i parami)
  {
    AppMethodBeat.i(92626);
    if ((this.bky != -9223372036854775807L) && (this.bkz != -9223372036854775807L)) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bkx.a(this);
      AppMethodBeat.o(92626);
      return;
    }
  }
  
  public final void h(long paramLong1, long paramLong2)
  {
    this.bky = paramLong1;
    this.bkz = paramLong2;
  }
  
  public final void tA()
  {
    AppMethodBeat.i(92617);
    this.aRF.tA();
    AppMethodBeat.o(92617);
  }
  
  public final q tB()
  {
    AppMethodBeat.i(92618);
    q localq = this.aRF.tB();
    AppMethodBeat.o(92618);
    return localq;
  }
  
  public final long tC()
  {
    boolean bool2 = false;
    AppMethodBeat.i(92621);
    if (this.bkB)
    {
      a[] arrayOfa = this.bkA;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        a locala = arrayOfa[i];
        if (locala != null) {
          locala.bkC = false;
        }
        i += 1;
      }
      this.bkB = false;
      l1 = tC();
      if (l1 != -9223372036854775807L)
      {
        AppMethodBeat.o(92621);
        return l1;
      }
      AppMethodBeat.o(92621);
      return 0L;
    }
    long l1 = this.aRF.tC();
    if (l1 == -9223372036854775807L)
    {
      AppMethodBeat.o(92621);
      return -9223372036854775807L;
    }
    if (l1 >= this.bky) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      a.checkState(bool1);
      if (this.bkz != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > this.bkz) {}
      }
      else
      {
        bool1 = true;
      }
      a.checkState(bool1);
      long l2 = this.bky;
      AppMethodBeat.o(92621);
      return l1 - l2;
    }
  }
  
  public final long tD()
  {
    AppMethodBeat.i(92622);
    long l = this.aRF.tD();
    if ((l == -9223372036854775808L) || ((this.bkz != -9223372036854775808L) && (l >= this.bkz)))
    {
      AppMethodBeat.o(92622);
      return -9223372036854775808L;
    }
    l = Math.max(0L, l - this.bky);
    AppMethodBeat.o(92622);
    return l;
  }
  
  public final long tE()
  {
    AppMethodBeat.i(92624);
    long l1 = this.aRF.tE();
    if ((l1 == -9223372036854775808L) || ((this.bkz != -9223372036854775808L) && (l1 >= this.bkz)))
    {
      AppMethodBeat.o(92624);
      return -9223372036854775808L;
    }
    long l2 = this.bky;
    AppMethodBeat.o(92624);
    return l1 - l2;
  }
  
  static final class a
    implements m
  {
    final m aQs;
    private final i aRF;
    boolean bkC;
    boolean bkD;
    private final long bky;
    private final long bkz;
    
    public a(i parami, m paramm, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      this.aRF = parami;
      this.aQs = paramm;
      this.bky = paramLong1;
      this.bkz = paramLong2;
      this.bkC = paramBoolean;
    }
    
    public final void X(long paramLong)
    {
      AppMethodBeat.i(92614);
      this.aQs.X(this.bky + paramLong);
      AppMethodBeat.o(92614);
    }
    
    public final int b(k paramk, e parame, boolean paramBoolean)
    {
      AppMethodBeat.i(92613);
      if (this.bkC)
      {
        AppMethodBeat.o(92613);
        return -3;
      }
      if (this.bkD)
      {
        parame.flags = 4;
        AppMethodBeat.o(92613);
        return -4;
      }
      int i = this.aQs.b(paramk, parame, paramBoolean);
      if ((this.bkz != -9223372036854775808L) && (((i == -4) && (parame.timeUs >= this.bkz)) || ((i == -3) && (this.aRF.tD() == -9223372036854775808L))))
      {
        parame.clear();
        parame.flags = 4;
        this.bkD = true;
        AppMethodBeat.o(92613);
        return -4;
      }
      if ((i == -4) && (!parame.sq())) {
        parame.timeUs -= this.bky;
      }
      AppMethodBeat.o(92613);
      return i;
    }
    
    public final boolean isReady()
    {
      AppMethodBeat.i(92611);
      boolean bool = this.aQs.isReady();
      AppMethodBeat.o(92611);
      return bool;
    }
    
    public final void tF()
    {
      AppMethodBeat.i(92612);
      this.aQs.tF();
      AppMethodBeat.o(92612);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c
 * JD-Core Version:    0.7.0.1
 */