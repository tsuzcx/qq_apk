package com.tencent.mm.media.widget.b;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class d$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(259239);
    paramT2 = (Size)paramT2;
    p.j(paramT2, "it");
    paramT2 = (Comparable)Integer.valueOf(paramT2.getWidth());
    paramT1 = (Size)paramT1;
    p.j(paramT1, "it");
    int i = a.a(paramT2, (Comparable)Integer.valueOf(paramT1.getWidth()));
    AppMethodBeat.o(259239);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.a
 * JD-Core Version:    0.7.0.1
 */