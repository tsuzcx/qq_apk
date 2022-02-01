package androidx.compose.runtime.b.a.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime_release", "checkPositionIndex", "checkPositionIndex$runtime_release", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime_release", "orderedEquals", "", "c", "", "other", "orderedEquals$runtime_release", "orderedHashCode", "orderedHashCode$runtime_release", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c arp;
  
  static
  {
    AppMethodBeat.i(202732);
    arp = new c();
    AppMethodBeat.o(202732);
  }
  
  public static final void U(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202720);
    if ((paramInt1 < 0) || (paramInt1 >= paramInt2))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2);
      AppMethodBeat.o(202720);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(202720);
  }
  
  public static final void V(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202724);
    if ((paramInt1 < 0) || (paramInt1 > paramInt2))
    {
      IndexOutOfBoundsException localIndexOutOfBoundsException = new IndexOutOfBoundsException("index: " + paramInt1 + ", size: " + paramInt2);
      AppMethodBeat.o(202724);
      throw localIndexOutOfBoundsException;
    }
    AppMethodBeat.o(202724);
  }
  
  public static final void m(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(202730);
    Object localObject;
    if ((paramInt1 < 0) || (paramInt2 > paramInt3))
    {
      localObject = new IndexOutOfBoundsException("fromIndex: " + paramInt1 + ", toIndex: " + paramInt2 + ", size: " + paramInt3);
      AppMethodBeat.o(202730);
      throw ((Throwable)localObject);
    }
    if (paramInt1 > paramInt2)
    {
      localObject = new IllegalArgumentException("fromIndex: " + paramInt1 + " > toIndex: " + paramInt2);
      AppMethodBeat.o(202730);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(202730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.b.a.a.a.b.c
 * JD-Core Version:    0.7.0.1
 */