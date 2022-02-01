package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/SnapshotPagedList;", "T", "", "Landroidx/paging/PagedList;", "pagedList", "(Landroidx/paging/PagedList;)V", "isDetached", "", "()Z", "isImmutable", "lastKey", "getLastKey", "()Ljava/lang/Object;", "detach", "", "dispatchCurrentLoadState", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "loadAroundInternal", "index", "", "paging-common"}, k=1, mv={1, 4, 2})
public final class bk<T>
  extends ap<T>
{
  private final boolean bRu;
  private final boolean bRv;
  private final ap<T> bRw;
  
  public bk(ap<T> paramap)
  {
    super(paramap.HG(), paramap.HY(), paramap.HZ(), new ar(paramap.Ia()), paramap.Ib());
    AppMethodBeat.i(196984);
    this.bRw = paramap;
    this.bRu = true;
    this.bRv = true;
    AppMethodBeat.o(196984);
  }
  
  public final Object HF()
  {
    AppMethodBeat.i(196996);
    Object localObject = this.bRw.HF();
    AppMethodBeat.o(196996);
    return localObject;
  }
  
  public final boolean isDetached()
  {
    return this.bRv;
  }
  
  public final boolean isImmutable()
  {
    return this.bRu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bk
 * JD-Core Version:    0.7.0.1
 */