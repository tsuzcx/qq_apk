package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w bel = new w()
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
    
    public final int ae(Object paramAnonymousObject)
    {
      return -1;
    }
    
    public final int tD()
    {
      return 0;
    }
    
    public final int tE()
    {
      return 0;
    }
  };
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).bdi;
    if (a(i, paramb).bez == paramInt1)
    {
      paramInt1 = aZ(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).bey;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.bh(paramInt, tD());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.beA;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.bey;
    paramLong2 = paramb.beB + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).bdJ; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.bez); paramLong1 = a(paramInt, parama, false).bdJ)
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
  
  public int aZ(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == tD() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == tD() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public abstract int ae(Object paramObject);
  
  public final boolean b(int paramInt1, a parama, b paramb, int paramInt2)
  {
    return a(paramInt1, parama, paramb, paramInt2) == -1;
  }
  
  public final boolean isEmpty()
  {
    return tD() == 0;
  }
  
  public abstract int tD();
  
  public abstract int tE();
  
  public static final class a
  {
    public Object bcT;
    public long bdJ;
    public int bdi;
    public Object bem;
    public long ben;
    public long[] beo;
    public int[] bep;
    public int[] beq;
    public int[] ber;
    public long[][] bes;
    public long bet;
    
    public final int E(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.beo == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.beo.length - 1;
      while ((i >= 0) && ((this.beo[i] == -9223372036854775808L) || (this.beo[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!dH(i)))
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
      if (this.beo == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.beo.length) && (this.beo[i] != -9223372036854775808L) && ((paramLong >= this.beo[i]) || (dH(i)))) {
        i += 1;
      }
      if (i < this.beo.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final boolean ba(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.beq[paramInt1];
    }
    
    public final long bb(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.bes[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.bes[paramInt1][paramInt2];
    }
    
    public final boolean dH(int paramInt)
    {
      return (this.bep[paramInt] != -1) && (this.ber[paramInt] == this.bep[paramInt]);
    }
    
    public final int tF()
    {
      if (this.beo == null) {
        return 0;
      }
      return this.beo.length;
    }
  }
  
  public static final class b
  {
    public long bdJ;
    public long beA;
    public long beB;
    public Object bem;
    public long beu;
    public long bev;
    public boolean bew;
    public boolean bex;
    public int bey;
    public int bez;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */