package a.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"})
public final class z<T>
  implements a.f.b.a.a, Iterable<y<? extends T>>
{
  private final a.f.a.a<Iterator<T>> BMA;
  
  public z(a.f.a.a<? extends Iterator<? extends T>> parama)
  {
    AppMethodBeat.i(56067);
    this.BMA = parama;
    AppMethodBeat.o(56067);
  }
  
  public final Iterator<y<T>> iterator()
  {
    AppMethodBeat.i(56066);
    Iterator localIterator = (Iterator)new aa((Iterator)this.BMA.invoke());
    AppMethodBeat.o(56066);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.a.z
 * JD-Core Version:    0.7.0.1
 */