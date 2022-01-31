package a.k;

import a.f.a.a;
import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T>
  implements h<T>
{
  final a<T> CGt;
  final b<T, T> CGu;
  
  public g(a<? extends T> parama, b<? super T, ? extends T> paramb)
  {
    AppMethodBeat.i(55959);
    this.CGt = parama;
    this.CGu = paramb;
    AppMethodBeat.o(55959);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(55958);
    Iterator localIterator = (Iterator)new g.a(this);
    AppMethodBeat.o(55958);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.k.g
 * JD-Core Version:    0.7.0.1
 */