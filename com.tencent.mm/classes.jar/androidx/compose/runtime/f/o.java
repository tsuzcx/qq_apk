package androidx.compose.runtime.f;

import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.a.h;
import kotlin.g.b.j;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "K", "V", "E", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "size", "", "getSize", "()I", "clear", "", "isEmpty", "", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class o<K, V, E>
  implements Set<E>, h
{
  private final t<K, V> asV;
  
  public o(t<K, V> paramt)
  {
    this.asV = paramt;
  }
  
  public void clear()
  {
    this.asV.clear();
  }
  
  public boolean isEmpty()
  {
    return this.asV.isEmpty();
  }
  
  public final t<K, V> rK()
  {
    return this.asV;
  }
  
  public Object[] toArray()
  {
    return j.L((Collection)this);
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    s.u(paramArrayOfT, "array");
    return j.b((Collection)this, paramArrayOfT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.o
 * JD-Core Version:    0.7.0.1
 */