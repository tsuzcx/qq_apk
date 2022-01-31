package a.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", "", "", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "reversed", "kotlin-stdlib"})
final class e
  implements Comparator<Comparable<? super Object>>
{
  public static final e BMD;
  
  static
  {
    AppMethodBeat.i(56017);
    BMD = new e();
    AppMethodBeat.o(56017);
  }
  
  public final Comparator<Comparable<Object>> reversed()
  {
    return (Comparator)f.BME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.b.e
 * JD-Core Version:    0.7.0.1
 */