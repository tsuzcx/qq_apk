package a.a;

import a.f.a.a;
import a.f.a.b;
import a.i.e;
import a.k.h;
import a.l;
import a.l.m;
import a.o;
import a.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"all", "", "T", "", "predicate", "Lkotlin/Function1;", "any", "asIterable", "asSequence", "Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "associateByTo", "M", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "(Ljava/lang/Iterable;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "average", "", "", "averageOfByte", "averageOfDouble", "", "averageOfFloat", "", "averageOfInt", "", "averageOfLong", "", "averageOfShort", "chunked", "", "size", "R", "component1", "(Ljava/util/List;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "(Ljava/lang/Iterable;Ljava/lang/Object;)Z", "count", "", "distinct", "distinctBy", "selector", "drop", "n", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "(Ljava/lang/Iterable;I)Ljava/lang/Object;", "(Ljava/util/List;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Ljava/lang/Iterable;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "filterIndexedTo", "C", "", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "(Ljava/lang/Iterable;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "(Ljava/lang/Iterable;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "findLast", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "first", "(Ljava/lang/Iterable;)Ljava/lang/Object;", "firstOrNull", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "(Ljava/lang/Iterable;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldRightIndexed", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "forEach", "", "action", "forEachIndexed", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "indexOf", "(Ljava/lang/Iterable;Ljava/lang/Object;)I", "(Ljava/util/List;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "(Ljava/lang/Iterable;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "minus", "(Ljava/lang/Iterable;Ljava/lang/Object;)Ljava/util/List;", "elements", "", "(Ljava/lang/Iterable;[Ljava/lang/Object;)Ljava/util/List;", "minusElement", "none", "onEach", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Iterable;", "partition", "plus", "(Ljava/util/Collection;Ljava/lang/Object;)Ljava/util/List;", "(Ljava/util/Collection;[Ljava/lang/Object;)Ljava/util/List;", "plusElement", "random", "(Ljava/util/Collection;)Ljava/lang/Object;", "Lkotlin/random/Random;", "(Ljava/util/Collection;Lkotlin/random/Random;)Ljava/lang/Object;", "reduce", "S", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceRight", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceRightIndexed", "(Ljava/util/List;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "requireNoNulls", "reversed", "single", "singleOrNull", "slice", "indices", "Lkotlin/ranges/IntRange;", "sortBy", "sortByDescending", "sortDescending", "sorted", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "subtract", "sum", "sumOfByte", "sumOfDouble", "sumOfFloat", "sumOfInt", "sumOfLong", "sumOfShort", "sumBy", "sumByDouble", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "", "toByteArray", "", "toCharArray", "", "", "toCollection", "toDoubleArray", "", "toFloatArray", "", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "toIntArray", "", "toList", "toLongArray", "", "toMutableList", "toMutableSet", "", "toSet", "toShortArray", "", "union", "windowed", "step", "partialWindows", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "a", "b", "(Ljava/lang/Iterable;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "zipWithNext", "kotlin-stdlib"}, eaR=1)
public class t
  extends s
{
  public static final <T, A extends Appendable> A a(Iterable<? extends T> paramIterable, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(56112);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramA, "buffer");
    a.f.b.j.q(paramCharSequence1, "separator");
    a.f.b.j.q(paramCharSequence2, "prefix");
    a.f.b.j.q(paramCharSequence3, "postfix");
    a.f.b.j.q(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int i = 0;
    paramIterable = paramIterable.iterator();
    int j;
    for (;;)
    {
      j = i;
      if (!paramIterable.hasNext()) {
        break;
      }
      paramCharSequence2 = paramIterable.next();
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        j = i;
        if (i > paramInt) {
          break;
        }
      }
      m.a(paramA, paramCharSequence2, paramb);
    }
    if ((paramInt >= 0) && (j > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(56112);
    return paramA;
  }
  
  public static final <T> String a(Iterable<? extends T> paramIterable, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(56114);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramCharSequence1, "separator");
    a.f.b.j.q(paramCharSequence2, "prefix");
    a.f.b.j.q(paramCharSequence3, "postfix");
    a.f.b.j.q(paramCharSequence4, "truncated");
    paramIterable = ((StringBuilder)j.a(paramIterable, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    a.f.b.j.p(paramIterable, "joinTo(StringBuilder(), …ed, transform).toString()");
    AppMethodBeat.o(56114);
    return paramIterable;
  }
  
  public static final <C extends Collection<? super T>, T> C a(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(56092);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (localObject != null) {
        paramC.add(localObject);
      }
    }
    AppMethodBeat.o(56092);
    return paramC;
  }
  
  public static final <T> List<T> a(Iterable<? extends T> paramIterable, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(56093);
    a.f.b.j.q(paramIterable, "receiver$0");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramIterable = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(56093);
      throw paramIterable;
    }
    if (paramInt == 0)
    {
      paramIterable = (List)v.BMx;
      AppMethodBeat.o(56093);
      return paramIterable;
    }
    if ((paramIterable instanceof Collection))
    {
      if (paramInt >= ((Collection)paramIterable).size())
      {
        paramIterable = j.m(paramIterable);
        AppMethodBeat.o(56093);
        return paramIterable;
      }
      if (paramInt == 1)
      {
        paramIterable = j.listOf(j.e(paramIterable));
        AppMethodBeat.o(56093);
        return paramIterable;
      }
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    paramIterable = paramIterable.iterator();
    i = j;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i == paramInt) {
        break;
      }
      localArrayList.add(localObject);
      i += 1;
    }
    paramIterable = j.fP((List)localArrayList);
    AppMethodBeat.o(56093);
    return paramIterable;
  }
  
  public static final <T, R> List<o<T, R>> a(Iterable<? extends T> paramIterable, Iterable<? extends R> paramIterable1)
  {
    AppMethodBeat.i(56111);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramIterable1, "other");
    Iterator localIterator1 = paramIterable.iterator();
    Iterator localIterator2 = paramIterable1.iterator();
    paramIterable = new ArrayList(Math.min(j.d(paramIterable), j.d(paramIterable1)));
    while ((localIterator1.hasNext()) && (localIterator2.hasNext())) {
      paramIterable.add(u.F(localIterator1.next(), localIterator2.next()));
    }
    paramIterable = (List)paramIterable;
    AppMethodBeat.o(56111);
    return paramIterable;
  }
  
  public static final <T> List<T> a(Collection<? extends T> paramCollection, T paramT)
  {
    AppMethodBeat.i(56109);
    a.f.b.j.q(paramCollection, "receiver$0");
    ArrayList localArrayList = new ArrayList(paramCollection.size() + 1);
    localArrayList.addAll(paramCollection);
    localArrayList.add(paramT);
    paramCollection = (List)localArrayList;
    AppMethodBeat.o(56109);
    return paramCollection;
  }
  
  public static final <T> boolean a(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(56074);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      boolean bool = ((Collection)paramIterable).contains(paramT);
      AppMethodBeat.o(56074);
      return bool;
    }
    if (j.b(paramIterable, paramT) >= 0)
    {
      AppMethodBeat.o(56074);
      return true;
    }
    AppMethodBeat.o(56074);
    return false;
  }
  
  public static final <T> int b(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(56080);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      i = ((List)paramIterable).indexOf(paramT);
      AppMethodBeat.o(56080);
      return i;
    }
    int i = 0;
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (i < 0) {
        j.eaS();
      }
      if (a.f.b.j.e(paramT, localObject))
      {
        AppMethodBeat.o(56080);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(56080);
    return -1;
  }
  
  public static final <T, C extends Collection<? super T>> C b(Iterable<? extends T> paramIterable, C paramC)
  {
    AppMethodBeat.i(56097);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramC, "destination");
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      paramC.add(paramIterable.next());
    }
    AppMethodBeat.o(56097);
    return paramC;
  }
  
  public static final <T> List<T> b(Iterable<? extends T> paramIterable, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(56090);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramb, "predicate");
    Collection localCollection = (Collection)new ArrayList();
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (((Boolean)paramb.S(localObject)).booleanValue()) {
        localCollection.add(localObject);
      }
    }
    paramIterable = (List)localCollection;
    AppMethodBeat.o(56090);
    return paramIterable;
  }
  
  public static final <T> List<T> b(Collection<? extends T> paramCollection, Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56110);
    a.f.b.j.q(paramCollection, "receiver$0");
    a.f.b.j.q(paramIterable, "elements");
    if ((paramIterable instanceof Collection))
    {
      int i = paramCollection.size();
      ArrayList localArrayList = new ArrayList(((Collection)paramIterable).size() + i);
      localArrayList.addAll(paramCollection);
      localArrayList.addAll((Collection)paramIterable);
      paramCollection = (List)localArrayList;
      AppMethodBeat.o(56110);
      return paramCollection;
    }
    paramCollection = new ArrayList(paramCollection);
    j.a((Collection)paramCollection, paramIterable);
    paramCollection = (List)paramCollection;
    AppMethodBeat.o(56110);
    return paramCollection;
  }
  
  public static final <T, R> List<R> c(Iterable<? extends T> paramIterable, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(56102);
    a.f.b.j.q(paramIterable, "receiver$0");
    a.f.b.j.q(paramb, "transform");
    Collection localCollection = (Collection)new ArrayList(j.d(paramIterable));
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext()) {
      localCollection.add(paramb.S(paramIterable.next()));
    }
    paramIterable = (List)localCollection;
    AppMethodBeat.o(56102);
    return paramIterable;
  }
  
  public static final <T> List<T> c(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(56107);
    a.f.b.j.q(paramIterable, "receiver$0");
    ArrayList localArrayList = new ArrayList(j.d(paramIterable));
    paramIterable = paramIterable.iterator();
    int i = 0;
    label111:
    for (;;)
    {
      if (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        int j;
        if ((i == 0) && (a.f.b.j.e(localObject, paramT)))
        {
          j = 0;
          i = 1;
        }
        for (;;)
        {
          if (j == 0) {
            break label111;
          }
          ((Collection)localArrayList).add(localObject);
          break;
          j = 1;
        }
      }
      paramIterable = (List)localArrayList;
      AppMethodBeat.o(56107);
      return paramIterable;
    }
  }
  
  public static final <T> List<T> d(Iterable<? extends T> paramIterable, T paramT)
  {
    AppMethodBeat.i(56108);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = j.a((Collection)paramIterable, paramT);
      AppMethodBeat.o(56108);
      return paramIterable;
    }
    ArrayList localArrayList = new ArrayList();
    j.a((Collection)localArrayList, paramIterable);
    localArrayList.add(paramT);
    paramIterable = (List)localArrayList;
    AppMethodBeat.o(56108);
    return paramIterable;
  }
  
  public static final <T> T e(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56075);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.fQ((List)paramIterable);
      AppMethodBeat.o(56075);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(56075);
      throw paramIterable;
    }
    paramIterable = paramIterable.next();
    AppMethodBeat.o(56075);
    return paramIterable;
  }
  
  public static final <T> T f(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56077);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).isEmpty())
      {
        AppMethodBeat.o(56077);
        return null;
      }
      paramIterable = ((List)paramIterable).get(0);
      AppMethodBeat.o(56077);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(56077);
      return null;
    }
    paramIterable = paramIterable.next();
    AppMethodBeat.o(56077);
    return paramIterable;
  }
  
  public static final int[] f(Collection<Integer> paramCollection)
  {
    AppMethodBeat.i(56096);
    a.f.b.j.q(paramCollection, "receiver$0");
    int[] arrayOfInt = new int[paramCollection.size()];
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      arrayOfInt[i] = ((Number)paramCollection.next()).intValue();
      i += 1;
    }
    AppMethodBeat.o(56096);
    return arrayOfInt;
  }
  
  public static final <T> T fQ(List<? extends T> paramList)
  {
    AppMethodBeat.i(56076);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramList.isEmpty())
    {
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(56076);
      throw paramList;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(56076);
    return paramList;
  }
  
  public static final <T> T fR(List<? extends T> paramList)
  {
    AppMethodBeat.i(56078);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(56078);
      return null;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(56078);
    return paramList;
  }
  
  public static final <T> T fS(List<? extends T> paramList)
  {
    AppMethodBeat.i(56082);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramList.isEmpty())
    {
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(56082);
      throw paramList;
    }
    paramList = paramList.get(j.fO(paramList));
    AppMethodBeat.o(56082);
    return paramList;
  }
  
  public static final <T> T fT(List<? extends T> paramList)
  {
    AppMethodBeat.i(56083);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(56083);
      return null;
    }
    paramList = paramList.get(paramList.size() - 1);
    AppMethodBeat.o(56083);
    return paramList;
  }
  
  public static final <T> T fU(List<? extends T> paramList)
  {
    AppMethodBeat.i(56085);
    a.f.b.j.q(paramList, "receiver$0");
    switch (paramList.size())
    {
    default: 
      paramList = (Throwable)new IllegalArgumentException("List has more than one element.");
      AppMethodBeat.o(56085);
      throw paramList;
    case 0: 
      paramList = (Throwable)new NoSuchElementException("List is empty.");
      AppMethodBeat.o(56085);
      throw paramList;
    }
    paramList = paramList.get(0);
    AppMethodBeat.o(56085);
    return paramList;
  }
  
  public static final <T> T fV(List<? extends T> paramList)
  {
    AppMethodBeat.i(56087);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramList.size() == 1)
    {
      paramList = paramList.get(0);
      AppMethodBeat.o(56087);
      return paramList;
    }
    AppMethodBeat.o(56087);
    return null;
  }
  
  public static final <T> List<T> fW(List<? extends T> paramList)
  {
    AppMethodBeat.i(56089);
    a.f.b.j.q(paramList, "receiver$0");
    paramList = j.a((Iterable)paramList, e.iE(paramList.size() - 1, 0));
    AppMethodBeat.o(56089);
    return paramList;
  }
  
  public static final <T> T g(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56081);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.fS((List)paramIterable);
      AppMethodBeat.o(56081);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(56081);
      throw paramIterable;
    }
    Object localObject;
    do
    {
      localObject = paramIterable.next();
    } while (paramIterable.hasNext());
    AppMethodBeat.o(56081);
    return localObject;
  }
  
  public static final <T> List<T> g(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(56100);
    a.f.b.j.q(paramCollection, "receiver$0");
    paramCollection = (List)new ArrayList(paramCollection);
    AppMethodBeat.o(56100);
    return paramCollection;
  }
  
  public static final <T> T h(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56084);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      paramIterable = j.fU((List)paramIterable);
      AppMethodBeat.o(56084);
      return paramIterable;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      paramIterable = (Throwable)new NoSuchElementException("Collection is empty.");
      AppMethodBeat.o(56084);
      throw paramIterable;
    }
    Object localObject = paramIterable.next();
    if (paramIterable.hasNext())
    {
      paramIterable = (Throwable)new IllegalArgumentException("Collection has more than one element.");
      AppMethodBeat.o(56084);
      throw paramIterable;
    }
    AppMethodBeat.o(56084);
    return localObject;
  }
  
  public static final <T> T i(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56086);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof List))
    {
      if (((List)paramIterable).size() == 1)
      {
        paramIterable = ((List)paramIterable).get(0);
        AppMethodBeat.o(56086);
        return paramIterable;
      }
      AppMethodBeat.o(56086);
      return null;
    }
    paramIterable = paramIterable.iterator();
    if (!paramIterable.hasNext())
    {
      AppMethodBeat.o(56086);
      return null;
    }
    Object localObject = paramIterable.next();
    if (paramIterable.hasNext())
    {
      AppMethodBeat.o(56086);
      return null;
    }
    AppMethodBeat.o(56086);
    return localObject;
  }
  
  public static final <T> List<T> j(Iterable<? extends T> paramIterable)
  {
    int i = 1;
    AppMethodBeat.i(56088);
    a.f.b.j.q(paramIterable, "receiver$0");
    ArrayList localArrayList;
    if ((paramIterable instanceof Collection))
    {
      int j = ((Collection)paramIterable).size() - 1;
      if (j <= 0)
      {
        paramIterable = (List)v.BMx;
        AppMethodBeat.o(56088);
        return paramIterable;
      }
      if (j == 1)
      {
        paramIterable = j.listOf(j.g(paramIterable));
        AppMethodBeat.o(56088);
        return paramIterable;
      }
      localArrayList = new ArrayList(j);
      if ((paramIterable instanceof List))
      {
        if ((paramIterable instanceof RandomAccess))
        {
          j = ((Collection)paramIterable).size();
          while (i < j)
          {
            localArrayList.add(((List)paramIterable).get(i));
            i += 1;
          }
        }
        paramIterable = (Iterator)((List)paramIterable).listIterator(1);
        while (paramIterable.hasNext()) {
          localArrayList.add(paramIterable.next());
        }
        paramIterable = (List)localArrayList;
        AppMethodBeat.o(56088);
        return paramIterable;
      }
    }
    else
    {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      i = 0;
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        if (i > 0) {
          localArrayList.add(localObject);
        }
        i += 1;
      }
      paramIterable = j.fP((List)localArrayList);
      AppMethodBeat.o(56088);
      return paramIterable;
    }
  }
  
  public static final <T> List<T> k(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56091);
    a.f.b.j.q(paramIterable, "receiver$0");
    paramIterable = (List)j.a(paramIterable, (Collection)new ArrayList());
    AppMethodBeat.o(56091);
    return paramIterable;
  }
  
  public static final <T> List<T> l(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56095);
    a.f.b.j.q(paramIterable, "receiver$0");
    if (((paramIterable instanceof Collection)) && (((Collection)paramIterable).size() <= 1))
    {
      paramIterable = j.m(paramIterable);
      AppMethodBeat.o(56095);
      return paramIterable;
    }
    paramIterable = j.n(paramIterable);
    j.reverse(paramIterable);
    AppMethodBeat.o(56095);
    return paramIterable;
  }
  
  public static final <T> List<T> m(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56098);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = j.g((Collection)paramIterable);
        AppMethodBeat.o(56098);
        return paramIterable;
      case 0: 
        paramIterable = (List)v.BMx;
        AppMethodBeat.o(56098);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = j.listOf(paramIterable);
        AppMethodBeat.o(56098);
        return paramIterable;
      }
    }
    paramIterable = j.fP(j.n(paramIterable));
    AppMethodBeat.o(56098);
    return paramIterable;
  }
  
  public static final <T> List<T> n(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56099);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = j.g((Collection)paramIterable);
      AppMethodBeat.o(56099);
      return paramIterable;
    }
    paramIterable = (List)j.b(paramIterable, (Collection)new ArrayList());
    AppMethodBeat.o(56099);
    return paramIterable;
  }
  
  public static final <T> Set<T> o(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56101);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      switch (((Collection)paramIterable).size())
      {
      default: 
        paramIterable = (Set)j.b(paramIterable, (Collection)new LinkedHashSet(ad.TQ(((Collection)paramIterable).size())));
        AppMethodBeat.o(56101);
        return paramIterable;
      case 0: 
        paramIterable = (Set)x.BMz;
        AppMethodBeat.o(56101);
        return paramIterable;
      }
      if ((paramIterable instanceof List)) {}
      for (paramIterable = ((List)paramIterable).get(0);; paramIterable = paramIterable.iterator().next())
      {
        paramIterable = aj.setOf(paramIterable);
        AppMethodBeat.o(56101);
        return paramIterable;
      }
    }
    paramIterable = (Set)j.b(paramIterable, (Collection)new LinkedHashSet());
    a.f.b.j.q(paramIterable, "receiver$0");
    switch (paramIterable.size())
    {
    default: 
      AppMethodBeat.o(56101);
      return paramIterable;
    case 0: 
      paramIterable = (Set)x.BMz;
      AppMethodBeat.o(56101);
      return paramIterable;
    }
    paramIterable = aj.setOf(paramIterable.iterator().next());
    AppMethodBeat.o(56101);
    return paramIterable;
  }
  
  public static final <T> Iterable<y<T>> p(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56103);
    a.f.b.j.q(paramIterable, "receiver$0");
    paramIterable = (Iterable)new z((a)new t.c(paramIterable));
    AppMethodBeat.o(56103);
    return paramIterable;
  }
  
  public static final <T> Set<T> q(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56104);
    a.f.b.j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      paramIterable = (Set)new LinkedHashSet((Collection)paramIterable);
      AppMethodBeat.o(56104);
      return paramIterable;
    }
    paramIterable = (Set)j.b(paramIterable, (Collection)new LinkedHashSet());
    AppMethodBeat.o(56104);
    return paramIterable;
  }
  
  public static final <T extends Comparable<? super T>> T r(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56105);
    a.f.b.j.q(paramIterable, "receiver$0");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(56105);
      return null;
    }
    paramIterable = (Comparable)localIterator.next();
    if (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramIterable.compareTo(localComparable) >= 0) {
        break label89;
      }
      paramIterable = localComparable;
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(56105);
      return paramIterable;
    }
  }
  
  public static final <T extends Comparable<? super T>> T s(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56106);
    a.f.b.j.q(paramIterable, "receiver$0");
    Iterator localIterator = paramIterable.iterator();
    if (!localIterator.hasNext())
    {
      AppMethodBeat.o(56106);
      return null;
    }
    paramIterable = (Comparable)localIterator.next();
    if (localIterator.hasNext())
    {
      Comparable localComparable = (Comparable)localIterator.next();
      if (paramIterable.compareTo(localComparable) <= 0) {
        break label89;
      }
      paramIterable = localComparable;
    }
    label89:
    for (;;)
    {
      break;
      AppMethodBeat.o(56106);
      return paramIterable;
    }
  }
  
  public static final <T> h<T> t(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56116);
    a.f.b.j.q(paramIterable, "receiver$0");
    paramIterable = (h)new t.a(paramIterable);
    AppMethodBeat.o(56116);
    return paramIterable;
  }
  
  public static final int u(Iterable<Integer> paramIterable)
  {
    AppMethodBeat.i(56117);
    a.f.b.j.q(paramIterable, "receiver$0");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = ((Number)paramIterable.next()).intValue() + i) {}
    AppMethodBeat.o(56117);
    return i;
  }
  
  public static final long v(Iterable<Long> paramIterable)
  {
    AppMethodBeat.i(142960);
    a.f.b.j.q(paramIterable, "receiver$0");
    paramIterable = paramIterable.iterator();
    for (long l = 0L; paramIterable.hasNext(); l = ((Number)paramIterable.next()).longValue() + l) {}
    AppMethodBeat.o(142960);
    return l;
  }
  
  public static final <T> T w(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(56079);
    a.f.b.j.q(paramList, "receiver$0");
    if ((paramInt >= 0) && (paramInt <= j.fO(paramList)))
    {
      paramList = paramList.get(paramInt);
      AppMethodBeat.o(56079);
      return paramList;
    }
    AppMethodBeat.o(56079);
    return null;
  }
  
  public static final <T> List<T> x(List<? extends T> paramList, int paramInt)
  {
    AppMethodBeat.i(56094);
    a.f.b.j.q(paramList, "receiver$0");
    if (paramInt >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramList = (Throwable)new IllegalArgumentException(("Requested element count " + paramInt + " is less than zero.").toString());
      AppMethodBeat.o(56094);
      throw paramList;
    }
    if (paramInt == 0)
    {
      paramList = (List)v.BMx;
      AppMethodBeat.o(56094);
      return paramList;
    }
    i = paramList.size();
    if (paramInt >= i)
    {
      paramList = j.m((Iterable)paramList);
      AppMethodBeat.o(56094);
      return paramList;
    }
    if (paramInt == 1)
    {
      paramList = j.listOf(j.fS(paramList));
      AppMethodBeat.o(56094);
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramInt);
    if ((paramList instanceof RandomAccess))
    {
      paramInt = i - paramInt;
      while (paramInt < i)
      {
        localArrayList.add(paramList.get(paramInt));
        paramInt += 1;
      }
    }
    paramList = (Iterator)paramList.listIterator(i - paramInt);
    while (paramList.hasNext()) {
      localArrayList.add(paramList.next());
    }
    paramList = (List)localArrayList;
    AppMethodBeat.o(56094);
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.a.t
 * JD-Core Version:    0.7.0.1
 */