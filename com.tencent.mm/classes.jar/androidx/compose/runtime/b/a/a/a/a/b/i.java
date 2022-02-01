package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.d;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "K", "V", "", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)V", "base", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderBaseIterator;", "hasNext", "", "next", "remove", "", "setValue", "key", "newValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i<K, V>
  implements Iterator<Map.Entry<K, V>>, d
{
  final g<K, V, Map.Entry<K, V>> aqZ;
  
  public i(f<K, V> paramf)
  {
    AppMethodBeat.i(202773);
    u[] arrayOfu = new u[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfu[i] = ((u)new y(this));
      i += 1;
    }
    this.aqZ = new g(paramf, arrayOfu);
    AppMethodBeat.o(202773);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(202780);
    boolean bool = this.aqZ.hasNext();
    AppMethodBeat.o(202780);
    return bool;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(202785);
    this.aqZ.remove();
    AppMethodBeat.o(202785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.i
 * JD-Core Version:    0.7.0.1
 */