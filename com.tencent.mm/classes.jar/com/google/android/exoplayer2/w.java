package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w aTU = new w()
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
    
    public final int ac(Object paramAnonymousObject)
    {
      return -1;
    }
    
    public final int rZ()
    {
      return 0;
    }
    
    public final int sa()
    {
      return 0;
    }
  };
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).aSQ;
    if (a(i, paramb).aUi == paramInt1)
    {
      paramInt1 = bd(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).aUh;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.bl(paramInt, rZ());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.aUj;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.aUh;
    paramLong2 = paramb.aUk + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).aTs; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.aUi); paramLong1 = a(paramInt, parama, false).aTs)
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
  
  public abstract int ac(Object paramObject);
  
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
      if (paramInt1 == rZ() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == rZ() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean isEmpty()
  {
    return rZ() == 0;
  }
  
  public abstract int rZ();
  
  public abstract int sa();
  
  public static final class a
  {
    public Object aSB;
    public int aSQ;
    public Object aTV;
    public long aTW;
    public long[] aTX;
    public int[] aTY;
    public int[] aTZ;
    public long aTs;
    public int[] aUa;
    public long[][] aUb;
    public long aUc;
    
    public final int E(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.aTX == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.aTX.length - 1;
      while ((i >= 0) && ((this.aTX[i] == -9223372036854775808L) || (this.aTX[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!dI(i)))
      {
        AppMethodBeat.o(92923);
        return i;
      }
      AppMethodBeat.o(92923);
      return -1;
    }
    
    public final int F(long paramLong)
    {
      AppMethodBeat.i(92924);
      if (this.aTX == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.aTX.length) && (this.aTX[i] != -9223372036854775808L) && ((paramLong >= this.aTX[i]) || (dI(i)))) {
        i += 1;
      }
      if (i < this.aTX.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final boolean be(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.aTZ[paramInt1];
    }
    
    public final long bf(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.aUb[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.aUb[paramInt1][paramInt2];
    }
    
    public final boolean dI(int paramInt)
    {
      return (this.aTY[paramInt] != -1) && (this.aUa[paramInt] == this.aTY[paramInt]);
    }
    
    public final int sb()
    {
      if (this.aTX == null) {
        return 0;
      }
      return this.aTX.length;
    }
  }
  
  public static final class b
  {
    public Object aTV;
    public long aTs;
    public long aUd;
    public long aUe;
    public boolean aUf;
    public boolean aUg;
    public int aUh;
    public int aUi;
    public long aUj;
    public long aUk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */