package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] MC = new int[0];
  private static final Object[] MD = new Object[0];
  private static Object[] MF;
  private static int MG;
  private static Object[] MH;
  private static int MI;
  private int[] MJ;
  public Object[] MK;
  private i<E, E> Mz;
  int mSize;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.MJ = MC;
      this.MK = MD;
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
        if (MI < 10)
        {
          paramArrayOfObject[0] = MH;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          MH = paramArrayOfObject;
          MI += 1;
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
        if (MG < 10)
        {
          paramArrayOfObject[0] = MF;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          MF = paramArrayOfObject;
          MG += 1;
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
        if (MH != null)
        {
          Object[] arrayOfObject1 = MH;
          this.MK = arrayOfObject1;
          MH = (Object[])arrayOfObject1[0];
          this.MJ = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          MI -= 1;
          return;
        }
        this.MJ = new int[paramInt];
        this.MK = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (MF != null)
          {
            Object[] arrayOfObject2 = MF;
            this.MK = arrayOfObject2;
            MF = (Object[])arrayOfObject2[0];
            this.MJ = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            MG -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int eY()
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
        j = d.b(this.MJ, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.MK[j] == null);
    int k = j + 1;
    while ((k < m) && (this.MJ[k] == 0))
    {
      if (this.MK[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.MJ[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.MK[j] == null) {
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
        j = d.b(this.MJ, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.MK[j]));
    int k = j + 1;
    while ((k < m) && (this.MJ[k] == paramInt))
    {
      if (paramObject.equals(this.MK[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.MJ[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.MK[j])) {
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
      i = eY();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.MJ.length)
    {
      if (this.mSize < 8) {
        break label227;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.MJ;
      Object[] arrayOfObject = this.MK;
      aH(i);
      if (this.MJ.length > 0)
      {
        System.arraycopy(localObject, 0, this.MJ, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.MK, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.MJ;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.MK;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.MJ[m] = j;
      this.MK[m] = paramE;
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
    if (this.MJ.length < i)
    {
      int[] arrayOfInt = this.MJ;
      Object[] arrayOfObject = this.MK;
      aH(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.MJ, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.MK, 0, this.mSize);
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
      a(this.MJ, this.MK, this.mSize);
      this.MJ = MC;
      this.MK = MD;
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
            boolean bool = paramObject.contains(this.MK[i]);
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
    int[] arrayOfInt = this.MJ;
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
      return eY();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.Mz == null) {
      this.Mz = new i()
      {
        protected final int D(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int E(Object paramAnonymousObject)
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
        
        protected final int eV()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> eW()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void eX()
        {
          b.this.clear();
        }
        
        protected final Object s(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.MK[paramAnonymousInt1];
        }
      };
    }
    return this.Mz.getKeySet().iterator();
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
    Object localObject = this.MK[paramInt];
    if (this.mSize <= 1)
    {
      a(this.MJ, this.MK, this.mSize);
      this.MJ = MC;
      this.MK = MD;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.MJ.length <= 8) || (this.mSize >= this.MJ.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.MJ;
      arrayOfObject = this.MK;
      aH(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.MJ, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.MK, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.MJ, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.MK, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.MJ, paramInt + 1, this.MJ, paramInt, this.mSize - paramInt);
      System.arraycopy(this.MK, paramInt + 1, this.MK, paramInt, this.mSize - paramInt);
    }
    this.MK[this.mSize] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.MK[i]))
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
    System.arraycopy(this.MK, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.MK, 0, paramArrayOfT, 0, this.mSize);
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
      Object localObject = this.MK[i];
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