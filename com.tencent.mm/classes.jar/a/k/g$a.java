package a.k;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class g$a
  implements a.f.b.a.a, Iterator<T>
{
  private int CGm = -2;
  private T CGn;
  
  private final void epi()
  {
    AppMethodBeat.i(55932);
    Object localObject1;
    if (this.CGm == -2)
    {
      localObject1 = this.CGv.CGt.invoke();
      this.CGn = localObject1;
      if (this.CGn != null) {
        break label83;
      }
    }
    label83:
    for (int i = 0;; i = 1)
    {
      this.CGm = i;
      AppMethodBeat.o(55932);
      return;
      localObject1 = this.CGv.CGu;
      Object localObject2 = this.CGn;
      if (localObject2 == null) {
        j.ebi();
      }
      localObject1 = ((b)localObject1).S(localObject2);
      break;
    }
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55934);
    if (this.CGm < 0) {
      epi();
    }
    if (this.CGm == 1)
    {
      AppMethodBeat.o(55934);
      return true;
    }
    AppMethodBeat.o(55934);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(55933);
    if (this.CGm < 0) {
      epi();
    }
    if (this.CGm == 0)
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(55933);
      throw ((Throwable)localObject);
    }
    Object localObject = this.CGn;
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type T");
      AppMethodBeat.o(55933);
      throw ((Throwable)localObject);
    }
    this.CGm = -1;
    AppMethodBeat.o(55933);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55935);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55935);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.k.g.a
 * JD-Core Version:    0.7.0.1
 */