package com.tencent.mm.media.widget.b;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.b.a;

@Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
public final class d$f<T>
  implements Comparator
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(237510);
    int i = a.b((Comparable)Integer.valueOf(((Size)paramT2).getWidth()), (Comparable)Integer.valueOf(((Size)paramT1).getWidth()));
    AppMethodBeat.o(237510);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.media.widget.b.d.f
 * JD-Core Version:    0.7.0.1
 */