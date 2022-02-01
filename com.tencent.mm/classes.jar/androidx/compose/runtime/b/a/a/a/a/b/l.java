package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.d;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderValues;", "K", "V", "", "Lkotlin/collections/AbstractMutableCollection;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "clear", "", "contains", "iterator", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l<K, V>
  extends d<V>
  implements Collection<V>
{
  private final f<K, V> aqW;
  
  public l(f<K, V> paramf)
  {
    AppMethodBeat.i(202783);
    this.aqW = paramf;
    AppMethodBeat.o(202783);
  }
  
  public final boolean add(V paramV)
  {
    AppMethodBeat.i(202807);
    paramV = new UnsupportedOperationException();
    AppMethodBeat.o(202807);
    throw paramV;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202815);
    this.aqW.clear();
    AppMethodBeat.o(202815);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202799);
    boolean bool = this.aqW.containsValue(paramObject);
    AppMethodBeat.o(202799);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202792);
    int i = this.aqW.size();
    AppMethodBeat.o(202792);
    return i;
  }
  
  public final Iterator<V> iterator()
  {
    AppMethodBeat.i(202828);
    Iterator localIterator = (Iterator)new m(this.aqW);
    AppMethodBeat.o(202828);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.l
 * JD-Core Version:    0.7.0.1
 */