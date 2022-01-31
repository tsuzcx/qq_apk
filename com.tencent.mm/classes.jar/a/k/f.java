package a.k;

import a.f.a.b;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
public final class f<T, R, E>
  implements h<E>
{
  final h<T> CGh;
  final b<T, R> CGp;
  final b<R, Iterator<E>> CGq;
  
  public f(h<? extends T> paramh, b<? super T, ? extends R> paramb, b<? super R, ? extends Iterator<? extends E>> paramb1)
  {
    AppMethodBeat.i(55931);
    this.CGh = paramh;
    this.CGp = paramb;
    this.CGq = paramb1;
    AppMethodBeat.o(55931);
  }
  
  public final Iterator<E> iterator()
  {
    AppMethodBeat.i(55930);
    Iterator localIterator = (Iterator)new f.a(this);
    AppMethodBeat.o(55930);
    return localIterator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.k.f
 * JD-Core Version:    0.7.0.1
 */