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
  private static final int[] RJ = new int[0];
  private static final Object[] RK = new Object[0];
  private static Object[] RL;
  private static int RM;
  private static Object[] RN;
  private static int RO;
  private f<E, E> RH;
  private int[] RP;
  public Object[] RQ;
  int mSize;
  
  public b()
  {
    this(0);
  }
  
  public b(int paramInt)
  {
    AppMethodBeat.i(194583);
    if (paramInt == 0)
    {
      this.RP = RJ;
      this.RQ = RK;
    }
    for (;;)
    {
      this.mSize = 0;
      AppMethodBeat.o(194583);
      return;
      bg(paramInt);
    }
  }
  
  private static void a(int[] paramArrayOfInt, Object[] paramArrayOfObject, int paramInt)
  {
    if (paramArrayOfInt.length == 8) {}
    for (;;)
    {
      try
      {
        if (RO < 10)
        {
          paramArrayOfObject[0] = RN;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break;
          RN = paramArrayOfObject;
          RO += 1;
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
        if (RM < 10)
        {
          paramArrayOfObject[0] = RL;
          paramArrayOfObject[1] = paramArrayOfInt;
          paramInt -= 1;
          break label129;
          RL = paramArrayOfObject;
          RM += 1;
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
  
  private int b(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(194532);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(194532);
      return -1;
    }
    int k = c.a(this.RP, j, paramInt);
    if (k < 0)
    {
      AppMethodBeat.o(194532);
      return k;
    }
    if (paramObject.equals(this.RQ[k]))
    {
      AppMethodBeat.o(194532);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.RP[i] == paramInt))
    {
      if (paramObject.equals(this.RQ[i]))
      {
        AppMethodBeat.o(194532);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.RP[j] == paramInt))
    {
      if (paramObject.equals(this.RQ[j]))
      {
        AppMethodBeat.o(194532);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(194532);
    return i ^ 0xFFFFFFFF;
  }
  
  private void bg(int paramInt)
  {
    if (paramInt == 8) {}
    for (;;)
    {
      try
      {
        if (RN != null)
        {
          Object[] arrayOfObject1 = RN;
          this.RQ = arrayOfObject1;
          RN = (Object[])arrayOfObject1[0];
          this.RP = ((int[])arrayOfObject1[1]);
          arrayOfObject1[1] = null;
          arrayOfObject1[0] = null;
          RO -= 1;
          return;
        }
        this.RP = new int[paramInt];
        this.RQ = new Object[paramInt];
        return;
      }
      finally {}
      if (paramInt == 4) {
        try
        {
          if (RL != null)
          {
            Object[] arrayOfObject2 = RL;
            this.RQ = arrayOfObject2;
            RL = (Object[])arrayOfObject2[0];
            this.RP = ((int[])arrayOfObject2[1]);
            arrayOfObject2[1] = null;
            arrayOfObject2[0] = null;
            RM -= 1;
            return;
          }
        }
        finally {}
      }
    }
  }
  
  private int lk()
  {
    AppMethodBeat.i(194539);
    int j = this.mSize;
    if (j == 0)
    {
      AppMethodBeat.o(194539);
      return -1;
    }
    int k = c.a(this.RP, j, 0);
    if (k < 0)
    {
      AppMethodBeat.o(194539);
      return k;
    }
    if (this.RQ[k] == null)
    {
      AppMethodBeat.o(194539);
      return k;
    }
    int i = k + 1;
    while ((i < j) && (this.RP[i] == 0))
    {
      if (this.RQ[i] == null)
      {
        AppMethodBeat.o(194539);
        return i;
      }
      i += 1;
    }
    j = k - 1;
    while ((j >= 0) && (this.RP[j] == 0))
    {
      if (this.RQ[j] == null)
      {
        AppMethodBeat.o(194539);
        return j;
      }
      j -= 1;
    }
    AppMethodBeat.o(194539);
    return i ^ 0xFFFFFFFF;
  }
  
  public final boolean add(E paramE)
  {
    int k = 8;
    AppMethodBeat.i(194636);
    int i;
    int j;
    if (paramE == null)
    {
      i = lk();
      j = 0;
    }
    while (i >= 0)
    {
      AppMethodBeat.o(194636);
      return false;
      j = paramE.hashCode();
      i = b(paramE, j);
    }
    int m = i ^ 0xFFFFFFFF;
    if (this.mSize >= this.RP.length)
    {
      if (this.mSize < 8) {
        break label242;
      }
      i = this.mSize + (this.mSize >> 1);
    }
    for (;;)
    {
      Object localObject = this.RP;
      Object[] arrayOfObject = this.RQ;
      bg(i);
      if (this.RP.length > 0)
      {
        System.arraycopy(localObject, 0, this.RP, 0, localObject.length);
        System.arraycopy(arrayOfObject, 0, this.RQ, 0, arrayOfObject.length);
      }
      a((int[])localObject, arrayOfObject, this.mSize);
      if (m < this.mSize)
      {
        localObject = this.RP;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
        localObject = this.RQ;
        System.arraycopy(localObject, m, localObject, m + 1, this.mSize - m);
      }
      this.RP[m] = j;
      this.RQ[m] = paramE;
      this.mSize += 1;
      AppMethodBeat.o(194636);
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
    AppMethodBeat.i(194747);
    int i = this.mSize + paramCollection.size();
    if (this.RP.length < i)
    {
      int[] arrayOfInt = this.RP;
      Object[] arrayOfObject = this.RQ;
      bg(i);
      if (this.mSize > 0)
      {
        System.arraycopy(arrayOfInt, 0, this.RP, 0, this.mSize);
        System.arraycopy(arrayOfObject, 0, this.RQ, 0, this.mSize);
      }
      a(arrayOfInt, arrayOfObject, this.mSize);
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= add(paramCollection.next());
    }
    AppMethodBeat.o(194747);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(194599);
    if (this.mSize != 0)
    {
      a(this.RP, this.RQ, this.mSize);
      this.RP = RJ;
      this.RQ = RK;
      this.mSize = 0;
    }
    AppMethodBeat.o(194599);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(194607);
    if (indexOf(paramObject) >= 0)
    {
      AppMethodBeat.o(194607);
      return true;
    }
    AppMethodBeat.o(194607);
    return false;
  }
  
  public final boolean containsAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(194736);
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next()))
      {
        AppMethodBeat.o(194736);
        return false;
      }
    }
    AppMethodBeat.o(194736);
    return true;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(194702);
    if (this == paramObject)
    {
      AppMethodBeat.o(194702);
      return true;
    }
    if ((paramObject instanceof Set))
    {
      paramObject = (Set)paramObject;
      if (size() != paramObject.size())
      {
        AppMethodBeat.o(194702);
        return false;
      }
      int i = 0;
      try
      {
        while (i < this.mSize)
        {
          boolean bool = paramObject.contains(this.RQ[i]);
          if (!bool)
          {
            AppMethodBeat.o(194702);
            return false;
          }
          i += 1;
        }
        AppMethodBeat.o(194702);
      }
      catch (NullPointerException paramObject)
      {
        AppMethodBeat.o(194702);
        return false;
      }
      catch (ClassCastException paramObject)
      {
        AppMethodBeat.o(194702);
        return false;
      }
      return true;
    }
    AppMethodBeat.o(194702);
    return false;
  }
  
  public final int hashCode()
  {
    int[] arrayOfInt = this.RP;
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
    AppMethodBeat.i(194615);
    if (paramObject == null)
    {
      i = lk();
      AppMethodBeat.o(194615);
      return i;
    }
    int i = b(paramObject, paramObject.hashCode());
    AppMethodBeat.o(194615);
    return i;
  }
  
  public final boolean isEmpty()
  {
    return this.mSize <= 0;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(194729);
    if (this.RH == null) {
      this.RH = new f()
      {
        protected final Object B(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          return b.this.RQ[paramAnonymousInt1];
        }
        
        protected final E b(int paramAnonymousInt, E paramAnonymousE)
        {
          AppMethodBeat.i(194640);
          paramAnonymousE = new UnsupportedOperationException("not a map");
          AppMethodBeat.o(194640);
          throw paramAnonymousE;
        }
        
        protected final void bf(int paramAnonymousInt)
        {
          AppMethodBeat.i(194651);
          b.this.removeAt(paramAnonymousInt);
          AppMethodBeat.o(194651);
        }
        
        protected final void d(E paramAnonymousE1, E paramAnonymousE2)
        {
          AppMethodBeat.i(194628);
          b.this.add(paramAnonymousE1);
          AppMethodBeat.o(194628);
        }
        
        protected final int lh()
        {
          return b.this.mSize;
        }
        
        protected final Map<E, E> li()
        {
          AppMethodBeat.i(194621);
          UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("not a map");
          AppMethodBeat.o(194621);
          throw localUnsupportedOperationException;
        }
        
        protected final void lj()
        {
          AppMethodBeat.i(194661);
          b.this.clear();
          AppMethodBeat.o(194661);
        }
        
        protected final int w(Object paramAnonymousObject)
        {
          AppMethodBeat.i(194600);
          int i = b.this.indexOf(paramAnonymousObject);
          AppMethodBeat.o(194600);
          return i;
        }
        
        protected final int x(Object paramAnonymousObject)
        {
          AppMethodBeat.i(194610);
          int i = b.this.indexOf(paramAnonymousObject);
          AppMethodBeat.o(194610);
          return i;
        }
      };
    }
    Iterator localIterator = this.RH.ln().iterator();
    AppMethodBeat.o(194729);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(194646);
    int i = indexOf(paramObject);
    if (i >= 0)
    {
      removeAt(i);
      AppMethodBeat.o(194646);
      return true;
    }
    AppMethodBeat.o(194646);
    return false;
  }
  
  public final boolean removeAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(194756);
    boolean bool = false;
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      bool |= remove(paramCollection.next());
    }
    AppMethodBeat.o(194756);
    return bool;
  }
  
  public final E removeAt(int paramInt)
  {
    int i = 8;
    AppMethodBeat.i(194663);
    Object localObject = this.RQ[paramInt];
    if (this.mSize <= 1)
    {
      a(this.RP, this.RQ, this.mSize);
      this.RP = RJ;
      this.RQ = RK;
      this.mSize = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(194663);
      return localObject;
      if ((this.RP.length > 8) && (this.mSize < this.RP.length / 3))
      {
        if (this.mSize > 8) {
          i = this.mSize + (this.mSize >> 1);
        }
        int[] arrayOfInt = this.RP;
        Object[] arrayOfObject = this.RQ;
        bg(i);
        this.mSize -= 1;
        if (paramInt > 0)
        {
          System.arraycopy(arrayOfInt, 0, this.RP, 0, paramInt);
          System.arraycopy(arrayOfObject, 0, this.RQ, 0, paramInt);
        }
        if (paramInt < this.mSize)
        {
          System.arraycopy(arrayOfInt, paramInt + 1, this.RP, paramInt, this.mSize - paramInt);
          System.arraycopy(arrayOfObject, paramInt + 1, this.RQ, paramInt, this.mSize - paramInt);
        }
      }
      else
      {
        this.mSize -= 1;
        if (paramInt < this.mSize)
        {
          System.arraycopy(this.RP, paramInt + 1, this.RP, paramInt, this.mSize - paramInt);
          System.arraycopy(this.RQ, paramInt + 1, this.RQ, paramInt, this.mSize - paramInt);
        }
        this.RQ[this.mSize] = null;
      }
    }
  }
  
  public final boolean retainAll(Collection<?> paramCollection)
  {
    AppMethodBeat.i(194764);
    boolean bool = false;
    int i = this.mSize - 1;
    while (i >= 0)
    {
      if (!paramCollection.contains(this.RQ[i]))
      {
        removeAt(i);
        bool = true;
      }
      i -= 1;
    }
    AppMethodBeat.o(194764);
    return bool;
  }
  
  public final int size()
  {
    return this.mSize;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(194677);
    Object[] arrayOfObject = new Object[this.mSize];
    System.arraycopy(this.RQ, 0, arrayOfObject, 0, this.mSize);
    AppMethodBeat.o(194677);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(194690);
    if (paramArrayOfT.length < this.mSize) {
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.mSize);
    }
    for (;;)
    {
      System.arraycopy(this.RQ, 0, paramArrayOfT, 0, this.mSize);
      if (paramArrayOfT.length > this.mSize) {
        paramArrayOfT[this.mSize] = null;
      }
      AppMethodBeat.o(194690);
      return paramArrayOfT;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(194722);
    if (isEmpty())
    {
      AppMethodBeat.o(194722);
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
      Object localObject2 = this.RQ[i];
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
    AppMethodBeat.o(194722);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.b.b
 * JD-Core Version:    0.7.0.1
 */