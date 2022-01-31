package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;

public abstract class w
{
  public static final w axJ = new w.1();
  
  public abstract int O(Object paramObject);
  
  public final int a(int paramInt1, w.a parama, w.b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).awC;
    if (a(i, paramb).axX == paramInt1)
    {
      paramInt1 = aS(i, paramInt2);
      if (paramInt1 == -1) {
        return -1;
      }
      return a(paramInt1, paramb).axW;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(w.b paramb, w.a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(w.b paramb, w.a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.ba(paramInt, ne());
    a(paramInt, paramb, false, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.axY;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.axW;
    paramLong2 = paramb.axZ + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).axh; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.axX); paramLong1 = a(paramInt, parama, false).axh)
    {
      paramLong2 -= paramLong1;
      paramInt += 1;
    }
    return Pair.create(Integer.valueOf(paramInt), Long.valueOf(paramLong2));
  }
  
  public abstract w.a a(int paramInt, w.a parama, boolean paramBoolean);
  
  public final w.b a(int paramInt, w.b paramb)
  {
    return a(paramInt, paramb, false, 0L);
  }
  
  public abstract w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong);
  
  public int aS(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      throw new IllegalStateException();
    case 0: 
      if (paramInt1 == ne() - 1) {
        i = -1;
      }
    case 1: 
      return i;
      return paramInt1 + 1;
    }
    if (paramInt1 == ne() - 1) {
      return 0;
    }
    return paramInt1 + 1;
  }
  
  public final boolean b(int paramInt1, w.a parama, w.b paramb, int paramInt2)
  {
    return a(paramInt1, parama, paramb, paramInt2) == -1;
  }
  
  public final boolean isEmpty()
  {
    return ne() == 0;
  }
  
  public abstract int ne();
  
  public abstract int nf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */