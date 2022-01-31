package a.f.b;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/jvm/internal/ArrayIterator;", "T", "", "array", "", "([Ljava/lang/Object;)V", "getArray", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "index", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
final class a<T>
  implements a.f.b.a.a, Iterator<T>
{
  private final T[] BNg;
  private int index;
  
  public a(T[] paramArrayOfT)
  {
    AppMethodBeat.i(56241);
    this.BNg = paramArrayOfT;
    AppMethodBeat.o(56241);
  }
  
  public final boolean hasNext()
  {
    return this.index < this.BNg.length;
  }
  
  public final T next()
  {
    AppMethodBeat.i(56240);
    try
    {
      Object localObject = this.BNg;
      int i = this.index;
      this.index = (i + 1);
      localObject = localObject[i];
      AppMethodBeat.o(56240);
      return localObject;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      Throwable localThrowable = (Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage());
      AppMethodBeat.o(56240);
      throw localThrowable;
    }
  }
  
  public final void remove()
  {
    AppMethodBeat.i(56242);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
    AppMethodBeat.o(56242);
    throw localUnsupportedOperationException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.f.b.a
 * JD-Core Version:    0.7.0.1
 */