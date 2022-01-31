package a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"fill", "", "T", "", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "shuffled", "", "", "sort", "", "comparison", "Lkotlin/Function2;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "sortWith", "kotlin-stdlib"}, eaR=1)
public class p
  extends o
{
  public static final <T> void a(List<T> paramList, Comparator<? super T> paramComparator)
  {
    AppMethodBeat.i(56155);
    j.q(paramList, "receiver$0");
    j.q(paramComparator, "comparator");
    if (paramList.size() > 1) {
      Collections.sort(paramList, paramComparator);
    }
    AppMethodBeat.o(56155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.a.p
 * JD-Core Version:    0.7.0.1
 */