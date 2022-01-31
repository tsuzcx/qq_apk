package a.a;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/collections/AbstractList$ListIteratorImpl;", "Lkotlin/collections/AbstractList$IteratorImpl;", "Lkotlin/collections/AbstractList;", "", "index", "", "(Lkotlin/collections/AbstractList;I)V", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "kotlin-stdlib"})
final class b$c
  extends b<E>.b
  implements a, ListIterator<E>
{
  public b$c(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(56179);
    b.a locala = b.BMk;
    int j = paramInt.size();
    int i;
    if ((i < 0) || (i > j))
    {
      paramInt = (Throwable)new IndexOutOfBoundsException("index: " + i + ", size: " + j);
      AppMethodBeat.o(56179);
      throw paramInt;
    }
    this.index = i;
    AppMethodBeat.o(56179);
  }
  
  public final void add(E paramE)
  {
    AppMethodBeat.i(56180);
    paramE = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56180);
    throw paramE;
  }
  
  public final boolean hasPrevious()
  {
    return this.index > 0;
  }
  
  public final int nextIndex()
  {
    return this.index;
  }
  
  public final E previous()
  {
    AppMethodBeat.i(56178);
    if (!hasPrevious())
    {
      localObject = (Throwable)new NoSuchElementException();
      AppMethodBeat.o(56178);
      throw ((Throwable)localObject);
    }
    Object localObject = this.BMl;
    this.index -= 1;
    localObject = ((b)localObject).get(this.index);
    AppMethodBeat.o(56178);
    return localObject;
  }
  
  public final int previousIndex()
  {
    return this.index - 1;
  }
  
  public final void set(E paramE)
  {
    AppMethodBeat.i(56181);
    paramE = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56181);
    throw paramE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.a.b.c
 * JD-Core Version:    0.7.0.1
 */