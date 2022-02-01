package androidx.compose.runtime;

import androidx.compose.runtime.b.a.a.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.f;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", "name", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "nodeKeyReplace", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "compositionLocalMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "getKey", "value", "left", "right", "invokeComposable", "composer", "Landroidx/compose/runtime/Composer;", "composable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)V", "invokeComposableForResult", "T", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "", "lazyMessage", "sourceInformation", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "asBool", "asInt", "cache", "invalid", "block", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contains", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "findLocation", "", "Landroidx/compose/runtime/Invalidation;", "location", "firstInRange", "start", "end", "getValueOf", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "mutate", "mutator", "Lkotlin/Function1;", "", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "CompositionLocalMap", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class j
{
  static final q<d<?>, bg, ay, ah> anc;
  static final q<d<?>, bg, ay, ah> ane;
  static final q<d<?>, bg, ay, ah> anf;
  static final Object ang;
  static final Object anh;
  static final Object ani;
  static final Object anj;
  static final Object ank;
  static final Object anl;
  
  static
  {
    AppMethodBeat.i(202399);
    anc = (q)b.ann;
    ane = (q)a.anm;
    anf = (q)c.ano;
    ang = new ap("provider");
    anh = new ap("provider");
    ani = new ap("compositionLocalMap");
    anj = new ap("providerValues");
    ank = new ap("providers");
    anl = new ap("reference");
    AppMethodBeat.o(202399);
  }
  
  private static final int a(bd parambd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202358);
    int j = 0;
    int i = paramInt1;
    paramInt1 = j;
    while ((i > 0) && (i != paramInt2))
    {
      i = parambd.bG(i);
      paramInt1 += 1;
    }
    AppMethodBeat.o(202358);
    return paramInt1;
  }
  
  static final int a(bd parambd, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(202367);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(202367);
      return paramInt1;
    }
    if ((paramInt1 == paramInt3) || (paramInt2 == paramInt3))
    {
      AppMethodBeat.o(202367);
      return paramInt3;
    }
    if (parambd.bG(paramInt1) == paramInt2)
    {
      AppMethodBeat.o(202367);
      return paramInt2;
    }
    if (parambd.bG(paramInt2) == paramInt1)
    {
      AppMethodBeat.o(202367);
      return paramInt1;
    }
    if (parambd.bG(paramInt1) == parambd.bG(paramInt2))
    {
      paramInt1 = parambd.bG(paramInt1);
      AppMethodBeat.o(202367);
      return paramInt1;
    }
    int k = a(parambd, paramInt1, paramInt3);
    int m = a(parambd, paramInt2, paramInt3);
    paramInt3 = 0;
    while (paramInt3 < k - m)
    {
      paramInt1 = parambd.bG(paramInt1);
      paramInt3 += 1;
    }
    paramInt3 = i;
    int j;
    for (;;)
    {
      i = paramInt2;
      j = paramInt1;
      if (paramInt3 >= m - k) {
        break;
      }
      paramInt2 = parambd.bG(paramInt2);
      paramInt3 += 1;
    }
    while (j != i)
    {
      j = parambd.bG(j);
      i = parambd.bG(i);
    }
    AppMethodBeat.o(202367);
    return j;
  }
  
  public static final void a(bg parambg, ay paramay)
  {
    AppMethodBeat.i(202325);
    s.u(parambg, "<this>");
    s.u(paramay, "rememberManager");
    Iterator localIterator = (Iterator)new bg.a(parambg.n(parambg.apB, parambg.bX(parambg.apF)), parambg.n(parambg.apB, parambg.bX(parambg.apF + parambg.bK(parambg.apF))), parambg);
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof az))
      {
        paramay.b((az)localObject);
      }
      else if ((localObject instanceof av))
      {
        n localn = ((av)localObject).aoI;
        if (localn != null)
        {
          localn.anx = true;
          ((av)localObject).aoI = null;
        }
      }
    }
    parambg.qc();
    AppMethodBeat.o(202325);
  }
  
  public static final <T> boolean a(i<p<Object>, ? extends bm<? extends Object>> parami, p<T> paramp)
  {
    AppMethodBeat.i(202305);
    s.u(parami, "<this>");
    s.u(paramp, "key");
    boolean bool = parami.containsKey(paramp);
    AppMethodBeat.o(202305);
    return bool;
  }
  
  public static final Void ah(String paramString)
  {
    AppMethodBeat.i(202376);
    s.u(paramString, "message");
    paramString = (Throwable)new IllegalStateException(("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + paramString + "). Please report to Google or use https://goo.gle/compose-feedback").toString());
    AppMethodBeat.o(202376);
    throw paramString;
  }
  
  public static final void ao(boolean paramBoolean)
  {
    AppMethodBeat.i(202373);
    if (!paramBoolean)
    {
      ah("Check failed".toString());
      f localf = new f();
      AppMethodBeat.o(202373);
      throw localf;
    }
    AppMethodBeat.o(202373);
  }
  
  static final ae b(List<ae> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202342);
    int i = e(paramList, paramInt1);
    paramInt1 = i;
    if (i < 0) {
      paramInt1 = -(i + 1);
    }
    if (paramInt1 < paramList.size())
    {
      paramList = (ae)paramList.get(paramInt1);
      if (paramList.location < paramInt2)
      {
        AppMethodBeat.o(202342);
        return paramList;
      }
    }
    AppMethodBeat.o(202342);
    return null;
  }
  
  public static final <T> T b(i<p<Object>, ? extends bm<? extends Object>> parami, p<T> paramp)
  {
    AppMethodBeat.i(202313);
    s.u(parami, "<this>");
    s.u(paramp, "key");
    parami = (bm)parami.get(paramp);
    if (parami == null)
    {
      AppMethodBeat.o(202313);
      return null;
    }
    parami = parami.getValue();
    AppMethodBeat.o(202313);
    return parami;
  }
  
  private static final void c(List<ae> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202354);
    paramInt1 = e(paramList, paramInt1);
    if (paramInt1 < 0) {
      paramInt1 = -(paramInt1 + 1);
    }
    while ((paramInt1 < paramList.size()) && (((ae)paramList.get(paramInt1)).location < paramInt2)) {
      paramList.remove(paramInt1);
    }
    AppMethodBeat.o(202354);
  }
  
  static final int e(List<ae> paramList, int paramInt)
  {
    AppMethodBeat.i(202332);
    int j = paramList.size() - 1;
    int i = 0;
    while (i <= j)
    {
      int k = i + j >>> 1;
      int m = s.compare(((ae)paramList.get(k)).location, paramInt);
      if (m < 0)
      {
        i = k + 1;
      }
      else if (m > 0)
      {
        j = k - 1;
      }
      else
      {
        AppMethodBeat.o(202332);
        return k;
      }
    }
    paramInt = -(i + 1);
    AppMethodBeat.o(202332);
    return paramInt;
  }
  
  static final ae f(List<ae> paramList, int paramInt)
  {
    AppMethodBeat.i(202348);
    paramInt = e(paramList, paramInt);
    if (paramInt >= 0)
    {
      paramList = (ae)paramList.remove(paramInt);
      AppMethodBeat.o(202348);
      return paramList;
    }
    AppMethodBeat.o(202348);
    return null;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<d<?>, bg, ay, ah>
  {
    public static final a anm;
    
    static
    {
      AppMethodBeat.i(202364);
      anm = new a();
      AppMethodBeat.o(202364);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements q<d<?>, bg, ay, ah>
  {
    public static final b ann;
    
    static
    {
      AppMethodBeat.i(202357);
      ann = new b();
      AppMethodBeat.o(202357);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "<anonymous parameter 2>", "Landroidx/compose/runtime/RememberManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<d<?>, bg, ay, ah>
  {
    public static final c ano;
    
    static
    {
      AppMethodBeat.i(202360);
      ano = new c();
      AppMethodBeat.o(202360);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.j
 * JD-Core Version:    0.7.0.1
 */