package com.tencent.mm.plugin.handoff.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOff;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
public final class e$e$a<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(266171);
    int i = a.b((Comparable)Long.valueOf(-((HandOff)paramT1).getCreateTime()), (Comparable)Long.valueOf(-((HandOff)paramT2).getCreateTime()));
    AppMethodBeat.o(266171);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.c.e.e.a
 * JD-Core Version:    0.7.0.1
 */