package a.a;

import a.f.b.j;
import a.l;
import a.o;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"INT_MAX_POWER_OF_TWO", "", "emptyMap", "", "K", "V", "hashMapOf", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/util/HashMap;", "linkedMapOf", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "([Lkotlin/Pair;)Ljava/util/LinkedHashMap;", "mapCapacity", "expectedSize", "mapOf", "([Lkotlin/Pair;)Ljava/util/Map;", "mutableMapOf", "", "component1", "", "(Ljava/util/Map$Entry;)Ljava/lang/Object;", "component2", "contains", "", "Lkotlin/internal/OnlyInputTypes;", "key", "(Ljava/util/Map;Ljava/lang/Object;)Z", "containsKey", "containsValue", "value", "filter", "predicate", "Lkotlin/Function1;", "filterKeys", "filterNot", "filterNotTo", "M", "destination", "(Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "filterTo", "filterValues", "get", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOrElseNullable", "getOrPut", "getValue", "ifEmpty", "R", "(Ljava/util/Map;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "iterator", "", "", "", "mutableIterator", "mapKeys", "transform", "mapKeysTo", "mapValues", "mapValuesTo", "minus", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/util/Map;", "keys", "(Ljava/util/Map;[Ljava/lang/Object;)Ljava/util/Map;", "", "Lkotlin/sequences/Sequence;", "minusAssign", "", "(Ljava/util/Map;Ljava/lang/Object;)V", "(Ljava/util/Map;[Ljava/lang/Object;)V", "optimizeReadOnlyMap", "orEmpty", "plus", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", "pair", "map", "plusAssign", "(Ljava/util/Map;[Lkotlin/Pair;)V", "putAll", "remove", "set", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)V", "toMap", "([Lkotlin/Pair;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;)Ljava/util/Map;", "(Ljava/util/Map;Ljava/util/Map;)Ljava/util/Map;", "(Lkotlin/sequences/Sequence;Ljava/util/Map;)Ljava/util/Map;", "toMutableMap", "toPair", "kotlin-stdlib"}, eaR=1)
public class ag
  extends af
{
  public static final int TQ(int paramInt)
  {
    if (paramInt < 3) {
      return paramInt + 1;
    }
    if (paramInt < 1073741824) {
      return paramInt / 3 + paramInt;
    }
    return 2147483647;
  }
  
  public static final <K, V, M extends Map<? super K, ? super V>> M a(Iterable<? extends o<? extends K, ? extends V>> paramIterable, M paramM)
  {
    AppMethodBeat.i(56064);
    j.q(paramIterable, "receiver$0");
    j.q(paramM, "destination");
    ad.a(paramM, paramIterable);
    AppMethodBeat.o(56064);
    return paramM;
  }
  
  public static final <K, V> Map<K, V> a(o<? extends K, ? extends V>... paramVarArgs)
  {
    AppMethodBeat.i(56060);
    j.q(paramVarArgs, "pairs");
    if (paramVarArgs.length > 0)
    {
      Map localMap = (Map)new LinkedHashMap(ad.TQ(paramVarArgs.length));
      j.q(paramVarArgs, "receiver$0");
      j.q(localMap, "destination");
      ad.a(localMap, paramVarArgs);
      AppMethodBeat.o(56060);
      return localMap;
    }
    paramVarArgs = ad.emptyMap();
    AppMethodBeat.o(56060);
    return paramVarArgs;
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, Iterable<? extends o<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(56062);
    j.q(paramMap, "receiver$0");
    j.q(paramIterable, "pairs");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      o localo = (o)paramIterable.next();
      paramMap.put(localo.first, localo.second);
    }
    AppMethodBeat.o(56062);
  }
  
  public static final <K, V> void a(Map<? super K, ? super V> paramMap, o<? extends K, ? extends V>[] paramArrayOfo)
  {
    AppMethodBeat.i(56061);
    j.q(paramMap, "receiver$0");
    j.q(paramArrayOfo, "pairs");
    int j = paramArrayOfo.length;
    int i = 0;
    while (i < j)
    {
      o<? extends K, ? extends V> localo = paramArrayOfo[i];
      paramMap.put(localo.first, localo.second);
      i += 1;
    }
    AppMethodBeat.o(56061);
  }
  
  public static final <K, V> Map<K, V> emptyMap()
  {
    AppMethodBeat.i(56059);
    Object localObject = w.BMy;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
      AppMethodBeat.o(56059);
      throw ((Throwable)localObject);
    }
    localObject = (Map)localObject;
    AppMethodBeat.o(56059);
    return localObject;
  }
  
  public static final <K, V> Map<K, V> w(Iterable<? extends o<? extends K, ? extends V>> paramIterable)
  {
    AppMethodBeat.i(56063);
    j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = ad.a(paramIterable, (Map)new LinkedHashMap(ad.TQ(((Collection)paramIterable).size())));
        AppMethodBeat.o(56063);
        return paramIterable;
      case 0: 
        paramIterable = ad.emptyMap();
        AppMethodBeat.o(56063);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = (o)((List)paramIterable).get(0);; paramIterable = (o)paramIterable.iterator().next())
      {
        paramIterable = ad.a(paramIterable);
        AppMethodBeat.o(56063);
        return paramIterable;
      }
    }
    paramIterable = ad.a(paramIterable, (Map)new LinkedHashMap());
    j.q(paramIterable, "receiver$0");
    switch (paramIterable.size())
    {
    default: 
      AppMethodBeat.o(56063);
      return paramIterable;
    case 0: 
      paramIterable = ad.emptyMap();
      AppMethodBeat.o(56063);
      return paramIterable;
    }
    j.q(paramIterable, "receiver$0");
    paramIterable = (Map.Entry)paramIterable.entrySet().iterator().next();
    paramIterable = Collections.singletonMap(paramIterable.getKey(), paramIterable.getValue());
    j.p(paramIterable, "java.util.Collections.singletonMap(key, value)");
    j.p(paramIterable, "with(entries.iterator().…ingletonMap(key, value) }");
    AppMethodBeat.o(56063);
    return paramIterable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.a.ag
 * JD-Core Version:    0.7.0.1
 */