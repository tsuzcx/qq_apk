package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w aTc = new w()
  {
    public final w.a a(int paramAnonymousInt, w.a paramAnonymousa, boolean paramAnonymousBoolean)
    {
      AppMethodBeat.i(92922);
      paramAnonymousa = new IndexOutOfBoundsException();
      AppMethodBeat.o(92922);
      throw paramAnonymousa;
    }
    
    public final w.b a(int paramAnonymousInt, w.b paramAnonymousb, boolean paramAnonymousBoolean, long paramAnonymousLong)
    {
      AppMethodBeat.i(92921);
      paramAnonymousb = new IndexOutOfBoundsException();
      AppMethodBeat.o(92921);
      throw paramAnonymousb;
    }
    
    public final int aa(Object paramAnonymousObject)
    {
      return -1;
    }
    
    public final int rP()
    {
      return 0;
    }
    
    public final int rQ()
    {
      return 0;
    }
  };
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).aRV;
    if (a(i, paramb).aTq == paramInt1)
    {
      paramInt1 = bd(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).aTp;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.bn(paramInt, rP());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.aTr;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.aTp;
    paramLong2 = paramb.aTs + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).aSz; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.aTq); paramLong1 = a(paramInt, parama, false).aSz)
    {
      paramLong2 -= paramLong1;
      paramInt += 1;
    }
    return Pair.create(Integer.valueOf(paramInt), Long.valueOf(paramLong2));
  }
  
  public abstract a a(int paramInt, a parama, boolean paramBoolean);
  
  public final b a(int paramInt, b paramb)
  {
    return a(paramInt, paramb, false, 0L);
  }
  
  public abstract b a(int paramInt, b paramb, boolean paramBoolean, long paramLong);
  
  public abstract int aa(Object paramObject);
  
  public final boolean b(int paramInt1, a parama, b paramb, int paramInt2)
  {
    return a(paramInt1, parama, paramb, paramInt2) == -1;
  }
  
  public int bd(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == rP() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == rP() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean isEmpty()
  {
    return rP() == 0;
  }
  
  public abstract int rP();
  
  public abstract int rQ();
  
  public static final class a
  {
    public Object aRG;
    public int aRV;
    public long aSz;
    public Object aTd;
    public long aTe;
    long[] aTf;
    int[] aTg;
    private int[] aTh;
    int[] aTi;
    private long[][] aTj;
    long aTk;
    
    public final int C(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.aTf == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.aTf.length - 1;
      while ((i >= 0) && ((this.aTf[i] == -9223372036854775808L) || (this.aTf[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!dJ(i)))
      {
        AppMethodBeat.o(92923);
        return i;
      }
      AppMethodBeat.o(92923);
      return -1;
    }
    
    public final int D(long paramLong)
    {
      AppMethodBeat.i(92924);
      if (this.aTf == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.aTf.length) && (this.aTf[i] != -9223372036854775808L) && ((paramLong >= this.aTf[i]) || (dJ(i)))) {
        i += 1;
      }
      if (i < this.aTf.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final a a(Object paramObject1, Object paramObject2, long paramLong1, long paramLong2)
    {
      this.aTd = paramObject1;
      this.aRG = paramObject2;
      this.aRV = 0;
      this.aSz = paramLong1;
      this.aTe = paramLong2;
      this.aTf = null;
      this.aTg = null;
      this.aTh = null;
      this.aTi = null;
      this.aTj = null;
      this.aTk = -9223372036854775807L;
      return this;
    }
    
    public final boolean be(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.aTh[paramInt1];
    }
    
    public final long bf(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.aTj[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.aTj[paramInt1][paramInt2];
    }
    
    public final boolean dJ(int paramInt)
    {
      return (this.aTg[paramInt] != -1) && (this.aTi[paramInt] == this.aTg[paramInt]);
    }
    
    public final int rR()
    {
      if (this.aTf == null) {
        return 0;
      }
      return this.aTf.length;
    }
  }
  
  public static final class b
  {
    public long aSz;
    public Object aTd;
    public long aTl;
    public long aTm;
    public boolean aTn;
    public boolean aTo;
    public int aTp;
    public int aTq;
    public long aTr;
    public long aTs;
    
    public final b a(Object paramObject, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, long paramLong3, long paramLong4, int paramInt, long paramLong5)
    {
      this.aTd = paramObject;
      this.aTl = paramLong1;
      this.aTm = paramLong2;
      this.aTn = paramBoolean1;
      this.aTo = paramBoolean2;
      this.aTr = paramLong3;
      this.aSz = paramLong4;
      this.aTp = 0;
      this.aTq = paramInt;
      this.aTs = paramLong5;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */