package androidx.compose.foundation.lazy;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/IntervalList;", "T", "", "()V", "intervals", "", "Landroidx/compose/foundation/lazy/IntervalHolder;", "<set-?>", "", "totalSize", "getTotalSize$foundation_release", "()I", "add", "", "size", "content", "(ILjava/lang/Object;)V", "findIndexOfHighestValueLesserThan", "list", "", "value", "intervalForIndex", "index", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e<T>
{
  private final List<d<T>> aer;
  int aes;
  
  public e()
  {
    AppMethodBeat.i(204192);
    this.aer = ((List)new ArrayList());
    AppMethodBeat.o(204192);
  }
  
  private static int d(List<d<T>> paramList, int paramInt)
  {
    AppMethodBeat.i(204200);
    int i = 0;
    int j = p.oE(paramList);
    while (i < j)
    {
      int m = (i + j) / 2;
      int k = ((d)paramList.get(m)).startIndex;
      if (k == paramInt)
      {
        AppMethodBeat.o(204200);
        return m;
      }
      if (k < paramInt)
      {
        k = m + 1;
        i = k;
        if (paramInt < ((d)paramList.get(k)).startIndex)
        {
          AppMethodBeat.o(204200);
          return m;
        }
      }
      else
      {
        j = m - 1;
      }
    }
    AppMethodBeat.o(204200);
    return i;
  }
  
  public final void add(int paramInt, T paramT)
  {
    AppMethodBeat.i(204204);
    if (paramInt == 0)
    {
      AppMethodBeat.o(204204);
      return;
    }
    paramT = new d(this.aes, paramInt, paramT);
    this.aes += paramInt;
    this.aer.add(paramT);
    AppMethodBeat.o(204204);
  }
  
  public final d<T> bt(int paramInt)
  {
    AppMethodBeat.i(204209);
    if ((paramInt < 0) || (paramInt >= this.aes))
    {
      localObject = new IndexOutOfBoundsException("Index " + paramInt + ", size " + this.aes);
      AppMethodBeat.o(204209);
      throw ((Throwable)localObject);
    }
    Object localObject = (d)this.aer.get(d(this.aer, paramInt));
    AppMethodBeat.o(204209);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.e
 * JD-Core Version:    0.7.0.1
 */