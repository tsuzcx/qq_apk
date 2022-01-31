package a.k;

import a.f.a.b;
import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class e$a
  implements a, Iterator<T>
{
  private final Iterator<T> BMB;
  private int CGm;
  private T CGn;
  
  e$a()
  {
    AppMethodBeat.i(55956);
    this.BMB = localObject.CGh.iterator();
    this.CGm = -1;
    AppMethodBeat.o(55956);
  }
  
  private final void epi()
  {
    AppMethodBeat.i(55953);
    while (this.BMB.hasNext())
    {
      Object localObject = this.BMB.next();
      if (((Boolean)this.CGo.CGl.S(localObject)).booleanValue() == this.CGo.CGk)
      {
        this.CGn = localObject;
        this.CGm = 1;
        AppMethodBeat.o(55953);
        return;
      }
    }
    this.CGm = 0;
    AppMethodBeat.o(55953);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55955);
    if (this.CGm == -1) {
      epi();
    }
    if (this.CGm == 1)
    {
      AppMethodBeat.o(55955);
      return true;
    }
    AppMethodBeat.o(55955);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(55954);
    if (this.CGm == -1) {
      epi();
    }
    if (this.CGm == 0)
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(55954);
      throw ((Throwable)localObject);
    }
    Object localObject = this.CGn;
    this.CGn = null;
    this.CGm = -1;
    AppMethodBeat.o(55954);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55957);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55957);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.k.e.a
 * JD-Core Version:    0.7.0.1
 */