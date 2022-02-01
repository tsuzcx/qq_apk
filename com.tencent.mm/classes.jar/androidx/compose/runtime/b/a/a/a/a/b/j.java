package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.g;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderKeys;", "K", "V", "", "Lkotlin/collections/AbstractMutableSet;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)V", "size", "", "getSize", "()I", "add", "", "element", "(Ljava/lang/Object;)Z", "clear", "", "contains", "iterator", "", "remove", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j<K, V>
  extends g<K>
  implements Set<K>
{
  private final f<K, V> aqW;
  
  public j(f<K, V> paramf)
  {
    AppMethodBeat.i(202769);
    this.aqW = paramf;
    AppMethodBeat.o(202769);
  }
  
  public final boolean add(K paramK)
  {
    AppMethodBeat.i(202776);
    paramK = new UnsupportedOperationException();
    AppMethodBeat.o(202776);
    throw paramK;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202787);
    this.aqW.clear();
    AppMethodBeat.o(202787);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202809);
    boolean bool = this.aqW.containsKey(paramObject);
    AppMethodBeat.o(202809);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202803);
    int i = this.aqW.size();
    AppMethodBeat.o(202803);
    return i;
  }
  
  public final Iterator<K> iterator()
  {
    AppMethodBeat.i(202793);
    Iterator localIterator = (Iterator)new k(this.aqW);
    AppMethodBeat.o(202793);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202798);
    if (this.aqW.containsKey(paramObject))
    {
      this.aqW.remove(paramObject);
      AppMethodBeat.o(202798);
      return true;
    }
    AppMethodBeat.o(202798);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.j
 * JD-Core Version:    0.7.0.1
 */