package a.a;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractList$IteratorImpl;", "", "(Lkotlin/collections/AbstractList;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
class b$b
  implements a, Iterator<E>
{
  int index;
  
  public boolean hasNext()
  {
    AppMethodBeat.i(56068);
    if (this.index < this.BMl.size())
    {
      AppMethodBeat.o(56068);
      return true;
    }
    AppMethodBeat.o(56068);
    return false;
  }
  
  public E next()
  {
    AppMethodBeat.i(56069);
    if (!hasNext())
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(56069);
      throw ((Throwable)localObject);
    }
    Object localObject = this.BMl;
    int i = this.index;
    this.index = (i + 1);
    localObject = ((b)localObject).get(i);
    AppMethodBeat.o(56069);
    return localObject;
  }
  
  public void remove()
  {
    AppMethodBeat.i(56070);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56070);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.b.b
 * JD-Core Version:    0.7.0.1
 */