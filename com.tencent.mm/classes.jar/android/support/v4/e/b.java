package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] OF = new int[0];
  private static final Object[] OG = new Object[0];
  private static Object[] OH;
  private static int OI;
  private static Object[] OJ;
  private static int OL;
  private i<E, E> OD;
  private int[] OM;
  public Object[] OO;
  int mSize;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.OM = OF;
      this.OO = OG;
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
        if (OL < 10)
        {
          paramArrayOfObject[0] = OJ;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          OJ = paramArrayOfObject;
          OL += 1;
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
        if (OI < 10)
        {
          paramArrayOfObject[0] = OH;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          OH = paramArrayOfObject;
          OI += 1;
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
        if (OJ != null)
        {
          Object[] arrayOfObject1 = OJ;
          this.OO = arrayOfObject1;
          OJ = (Object[])arrayOfObject1[0];
          this.OM = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          OL -= 1;
          return;
        }
        this.OM = new int[paramInt];
        this.OO = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (OH != null)
          {
            Object[] arrayOfObject2 = OH;
            this.OO = arrayOfObject2;
            OH = (Object[])arrayOfObject2[0];
            this.OM = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            OI -= 1;
            return;
          }
        }
        finally {}
      }
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
        j = d.b(this.OM, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.OO[j] == null);
    int k = j + 1;
    while ((k < m) && (this.OM[k] == 0))
    {
      if (this.OO[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.OM[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.OO[j] == null) {
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
        j = d.b(this.OM, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.OO[j]));
    int k = j + 1;
    while ((k < m) && (this.OM[k] == paramInt))
    {
      if (paramObject.equals(this.OO[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.OM[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.OO[j])) {
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
      i = fv();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.OM.length)
    {
      if (this.mSize < 8) {
        break label227;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.OM;
      Object[] arrayOfObject = this.OO;
      aH(i);
      if (this.OM.length > 0)
      {
        System.arraycopy(localObject, 0, this.OM, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.OO, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.OM;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.OO;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.OM[m] = j;
      this.OO[m] = paramE;
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
    if (this.OM.length < i)
    {
      int[] arrayOfInt = this.OM;
      Object[] arrayOfObject = this.OO;
      aH(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.OM, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.OO, 0, this.mSize);
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
      a(this.OM, this.OO, this.mSize);
      this.OM = OF;
      this.OO = OG;
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
            boolean bool = paramObject.contains(this.OO[i]);
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
    int[] arrayOfInt = this.OM;
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
      return fv();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.OD == null) {
      this.OD = new i()
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
        
        protected final int fs()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> ft()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void fu()
        {
          b.this.clear();
        }
        
        protected final Object z(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.OO[paramAnonymousInt1];
        }
      };
    }
    return this.OD.getKeySet().iterator();
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
    Object localObject = this.OO[paramInt];
    if (this.mSize <= 1)
    {
      a(this.OM, this.OO, this.mSize);
      this.OM = OF;
      this.OO = OG;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.OM.length <= 8) || (this.mSize >= this.OM.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.OM;
      arrayOfObject = this.OO;
      aH(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.OM, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.OO, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.OM, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.OO, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.OM, paramInt + 1, this.OM, paramInt, this.mSize - paramInt);
      System.arraycopy(this.OO, paramInt + 1, this.OO, paramInt, this.mSize - paramInt);
    }
    this.OO[this.mSize] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.OO[i]))
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
    System.arraycopy(this.OO, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.OO, 0, paramArrayOfT, 0, this.mSize);
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
      Object localObject = this.OO[i];
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