package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class w
{
  public static final w cHI = new w()
  {
    public final int QW()
    {
      return 0;
    }
    
    public final int QX()
    {
      return 0;
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
    
    public final int bf(Object paramAnonymousObject)
    {
      return -1;
    }
  };
  
  public abstract int QW();
  
  public abstract int QX();
  
  public final int a(int paramInt1, a parama, b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).cGF;
    if (a(i, paramb).cHW == paramInt1)
    {
      paramInt1 = ca(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).cHV;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(b paramb, a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.ck(paramInt, QW());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.cHX;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.cHV;
    paramLong2 = paramb.cHY + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).cHg; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.cHW); paramLong1 = a(paramInt, parama, false).cHg)
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
  
  public abstract int bf(Object paramObject);
  
  public int ca(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == QW() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == QW() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean isEmpty()
  {
    return QW() == 0;
  }
  
  public static final class a
  {
    public int cGF;
    public Object cGq;
    public Object cHJ;
    public long cHK;
    public long[] cHL;
    public int[] cHM;
    public int[] cHN;
    public int[] cHO;
    public long[][] cHP;
    public long cHQ;
    public long cHg;
    
    public final int QY()
    {
      if (this.cHL == null) {
        return 0;
      }
      return this.cHL.length;
    }
    
    public final int bV(long paramLong)
    {
      AppMethodBeat.i(92923);
      if (this.cHL == null)
      {
        AppMethodBeat.o(92923);
        return -1;
      }
      int i = this.cHL.length - 1;
      while ((i >= 0) && ((this.cHL[i] == -9223372036854775808L) || (this.cHL[i] > paramLong))) {
        i -= 1;
      }
      if ((i >= 0) && (!hm(i)))
      {
        AppMethodBeat.o(92923);
        return i;
      }
      AppMethodBeat.o(92923);
      return -1;
    }
    
    public final int bW(long paramLong)
    {
      AppMethodBeat.i(92924);
      if (this.cHL == null)
      {
        AppMethodBeat.o(92924);
        return -1;
      }
      int i = 0;
      while ((i < this.cHL.length) && (this.cHL[i] != -9223372036854775808L) && ((paramLong >= this.cHL[i]) || (hm(i)))) {
        i += 1;
      }
      if (i < this.cHL.length)
      {
        AppMethodBeat.o(92924);
        return i;
      }
      AppMethodBeat.o(92924);
      return -1;
    }
    
    public final boolean cb(int paramInt1, int paramInt2)
    {
      return paramInt2 < this.cHN[paramInt1];
    }
    
    public final long cc(int paramInt1, int paramInt2)
    {
      if (paramInt2 >= this.cHP[paramInt1].length) {
        return -9223372036854775807L;
      }
      return this.cHP[paramInt1][paramInt2];
    }
    
    public final boolean hm(int paramInt)
    {
      return (this.cHM[paramInt] != -1) && (this.cHO[paramInt] == this.cHM[paramInt]);
    }
  }
  
  public static final class b
  {
    public Object cHJ;
    public long cHR;
    public long cHS;
    public boolean cHT;
    public boolean cHU;
    public int cHV;
    public int cHW;
    public long cHX;
    public long cHY;
    public long cHg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */