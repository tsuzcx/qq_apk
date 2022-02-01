package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class g<K, V>
{
  static Object[] Sg;
  static int Sh;
  static Object[] Si;
  static int Sj;
  int[] RP;
  Object[] RQ;
  int mSize;
  
  public g()
  {
    this.RP = c.RS;
    this.RQ = c.RU;
    this.mSize = 0;
  }
  
  public g(int paramInt)
  {
    AppMethodBeat.i(194563);
    if (paramInt == 0)
    {
      this.RP = c.RS;
      this.RQ = c.RU;
    }
    for (;;)
    {
      this.mSize = 0;
      AppMethodBeat.o(194563);
      return;
      bg(paramInt);
    }
  }
  
  public g(g<K, V> paramg)
  {
    this();
    AppMethodBeat.i(194573);
    if (paramg != null)
    {
      int j = paramg.mSize;
      ensureCapacity(this.mSize + j);
      if (this.mSize == 0)
      {
        if (j > 0)
        {
          System.arraycopy(paramg.RP, 0, this.RP, 0, j);
          System.arraycopy(paramg.RQ, 0, this.RQ, 0, j << 1);
          this.mSize = j;
          AppMethodBeat.o(194573);
        }
      }
      else {
        while (i < j)
        {
          put(paramg.bn(i), paramg.bl(i));
          i += 1;
        }
      }
    }
    AppMethodBeat.o(194573);
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {}
    for (;;)
    {
      try
      {
        if (Sj < 10)
        {
          paramArrayOfObject[0] = Si;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break;
          Si = paramArrayOfObject;
          Sj += 1;
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
        if (Sh < 10)
        {
          paramArrayOfObject[0] = Sg;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt = (paramInt << 1) - 1;
          break label133;
          Sg = paramArrayOfObject;
          Sh += 1;
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
  
  private int b(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(194518);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(194518);
      return -1;
    }
    int k = b(this.RP, j, paramInt);
    if (k < 0)
    {
      AppMethodBeat.o(194518);
      return k;
    }
    if (paramObject.equals(this.RQ[(k << 1)]))
    {
      AppMethodBeat.o(194518);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.RP[i] == paramInt))
    {
      if (paramObject.equals(this.RQ[(i << 1)]))
      {
        AppMethodBeat.o(194518);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.RP[j] == paramInt))
    {
      if (paramObject.equals(this.RQ[(j << 1)]))
      {
        AppMethodBeat.o(194518);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(194518);
    return i ^ 0xFFFFFFFF;
  }
  
  private static int b(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194512);
    try
    {
      paramInt1 = c.a(paramArrayOfInt, paramInt1, paramInt2);
      AppMethodBeat.o(194512);
      return paramInt1;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfInt)
    {
      paramArrayOfInt = new ConcurrentModificationException();
      AppMethodBeat.o(194512);
      throw paramArrayOfInt;
    }
  }
  
  private void bg(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (Si != null)
        {
          Object[] arrayOfObject1 = Si;
          this.RQ = arrayOfObject1;
          Si = (Object[])arrayOfObject1[0];
          this.RP = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          Sj -= 1;
          return;
        }
        this.RP = new int[paramInt];
        this.RQ = new Object[paramInt << 1];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (Sg != null)
          {
            Object[] arrayOfObject2 = Sg;
            this.RQ = arrayOfObject2;
            Sg = (Object[])arrayOfObject2[0];
            this.RP = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            Sh -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int lk()
  {
    AppMethodBeat.i(194525);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(194525);
      return -1;
    }
    int k = b(this.RP, j, 0);
    if (k < 0)
    {
      AppMethodBeat.o(194525);
      return k;
    }
    if (this.RQ[(k << 1)] == null)
    {
      AppMethodBeat.o(194525);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.RP[i] == 0))
    {
      if (this.RQ[(i << 1)] == null)
      {
        AppMethodBeat.o(194525);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.RP[j] == 0))
    {
      if (this.RQ[(j << 1)] == null)
      {
        AppMethodBeat.o(194525);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(194525);
    return i ^ 0xFFFFFFFF;
  }
  
  public final V bl(int paramInt)
  {
    return this.RQ[((paramInt << 1) + 1)];
  }
  
  public final K bn(int paramInt)
  {
    return this.RQ[(paramInt << 1)];
  }
  
  public final V c(int paramInt, V paramV)
  {
    paramInt = (paramInt << 1) + 1;
    Object localObject = this.RQ[paramInt];
    this.RQ[paramInt] = paramV;
    return localObject;
  }
  
  public void clear()
  {
    AppMethodBeat.i(194584);
    Object localObject;
    if (this.mSize > 0)
    {
      localObject = this.RP;
      Object[] arrayOfObject = this.RQ;
      int i = this.mSize;
      this.RP = c.RS;
      this.RQ = c.RU;
      this.mSize = 0;
      a((int[])localObject, arrayOfObject, i);
    }
    if (this.mSize > 0)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(194584);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(194584);
  }
  
  public boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(194601);
    if (y(paramObject) >= 0)
    {
      AppMethodBeat.o(194601);
      return true;
    }
    AppMethodBeat.o(194601);
    return false;
  }
  
  public boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(194627);
    if (z(paramObject) >= 0)
    {
      AppMethodBeat.o(194627);
      return true;
    }
    AppMethodBeat.o(194627);
    return false;
  }
  
  public final void ensureCapacity(int paramInt)
  {
    AppMethodBeat.i(194592);
    int i = this.mSize;
    Object localObject;
    if (this.RP.length < paramInt)
    {
      localObject = this.RP;
      Object[] arrayOfObject = this.RQ;
      bg(paramInt);
      if (this.mSize > 0)
      {
        System.arraycopy(localObject, 0, this.RP, 0, i);
        System.arraycopy(arrayOfObject, 0, this.RQ, 0, i << 1);
      }
      a((int[])localObject, arrayOfObject, i);
    }
    if (this.mSize != i)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(194592);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(194592);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194776);
    if (this == paramObject)
    {
      AppMethodBeat.o(194776);
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
        AppMethodBeat.o(194776);
        return false;
      }
      i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject1 = bn(i);
          localObject2 = bl(i);
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
              AppMethodBeat.o(194776);
              return false;
            }
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool)
            {
              AppMethodBeat.o(194776);
              return false;
            }
          }
          i += 1;
        }
        AppMethodBeat.o(194776);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(194776);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(194776);
        return false;
      }
      return true;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (size() != paramObject.size())
      {
        AppMethodBeat.o(194776);
        return false;
      }
      i = 0;
      try
      {
        while (i < this.mSize)
        {
          localObject1 = bn(i);
          localObject2 = bl(i);
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
              AppMethodBeat.o(194776);
              return false;
            }
          }
          else
          {
            bool = localObject2.equals(localObject3);
            if (!bool)
            {
              AppMethodBeat.o(194776);
              return false;
            }
          }
          i += 1;
        }
        AppMethodBeat.o(194776);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(194776);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(194776);
        return false;
      }
      return true;
    }
    AppMethodBeat.o(194776);
    return false;
  }
  
  public V get(Object paramObject)
  {
    AppMethodBeat.i(194641);
    paramObject = getOrDefault(paramObject, null);
    AppMethodBeat.o(194641);
    return paramObject;
  }
  
  public V getOrDefault(Object paramObject, V paramV)
  {
    AppMethodBeat.i(194654);
    int i = y(paramObject);
    if (i >= 0)
    {
      paramObject = this.RQ[((i << 1) + 1)];
      AppMethodBeat.o(194654);
      return paramObject;
    }
    AppMethodBeat.o(194654);
    return paramV;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(194784);
    int[] arrayOfInt = this.RP;
    Object[] arrayOfObject = this.RQ;
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
    AppMethodBeat.o(194784);
    return k;
  }
  
  public boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public V put(K paramK, V paramV)
  {
    int k = 8;
    AppMethodBeat.i(194700);
    int m = this.mSize;
    int i;
    int j;
    if (paramK == null)
    {
      i = lk();
      j = 0;
    }
    while (i >= 0)
    {
      i = (i << 1) + 1;
      paramK = this.RQ[i];
      this.RQ[i] = paramV;
      AppMethodBeat.o(194700);
      return paramK;
      j = paramK.hashCode();
      i = b(paramK, j);
    }
    int n = i ^ 0xFFFFFFFF;
    int[] arrayOfInt;
    if (m >= this.RP.length)
    {
      if (m >= 8) {
        i = (m >> 1) + m;
      }
      Object[] arrayOfObject;
      for (;;)
      {
        arrayOfInt = this.RP;
        arrayOfObject = this.RQ;
        bg(i);
        if (m == this.mSize) {
          break;
        }
        paramK = new ConcurrentModificationException();
        AppMethodBeat.o(194700);
        throw paramK;
        i = k;
        if (m < 4) {
          i = 4;
        }
      }
      if (this.RP.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.RP, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.RQ, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, m);
    }
    if (n < m)
    {
      arrayOfInt = this.RP;
      System.arraycopy(arrayOfInt, n, arrayOfInt, n + 1, m - n);
      System.arraycopy(this.RQ, n << 1, this.RQ, n + 1 << 1, this.mSize - n << 1);
    }
    if ((m != this.mSize) || (n >= this.RP.length))
    {
      paramK = new ConcurrentModificationException();
      AppMethodBeat.o(194700);
      throw paramK;
    }
    this.RP[n] = j;
    this.RQ[(n << 1)] = paramK;
    this.RQ[((n << 1) + 1)] = paramV;
    this.mSize += 1;
    AppMethodBeat.o(194700);
    return null;
  }
  
  public V putIfAbsent(K paramK, V paramV)
  {
    AppMethodBeat.i(194711);
    Object localObject2 = get(paramK);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = put(paramK, paramV);
    }
    AppMethodBeat.o(194711);
    return localObject1;
  }
  
  public V remove(Object paramObject)
  {
    AppMethodBeat.i(194720);
    int i = y(paramObject);
    if (i >= 0)
    {
      paramObject = removeAt(i);
      AppMethodBeat.o(194720);
      return paramObject;
    }
    AppMethodBeat.o(194720);
    return null;
  }
  
  public boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(194730);
    int i = y(paramObject1);
    if (i >= 0)
    {
      paramObject1 = bl(i);
      if ((paramObject2 == paramObject1) || ((paramObject2 != null) && (paramObject2.equals(paramObject1))))
      {
        removeAt(i);
        AppMethodBeat.o(194730);
        return true;
      }
    }
    AppMethodBeat.o(194730);
    return false;
  }
  
  public final V removeAt(int paramInt)
  {
    int j = 8;
    AppMethodBeat.i(194745);
    Object localObject = this.RQ[((paramInt << 1) + 1)];
    int k = this.mSize;
    if (k <= 1)
    {
      a(this.RP, this.RQ, k);
      this.RP = c.RS;
      this.RQ = c.RU;
      paramInt = 0;
    }
    while (k != this.mSize)
    {
      localObject = new ConcurrentModificationException();
      AppMethodBeat.o(194745);
      throw ((Throwable)localObject);
      int i = k - 1;
      if ((this.RP.length > 8) && (this.mSize < this.RP.length / 3))
      {
        if (k > 8) {
          j = (k >> 1) + k;
        }
        int[] arrayOfInt = this.RP;
        Object[] arrayOfObject = this.RQ;
        bg(j);
        if (k != this.mSize)
        {
          localObject = new ConcurrentModificationException();
          AppMethodBeat.o(194745);
          throw ((Throwable)localObject);
        }
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.RP, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.RQ, 0, paramInt << 1);
        }
        if (paramInt < i)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.RP, paramInt, i - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1 << 1, this.RQ, paramInt << 1, i - paramInt << 1);
        }
        paramInt = i;
      }
      else
      {
        if (paramInt < i)
        {
          System.arraycopy(this.RP, paramInt + 1, this.RP, paramInt, i - paramInt);
          System.arraycopy(this.RQ, paramInt + 1 << 1, this.RQ, paramInt << 1, i - paramInt << 1);
        }
        this.RQ[(i << 1)] = null;
        this.RQ[((i << 1) + 1)] = null;
        paramInt = i;
      }
    }
    this.mSize = paramInt;
    AppMethodBeat.o(194745);
    return localObject;
  }
  
  public V replace(K paramK, V paramV)
  {
    AppMethodBeat.i(194754);
    int i = y(paramK);
    if (i >= 0)
    {
      paramK = c(i, paramV);
      AppMethodBeat.o(194754);
      return paramK;
    }
    AppMethodBeat.o(194754);
    return null;
  }
  
  public boolean replace(K paramK, V paramV1, V paramV2)
  {
    AppMethodBeat.i(194763);
    int i = y(paramK);
    if (i >= 0)
    {
      paramK = bl(i);
      if ((paramK == paramV1) || ((paramV1 != null) && (paramV1.equals(paramK))))
      {
        c(i, paramV2);
        AppMethodBeat.o(194763);
        return true;
      }
    }
    AppMethodBeat.o(194763);
    return false;
  }
  
  public int size()
  {
    return this.mSize;
  }
  
  public String toString()
  {
    AppMethodBeat.i(194797);
    if (isEmpty())
    {
      AppMethodBeat.o(194797);
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
      Object localObject2 = bn(i);
      if (localObject2 != this)
      {
        ((StringBuilder)localObject1).append(localObject2);
        label80:
        ((StringBuilder)localObject1).append('=');
        localObject2 = bl(i);
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
    AppMethodBeat.o(194797);
    return localObject1;
  }
  
  public final int y(Object paramObject)
  {
    AppMethodBeat.i(194609);
    if (paramObject == null)
    {
      i = lk();
      AppMethodBeat.o(194609);
      return i;
    }
    int i = b(paramObject, paramObject.hashCode());
    AppMethodBeat.o(194609);
    return i;
  }
  
  final int z(Object paramObject)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(194620);
    int k = this.mSize * 2;
    Object[] arrayOfObject = this.RQ;
    if (paramObject == null)
    {
      i = j;
      while (i < k)
      {
        if (arrayOfObject[i] == null)
        {
          AppMethodBeat.o(194620);
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
    AppMethodBeat.o(194620);
    return i >> 1;
    AppMethodBeat.o(194620);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.g
 * JD-Core Version:    0.7.0.1
 */