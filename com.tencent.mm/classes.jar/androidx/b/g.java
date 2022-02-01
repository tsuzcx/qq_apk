package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V>
{
  static Object[] zT;
  static int zU;
  static Object[] zV;
  static int zW;
  int mSize;
  int[] zC;
  Object[] zD;
  
  public g()
  {
    this.zC = c.zF;
    this.zD = c.zH;
    this.mSize = 0;
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(210365);
    if (paramInt == 0)
    {
      this.zC = c.zF;
      this.zD = c.zH;
    }
    for (;;)
    {
      this.mSize = 0;
      AppMethodBeat.o(210365);
      return;
      aH(paramInt);
    }
  }
  
  public g(g<K, V> paramg)
  {
    this();
    AppMethodBeat.i(210367);
    if (paramg != null)
    {
      int j = paramg.mSize;
      ensureCapacity(this.mSize + j);
      if (this.mSize == 0)
      {
        if (j > 0)
        {
          System.arraycopy(paramg.zC, 0, this.zC, 0, j);
          System.arraycopy(paramg.zD, 0, this.zD, 0, j << 1);
          this.mSize = j;
          AppMethodBeat.o(210367);
        }
      }
      else {
        while (i < j)
        {
          put(paramg.aO(i), paramg.aM(i));
          i += 1;
        }
      }
    }
    AppMethodBeat.o(210367);
  }
  
  private int a(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(210359);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(210359);
      return -1;
    }
    int k = b(this.zC, j, paramInt);
    if (k < 0)
    {
      AppMethodBeat.o(210359);
      return k;
    }
    if (paramObject.equals(this.zD[(k << 1)]))
    {
      AppMethodBeat.o(210359);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.zC[i] == paramInt))
    {
      if (paramObject.equals(this.zD[(i << 1)]))
      {
        AppMethodBeat.o(210359);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.zC[j] == paramInt))
    {
      if (paramObject.equals(this.zD[(j << 1)]))
      {
        AppMethodBeat.o(210359);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(210359);
    return i ^ 0xFFFFFFFF;
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {}
    for (;;)
    {
      try
      {
        if (zW < 10)
        {
          paramArrayOfObject[0] = zV;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break;
          zV = paramArrayOfObject;
          zW += 1;
        }
        return;
      }
      finally {}
      if (paramArrayOfInt.length != 4) {
        break;
      }
    }
    for (;;)
    {
      try
      {
        if (zU < 10)
        {
          paramArrayOfObject[0] = zT;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label133;
          zT = paramArrayOfObject;
          zU += 1;
        }
        return;
      }
      finally {}
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label133:
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
        if (zV != null)
        {
          Object[] arrayOfObject1 = zV;
          this.zD = arrayOfObject1;
          zV = (Object[])arrayOfObject1[0];
          this.zC = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          zW -= 1;
          return;
        }
        this.zC = new int[paramInt];
        this.zD = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (zT != null)
          {
            Object[] arrayOfObject2 = zT;
            this.zD = arrayOfObject2;
            zT = (Object[])arrayOfObject2[0];
            this.zC = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            zU -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(210357);
    try
    {
      paramInt1 = c.a(paramArrayOfInt, paramInt1, paramInt2);
      AppMethodBeat.o(210357);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      paramArrayOfInt = new ConcurrentModificationException();
      AppMethodBeat.o(210357);
      throw paramArrayOfInt;
    }
  }
  
  private int fb()
  {
    AppMethodBeat.i(210360);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(210360);
      return -1;
    }
    int k = b(this.zC, j, 0);
    if (k < 0)
    {
      AppMethodBeat.o(210360);
      return k;
    }
    if (this.zD[(k << 1)] == null)
    {
      AppMethodBeat.o(210360);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.zC[i] == 0))
    {
      if (this.zD[(i << 1)] == null)
      {
        AppMethodBeat.o(210360);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.zC[j] == 0))
    {
      if (this.zD[(j << 1)] == null)
      {
        AppMethodBeat.o(210360);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(210360);
    return i ^ 0xFFFFFFFF;
  }
  
  public final V aM(int paramInt)
  {
    return this.zD[((paramInt << 1) + 1)];
  }
  
  public final K aO(int paramInt)
  {
    return this.zD[(paramInt << 1)];
  }
  
  public void clear()
  {
    AppMethodBeat.i(210368);
    Object localObject;
    if (this.mSize > 0)
    {
      localObject = this.zC;
      Object[] arrayOfObject = this.zD;
      int i = this.mSize;
      this.zC = c.zF;
      this.zD = c.zH;
      this.mSize = 0;
      a((int[])localObject, arrayOfObject, i);
    }
    if (this.mSize > 0)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(210368);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(210368);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(210370);
    if (q(paramObject) >= 0)
    {
      AppMethodBeat.o(210370);
      return true;
    }
    AppMethodBeat.o(210370);
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(210374);
    if (r(paramObject) >= 0)
    {
      AppMethodBeat.o(210374);
      return true;
    }
    AppMethodBeat.o(210374);
    return false;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(210369);
    int i = this.mSize;
    Object localObject;
    if (this.zC.length < paramInt)
    {
      localObject = this.zC;
      Object[] arrayOfObject = this.zD;
      aH(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(localObject, 0, this.zC, 0, i);
        System.arraycopy(arrayOfObject, 0, this.zD, 0, i << 1);
      }
      a((int[])localObject, arrayOfObject, i);
    }
    if (this.mSize != i)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(210369);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(210369);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210385);
    if (this == paramObject)
    {
      AppMethodBeat.o(210385);
      return true;
    }
    int i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    boolean bool;
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if (size() != paramObject.size())
      {
        AppMethodBeat.o(210385);
        return false;
      }
      i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject1 = aO(i);
          localObject2 = aM(i);
          localObject3 = paramObject.get(localObject1);
          if (localObject2 == null)
          {
            if (localObject3 == null)
            {
              bool = paramObject.containsKey(localObject1);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(210385);
              return false;
            }
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool)
            {
              AppMethodBeat.o(210385);
              return false;
            }
          }
          i += 1;
        }
        AppMethodBeat.o(210385);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(210385);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(210385);
        return false;
      }
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size())
      {
        AppMethodBeat.o(210385);
        return false;
      }
      i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject1 = aO(i);
          localObject2 = aM(i);
          localObject3 = paramObject.get(localObject1);
          if (localObject2 == null)
          {
            if (localObject3 == null)
            {
              bool = paramObject.containsKey(localObject1);
              if (bool) {}
            }
            else
            {
              AppMethodBeat.o(210385);
              return false;
            }
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool)
            {
              AppMethodBeat.o(210385);
              return false;
            }
          }
          i += 1;
        }
        AppMethodBeat.o(210385);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(210385);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(210385);
        return false;
      }
      return true;
    }
    AppMethodBeat.o(210385);
    return false;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(210375);
    int i = q(paramObject);
    if (i >= 0)
    {
      paramObject = this.zD[((i << 1) + 1)];
      AppMethodBeat.o(210375);
      return paramObject;
    }
    AppMethodBeat.o(210375);
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(210387);
    int[] arrayOfInt = this.zC;
    Object[] arrayOfObject = this.zD;
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
    AppMethodBeat.o(210387);
    return k;
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    AppMethodBeat.i(210378);
    int m = this.mSize;
    int i;
    int j;
    if (paramK == null)
    {
      i = fb();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.zD[i];
      this.zD[i] = paramV;
      AppMethodBeat.o(210378);
      return paramK;
      j = paramK.hashCode();
      i = a(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    int[] arrayOfInt;
    if (m >= this.zC.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.zC;
        arrayOfObject = this.zD;
        aH(i);
        if (m == this.mSize) {
          break;
        }
        paramK = new ConcurrentModificationException();
        AppMethodBeat.o(210378);
        throw paramK;
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.zC.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.zC, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.zD, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      arrayOfInt = this.zC;
      System.arraycopy(arrayOfInt, n, arrayOfInt, n + 1, m - n);
      System.arraycopy(this.zD, n << 1, this.zD, n + 1 << 1, this.mSize - n << 1);
    }
    if ((m != this.mSize) || (n >= this.zC.length))
    {
      paramK = new ConcurrentModificationException();
      AppMethodBeat.o(210378);
      throw paramK;
    }
    this.zC[n] = j;
    this.zD[(n << 1)] = paramK;
    this.zD[((n << 1) + 1)] = paramV;
    this.mSize += 1;
    AppMethodBeat.o(210378);
    return null;
  }
  
  public final int q(Object paramObject)
  {
    AppMethodBeat.i(210371);
    if (paramObject == null)
    {
      i = fb();
      AppMethodBeat.o(210371);
      return i;
    }
    int i = a(paramObject, paramObject.hashCode());
    AppMethodBeat.o(210371);
    return i;
  }
  
  final int r(Object paramObject)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(210373);
    int k = this.mSize * 2;
    Object[] arrayOfObject = this.zD;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null)
        {
          AppMethodBeat.o(210373);
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
    AppMethodBeat.o(210373);
    return i >> 1;
    AppMethodBeat.o(210373);
    return -1;
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(210380);
    int i = q(paramObject);
    if (i >= 0)
    {
      paramObject = removeAt(i);
      AppMethodBeat.o(210380);
      return paramObject;
    }
    AppMethodBeat.o(210380);
    return null;
  }
  
  public final V removeAt(int paramInt)
  {
    int j = 8;
    AppMethodBeat.i(210383);
    Object localObject = this.zD[((paramInt << 1) + 1)];
    int k = this.mSize;
    if (k <= 1)
    {
      a(this.zC, this.zD, k);
      this.zC = c.zF;
      this.zD = c.zH;
      paramInt = 0;
    }
    while (k != this.mSize)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(210383);
      throw ((Throwable)localObject);
      int i = k - 1;
      if ((this.zC.length > 8) && (this.mSize < this.zC.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.zC;
        Object[] arrayOfObject = this.zD;
        aH(j);
        if (k != this.mSize)
        {
          localObject = new ConcurrentModificationException();
          AppMethodBeat.o(210383);
          throw ((Throwable)localObject);
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.zC, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.zD, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.zC, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.zD, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.zC, paramInt + 1, this.zC, paramInt, i - paramInt);
          System.arraycopy(this.zD, paramInt + 1 << 1, this.zD, paramInt << 1, i - paramInt << 1);
        }
        this.zD[(i << 1)] = null;
        this.zD[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.mSize = paramInt;
    AppMethodBeat.o(210383);
    return localObject;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    AppMethodBeat.i(210388);
    if (isEmpty())
    {
      AppMethodBeat.o(210388);
      return "{}";
    }
    Object localObject1 = new StringBuilder(this.mSize * 28);
    ((StringBuilder)localObject1).append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        ((StringBuilder)localObject1).append(", ");
      }
      Object localObject2 = aO(i);
      if (localObject2 != this)
      {
        ((StringBuilder)localObject1).append(localObject2);
        label80:
        ((StringBuilder)localObject1).append('=');
        localObject2 = aM(i);
        if (localObject2 == this) {
          break label121;
        }
        ((StringBuilder)localObject1).append(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject1).append("(this Map)");
        break label80;
        label121:
        ((StringBuilder)localObject1).append("(this Map)");
      }
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(210388);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.g
 * JD-Core Version:    0.7.0.1
 */