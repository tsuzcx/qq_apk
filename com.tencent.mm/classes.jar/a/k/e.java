package a.k;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T>
  implements h<T>
{
  final h<T> CGh;
  final boolean CGk;
  final b<T, Boolean> CGl;
  
  public e(h<? extends T> paramh, boolean paramBoolean, b<? super T, Boolean> paramb)
  {
    AppMethodBeat.i(55923);
    this.CGh = paramh;
    this.CGk = paramBoolean;
    this.CGl = paramb;
    AppMethodBeat.o(55923);
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(55922);
    Iterator localIterator = (Iterator)new e.a(this);
    AppMethodBeat.o(55922);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.k.e
 * JD-Core Version:    0.7.0.1
 */