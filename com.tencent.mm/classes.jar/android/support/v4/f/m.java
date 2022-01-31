package android.support.v4.f;

import java.util.ConcurrentModificationException;
import java.util.Map;

public class m<K, V>
{
  static Object[] Es;
  static int Et;
  static Object[] Eu;
  static int Ev;
  int[] DY;
  Object[] DZ;
  int mSize;
  
  public m()
  {
    this.DY = c.Eb;
    this.DZ = c.Ed;
    this.mSize = 0;
  }
  
  public m(int paramInt)
  {
    if (paramInt == 0)
    {
      this.DY = c.Eb;
      this.DZ = c.Ed;
    }
    for (;;)
    {
      this.mSize = 0;
      return;
      ar(paramInt);
    }
  }
  
  public m(m<K, V> paramm)
  {
    this();
    if (paramm != null) {
      a(paramm);
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (Ev < 10)
        {
          paramArrayOfObject[0] = Eu;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label117;
          Eu = paramArrayOfObject;
          Ev += 1;
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
        if (Et < 10)
        {
          paramArrayOfObject[0] = Es;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label134;
          Es = paramArrayOfObject;
          Et += 1;
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
  
  private void ar(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (Eu != null)
        {
          Object[] arrayOfObject1 = Eu;
          this.DZ = arrayOfObject1;
          Eu = (Object[])arrayOfObject1[0];
          this.DY = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          Ev -= 1;
          return;
        }
        this.DY = new int[paramInt];
        this.DZ = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (Es != null)
          {
            Object[] arrayOfObject2 = Es;
            this.DZ = arrayOfObject2;
            Es = (Object[])arrayOfObject2[0];
            this.DY = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            Et -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = c.a(paramArrayOfInt, paramInt1, paramInt2);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      throw new ConcurrentModificationException();
    }
  }
  
  private int da()
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
        j = b(this.DY, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.DZ[(j << 1)] == null);
    int k = j + 1;
    while ((k < m) && (this.DY[k] == 0))
    {
      if (this.DZ[(k << 1)] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.DY[j] != 0)) {
        break label121;
      }
      i = j;
      if (this.DZ[(j << 1)] == null) {
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
        j = b(this.DY, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.DZ[(j << 1)]));
    int k = j + 1;
    while ((k < m) && (this.DY[k] == paramInt))
    {
      if (paramObject.equals(this.DZ[(k << 1)])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.DY[j] != paramInt)) {
        break label156;
      }
      i = j;
      if (paramObject.equals(this.DZ[(j << 1)])) {
        break;
      }
      j -= 1;
    }
    label156:
    return k ^ 0xFFFFFFFF;
  }
  
  public final void a(m<? extends K, ? extends V> paramm)
  {
    int i = 0;
    int j = paramm.mSize;
    ensureCapacity(this.mSize + j);
    if (this.mSize == 0) {
      if (j > 0)
      {
        System.arraycopy(paramm.DY, 0, this.DY, 0, j);
        System.arraycopy(paramm.DZ, 0, this.DZ, 0, j << 1);
        this.mSize = j;
      }
    }
    for (;;)
    {
      return;
      while (i < j)
      {
        put(paramm.keyAt(i), paramm.valueAt(i));
        i += 1;
      }
    }
  }
  
  public void clear()
  {
    if (this.mSize > 0)
    {
      int[] arrayOfInt = this.DY;
      Object[] arrayOfObject = this.DZ;
      int i = this.mSize;
      this.DY = c.Eb;
      this.DZ = c.Ed;
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
    if (this.DY.length < paramInt)
    {
      int[] arrayOfInt = this.DY;
      Object[] arrayOfObject = this.DZ;
      ar(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.DY, 0, i);
        System.arraycopy(arrayOfObject, 0, this.DZ, 0, i << 1);
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
      if ((paramObject instanceof m))
      {
        paramObject = (m)paramObject;
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
      return this.DZ[((i << 1) + 1)];
    }
    return null;
  }
  
  public int hashCode()
  {
    int[] arrayOfInt = this.DY;
    Object[] arrayOfObject = this.DZ;
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
      return da();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  final int indexOfValue(Object paramObject)
  {
    int i = 1;
    int j = 1;
    int k = this.mSize * 2;
    Object[] arrayOfObject = this.DZ;
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
    return this.DZ[(paramInt << 1)];
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    int m = this.mSize;
    int i;
    int j;
    if (paramK == null)
    {
      i = da();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.DZ[i];
      this.DZ[i] = paramV;
      return paramK;
      j = paramK.hashCode();
      i = indexOf(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    if (m >= this.DY.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      int[] arrayOfInt;
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.DY;
        arrayOfObject = this.DZ;
        ar(i);
        if (m == this.mSize) {
          break;
        }
        throw new ConcurrentModificationException();
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.DY.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.DY, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.DZ, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      System.arraycopy(this.DY, n, this.DY, n + 1, m - n);
      System.arraycopy(this.DZ, n << 1, this.DZ, n + 1 << 1, this.mSize - n << 1);
    }
    if ((m != this.mSize) || (n >= this.DY.length)) {
      throw new ConcurrentModificationException();
    }
    this.DY[n] = j;
    this.DZ[(n << 1)] = paramK;
    this.DZ[((n << 1) + 1)] = paramV;
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
  
  public final V removeAt(int paramInt)
  {
    int j = 8;
    Object localObject = this.DZ[((paramInt << 1) + 1)];
    int k = this.mSize;
    if (k <= 1)
    {
      a(this.DY, this.DZ, k);
      this.DY = c.Eb;
      this.DZ = c.Ed;
      paramInt = 0;
    }
    while (k != this.mSize)
    {
      throw new ConcurrentModificationException();
      int i = k - 1;
      if ((this.DY.length > 8) && (this.mSize < this.DY.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.DY;
        Object[] arrayOfObject = this.DZ;
        ar(j);
        if (k != this.mSize) {
          throw new ConcurrentModificationException();
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.DY, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.DZ, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.DY, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.DZ, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.DY, paramInt + 1, this.DY, paramInt, i - paramInt);
          System.arraycopy(this.DZ, paramInt + 1 << 1, this.DZ, paramInt << 1, i - paramInt << 1);
        }
        this.DZ[(i << 1)] = null;
        this.DZ[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.mSize = paramInt;
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
    return this.DZ[((paramInt << 1) + 1)];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.f.m
 * JD-Core Version:    0.7.0.1
 */