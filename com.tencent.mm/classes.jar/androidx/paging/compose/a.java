package androidx.paging.compose;

import androidx.compose.runtime.an;
import androidx.compose.runtime.bm;
import androidx.paging.av;
import androidx.paging.aw;
import androidx.paging.aw.a;
import androidx.paging.j;
import androidx.paging.n;
import androidx.paging.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlinx.coroutines.al;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cm;

@Metadata(d1={""}, d2={"Landroidx/paging/compose/LazyPagingItems;", "T", "", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "(Lkotlinx/coroutines/flow/Flow;)V", "differCallback", "Landroidx/paging/DifferCallback;", "itemCount", "", "getItemCount", "()I", "<set-?>", "Landroidx/paging/ItemSnapshotList;", "itemSnapshotList", "getItemSnapshotList", "()Landroidx/paging/ItemSnapshotList;", "setItemSnapshotList", "(Landroidx/paging/ItemSnapshotList;)V", "itemSnapshotList$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/paging/CombinedLoadStates;", "loadState", "getLoadState", "()Landroidx/paging/CombinedLoadStates;", "setLoadState", "(Landroidx/paging/CombinedLoadStates;)V", "loadState$delegate", "mainDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "pagingDataDiffer", "androidx/paging/compose/LazyPagingItems$pagingDataDiffer$1", "Landroidx/paging/compose/LazyPagingItems$pagingDataDiffer$1;", "collectLoadState", "", "collectLoadState$paging_compose_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectPagingData", "collectPagingData$paging_compose_release", "get", "index", "(I)Ljava/lang/Object;", "getAsState", "Landroidx/compose/runtime/State;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "peek", "refresh", "retry", "snapshot", "updateItemSnapshotList", "paging-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a<T>
{
  public static final int Ue = 8;
  final g<av<T>> bLH;
  private final n bQw;
  private final cm bRN;
  private final an bRO;
  final d bRP;
  private final an bRQ;
  
  public a(g<av<T>> paramg)
  {
    AppMethodBeat.i(197192);
    this.bLH = paramg;
    paramg = bg.ajvV;
    this.bRN = bg.kCh();
    this.bRO = androidx.compose.runtime.bj.T(new u(0, 0, (List)kotlin.a.ab.aivy));
    this.bQw = ((n)new c(this));
    this.bRP = new d(this, this.bQw, this.bRN);
    this.bRQ = androidx.compose.runtime.bj.T(new j(b.In().bLz, b.In().bLA, b.In().bLB, b.In()));
    AppMethodBeat.o(197192);
  }
  
  public final u<T> Il()
  {
    AppMethodBeat.i(197227);
    u localu = (u)((bm)this.bRO).getValue();
    AppMethodBeat.o(197227);
    return localu;
  }
  
  public final j Im()
  {
    AppMethodBeat.i(197238);
    j localj = (j)((bm)this.bRQ).getValue();
    AppMethodBeat.o(197238);
    return localj;
  }
  
  public final T fp(int paramInt)
  {
    AppMethodBeat.i(197233);
    Object localObject = Il().get(paramInt);
    AppMethodBeat.o(197233);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h<j>
  {
    public a(a parama) {}
    
    public final Object a(j paramj, d<? super ah> paramd)
    {
      AppMethodBeat.i(197181);
      paramj = (j)paramj;
      a.a(this.bRR, paramj);
      paramj = ah.aiuX;
      AppMethodBeat.o(197181);
      return paramj;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "", "it", "Landroidx/paging/PagingData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<av<T>, d<? super ah>, Object>
  {
    int label;
    
    b(a<T> parama, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(197187);
      paramd = new b(this.bRR, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(197187);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(197183);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(197183);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (av)this.L$0;
        Object localObject = a.a(this.bRR);
        d locald = (d)this;
        this.label = 1;
        localObject = androidx.paging.bj.a(((aw)localObject).bQr, (kotlin.g.a.b)new aw.a((aw)localObject, paramObject, null), locald);
        paramObject = localObject;
        if (localObject != kotlin.d.a.a.aiwj) {
          paramObject = ah.aiuX;
        }
        if (paramObject == locala)
        {
          AppMethodBeat.o(197183);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(197183);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/paging/compose/LazyPagingItems$differCallback$1", "Landroidx/paging/DifferCallback;", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "paging-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements n
  {
    c(a<T> parama) {}
    
    public final void fc(int paramInt)
    {
      AppMethodBeat.i(197178);
      if (paramInt > 0) {
        a.b(this.bRR);
      }
      AppMethodBeat.o(197178);
    }
    
    public final void fg(int paramInt)
    {
      AppMethodBeat.i(197182);
      if (paramInt > 0) {
        a.b(this.bRR);
      }
      AppMethodBeat.o(197182);
    }
    
    public final void fh(int paramInt)
    {
      AppMethodBeat.i(197186);
      if (paramInt > 0) {
        a.b(this.bRR);
      }
      AppMethodBeat.o(197186);
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/paging/compose/LazyPagingItems$pagingDataDiffer$1", "Landroidx/paging/PagingDataDiffer;", "presentNewList", "", "previousList", "Landroidx/paging/NullPaddedList;", "newList", "newCombinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "lastAccessedIndex", "onListPresentable", "Lkotlin/Function0;", "", "(Landroidx/paging/NullPaddedList;Landroidx/paging/NullPaddedList;Landroidx/paging/CombinedLoadStates;ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-compose_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends aw<T>
  {
    d(a<T> parama, n paramn, cm paramcm)
    {
      super((al)paramcm);
      AppMethodBeat.i(197176);
      AppMethodBeat.o(197176);
    }
    
    public final Object l(kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(197180);
      parama.invoke();
      a.b(this.bRR);
      AppMethodBeat.o(197180);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.compose.a
 * JD-Core Version:    0.7.0.1
 */