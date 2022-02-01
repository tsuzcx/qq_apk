package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] Ot = new int[0];
  private static final Object[] Ou = new Object[0];
  private static Object[] Ov;
  private static int Ow;
  private static Object[] Ox;
  private static int Oy;
  public Object[] OA;
  private i<E, E> Or;
  private int[] Oz;
  int mSize;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.Oz = Ot;
      this.OA = Ou;
    }
    for (;;)
    {
      this.mSize = 0;
      return;
      aH(paramInt);
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (Oy < 10)
        {
          paramArrayOfObject[0] = Ox;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          Ox = paramArrayOfObject;
          Oy += 1;
        }
        return;
      }
      finally {}
    } else {
      if (paramArrayOfInt.length != 4) {
        break label129;
      }
    }
    for (;;)
    {
      try
      {
        if (Ow < 10)
        {
          paramArrayOfObject[0] = Ov;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          Ov = paramArrayOfObject;
          Ow += 1;
        }
        return;
      }
      finally {}
      label113:
      while (paramInt >= 2)
      {
        paramArrayOfObject[paramInt] = null;
        paramInt -= 1;
      }
      break;
      label129:
      return;
      label130:
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
        if (Ox != null)
        {
          Object[] arrayOfObject1 = Ox;
          this.OA = arrayOfObject1;
          Ox = (Object[])arrayOfObject1[0];
          this.Oz = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          Oy -= 1;
          return;
        }
        this.Oz = new int[paramInt];
        this.OA = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (Ov != null)
          {
            Object[] arrayOfObject2 = Ov;
            this.OA = arrayOfObject2;
            Ov = (Object[])arrayOfObject2[0];
            this.Oz = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            Ow -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int fp()
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
        j = d.b(this.Oz, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.OA[j] == null);
    int k = j + 1;
    while ((k < m) && (this.Oz[k] == 0))
    {
      if (this.OA[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.Oz[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.OA[j] == null) {
        break;
      }
      j -= 1;
    }
    label115:
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
        j = d.b(this.Oz, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.OA[j]));
    int k = j + 1;
    while ((k < m) && (this.Oz[k] == paramInt))
    {
      if (paramObject.equals(this.OA[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.Oz[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.OA[j])) {
        break;
      }
      j -= 1;
    }
    label150:
    return k ^ 0xFFFFFFFF;
  }
  
  public final boolean add(E paramE)
  {
    int k = 8;
    int i;
    int j;
    if (paramE == null)
    {
      i = fp();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.Oz.length)
    {
      if (this.mSize < 8) {
        break label227;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.Oz;
      Object[] arrayOfObject = this.OA;
      aH(i);
      if (this.Oz.length > 0)
      {
        System.arraycopy(localObject, 0, this.Oz, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.OA, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.Oz;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.OA;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.Oz[m] = j;
      this.OA[m] = paramE;
      this.mSize += 1;
      return true;
      label227:
      i = k;
      if (this.mSize < 4) {
        i = 4;
      }
    }
  }
  
  public final boolean addAll(Collection<? extends E> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize + paramCollection.size();
    if (this.Oz.length < i)
    {
      int[] arrayOfInt = this.Oz;
      Object[] arrayOfObject = this.OA;
      aH(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.Oz, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.OA, 0, this.mSize);
      }
      a(arrayOfInt, arrayOfObject, this.mSize);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    return bool;
  }
  
  public final void clear()
  {
    if (this.mSize != 0)
    {
      a(this.Oz, this.OA, this.mSize);
      this.Oz = Ot;
      this.OA = Ou;
      this.mSize = 0;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    return indexOf(paramObject) >= 0;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next())) {
        return false;
      }
    }
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof Set))
      {
        paramObject = (Set)paramObject;
        if (size() != paramObject.size()) {
          return false;
        }
        int i = 0;
        try
        {
          while (i < this.mSize)
          {
            boolean bool = paramObject.contains(this.OA[i]);
            if (!bool) {
              return false;
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
  }
  
  public final int hashCode()
  {
    int[] arrayOfInt = this.Oz;
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
    if (paramObject == null) {
      return fp();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.Or == null) {
      this.Or = new i()
      {
        protected final int E(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int F(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final E a(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void aG(int paramAnonymousInt)
        {
          b.this.removeAt(paramAnonymousInt);
        }
        
        protected final void b(E paramAnonymousE1, E paramAnonymousE2)
        {
          b.this.add(paramAnonymousE1);
        }
        
        protected final int fm()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> fn()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void fo()
        {
          b.this.clear();
        }
        
        protected final Object z(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.OA[paramAnonymousInt1];
        }
      };
    }
    return this.Or.getKeySet().iterator();
  }
  
  public final boolean remove(Object paramObject)
  {
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      return true;
    }
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    return bool;
  }
  
  public final E removeAt(int paramInt)
  {
    int i = 8;
    Object localObject = this.OA[paramInt];
    if (this.mSize <= 1)
    {
      a(this.Oz, this.OA, this.mSize);
      this.Oz = Ot;
      this.OA = Ou;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.Oz.length <= 8) || (this.mSize >= this.Oz.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.Oz;
      arrayOfObject = this.OA;
      aH(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.Oz, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.OA, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.Oz, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.OA, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.Oz, paramInt + 1, this.Oz, paramInt, this.mSize - paramInt);
      System.arraycopy(this.OA, paramInt + 1, this.OA, paramInt, this.mSize - paramInt);
    }
    this.OA[this.mSize] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.OA[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    return bool;
  }
  
  public final int size()
  {
    return this.mSize;
  }
  
  public final Object[] toArray()
  {
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.OA, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.OA, 0, paramArrayOfT, 0, this.mSize);
      if (paramArrayOfT.length > this.mSize) {
        paramArrayOfT[this.mSize] = null;
      }
      return paramArrayOfT;
    }
  }
  
  public final String toString()
  {
    if (isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder(this.mSize * 14);
    localStringBuilder.append('{');
    int i = 0;
    if (i < this.mSize)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      Object localObject = this.OA[i];
      if (localObject != this) {
        localStringBuilder.append(localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("(this Set)");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.e.b
 * JD-Core Version:    0.7.0.1
 */