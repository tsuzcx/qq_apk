package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.c;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "K", "V", "Lkotlin/collections/AbstractMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "size", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "entries", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "", "getEntries", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableSet;", "keys", "getKeys", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getSize", "()I", "values", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "getValues", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableCollection;", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "clear", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "createEntries", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "putAll", "m", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d<K, V>
  extends c<K, V>
  implements i<K, V>
{
  public static final d.a aqN;
  private static final d aqP;
  public final t<K, V> aqO;
  private final int size;
  
  static
  {
    AppMethodBeat.i(202844);
    aqN = new d.a((byte)0);
    t.a locala = t.ara;
    aqP = new d(t.qT(), 0);
    AppMethodBeat.o(202844);
  }
  
  public d(t<K, V> paramt, int paramInt)
  {
    AppMethodBeat.i(202825);
    this.aqO = paramt;
    this.size = paramInt;
    AppMethodBeat.o(202825);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(202878);
    t localt = this.aqO;
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0)
    {
      boolean bool = localt.b(i, paramObject, 0);
      AppMethodBeat.o(202878);
      return bool;
    }
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(202886);
    t localt = this.aqO;
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0)
    {
      paramObject = localt.c(i, paramObject, 0);
      AppMethodBeat.o(202886);
      return paramObject;
    }
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final d<K, V> h(K paramK, V paramV)
  {
    AppMethodBeat.i(202896);
    t localt = this.aqO;
    if (paramK != null) {}
    for (int i = paramK.hashCode();; i = 0)
    {
      paramK = localt.a(i, paramK, paramV, 0);
      if (paramK != null) {
        break;
      }
      AppMethodBeat.o(202896);
      return this;
    }
    paramV = paramK.aqO;
    i = size();
    paramK = new d(paramV, paramK.arf + i);
    AppMethodBeat.o(202896);
    return paramK;
  }
  
  public final Set<Map.Entry<K, V>> qH()
  {
    AppMethodBeat.i(202865);
    Set localSet = (Set)new n(this);
    AppMethodBeat.o(202865);
    return localSet;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.d
 * JD-Core Version:    0.7.0.1
 */