package a.j.b.a;

import a.b.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
public final class c$a$a<T>
  implements Comparator<T>
{
  public final int compare(T paramT1, T paramT2)
  {
    AppMethodBeat.i(118666);
    paramT1 = (Method)paramT1;
    j.p(paramT1, "it");
    paramT1 = (Comparable)paramT1.getName();
    paramT2 = (Method)paramT2;
    j.p(paramT2, "it");
    int i = a.a(paramT1, (Comparable)paramT2.getName());
    AppMethodBeat.o(118666);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */