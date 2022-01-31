package a.a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrDefault", "", "default", "collectionSizeOrNull", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "convertToSetForSetOperation", "", "convertToSetForSetOperationWith", "source", "flatten", "", "safeToConvertToSet", "", "safeToConvertToSet$CollectionsKt__IterablesKt", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, eaR=1)
public class m
  extends l
{
  public static final <T> int d(Iterable<? extends T> paramIterable)
  {
    AppMethodBeat.i(56029);
    j.q(paramIterable, "receiver$0");
    if ((paramIterable instanceof Collection))
    {
      int i = ((Collection)paramIterable).size();
      AppMethodBeat.o(56029);
      return i;
    }
    AppMethodBeat.o(56029);
    return 10;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.a.m
 * JD-Core Version:    0.7.0.1
 */