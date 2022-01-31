package com.google.android.exoplayer2;

import android.util.Pair;
import com.google.android.exoplayer2.i.a;

public abstract class w
{
  public static final w avt = new w.1();
  
  public abstract int O(Object paramObject);
  
  public final int a(int paramInt1, w.a parama, w.b paramb, int paramInt2)
  {
    int i = a(paramInt1, parama, false).auk;
    if (a(i, paramb, 0L).avH == paramInt1)
    {
      paramInt1 = i;
      switch (paramInt2)
      {
      default: 
        throw new IllegalStateException();
      case 0: 
        if (i == kV() - 1) {
          paramInt1 = -1;
        }
        break;
      }
      while (paramInt1 == -1)
      {
        return -1;
        paramInt1 = i + 1;
        continue;
        if (i == kV() - 1) {
          paramInt1 = 0;
        } else {
          paramInt1 = i + 1;
        }
      }
      return a(paramInt1, paramb, 0L).avG;
    }
    return paramInt1 + 1;
  }
  
  public final Pair<Integer, Long> a(w.b paramb, w.a parama, int paramInt, long paramLong)
  {
    return a(paramb, parama, paramInt, paramLong, 0L);
  }
  
  public final Pair<Integer, Long> a(w.b paramb, w.a parama, int paramInt, long paramLong1, long paramLong2)
  {
    a.aI(paramInt, kV());
    a(paramInt, paramb, paramLong2);
    paramLong2 = paramLong1;
    if (paramLong1 == -9223372036854775807L)
    {
      paramLong1 = paramb.avI;
      paramLong2 = paramLong1;
      if (paramLong1 == -9223372036854775807L) {
        return null;
      }
    }
    paramInt = paramb.avG;
    paramLong2 = paramb.avJ + paramLong2;
    for (paramLong1 = a(paramInt, parama, false).auP; (paramLong1 != -9223372036854775807L) && (paramLong2 >= paramLong1) && (paramInt < paramb.avH); paramLong1 = a(paramInt, parama, false).auP)
    {
      paramLong2 -= paramLong1;
      paramInt += 1;
    }
    return Pair.create(Integer.valueOf(paramInt), Long.valueOf(paramLong2));
  }
  
  public abstract w.a a(int paramInt, w.a parama, boolean paramBoolean);
  
  public abstract w.b a(int paramInt, w.b paramb, long paramLong);
  
  public final boolean isEmpty()
  {
    return kV() == 0;
  }
  
  public abstract int kV();
  
  public abstract int kW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.w
 * JD-Core Version:    0.7.0.1
 */