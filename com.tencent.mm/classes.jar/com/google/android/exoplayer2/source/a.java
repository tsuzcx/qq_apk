package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

abstract class a
  extends w
{
  private final int beC;
  
  public a(int paramInt)
  {
    this.beC = paramInt;
  }
  
  public final int W(Object paramObject)
  {
    if (!(paramObject instanceof Pair)) {}
    int i;
    int j;
    do
    {
      Object localObject;
      do
      {
        return -1;
        localObject = (Pair)paramObject;
        paramObject = ((Pair)localObject).first;
        localObject = ((Pair)localObject).second;
        i = Y(paramObject);
      } while (i == -1);
      j = ti().W(localObject);
    } while (j == -1);
    return eN(i) + j;
  }
  
  protected abstract int Y(Object paramObject);
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    int i = eL(paramInt);
    int j = eO(i);
    int k = eN(i);
    ti().a(paramInt - k, parama, paramBoolean);
    parama.aMI = (j + parama.aMI);
    if (paramBoolean) {
      parama.aMt = Pair.create(eP(i), parama.aMt);
    }
    return parama;
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    int j = eM(paramInt);
    int i = eO(j);
    j = eN(j);
    ti().a(paramInt - i, paramb, paramBoolean, paramLong);
    paramb.aNZ += j;
    paramb.aOa += j;
    return paramb;
  }
  
  public final int bf(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = eM(paramInt1);
    int m = eO(k);
    w localw = ti();
    int i;
    if (paramInt2 == 2)
    {
      i = 0;
      paramInt1 = localw.bf(paramInt1 - m, i);
      if (paramInt1 == -1) {
        break label59;
      }
      paramInt1 = m + paramInt1;
    }
    label59:
    do
    {
      return paramInt1;
      i = paramInt2;
      break;
      paramInt1 = k + 1;
      if (paramInt1 < this.beC) {
        return eO(paramInt1);
      }
      paramInt1 = j;
    } while (paramInt2 == 2);
    return -1;
  }
  
  protected abstract int eL(int paramInt);
  
  protected abstract int eM(int paramInt);
  
  protected abstract int eN(int paramInt);
  
  protected abstract int eO(int paramInt);
  
  protected abstract Object eP(int paramInt);
  
  protected abstract w ti();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a
 * JD-Core Version:    0.7.0.1
 */