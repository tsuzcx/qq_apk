package a.a;

import a.f.a.a;
import a.f.a.b;
import a.l;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"indices", "Lkotlin/ranges/IntRange;", "T", "", "getIndices", "([Ljava/lang/Object;)Lkotlin/ranges/IntRange;", "", "([Z)Lkotlin/ranges/IntRange;", "", "([B)Lkotlin/ranges/IntRange;", "", "([C)Lkotlin/ranges/IntRange;", "", "([D)Lkotlin/ranges/IntRange;", "", "([F)Lkotlin/ranges/IntRange;", "", "([I)Lkotlin/ranges/IntRange;", "", "([J)Lkotlin/ranges/IntRange;", "", "([S)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "([Ljava/lang/Object;)I", "([Z)I", "([B)I", "([C)I", "([D)I", "([F)I", "([I)I", "([J)I", "([S)I", "all", "", "predicate", "Lkotlin/Function1;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "", "", "", "", "", "", "any", "([Ljava/lang/Object;)Z", "asIterable", "", "([Ljava/lang/Object;)Ljava/lang/Iterable;", "asSequence", "Lkotlin/sequences/Sequence;", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "associate", "", "K", "V", "transform", "Lkotlin/Pair;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateBy", "keySelector", "valueTransform", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateByTo", "M", "", "destination", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([Ljava/lang/Object;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ZLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([BLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([CLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([DLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([FLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([ILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([JLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "([SLjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "associateTo", "average", "averageOfByte", "([Ljava/lang/Byte;)D", "averageOfDouble", "([Ljava/lang/Double;)D", "averageOfFloat", "([Ljava/lang/Float;)D", "averageOfInt", "([Ljava/lang/Integer;)D", "averageOfLong", "([Ljava/lang/Long;)D", "averageOfShort", "([Ljava/lang/Short;)D", "component1", "([Ljava/lang/Object;)Ljava/lang/Object;", "component2", "component3", "component4", "component5", "contains", "Lkotlin/internal/OnlyInputTypes;", "element", "([Ljava/lang/Object;Ljava/lang/Object;)Z", "count", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "distinct", "", "([Ljava/lang/Object;)Ljava/util/List;", "distinctBy", "selector", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "drop", "n", "([Ljava/lang/Object;I)Ljava/util/List;", "dropLast", "dropLastWhile", "dropWhile", "elementAt", "index", "([Ljava/lang/Object;I)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "([Ljava/lang/Object;ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "elementAtOrNull", "([ZI)Ljava/lang/Boolean;", "([BI)Ljava/lang/Byte;", "([CI)Ljava/lang/Character;", "([DI)Ljava/lang/Double;", "([FI)Ljava/lang/Float;", "([II)Ljava/lang/Integer;", "([JI)Ljava/lang/Long;", "([SI)Ljava/lang/Short;", "filter", "filterIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "filterIndexedTo", "C", "", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function2;)Ljava/util/Collection;", "filterIsInstance", "R", "Lkotlin/internal/NoInfer;", "filterIsInstanceTo", "([Ljava/lang/Object;Ljava/util/Collection;)Ljava/util/Collection;", "filterNot", "filterNotNull", "", "filterNotNullTo", "filterNotTo", "([Ljava/lang/Object;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ZLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([BLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([CLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([DLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([FLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([ILjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([JLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "([SLjava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "filterTo", "find", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "([ZLkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "([BLkotlin/jvm/functions/Function1;)Ljava/lang/Byte;", "([CLkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "([DLkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "([FLkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "([ILkotlin/jvm/functions/Function1;)Ljava/lang/Integer;", "([JLkotlin/jvm/functions/Function1;)Ljava/lang/Long;", "([SLkotlin/jvm/functions/Function1;)Ljava/lang/Short;", "findLast", "first", "firstOrNull", "([Z)Ljava/lang/Boolean;", "([B)Ljava/lang/Byte;", "([C)Ljava/lang/Character;", "([D)Ljava/lang/Double;", "([F)Ljava/lang/Float;", "([I)Ljava/lang/Integer;", "([J)Ljava/lang/Long;", "([S)Ljava/lang/Short;", "flatMap", "flatMapTo", "fold", "initial", "operation", "acc", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "foldIndexed", "Lkotlin/Function3;", "([Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ZLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([BLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([CLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([DLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([FLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([ILjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([JLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "([SLjava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "foldRight", "foldRightIndexed", "forEach", "", "action", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "forEachIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getOrElse", "getOrNull", "groupBy", "groupByTo", "", "groupingBy", "Lkotlin/collections/Grouping;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/collections/Grouping;", "indexOf", "([Ljava/lang/Object;Ljava/lang/Object;)I", "indexOfFirst", "indexOfLast", "intersect", "", "other", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/Set;", "isEmpty", "isNotEmpty", "joinTo", "A", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "buffer", "separator", "", "prefix", "postfix", "limit", "truncated", "([Ljava/lang/Object;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ZLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([BLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([CLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([DLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([FLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([ILjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([JLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "([SLjava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "joinToString", "", "([Ljava/lang/Object;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "max", "", "([Ljava/lang/Comparable;)Ljava/lang/Comparable;", "([Ljava/lang/Double;)Ljava/lang/Double;", "([Ljava/lang/Float;)Ljava/lang/Float;", "maxBy", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/lang/Object;", "([ZLjava/util/Comparator;)Ljava/lang/Boolean;", "([BLjava/util/Comparator;)Ljava/lang/Byte;", "([CLjava/util/Comparator;)Ljava/lang/Character;", "([DLjava/util/Comparator;)Ljava/lang/Double;", "([FLjava/util/Comparator;)Ljava/lang/Float;", "([ILjava/util/Comparator;)Ljava/lang/Integer;", "([JLjava/util/Comparator;)Ljava/lang/Long;", "([SLjava/util/Comparator;)Ljava/lang/Short;", "min", "minBy", "minWith", "none", "partition", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/Pair;", "random", "Lkotlin/random/Random;", "([Ljava/lang/Object;Lkotlin/random/Random;)Ljava/lang/Object;", "reduce", "S", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "reduceIndexed", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "reduceRight", "reduceRightIndexed", "requireNoNulls", "([Ljava/lang/Object;)[Ljava/lang/Object;", "reverse", "([Ljava/lang/Object;)V", "reversed", "reversedArray", "single", "singleOrNull", "slice", "([Ljava/lang/Object;Ljava/lang/Iterable;)Ljava/util/List;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)Ljava/util/List;", "sliceArray", "", "([Ljava/lang/Object;Ljava/util/Collection;)[Ljava/lang/Object;", "([Ljava/lang/Object;Lkotlin/ranges/IntRange;)[Ljava/lang/Object;", "sortBy", "sortByDescending", "sortDescending", "([Ljava/lang/Comparable;)V", "sorted", "([Ljava/lang/Comparable;)Ljava/util/List;", "sortedArray", "([Ljava/lang/Comparable;)[Ljava/lang/Comparable;", "sortedArrayDescending", "sortedArrayWith", "([Ljava/lang/Object;Ljava/util/Comparator;)[Ljava/lang/Object;", "sortedBy", "sortedByDescending", "sortedDescending", "sortedWith", "([Ljava/lang/Object;Ljava/util/Comparator;)Ljava/util/List;", "subtract", "sum", "sumOfByte", "([Ljava/lang/Byte;)I", "sumOfDouble", "sumOfFloat", "([Ljava/lang/Float;)F", "sumOfInt", "([Ljava/lang/Integer;)I", "sumOfLong", "([Ljava/lang/Long;)J", "sumOfShort", "([Ljava/lang/Short;)I", "sumBy", "sumByDouble", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)D", "take", "takeLast", "takeLastWhile", "takeWhile", "toBooleanArray", "([Ljava/lang/Boolean;)[Z", "toByteArray", "([Ljava/lang/Byte;)[B", "toCharArray", "([Ljava/lang/Character;)[C", "toCollection", "([ZLjava/util/Collection;)Ljava/util/Collection;", "([BLjava/util/Collection;)Ljava/util/Collection;", "([CLjava/util/Collection;)Ljava/util/Collection;", "([DLjava/util/Collection;)Ljava/util/Collection;", "([FLjava/util/Collection;)Ljava/util/Collection;", "([ILjava/util/Collection;)Ljava/util/Collection;", "([JLjava/util/Collection;)Ljava/util/Collection;", "([SLjava/util/Collection;)Ljava/util/Collection;", "toDoubleArray", "([Ljava/lang/Double;)[D", "toFloatArray", "([Ljava/lang/Float;)[F", "toHashSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "toIntArray", "([Ljava/lang/Integer;)[I", "toList", "toLongArray", "([Ljava/lang/Long;)[J", "toMutableList", "toMutableSet", "", "([Ljava/lang/Object;)Ljava/util/Set;", "toSet", "toShortArray", "([Ljava/lang/Short;)[S", "union", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "([Ljava/lang/Object;[Ljava/lang/Object;)Ljava/util/List;", "a", "b", "([Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Ljava/lang/Object;Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([Z[Ljava/lang/Object;)Ljava/util/List;", "([Z[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([B[Ljava/lang/Object;)Ljava/util/List;", "([B[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([C[Ljava/lang/Object;)Ljava/util/List;", "([C[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([D[Ljava/lang/Object;)Ljava/util/List;", "([D[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([F[Ljava/lang/Object;)Ljava/util/List;", "([F[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([I[Ljava/lang/Object;)Ljava/util/List;", "([I[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([J[Ljava/lang/Object;)Ljava/util/List;", "([J[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "([S[Ljava/lang/Object;)Ljava/util/List;", "([S[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "kotlin-stdlib"}, eaR=1)
public class i
  extends h
{
  public static final int M(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(56129);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    int i = paramArrayOfInt.length;
    AppMethodBeat.o(56129);
    return i - 1;
  }
  
  public static final <T> T M(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56120);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(56120);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(56120);
    return paramArrayOfT;
  }
  
  public static final <T> T N(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56121);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(56121);
      return null;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(56121);
    return paramArrayOfT;
  }
  
  public static final List<Integer> N(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(56134);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    switch (paramArrayOfInt.length)
    {
    default: 
      paramArrayOfInt = e.O(paramArrayOfInt);
      AppMethodBeat.o(56134);
      return paramArrayOfInt;
    case 0: 
      paramArrayOfInt = (List)v.BMx;
      AppMethodBeat.o(56134);
      return paramArrayOfInt;
    }
    paramArrayOfInt = j.listOf(Integer.valueOf(paramArrayOfInt[0]));
    AppMethodBeat.o(56134);
    return paramArrayOfInt;
  }
  
  public static final <T> T O(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56125);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(56125);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[e.Q(paramArrayOfT)];
    AppMethodBeat.o(56125);
    return paramArrayOfT;
  }
  
  public static final List<Integer> O(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(56140);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    ArrayList localArrayList = new ArrayList(paramArrayOfInt.length);
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Integer.valueOf(paramArrayOfInt[i]));
      i += 1;
    }
    paramArrayOfInt = (List)localArrayList;
    AppMethodBeat.o(56140);
    return paramArrayOfInt;
  }
  
  public static final <T> T P(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56126);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    switch (paramArrayOfT.length)
    {
    default: 
      paramArrayOfT = (Throwable)new IllegalArgumentException("Array has more than one element.");
      AppMethodBeat.o(56126);
      throw paramArrayOfT;
    case 0: 
      paramArrayOfT = (Throwable)new NoSuchElementException("Array is empty.");
      AppMethodBeat.o(56126);
      throw paramArrayOfT;
    }
    paramArrayOfT = paramArrayOfT[0];
    AppMethodBeat.o(56126);
    return paramArrayOfT;
  }
  
  public static final <T> int Q(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56128);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    int i = paramArrayOfT.length;
    AppMethodBeat.o(56128);
    return i - 1;
  }
  
  public static final <T> List<T> R(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56131);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    switch (paramArrayOfT.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfT, "receiver$0");
      a.f.b.j.q(paramArrayOfT, "receiver$0");
      paramArrayOfT = (List)new ArrayList((Collection)new d(paramArrayOfT, false));
      AppMethodBeat.o(56131);
      return paramArrayOfT;
    case 0: 
      paramArrayOfT = (List)v.BMx;
      AppMethodBeat.o(56131);
      return paramArrayOfT;
    }
    paramArrayOfT = j.listOf(paramArrayOfT[0]);
    AppMethodBeat.o(56131);
    return paramArrayOfT;
  }
  
  public static final <T> Set<T> S(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56141);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    switch (paramArrayOfT.length)
    {
    default: 
      paramArrayOfT = (Set)e.a(paramArrayOfT, (Collection)new LinkedHashSet(ad.TQ(paramArrayOfT.length)));
      AppMethodBeat.o(56141);
      return paramArrayOfT;
    case 0: 
      paramArrayOfT = (Set)x.BMz;
      AppMethodBeat.o(56141);
      return paramArrayOfT;
    }
    paramArrayOfT = aj.setOf(paramArrayOfT[0]);
    AppMethodBeat.o(56141);
    return paramArrayOfT;
  }
  
  public static final <T> Iterable<y<T>> T(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56143);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    paramArrayOfT = (Iterable)new z((a)new i.b(paramArrayOfT));
    AppMethodBeat.o(56143);
    return paramArrayOfT;
  }
  
  public static final <T> a.k.h<T> U(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56147);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (paramArrayOfT.length == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArrayOfT = (a.k.h)a.k.d.CGj;
      AppMethodBeat.o(56147);
      return paramArrayOfT;
    }
    paramArrayOfT = (a.k.h)new i.a(paramArrayOfT);
    AppMethodBeat.o(56147);
    return paramArrayOfT;
  }
  
  public static final <T, A extends Appendable> A a(T[] paramArrayOfT, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(56144);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    a.f.b.j.q(paramA, "buffer");
    a.f.b.j.q(paramCharSequence1, "separator");
    a.f.b.j.q(paramCharSequence2, "prefix");
    a.f.b.j.q(paramCharSequence3, "postfix");
    a.f.b.j.q(paramCharSequence4, "truncated");
    paramA.append(paramCharSequence2);
    int m = paramArrayOfT.length;
    int j = 0;
    int i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      paramCharSequence2 = paramArrayOfT[j];
      i += 1;
      if (i > 1) {
        paramA.append(paramCharSequence1);
      }
      if (paramInt >= 0)
      {
        k = i;
        if (i > paramInt) {
          break;
        }
      }
      m.a(paramA, paramCharSequence2, paramb);
      j += 1;
    }
    if ((paramInt >= 0) && (k > paramInt)) {
      paramA.append(paramCharSequence4);
    }
    paramA.append(paramCharSequence3);
    AppMethodBeat.o(56144);
    return paramA;
  }
  
  public static final <T> String a(T[] paramArrayOfT, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3, int paramInt, CharSequence paramCharSequence4, b<? super T, ? extends CharSequence> paramb)
  {
    AppMethodBeat.i(56145);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    a.f.b.j.q(paramCharSequence1, "separator");
    a.f.b.j.q(paramCharSequence2, "prefix");
    a.f.b.j.q(paramCharSequence3, "postfix");
    a.f.b.j.q(paramCharSequence4, "truncated");
    paramArrayOfT = ((StringBuilder)e.a(paramArrayOfT, (Appendable)new StringBuilder(), paramCharSequence1, paramCharSequence2, paramCharSequence3, paramInt, paramCharSequence4, paramb)).toString();
    a.f.b.j.p(paramArrayOfT, "joinTo(StringBuilder(), …ed, transform).toString()");
    AppMethodBeat.o(56145);
    return paramArrayOfT;
  }
  
  public static final <T, C extends Collection<? super T>> C a(T[] paramArrayOfT, C paramC)
  {
    AppMethodBeat.i(56130);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    a.f.b.j.q(paramC, "destination");
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      paramC.add(paramArrayOfT[i]);
      i += 1;
    }
    AppMethodBeat.o(56130);
    return paramC;
  }
  
  public static final <T, R> List<R> a(T[] paramArrayOfT, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(56142);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    a.f.b.j.q(paramb, "transform");
    Collection localCollection = (Collection)new ArrayList(paramArrayOfT.length);
    int j = paramArrayOfT.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(paramb.S(paramArrayOfT[i]));
      i += 1;
    }
    paramArrayOfT = (List)localCollection;
    AppMethodBeat.o(56142);
    return paramArrayOfT;
  }
  
  public static final float[] a(Float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(142961);
    a.f.b.j.q(paramArrayOfFloat, "receiver$0");
    float[] arrayOfFloat = new float[4];
    int i = 0;
    while (i < 4)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i].floatValue();
      i += 1;
    }
    AppMethodBeat.o(142961);
    return arrayOfFloat;
  }
  
  public static final char b(char[] paramArrayOfChar)
  {
    AppMethodBeat.i(56127);
    a.f.b.j.q(paramArrayOfChar, "receiver$0");
    char c = paramArrayOfChar[0];
    AppMethodBeat.o(56127);
    return c;
  }
  
  public static final List<Short> b(short[] paramArrayOfShort)
  {
    int i = 0;
    AppMethodBeat.i(56133);
    a.f.b.j.q(paramArrayOfShort, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfShort.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfShort, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfShort.length);
      j = paramArrayOfShort.length;
    }
    while (i < j)
    {
      localArrayList.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
      continue;
      paramArrayOfShort = (List)v.BMx;
      AppMethodBeat.o(56133);
      return paramArrayOfShort;
      paramArrayOfShort = j.listOf(Short.valueOf(paramArrayOfShort[0]));
      AppMethodBeat.o(56133);
      return paramArrayOfShort;
    }
    paramArrayOfShort = (List)localArrayList;
    AppMethodBeat.o(56133);
    return paramArrayOfShort;
  }
  
  public static final List<Boolean> b(boolean[] paramArrayOfBoolean)
  {
    int i = 0;
    AppMethodBeat.i(56138);
    a.f.b.j.q(paramArrayOfBoolean, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfBoolean.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfBoolean, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfBoolean.length);
      j = paramArrayOfBoolean.length;
    }
    while (i < j)
    {
      localArrayList.add(Boolean.valueOf(paramArrayOfBoolean[i]));
      i += 1;
      continue;
      paramArrayOfBoolean = (List)v.BMx;
      AppMethodBeat.o(56138);
      return paramArrayOfBoolean;
      paramArrayOfBoolean = j.listOf(Boolean.valueOf(paramArrayOfBoolean[0]));
      AppMethodBeat.o(56138);
      return paramArrayOfBoolean;
    }
    paramArrayOfBoolean = (List)localArrayList;
    AppMethodBeat.o(56138);
    return paramArrayOfBoolean;
  }
  
  public static final List<Character> c(char[] paramArrayOfChar)
  {
    int i = 0;
    AppMethodBeat.i(56139);
    a.f.b.j.q(paramArrayOfChar, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfChar.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfChar, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfChar.length);
      j = paramArrayOfChar.length;
    }
    while (i < j)
    {
      localArrayList.add(Character.valueOf(paramArrayOfChar[i]));
      i += 1;
      continue;
      paramArrayOfChar = (List)v.BMx;
      AppMethodBeat.o(56139);
      return paramArrayOfChar;
      paramArrayOfChar = j.listOf(Character.valueOf(paramArrayOfChar[0]));
      AppMethodBeat.o(56139);
      return paramArrayOfChar;
    }
    paramArrayOfChar = (List)localArrayList;
    AppMethodBeat.o(56139);
    return paramArrayOfChar;
  }
  
  public static final boolean contains(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(56119);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    if (e.k(paramArrayOfInt, paramInt) >= 0)
    {
      AppMethodBeat.o(56119);
      return true;
    }
    AppMethodBeat.o(56119);
    return false;
  }
  
  public static final <T> boolean contains(T[] paramArrayOfT, T paramT)
  {
    AppMethodBeat.i(56118);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (e.indexOf(paramArrayOfT, paramT) >= 0)
    {
      AppMethodBeat.o(56118);
      return true;
    }
    AppMethodBeat.o(56118);
    return false;
  }
  
  public static final List<Byte> cy(byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(56132);
    a.f.b.j.q(paramArrayOfByte, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfByte.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfByte, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfByte.length);
      j = paramArrayOfByte.length;
    }
    while (i < j)
    {
      localArrayList.add(Byte.valueOf(paramArrayOfByte[i]));
      i += 1;
      continue;
      paramArrayOfByte = (List)v.BMx;
      AppMethodBeat.o(56132);
      return paramArrayOfByte;
      paramArrayOfByte = j.listOf(Byte.valueOf(paramArrayOfByte[0]));
      AppMethodBeat.o(56132);
      return paramArrayOfByte;
    }
    paramArrayOfByte = (List)localArrayList;
    AppMethodBeat.o(56132);
    return paramArrayOfByte;
  }
  
  public static final List<Double> e(double[] paramArrayOfDouble)
  {
    int i = 0;
    AppMethodBeat.i(56137);
    a.f.b.j.q(paramArrayOfDouble, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfDouble.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfDouble, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfDouble.length);
      j = paramArrayOfDouble.length;
    }
    while (i < j)
    {
      localArrayList.add(Double.valueOf(paramArrayOfDouble[i]));
      i += 1;
      continue;
      paramArrayOfDouble = (List)v.BMx;
      AppMethodBeat.o(56137);
      return paramArrayOfDouble;
      paramArrayOfDouble = j.listOf(Double.valueOf(paramArrayOfDouble[0]));
      AppMethodBeat.o(56137);
      return paramArrayOfDouble;
    }
    paramArrayOfDouble = (List)localArrayList;
    AppMethodBeat.o(56137);
    return paramArrayOfDouble;
  }
  
  public static final List<Long> g(long[] paramArrayOfLong)
  {
    int i = 0;
    AppMethodBeat.i(56135);
    a.f.b.j.q(paramArrayOfLong, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfLong.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfLong, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfLong.length);
      j = paramArrayOfLong.length;
    }
    while (i < j)
    {
      localArrayList.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
      continue;
      paramArrayOfLong = (List)v.BMx;
      AppMethodBeat.o(56135);
      return paramArrayOfLong;
      paramArrayOfLong = j.listOf(Long.valueOf(paramArrayOfLong[0]));
      AppMethodBeat.o(56135);
      return paramArrayOfLong;
    }
    paramArrayOfLong = (List)localArrayList;
    AppMethodBeat.o(56135);
    return paramArrayOfLong;
  }
  
  public static final <T> int indexOf(T[] paramArrayOfT, T paramT)
  {
    int j = 0;
    int i = 0;
    AppMethodBeat.i(56123);
    a.f.b.j.q(paramArrayOfT, "receiver$0");
    if (paramT == null)
    {
      j = paramArrayOfT.length;
      while (i < j)
      {
        if (paramArrayOfT[i] == null)
        {
          AppMethodBeat.o(56123);
          return i;
        }
        i += 1;
      }
    }
    int k = paramArrayOfT.length;
    i = j;
    while (i < k)
    {
      if (a.f.b.j.e(paramT, paramArrayOfT[i]))
      {
        AppMethodBeat.o(56123);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(56123);
    return -1;
  }
  
  public static final Integer j(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(56122);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    if ((paramInt >= 0) && (paramInt <= e.M(paramArrayOfInt)))
    {
      paramInt = paramArrayOfInt[paramInt];
      AppMethodBeat.o(56122);
      return Integer.valueOf(paramInt);
    }
    AppMethodBeat.o(56122);
    return null;
  }
  
  public static final int k(int[] paramArrayOfInt, int paramInt)
  {
    AppMethodBeat.i(56124);
    a.f.b.j.q(paramArrayOfInt, "receiver$0");
    int i = 0;
    int j = paramArrayOfInt.length;
    while (i < j)
    {
      if (paramInt == paramArrayOfInt[i])
      {
        AppMethodBeat.o(56124);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(56124);
    return -1;
  }
  
  public static final List<Float> l(float[] paramArrayOfFloat)
  {
    int i = 0;
    AppMethodBeat.i(56136);
    a.f.b.j.q(paramArrayOfFloat, "receiver$0");
    ArrayList localArrayList;
    int j;
    switch (paramArrayOfFloat.length)
    {
    default: 
      a.f.b.j.q(paramArrayOfFloat, "receiver$0");
      localArrayList = new ArrayList(paramArrayOfFloat.length);
      j = paramArrayOfFloat.length;
    }
    while (i < j)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
      continue;
      paramArrayOfFloat = (List)v.BMx;
      AppMethodBeat.o(56136);
      return paramArrayOfFloat;
      paramArrayOfFloat = j.listOf(Float.valueOf(paramArrayOfFloat[0]));
      AppMethodBeat.o(56136);
      return paramArrayOfFloat;
    }
    paramArrayOfFloat = (List)localArrayList;
    AppMethodBeat.o(56136);
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.a.i
 * JD-Core Version:    0.7.0.1
 */