package com.d.a.c;

import com.d.a.a.a.a;

public final class g<V>
  extends b
  implements f
{
  private transient int[] bVC;
  protected final f bVD = this;
  public transient V[] bVv;
  
  private boolean a(h<V> paramh)
  {
    int[] arrayOfInt = this.bVC;
    Object[] arrayOfObject = this.bVv;
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
    if (paramV == n.bVQ) {
      ? = null;
    }
    return ?;
  }
  
  public static boolean b(Object[] paramArrayOfObject, int paramInt)
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
  
  private int go(int paramInt)
  {
    Object[] arrayOfObject = this.bVv;
    int[] arrayOfInt = this.bVC;
    int n = arrayOfInt.length;
    int j = this.bVD.gm(paramInt) & 0x7FFFFFFF;
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
  
  public final int[] Af()
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = this.bVC;
    Object[] arrayOfObject = this.bVv;
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
    return this.bVv.length;
  }
  
  public final void clear()
  {
    super.clear();
    int[] arrayOfInt = this.bVC;
    Object[] arrayOfObject = this.bVv;
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
    int j = go(paramInt);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject = au(this.bVv[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = d(this.bVv, j))
    {
      this.bVC[j] = paramInt;
      this.bVv[j] = paramV;
      if (i != 0) {
        bn(bool);
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
  
  public final V get(int paramInt)
  {
    paramInt = gn(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return au(this.bVv[paramInt]);
  }
  
  protected final int gi(int paramInt)
  {
    paramInt = super.gi(paramInt);
    this.bVv = ((Object[])new Object[paramInt]);
    this.bVC = new int[paramInt];
    return paramInt;
  }
  
  protected final void gj(int paramInt)
  {
    int i = this.bVC.length;
    int[] arrayOfInt = this.bVC;
    Object[] arrayOfObject = this.bVv;
    this.bVC = new int[paramInt];
    this.bVv = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (b(arrayOfObject, i))
        {
          paramInt = arrayOfInt[i];
          int j = go(paramInt);
          this.bVC[j] = paramInt;
          this.bVv[j] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final int gm(int paramInt)
  {
    return paramInt;
  }
  
  protected final int gn(int paramInt)
  {
    int[] arrayOfInt = this.bVC;
    Object[] arrayOfObject = this.bVv;
    int k = arrayOfInt.length;
    int m = 0x7FFFFFFF & this.bVD.gm(paramInt);
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
    implements h<V>
  {
    private final g<V> bVE;
    
    a(g<V> paramg)
    {
      this.bVE = paramg;
    }
    
    public final boolean e(int paramInt, V paramV)
    {
      if (this.bVE.gn(paramInt) >= 0)
      {
        Object localObject = this.bVE.get(paramInt);
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
      this.h += (g.this.bVD.gm(paramInt) ^ a.al(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.d.a.c.g
 * JD-Core Version:    0.7.0.1
 */