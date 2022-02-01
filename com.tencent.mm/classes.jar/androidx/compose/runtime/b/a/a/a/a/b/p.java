package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.h;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapKeys;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "Lkotlin/collections/AbstractSet;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p<K, V>
  extends h<K>
  implements e<K>
{
  private final d<K, V> aqT;
  
  public p(d<K, V> paramd)
  {
    AppMethodBeat.i(202764);
    this.aqT = paramd;
    AppMethodBeat.o(202764);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202781);
    boolean bool = this.aqT.containsKey(paramObject);
    AppMethodBeat.o(202781);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202770);
    int i = this.aqT.size();
    AppMethodBeat.o(202770);
    return i;
  }
  
  public final Iterator<K> iterator()
  {
    AppMethodBeat.i(202789);
    Iterator localIterator = (Iterator)new q(this.aqT.aqO);
    AppMethodBeat.o(202789);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.p
 * JD-Core Version:    0.7.0.1
 */