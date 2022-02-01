package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagingState;", "Key", "", "Value", "pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "anchorPosition", "", "config", "Landroidx/paging/PagingConfig;", "leadingPlaceholderCount", "(Ljava/util/List;Ljava/lang/Integer;Landroidx/paging/PagingConfig;I)V", "getAnchorPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getConfig", "()Landroidx/paging/PagingConfig;", "getPages", "()Ljava/util/List;", "anchorPositionToPagedIndices", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "pageIndex", "index", "anchorPositionToPagedIndices$paging_common", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "closestItemToPosition", "(I)Ljava/lang/Object;", "closestPageToPosition", "equals", "", "other", "firstItemOrNull", "()Ljava/lang/Object;", "hashCode", "isEmpty", "lastItemOrNull", "toString", "", "paging-common"}, k=1, mv={1, 4, 2})
public final class ba<Key, Value>
{
  final List<ay.b.b<Key, Value>> bNN;
  private final au bOe;
  final Integer bQN;
  final int bQO;
  
  public ba(List<ay.b.b<Key, Value>> paramList, Integer paramInteger, au paramau, int paramInt)
  {
    AppMethodBeat.i(197011);
    this.bNN = paramList;
    this.bQN = paramInteger;
    this.bOe = paramau;
    this.bQO = paramInt;
    AppMethodBeat.o(197011);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197014);
    if (((paramObject instanceof ba)) && (s.p(this.bNN, ((ba)paramObject).bNN)) && (s.p(this.bQN, ((ba)paramObject).bQN)) && (s.p(this.bOe, ((ba)paramObject).bOe)) && (this.bQO == ((ba)paramObject).bQO))
    {
      AppMethodBeat.o(197014);
      return true;
    }
    AppMethodBeat.o(197014);
    return false;
  }
  
  public final Value fo(int paramInt)
  {
    AppMethodBeat.i(197029);
    Object localObject1 = (Iterable)this.bNN;
    if ((!(localObject1 instanceof Collection)) || (!((Collection)localObject1).isEmpty()))
    {
      localObject1 = ((Iterable)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (((ay.b.b)((Iterator)localObject1).next()).bMf.isEmpty());
    }
    for (int i = 0; i != 0; i = 1)
    {
      AppMethodBeat.o(197029);
      return null;
    }
    i = paramInt - this.bQO;
    paramInt = 0;
    while ((paramInt < p.oE(this.bNN)) && (i > p.oE(((ay.b.b)this.bNN.get(paramInt)).bMf)))
    {
      i -= ((ay.b.b)this.bNN.get(paramInt)).bMf.size();
      paramInt += 1;
    }
    localObject1 = ((Iterable)this.bNN).iterator();
    Object localObject2;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (!((Collection)((ay.b.b)localObject2).bMf).isEmpty())
      {
        j = 1;
        label221:
        if (j == 0) {
          break label330;
        }
        localObject1 = (ay.b.b)localObject2;
        localObject2 = this.bNN;
        localObject2 = ((List)localObject2).listIterator(((List)localObject2).size());
      }
    }
    label330:
    label357:
    for (;;)
    {
      if (!((ListIterator)localObject2).hasPrevious()) {
        break label359;
      }
      Object localObject3 = ((ListIterator)localObject2).previous();
      if (!((Collection)((ay.b.b)localObject3).bMf).isEmpty()) {}
      for (j = 1;; j = 0)
      {
        if (j == 0) {
          break label357;
        }
        localObject2 = (ay.b.b)localObject3;
        if (i >= 0) {
          break label381;
        }
        localObject1 = p.oK(((ay.b.b)localObject1).bMf);
        AppMethodBeat.o(197029);
        return localObject1;
        j = 0;
        break label221;
        break;
        localObject1 = (Throwable)new NoSuchElementException("Collection contains no element matching the predicate.");
        AppMethodBeat.o(197029);
        throw ((Throwable)localObject1);
      }
    }
    label359:
    localObject1 = (Throwable)new NoSuchElementException("List contains no element matching the predicate.");
    AppMethodBeat.o(197029);
    throw ((Throwable)localObject1);
    label381:
    if ((paramInt == p.oE(this.bNN)) && (i > p.oE(((ay.b.b)p.oM(this.bNN)).bMf)))
    {
      localObject1 = p.oM(((ay.b.b)localObject2).bMf);
      AppMethodBeat.o(197029);
      return localObject1;
    }
    localObject1 = ((ay.b.b)this.bNN.get(paramInt)).bMf.get(i);
    AppMethodBeat.o(197029);
    return localObject1;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197020);
    int j = this.bNN.hashCode();
    Integer localInteger = this.bQN;
    if (localInteger != null) {}
    for (int i = localInteger.hashCode();; i = 0)
    {
      int k = this.bOe.hashCode();
      int m = this.bQO;
      AppMethodBeat.o(197020);
      return i + j + k + m;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197037);
    String str = "PagingState(pages=" + this.bNN + ", anchorPosition=" + this.bQN + ", config=" + this.bOe + ", leadingPlaceholderCount=" + this.bQO + ')';
    AppMethodBeat.o(197037);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ba
 * JD-Core Version:    0.7.0.1
 */