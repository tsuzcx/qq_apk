package a.k;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
public final class b$a
  implements a, Iterator<T>
{
  private final Iterator<T> BMB;
  private int left;
  
  b$a()
  {
    AppMethodBeat.i(55963);
    this.BMB = localObject.CGh.iterator();
    this.left = localObject.count;
    AppMethodBeat.o(55963);
  }
  
  private final void drop()
  {
    AppMethodBeat.i(55960);
    while ((this.left > 0) && (this.BMB.hasNext()))
    {
      this.BMB.next();
      this.left -= 1;
    }
    AppMethodBeat.o(55960);
  }
  
  public final boolean hasNext()
  {
    AppMethodBeat.i(55962);
    drop();
    boolean bool = this.BMB.hasNext();
    AppMethodBeat.o(55962);
    return bool;
  }
  
  public final T next()
  {
    AppMethodBeat.i(55961);
    drop();
    Object localObject = this.BMB.next();
    AppMethodBeat.o(55961);
    return localObject;
  }
  
  public final void remove()
  {
    AppMethodBeat.i(55964);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(55964);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.k.b.a
 * JD-Core Version:    0.7.0.1
 */