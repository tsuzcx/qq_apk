package androidx.compose.runtime.b.a.a.a.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSetIterator;", "E", "", "nextElement", "", "map", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "(Ljava/lang/Object;Ljava/util/Map;)V", "index", "", "getIndex$runtime_release", "()I", "setIndex$runtime_release", "(I)V", "getMap$runtime_release", "()Ljava/util/Map;", "checkHasNext", "", "hasNext", "", "next", "()Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<E>
  implements Iterator<E>, kotlin.g.b.a.a
{
  private Object arn;
  private int index;
  private final Map<E, a> map;
  
  public c(Object paramObject, Map<E, a> paramMap)
  {
    AppMethodBeat.i(202728);
    this.arn = paramObject;
    this.map = paramMap;
    AppMethodBeat.o(202728);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(202735);
    if (this.index < this.map.size())
    {
      AppMethodBeat.o(202735);
      return true;
    }
    AppMethodBeat.o(202735);
    return false;
  }
  
  public final E next()
  {
    AppMethodBeat.i(202743);
    if (!hasNext())
    {
      localObject1 = new NoSuchElementException();
      AppMethodBeat.o(202743);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = this.arn;
    this.index += 1;
    Object localObject2 = this.map.get(localObject1);
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentModificationException("Hash code of an element (" + localObject1 + ") has changed after it was added to the persistent set.");
      AppMethodBeat.o(202743);
      throw ((Throwable)localObject1);
    }
    this.arn = ((a)localObject2).arh;
    AppMethodBeat.o(202743);
    return localObject1;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(202748);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(202748);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.c.c
 * JD-Core Version:    0.7.0.1
 */