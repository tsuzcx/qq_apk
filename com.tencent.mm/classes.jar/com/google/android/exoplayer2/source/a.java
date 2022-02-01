package com.google.android.exoplayer2.source;

import android.util.Pair;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;

abstract class a
  extends w
{
  private final int bva;
  
  public a(int paramInt)
  {
    this.bva = paramInt;
  }
  
  public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
  {
    int i = ev(paramInt);
    int j = ey(i);
    int k = ex(i);
    vk().a(paramInt - k, parama, paramBoolean);
    parama.bdi = (j + parama.bdi);
    if (paramBoolean) {
      parama.bcT = Pair.create(ez(i), parama.bcT);
    }
    return parama;
  }
  
  public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
  {
    int j = ew(paramInt);
    int i = ey(j);
    j = ex(j);
    vk().a(paramInt - i, paramb, paramBoolean, paramLong);
    paramb.bey += j;
    paramb.bez += j;
    return paramb;
  }
  
  public final int aZ(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = ew(paramInt1);
    int m = ey(k);
    w localw = vk();
    int i;
    if (paramInt2 == 2)
    {
      i = 0;
      paramInt1 = localw.aZ(paramInt1 - m, i);
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
      if (paramInt1 < this.bva) {
        return ey(paramInt1);
      }
      paramInt1 = j;
    } while (paramInt2 == 2);
    return -1;
  }
  
  public final int ae(Object paramObject)
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
        i = ag(paramObject);
      } while (i == -1);
      j = vk().ae(localObject);
    } while (j == -1);
    return ex(i) + j;
  }
  
  protected abstract int ag(Object paramObject);
  
  protected abstract int ev(int paramInt);
  
  protected abstract int ew(int paramInt);
  
  protected abstract int ex(int paramInt);
  
  protected abstract int ey(int paramInt);
  
  protected abstract Object ez(int paramInt);
  
  protected abstract w vk();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.a
 * JD-Core Version:    0.7.0.1
 */