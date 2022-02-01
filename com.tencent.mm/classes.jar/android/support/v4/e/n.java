package android.support.v4.e;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class n<K, V>
{
  static Object[] Pe;
  static int Pf;
  static Object[] Pg;
  static int Ph;
  int[] OM;
  Object[] OO;
  int mSize;
  
  public n()
  {
    this.OM = d.OQ;
    this.OO = d.OS;
    this.mSize = 0;
  }
  
  public n(int paramInt)
  {
    if (paramInt == 0)
    {
      this.OM = d.OQ;
      this.OO = d.OS;
    }
    for (;;)
    {
      this.mSize = 0;
      return;
      aH(paramInt);
    }
  }
  
  public n(n<K, V> paramn)
  {
    this();
    if (paramn != null) {
      a(paramn);
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (Ph < 10)
        {
          paramArrayOfObject[0] = Pg;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          Pg = paramArrayOfObject;
          Ph += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label133;
      }
    }
    for (;;)
    {
      try
      {
        if (Pf < 10)
        {
          paramArrayOfObject[0] = Pe;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          Pe = paramArrayOfObject;
          Pf += 1;
        }
        return;
      }
      finally {}
      label117:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label133:
      return;
      label134:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
    }
  }
  
  private void aH(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (Pg != null)
        {
          Object[] arrayOfObject1 = Pg;
          this.OO = arrayOfObject1;
          Pg = (Object[])arrayOfObject1[0];
          this.OM = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          Ph -= 1;
          return;
        }
        this.OM = new int[paramInt];
        this.OO = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (Pe != null)
          {
            Object[] arrayOfObject2 = Pe;
            this.OO = arrayOfObject2;
            Pe = (Object[])arrayOfObject2[0];
            this.OM = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            Pf -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static int c(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = d.b(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  private int fv()
  {
    int m = this.mSize;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c(this.OM, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.OO[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.OM[k] == 0))
    {
      if (this.OO[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.OM[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.OO[(j << 1)] == null) {
        break;
      }
      j -= 1;
    }
    label121:
    return k ^ 0xFFFFFFFF;
  }
  
  private int indexOf(Object paramObject, int paramInt)
  {
    int m = this.mSize;
    int i;
    if (m == 0) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        j = c(this.OM, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.OO[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.OM[k] == paramInt))
    {
      if (paramObject.equals(this.OO[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.OM[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.OO[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  public void a(n<? extends K, ? extends V> paramn)
  {
    int i = 0;
    int j = paramn.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0) {
      if (j > 0)
      {
        System.arraycopy(paramn.OM, 0, this.OM, 0, j);
        System.arraycopy(paramn.OO, 0, this.OO, 0, j << 1);
        this.mSize = j;
      }
    }
    for (;;)
    {
      return;
      while (i < j)
      {
        put(paramn.keyAt(i), paramn.valueAt(i));
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    if (this.mSize > 0)
    {
      int[] arrayOfInt = this.OM;
      Object[] arrayOfObject = this.OO;
      int i = this.mSize;
      this.OM = d.OQ;
      this.OO = d.OS;
      this.mSize = 0;
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize > 0) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean containsKey(Object paramObject)
  {
    return indexOfKey(paramObject) >= 0;
  }
  
  public boolean containsValue(Object paramObject)
  {
    return indexOfValue(paramObject) >= 0;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    int i = this.mSize;
    if (this.OM.length < paramInt)
    {
      int[] arrayOfInt = this.OM;
      Object[] arrayOfObject = this.OO;
      aH(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.OM, 0, i);
        System.arraycopy(arrayOfObject, 0, this.OO, 0, i << 1);
      }
      a(arrayOfInt, arrayOfObject, i);
    }
    if (this.mSize != i) {
      throw new ConcurrentModificationException();
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      int i;
      Object localObject1;
      Object localObject2;
      Object localObject3;
      boolean bool;
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.mSize)
          {
            localObject1 = keyAt(i);
            localObject2 = valueAt(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label227;
              }
              if (!paramObject.containsKey(localObject1)) {
                break label227;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          if (!(paramObject instanceof Map)) {
            break;
          }
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
      else
      {
        paramObject = (Map)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        i = 0;
        try
        {
          while (i < this.mSize)
          {
            localObject1 = keyAt(i);
            localObject2 = valueAt(i);
            localObject3 = paramObject.get(localObject1);
            if (localObject2 == null)
            {
              if (localObject3 != null) {
                break label229;
              }
              if (!paramObject.containsKey(localObject1)) {
                break label229;
              }
            }
            else
            {
              bool = localObject2.equals(localObject3);
              if (!bool) {
                return false;
              }
            }
            i += 1;
          }
          return false;
        }
        catch (NullPointerException paramObject)
        {
          return false;
        }
        catch (ClassCastException paramObject)
        {
          return false;
        }
      }
    }
    label227:
    return false;
    label229:
    return false;
  }
  
  public V get(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return this.OO[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.OM;
    Object[] arrayOfObject = this.OO;
    int n = this.mSize;
    int i = 1;
    int j = 0;
    int k = 0;
    if (j < n)
    {
      Object localObject = arrayOfObject[i];
      int i1 = arrayOfInt[j];
      if (localObject == null) {}
      for (int m = 0;; m = localObject.hashCode())
      {
        k += (m ^ i1);
        j += 1;
        i += 2;
        break;
      }
    }
    return k;
  }
  
  public final int indexOfKey(Object paramObject)
  {
    if (paramObject == null) {
      return fv();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  final int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.mSize * 2;
    Object[] arrayOfObject = this.OO;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null) {
          return i >> 1;
        }
        i += 2;
      }
    }
    do
    {
      i += 2;
      if (i >= k) {
        break;
      }
    } while (!paramObject.equals(arrayOfObject[i]));
    return i >> 1;
    return -1;
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final K keyAt(int paramInt)
  {
    return this.OO[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int m = this.mSize;
    int i;
    int j;
    if (paramK == null)
    {
      i = fv();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.OO[i];
      this.OO[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    int[] arrayOfInt;
    if (m >= this.OM.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.OM;
        arrayOfObject = this.OO;
        aH(i);
        if (m == this.mSize) {
          break;
        }
        throw new ConcurrentModificationException();
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.OM.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.OM, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.OO, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      arrayOfInt = this.OM;
      System.arraycopy(arrayOfInt, n, arrayOfInt, n + 1, m - n);
      System.arraycopy(this.OO, n << 1, this.OO, n + 1 << 1, this.mSize - n << 1);
    }
    if ((m != this.mSize) || (n >= this.OM.length)) {
      throw new ConcurrentModificationException();
    }
    this.OM[n] = j;
    this.OO[(n << 1)] = paramK;
    this.OO[((n << 1) + 1)] = paramV;
    this.mSize += 1;
    return null;
  }
  
  public V remove(Object paramObject)
  {
    int i = indexOfKey(paramObject);
    if (i >= 0) {
      return removeAt(i);
    }
    return null;
  }
  
  public V removeAt(int paramInt)
  {
    int j = 8;
    Object localObject = this.OO[((paramInt << 1) + 1)];
    int k = this.mSize;
    if (k <= 1)
    {
      a(this.OM, this.OO, k);
      this.OM = d.OQ;
      this.OO = d.OS;
      paramInt = 0;
    }
    while (k != this.mSize)
    {
      throw new ConcurrentModificationException();
      int i = k - 1;
      if ((this.OM.length > 8) && (this.mSize < this.OM.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.OM;
        Object[] arrayOfObject = this.OO;
        aH(j);
        if (k != this.mSize) {
          throw new ConcurrentModificationException();
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.OM, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.OO, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.OM, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.OO, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.OM, paramInt + 1, this.OM, paramInt, i - paramInt);
          System.arraycopy(this.OO, paramInt + 1 << 1, this.OO, paramInt << 1, i - paramInt << 1);
        }
        this.OO[(i << 1)] = null;
        this.OO[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.mSize = paramInt;
    return localObject;
  }
  
  public V setValueAt(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object localObject = this.OO[paramInt];
    this.OO[paramInt] = paramV;
    return localObject;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 28);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = keyAt(i);
      if (localObject != this)
      {
        localStringBuilder.append(localObject);
        label70:
        localStringBuilder.append('=');
        localObject = valueAt(i);
        if (localObject == this) {
          break label111;
        }
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Map)");
        break label70;
        label111:
        localStringBuilder.append("(this Map)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final V valueAt(int paramInt)
  {
    return this.OO[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.n
 * JD-Core Version:    0.7.0.1
 */