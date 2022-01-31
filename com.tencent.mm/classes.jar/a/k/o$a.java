package a.k;

import a.f.a.b;
import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class o$a
  implements a, Iterator<T>
{
  private final Iterator<T> BMB;
  private int CGm;
  private T CGn;
  
  o$a()
  {
    AppMethodBeat.i(55917);
    this.BMB = localObject.CGh.iterator();
    this.CGm = -1;
    AppMethodBeat.o(55917);
  }
  
  private final void epi()
  {
    AppMethodBeat.i(55914);
    if (this.BMB.hasNext())
    {
      Object localObject = this.BMB.next();
      if (((Boolean)this.CGD.CGl.S(localObject)).booleanValue())
      {
        this.CGm = 1;
        this.CGn = localObject;
        AppMethodBeat.o(55914);
        return;
      }
    }
    this.CGm = 0;
    AppMethodBeat.o(55914);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55916);
    if (this.CGm == -1) {
      epi();
    }
    if (this.CGm == 1)
    {
      AppMethodBeat.o(55916);
      return true;
    }
    AppMethodBeat.o(55916);
    return false;
  }
  
  public final T next()
  {
    AppMethodBeat.i(55915);
    if (this.CGm == -1) {
      epi();
    }
    if (this.CGm == 0)
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(55915);
      throw ((Throwable)localObject);
    }
    Object localObject = this.CGn;
    this.CGn = null;
    this.CGm = -1;
    AppMethodBeat.o(55915);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55918);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55918);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.k.o.a
 * JD-Core Version:    0.7.0.1
 */