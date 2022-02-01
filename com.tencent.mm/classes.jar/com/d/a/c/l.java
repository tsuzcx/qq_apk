package com.d.a.c;

import com.d.a.a.a.b;

public final class l<V>
  extends c
  implements k
{
  private transient V[] clO;
  private transient long[] cmb;
  protected final k cmc = this;
  
  private boolean a(m<V> paramm)
  {
    long[] arrayOfLong = this.cmb;
    Object[] arrayOfObject = this.clO;
    int j;
    for (int i = arrayOfLong.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((c(arrayOfObject, j)) && (!paramm.c(arrayOfLong[j], aC(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  private static <V> V aC(V paramV)
  {
    V ? = paramV;
    if (paramV == o.cmi) {
      ? = null;
    }
    return ?;
  }
  
  private int aY(long paramLong)
  {
    Object[] arrayOfObject = this.clO;
    long[] arrayOfLong = this.cmb;
    int n = arrayOfLong.length;
    int j = this.cmc.aW(paramLong) & 0x7FFFFFFF;
    int i = j % n;
    if (e(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((c(arrayOfObject, i)) && (arrayOfLong[i] == paramLong)) {
        return -i - 1;
      }
      int i1 = j % (n - 2) + 1;
      int m;
      if (d(arrayOfObject, i))
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
          if (d(arrayOfObject, i)) {
            k = i;
          }
        }
        if (c(arrayOfObject, i))
        {
          j = k;
          m = i;
          if (arrayOfLong[i] != paramLong) {}
        }
        else
        {
          j = i;
          if (!d(arrayOfObject, i)) {
            break;
          }
          for (;;)
          {
            j = i;
            if (e(arrayOfObject, i)) {
              break;
            }
            if (!d(arrayOfObject, i))
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
      if (c(arrayOfObject, j)) {
        return -j - 1;
      }
      i = j;
    } while (k == -1);
    return k;
  }
  
  private static boolean c(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject = paramArrayOfObject[paramInt];
    return (paramArrayOfObject != null) && (paramArrayOfObject != o.cmh);
  }
  
  private static boolean d(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == o.cmh;
  }
  
  private static boolean e(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == null;
  }
  
  public final boolean a(t<V> paramt)
  {
    Object[] arrayOfObject = this.clO;
    int j;
    for (int i = arrayOfObject.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((c(arrayOfObject, j)) && (!paramt.az(aC(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  protected final void aK(int paramInt)
  {
    this.clO[paramInt] = o.cmh;
    super.aK(paramInt);
  }
  
  public final int aW(long paramLong)
  {
    return (int)(paramLong >> 32 ^ paramLong);
  }
  
  public final V aX(long paramLong)
  {
    int i = index(paramLong);
    if (i < 0) {
      return null;
    }
    return aC(this.clO[i]);
  }
  
  public final void clear()
  {
    super.clear();
    long[] arrayOfLong = this.cmb;
    Object[] arrayOfObject = this.clO;
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
  
  public final V d(long paramLong, V paramV)
  {
    Object localObject1 = null;
    int j = aY(paramLong);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject1 = aC(this.clO[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = e(this.clO, j))
    {
      this.cmb[j] = paramLong;
      Object[] arrayOfObject = this.clO;
      Object localObject2 = paramV;
      if (paramV == null) {
        localObject2 = o.cmi;
      }
      arrayOfObject[j] = localObject2;
      if (i != 0) {
        bY(bool);
      }
      return localObject1;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof l)) {}
    do
    {
      return false;
      paramObject = (l)paramObject;
    } while (paramObject.size() != size());
    return a(new a(paramObject));
  }
  
  public final int hashCode()
  {
    b localb = new b();
    a(localb);
    return localb.h;
  }
  
  protected final int index(long paramLong)
  {
    long[] arrayOfLong = this.cmb;
    Object[] arrayOfObject = this.clO;
    int k = arrayOfLong.length;
    int m = 0x7FFFFFFF & this.cmc.aW(paramLong);
    int i = m % k;
    int j = i;
    if (!e(arrayOfObject, i)) {
      if (!d(arrayOfObject, i))
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
            if (e(arrayOfObject, i)) {
              break;
            }
            j = i;
          } while (d(arrayOfObject, i));
          j = i;
        } while (arrayOfLong[i] != paramLong);
        j = i;
      }
    }
    i = j;
    if (e(arrayOfObject, j)) {
      i = -1;
    }
    return i;
  }
  
  protected final int ip(int paramInt)
  {
    paramInt = super.ip(paramInt);
    this.clO = ((Object[])new Object[paramInt]);
    this.cmb = new long[paramInt];
    return paramInt;
  }
  
  protected final void iq(int paramInt)
  {
    int i = this.cmb.length;
    long[] arrayOfLong = this.cmb;
    Object[] arrayOfObject = this.clO;
    this.cmb = new long[paramInt];
    this.clO = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (c(arrayOfObject, i))
        {
          long l = arrayOfLong[i];
          paramInt = aY(l);
          this.cmb[paramInt] = l;
          this.clO[paramInt] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  protected final int vh()
  {
    return this.clO.length;
  }
  
  static final class a<V>
    implements m<V>
  {
    private final l<V> cmd;
    
    a(l<V> paraml)
    {
      this.cmd = paraml;
    }
    
    public final boolean c(long paramLong, V paramV)
    {
      if (this.cmd.index(paramLong) >= 0)
      {
        Object localObject = this.cmd.aX(paramLong);
        if ((paramV == localObject) || ((paramV != null) && (paramV.equals(localObject)))) {}
        for (int i = 1; i != 0; i = 0) {
          return true;
        }
      }
      return false;
    }
  }
  
  final class b
    implements m<V>
  {
    int h;
    
    b() {}
    
    public final boolean c(long paramLong, V paramV)
    {
      this.h += (l.this.cmc.aW(paramLong) ^ b.at(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.l
 * JD-Core Version:    0.7.0.1
 */