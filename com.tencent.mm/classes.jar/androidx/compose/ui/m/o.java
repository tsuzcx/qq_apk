package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastDistinctBy", "", "K", "selector", "fastDrop", "n", "", "fastFilter", "predicate", "", "fastFilterNot", "fastFlatMap", "R", "", "fastFold", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMinByOrNull", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "fastTakeWhile", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final <T, A extends Appendable> A a(List<? extends T> paramList, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(204948);
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
        AppMethodBeat.o(204948);
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
 * Qualified Name:     androidx.compose.ui.m.o
 * JD-Core Version:    0.7.0.1
 */