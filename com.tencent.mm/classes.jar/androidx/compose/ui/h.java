package androidx.compose.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"appendElement", "", "T", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "element", "transform", "Lkotlin/Function1;", "", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "fastAssociate", "", "K", "V", "", "Lkotlin/Pair;", "fastJoinTo", "A", "buffer", "separator", "prefix", "postfix", "limit", "", "truncated", "(Ljava/util/List;Ljava/lang/Appendable;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Appendable;", "fastJoinToString", "", "fastMapNotNull", "R", "fastReduce", "S", "operation", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "acc", "(Ljava/util/List;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "fastZip", "other", "a", "b", "fastZipWithNext", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final <T, A extends Appendable> A a(List<? extends T> paramList, A paramA, CharSequence paramCharSequence1, CharSequence paramCharSequence2, CharSequence paramCharSequence3)
  {
    AppMethodBeat.i(204700);
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
        AppMethodBeat.o(204700);
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
 * Qualified Name:     androidx.compose.ui.h
 * JD-Core Version:    0.7.0.1
 */