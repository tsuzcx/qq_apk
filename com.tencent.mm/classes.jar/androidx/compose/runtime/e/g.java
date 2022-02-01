package androidx.compose.runtime.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "performSave", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
final class g
  implements f
{
  private final b<Object, Boolean> asb;
  private final Map<String, List<Object>> asc;
  private final Map<String, List<a<Object>>> asd;
  
  public g(Map<String, ? extends List<? extends Object>> paramMap, b<Object, Boolean> paramb)
  {
    AppMethodBeat.i(202936);
    this.asb = paramb;
    if (paramMap == null) {}
    for (paramMap = null;; paramMap = ak.dw(paramMap))
    {
      paramb = paramMap;
      if (paramMap == null) {
        paramb = (Map)new LinkedHashMap();
      }
      this.asc = paramb;
      this.asd = ((Map)new LinkedHashMap());
      AppMethodBeat.o(202936);
      return;
    }
  }
  
  public final f.a a(final String paramString, final a<? extends Object> parama)
  {
    AppMethodBeat.i(202982);
    s.u(paramString, "key");
    s.u(parama, "valueProvider");
    if (!n.bp((CharSequence)paramString)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramString = (Throwable)new IllegalArgumentException("Registered key is empty or blank".toString());
      AppMethodBeat.o(202982);
      throw paramString;
    }
    Map localMap = this.asd;
    Object localObject2 = localMap.get(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = (List)new ArrayList();
      localMap.put(paramString, localObject1);
    }
    ((List)localObject1).add(parama);
    paramString = (f.a)new a(this, paramString, parama);
    AppMethodBeat.o(202982);
    return paramString;
  }
  
  public final boolean ah(Object paramObject)
  {
    AppMethodBeat.i(202957);
    s.u(paramObject, "value");
    boolean bool = ((Boolean)this.asb.invoke(paramObject)).booleanValue();
    AppMethodBeat.o(202957);
    return bool;
  }
  
  public final Object aj(String paramString)
  {
    AppMethodBeat.i(202968);
    s.u(paramString, "key");
    List localList = (List)this.asc.remove(paramString);
    if (localList != null)
    {
      if (!((Collection)localList).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        if (localList.size() > 1) {
          this.asc.put(paramString, localList.subList(1, localList.size()));
        }
        paramString = localList.get(0);
        AppMethodBeat.o(202968);
        return paramString;
      }
    }
    AppMethodBeat.o(202968);
    return null;
  }
  
  public final Map<String, List<Object>> rc()
  {
    AppMethodBeat.i(202998);
    Object localObject1 = ak.dw(this.asc);
    Iterator localIterator = this.asd.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject2).getKey();
      localObject2 = (List)((Map.Entry)localObject2).getValue();
      if (((List)localObject2).size() == 1)
      {
        localObject2 = ((a)((List)localObject2).get(0)).invoke();
        if (localObject2 != null)
        {
          if (!ah(localObject2))
          {
            localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(202998);
            throw ((Throwable)localObject1);
          }
          ((Map)localObject1).put(str, p.al(new Object[] { localObject2 }));
        }
      }
      else
      {
        int j = ((List)localObject2).size();
        ArrayList localArrayList = new ArrayList(j);
        int i = 0;
        while (i < j)
        {
          Object localObject3 = ((a)((List)localObject2).get(i)).invoke();
          if ((localObject3 != null) && (!ah(localObject3)))
          {
            localObject1 = (Throwable)new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(202998);
            throw ((Throwable)localObject1);
          }
          localArrayList.add(localObject3);
          i += 1;
        }
        ((Map)localObject1).put(str, (List)localArrayList);
      }
    }
    AppMethodBeat.o(202998);
    return localObject1;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/runtime/saveable/SaveableStateRegistryImpl$registerProvider$3", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "unregister", "", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements f.a
  {
    a(g paramg, String paramString, a<? extends Object> parama) {}
    
    public final void unregister()
    {
      AppMethodBeat.i(202989);
      List localList = (List)g.a(this.ase).remove(paramString);
      if (localList != null) {
        localList.remove(parama);
      }
      if (localList != null) {
        if (((Collection)localList).isEmpty()) {
          break label86;
        }
      }
      label86:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          g.a(this.ase).put(paramString, localList);
        }
        AppMethodBeat.o(202989);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.compose.runtime.e.g
 * JD-Core Version:    0.7.0.1
 */