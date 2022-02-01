package androidx.compose.runtime.b.a.a.a.a.b;

import androidx.compose.runtime.b.a.a.a.b.a;
import androidx.compose.runtime.b.a.a.a.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "map", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "modCount", "", "getModCount$runtime_release", "()I", "setModCount$runtime_release", "(I)V", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime_release", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "getOperationResult$runtime_release", "()Ljava/lang/Object;", "setOperationResult$runtime_release", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "<set-?>", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "ownership", "getOwnership$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "value", "size", "getSize", "setSize", "values", "", "getValues", "()Ljava/util/Collection;", "build", "clear", "", "containsKey", "", "key", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f<K, V>
  extends kotlin.a.f<K, V>
  implements i.a<K, V>
{
  androidx.compose.runtime.b.a.a.a.b.d aqC;
  t<K, V> aqO;
  private d<K, V> aqT;
  V aqU;
  int aqV;
  private int size;
  
  public f(d<K, V> paramd)
  {
    AppMethodBeat.i(202806);
    this.aqT = paramd;
    this.aqC = new androidx.compose.runtime.b.a.a.a.b.d();
    this.aqO = this.aqT.aqO;
    this.size = this.aqT.size();
    AppMethodBeat.o(202806);
  }
  
  private d<K, V> qP()
  {
    AppMethodBeat.i(202813);
    if (this.aqO == this.aqT.aqO) {}
    for (d locald = this.aqT;; locald = new d(this.aqO, size()))
    {
      this.aqT = locald;
      locald = this.aqT;
      AppMethodBeat.o(202813);
      return locald;
      this.aqC = new androidx.compose.runtime.b.a.a.a.b.d();
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(202897);
    t.a locala = t.ara;
    this.aqO = t.qT();
    setSize(0);
    AppMethodBeat.o(202897);
  }
  
  public final boolean containsKey(Object paramObject)
  {
    AppMethodBeat.i(202853);
    t localt = this.aqO;
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0)
    {
      boolean bool = localt.b(i, paramObject, 0);
      AppMethodBeat.o(202853);
      return bool;
    }
  }
  
  public final V get(Object paramObject)
  {
    AppMethodBeat.i(202861);
    t localt = this.aqO;
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0)
    {
      paramObject = localt.c(i, paramObject, 0);
      AppMethodBeat.o(202861);
      return paramObject;
    }
  }
  
  public final int getSize()
  {
    return this.size;
  }
  
  public final V put(K paramK, V paramV)
  {
    AppMethodBeat.i(202870);
    this.aqU = null;
    t localt = this.aqO;
    if (paramK != null) {}
    for (int i = paramK.hashCode();; i = 0)
    {
      this.aqO = localt.a(i, paramK, paramV, 0, this);
      paramK = this.aqU;
      AppMethodBeat.o(202870);
      return paramK;
    }
  }
  
  public final void putAll(Map<? extends K, ? extends V> paramMap)
  {
    AppMethodBeat.i(202879);
    s.u(paramMap, "from");
    d locald;
    if ((paramMap instanceof d))
    {
      locald = (d)paramMap;
      localObject = locald;
      if (locald == null)
      {
        if (!(paramMap instanceof f)) {
          break label127;
        }
        localObject = (f)paramMap;
        label46:
        if (localObject != null) {
          break label133;
        }
      }
    }
    label133:
    for (Object localObject = null;; localObject = ((f)localObject).qP())
    {
      if (localObject == null) {
        break label143;
      }
      paramMap = new a((byte)0);
      int i = size();
      this.aqO = this.aqO.a(((d)localObject).aqO, 0, paramMap, this);
      int j = ((d)localObject).size() + i - paramMap.count;
      if (i == j) {
        break label148;
      }
      setSize(j);
      AppMethodBeat.o(202879);
      return;
      locald = null;
      break;
      label127:
      localObject = null;
      break label46;
    }
    label143:
    super.putAll(paramMap);
    label148:
    AppMethodBeat.o(202879);
  }
  
  public final Set<Map.Entry<K, V>> qH()
  {
    AppMethodBeat.i(202835);
    Set localSet = (Set)new h(this);
    AppMethodBeat.o(202835);
    return localSet;
  }
  
  public final Set<K> qI()
  {
    AppMethodBeat.i(202841);
    Set localSet = (Set)new j(this);
    AppMethodBeat.o(202841);
    return localSet;
  }
  
  public final Collection<V> qJ()
  {
    AppMethodBeat.i(202847);
    Collection localCollection = (Collection)new l(this);
    AppMethodBeat.o(202847);
    return localCollection;
  }
  
  public final V remove(Object paramObject)
  {
    AppMethodBeat.i(202883);
    this.aqU = null;
    t localt = this.aqO;
    if (paramObject != null) {}
    for (int i = paramObject.hashCode();; i = 0)
    {
      localt = localt.a(i, paramObject, 0, this);
      paramObject = localt;
      if (localt == null)
      {
        paramObject = t.ara;
        paramObject = t.qT();
      }
      this.aqO = paramObject;
      paramObject = this.aqU;
      AppMethodBeat.o(202883);
      return paramObject;
    }
  }
  
  public final boolean remove(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(202890);
    int j = size();
    t localt = this.aqO;
    if (paramObject1 != null) {}
    for (int i = paramObject1.hashCode();; i = 0)
    {
      paramObject2 = localt.b(i, paramObject1, paramObject2, 0, this);
      paramObject1 = paramObject2;
      if (paramObject2 == null)
      {
        paramObject1 = t.ara;
        paramObject1 = t.qT();
      }
      this.aqO = paramObject1;
      if (j == size()) {
        break;
      }
      AppMethodBeat.o(202890);
      return true;
    }
    AppMethodBeat.o(202890);
    return false;
  }
  
  public final void setSize(int paramInt)
  {
    this.size = paramInt;
    this.aqV += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.b.f
 * JD-Core Version:    0.7.0.1
 */