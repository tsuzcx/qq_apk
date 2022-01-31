package a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "", "T", "", "getLastIndex", "(Ljava/util/List;)I", "List", "size", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "elements", "", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "emptyList", "listOf", "([Ljava/lang/Object;)Ljava/util/List;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "rangeCheck", "", "fromIndex", "toIndex", "rangeCheck$CollectionsKt__CollectionsKt", "throwCountOverflow", "throwIndexOverflow", "asCollection", "([Ljava/lang/Object;)Ljava/util/Collection;", "binarySearch", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "comparison", "", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "containsAll", "", "Lkotlin/internal/OnlyInputTypes;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNotEmpty", "isNullOrEmpty", "optimizeReadOnlyList", "orEmpty", "kotlin-stdlib"}, eaR=1)
public class l
  extends k
{
  public static final <T> ArrayList<T> V(T... paramVarArgs)
  {
    AppMethodBeat.i(56208);
    a.f.b.j.q(paramVarArgs, "elements");
    if (paramVarArgs.length == 0)
    {
      paramVarArgs = new ArrayList();
      AppMethodBeat.o(56208);
      return paramVarArgs;
    }
    paramVarArgs = new ArrayList((Collection)new d(paramVarArgs, true));
    AppMethodBeat.o(56208);
    return paramVarArgs;
  }
  
  public static final <T> List<T> df(T paramT)
  {
    AppMethodBeat.i(56209);
    if (paramT != null)
    {
      paramT = j.listOf(paramT);
      AppMethodBeat.o(56209);
      return paramT;
    }
    paramT = (List)v.BMx;
    AppMethodBeat.o(56209);
    return paramT;
  }
  
  public static final a.i.d e(Collection<?> paramCollection)
  {
    AppMethodBeat.i(56210);
    a.f.b.j.q(paramCollection, "receiver$0");
    paramCollection = new a.i.d(0, paramCollection.size() - 1);
    AppMethodBeat.o(56210);
    return paramCollection;
  }
  
  public static final void eaS()
  {
    AppMethodBeat.i(56213);
    Throwable localThrowable = (Throwable)new ArithmeticException("Index overflow has happened.");
    AppMethodBeat.o(56213);
    throw localThrowable;
  }
  
  public static final void eaT()
  {
    AppMethodBeat.i(56214);
    Throwable localThrowable = (Throwable)new ArithmeticException("Count overflow has happened.");
    AppMethodBeat.o(56214);
    throw localThrowable;
  }
  
  public static final <T> int fO(List<? extends T> paramList)
  {
    AppMethodBeat.i(56211);
    a.f.b.j.q(paramList, "receiver$0");
    int i = paramList.size();
    AppMethodBeat.o(56211);
    return i - 1;
  }
  
  public static final <T> List<T> fP(List<? extends T> paramList)
  {
    AppMethodBeat.i(56212);
    a.f.b.j.q(paramList, "receiver$0");
    switch (paramList.size())
    {
    default: 
      AppMethodBeat.o(56212);
      return paramList;
    case 0: 
      paramList = (List)v.BMx;
      AppMethodBeat.o(56212);
      return paramList;
    }
    paramList = j.listOf(paramList.get(0));
    AppMethodBeat.o(56212);
    return paramList;
  }
  
  public static final <T> List<T> listOf(T... paramVarArgs)
  {
    AppMethodBeat.i(56207);
    a.f.b.j.q(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.asList(paramVarArgs);
      AppMethodBeat.o(56207);
      return paramVarArgs;
    }
    paramVarArgs = (List)v.BMx;
    AppMethodBeat.o(56207);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.a.l
 * JD-Core Version:    0.7.0.1
 */