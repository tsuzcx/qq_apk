package androidx.compose.runtime.b.a.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/BufferIterator;", "T", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractListIterator;", "buffer", "", "index", "", "size", "([Ljava/lang/Object;II)V", "[Ljava/lang/Object;", "next", "()Ljava/lang/Object;", "previous", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c<T>
  extends a<T>
{
  private final T[] buffer;
  
  public c(T[] paramArrayOfT, int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(202852);
    this.buffer = paramArrayOfT;
    AppMethodBeat.o(202852);
  }
  
  public final T next()
  {
    AppMethodBeat.i(202859);
    if (!hasNext())
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(202859);
      throw ((Throwable)localObject);
    }
    Object localObject = this.buffer;
    int i = getIndex();
    setIndex(i + 1);
    localObject = localObject[i];
    AppMethodBeat.o(202859);
    return localObject;
  }
  
  public final T previous()
  {
    AppMethodBeat.i(202868);
    if (!hasPrevious())
    {
      localObject = new NoSuchElementException();
      AppMethodBeat.o(202868);
      throw ((Throwable)localObject);
    }
    Object localObject = this.buffer;
    setIndex(getIndex() - 1);
    localObject = localObject[getIndex()];
    AppMethodBeat.o(202868);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */