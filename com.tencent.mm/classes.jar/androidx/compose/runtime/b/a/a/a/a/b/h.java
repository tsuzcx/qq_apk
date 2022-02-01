package androidx.compose.runtime.b.a.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilderEntries;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/AbstractMapBuilderEntries;", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)V", "size", "", "getSize", "()I", "add", "", "element", "clear", "", "containsEntry", "", "iterator", "", "removeEntry", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h<K, V>
  extends a<Map.Entry<K, V>, K, V>
{
  private final f<K, V> aqW;
  
  public h(f<K, V> paramf)
  {
    AppMethodBeat.i(202795);
    this.aqW = paramf;
    AppMethodBeat.o(202795);
  }
  
  public final boolean b(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(202822);
    s.u(paramEntry, "element");
    Object localObject = this.aqW.get(paramEntry.getKey());
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null) {
      if ((paramEntry.getValue() == null) && (this.aqW.containsKey(paramEntry.getKey())))
      {
        AppMethodBeat.o(202822);
        return true;
        localObject = Boolean.valueOf(s.p(localObject, paramEntry.getValue()));
      }
      else
      {
        AppMethodBeat.o(202822);
        return false;
      }
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(202822);
    return bool;
  }
  
  public final boolean c(Map.Entry<? extends K, ? extends V> paramEntry)
  {
    AppMethodBeat.i(202808);
    s.u(paramEntry, "element");
    boolean bool = this.aqW.remove(paramEntry.getKey(), paramEntry.getValue());
    AppMethodBeat.o(202808);
    return bool;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202797);
    this.aqW.clear();
    AppMethodBeat.o(202797);
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202812);
    int i = this.aqW.size();
    AppMethodBeat.o(202812);
    return i;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(202801);
    Iterator localIterator = (Iterator)new i(this.aqW);
    AppMethodBeat.o(202801);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.h
 * JD-Core Version:    0.7.0.1
 */