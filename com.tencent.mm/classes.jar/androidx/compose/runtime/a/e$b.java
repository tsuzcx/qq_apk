package androidx.compose.runtime.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.a.e;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/collection/MutableVector$SubList;", "T", "", "list", "start", "", "end", "(Ljava/util/List;II)V", "size", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e$b<T>
  implements List<T>, e
{
  private int end;
  private final List<T> list;
  private final int start;
  
  public e$b(List<T> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202059);
    this.list = paramList;
    this.start = paramInt1;
    this.end = paramInt2;
    AppMethodBeat.o(202059);
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(202172);
    this.list.add(this.start + paramInt, paramT);
    this.end += 1;
    AppMethodBeat.o(202172);
  }
  
  public final boolean add(T paramT)
  {
    AppMethodBeat.i(202159);
    List localList = this.list;
    int i = this.end;
    this.end = (i + 1);
    localList.add(i, paramT);
    AppMethodBeat.o(202159);
    return true;
  }
  
  public final boolean addAll(int paramInt, Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202180);
    s.u(paramCollection, "elements");
    this.list.addAll(this.start + paramInt, paramCollection);
    this.end += paramCollection.size();
    if (paramCollection.size() > 0)
    {
      AppMethodBeat.o(202180);
      return true;
    }
    AppMethodBeat.o(202180);
    return false;
  }
  
  public final boolean addAll(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202189);
    s.u(paramCollection, "elements");
    this.list.addAll(this.end, paramCollection);
    this.end += paramCollection.size();
    if (paramCollection.size() > 0)
    {
      AppMethodBeat.o(202189);
      return true;
    }
    AppMethodBeat.o(202189);
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202197);
    int i = this.end - 1;
    int j = this.start;
    if (j <= i) {}
    for (;;)
    {
      this.list.remove(i);
      if (i == j)
      {
        this.end = this.start;
        AppMethodBeat.o(202197);
        return;
      }
      i -= 1;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202071);
    int i = this.start;
    int k = this.end;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      if (s.p(this.list.get(i), paramObject))
      {
        AppMethodBeat.o(202071);
        return true;
      }
      if (j >= k)
      {
        AppMethodBeat.o(202071);
        return false;
      }
      i = j;
    }
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202088);
    s.u(paramCollection, "elements");
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      if (!contains(paramCollection.next()))
      {
        AppMethodBeat.o(202088);
        return false;
      }
    }
    AppMethodBeat.o(202088);
    return true;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(202098);
    Object localObject = this.list.get(this.start + paramInt);
    AppMethodBeat.o(202098);
    return localObject;
  }
  
  public final int indexOf(Object paramObject)
  {
    AppMethodBeat.i(202116);
    int i = this.start;
    int k = this.end;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      if (s.p(this.list.get(i), paramObject))
      {
        j = this.start;
        AppMethodBeat.o(202116);
        return i - j;
      }
      if (j >= k)
      {
        AppMethodBeat.o(202116);
        return -1;
      }
      i = j;
    }
  }
  
  public final boolean isEmpty()
  {
    return this.end == this.start;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(202138);
    Iterator localIterator = (Iterator)new e.c((List)this, 0);
    AppMethodBeat.o(202138);
    return localIterator;
  }
  
  public final int lastIndexOf(Object paramObject)
  {
    AppMethodBeat.i(202152);
    int i = this.end - 1;
    int j = this.start;
    if (j <= i) {}
    for (;;)
    {
      if (s.p(this.list.get(i), paramObject))
      {
        j = this.start;
        AppMethodBeat.o(202152);
        return i - j;
      }
      if (i == j)
      {
        AppMethodBeat.o(202152);
        return -1;
      }
      i -= 1;
    }
  }
  
  public final ListIterator<T> listIterator()
  {
    AppMethodBeat.i(202212);
    ListIterator localListIterator = (ListIterator)new e.c((List)this, 0);
    AppMethodBeat.o(202212);
    return localListIterator;
  }
  
  public final ListIterator<T> listIterator(int paramInt)
  {
    AppMethodBeat.i(202221);
    ListIterator localListIterator = (ListIterator)new e.c((List)this, paramInt);
    AppMethodBeat.o(202221);
    return localListIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202231);
    int i = this.start;
    int k = this.end;
    if (i < k) {}
    for (;;)
    {
      int j = i + 1;
      if (s.p(this.list.get(i), paramObject))
      {
        this.list.remove(i);
        this.end -= 1;
        AppMethodBeat.o(202231);
        return true;
      }
      if (j >= k)
      {
        AppMethodBeat.o(202231);
        return false;
      }
      i = j;
    }
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202241);
    s.u(paramCollection, "elements");
    int i = this.end;
    paramCollection = ((Iterable)paramCollection).iterator();
    while (paramCollection.hasNext()) {
      remove(paramCollection.next());
    }
    if (i != this.end)
    {
      AppMethodBeat.o(202241);
      return true;
    }
    AppMethodBeat.o(202241);
    return false;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202252);
    s.u(paramCollection, "elements");
    int j = this.end;
    int i = this.end - 1;
    int k = this.start;
    if (k <= i) {}
    for (;;)
    {
      if (!paramCollection.contains(this.list.get(i)))
      {
        this.list.remove(i);
        this.end -= 1;
      }
      if (i == k)
      {
        if (j != this.end)
        {
          AppMethodBeat.o(202252);
          return true;
        }
        AppMethodBeat.o(202252);
        return false;
      }
      i -= 1;
    }
  }
  
  public final T set(int paramInt, T paramT)
  {
    AppMethodBeat.i(202258);
    paramT = this.list.set(this.start + paramInt, paramT);
    AppMethodBeat.o(202258);
    return paramT;
  }
  
  public final List<T> subList(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202266);
    List localList = (List)new b((List)this, paramInt1, paramInt2);
    AppMethodBeat.o(202266);
    return localList;
  }
  
  public final Object[] toArray()
  {
    AppMethodBeat.i(202291);
    Object[] arrayOfObject = j.L((Collection)this);
    AppMethodBeat.o(202291);
    return arrayOfObject;
  }
  
  public final <T> T[] toArray(T[] paramArrayOfT)
  {
    AppMethodBeat.i(202286);
    s.u(paramArrayOfT, "array");
    paramArrayOfT = j.b((Collection)this, paramArrayOfT);
    AppMethodBeat.o(202286);
    return paramArrayOfT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.a.e.b
 * JD-Core Version:    0.7.0.1
 */