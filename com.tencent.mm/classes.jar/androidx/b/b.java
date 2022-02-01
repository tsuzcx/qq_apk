package androidx.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static Object[] zA;
  private static int zB;
  private static final int[] zw = new int[0];
  private static final Object[] zx = new Object[0];
  private static Object[] zy;
  private static int zz;
  int mSize;
  private int[] zC;
  public Object[] zD;
  private f<E, E> zu;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(210179);
    if (paramInt == 0)
    {
      this.zC = zw;
      this.zD = zx;
    }
    for (;;)
    {
      this.mSize = 0;
      AppMethodBeat.o(210179);
      return;
      aH(paramInt);
    }
  }
  
  private int a(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(210175);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(210175);
      return -1;
    }
    int k = c.a(this.zC, j, paramInt);
    if (k < 0)
    {
      AppMethodBeat.o(210175);
      return k;
    }
    if (paramObject.equals(this.zD[k]))
    {
      AppMethodBeat.o(210175);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.zC[i] == paramInt))
    {
      if (paramObject.equals(this.zD[i]))
      {
        AppMethodBeat.o(210175);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.zC[j] == paramInt))
    {
      if (paramObject.equals(this.zD[j]))
      {
        AppMethodBeat.o(210175);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(210175);
    return i ^ 0xFFFFFFFF;
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {}
    for (;;)
    {
      try
      {
        if (zB < 10)
        {
          paramArrayOfObject[0] = zA;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break;
          zA = paramArrayOfObject;
          zB += 1;
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
        if (zz < 10)
        {
          paramArrayOfObject[0] = zy;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label129;
          zy = paramArrayOfObject;
          zz += 1;
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
      label129:
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
        if (zA != null)
        {
          Object[] arrayOfObject1 = zA;
          this.zD = arrayOfObject1;
          zA = (Object[])arrayOfObject1[0];
          this.zC = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          zB -= 1;
          return;
        }
        this.zC = new int[paramInt];
        this.zD = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (zy != null)
          {
            Object[] arrayOfObject2 = zy;
            this.zD = arrayOfObject2;
            zy = (Object[])arrayOfObject2[0];
            this.zC = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            zz -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int fb()
  {
    AppMethodBeat.i(210177);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(210177);
      return -1;
    }
    int k = c.a(this.zC, j, 0);
    if (k < 0)
    {
      AppMethodBeat.o(210177);
      return k;
    }
    if (this.zD[k] == null)
    {
      AppMethodBeat.o(210177);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.zC[i] == 0))
    {
      if (this.zD[i] == null)
      {
        AppMethodBeat.o(210177);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.zC[j] == 0))
    {
      if (this.zD[j] == null)
      {
        AppMethodBeat.o(210177);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(210177);
    return i ^ 0xFFFFFFFF;
  }
  
  public final boolean add(E paramE)
  {
    int k = 8;
    AppMethodBeat.i(210187);
    int i;
    int j;
    if (paramE == null)
    {
      i = fb();
      j = 0;
    }
    while (i >= 0)
    {
      AppMethodBeat.o(210187);
      return false;
      j = paramE.hashCode();
      i = a(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.zC.length)
    {
      if (this.mSize < 8) {
        break label242;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.zC;
      Object[] arrayOfObject = this.zD;
      aH(i);
      if (this.zC.length > 0)
      {
        System.arraycopy(localObject, 0, this.zC, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.zD, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.zC;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.zD;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.zC[m] = j;
      this.zD[m] = paramE;
      this.mSize += 1;
      AppMethodBeat.o(210187);
      return true;
      label242:
      i = k;
      if (this.mSize < 4) {
        i = 4;
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    AppMethodBeat.i(210205);
    int i = this.mSize + paramCollection.size();
    if (this.zC.length < i)
    {
      int[] arrayOfInt = this.zC;
      Object[] arrayOfObject = this.zD;
      aH(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.zC, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.zD, 0, this.mSize);
      }
      a(arrayOfInt, arrayOfObject, this.mSize);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    AppMethodBeat.o(210205);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(210180);
    if (this.mSize != 0)
    {
      a(this.zC, this.zD, this.mSize);
      this.zC = zw;
      this.zD = zx;
      this.mSize = 0;
    }
    AppMethodBeat.o(210180);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(210182);
    if (indexOf(paramObject) >= 0)
    {
      AppMethodBeat.o(210182);
      return true;
    }
    AppMethodBeat.o(210182);
    return false;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(210204);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next()))
      {
        AppMethodBeat.o(210204);
        return false;
      }
    }
    AppMethodBeat.o(210204);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(210196);
    if (this == paramObject)
    {
      AppMethodBeat.o(210196);
      return true;
    }
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != paramObject.size())
      {
        AppMethodBeat.o(210196);
        return false;
      }
      int i = 0;
      try
      {
        while (i < this.mSize)
        {
          boolean bool = paramObject.contains(this.zD[i]);
          if (!bool)
          {
            AppMethodBeat.o(210196);
            return false;
          }
          i += 1;
        }
        AppMethodBeat.o(210196);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(210196);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(210196);
        return false;
      }
      return true;
    }
    AppMethodBeat.o(210196);
    return false;
  }
  
  public final int hashCode()
  {
    int[] arrayOfInt = this.zC;
    int k = this.mSize;
    int j = 0;
    int m;
    for (int i = 0; j < k; i = m + i)
    {
      m = arrayOfInt[j];
      j += 1;
    }
    return i;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(210184);
    if (paramObject == null)
    {
      i = fb();
      AppMethodBeat.o(210184);
      return i;
    }
    int i = a(paramObject, paramObject.hashCode());
    AppMethodBeat.o(210184);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(210201);
    if (this.zu == null) {
      this.zu = new f()
      {
        protected final E a(int paramAnonymousInt, E paramAnonymousE)
        {
          AppMethodBeat.i(210166);
          paramAnonymousE = new UnsupportedOperationException("not a map");
          AppMethodBeat.o(210166);
          throw paramAnonymousE;
        }
        
        protected final void aG(int paramAnonymousInt)
        {
          AppMethodBeat.i(210168);
          b.this.removeAt(paramAnonymousInt);
          AppMethodBeat.o(210168);
        }
        
        protected final void b(E paramAnonymousE1, E paramAnonymousE2)
        {
          AppMethodBeat.i(210165);
          b.this.add(paramAnonymousE1);
          AppMethodBeat.o(210165);
        }
        
        protected final int eY()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> eZ()
        {
          AppMethodBeat.i(210163);
          UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("not a map");
          AppMethodBeat.o(210163);
          throw localUnsupportedOperationException;
        }
        
        protected final void fa()
        {
          AppMethodBeat.i(210169);
          b.this.clear();
          AppMethodBeat.o(210169);
        }
        
        protected final int o(Object paramAnonymousObject)
        {
          AppMethodBeat.i(210161);
          int i = b.this.indexOf(paramAnonymousObject);
          AppMethodBeat.o(210161);
          return i;
        }
        
        protected final int p(Object paramAnonymousObject)
        {
          AppMethodBeat.i(210162);
          int i = b.this.indexOf(paramAnonymousObject);
          AppMethodBeat.o(210162);
          return i;
        }
        
        protected final Object t(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.zD[paramAnonymousInt1];
        }
      };
    }
    Iterator localIterator = this.zu.getKeySet().iterator();
    AppMethodBeat.o(210201);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(210189);
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      AppMethodBeat.o(210189);
      return true;
    }
    AppMethodBeat.o(210189);
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(210207);
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    AppMethodBeat.o(210207);
    return bool;
  }
  
  public final E removeAt(int paramInt)
  {
    int i = 8;
    AppMethodBeat.i(210191);
    Object localObject = this.zD[paramInt];
    if (this.mSize <= 1)
    {
      a(this.zC, this.zD, this.mSize);
      this.zC = zw;
      this.zD = zx;
      this.mSize = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(210191);
      return localObject;
      if ((this.zC.length > 8) && (this.mSize < this.zC.length / 3))
      {
        if (this.mSize > 8) {
          i = this.mSize + (this.mSize >> 1);
        }
        int[] arrayOfInt = this.zC;
        Object[] arrayOfObject = this.zD;
        aH(i);
        this.mSize -= 1;
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.zC, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.zD, 0, paramInt);
        }
        if (paramInt < this.mSize)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.zC, paramInt, this.mSize - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1, this.zD, paramInt, this.mSize - paramInt);
        }
      }
      else
      {
        this.mSize -= 1;
        if (paramInt < this.mSize)
        {
          System.arraycopy(this.zC, paramInt + 1, this.zC, paramInt, this.mSize - paramInt);
          System.arraycopy(this.zD, paramInt + 1, this.zD, paramInt, this.mSize - paramInt);
        }
        this.zD[this.mSize] = null;
      }
    }
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(210210);
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.zD[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    AppMethodBeat.o(210210);
    return bool;
  }
  
  public final int size()
  {
    return this.mSize;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(210193);
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.zD, 0, arrayOfObject, 0, this.mSize);
    AppMethodBeat.o(210193);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(210195);
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.zD, 0, paramArrayOfT, 0, this.mSize);
      if (paramArrayOfT.length > this.mSize) {
        paramArrayOfT[this.mSize] = null;
      }
      AppMethodBeat.o(210195);
      return paramArrayOfT;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210198);
    if (isEmpty())
    {
      AppMethodBeat.o(210198);
      return "{}";
    }
    Object localObject1 = new StringBuilder(this.mSize * 14);
    ((StringBuilder)localObject1).append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        ((StringBuilder)localObject1).append(", ");
      }
      Object localObject2 = this.zD[i];
      if (localObject2 != this) {
        ((StringBuilder)localObject1).append(localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject1).append("(this Set)");
      }
    }
    ((StringBuilder)localObject1).append('}');
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(210198);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.b.b
 * JD-Core Version:    0.7.0.1
 */