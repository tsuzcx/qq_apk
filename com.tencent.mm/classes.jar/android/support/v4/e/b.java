package android.support.v4.e;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] LG = new int[0];
  private static final Object[] LH = new Object[0];
  private static Object[] LI;
  private static int LJ;
  private static Object[] LK;
  private static int LL;
  private i<E, E> LE;
  private int[] LM;
  public Object[] LN;
  int mSize;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    if (paramInt == 0)
    {
      this.LM = LG;
      this.LN = LH;
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
        if (LL < 10)
        {
          paramArrayOfObject[0] = LK;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          LK = paramArrayOfObject;
          LL += 1;
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
        if (LJ < 10)
        {
          paramArrayOfObject[0] = LI;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          LI = paramArrayOfObject;
          LJ += 1;
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
        if (LK != null)
        {
          Object[] arrayOfObject1 = LK;
          this.LN = arrayOfObject1;
          LK = (Object[])arrayOfObject1[0];
          this.LM = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          LL -= 1;
          return;
        }
        this.LM = new int[paramInt];
        this.LN = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (LI != null)
          {
            Object[] arrayOfObject2 = LI;
            this.LN = arrayOfObject2;
            LI = (Object[])arrayOfObject2[0];
            this.LM = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            LJ -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int eQ()
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
        j = d.b(this.LM, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.LN[j] == null);
    int k = j + 1;
    while ((k < m) && (this.LM[k] == 0))
    {
      if (this.LN[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.LM[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.LN[j] == null) {
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
        j = d.b(this.LM, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.LN[j]));
    int k = j + 1;
    while ((k < m) && (this.LM[k] == paramInt))
    {
      if (paramObject.equals(this.LN[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.LM[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.LN[j])) {
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
      i = eQ();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.LM.length)
    {
      if (this.mSize < 8) {
        break label227;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.LM;
      Object[] arrayOfObject = this.LN;
      aH(i);
      if (this.LM.length > 0)
      {
        System.arraycopy(localObject, 0, this.LM, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.LN, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.LM;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.LN;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.LM[m] = j;
      this.LN[m] = paramE;
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
    if (this.LM.length < i)
    {
      int[] arrayOfInt = this.LM;
      Object[] arrayOfObject = this.LN;
      aH(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.LM, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.LN, 0, this.mSize);
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
      a(this.LM, this.LN, this.mSize);
      this.LM = LG;
      this.LN = LH;
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
            boolean bool = paramObject.contains(this.LN[i]);
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
    int[] arrayOfInt = this.LM;
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
      return eQ();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.LE == null) {
      this.LE = new i()
      {
        protected final int B(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int C(Object paramAnonymousObject)
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
        
        protected final int eN()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> eO()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void eP()
        {
          b.this.clear();
        }
        
        protected final Object s(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.LN[paramAnonymousInt1];
        }
      };
    }
    return this.LE.getKeySet().iterator();
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
    Object localObject = this.LN[paramInt];
    if (this.mSize <= 1)
    {
      a(this.LM, this.LN, this.mSize);
      this.LM = LG;
      this.LN = LH;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.LM.length <= 8) || (this.mSize >= this.LM.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.LM;
      arrayOfObject = this.LN;
      aH(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.LM, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.LN, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.LM, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.LN, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.LM, paramInt + 1, this.LM, paramInt, this.mSize - paramInt);
      System.arraycopy(this.LN, paramInt + 1, this.LN, paramInt, this.mSize - paramInt);
    }
    this.LN[this.mSize] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.LN[i]))
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
    System.arraycopy(this.LN, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.LN, 0, paramArrayOfT, 0, this.mSize);
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
      Object localObject = this.LN[i];
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