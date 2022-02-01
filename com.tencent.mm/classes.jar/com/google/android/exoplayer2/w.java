package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w aNM = new w()
  {
    public final int W(Object paramAnonymousObject)
    {
      return -1;
    }
    
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
    
    public final int rv()
    {
      return 0;
    }
    
    public final int rw()
    {
      return 0;
    }
  };
  
  public abstract int W(Object paramObject);
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).aMI;
    if (a(i, paramb).aOa == paramInt1)
    {
      paramInt1 = bf(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).aNZ;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.bp(paramInt, rv());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.aOb;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.aNZ;
    paramLong2 = paramb.aOc + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).aNk; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.aOa); paramLong1 = a(paramInt, parama, false).aNk)
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
  
  public final boolean b(int paramInt1, a parama, b paramb, int paramInt2)
  {
    return a(paramInt1, parama, paramb, paramInt2) == -1;
  }
  
  public int bf(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == rv() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == rv() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean isEmpty()
  {
    return rv() == 0;
  }
  
  public abstract int rv();
  
  public abstract int rw();
  
  public static final class a
  {
    public int aMI;
    public Object aMt;
    public Object aNN;
    public long aNO;
    public long[] aNP;
    public int[] aNQ;
    public int[] aNR;
    public int[] aNS;
    public long[][] aNT;
    public long aNU;
    public long aNk;
    
    public final int H(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.aNP == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.aNP.length - 1;
      while ((i >= 0) && ((this.aNP[i] == -9223372036854775808L) || (this.aNP[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!dV(i)))
      {
        AppMethodBeat.o(92923);
        return i;
      }
      AppMethodBeat.o(92923);
      return -1;
    }
    
    public final int I(long paramLong)
    {
      AppMethodBeat.i(92924);
      if (this.aNP == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.aNP.length) && (this.aNP[i] != -9223372036854775808L) && ((paramLong >= this.aNP[i]) || (dV(i)))) {
        i += 1;
      }
      if (i < this.aNP.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final boolean bg(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.aNR[paramInt1];
    }
    
    public final long bh(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.aNT[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.aNT[paramInt1][paramInt2];
    }
    
    public final boolean dV(int paramInt)
    {
      return (this.aNQ[paramInt] != -1) && (this.aNS[paramInt] == this.aNQ[paramInt]);
    }
    
    public final int rx()
    {
      if (this.aNP == null) {
        return 0;
      }
      return this.aNP.length;
    }
  }
  
  public static final class b
  {
    public Object aNN;
    public long aNV;
    public long aNW;
    public boolean aNX;
    public boolean aNY;
    public int aNZ;
    public long aNk;
    public int aOa;
    public long aOb;
    public long aOc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */