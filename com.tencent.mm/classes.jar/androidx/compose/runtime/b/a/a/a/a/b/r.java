package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapValues;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "Lkotlin/collections/AbstractCollection;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r<K, V>
  extends a<V>
  implements b<V>
{
  private final d<K, V> aqT;
  
  public r(d<K, V> paramd)
  {
    AppMethodBeat.i(202746);
    this.aqT = paramd;
    AppMethodBeat.o(202746);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202762);
    boolean bool = this.aqT.containsValue(paramObject);
    AppMethodBeat.o(202762);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202754);
    int i = this.aqT.size();
    AppMethodBeat.o(202754);
    return i;
  }
  
  public final Iterator<V> iterator()
  {
    AppMethodBeat.i(202767);
    Iterator localIterator = (Iterator)new s(this.aqT.aqO);
    AppMethodBeat.o(202767);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.r
 * JD-Core Version:    0.7.0.1
 */