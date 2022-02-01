package androidx.compose.runtime.f;

import androidx.compose.runtime.b.a.a.a.e;
import androidx.compose.runtime.b.a.a.a.i;
import androidx.compose.runtime.b.a.a.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.r;
import kotlin.v;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotMapEntrySet;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotMapSet;", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;)V", "add", "", "element", "addAll", "elements", "", "contains", "", "containsAll", "iterator", "", "remove", "removeAll", "retainAll", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
final class m<K, V>
  extends o<K, V, Map.Entry<K, V>>
{
  public m(t<K, V> paramt)
  {
    super(paramt);
    AppMethodBeat.i(202501);
    AppMethodBeat.o(202501);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202616);
    if (!an.hL(paramObject))
    {
      AppMethodBeat.o(202616);
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    s.u(paramObject, "element");
    boolean bool = s.p(rK().get(paramObject.getKey()), paramObject.getValue());
    AppMethodBeat.o(202616);
    return bool;
  }
  
  public final boolean containsAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202561);
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    if (!((Collection)paramCollection).isEmpty())
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        if (!contains((Map.Entry)paramCollection.next()))
        {
          AppMethodBeat.o(202561);
          return false;
        }
      }
    }
    AppMethodBeat.o(202561);
    return true;
  }
  
  public final Iterator<Map.Entry<K, V>> iterator()
  {
    AppMethodBeat.i(202511);
    Iterator localIterator = (Iterator)new w(rK(), ((e)rK().rO().atc.entrySet()).iterator());
    AppMethodBeat.o(202511);
    return localIterator;
  }
  
  public final boolean remove(Object paramObject)
  {
    AppMethodBeat.i(202603);
    if (!an.hL(paramObject))
    {
      AppMethodBeat.o(202603);
      return false;
    }
    paramObject = (Map.Entry)paramObject;
    s.u(paramObject, "element");
    if (rK().remove(paramObject.getKey()) != null)
    {
      AppMethodBeat.o(202603);
      return true;
    }
    AppMethodBeat.o(202603);
    return false;
  }
  
  public final boolean removeAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202521);
    s.u(paramCollection, "elements");
    paramCollection = paramCollection.iterator();
    boolean bool = false;
    if (paramCollection.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramCollection.next();
      if ((rK().remove(localEntry.getKey()) != null) || (bool)) {}
      for (bool = true;; bool = false) {
        break;
      }
    }
    AppMethodBeat.o(202521);
    return bool;
  }
  
  public final boolean retainAll(Collection<? extends Object> paramCollection)
  {
    AppMethodBeat.i(202546);
    s.u(paramCollection, "elements");
    paramCollection = (Iterable)paramCollection;
    Object localObject1 = (Map)new LinkedHashMap(k.qu(ak.aKi(p.a(paramCollection, 10)), 16));
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      ??? = (Map.Entry)paramCollection.next();
      ??? = v.Y(((Map.Entry)???).getKey(), ((Map.Entry)???).getValue());
      ((Map)localObject1).put(((r)???).bsC, ((r)???).bsD);
    }
    paramCollection = rK();
    ??? = (ab)paramCollection.asW;
    Object localObject3 = h.asx;
    ??? = (t.a)l.a((ab)???, l.rx());
    localObject3 = ((t.a)???).atc.qt();
    Object localObject4 = (Map)localObject3;
    Iterator localIterator = paramCollection.entrySet().iterator();
    boolean bool = false;
    label271:
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((!((Map)localObject1).containsKey(localEntry.getKey())) || (!s.p(((Map)localObject1).get(localEntry.getKey()), localEntry.getValue()))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label271;
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
      AppMethodBeat.o(202546);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.m
 * JD-Core Version:    0.7.0.1
 */