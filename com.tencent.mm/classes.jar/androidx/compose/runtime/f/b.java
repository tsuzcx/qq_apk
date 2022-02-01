package androidx.compose.runtime.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastFilterIndexed", "", "predicate", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "", "fastForEach", "action", "fastForEachIndexed", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMap", "R", "fastMapNotNull", "fastToSet", "", "runtime_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final <T> Set<T> O(List<? extends T> paramList)
  {
    AppMethodBeat.i(202623);
    s.u(paramList, "<this>");
    HashSet localHashSet = new HashSet(paramList.size());
    int i = 0;
    int k = paramList.size() - 1;
    if (k >= 0) {}
    for (;;)
    {
      int j = i + 1;
      localHashSet.add(paramList.get(i));
      if (j > k)
      {
        paramList = (Set)localHashSet;
        AppMethodBeat.o(202623);
        return paramList;
      }
      i = j;
    }
  }
  
  static final <T, A extends Appendable> A a(List<? extends T> paramList, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(202642);
    paramA.append(paramCharSequence2);
    int m = paramList.size() - 1;
    int i;
    int j;
    if (m >= 0)
    {
      i = 0;
      j = 0;
    }
    for (;;)
    {
      int k = i + 1;
      paramCharSequence2 = paramList.get(i);
      j += 1;
      if (j > 1) {
        paramA.append(paramCharSequence1);
      }
      boolean bool;
      if (paramCharSequence2 == null)
      {
        bool = true;
        if (!bool) {
          break label124;
        }
        paramA.append((CharSequence)paramCharSequence2);
      }
      for (;;)
      {
        if (k <= m) {
          break label165;
        }
        paramA.append(paramCharSequence3);
        AppMethodBeat.o(202642);
        return paramA;
        bool = paramCharSequence2 instanceof CharSequence;
        break;
        label124:
        if ((paramCharSequence2 instanceof Character)) {
          paramA.append(((Character)paramCharSequence2).charValue());
        } else {
          paramA.append((CharSequence)String.valueOf(paramCharSequence2));
        }
      }
      label165:
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.compose.runtime.f.b
 * JD-Core Version:    0.7.0.1
 */