package a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"emptySet", "", "T", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "mutableSetOf", "", "([Ljava/lang/Object;)Ljava/util/Set;", "setOf", "optimizeReadOnlySet", "orEmpty", "kotlin-stdlib"}, eaR=1)
public class al
  extends ak
{
  public static final <T> Set<T> setOf(T... paramVarArgs)
  {
    AppMethodBeat.i(56188);
    j.q(paramVarArgs, "elements");
    if (paramVarArgs.length > 0)
    {
      paramVarArgs = e.S(paramVarArgs);
      AppMethodBeat.o(56188);
      return paramVarArgs;
    }
    paramVarArgs = (Set)x.BMz;
    AppMethodBeat.o(56188);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.a.al
 * JD-Core Version:    0.7.0.1
 */