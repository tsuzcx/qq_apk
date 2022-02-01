package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w beo = new w()
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
    
    public final int ty()
    {
      return 0;
    }
    
    public final int tz()
    {
      return 0;
    }
  };
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).bdl;
    if (a(i, paramb).beC == paramInt1)
    {
      paramInt1 = bf(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).beB;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.bn(paramInt, ty());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.beD;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.beB;
    paramLong2 = paramb.beE + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).bdM; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.beC); paramLong1 = a(paramInt, parama, false).bdM)
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
  
  public abstract int ae(Object paramObject);
  
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
      if (paramInt1 == ty() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == ty() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean isEmpty()
  {
    return ty() == 0;
  }
  
  public abstract int ty();
  
  public abstract int tz();
  
  public static final class a
  {
    public Object bcW;
    public long bdM;
    public int bdl;
    public Object bep;
    public long beq;
    public long[] ber;
    public int[] bes;
    public int[] bet;
    public int[] beu;
    public long[][] bev;
    public long bew;
    
    public final int E(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.ber == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.ber.length - 1;
      while ((i >= 0) && ((this.ber[i] == -9223372036854775808L) || (this.ber[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!dM(i)))
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
      if (this.ber == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.ber.length) && (this.ber[i] != -9223372036854775808L) && ((paramLong >= this.ber[i]) || (dM(i)))) {
        i += 1;
      }
      if (i < this.ber.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final boolean bg(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.bet[paramInt1];
    }
    
    public final long bh(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.bev[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.bev[paramInt1][paramInt2];
    }
    
    public final boolean dM(int paramInt)
    {
      return (this.bes[paramInt] != -1) && (this.beu[paramInt] == this.bes[paramInt]);
    }
    
    public final int tA()
    {
      if (this.ber == null) {
        return 0;
      }
      return this.ber.length;
    }
  }
  
  public static final class b
  {
    public long bdM;
    public boolean beA;
    public int beB;
    public int beC;
    public long beD;
    public long beE;
    public Object bep;
    public long bex;
    public long bey;
    public boolean bez;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */