package com.d.a.c;

import com.d.a.a.a.a;

public final class k<V>
  extends b
  implements j
{
  private transient V[] bXN;
  private transient long[] bYb;
  protected final j bYc = this;
  
  private boolean a(l<V> paraml)
  {
    long[] arrayOfLong = this.bYb;
    Object[] arrayOfObject = this.bXN;
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
  
  private int aN(long paramLong)
  {
    Object[] arrayOfObject = this.bXN;
    long[] arrayOfLong = this.bYb;
    int n = arrayOfLong.length;
    int j = this.bYc.aL(paramLong) & 0x7FFFFFFF;
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
    if (paramV == n.bYi) {
      ? = null;
    }
    return ?;
  }
  
  private static boolean b(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject = paramArrayOfObject[paramInt];
    return (paramArrayOfObject != null) && (paramArrayOfObject != n.bYh);
  }
  
  private static boolean c(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == n.bYh;
  }
  
  private static boolean d(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == null;
  }
  
  public final V a(long paramLong, V paramV)
  {
    Object localObject1 = null;
    int j = aN(paramLong);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject1 = au(this.bXN[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = d(this.bXN, j))
    {
      this.bYb[j] = paramLong;
      Object[] arrayOfObject = this.bXN;
      Object localObject2 = paramV;
      if (paramV == null) {
        localObject2 = n.bYi;
      }
      arrayOfObject[j] = localObject2;
      if (i != 0) {
        bo(bool);
      }
      return localObject1;
    }
  }
  
  public final boolean a(s<V> params)
  {
    Object[] arrayOfObject = this.bXN;
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
  
  public final int aL(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong);
  }
  
  protected final int aM(long paramLong)
  {
    long[] arrayOfLong = this.bYb;
    Object[] arrayOfObject = this.bXN;
    int k = arrayOfLong.length;
    int m = 0x7FFFFFFF & this.bYc.aL(paramLong);
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
    return this.bXN.length;
  }
  
  public final void clear()
  {
    super.clear();
    long[] arrayOfLong = this.bYb;
    Object[] arrayOfObject = this.bXN;
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
    int i = aM(paramLong);
    if (i < 0) {
      return null;
    }
    return au(this.bXN[i]);
  }
  
  protected final int gx(int paramInt)
  {
    paramInt = super.gx(paramInt);
    this.bXN = ((Object[])new Object[paramInt]);
    this.bYb = new long[paramInt];
    return paramInt;
  }
  
  protected final void gy(int paramInt)
  {
    int i = this.bYb.length;
    long[] arrayOfLong = this.bYb;
    Object[] arrayOfObject = this.bXN;
    this.bYb = new long[paramInt];
    this.bXN = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (b(arrayOfObject, i))
        {
          long l = arrayOfLong[i];
          paramInt = aN(l);
          this.bYb[paramInt] = l;
          this.bXN[paramInt] = arrayOfObject[i];
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
    this.bXN[paramInt] = n.bYh;
    super.removeAt(paramInt);
  }
  
  static final class a<V>
    implements l<V>
  {
    private final k<V> bYd;
    
    a(k<V> paramk)
    {
      this.bYd = paramk;
    }
    
    public final boolean b(long paramLong, V paramV)
    {
      if (this.bYd.aM(paramLong) >= 0)
      {
        Object localObject = this.bYd.get(paramLong);
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
      this.h += (k.this.bYc.aL(paramLong) ^ a.al(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */