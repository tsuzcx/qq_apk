package a.k;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class o<T>
  implements h<T>
{
  final h<T> CGh;
  final b<T, Boolean> CGl;
  
  public o(h<? extends T> paramh, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(55976);
    this.CGh = paramh;
    this.CGl = paramb;
    AppMethodBeat.o(55976);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(55975);
    Iterator localIterator = (Iterator)new o.a(this);
    AppMethodBeat.o(55975);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.k.o
 * JD-Core Version:    0.7.0.1
 */