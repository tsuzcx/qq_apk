package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.a.d;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/StateMapMutableValuesIterator;", "K", "V", "Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "next", "()Ljava/lang/Object;", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class z<K, V>
  extends x<K, V>
  implements Iterator<V>, d
{
  public z(t<K, V> paramt, Iterator<? extends Map.Entry<? extends K, ? extends V>> paramIterator)
  {
    super(paramt, paramIterator);
    AppMethodBeat.i(202454);
    AppMethodBeat.o(202454);
  }
  
  public final V next()
  {
    AppMethodBeat.i(202460);
    Object localObject = rQ();
    if (localObject == null)
    {
      localObject = new IllegalStateException();
      AppMethodBeat.o(202460);
      throw ((Throwable)localObject);
    }
    rR();
    localObject = ((Map.Entry)localObject).getValue();
    AppMethodBeat.o(202460);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.z
 * JD-Core Version:    0.7.0.1
 */