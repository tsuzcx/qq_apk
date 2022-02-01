package androidx.compose.runtime.b.a.a.a.a.b;

import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/AbstractMapBuilderEntries;", "E", "", "K", "V", "Lkotlin/collections/AbstractMutableSet;", "()V", "contains", "", "element", "(Ljava/util/Map$Entry;)Z", "containsEntry", "remove", "removeEntry", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<E extends Map.Entry<? extends K, ? extends V>, K, V>
  extends g<E>
{
  public abstract boolean b(Map.Entry<? extends K, ? extends V> paramEntry);
  
  public abstract boolean c(Map.Entry<? extends K, ? extends V> paramEntry);
  
  public final boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    Map.Entry localEntry = (Map.Entry)paramObject;
    s.u(localEntry, "element");
    if ((localEntry instanceof Object)) {}
    for (paramObject = localEntry; !(paramObject instanceof Map.Entry); paramObject = null) {
      return false;
    }
    return b(localEntry);
  }
  
  public final boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry)) {
      return false;
    }
    Map.Entry localEntry = (Map.Entry)paramObject;
    s.u(localEntry, "element");
    if ((localEntry instanceof Object)) {}
    for (paramObject = localEntry; !(paramObject instanceof Map.Entry); paramObject = null) {
      return false;
    }
    return c(localEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */