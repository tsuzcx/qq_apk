package androidx.compose.runtime.f;

import androidx.compose.runtime.b.a.a.a.a;
import androidx.compose.runtime.b.a.a.a.i;
import androidx.compose.runtime.b.a.a.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.a.g;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "", "Landroidx/compose/runtime/snapshots/StateObject;", "()V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "<set-?>", "Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "keys", "getKeys", "modification", "", "getModification$runtime_release", "()I", "readable", "Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "getReadable$runtime_release$annotations", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "size", "getSize", "values", "", "getValues", "()Ljava/util/Collection;", "all", "", "predicate", "Lkotlin/Function1;", "", "all$runtime_release", "any", "any$runtime_release", "clear", "", "containsKey", "key", "(Ljava/lang/Object;)Z", "containsValue", "value", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "mutate", "R", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "prependStateRecord", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "removeIf", "removeIf$runtime_release", "removeValue", "removeValue$runtime_release", "update", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "withCurrent", "Lkotlin/ExtensionFunctionType;", "writable", "StateMapStateRecord", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t<K, V>
  implements aa, Map<K, V>, g
{
  ab asW;
  private final Set<Map.Entry<K, V>> asZ;
  private final Set<K> ata;
  private final Collection<V> atb;
  
  public t()
  {
    AppMethodBeat.i(202518);
    this.asW = ((ab)new a(a.qq()));
    this.asZ = ((Set)new m(this));
    this.ata = ((Set)new n(this));
    this.atb = ((Collection)new p(this));
    AppMethodBeat.o(202518);
  }
  
  public final ab a(ab paramab1, ab paramab2, ab paramab3)
  {
    AppMethodBeat.i(202691);
    paramab1 = aa.a.a(this, paramab1, paramab2, paramab3);
    AppMethodBeat.o(202691);
    return paramab1;
  }
  
  public final void a(ab paramab)
  {
    AppMethodBeat.i(202541);
    s.u(paramab, "value");
    this.asW = ((ab)paramab);
    AppMethodBeat.o(202541);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202613);
    Object localObject1 = (ab)this.asW;
    ??? = h.asx;
    ??? = (a)l.a((ab)localObject1, l.rx());
    localObject1 = a.qq();
    Object localObject4;
    if (localObject1 != ((a)???).atc)
    {
      localObject4 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject5 = h.asx;
      localObject5 = l.rx();
      localObject4 = (a)l.b((ab)localObject4, (aa)this, (h)localObject5);
      ((a)localObject4).a((i)localObject1);
      ((a)localObject4).asY += 1;
      l.a((h)localObject5, (aa)this);
      AppMethodBeat.o(202613);
      return;
    }
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(202554);
    boolean bool = rO().atc.containsKey(paramObject);
    AppMethodBeat.o(202554);
    return bool;
  }
  
  public final boolean containsValue(Object paramObject)
  {
    AppMethodBeat.i(202567);
    boolean bool = rO().atc.containsValue(paramObject);
    AppMethodBeat.o(202567);
    return bool;
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(202582);
    paramObject = rO().atc.get(paramObject);
    AppMethodBeat.o(202582);
    return paramObject;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202597);
    boolean bool = rO().atc.isEmpty();
    AppMethodBeat.o(202597);
    return bool;
  }
  
  public final ab pp()
  {
    return this.asW;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(202637);
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    localObject2 = ((a)???).atc.qt();
    paramK = ((Map)localObject2).put(paramK, paramV);
    paramV = ((i.a)localObject2).qu();
    if (paramV != ((a)???).atc)
    {
      localObject2 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
      ((a)localObject2).a(paramV);
      ((a)localObject2).asY += 1;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(202637);
      return paramK;
    }
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(202650);
    s.u(paramMap, "from");
    ??? = (ab)this.asW;
    Object localObject2 = h.asx;
    ??? = (a)l.a((ab)???, l.rx());
    localObject2 = ((a)???).atc.qt();
    ((Map)localObject2).putAll(paramMap);
    paramMap = ah.aiuX;
    paramMap = ((i.a)localObject2).qu();
    if (paramMap != ((a)???).atc)
    {
      localObject2 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject3 = h.asx;
      localObject3 = l.rx();
      localObject2 = (a)l.b((ab)localObject2, (aa)this, (h)localObject3);
      ((a)localObject2).a(paramMap);
      ((a)localObject2).asY += 1;
      l.a((h)localObject3, (aa)this);
      AppMethodBeat.o(202650);
      return;
    }
  }
  
  public final a<K, V> rO()
  {
    AppMethodBeat.i(202679);
    a locala = (a)l.a((ab)this.asW, (aa)this);
    AppMethodBeat.o(202679);
    return locala;
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(202664);
    Object localObject1 = (ab)this.asW;
    ??? = h.asx;
    ??? = (a)l.a((ab)localObject1, l.rx());
    localObject1 = ((a)???).atc.qt();
    paramObject = ((Map)localObject1).remove(paramObject);
    localObject1 = ((i.a)localObject1).qu();
    Object localObject3;
    if (localObject1 != ((a)???).atc)
    {
      localObject3 = (ab)this.asW;
      l.rz();
    }
    synchronized (l.ry())
    {
      Object localObject4 = h.asx;
      localObject4 = l.rx();
      localObject3 = (a)l.b((ab)localObject3, (aa)this, (h)localObject4);
      ((a)localObject3).a((i)localObject1);
      ((a)localObject3).asY += 1;
      l.a((h)localObject4, (aa)this);
      AppMethodBeat.o(202664);
      return paramObject;
    }
  }
  
  public final int size()
  {
    AppMethodBeat.i(202701);
    int i = rO().atc.size();
    AppMethodBeat.o(202701);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/snapshots/SnapshotStateMap$StateMapStateRecord;", "K", "V", "Landroidx/compose/runtime/snapshots/StateRecord;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;)V", "getMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "setMap$runtime_release", "modification", "", "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "assign", "", "value", "create", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a<K, V>
    extends ab
  {
    int asY;
    i<K, ? extends V> atc;
    
    public a(i<K, ? extends V> parami)
    {
      AppMethodBeat.i(202570);
      this.atc = parami;
      AppMethodBeat.o(202570);
    }
    
    public final void a(i<K, ? extends V> parami)
    {
      AppMethodBeat.i(202577);
      s.u(parami, "<set-?>");
      this.atc = parami;
      AppMethodBeat.o(202577);
    }
    
    public final void b(ab paramab)
    {
      AppMethodBeat.i(202586);
      s.u(paramab, "value");
      paramab = (a)paramab;
      this.atc = paramab.atc;
      this.asY = paramab.asY;
      AppMethodBeat.o(202586);
    }
    
    public final ab ps()
    {
      AppMethodBeat.i(202598);
      ab localab = (ab)new a(this.atc);
      AppMethodBeat.o(202598);
      return localab;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.f.t
 * JD-Core Version:    0.7.0.1
 */