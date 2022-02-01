package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

abstract class a
  extends w
{
  private final int cYv;
  
  public a(int paramInt)
  {
    this.cYv = paramInt;
  }
  
  protected abstract w SL();
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    int i = ib(paramInt);
    int j = ie(i);
    int k = id(i);
    SL().a(paramInt - k, parama, paramBoolean);
    parama.cGF = (j + parama.cGF);
    if (paramBoolean) {
      parama.cGq = Pair.create(jdMethod_if(i), parama.cGq);
    }
    return parama;
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    int j = ic(paramInt);
    int i = ie(j);
    j = id(j);
    SL().a(paramInt - i, paramb, paramBoolean, paramLong);
    paramb.cHV += j;
    paramb.cHW += j;
    return paramb;
  }
  
  public final int bf(Object paramObject)
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
        i = bh(paramObject);
      } while (i == -1);
      j = SL().bf(localObject);
    } while (j == -1);
    return id(i) + j;
  }
  
  protected abstract int bh(Object paramObject);
  
  public final int ca(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = ic(paramInt1);
    int m = ie(k);
    w localw = SL();
    int i;
    if (paramInt2 == 2)
    {
      i = 0;
      paramInt1 = localw.ca(paramInt1 - m, i);
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
      if (paramInt1 < this.cYv) {
        return ie(paramInt1);
      }
      paramInt1 = j;
    } while (paramInt2 == 2);
    return -1;
  }
  
  protected abstract int ib(int paramInt);
  
  protected abstract int ic(int paramInt);
  
  protected abstract int id(int paramInt);
  
  protected abstract int ie(int paramInt);
  
  protected abstract Object jdMethod_if(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a
 * JD-Core Version:    0.7.0.1
 */