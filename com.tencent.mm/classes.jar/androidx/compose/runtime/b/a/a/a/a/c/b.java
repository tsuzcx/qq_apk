package androidx.compose.runtime.b.a.a.a.a.c;

import TE;;
import androidx.compose.runtime.b.a.a.a.a.b.d;
import androidx.compose.runtime.b.a.a.a.a.b.d.a;
import androidx.compose.runtime.b.a.a.a.a.b.t;
import androidx.compose.runtime.b.a.a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.h;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/PersistentOrderedSet;", "E", "Lkotlin/collections/AbstractSet;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "firstElement", "", "lastElement", "hashMap", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/persistentOrderedSet/Links;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "getFirstElement$runtime_release", "()Ljava/lang/Object;", "getHashMap$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "getLastElement$runtime_release", "size", "", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "addAll", "elements", "", "builder", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet$Builder;", "clear", "contains", "", "(Ljava/lang/Object;)Z", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "retainAll", "Companion", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b<E>
  extends h<E>
  implements j<E>
{
  public static final b.a ari;
  private static final b arm;
  private final Object arj;
  private final Object ark;
  private final d<E, a> arl;
  
  static
  {
    AppMethodBeat.i(202752);
    ari = new b.a((byte)0);
    androidx.compose.runtime.b.a.a.a.b.b localb = androidx.compose.runtime.b.a.a.a.b.b.aro;
    d.a locala = d.aqN;
    arm = new b(localb, localb, d.qK());
    AppMethodBeat.o(202752);
  }
  
  private b(Object paramObject1, Object paramObject2, d<E, a> paramd)
  {
    AppMethodBeat.i(202741);
    this.arj = paramObject1;
    this.ark = paramObject2;
    this.arl = paramd;
    AppMethodBeat.o(202741);
  }
  
  public final j<E> Z(E paramE)
  {
    AppMethodBeat.i(202774);
    if (this.arl.containsKey(paramE))
    {
      paramE = (j)this;
      AppMethodBeat.o(202774);
      return paramE;
    }
    if (isEmpty())
    {
      paramE = (j)new b(paramE, paramE, this.arl.h(paramE, new a()));
      AppMethodBeat.o(202774);
      return paramE;
    }
    Object localObject1 = this.ark;
    Object localObject2 = this.arl.get(localObject1);
    s.checkNotNull(localObject2);
    localObject2 = (a)localObject2;
    localObject1 = this.arl.h(localObject1, ((a)localObject2).af(paramE)).h(paramE, new a(localObject1));
    paramE = (j)new b(this.arj, paramE, (d)localObject1);
    AppMethodBeat.o(202774);
    return paramE;
  }
  
  public final j<E> aa(E paramE)
  {
    AppMethodBeat.i(202784);
    Object localObject2 = (a)this.arl.get(paramE);
    if (localObject2 == null)
    {
      paramE = (j)this;
      AppMethodBeat.o(202784);
      return paramE;
    }
    Object localObject1 = this.arl;
    t localt = ((d)localObject1).aqO;
    int i;
    if (paramE != null)
    {
      i = paramE.hashCode();
      paramE = localt.d(i, paramE, 0);
      if (((d)localObject1).aqO != paramE) {
        break label243;
      }
      paramE = (TE)localObject1;
      label74:
      localObject1 = paramE;
      if (((a)localObject2).qZ())
      {
        localObject1 = ((Map)paramE).get(((a)localObject2).arg);
        s.checkNotNull(localObject1);
        localObject1 = (a)localObject1;
        localObject1 = paramE.h(((a)localObject2).arg, ((a)localObject1).af(((a)localObject2).arh));
      }
      paramE = (TE)localObject1;
      if (((a)localObject2).qY())
      {
        paramE = ((Map)localObject1).get(((a)localObject2).arh);
        s.checkNotNull(paramE);
        paramE = (a)paramE;
        paramE = ((d)localObject1).h(((a)localObject2).arh, new a(((a)localObject2).arg, paramE.arh));
      }
      if (((a)localObject2).qZ()) {
        break label272;
      }
      localObject1 = ((a)localObject2).arh;
      label201:
      if (((a)localObject2).qY()) {
        break label280;
      }
    }
    label272:
    label280:
    for (localObject2 = ((a)localObject2).arg;; localObject2 = this.ark)
    {
      paramE = (j)new b(localObject1, localObject2, paramE);
      AppMethodBeat.o(202784);
      return paramE;
      i = 0;
      break;
      label243:
      if (paramE == null)
      {
        paramE = d.qK();
        break label74;
      }
      paramE = new d(paramE, ((d)localObject1).size() - 1);
      break label74;
      localObject1 = this.arj;
      break label201;
    }
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202765);
    boolean bool = this.arl.containsKey(paramObject);
    AppMethodBeat.o(202765);
    return bool;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202759);
    int i = this.arl.size();
    AppMethodBeat.o(202759);
    return i;
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(202790);
    Iterator localIterator = (Iterator)new c(this.arj, (Map)this.arl);
    AppMethodBeat.o(202790);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.c.b
 * JD-Core Version:    0.7.0.1
 */