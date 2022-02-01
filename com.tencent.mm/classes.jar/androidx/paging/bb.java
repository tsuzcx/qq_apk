package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediator;", "Key", "", "Value", "()V", "initialize", "Landroidx/paging/RemoteMediator$InitializeAction;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "Landroidx/paging/RemoteMediator$MediatorResult;", "loadType", "Landroidx/paging/LoadType;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/LoadType;Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "InitializeAction", "MediatorResult", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class bb<Key, Value>
{
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediator$InitializeAction;", "", "(Ljava/lang/String;I)V", "LAUNCH_INITIAL_REFRESH", "SKIP_INITIAL_REFRESH", "paging-common"}, k=1, mv={1, 4, 2})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(196771);
      a locala1 = new a("LAUNCH_INITIAL_REFRESH", 0);
      bQP = locala1;
      a locala2 = new a("SKIP_INITIAL_REFRESH", 1);
      bQQ = locala2;
      bQR = new a[] { locala1, locala2 };
      AppMethodBeat.o(196771);
    }
    
    private a() {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediator$MediatorResult;", "", "()V", "Error", "Success", "Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult$Success;", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class b
  {
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediator$MediatorResult$Error;", "Landroidx/paging/RemoteMediator$MediatorResult;", "throwable", "", "(Ljava/lang/Throwable;)V", "getThrowable", "()Ljava/lang/Throwable;", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a
      extends bb.b
    {}
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediator$MediatorResult$Success;", "Landroidx/paging/RemoteMediator$MediatorResult;", "endOfPaginationReached", "", "(Z)V", "()Z", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class b
      extends bb.b
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     androidx.paging.bb
 * JD-Core Version:    0.7.0.1
 */