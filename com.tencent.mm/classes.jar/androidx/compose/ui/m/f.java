package androidx.compose.ui.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"getLocalPlaceholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "start", "", "end", "ui-text_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  static final List<a.a<Object>> f(List<a.a<Object>> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204896);
    ArrayList localArrayList = new ArrayList(paramList.size());
    int k = paramList.size() - 1;
    if (k >= 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject1 = paramList.get(i);
      Object localObject2 = (a.a)localObject1;
      if (b.i(paramInt1, paramInt2, ((a.a)localObject2).start, ((a.a)localObject2).end)) {
        ((Collection)localArrayList).add(localObject1);
      }
      if (j > k)
      {
        paramList = (List)localArrayList;
        localArrayList = new ArrayList(paramList.size());
        k = paramList.size() - 1;
        if (k >= 0) {}
        for (i = 0;; i = j)
        {
          j = i + 1;
          localObject2 = paramList.get(i);
          localObject1 = (Collection)localArrayList;
          localObject2 = (a.a)localObject2;
          if ((paramInt1 <= ((a.a)localObject2).start) && (((a.a)localObject2).end <= paramInt2)) {}
          for (i = 1; i == 0; i = 0)
          {
            paramList = (Throwable)new IllegalArgumentException("placeholder can not overlap with paragraph.".toString());
            AppMethodBeat.o(204896);
            throw paramList;
          }
          ((Collection)localObject1).add(new a.a(((a.a)localObject2).aYG, ((a.a)localObject2).start - paramInt1, ((a.a)localObject2).end - paramInt1));
          if (j > k)
          {
            paramList = (List)localArrayList;
            AppMethodBeat.o(204896);
            return paramList;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.f
 * JD-Core Version:    0.7.0.1
 */