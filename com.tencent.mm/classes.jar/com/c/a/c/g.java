package com.c.a.c;

import com.c.a.a.a.a;

public final class g<V>
  extends b
  implements f
{
  public transient V[] cql;
  private transient int[] cqr;
  protected final f cqs = this;
  
  private boolean a(h<V> paramh)
  {
    int[] arrayOfInt = this.cqr;
    Object[] arrayOfObject = this.cql;
    int j;
    for (int i = arrayOfInt.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((b(arrayOfObject, j)) && (!paramh.f(arrayOfInt[j], aF(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public static <V> V aF(V paramV)
  {
    V ? = paramV;
    if (paramV == n.cqF) {
      ? = null;
    }
    return ?;
  }
  
  public static boolean b(Object[] paramArrayOfObject, int paramInt)
  {
    paramArrayOfObject = paramArrayOfObject[paramInt];
    return (paramArrayOfObject != null) && (paramArrayOfObject != n.cqE);
  }
  
  private static boolean c(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == n.cqE;
  }
  
  private static boolean d(Object[] paramArrayOfObject, int paramInt)
  {
    return paramArrayOfObject[paramInt] == null;
  }
  
  private int hC(int paramInt)
  {
    Object[] arrayOfObject = this.cql;
    int[] arrayOfInt = this.cqr;
    int n = arrayOfInt.length;
    int j = this.cqs.hA(paramInt) & 0x7FFFFFFF;
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
  
  public final int[] Kv()
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = this.cqr;
    Object[] arrayOfObject = this.cql;
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
    return this.cql.length;
  }
  
  public final void clear()
  {
    super.clear();
    int[] arrayOfInt = this.cqr;
    Object[] arrayOfObject = this.cql;
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
  
  public final V e(int paramInt, V paramV)
  {
    Object localObject = null;
    int j = hC(paramInt);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject = aF(this.cql[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = d(this.cql, j))
    {
      this.cqr[j] = paramInt;
      this.cql[j] = paramV;
      if (i != 0) {
        bO(bool);
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
    paramInt = hB(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return aF(this.cql[paramInt]);
  }
  
  public final int hA(int paramInt)
  {
    return paramInt;
  }
  
  protected final int hB(int paramInt)
  {
    int[] arrayOfInt = this.cqr;
    Object[] arrayOfObject = this.cql;
    int k = arrayOfInt.length;
    int m = 0x7FFFFFFF & this.cqs.hA(paramInt);
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
  
  protected final int hw(int paramInt)
  {
    paramInt = super.hw(paramInt);
    this.cql = ((Object[])new Object[paramInt]);
    this.cqr = new int[paramInt];
    return paramInt;
  }
  
  protected final void hx(int paramInt)
  {
    int i = this.cqr.length;
    int[] arrayOfInt = this.cqr;
    Object[] arrayOfObject = this.cql;
    this.cqr = new int[paramInt];
    this.cql = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (b(arrayOfObject, i))
        {
          paramInt = arrayOfInt[i];
          int j = hC(paramInt);
          this.cqr[j] = paramInt;
          this.cql[j] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  protected final void removeAt(int paramInt)
  {
    this.cql[paramInt] = n.cqE;
    super.removeAt(paramInt);
  }
  
  static final class a<V>
    implements h<V>
  {
    private final g<V> cqt;
    
    a(g<V> paramg)
    {
      this.cqt = paramg;
    }
    
    public final boolean f(int paramInt, V paramV)
    {
      if (this.cqt.hB(paramInt) >= 0)
      {
        Object localObject = this.cqt.get(paramInt);
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
    
    public final boolean f(int paramInt, V paramV)
    {
      this.h += (g.this.cqs.hA(paramInt) ^ a.ax(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.c.a.c.g
 * JD-Core Version:    0.7.0.1
 */