package androidx.compose.runtime.f;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "current", "getCurrent", "()Ljava/util/Map$Entry;", "setCurrent", "(Ljava/util/Map$Entry;)V", "getIterator", "()Ljava/util/Iterator;", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "modification", "", "getModification", "()I", "setModification", "(I)V", "next", "getNext", "setNext", "advance", "", "hasNext", "", "modify", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "remove", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract class x<K, V>
{
  final t<K, V> asV;
  int asY;
  private final Iterator<Map.Entry<K, V>> atq;
  Map.Entry<? extends K, ? extends V> atr;
  private Map.Entry<? extends K, ? extends V> ats;
  
  public x(t<K, V> paramt, Iterator<? extends Map.Entry<? extends K, ? extends V>> paramIterator)
  {
    this.asV = paramt;
    this.atq = paramIterator;
    this.asY = this.asV.rO().asY;
    rR();
  }
  
  public final boolean hasNext()
  {
    return this.ats != null;
  }
  
  protected final Map.Entry<K, V> rQ()
  {
    return this.ats;
  }
  
  protected final void rR()
  {
    this.atr = this.ats;
    if (this.atq.hasNext()) {}
    for (Map.Entry localEntry = (Map.Entry)this.atq.next();; localEntry = null)
    {
      this.ats = localEntry;
      return;
    }
  }
  
  public final void remove()
  {
    if (this.asV.rO().asY != this.asY) {
      throw new ConcurrentModificationException();
    }
    Object localObject = this.atr;
    if (localObject != null)
    {
      this.asV.remove(((Map.Entry)localObject).getKey());
      this.atr = null;
      localObject = ah.aiuX;
      this.asY = this.asV.rO().asY;
      return;
    }
    throw new IllegalStateException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.x
 * JD-Core Version:    0.7.0.1
 */