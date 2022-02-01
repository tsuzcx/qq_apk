package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.j;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ContiguousPagedList;", "K", "", "V", "Landroidx/paging/PagedList;", "Landroidx/paging/PagedStorage$Callback;", "Landroidx/paging/LegacyPageFetcher$PageConsumer;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "backgroundDispatcher", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "config", "Landroidx/paging/PagedList$Config;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "initialLastKey", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedList$BoundaryCallback;Landroidx/paging/PagedList$Config;Landroidx/paging/PagingSource$LoadResult$Page;Ljava/lang/Object;)V", "appendItemsRequested", "", "getBoundaryCallback$paging_common", "()Landroidx/paging/PagedList$BoundaryCallback;", "boundaryCallbackBeginDeferred", "", "boundaryCallbackEndDeferred", "highestIndexAccessed", "Ljava/lang/Object;", "isDetached", "()Z", "lastKey", "getLastKey$annotations", "()V", "getLastKey", "()Ljava/lang/Object;", "lowestIndexAccessed", "pager", "Landroidx/paging/LegacyPageFetcher;", "getPager$annotations", "getPagingSource", "()Landroidx/paging/PagingSource;", "prependItemsRequested", "replacePagesWithNulls", "shouldTrim", "deferBoundaryCallbacks", "", "deferEmpty", "deferBegin", "deferEnd", "deferBoundaryCallbacks$paging_common", "detach", "dispatchBoundaryCallbacks", "begin", "end", "dispatchCurrentLoadState", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "loadAroundInternal", "index", "onInitialized", "count", "onPageAppended", "endPosition", "changed", "added", "onPagePrepended", "leadingNulls", "onPageResult", "type", "page", "onPagesRemoved", "startOfDrops", "onPagesSwappedToPlaceholder", "onStateChanged", "state", "retry", "setInitialLoadState", "loadType", "loadState", "triggerBoundaryCallback", "", "tryDispatchBoundaryCallbacks", "post", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
public final class l<K, V>
  extends ap<V>
  implements ar.a, v.b<V>
{
  public static final l.a bLU;
  private boolean bLK;
  private boolean bLL;
  private int bLM;
  private int bLN;
  private boolean bLO;
  private final boolean bLP;
  private final v<K, V> bLQ;
  private final ay<K, V> bLR;
  final ap.a<V> bLS;
  private final K bLT;
  
  static
  {
    AppMethodBeat.i(197107);
    bLU = new l.a((byte)0);
    AppMethodBeat.o(197107);
  }
  
  public l(ay<K, V> paramay, aq paramaq, al paramal1, al paramal2, ap.a<V> parama, ap.e parame, ay.b.b<K, V> paramb, K paramK)
  {
    super(paramay, paramaq, paramal1, new ar(), parame);
    AppMethodBeat.i(197102);
    this.bLR = paramay;
    this.bLS = parama;
    this.bLT = paramK;
    this.bLM = 2147483647;
    this.bLN = -2147483648;
    if (parame.maxSize != 2147483647) {}
    for (final boolean bool1 = true;; bool1 = false)
    {
      this.bLP = bool1;
      paramay = this.bLR;
      parama = (v.b)this;
      paramK = Ia();
      if (paramK != null) {
        break;
      }
      paramay = new NullPointerException("null cannot be cast to non-null type androidx.paging.LegacyPageFetcher.KeyProvider<K>");
      AppMethodBeat.o(197102);
      throw paramay;
    }
    this.bLQ = new v(paramaq, parame, paramay, paramal1, paramal2, parama, (v.a)paramK);
    int i;
    int j;
    label225:
    label253:
    final boolean bool2;
    if (parame.bPM)
    {
      paramay = Ia();
      if (paramb.bMi != -2147483648)
      {
        i = paramb.bMi;
        if (paramb.bMj == -2147483648) {
          break label378;
        }
        j = paramb.bMj;
        paramaq = (ar.a)this;
        if ((paramb.bMi == -2147483648) || (paramb.bMj == -2147483648)) {
          break label384;
        }
        bool1 = true;
        paramay.a(i, paramb, j, 0, paramaq, bool1);
        paramay = ad.bNC;
        paramaq = paramb.bMf;
        if (this.bLS == null) {
          break label538;
        }
        if (Ia().size() != 0) {
          break label436;
        }
        bool1 = true;
        label297:
        if ((bool1) || (paramay != ad.bND) || (!paramaq.isEmpty())) {
          break label442;
        }
        bool2 = true;
        label321:
        if ((bool1) || (paramay != ad.bNE) || (!paramaq.isEmpty())) {
          break label448;
        }
      }
    }
    label384:
    label436:
    label442:
    label448:
    for (final boolean bool3 = true;; bool3 = false)
    {
      if (this.bLS != null) {
        break label454;
      }
      paramay = (Throwable)new IllegalStateException("Can't defer BoundaryCallback, no instance");
      AppMethodBeat.o(197102);
      throw paramay;
      i = 0;
      break;
      label378:
      j = 0;
      break label225;
      bool1 = false;
      break label253;
      paramay = Ia();
      if (paramb.bMi != -2147483648) {}
      for (i = paramb.bMi;; i = 0)
      {
        paramay.a(0, paramb, 0, i, (ar.a)this, false);
        break;
      }
      bool1 = false;
      break label297;
      bool2 = false;
      break label321;
    }
    label454:
    if (this.bLM == 2147483647) {
      this.bLM = Ia().size();
    }
    if (this.bLN == -2147483648) {
      this.bLN = 0;
    }
    if ((bool1) || (bool2) || (bool3)) {
      j.a(HY(), (f)HZ(), null, (m)new b(this, bool1, bool2, bool3, null), 2);
    }
    label538:
    AppMethodBeat.o(197102);
  }
  
  public final K HF()
  {
    AppMethodBeat.i(197131);
    Object localObject1 = Ia();
    Object localObject2 = Ib();
    s.u(localObject2, "config");
    if (((ar)localObject1).bNN.isEmpty()) {}
    List localList;
    for (localObject1 = null;; localObject1 = new ba(localList, Integer.valueOf(((ar)localObject1).bMw + ((ar)localObject1).bPZ), new au(((ap.e)localObject2).pageSize, ((ap.e)localObject2).bPL, ((ap.e)localObject2).bPM, ((ap.e)localObject2).bPN, ((ap.e)localObject2).maxSize, 0, 32), ((ar)localObject1).bMw))
    {
      if (localObject1 != null)
      {
        localObject2 = this.bLR.a((ba)localObject1);
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = this.bLT;
      }
      AppMethodBeat.o(197131);
      return localObject1;
      localList = p.p((Iterable)((ar)localObject1).bNN);
      if (localList == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.paging.PagingSource.LoadResult.Page<kotlin.Any, T>>");
        AppMethodBeat.o(197131);
        throw ((Throwable)localObject1);
      }
    }
  }
  
  public final ay<K, V> HG()
  {
    return this.bLR;
  }
  
  public final void fd(int paramInt)
  {
    AppMethodBeat.i(197141);
    fn(paramInt);
    if ((Ia().bMw > 0) || (Ia().bMx > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      this.bLO = bool;
      AppMethodBeat.o(197141);
      return;
    }
  }
  
  public final boolean isDetached()
  {
    AppMethodBeat.i(197134);
    boolean bool = this.bLQ.bMR.get();
    AppMethodBeat.o(197134);
    return bool;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "K", "", "V", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(l paraml, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196587);
      s.u(paramd, "completion");
      paramObject = new b(this.bLV, bool1, bool2, bool3, paramd);
      AppMethodBeat.o(196587);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196595);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196595);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196581);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196581);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (bool1) {
        this.bLV.bLS.Ic();
      }
      if (bool2) {
        l.a(this.bLV);
      }
      if (bool3) {
        l.b(this.bLV);
      }
      l.c(this.bLV);
      paramObject = ah.aiuX;
      AppMethodBeat.o(196581);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.l
 * JD-Core Version:    0.7.0.1
 */