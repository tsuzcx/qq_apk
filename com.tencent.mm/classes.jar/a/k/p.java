package a.k;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"})
public final class p<T, R>
  implements h<R>
{
  public final h<T> CGh;
  public final b<T, R> CGp;
  
  public p(h<? extends T> paramh, b<? super T, ? extends R> paramb)
  {
    AppMethodBeat.i(55937);
    this.CGh = paramh;
    this.CGp = paramb;
    AppMethodBeat.o(55937);
  }
  
  public final Iterator<R> iterator()
  {
    AppMethodBeat.i(55936);
    Iterator localIterator = (Iterator)new p.a(this);
    AppMethodBeat.o(55936);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.k.p
 * JD-Core Version:    0.7.0.1
 */