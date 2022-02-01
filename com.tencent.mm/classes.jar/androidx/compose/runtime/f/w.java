package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.d;
import kotlin.g.b.a.g.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/StateMapMutableEntriesIterator;", "K", "V", "Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "next", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class w<K, V>
  extends x<K, V>
  implements Iterator<Map.Entry<K, V>>, d
{
  public w(t<K, V> paramt, Iterator<? extends Map.Entry<? extends K, ? extends V>> paramIterator)
  {
    super(paramt, paramIterator);
    AppMethodBeat.i(202459);
    AppMethodBeat.o(202459);
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/snapshots/StateMapMutableEntriesIterator$next$1", "", "key", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Map.Entry<K, V>, g.a
  {
    private final K key;
    private V value;
    
    a(w<K, V> paramw)
    {
      AppMethodBeat.i(202675);
      paramw = this.atp.atr;
      s.checkNotNull(paramw);
      this.key = paramw.getKey();
      paramw = this.atp.atr;
      s.checkNotNull(paramw);
      this.value = paramw.getValue();
      AppMethodBeat.o(202675);
    }
    
    public final K getKey()
    {
      return this.key;
    }
    
    public final V getValue()
    {
      return this.value;
    }
    
    public final V setValue(V paramV)
    {
      AppMethodBeat.i(202700);
      Object localObject = (x)this.atp;
      w localw = this.atp;
      if (((x)localObject).asV.rO().asY != ((x)localObject).asY)
      {
        paramV = new ConcurrentModificationException();
        AppMethodBeat.o(202700);
        throw paramV;
      }
      localObject = getValue();
      ((Map)localw.asV).put(getKey(), paramV);
      this.value = paramV;
      AppMethodBeat.o(202700);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.w
 * JD-Core Version:    0.7.0.1
 */