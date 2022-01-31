package a.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/comparisons/ReverseOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
public final class f
  implements Comparator<Comparable<? super Object>>
{
  public static final f BME;
  
  static
  {
    AppMethodBeat.i(56019);
    BME = new f();
    AppMethodBeat.o(56019);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)e.BMD;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.b.f
 * JD-Core Version:    0.7.0.1
 */