package com.tencent.mm.plugin.finder.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class FinderFeedExposeLayout$n<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(221570);
    int i = a.a((Comparable)Long.valueOf(((FinderCommentInfo)paramT2).displayid), (Comparable)Long.valueOf(((FinderCommentInfo)paramT1).displayid));
    AppMethodBeat.o(221570);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout.n
 * JD-Core Version:    0.7.0.1
 */