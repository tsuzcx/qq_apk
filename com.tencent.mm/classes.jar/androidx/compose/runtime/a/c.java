package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.a.a;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/IdentityArraySet;", "T", "", "", "()V", "size", "", "getSize", "()I", "setSize", "(I)V", "values", "", "getValues$annotations", "getValues", "()[Ljava/lang/Object;", "setValues", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "add", "", "value", "(Ljava/lang/Object;)Z", "clear", "", "contains", "element", "containsAll", "elements", "", "find", "findExactIndex", "midIndex", "valueHash", "forEach", "block", "Lkotlin/Function1;", "get", "index", "(I)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "iterator", "", "remove", "removeValueIf", "predicate", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T>
  implements Set<T>, a
{
  public Object[] aqm;
  public int size;
  
  public c()
  {
    AppMethodBeat.i(202036);
    this.aqm = new Object[16];
    AppMethodBeat.o(202036);
  }
  
  private final int V(Object paramObject)
  {
    AppMethodBeat.i(202049);
    int i = 0;
    int j = size();
    int k = System.identityHashCode(paramObject);
    j -= 1;
    while (i <= j)
    {
      int m = i + j >>> 1;
      Object localObject = get(m);
      int n = System.identityHashCode(localObject) - k;
      if (n < 0)
      {
        i = m + 1;
      }
      else if (n > 0)
      {
        j = m - 1;
      }
      else
      {
        if (localObject == paramObject)
        {
          AppMethodBeat.o(202049);
          return m;
        }
        i = a(m, paramObject, k);
        AppMethodBeat.o(202049);
        return i;
      }
    }
    i = -(i + 1);
    AppMethodBeat.o(202049);
    return i;
  }
  
  private final int a(int paramInt1, Object paramObject, int paramInt2)
  {
    AppMethodBeat.i(202056);
    int i = paramInt1 - 1;
    if (i >= 0) {}
    for (;;)
    {
      int j = i - 1;
      Object localObject = this.aqm[i];
      if (localObject == paramObject)
      {
        AppMethodBeat.o(202056);
        return i;
      }
      if ((System.identityHashCode(localObject) != paramInt2) || (j < 0))
      {
        paramInt1 += 1;
        j = size();
        if (paramInt1 < j) {}
        for (;;)
        {
          i = paramInt1 + 1;
          localObject = this.aqm[paramInt1];
          if (localObject == paramObject)
          {
            AppMethodBeat.o(202056);
            return paramInt1;
          }
          if (System.identityHashCode(localObject) != paramInt2)
          {
            paramInt1 = -(paramInt1 + 1);
            AppMethodBeat.o(202056);
            return paramInt1;
          }
          if (i >= j)
          {
            paramInt1 = -(size() + 1);
            AppMethodBeat.o(202056);
            return paramInt1;
          }
          paramInt1 = i;
        }
      }
      i = j;
    }
  }
  
  private T get(int paramInt)
  {
    AppMethodBeat.i(202041);
    Object localObject = this.aqm[paramInt];
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
      AppMethodBeat.o(202041);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(202041);
    return localObject;
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(202073);
    s.u(paramT, "value");
    if (size() > 0)
    {
      int j = V(paramT);
      i = j;
      if (j >= 0)
      {
        AppMethodBeat.o(202073);
        return false;
      }
    }
    else
    {
      i = -1;
    }
    int i = -(i + 1);
    if (size() == this.aqm.length)
    {
      Object[] arrayOfObject = new Object[this.aqm.length * 2];
      k.a(this.aqm, arrayOfObject, i + 1, i, size());
      k.a(this.aqm, arrayOfObject, 0, 0, i, 6);
      this.aqm = arrayOfObject;
    }
    for (;;)
    {
      this.aqm[i] = paramT;
      this.size = (size() + 1);
      AppMethodBeat.o(202073);
      return true;
      k.a(this.aqm, this.aqm, i + 1, i, size());
    }
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202132);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(202132);
    throw paramCollection;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202084);
    int k = size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      this.aqm[i] = null;
      if (j >= k)
      {
        this.size = 0;
        AppMethodBeat.o(202084);
        return;
      }
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202063);
    if (paramObject == null)
    {
      AppMethodBeat.o(202063);
      return false;
    }
    if (V(paramObject) >= 0)
    {
      AppMethodBeat.o(202063);
      return true;
    }
    AppMethodBeat.o(202063);
    return false;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202121);
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next()))
        {
          AppMethodBeat.o(202121);
          return false;
        }
      }
    }
    AppMethodBeat.o(202121);
    return true;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202092);
    if (size() == 0)
    {
      AppMethodBeat.o(202092);
      return true;
    }
    AppMethodBeat.o(202092);
    return false;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(202126);
    Iterator localIterator = (Iterator)new a(this);
    AppMethodBeat.o(202126);
    return localIterator;
  }
  
  public final boolean qn()
  {
    AppMethodBeat.i(202099);
    if (size() > 0)
    {
      AppMethodBeat.o(202099);
      return true;
    }
    AppMethodBeat.o(202099);
    return false;
  }
  
  public final boolean remove(T paramT)
  {
    AppMethodBeat.i(202109);
    if (paramT == null)
    {
      AppMethodBeat.o(202109);
      return false;
    }
    int i = V(paramT);
    if (i >= 0)
    {
      if (i < size() - 1) {
        k.a(this.aqm, this.aqm, i, i + 1, size());
      }
      this.size = (size() - 1);
      this.aqm[size()] = null;
      AppMethodBeat.o(202109);
      return true;
    }
    AppMethodBeat.o(202109);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202140);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(202140);
    throw paramCollection;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202150);
    paramCollection = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(202150);
    throw paramCollection;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(202170);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(202170);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202163);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(202163);
    return paramArrayOfT;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/collection/IdentityArraySet$iterator$1", "", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Iterator<T>, a
  {
    private int index;
    
    a(c<T> paramc) {}
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(202005);
      if (this.index < this.aqn.size())
      {
        AppMethodBeat.o(202005);
        return true;
      }
      AppMethodBeat.o(202005);
      return false;
    }
    
    public final T next()
    {
      AppMethodBeat.i(202012);
      Object localObject = this.aqn.aqm;
      int i = this.index;
      this.index = (i + 1);
      localObject = localObject[i];
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type T of androidx.compose.runtime.collection.IdentityArraySet");
        AppMethodBeat.o(202012);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(202012);
      return localObject;
    }
    
    public final void remove()
    {
      AppMethodBeat.i(202020);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
      AppMethodBeat.o(202020);
      throw localUnsupportedOperationException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.a.c
 * JD-Core Version:    0.7.0.1
 */