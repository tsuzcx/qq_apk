package androidx.compose.runtime.f;

import androidx.compose.runtime.b.a.a.a.i;
import androidx.compose.runtime.b.a.a.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapKeySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "(Ljava/lang/Object;)Ljava/lang/Void;", "addAll", "elements", "", "contains", "", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "Landroidx/compose/runtime/snapshots/StateMapMutableKeysIterator;", "remove", "removeAll", "retainAll", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class n<K, V>
  extends o<K, V, K>
{
  public n(t<K, V> paramt)
  {
    super(paramt);
    AppMethodBeat.i(202483);
    AppMethodBeat.o(202483);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202509);
    boolean bool = ((Map)rK()).containsKey(paramObject);
    AppMethodBeat.o(202509);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202519);
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        Object localObject = paramCollection.next();
        if (!((Map)rK()).containsKey(localObject))
        {
          AppMethodBeat.o(202519);
          return false;
        }
      }
    }
    AppMethodBeat.o(202519);
    return true;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202489);
    if (rK().remove(paramObject) != null)
    {
      AppMethodBeat.o(202489);
      return true;
    }
    AppMethodBeat.o(202489);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202495);
    s.u(paramCollection, "elements");
    paramCollection = ((Iterable)paramCollection).iterator();
    boolean bool = false;
    while (paramCollection.hasNext())
    {
      Object localObject = paramCollection.next();
      if ((rK().remove(localObject) != null) || (bool)) {
        bool = true;
      } else {
        bool = false;
      }
    }
    AppMethodBeat.o(202495);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202505);
    s.u(paramCollection, "elements");
    Object localObject1 = p.r((Iterable)paramCollection);
    paramCollection = rK();
    ??? = (ab)paramCollection.asW;
    Object localObject3 = h.asx;
    ??? = (t.a)l.a((ab)???, l.rx());
    localObject3 = ((t.a)???).atc.qt();
    Object localObject4 = (Map)localObject3;
    Iterator localIterator = paramCollection.entrySet().iterator();
    boolean bool = false;
    label155:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((Set)localObject1).contains(localEntry.getKey())) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label155;
        }
        ((Map)localObject4).remove(localEntry.getKey());
        bool = true;
        break;
      }
    }
    localObject1 = ah.aiuX;
    localObject1 = ((i.a)localObject3).qu();
    if (localObject1 != ((t.a)???).atc)
    {
      localObject3 = (ab)paramCollection.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      localObject4 = h.asx;
      localObject4 = l.rx();
      localObject3 = (t.a)l.b((ab)localObject3, (aa)paramCollection, (h)localObject4);
      ((t.a)localObject3).a((i)localObject1);
      ((t.a)localObject3).asY += 1;
      l.a((h)localObject4, (aa)paramCollection);
      AppMethodBeat.o(202505);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.n
 * JD-Core Version:    0.7.0.1
 */