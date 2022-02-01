package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapEntries;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "Lkotlin/collections/AbstractSet;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "iterator", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n<K, V>
  extends h<Map.Entry<? extends K, ? extends V>>
  implements e<Map.Entry<? extends K, ? extends V>>
{
  private final d<K, V> aqT;
  
  public n(d<K, V> paramd)
  {
    AppMethodBeat.i(202761);
    this.aqT = paramd;
    AppMethodBeat.o(202761);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202779);
    if (!(paramObject instanceof Map.Entry))
    {
      AppMethodBeat.o(202779);
      return false;
    }
    Map.Entry localEntry = (Map.Entry)paramObject;
    s.u(localEntry, "element");
    paramObject = this.aqT.get(localEntry.getKey());
    if (paramObject == null) {
      paramObject = null;
    }
    while (paramObject == null) {
      if ((localEntry.getValue() == null) && (this.aqT.containsKey(localEntry.getKey())))
      {
        AppMethodBeat.o(202779);
        return true;
        paramObject = Boolean.valueOf(s.p(paramObject, localEntry.getValue()));
      }
      else
      {
        AppMethodBeat.o(202779);
        return false;
      }
    }
    boolean bool = paramObject.booleanValue();
    AppMethodBeat.o(202779);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202766);
    int i = this.aqT.size();
    AppMethodBeat.o(202766);
    return i;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(202771);
    Iterator localIterator = (Iterator)new o(this.aqT.aqO);
    AppMethodBeat.o(202771);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.n
 * JD-Core Version:    0.7.0.1
 */