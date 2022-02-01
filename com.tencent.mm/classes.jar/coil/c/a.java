package coil.c;

import TK;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.an;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcoil/collection/LinkedMultimap;", "K", "V", "", "()V", "entries", "Ljava/util/HashMap;", "Lcoil/collection/LinkedMultimap$LinkedEntry;", "Lkotlin/collections/HashMap;", "head", "insertEntry", "", "entry", "makeHead", "makeTail", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "removeEntry", "removeLast", "()Ljava/lang/Object;", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "LinkedEntry", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<K, V>
{
  private final a<K, V> cmc;
  private final HashMap<K, a<K, V>> cmd;
  
  public a()
  {
    AppMethodBeat.i(187773);
    this.cmc = new a(null);
    this.cmd = new HashMap();
    AppMethodBeat.o(187773);
  }
  
  private final void a(a<K, V> parama)
  {
    AppMethodBeat.i(187777);
    d(parama);
    parama.e(this.cmc);
    parama.f(this.cmc.cmf);
    c(parama);
    AppMethodBeat.o(187777);
  }
  
  private final void b(a<K, V> parama)
  {
    AppMethodBeat.i(187781);
    d(parama);
    parama.e(this.cmc.cme);
    parama.f(this.cmc);
    c(parama);
    AppMethodBeat.o(187781);
  }
  
  private static <K, V> void c(a<K, V> parama)
  {
    AppMethodBeat.i(187789);
    parama.cmf.e(parama);
    parama.cme.f(parama);
    AppMethodBeat.o(187789);
  }
  
  private static <K, V> void d(a<K, V> parama)
  {
    AppMethodBeat.i(187795);
    parama.cme.f(parama.cmf);
    parama.cmf.e(parama.cme);
    AppMethodBeat.o(187795);
  }
  
  public final V MJ()
  {
    AppMethodBeat.i(187815);
    for (Object localObject1 = this.cmc.cme; !s.p(localObject1, this.cmc); localObject1 = ((a)localObject1).cme)
    {
      Object localObject2 = ((a)localObject1).MJ();
      if (localObject2 != null)
      {
        AppMethodBeat.o(187815);
        return localObject2;
      }
      d((a)localObject1);
      localObject2 = (Map)this.cmd;
      Object localObject3 = ((a)localObject1).key;
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        AppMethodBeat.o(187815);
        throw ((Throwable)localObject1);
      }
      an.hJ(localObject2).remove(localObject3);
    }
    AppMethodBeat.o(187815);
    return null;
  }
  
  public final V aU(K paramK)
  {
    AppMethodBeat.i(187809);
    Map localMap = (Map)this.cmd;
    Object localObject = localMap.get(paramK);
    if (localObject == null)
    {
      localObject = new a(paramK);
      localMap.put(paramK, localObject);
    }
    for (paramK = (TK)localObject;; paramK = (TK)localObject)
    {
      paramK = (a)paramK;
      a(paramK);
      paramK = paramK.MJ();
      AppMethodBeat.o(187809);
      return paramK;
    }
  }
  
  public final void m(K paramK, V paramV)
  {
    AppMethodBeat.i(187799);
    Map localMap = (Map)this.cmd;
    Object localObject = localMap.get(paramK);
    if (localObject == null)
    {
      localObject = new a(paramK);
      b((a)localObject);
      localMap.put(paramK, localObject);
    }
    for (paramK = (TK)localObject;; paramK = (TK)localObject)
    {
      ((a)paramK).add(paramV);
      AppMethodBeat.o(187799);
      return;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187823);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LinkedMultimap( ");
    Object localObject1 = this.cmc.cmf;
    if (!s.p(localObject1, this.cmc))
    {
      localStringBuilder.append('{');
      localStringBuilder.append(((a)localObject1).key);
      localStringBuilder.append(':');
      Object localObject2 = ((a)localObject1).values;
      if (localObject2 == null) {}
      for (int i = 0;; i = ((List)localObject2).size())
      {
        localStringBuilder.append(i);
        localStringBuilder.append('}');
        localObject2 = ((a)localObject1).cmf;
        localObject1 = localObject2;
        if (s.p(localObject2, this.cmc)) {
          break;
        }
        localStringBuilder.append(", ");
        localObject1 = localObject2;
        break;
      }
    }
    localStringBuilder.append(" )");
    localObject1 = localStringBuilder.toString();
    s.s(localObject1, "StringBuilder().apply(builderAction).toString()");
    AppMethodBeat.o(187823);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"Lcoil/collection/LinkedMultimap$LinkedEntry;", "K", "V", "", "key", "(Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "next", "getNext", "()Lcoil/collection/LinkedMultimap$LinkedEntry;", "setNext", "(Lcoil/collection/LinkedMultimap$LinkedEntry;)V", "prev", "getPrev", "setPrev", "size", "", "getSize", "()I", "values", "", "add", "", "value", "removeLast", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a<K, V>
  {
    a<K, V> cme;
    a<K, V> cmf;
    final K key;
    List<V> values;
    
    public a(K paramK)
    {
      AppMethodBeat.i(187772);
      this.key = paramK;
      this.cme = this;
      this.cmf = this;
      AppMethodBeat.o(187772);
    }
    
    public final V MJ()
    {
      AppMethodBeat.i(187787);
      Object localObject = this.values;
      if (localObject == null)
      {
        AppMethodBeat.o(187787);
        return null;
      }
      localObject = p.oH((List)localObject);
      AppMethodBeat.o(187787);
      return localObject;
    }
    
    public final void add(V paramV)
    {
      AppMethodBeat.i(187793);
      List localList2 = this.values;
      List localList1 = localList2;
      if (localList2 == null)
      {
        localList1 = (List)new ArrayList();
        this.values = localList1;
      }
      ((Collection)localList1).add(paramV);
      AppMethodBeat.o(187793);
    }
    
    public final void e(a<K, V> parama)
    {
      AppMethodBeat.i(187776);
      s.u(parama, "<set-?>");
      this.cme = parama;
      AppMethodBeat.o(187776);
    }
    
    public final void f(a<K, V> parama)
    {
      AppMethodBeat.i(187779);
      s.u(parama, "<set-?>");
      this.cmf = parama;
      AppMethodBeat.o(187779);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.c.a
 * JD-Core Version:    0.7.0.1
 */