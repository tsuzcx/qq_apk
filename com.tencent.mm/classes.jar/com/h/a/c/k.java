package com.h.a.c;

public final class k<V>
  extends b
  implements j
{
  private transient V[] ecg;
  private transient long[] ect;
  protected final j ecu = this;
  
  private boolean a(l<V> paraml)
  {
    long[] arrayOfLong = this.ect;
    Object[] arrayOfObject = this.ecg;
    int j;
    for (int i = arrayOfLong.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((j(arrayOfObject, j)) && (!paraml.g(arrayOfLong[j], unwrapNull(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  private int dq(long paramLong)
  {
    Object[] arrayOfObject = this.ecg;
    long[] arrayOfLong = this.ect;
    int n = arrayOfLong.length;
    int j = this.ecu.dp(paramLong) & 0x7FFFFFFF;
    int i = j % n;
    if (l(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((j(arrayOfObject, i)) && (arrayOfLong[i] == paramLong)) {
        return -i - 1;
      }
      int i1 = j % (n - 2) + 1;
      int m;
      if (k(arrayOfObject, i))
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
          if (k(arrayOfObject, i)) {
            k = i;
          }
        }
        if (j(arrayOfObject, i))
        {
          j = k;
          m = i;
          if (arrayOfLong[i] != paramLong) {}
        }
        else
        {
          j = i;
          if (!k(arrayOfObject, i)) {
            break;
          }
          for (;;)
          {
            j = i;
            if (l(arrayOfObject, i)) {
              break;
            }
            if (!k(arrayOfObject, i))
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
      if (j(arrayOfObject, j)) {
        return -j - 1;
      }
      i = j;
    } while (k == -1);
    return k;
  }
  
  private static boolean j(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject = paramArrayOfObject[paramInt];
    return (paramArrayOfObject != null) && (paramArrayOfObject != n.ecz);
  }
  
  private static boolean k(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == n.ecz;
  }
  
  private static boolean l(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == null;
  }
  
  private static <V> V unwrapNull(V paramV)
  {
    V ? = paramV;
    if (paramV == n.ecA) {
      ? = null;
    }
    return ?;
  }
  
  public final V A(long paramLong)
  {
    int i = index(paramLong);
    if (i < 0) {
      return null;
    }
    return unwrapNull(this.ecg[i]);
  }
  
  protected final int UG()
  {
    return this.ecg.length;
  }
  
  public final boolean a(s<V> params)
  {
    Object[] arrayOfObject = this.ecg;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((j(arrayOfObject, j)) && (!params.bU(unwrapNull(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  protected final void bj(int paramInt)
  {
    this.ecg[paramInt] = n.ecz;
    super.bj(paramInt);
  }
  
  public final void clear()
  {
    super.clear();
    long[] arrayOfLong = this.ect;
    Object[] arrayOfObject = this.ecg;
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
  
  public final int dp(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong);
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
  
  public final V f(long paramLong, V paramV)
  {
    Object localObject1 = null;
    int j = dq(paramLong);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject1 = unwrapNull(this.ecg[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = l(this.ecg, j))
    {
      this.ect[j] = paramLong;
      Object[] arrayOfObject = this.ecg;
      Object localObject2 = paramV;
      if (paramV == null) {
        localObject2 = n.ecA;
      }
      arrayOfObject[j] = localObject2;
      if (i != 0) {
        cD(bool);
      }
      return localObject1;
    }
  }
  
  public final int hashCode()
  {
    b localb = new b();
    a(localb);
    return localb.h;
  }
  
  protected final int index(long paramLong)
  {
    long[] arrayOfLong = this.ect;
    Object[] arrayOfObject = this.ecg;
    int k = arrayOfLong.length;
    int m = 0x7FFFFFFF & this.ecu.dp(paramLong);
    int i = m % k;
    int j = i;
    if (!l(arrayOfObject, i)) {
      if (!k(arrayOfObject, i))
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
            if (l(arrayOfObject, i)) {
              break;
            }
            j = i;
          } while (k(arrayOfObject, i));
          j = i;
        } while (arrayOfLong[i] != paramLong);
        j = i;
      }
    }
    i = j;
    if (l(arrayOfObject, j)) {
      i = -1;
    }
    return i;
  }
  
  protected final int lU(int paramInt)
  {
    paramInt = super.lU(paramInt);
    this.ecg = ((Object[])new Object[paramInt]);
    this.ect = new long[paramInt];
    return paramInt;
  }
  
  protected final void lV(int paramInt)
  {
    int i = this.ect.length;
    long[] arrayOfLong = this.ect;
    Object[] arrayOfObject = this.ecg;
    this.ect = new long[paramInt];
    this.ecg = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (j(arrayOfObject, i))
        {
          long l = arrayOfLong[i];
          paramInt = dq(l);
          this.ect[paramInt] = l;
          this.ecg[paramInt] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  static final class a<V>
    implements l<V>
  {
    private final k<V> ecv;
    
    a(k<V> paramk)
    {
      this.ecv = paramk;
    }
    
    public final boolean g(long paramLong, V paramV)
    {
      if (this.ecv.index(paramLong) >= 0)
      {
        Object localObject = this.ecv.A(paramLong);
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
    
    public final boolean g(long paramLong, V paramV)
    {
      this.h += (k.this.ecu.dp(paramLong) ^ com.h.a.a.a.b.bO(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.c.k
 * JD-Core Version:    0.7.0.1
 */