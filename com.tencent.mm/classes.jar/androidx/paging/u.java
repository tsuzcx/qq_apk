package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.b;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ItemSnapshotList;", "T", "Lkotlin/collections/AbstractList;", "placeholdersBefore", "", "placeholdersAfter", "items", "", "(IILjava/util/List;)V", "getItems", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "size", "getSize", "get", "index", "(I)Ljava/lang/Object;", "paging-common"}, k=1, mv={1, 4, 2})
public final class u<T>
  extends b<T>
{
  private final List<T> bMQ;
  private final int bMw;
  private final int bMx;
  
  public u(int paramInt1, int paramInt2, List<? extends T> paramList)
  {
    AppMethodBeat.i(196978);
    this.bMw = paramInt1;
    this.bMx = paramInt2;
    this.bMQ = paramList;
    AppMethodBeat.o(196978);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(196995);
    int i = this.bMw;
    int j;
    int k;
    if (paramInt < 0)
    {
      i = this.bMw;
      j = this.bMw;
      k = this.bMQ.size();
      if (i <= paramInt) {
        break label128;
      }
      label40:
      i = this.bMw;
      j = this.bMQ.size();
      k = size();
      if (i + j <= paramInt) {
        break label161;
      }
    }
    label128:
    label161:
    while (k <= paramInt)
    {
      Object localObject = (Throwable)new IndexOutOfBoundsException("Illegal attempt to access index " + paramInt + " in ItemSnapshotList of size " + size());
      AppMethodBeat.o(196995);
      throw ((Throwable)localObject);
      if (i <= paramInt) {
        break;
      }
      AppMethodBeat.o(196995);
      return null;
      if (j + k <= paramInt) {
        break label40;
      }
      localObject = this.bMQ.get(paramInt - this.bMw);
      AppMethodBeat.o(196995);
      return localObject;
    }
    AppMethodBeat.o(196995);
    return null;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(196986);
    int i = this.bMw;
    int j = this.bMQ.size();
    int k = this.bMx;
    AppMethodBeat.o(196986);
    return i + j + k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.u
 * JD-Core Version:    0.7.0.1
 */