package android.support.v4.f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b<E>
  implements Collection<E>, Set<E>
{
  private static final int[] DS = new int[0];
  private static final Object[] DT = new Object[0];
  private static Object[] DU;
  private static int DV;
  private static Object[] DW;
  private static int DX;
  private h<E, E> DQ;
  private int[] DY = DS;
  public Object[] DZ = DT;
  private int mSize = 0;
  
  public b()
  {
    this((byte)0);
  }
  
  private b(byte paramByte) {}
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {
      try
      {
        if (DX < 10)
        {
          paramArrayOfObject[0] = DW;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label113;
          DW = paramArrayOfObject;
          DX += 1;
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
        if (DV < 10)
        {
          paramArrayOfObject[0] = DU;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label130;
          DU = paramArrayOfObject;
          DV += 1;
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
  
  private void ar(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (DW != null)
        {
          Object[] arrayOfObject1 = DW;
          this.DZ = arrayOfObject1;
          DW = (Object[])arrayOfObject1[0];
          this.DY = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          DX -= 1;
          return;
        }
        this.DY = new int[paramInt];
        this.DZ = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (DU != null)
          {
            Object[] arrayOfObject2 = DU;
            this.DZ = arrayOfObject2;
            DU = (Object[])arrayOfObject2[0];
            this.DY = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            DV -= 1;
            return;
          }
        }
        finally {}
      }
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
        j = c.a(this.DY, m, 0);
        i = j;
      } while (j < 0);
      i = j;
    } while (this.DZ[j] == null);
    int k = j + 1;
    while ((k < m) && (this.DY[k] == 0))
    {
      if (this.DZ[k] == null) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.DY[j] != 0)) {
        break label115;
      }
      i = j;
      if (this.DZ[j] == null) {
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
        j = c.a(this.DY, m, paramInt);
        i = j;
      } while (j < 0);
      i = j;
    } while (paramObject.equals(this.DZ[j]));
    int k = j + 1;
    while ((k < m) && (this.DY[k] == paramInt))
    {
      if (paramObject.equals(this.DZ[k])) {
        return k;
      }
      k += 1;
    }
    j -= 1;
    for (;;)
    {
      if ((j < 0) || (this.DY[j] != paramInt)) {
        break label150;
      }
      i = j;
      if (paramObject.equals(this.DZ[j])) {
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
      i = da();
      j = 0;
    }
    while (i >= 0)
    {
      return false;
      j = paramE.hashCode();
      i = indexOf(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.DY.length)
    {
      if (this.mSize < 8) {
        break label223;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      int[] arrayOfInt = this.DY;
      Object[] arrayOfObject = this.DZ;
      ar(i);
      if (this.DY.length > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.DY, 0, arrayOfInt.length);
        System.arraycopy(arrayOfObject, 0, this.DZ, 0, arrayOfObject.length);
      }
      a(arrayOfInt, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        System.arraycopy(this.DY, m, this.DY, m + 1, this.mSize - m);
        System.arraycopy(this.DZ, m, this.DZ, m + 1, this.mSize - m);
      }
      this.DY[m] = j;
      this.DZ[m] = paramE;
      this.mSize += 1;
      return true;
      label223:
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
    if (this.DY.length < i)
    {
      int[] arrayOfInt = this.DY;
      Object[] arrayOfObject = this.DZ;
      ar(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.DY, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.DZ, 0, this.mSize);
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
      a(this.DY, this.DZ, this.mSize);
      this.DY = DS;
      this.DZ = DT;
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
            boolean bool = paramObject.contains(this.DZ[i]);
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
    int[] arrayOfInt = this.DY;
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
      return da();
    }
    return indexOf(paramObject, paramObject.hashCode());
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    if (this.DQ == null) {
      this.DQ = new h()
      {
        protected final int B(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final int C(Object paramAnonymousObject)
        {
          return b.this.indexOf(paramAnonymousObject);
        }
        
        protected final void aq(int paramAnonymousInt)
        {
          b.this.removeAt(paramAnonymousInt);
        }
        
        protected final E b(int paramAnonymousInt, E paramAnonymousE)
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void c(E paramAnonymousE1, E paramAnonymousE2)
        {
          b.this.add(paramAnonymousE1);
        }
        
        protected final int cX()
        {
          return b.c(b.this);
        }
        
        protected final Map<E, E> cY()
        {
          throw new UnsupportedOperationException("not a map");
        }
        
        protected final void cZ()
        {
          b.this.clear();
        }
        
        protected final Object q(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.d(b.this)[paramAnonymousInt1];
        }
      };
    }
    return this.DQ.dd().iterator();
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
    Object localObject = this.DZ[paramInt];
    if (this.mSize <= 1)
    {
      a(this.DY, this.DZ, this.mSize);
      this.DY = DS;
      this.DZ = DT;
      this.mSize = 0;
    }
    int[] arrayOfInt;
    Object[] arrayOfObject;
    do
    {
      return localObject;
      if ((this.DY.length <= 8) || (this.mSize >= this.DY.length / 3)) {
        break;
      }
      if (this.mSize > 8) {
        i = this.mSize + (this.mSize >> 1);
      }
      arrayOfInt = this.DY;
      arrayOfObject = this.DZ;
      ar(i);
      this.mSize -= 1;
      if (paramInt > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.DY, 0, paramInt);
        System.arraycopy(arrayOfObject, 0, this.DZ, 0, paramInt);
      }
    } while (paramInt >= this.mSize);
    System.arraycopy(arrayOfInt, paramInt + 1, this.DY, paramInt, this.mSize - paramInt);
    System.arraycopy(arrayOfObject, paramInt + 1, this.DZ, paramInt, this.mSize - paramInt);
    return localObject;
    this.mSize -= 1;
    if (paramInt < this.mSize)
    {
      System.arraycopy(this.DY, paramInt + 1, this.DY, paramInt, this.mSize - paramInt);
      System.arraycopy(this.DZ, paramInt + 1, this.DZ, paramInt, this.mSize - paramInt);
    }
    this.DZ[this.mSize] = null;
    return localObject;
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.DZ[i]))
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
    System.arraycopy(this.DZ, 0, arrayOfObject, 0, this.mSize);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.DZ, 0, paramArrayOfT, 0, this.mSize);
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
      Object localObject = this.DZ[i];
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
 * Qualified Name:     android.support.v4.f.b
 * JD-Core Version:    0.7.0.1
 */