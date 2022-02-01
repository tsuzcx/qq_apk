package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.g.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MutableMapEntry;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/MapEntry;", "", "parentIterator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;", "key", "value", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntriesIterator;Ljava/lang/Object;Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class c<K, V>
  extends b<K, V>
  implements Map.Entry<K, V>, g.a
{
  private final i<K, V> aqM;
  private V value;
  
  public c(i<K, V> parami, K paramK, V paramV)
  {
    super(paramK, paramV);
    AppMethodBeat.i(202805);
    this.aqM = parami;
    this.value = paramV;
    AppMethodBeat.o(202805);
  }
  
  public final V getValue()
  {
    return this.value;
  }
  
  public final V setValue(V paramV)
  {
    AppMethodBeat.i(202817);
    Object localObject1 = getValue();
    this.value = paramV;
    i locali = this.aqM;
    Object localObject2 = getKey();
    locali.aqZ.i(localObject2, paramV);
    AppMethodBeat.o(202817);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */