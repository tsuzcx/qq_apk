package a.k;

import a.f.a.b;
import a.f.b.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class f$a
  implements a, Iterator<E>
{
  private final Iterator<T> BMB;
  private Iterator<? extends E> CGr;
  
  f$a()
  {
    AppMethodBeat.i(55927);
    this.BMB = localObject.CGh.iterator();
    AppMethodBeat.o(55927);
  }
  
  private final boolean epj()
  {
    AppMethodBeat.i(55926);
    Object localObject = this.CGr;
    if ((localObject != null) && (!((Iterator)localObject).hasNext())) {
      this.CGr = null;
    }
    while (this.CGr == null)
    {
      if (!this.BMB.hasNext())
      {
        AppMethodBeat.o(55926);
        return false;
      }
      localObject = this.BMB.next();
      localObject = (Iterator)this.CGs.CGq.S(this.CGs.CGp.S(localObject));
      if (((Iterator)localObject).hasNext())
      {
        this.CGr = ((Iterator)localObject);
        AppMethodBeat.o(55926);
        return true;
      }
    }
    AppMethodBeat.o(55926);
    return true;
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55925);
    boolean bool = epj();
    AppMethodBeat.o(55925);
    return bool;
  }
  
  public final E next()
  {
    AppMethodBeat.i(55924);
    if (!epj())
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(55924);
      throw ((Throwable)localObject);
    }
    Object localObject = this.CGr;
    if (localObject == null) {
      j.ebi();
    }
    localObject = ((Iterator)localObject).next();
    AppMethodBeat.o(55924);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55928);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55928);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.k.f.a
 * JD-Core Version:    0.7.0.1
 */