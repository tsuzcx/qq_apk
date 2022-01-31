package a.j.b.a.c.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;

public final class h<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int CFe;
  private Object CFf;
  
  public final void add(int paramInt, E paramE)
  {
    AppMethodBeat.i(122957);
    if ((paramInt < 0) || (paramInt > this.CFe))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.CFe);
      AppMethodBeat.o(122957);
      throw paramE;
    }
    if (this.CFe == 0) {}
    for (this.CFf = paramE;; this.CFf = new Object[] { paramE, this.CFf })
    {
      this.CFe += 1;
      this.modCount += 1;
      AppMethodBeat.o(122957);
      return;
      if ((this.CFe != 1) || (paramInt != 0)) {
        break;
      }
    }
    Object[] arrayOfObject1 = new Object[this.CFe + 1];
    if (this.CFe == 1) {
      arrayOfObject1[0] = this.CFf;
    }
    for (;;)
    {
      arrayOfObject1[paramInt] = paramE;
      this.CFf = arrayOfObject1;
      break;
      Object[] arrayOfObject2 = (Object[])this.CFf;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, paramInt);
      System.arraycopy(arrayOfObject2, paramInt, arrayOfObject1, paramInt + 1, this.CFe - paramInt);
    }
  }
  
  public final boolean add(E paramE)
  {
    AppMethodBeat.i(122956);
    if (this.CFe == 0) {}
    for (this.CFf = paramE;; this.CFf = new Object[] { this.CFf, paramE })
    {
      this.CFe += 1;
      this.modCount += 1;
      AppMethodBeat.o(122956);
      return true;
      if (this.CFe != 1) {
        break;
      }
    }
    Object[] arrayOfObject2 = (Object[])this.CFf;
    int k = arrayOfObject2.length;
    Object[] arrayOfObject1 = arrayOfObject2;
    int i;
    if (this.CFe >= k)
    {
      i = k * 3 / 2 + 1;
      int j = this.CFe + 1;
      if (i >= j) {
        break label161;
      }
      i = j;
    }
    label161:
    for (;;)
    {
      arrayOfObject1 = new Object[i];
      this.CFf = arrayOfObject1;
      System.arraycopy(arrayOfObject2, 0, arrayOfObject1, 0, k);
      arrayOfObject1[this.CFe] = paramE;
      break;
    }
  }
  
  public final void clear()
  {
    this.CFf = null;
    this.CFe = 0;
    this.modCount += 1;
  }
  
  public final E get(int paramInt)
  {
    AppMethodBeat.i(122955);
    if ((paramInt < 0) || (paramInt >= this.CFe))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.CFe);
      AppMethodBeat.o(122955);
      throw ((Throwable)localObject);
    }
    if (this.CFe == 1)
    {
      localObject = this.CFf;
      AppMethodBeat.o(122955);
      return localObject;
    }
    Object localObject = ((Object[])(Object[])this.CFf)[paramInt];
    AppMethodBeat.o(122955);
    return localObject;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(122960);
    if (this.CFe == 0)
    {
      localObject = h.a.eoY();
      AppMethodBeat.o(122960);
      return localObject;
    }
    if (this.CFe == 1)
    {
      localObject = new h.b(this);
      AppMethodBeat.o(122960);
      return localObject;
    }
    Object localObject = super.iterator();
    AppMethodBeat.o(122960);
    return localObject;
  }
  
  public final E remove(int paramInt)
  {
    AppMethodBeat.i(122959);
    Object localObject;
    if ((paramInt < 0) || (paramInt >= this.CFe))
    {
      localObject = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.CFe);
      AppMethodBeat.o(122959);
      throw ((Throwable)localObject);
    }
    if (this.CFe == 1)
    {
      localObject = this.CFf;
      this.CFf = null;
    }
    for (;;)
    {
      this.CFe -= 1;
      this.modCount += 1;
      AppMethodBeat.o(122959);
      return localObject;
      Object[] arrayOfObject = (Object[])this.CFf;
      localObject = arrayOfObject[paramInt];
      if (this.CFe == 2)
      {
        this.CFf = arrayOfObject[(1 - paramInt)];
      }
      else
      {
        int i = this.CFe - paramInt - 1;
        if (i > 0) {
          System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
        }
        arrayOfObject[(this.CFe - 1)] = null;
      }
    }
  }
  
  public final E set(int paramInt, E paramE)
  {
    AppMethodBeat.i(122958);
    if ((paramInt < 0) || (paramInt >= this.CFe))
    {
      paramE = new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + this.CFe);
      AppMethodBeat.o(122958);
      throw paramE;
    }
    Object localObject;
    if (this.CFe == 1)
    {
      localObject = this.CFf;
      this.CFf = paramE;
    }
    for (paramE = localObject;; paramE = localObject)
    {
      AppMethodBeat.o(122958);
      return paramE;
      Object[] arrayOfObject = (Object[])this.CFf;
      localObject = arrayOfObject[paramInt];
      arrayOfObject[paramInt] = paramE;
    }
  }
  
  public final int size()
  {
    return this.CFe;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(122961);
    int i = paramArrayOfT.length;
    if (this.CFe == 1) {
      if (i != 0) {
        paramArrayOfT[0] = this.CFf;
      }
    }
    for (;;)
    {
      if (i > this.CFe) {
        paramArrayOfT[this.CFe] = null;
      }
      AppMethodBeat.o(122961);
      return paramArrayOfT;
      paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), 1);
      paramArrayOfT[0] = this.CFf;
      AppMethodBeat.o(122961);
      return paramArrayOfT;
      if (i < this.CFe)
      {
        paramArrayOfT = (Object[])Arrays.copyOf((Object[])this.CFf, this.CFe, paramArrayOfT.getClass());
        AppMethodBeat.o(122961);
        return paramArrayOfT;
      }
      if (this.CFe != 0) {
        System.arraycopy(this.CFf, 0, paramArrayOfT, 0, this.CFe);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.n.h
 * JD-Core Version:    0.7.0.1
 */