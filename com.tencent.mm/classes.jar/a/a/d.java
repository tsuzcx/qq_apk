package a.a;

import a.f.b.a.a;
import a.f.b.b;
import a.f.b.f;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/ArrayAsCollection;", "T", "", "values", "", "isVarargs", "", "([Ljava/lang/Object;Z)V", "()Z", "size", "", "getSize", "()I", "getValues", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "contains", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "kotlin-stdlib"})
public final class d<T>
  implements a, Collection<T>
{
  private final boolean BMp;
  private final T[] afB;
  
  public d(T[] paramArrayOfT, boolean paramBoolean)
  {
    AppMethodBeat.i(56193);
    this.afB = paramArrayOfT;
    this.BMp = paramBoolean;
    AppMethodBeat.o(56193);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(56194);
    paramT = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56194);
    throw paramT;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(56195);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56195);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(56196);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56196);
    throw localUnsupportedOperationException;
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(56189);
    boolean bool = e.contains(this.afB, paramObject);
    AppMethodBeat.o(56189);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(56190);
    j.q(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(56190);
          return false;
        }
      }
    }
    AppMethodBeat.o(56190);
    return true;
  }
  
  public final boolean isEmpty()
  {
    return this.afB.length == 0;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(56191);
    Iterator localIterator = b.W(this.afB);
    AppMethodBeat.o(56191);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(56197);
    paramObject = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56197);
    throw paramObject;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(56198);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56198);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(56199);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56199);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(56192);
    Object[] arrayOfObject = this.afB;
    boolean bool = this.BMp;
    j.q(arrayOfObject, "receiver$0");
    if ((bool) && (j.e(arrayOfObject.getClass(), [Ljava.lang.Object.class)))
    {
      AppMethodBeat.o(56192);
      return arrayOfObject;
    }
    arrayOfObject = Arrays.copyOf(arrayOfObject, arrayOfObject.length, [Ljava.lang.Object.class);
    j.p(arrayOfObject, "java.util.Arrays.copyOf(… Array<Any?>::class.java)");
    AppMethodBeat.o(56192);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56200);
    paramArrayOfT = f.a(this, paramArrayOfT);
    AppMethodBeat.o(56200);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.a.d
 * JD-Core Version:    0.7.0.1
 */