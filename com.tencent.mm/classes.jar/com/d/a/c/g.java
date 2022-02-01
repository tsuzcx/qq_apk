package com.d.a.c;

import com.d.a.a.a.a;

public final class g<V>
  extends b
  implements f
{
  public transient V[] bXN;
  private transient int[] bXU;
  protected final f bXV = this;
  
  private boolean a(h<V> paramh)
  {
    int[] arrayOfInt = this.bXU;
    Object[] arrayOfObject = this.bXN;
    int j;
    for (int i = arrayOfInt.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((b(arrayOfObject, j)) && (!paramh.e(arrayOfInt[j], au(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public static <V> V au(V paramV)
  {
    V ? = paramV;
    if (paramV == n.bYi) {
      ? = null;
    }
    return ?;
  }
  
  public static boolean b(Object[] paramArrayOfObject, int paramInt)
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
  
  private int gD(int paramInt)
  {
    Object[] arrayOfObject = this.bXN;
    int[] arrayOfInt = this.bXU;
    int n = arrayOfInt.length;
    int j = this.bXV.gB(paramInt) & 0x7FFFFFFF;
    int i = j % n;
    if (d(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((b(arrayOfObject, i)) && (arrayOfInt[i] == paramInt)) {
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
          if (arrayOfInt[i] != paramInt) {}
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
      if (b(arrayOfObject, j)) {
        return -j - 1;
      }
      i = j;
    } while (k == -1);
    return k;
  }
  
  public final int[] As()
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = this.bXU;
    Object[] arrayOfObject = this.bXN;
    int i = arrayOfInt2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (b(arrayOfObject, k))
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
  
  protected final int capacity()
  {
    return this.bXN.length;
  }
  
  public final void clear()
  {
    super.clear();
    int[] arrayOfInt = this.bXU;
    Object[] arrayOfObject = this.bXN;
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
  
  public final V d(int paramInt, V paramV)
  {
    Object localObject = null;
    int j = gD(paramInt);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject = au(this.bXN[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = d(this.bXN, j))
    {
      this.bXU[j] = paramInt;
      this.bXN[j] = paramV;
      if (i != 0) {
        bo(bool);
      }
      return localObject;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof g)) {}
    do
    {
      return false;
      paramObject = (g)paramObject;
    } while (paramObject.size() != size());
    return a(new a(paramObject));
  }
  
  public final int gB(int paramInt)
  {
    return paramInt;
  }
  
  protected final int gC(int paramInt)
  {
    int[] arrayOfInt = this.bXU;
    Object[] arrayOfObject = this.bXN;
    int k = arrayOfInt.length;
    int m = 0x7FFFFFFF & this.bXV.gB(paramInt);
    int i = m % k;
    int j = i;
    if (!d(arrayOfObject, i)) {
      if (!c(arrayOfObject, i))
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
            if (d(arrayOfObject, i)) {
              break;
            }
            j = i;
          } while (c(arrayOfObject, i));
          j = i;
        } while (arrayOfInt[i] != paramInt);
        j = i;
      }
    }
    paramInt = j;
    if (d(arrayOfObject, j)) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final V get(int paramInt)
  {
    paramInt = gC(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return au(this.bXN[paramInt]);
  }
  
  protected final int gx(int paramInt)
  {
    paramInt = super.gx(paramInt);
    this.bXN = ((Object[])new Object[paramInt]);
    this.bXU = new int[paramInt];
    return paramInt;
  }
  
  protected final void gy(int paramInt)
  {
    int i = this.bXU.length;
    int[] arrayOfInt = this.bXU;
    Object[] arrayOfObject = this.bXN;
    this.bXU = new int[paramInt];
    this.bXN = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (b(arrayOfObject, i))
        {
          paramInt = arrayOfInt[i];
          int j = gD(paramInt);
          this.bXU[j] = paramInt;
          this.bXN[j] = arrayOfObject[i];
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
    implements h<V>
  {
    private final g<V> bXW;
    
    a(g<V> paramg)
    {
      this.bXW = paramg;
    }
    
    public final boolean e(int paramInt, V paramV)
    {
      if (this.bXW.gC(paramInt) >= 0)
      {
        Object localObject = this.bXW.get(paramInt);
        if ((paramV == localObject) || ((paramV != null) && (paramV.equals(localObject)))) {}
        for (paramInt = 1; paramInt != 0; paramInt = 0) {
          return true;
        }
      }
      return false;
    }
  }
  
  final class b
    implements h<V>
  {
    int h;
    
    b() {}
    
    public final boolean e(int paramInt, V paramV)
    {
      this.h += (g.this.bXV.gB(paramInt) ^ a.al(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */