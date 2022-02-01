package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedStorage;", "T", "", "Ljava/util/AbstractList;", "Landroidx/paging/LegacyPageFetcher$KeyProvider;", "Landroidx/paging/NullPaddedList;", "()V", "leadingNulls", "", "page", "Landroidx/paging/PagingSource$LoadResult$Page;", "trailingNulls", "(ILandroidx/paging/PagingSource$LoadResult$Page;I)V", "other", "(Landroidx/paging/PagedStorage;)V", "counted", "", "firstLoadedItem", "getFirstLoadedItem$paging_common", "()Ljava/lang/Object;", "value", "lastLoadAroundIndex", "getLastLoadAroundIndex", "()I", "setLastLoadAroundIndex", "(I)V", "lastLoadAroundLocalIndex", "lastLoadedItem", "getLastLoadedItem$paging_common", "middleOfLoadedRange", "getMiddleOfLoadedRange", "nextKey", "getNextKey", "pages", "", "<set-?>", "placeholdersAfter", "getPlaceholdersAfter", "placeholdersBefore", "getPlaceholdersBefore", "positionOffset", "getPositionOffset", "prevKey", "getPrevKey", "size", "getSize", "storageCount", "getStorageCount", "appendPage", "", "callback", "Landroidx/paging/PagedStorage$Callback;", "appendPage$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getFromStorage", "localIndex", "getRefreshKeyInfo", "Landroidx/paging/PagingState;", "config", "Landroidx/paging/PagedList$Config;", "init", "needsTrim", "maxSize", "requiredRemaining", "localPageIndex", "needsTrimFromEnd", "needsTrimFromFront", "prependPage", "prependPage$paging_common", "shouldPreTrimNewPage", "countToBeAdded", "snapshot", "toString", "", "traversePages", "V", "onLastPage", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pageInternalIndex", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "trimFromEnd", "insertNulls", "trimFromEnd$paging_common", "trimFromFront", "trimFromFront$paging_common", "Callback", "paging-common"}, k=1, mv={1, 4, 2})
public final class ar<T>
  extends AbstractList<T>
  implements v.a<Object>
{
  int bMw;
  int bMx;
  final List<ay.b.b<?, T>> bNN;
  private int bPX;
  private boolean bPY;
  int bPZ;
  private int bPz;
  
  public ar()
  {
    AppMethodBeat.i(196703);
    this.bNN = ((List)new ArrayList());
    this.bPY = true;
    AppMethodBeat.o(196703);
  }
  
  ar(ar<T> paramar)
  {
    AppMethodBeat.i(196710);
    this.bNN = ((List)new ArrayList());
    this.bPY = true;
    this.bNN.addAll((Collection)paramar.bNN);
    this.bMw = paramar.bMw;
    this.bMx = paramar.bMx;
    this.bPX = paramar.bPX;
    this.bPY = paramar.bPY;
    this.bPz = paramar.bPz;
    this.bPZ = paramar.bPZ;
    AppMethodBeat.o(196710);
  }
  
  private final void a(int paramInt1, ay.b.b<?, T> paramb, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(196689);
    this.bMw = paramInt1;
    this.bNN.clear();
    this.bNN.add(paramb);
    this.bMx = paramInt2;
    this.bPX = paramInt3;
    this.bPz = paramb.bMf.size();
    this.bPY = paramBoolean;
    this.bPZ = (paramb.bMf.size() / 2);
    AppMethodBeat.o(196689);
  }
  
  private T fl(int paramInt)
  {
    AppMethodBeat.i(196696);
    int k = this.bNN.size();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < k)
    {
      j = ((ay.b.b)this.bNN.get(paramInt)).bMf.size();
      if (j > i) {
        break;
      }
      i -= j;
      paramInt += 1;
    }
    Object localObject = ((ay.b.b)this.bNN.get(paramInt)).bMf.get(i);
    AppMethodBeat.o(196696);
    return localObject;
  }
  
  public final int Ie()
  {
    return this.bPz;
  }
  
  public final void a(int paramInt1, ay.b.b<?, T> paramb, int paramInt2, int paramInt3, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(196723);
    s.u(paramb, "page");
    s.u(parama, "callback");
    a(paramInt1, paramb, paramInt2, paramInt3, paramBoolean);
    parama.fd(size());
    AppMethodBeat.o(196723);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(196728);
    int i = paramInt - this.bMw;
    if ((paramInt < 0) || (paramInt >= size()))
    {
      localObject = (Throwable)new IndexOutOfBoundsException("Index: " + paramInt + ", Size: " + size());
      AppMethodBeat.o(196728);
      throw ((Throwable)localObject);
    }
    if ((i < 0) || (i >= this.bPz))
    {
      AppMethodBeat.o(196728);
      return null;
    }
    Object localObject = fl(i);
    AppMethodBeat.o(196728);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196742);
    String str = "leading " + this.bMw + ", storage " + this.bPz + ", trailing " + this.bMx + ' ' + p.a((Iterable)this.bNN, (CharSequence)" ", null, null, 0, null, null, 62);
    AppMethodBeat.o(196742);
    return str;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedStorage$Callback;", "", "onInitialized", "", "count", "", "onPageAppended", "endPosition", "changed", "added", "onPagePrepended", "leadingNulls", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract interface a
  {
    public abstract void fd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ar
 * JD-Core Version:    0.7.0.1
 */