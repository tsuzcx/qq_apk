package com.d.a.c;

import com.d.a.a.a.a;

public final class k<V>
  extends b
  implements j
{
  private transient long[] bVJ;
  protected final j bVK = this;
  private transient V[] bVv;
  
  private boolean a(l<V> paraml)
  {
    long[] arrayOfLong = this.bVJ;
    Object[] arrayOfObject = this.bVv;
    int j;
    for (int i = arrayOfLong.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((b(arrayOfObject, j)) && (!paraml.b(arrayOfLong[j], au(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  private int aJ(long paramLong)
  {
    Object[] arrayOfObject = this.bVv;
    long[] arrayOfLong = this.bVJ;
    int n = arrayOfLong.length;
    int j = this.bVK.aH(paramLong) & 0x7FFFFFFF;
    int i = j % n;
    if (d(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((b(arrayOfObject, i)) && (arrayOfLong[i] == paramLong)) {
        return -i - 1;
      }
      int i1 = j % (n - 2) + 1;
      int m;
      if (c(arrayOfObject, i))
      {
        j = i;
        m = i;
      }
      for (;;)
      {
        k = m - i1;
        i = k;
        if (k < 0) {
          i = k + n;
        }
        k = j;
        if (j == -1)
        {
          k = j;
          if (c(arrayOfObject, i)) {
            k = i;
          }
        }
        if (b(arrayOfObject, i))
        {
          j = k;
          m = i;
          if (arrayOfLong[i] != paramLong) {}
        }
        else
        {
          j = i;
          if (!c(arrayOfObject, i)) {
            break;
          }
          for (;;)
          {
            j = i;
            if (d(arrayOfObject, i)) {
              break;
            }
            if (!c(arrayOfObject, i))
            {
              j = i;
              if (arrayOfLong[i] == paramLong) {
                break;
              }
            }
            j = i - i1;
            i = j;
            if (j < 0) {
              i = j + n;
            }
          }
          j = -1;
          m = i;
        }
      }
      if (b(arrayOfObject, j)) {
        return -j - 1;
      }
      i = j;
    } while (k == -1);
    return k;
  }
  
  private static <V> V au(V paramV)
  {
    V ? = paramV;
    if (paramV == n.bVQ) {
      ? = null;
    }
    return ?;
  }
  
  private static boolean b(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject = paramArrayOfObject[paramInt];
    return (paramArrayOfObject != null) && (paramArrayOfObject != n.bVP);
  }
  
  private static boolean c(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == n.bVP;
  }
  
  private static boolean d(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == null;
  }
  
  public final V a(long paramLong, V paramV)
  {
    Object localObject1 = null;
    int j = aJ(paramLong);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject1 = au(this.bVv[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = d(this.bVv, j))
    {
      this.bVJ[j] = paramLong;
      Object[] arrayOfObject = this.bVv;
      Object localObject2 = paramV;
      if (paramV == null) {
        localObject2 = n.bVQ;
      }
      arrayOfObject[j] = localObject2;
      if (i != 0) {
        bn(bool);
      }
      return localObject1;
    }
  }
  
  public final boolean a(s<V> params)
  {
    Object[] arrayOfObject = this.bVv;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((b(arrayOfObject, j)) && (!params.as(au(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public final int aH(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong);
  }
  
  protected final int aI(long paramLong)
  {
    long[] arrayOfLong = this.bVJ;
    Object[] arrayOfObject = this.bVv;
    int k = arrayOfLong.length;
    int m = 0x7FFFFFFF & this.bVK.aH(paramLong);
    int i = m % k;
    int j = i;
    if (!d(arrayOfObject, i)) {
      if (!c(arrayOfObject, i))
      {
        j = i;
        if (arrayOfLong[i] == paramLong) {}
      }
      else
      {
        j = i;
        do
        {
          do
          {
            j -= m % (k - 2) + 1;
            i = j;
            if (j < 0) {
              i = j + k;
            }
            j = i;
            if (d(arrayOfObject, i)) {
              break;
            }
            j = i;
          } while (c(arrayOfObject, i));
          j = i;
        } while (arrayOfLong[i] != paramLong);
        j = i;
      }
    }
    i = j;
    if (d(arrayOfObject, j)) {
      i = -1;
    }
    return i;
  }
  
  protected final int capacity()
  {
    return this.bVv.length;
  }
  
  public final void clear()
  {
    super.clear();
    long[] arrayOfLong = this.bVJ;
    Object[] arrayOfObject = this.bVv;
    int j;
    for (int i = arrayOfLong.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      arrayOfLong[j] = 0L;
      arrayOfObject[j] = null;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof k)) {}
    do
    {
      return false;
      paramObject = (k)paramObject;
    } while (paramObject.size() != size());
    return a(new a(paramObject));
  }
  
  public final V get(long paramLong)
  {
    int i = aI(paramLong);
    if (i < 0) {
      return null;
    }
    return au(this.bVv[i]);
  }
  
  protected final int gi(int paramInt)
  {
    paramInt = super.gi(paramInt);
    this.bVv = ((Object[])new Object[paramInt]);
    this.bVJ = new long[paramInt];
    return paramInt;
  }
  
  protected final void gj(int paramInt)
  {
    int i = this.bVJ.length;
    long[] arrayOfLong = this.bVJ;
    Object[] arrayOfObject = this.bVv;
    this.bVJ = new long[paramInt];
    this.bVv = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (b(arrayOfObject, i))
        {
          long l = arrayOfLong[i];
          paramInt = aJ(l);
          this.bVJ[paramInt] = l;
          this.bVv[paramInt] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final int hashCode()
  {
    b localb = new b();
    a(localb);
    return localb.h;
  }
  
  protected final void removeAt(int paramInt)
  {
    this.bVv[paramInt] = n.bVP;
    super.removeAt(paramInt);
  }
  
  static final class a<V>
    implements l<V>
  {
    private final k<V> bVL;
    
    a(k<V> paramk)
    {
      this.bVL = paramk;
    }
    
    public final boolean b(long paramLong, V paramV)
    {
      if (this.bVL.aI(paramLong) >= 0)
      {
        Object localObject = this.bVL.get(paramLong);
        if ((paramV == localObject) || ((paramV != null) && (paramV.equals(localObject)))) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
      return false;
    }
  }
  
  final class b
    implements l<V>
  {
    int h;
    
    b() {}
    
    public final boolean b(long paramLong, V paramV)
    {
      this.h += (k.this.bVK.aH(paramLong) ^ a.al(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */