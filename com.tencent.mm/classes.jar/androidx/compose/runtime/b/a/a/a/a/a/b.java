package androidx.compose.runtime.b.a.a.a.a.a;

import androidx.compose.runtime.b.a.a.a.h;
import androidx.compose.runtime.b.a.a.a.h.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/collections/AbstractList;", "()V", "addAll", "index", "", "c", "", "elements", "clear", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "listIterator", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "removeAll", "retainAll", "subList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "fromIndex", "toIndex", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<E>
  extends kotlin.a.b<E>
  implements h<E>
{
  public final h<E> Y(E paramE)
  {
    int i = indexOf(paramE);
    if (i != -1) {
      return cc(i);
    }
    return (h)this;
  }
  
  public boolean contains(Object paramObject)
  {
    return indexOf(paramObject) != -1;
  }
  
  public boolean containsAll(Collection<? extends Object> paramCollection)
  {
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains(paramCollection.next())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public Iterator<E> iterator()
  {
    return (Iterator)listIterator();
  }
  
  public ListIterator<E> listIterator()
  {
    return listIterator(0);
  }
  
  public h<E> n(Collection<? extends E> paramCollection)
  {
    s.u(paramCollection, "elements");
    h.a locala = ((h)this).qr();
    ((List)locala).addAll(paramCollection);
    return locala.qs();
  }
  
  public final h<E> o(Collection<? extends E> paramCollection)
  {
    s.u(paramCollection, "elements");
    return e((kotlin.g.a.b)new b.a(paramCollection));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */