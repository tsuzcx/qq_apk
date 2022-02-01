package com.h.a.c;

public final class g<V>
  extends b
  implements f
{
  public transient V[] ecg;
  private transient int[] ecm;
  protected final f ecn = this;
  
  private boolean a(h<V> paramh)
  {
    int[] arrayOfInt = this.ecm;
    Object[] arrayOfObject = this.ecg;
    int j;
    for (int i = arrayOfInt.length;; i = j)
    {
      j = i - 1;
      if (i > 0)
      {
        if ((j(arrayOfObject, j)) && (!paramh.A(arrayOfInt[j], unwrapNull(arrayOfObject[j])))) {
          return false;
        }
      }
      else {
        return true;
      }
    }
  }
  
  public static boolean j(Object[] paramArrayOfObject, int paramInt)
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
  
  private int ma(int paramInt)
  {
    Object[] arrayOfObject = this.ecg;
    int[] arrayOfInt = this.ecm;
    int n = arrayOfInt.length;
    int j = this.ecn.lY(paramInt) & 0x7FFFFFFF;
    int i = j % n;
    if (l(arrayOfObject, i)) {}
    int k;
    do
    {
      return i;
      if ((j(arrayOfObject, i)) && (arrayOfInt[i] == paramInt)) {
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
          if (arrayOfInt[i] != paramInt) {}
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
      if (j(arrayOfObject, j)) {
        return -j - 1;
      }
      i = j;
    } while (k == -1);
    return k;
  }
  
  public static <V> V unwrapNull(V paramV)
  {
    V ? = paramV;
    if (paramV == n.ecA) {
      ? = null;
    }
    return ?;
  }
  
  protected final int UG()
  {
    return this.ecg.length;
  }
  
  public final int[] alr()
  {
    int[] arrayOfInt1 = new int[size()];
    int[] arrayOfInt2 = this.ecm;
    Object[] arrayOfObject = this.ecg;
    int i = arrayOfInt2.length;
    int j = 0;
    for (;;)
    {
      int k = i - 1;
      if (i > 0)
      {
        if (j(arrayOfObject, k))
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
  
  protected final void bj(int paramInt)
  {
    this.ecg[paramInt] = n.ecz;
    super.bj(paramInt);
  }
  
  public final void clear()
  {
    super.clear();
    int[] arrayOfInt = this.ecm;
    Object[] arrayOfObject = this.ecg;
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
    paramInt = lZ(paramInt);
    if (paramInt < 0) {
      return null;
    }
    return unwrapNull(this.ecg[paramInt]);
  }
  
  public final int hashCode()
  {
    b localb = new b();
    a(localb);
    return localb.h;
  }
  
  protected final int lU(int paramInt)
  {
    paramInt = super.lU(paramInt);
    this.ecg = ((Object[])new Object[paramInt]);
    this.ecm = new int[paramInt];
    return paramInt;
  }
  
  protected final void lV(int paramInt)
  {
    int i = this.ecm.length;
    int[] arrayOfInt = this.ecm;
    Object[] arrayOfObject = this.ecg;
    this.ecm = new int[paramInt];
    this.ecg = ((Object[])new Object[paramInt]);
    paramInt = i;
    for (;;)
    {
      i = paramInt - 1;
      if (paramInt > 0)
      {
        if (j(arrayOfObject, i))
        {
          paramInt = arrayOfInt[i];
          int j = ma(paramInt);
          this.ecm[j] = paramInt;
          this.ecg[j] = arrayOfObject[i];
          paramInt = i;
        }
      }
      else {
        return;
      }
      paramInt = i;
    }
  }
  
  public final int lY(int paramInt)
  {
    return paramInt;
  }
  
  protected final int lZ(int paramInt)
  {
    int[] arrayOfInt = this.ecm;
    Object[] arrayOfObject = this.ecg;
    int k = arrayOfInt.length;
    int m = 0x7FFFFFFF & this.ecn.lY(paramInt);
    int i = m % k;
    int j = i;
    if (!l(arrayOfObject, i)) {
      if (!k(arrayOfObject, i))
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
            if (l(arrayOfObject, i)) {
              break;
            }
            j = i;
          } while (k(arrayOfObject, i));
          j = i;
        } while (arrayOfInt[i] != paramInt);
        j = i;
      }
    }
    paramInt = j;
    if (l(arrayOfObject, j)) {
      paramInt = -1;
    }
    return paramInt;
  }
  
  public final V z(int paramInt, V paramV)
  {
    Object localObject = null;
    int j = ma(paramInt);
    int i = 1;
    if (j < 0)
    {
      j = -j - 1;
      localObject = unwrapNull(this.ecg[j]);
      i = 0;
    }
    for (boolean bool = false;; bool = l(this.ecg, j))
    {
      this.ecm[j] = paramInt;
      this.ecg[j] = paramV;
      if (i != 0) {
        cD(bool);
      }
      return localObject;
    }
  }
  
  static final class a<V>
    implements h<V>
  {
    private final g<V> eco;
    
    a(g<V> paramg)
    {
      this.eco = paramg;
    }
    
    public final boolean A(int paramInt, V paramV)
    {
      if (this.eco.lZ(paramInt) >= 0)
      {
        Object localObject = this.eco.get(paramInt);
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
    
    public final boolean A(int paramInt, V paramV)
    {
      this.h += (g.this.ecn.lY(paramInt) ^ com.h.a.a.a.b.bO(paramV));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.h.a.c.g
 * JD-Core Version:    0.7.0.1
 */