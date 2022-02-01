package com.tencent.mm.plugin.finder.preload.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.w;
import d.b.a;
import d.l;
import java.util.Comparator;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class a$d<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(202630);
    int i = a.a((Comparable)((w)paramT1).field_fileFormat, (Comparable)((w)paramT2).field_fileFormat);
    AppMethodBeat.o(202630);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.model.a.d
 * JD-Core Version:    0.7.0.1
 */