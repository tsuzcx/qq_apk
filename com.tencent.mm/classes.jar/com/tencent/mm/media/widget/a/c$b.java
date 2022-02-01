package com.tencent.mm.media.widget.a;

import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.b.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
public final class c$b<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(262185);
    int i = a.a((Comparable)Integer.valueOf(((Camera.Size)paramT2).width), (Comparable)Integer.valueOf(((Camera.Size)paramT1).width));
    AppMethodBeat.o(262185);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.widget.a.c.b
 * JD-Core Version:    0.7.0.1
 */