package a.k;

import a.f.a.b;
import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class p$a
  implements a, Iterator<R>
{
  private final Iterator<T> BMB;
  
  p$a()
  {
    AppMethodBeat.i(55968);
    this.BMB = localObject.CGh.iterator();
    AppMethodBeat.o(55968);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55967);
    boolean bool = this.BMB.hasNext();
    AppMethodBeat.o(55967);
    return bool;
  }
  
  public final R next()
  {
    AppMethodBeat.i(55966);
    Object localObject = this.CGE.CGp.S(this.BMB.next());
    AppMethodBeat.o(55966);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55969);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55969);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.k.p.a
 * JD-Core Version:    0.7.0.1
 */