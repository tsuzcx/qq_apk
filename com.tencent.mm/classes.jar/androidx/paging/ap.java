package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bt;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cm;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList;", "T", "", "Ljava/util/AbstractList;", "pagingSource", "Landroidx/paging/PagingSource;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "notifyDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "storage", "Landroidx/paging/PagedStorage;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/PagingSource;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/CoroutineDispatcher;Landroidx/paging/PagedStorage;Landroidx/paging/PagedList$Config;)V", "callbacks", "", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "getConfig", "()Landroidx/paging/PagedList$Config;", "getCoroutineScope$paging_common", "()Lkotlinx/coroutines/CoroutineScope;", "dataSource", "Landroidx/paging/DataSource;", "getDataSource$annotations", "()V", "getDataSource", "()Landroidx/paging/DataSource;", "isDetached", "", "()Z", "isImmutable", "lastKey", "getLastKey", "()Ljava/lang/Object;", "loadStateListeners", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "Landroidx/paging/LoadState;", "", "loadedCount", "", "getLoadedCount", "()I", "getNotifyDispatcher$paging_common", "()Lkotlinx/coroutines/CoroutineDispatcher;", "getPagingSource", "()Landroidx/paging/PagingSource;", "positionOffset", "getPositionOffset", "refreshRetryCallback", "Ljava/lang/Runnable;", "getRefreshRetryCallback$paging_common", "()Ljava/lang/Runnable;", "setRefreshRetryCallback$paging_common", "(Ljava/lang/Runnable;)V", "requiredRemainder", "getRequiredRemainder$paging_common", "size", "getSize", "getStorage$paging_common", "()Landroidx/paging/PagedStorage;", "addWeakCallback", "callback", "previousSnapshot", "", "addWeakLoadStateListener", "listener", "detach", "dispatchCurrentLoadState", "dispatchStateChangeAsync", "type", "state", "dispatchStateChangeAsync$paging_common", "get", "index", "(I)Ljava/lang/Object;", "getNullPaddedList", "Landroidx/paging/NullPaddedList;", "lastLoad", "loadAround", "loadAroundInternal", "notifyChanged", "position", "count", "notifyInserted", "notifyInserted$paging_common", "notifyRemoved", "removeWeakCallback", "removeWeakLoadStateListener", "retry", "setInitialLoadState", "loadType", "loadState", "setRetryCallback", "snapshot", "BoundaryCallback", "Builder", "Callback", "Companion", "Config", "LoadStateManager", "paging-common"}, k=1, mv={1, 4, 2})
public abstract class ap<T>
  extends AbstractList<T>
{
  public static final ap.d bPH = new ap.d((byte)0);
  private final ay<?, T> bLR;
  private final e bMU;
  private final al bMW;
  private final int bPD;
  private final List<WeakReference<c>> bPE;
  private final List<WeakReference<kotlin.g.a.m<ad, aa, ah>>> bPF;
  private final ar<T> bPG;
  private final aq coroutineScope;
  
  public ap(ay<?, T> paramay, aq paramaq, al paramal, ar<T> paramar, e parame)
  {
    this.bLR = paramay;
    this.coroutineScope = paramaq;
    this.bMW = paramal;
    this.bPG = paramar;
    this.bMU = parame;
    this.bPD = (this.bMU.bPL * 2 + this.bMU.pageSize);
    this.bPE = ((List)new ArrayList());
    this.bPF = ((List)new ArrayList());
  }
  
  public abstract Object HF();
  
  public ay<?, T> HG()
  {
    return this.bLR;
  }
  
  public final List<T> HX()
  {
    if (isImmutable()) {
      return (List)this;
    }
    return (List)new bk(this);
  }
  
  public final aq HY()
  {
    return this.coroutineScope;
  }
  
  public final al HZ()
  {
    return this.bMW;
  }
  
  public final ar<T> Ia()
  {
    return this.bPG;
  }
  
  public final e Ib()
  {
    return this.bMU;
  }
  
  public final void a(c paramc)
  {
    s.u(paramc, "callback");
    kotlin.a.p.e(this.bPE, (b)new h(paramc));
  }
  
  public final void a(List<? extends T> paramList, c paramc)
  {
    s.u(paramc, "callback");
    int i;
    int j;
    if ((paramList != null) && (paramList != (ap)this))
    {
      i = size();
      j = paramList.size();
      s.u(paramc, "callback");
      if (j >= i) {
        break label109;
      }
      if (j > 0) {
        paramc.fc(j);
      }
      i -= j;
      if (i > 0) {
        paramc.aR(j, i);
      }
    }
    for (;;)
    {
      s.u(paramc, "callback");
      kotlin.a.p.e(this.bPE, (b)ap.g.bPT);
      this.bPE.add(new WeakReference(paramc));
      return;
      label109:
      if (i > 0) {
        paramc.fc(i);
      }
      j -= i;
      if (j != 0) {
        paramc.aS(i, j);
      }
    }
  }
  
  public final void fn(int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return;
      Iterator localIterator = ((Iterable)kotlin.a.p.m((Iterable)this.bPE)).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)((WeakReference)localIterator.next()).get();
        if (localc != null) {
          localc.aR(0, paramInt);
        }
      }
    }
  }
  
  public T get(int paramInt)
  {
    return this.bPG.get(paramInt);
  }
  
  public abstract boolean isDetached();
  
  public boolean isImmutable()
  {
    return isDetached();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$BoundaryCallback;", "T", "", "()V", "onItemAtEndLoaded", "", "itemAtEnd", "(Ljava/lang/Object;)V", "onItemAtFrontLoaded", "itemAtFront", "onZeroItemsLoaded", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class a<T>
  {
    public void Ic() {}
    
    public void aQ(T paramT)
    {
      s.u(paramT, "itemAtFront");
    }
    
    public void aR(T paramT)
    {
      s.u(paramT, "itemAtEnd");
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$Builder;", "Key", "", "Value", "dataSource", "Landroidx/paging/DataSource;", "config", "Landroidx/paging/PagedList$Config;", "(Landroidx/paging/DataSource;Landroidx/paging/PagedList$Config;)V", "pageSize", "", "(Landroidx/paging/DataSource;I)V", "pagingSource", "Landroidx/paging/PagingSource;", "initialPage", "Landroidx/paging/PagingSource$LoadResult$Page;", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;Landroidx/paging/PagedList$Config;)V", "(Landroidx/paging/PagingSource;Landroidx/paging/PagingSource$LoadResult$Page;I)V", "boundaryCallback", "Landroidx/paging/PagedList$BoundaryCallback;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "fetchDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initialKey", "Ljava/lang/Object;", "notifyDispatcher", "build", "Landroidx/paging/PagedList;", "setBoundaryCallback", "setCoroutineScope", "setFetchDispatcher", "setFetchExecutor", "fetchExecutor", "Ljava/util/concurrent/Executor;", "setInitialKey", "(Ljava/lang/Object;)Landroidx/paging/PagedList$Builder;", "setNotifyDispatcher", "setNotifyExecutor", "notifyExecutor", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class b<Key, Value>
  {
    private final ay<Key, Value> bLR;
    private ap.a<Value> bLS;
    private final ap.e bMU;
    private al bMW;
    private al bMX;
    private m<Key, Value> bNb;
    private Key bOd;
    private final ay.b.b<Key, Value> bPI;
    private aq coroutineScope;
    
    public b(m<Key, Value> paramm, ap.e parame)
    {
      AppMethodBeat.i(196833);
      this.coroutineScope = ((aq)bu.ajwo);
      this.bLR = null;
      this.bNb = paramm;
      this.bPI = null;
      this.bMU = parame;
      AppMethodBeat.o(196833);
    }
    
    public final ap<Value> Id()
    {
      AppMethodBeat.i(196862);
      Object localObject2 = this.bMX;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = bg.kCi();
      }
      Object localObject3 = this.bLR;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = this.bNb;
        if (localObject2 != null)
        {
          localObject2 = new w((al)localObject1, (m)localObject2);
          ((w)localObject2).fi(this.bMU.pageSize);
          localObject2 = (ay)localObject2;
        }
      }
      else
      {
        if (localObject2 == null) {
          break label107;
        }
      }
      label107:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label112;
        }
        localObject1 = (Throwable)new IllegalStateException("PagedList cannot be built without a PagingSource or DataSource".toString());
        AppMethodBeat.o(196862);
        throw ((Throwable)localObject1);
        localObject2 = null;
        break;
      }
      label112:
      localObject3 = ap.bPH;
      Object localObject4 = this.bPI;
      aq localaq = this.coroutineScope;
      Object localObject5 = this.bMW;
      localObject3 = localObject5;
      if (localObject5 == null) {
        localObject3 = (al)bg.kCh().kCK();
      }
      localObject5 = this.bLS;
      ap.e locale = this.bMU;
      Object localObject6 = this.bOd;
      s.u(localObject2, "pagingSource");
      s.u(localaq, "coroutineScope");
      s.u(localObject3, "notifyDispatcher");
      s.u(localObject1, "fetchDispatcher");
      s.u(locale, "config");
      if (localObject4 == null)
      {
        localObject4 = new ah.f();
        ((ah.f)localObject4).aqH = new ay.a.d(localObject6, locale.bPN, locale.bPM);
        localObject4 = (ay.b.b)kotlinx.coroutines.k.x((kotlin.g.a.m)new ap.d.a((ay)localObject2, (ah.f)localObject4, null));
      }
      for (;;)
      {
        localObject1 = (ap)new l((ay)localObject2, localaq, (al)localObject3, (al)localObject1, (ap.a)localObject5, locale, (ay.b.b)localObject4, localObject6);
        AppMethodBeat.o(196862);
        return localObject1;
      }
    }
    
    public final b<Key, Value> a(ap.a<Value> parama)
    {
      ((b)this).bLS = parama;
      return (b)this;
    }
    
    public final b<Key, Value> aS(Key paramKey)
    {
      ((b)this).bOd = paramKey;
      return (b)this;
    }
    
    public final b<Key, Value> e(Executor paramExecutor)
    {
      AppMethodBeat.i(196839);
      s.u(paramExecutor, "notifyExecutor");
      ((b)this).bMW = bt.g(paramExecutor);
      paramExecutor = (b)this;
      AppMethodBeat.o(196839);
      return paramExecutor;
    }
    
    public final b<Key, Value> f(Executor paramExecutor)
    {
      AppMethodBeat.i(196848);
      s.u(paramExecutor, "fetchExecutor");
      ((b)this).bMX = bt.g(paramExecutor);
      paramExecutor = (b)this;
      AppMethodBeat.o(196848);
      return paramExecutor;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$Callback;", "", "()V", "onChanged", "", "position", "", "count", "onInserted", "onRemoved", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class c
  {
    public abstract void aR(int paramInt1, int paramInt2);
    
    public abstract void aS(int paramInt1, int paramInt2);
    
    public abstract void fc(int paramInt);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroidx/paging/PagingSource$LoadResult$Page;", "K", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class d$a
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ay.b.b<K, T>>, Object>
  {
    int label;
    
    d$a(ay paramay, ah.f paramf, d paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(196891);
      s.u(paramd, "completion");
      paramObject = new a(this.bPJ, this.bPK, paramd);
      AppMethodBeat.o(196891);
      return paramObject;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196895);
      paramObject1 = ((a)create(paramObject1, (d)paramObject2)).invokeSuspend(ah.aiuX);
      AppMethodBeat.o(196895);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196882);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196882);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.bPJ;
        Object localObject = (ay.a)this.bPK.aqH;
        this.label = 1;
        localObject = paramObject.a((ay.a)localObject, this);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(196882);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = (ay.b)paramObject;
      if ((paramObject instanceof ay.b.b))
      {
        paramObject = (ay.b.b)paramObject;
        AppMethodBeat.o(196882);
        return paramObject;
      }
      if ((paramObject instanceof ay.b.a))
      {
        AppMethodBeat.o(196882);
        throw null;
      }
      paramObject = new kotlin.p();
      AppMethodBeat.o(196882);
      throw paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$Config;", "", "pageSize", "", "prefetchDistance", "enablePlaceholders", "", "initialLoadSizeHint", "maxSize", "(IIZII)V", "Builder", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
  public static final class e
  {
    public static final ap.e.b bPO;
    public final int bPL;
    public final boolean bPM;
    public final int bPN;
    public final int maxSize;
    public final int pageSize;
    
    static
    {
      AppMethodBeat.i(196864);
      bPO = new ap.e.b((byte)0);
      AppMethodBeat.o(196864);
    }
    
    public e(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4)
    {
      this.pageSize = paramInt1;
      this.bPL = paramInt2;
      this.bPM = paramBoolean;
      this.bPN = paramInt3;
      this.maxSize = paramInt4;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$Config$Builder;", "", "()V", "enablePlaceholders", "", "initialLoadSizeHint", "", "maxSize", "pageSize", "prefetchDistance", "build", "Landroidx/paging/PagedList$Config;", "setEnablePlaceholders", "setInitialLoadSizeHint", "setMaxSize", "setPageSize", "setPrefetchDistance", "Companion", "paging-common"}, k=1, mv={1, 4, 2})
    public static final class a
    {
      public static final ap.e.a.a bPP;
      public int bPL = -1;
      public boolean bPM = true;
      public int bPN = -1;
      public int maxSize = 2147483647;
      public int pageSize = -1;
      
      static
      {
        AppMethodBeat.i(196906);
        bPP = new ap.e.a.a((byte)0);
        AppMethodBeat.o(196906);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PagedList$LoadStateManager;", "", "()V", "endState", "Landroidx/paging/LoadState;", "getEndState", "()Landroidx/paging/LoadState;", "setEndState", "(Landroidx/paging/LoadState;)V", "refreshState", "getRefreshState", "setRefreshState", "startState", "getStartState", "setStartState", "dispatchCurrentLoadState", "", "callback", "Lkotlin/Function2;", "Landroidx/paging/LoadType;", "onStateChanged", "type", "state", "setState", "paging-common"}, k=1, mv={1, 4, 2})
  public static abstract class f
  {
    private aa bPQ;
    private aa bPR;
    private aa bPS;
    
    public f()
    {
      aa.c.a locala = aa.c.bNz;
      this.bPQ = ((aa)aa.c.HM());
      locala = aa.c.bNz;
      this.bPR = ((aa)aa.c.HM());
      locala = aa.c.bNz;
      this.bPS = ((aa)aa.c.HM());
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "", "it", "Ljava/lang/ref/WeakReference;", "Landroidx/paging/PagedList$Callback;", "invoke"}, k=3, mv={1, 4, 2})
  static final class h
    extends u
    implements b<WeakReference<ap.c>, Boolean>
  {
    h(ap.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ap
 * JD-Core Version:    0.7.0.1
 */