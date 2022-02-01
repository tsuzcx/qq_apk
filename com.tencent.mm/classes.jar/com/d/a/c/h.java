package com.d.a.c;

import com.d.a.a.a.b;

public final class h<V>
  extends c
  implements g
{
  public transient V[] clO;
  private transient int[] clU;
  protected final g clV = this;
  
  private boolean a(i<V> parami)
  {
    int[] arrayOfInt = this.clU;
    Object[] arrayOfObject = this.clO;
    int j;
    for (int i = arrayOfInt.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((c(arrayOfObject, j)) && (!parami.g(arrayOfInt[j], aC(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public static <V> V aC(V paramV)
  {
    V ? = paramV;
    if (paramV == o.cmi) {
      ? = null;
    }
    return ?;
  }
  
  public static boolean c(Object[] paramArrayOfObject, int paramInt)
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
  
  private int iw(int paramInt)
  {
    Object[] arrayOfObject = this.clO;
    int[] arrayOfInt = this.clU;
    int n = arrayOfInt.length;
    int j = this.clV.iu(paramInt) & 0x7FFFFFFF;
    int i = j % n;
    if (e(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((c(arrayOfObject, i)) && (arrayOfInt[i] == paramInt)) {
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
          if (arrayOfInt[i] != paramInt) {}
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
              if (arrayOfInt[i] == paramInt) {
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
  
  public final int[] Lq()
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = this.clU;
    Object[] arrayOfObject = this.clO;
    int i = arrayOfInt2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (c(arrayOfObject, k))
        {
          arrayOfInt1[j] = arrayOfInt2[k];
          j += 1;
          i = k;
        }
      }
      else {
        return arrayOfInt1;
      }
      i = k;
    }
  }
  
  protected final void aK(int paramInt)
  {
    this.clO[paramInt] = o.cmh;
    super.aK(paramInt);
  }
  
  public final void clear()
  {
    super.clear();
    int[] arrayOfInt = this.clU;
    Object[] arrayOfObject = this.clO;
    int j;
    for (int i = arrayOfInt.length;; i = j)
    {
      j = i - 1;
      if (i <= 0) {
        break;
      }
      arrayOfInt[j] = 0;
      arrayOfObject[j] = null;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof h)) {}
    do
    {
      return false;
      paramObject = (h)paramObject;
    } while (paramObject.size() != size());
    return a(new a(paramObject));
  }
  
  public final V get(int paramInt)
  {
    paramInt = iv(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return aC(this.clO[paramInt]);
  }
  
  public final V h(int paramInt, V paramV)
  {
    Object localObject = null;
    int j = iw(paramInt);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject = aC(this.clO[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = e(this.clO, j))
    {
      this.clU[j] = paramInt;
      this.clO[j] = paramV;
      if (i != 0) {
        bY(bool);
      }
      return localObject;
    }
  }
  
  public final int hashCode()
  {
    b localb = new b();
    a(localb);
    return localb.h;
  }
  
  protected final int ip(int paramInt)
  {
    paramInt = super.ip(paramInt);
    this.clO = ((Object[])new Object[paramInt]);
    this.clU = new int[paramInt];
    return paramInt;
  }
  
  protected final void iq(int paramInt)
  {
    int i = this.clU.length;
    int[] arrayOfInt = this.clU;
    Object[] arrayOfObject = this.clO;
    this.clU = new int[paramInt];
    this.clO = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (c(arrayOfObject, i))
        {
          paramInt = arrayOfInt[i];
          int j = iw(paramInt);
          this.clU[j] = paramInt;
          this.clO[j] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final int iu(int paramInt)
  {
    return paramInt;
  }
  
  protected final int iv(int paramInt)
  {
    int[] arrayOfInt = this.clU;
    Object[] arrayOfObject = this.clO;
    int k = arrayOfInt.length;
    int m = 0x7FFFFFFF & this.clV.iu(paramInt);
    int i = m % k;
    int j = i;
    if (!e(arrayOfObject, i)) {
      if (!d(arrayOfObject, i))
      {
        j = i;
        if (arrayOfInt[i] == paramInt) {}
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
        } while (arrayOfInt[i] != paramInt);
        j = i;
      }
    }
    paramInt = j;
    if (e(arrayOfObject, j)) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  protected final int vh()
  {
    return this.clO.length;
  }
  
  static final class a<V>
    implements i<V>
  {
    private final h<V> clW;
    
    a(h<V> paramh)
    {
      this.clW = paramh;
    }
    
    public final boolean g(int paramInt, V paramV)
    {
      if (this.clW.iv(paramInt) >= 0)
      {
        Object localObject = this.clW.get(paramInt);
        if ((paramV == localObject) || ((paramV != null) && (paramV.equals(localObject)))) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0) {
          return true;
        }
      }
      return false;
    }
  }
  
  final class b
    implements i<V>
  {
    int h;
    
    b() {}
    
    public final boolean g(int paramInt, V paramV)
    {
      this.h += (h.this.clV.iu(paramInt) ^ b.at(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.d.a.c.h
 * JD-Core Version:    0.7.0.1
 */