package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.d.d;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlinx.coroutines.b.g;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/Pager;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "initialKey", "pagingSourceFactory", "Lkotlin/Function0;", "Landroidx/paging/PagingSource;", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)V", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Landroidx/paging/PagingConfig;Ljava/lang/Object;Landroidx/paging/RemoteMediator;Lkotlin/jvm/functions/Function0;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "paging-common"}, k=1, mv={1, 4, 2})
public final class at<Key, Value>
{
  public final g<av<Value>> bLH;
  
  private at(au paramau, Key paramKey, a<? extends ay<Key, Value>> parama)
  {
    AppMethodBeat.i(196671);
    if ((parama instanceof bl)) {}
    for (paramKey = (b)new a(parama);; paramKey = (b)new at.b(parama, null))
    {
      this.bLH = new ah(paramKey, null, paramau).bLH;
      AppMethodBeat.o(196671);
      return;
    }
  }
  
  private at(au paramau, a<? extends ay<Key, Value>> parama)
  {
    this(paramau, null, parama);
    AppMethodBeat.i(196678);
    AppMethodBeat.o(196678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.at
 * JD-Core Version:    0.7.0.1
 */