package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.o;
import kotlinx.coroutines.b.u;
import kotlinx.coroutines.b.w;
import kotlinx.coroutines.cb;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageFetcher;", "Key", "", "Value", "pagingSourceFactory", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/PagingSource;", "initialKey", "config", "Landroidx/paging/PagingConfig;", "remoteMediator", "Landroidx/paging/RemoteMediator;", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Landroidx/paging/PagingConfig;Landroidx/paging/RemoteMediator;)V", "flow", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/paging/PagingData;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Object;", "Lkotlin/jvm/functions/Function1;", "refreshEvents", "Landroidx/paging/ConflatedEventBus;", "", "retryEvents", "", "generateNewPagingSource", "previousPagingSource", "(Landroidx/paging/PagingSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invalidate", "refresh", "injectRemoteEvents", "Landroidx/paging/PageEvent;", "Landroidx/paging/PageFetcherSnapshot;", "accessor", "Landroidx/paging/RemoteMediatorAccessor;", "GenerationInfo", "PagerUiReceiver", "paging-common"}, k=1, mv={1, 4, 2})
public final class ah<Key, Value>
{
  final g<av<Value>> bLH;
  final k<Boolean> bOa;
  private final k<kotlin.ah> bOb;
  private final b<kotlin.d.d<? super ay<Key, Value>>, Object> bOc;
  private final Key bOd;
  private final au bOe;
  private final bb<Key, Value> bOf;
  
  public ah(b<? super kotlin.d.d<? super ay<Key, Value>>, ? extends Object> paramb, Key paramKey, au paramau)
  {
    AppMethodBeat.i(196711);
    this.bOc = paramb;
    this.bOd = paramKey;
    this.bOe = paramau;
    this.bOf = null;
    this.bOa = new k((byte)0);
    this.bOb = new k((byte)0);
    this.bLH = bg.d((m)new c(this, null));
    AppMethodBeat.o(196711);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageFetcher$GenerationInfo;", "Key", "", "Value", "snapshot", "Landroidx/paging/PageFetcherSnapshot;", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/PagingState;)V", "getSnapshot", "()Landroidx/paging/PageFetcherSnapshot;", "getState", "()Landroidx/paging/PagingState;", "paging-common"}, k=1, mv={1, 4, 2})
  static final class a<Key, Value>
  {
    final ai<Key, Value> bOg;
    final ba<Key, Value> bOh;
    
    public a(ai<Key, Value> paramai, ba<Key, Value> paramba)
    {
      AppMethodBeat.i(196778);
      this.bOg = paramai;
      this.bOh = paramba;
      AppMethodBeat.o(196778);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/PageFetcher$PagerUiReceiver;", "Key", "", "Value", "Landroidx/paging/UiReceiver;", "pageFetcherSnapshot", "Landroidx/paging/PageFetcherSnapshot;", "retryEventBus", "Landroidx/paging/ConflatedEventBus;", "", "(Landroidx/paging/PageFetcher;Landroidx/paging/PageFetcherSnapshot;Landroidx/paging/ConflatedEventBus;)V", "accessHint", "viewportHint", "Landroidx/paging/ViewportHint;", "refresh", "retry", "paging-common"}, k=1, mv={1, 4, 2})
  public final class b<Key, Value>
    implements bo
  {
    private final ai<Key, Value> bOi;
    private final k<kotlin.ah> bOj;
    
    public b(k<kotlin.ah> paramk)
    {
      AppMethodBeat.i(196803);
      this.bOi = paramk;
      this.bOj = localObject;
      AppMethodBeat.o(196803);
    }
    
    public final void a(bp parambp)
    {
      AppMethodBeat.i(196808);
      s.u(parambp, "viewportHint");
      ai localai = this.bOi;
      s.u(parambp, "viewportHint");
      if ((parambp instanceof bp.a)) {
        localai.bOA = ((bp.a)parambp);
      }
      localai.bOz.jc(parambp);
      AppMethodBeat.o(196808);
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PagingData;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class c
    extends kotlin.d.b.a.k
    implements m<bh<av<Value>>, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(ah paramah, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196814);
      s.u(paramd, "completion");
      paramd = new c(this.bOk, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196814);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196822);
      paramObject1 = ((c)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.ah.aiuX);
      AppMethodBeat.o(196822);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(196807);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196807);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        Object localObject = (bh)this.L$0;
        paramObject = ah.b(this.bOk);
        aq localaq;
        if (paramObject != null)
        {
          localaq = (aq)localObject;
          s.u(localaq, "scope");
          s.u(paramObject, "delegate");
        }
        for (paramObject = (be)new bc(localaq, paramObject);; paramObject = null)
        {
          paramObject = r.c(u.b(r.a(o.a(ah.c(this.bOk).bLH, (m)new kotlin.d.b.a.k(paramObject, null)
          {
            int label;
            
            public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
            {
              AppMethodBeat.i(196878);
              s.u(paramAnonymousd, "completion");
              paramAnonymousd = new 1(this.bOl, paramAnonymousd);
              paramAnonymousd.L$0 = paramAnonymousObject;
              AppMethodBeat.o(196878);
              return paramAnonymousd;
            }
            
            public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
            {
              AppMethodBeat.i(196885);
              paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(kotlin.ah.aiuX);
              AppMethodBeat.o(196885);
              return paramAnonymousObject1;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(196859);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              Object localObject1;
              Object localObject2;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(196859);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = (h)this.L$0;
                localObject1 = this.bOl;
                if (localObject1 != null)
                {
                  this.L$0 = paramAnonymousObject;
                  this.label = 1;
                  localObject1 = ((be)localObject1).l(this);
                  if (localObject1 != locala) {
                    break label213;
                  }
                  AppMethodBeat.o(196859);
                  return locala;
                }
                break;
              case 1: 
                localObject2 = (h)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject1 = paramAnonymousObject;
                paramAnonymousObject = localObject2;
              }
              label202:
              label213:
              for (;;)
              {
                localObject2 = (bb.a)localObject1;
                localObject1 = paramAnonymousObject;
                paramAnonymousObject = localObject2;
                if (paramAnonymousObject == bb.a.bQP) {}
                for (boolean bool = true;; bool = false)
                {
                  this.L$0 = null;
                  this.label = 2;
                  if (((h)localObject1).a(Boolean.valueOf(bool), this) != locala) {
                    break label202;
                  }
                  AppMethodBeat.o(196859);
                  return locala;
                  localObject2 = null;
                  localObject1 = paramAnonymousObject;
                  paramAnonymousObject = localObject2;
                  break;
                }
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = kotlin.ah.aiuX;
                AppMethodBeat.o(196859);
                return paramAnonymousObject;
              }
            }
          }), (kotlin.g.a.q)new kotlin.d.b.a.k(paramObject, null)
          {
            Object Uf;
            Object VC;
            int label;
            
            public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2, Object paramAnonymousObject3)
            {
              AppMethodBeat.i(196867);
              paramAnonymousObject1 = (ah.a)paramAnonymousObject1;
              boolean bool = ((Boolean)paramAnonymousObject2).booleanValue();
              paramAnonymousObject2 = (kotlin.d.d)paramAnonymousObject3;
              s.u(paramAnonymousObject2, "continuation");
              paramAnonymousObject2 = new 2(this.bOm, paramObject, paramAnonymousObject2);
              paramAnonymousObject2.L$0 = paramAnonymousObject1;
              paramAnonymousObject2.YF = bool;
              paramAnonymousObject1 = ((2)paramAnonymousObject2).invokeSuspend(kotlin.ah.aiuX);
              AppMethodBeat.o(196867);
              return paramAnonymousObject1;
            }
            
            public final Object invokeSuspend(Object paramAnonymousObject)
            {
              AppMethodBeat.i(196861);
              kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
              Object localObject4;
              boolean bool;
              Object localObject2;
              Object localObject1;
              Object localObject3;
              switch (this.label)
              {
              default: 
                paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(196861);
                throw paramAnonymousObject;
              case 0: 
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject4 = (ah.a)this.L$0;
                bool = this.YF;
                paramAnonymousObject = new kotlin.g.b.ah.f();
                localObject2 = this.bOm.bOk;
                if (localObject4 != null)
                {
                  localObject1 = ((ah.a)localObject4).bOg;
                  if (localObject1 == null) {}
                }
                for (localObject1 = ((ai)localObject1).bLR;; localObject1 = null)
                {
                  this.L$0 = localObject4;
                  this.Uf = paramAnonymousObject;
                  this.VC = paramAnonymousObject;
                  this.YF = bool;
                  this.label = 1;
                  localObject2 = ((ah)localObject2).a((ay)localObject1, this);
                  if (localObject2 != locala) {
                    break;
                  }
                  AppMethodBeat.o(196861);
                  return locala;
                }
              case 1: 
                bool = this.YF;
                localObject3 = (kotlin.g.b.ah.f)this.VC;
                localObject4 = (kotlin.g.b.ah.f)this.Uf;
                localObject1 = (ah.a)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                localObject2 = paramAnonymousObject;
                paramAnonymousObject = localObject4;
              }
              for (;;)
              {
                ((kotlin.g.b.ah.f)localObject3).aqH = ((ay)localObject2);
                if (((ay)paramAnonymousObject.aqH).bMa.get())
                {
                  localObject2 = this.bOm.bOk;
                  localObject3 = (ay)paramAnonymousObject.aqH;
                  this.L$0 = localObject1;
                  this.Uf = paramAnonymousObject;
                  this.VC = paramAnonymousObject;
                  this.YF = bool;
                  this.label = 2;
                  localObject4 = ((ah)localObject2).a((ay)localObject3, this);
                  if (localObject4 != locala) {
                    break label880;
                  }
                  AppMethodBeat.o(196861);
                  return locala;
                  bool = this.YF;
                  localObject3 = (kotlin.g.b.ah.f)this.VC;
                  localObject4 = (kotlin.g.b.ah.f)this.Uf;
                  localObject2 = (ah.a)this.L$0;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                  localObject1 = paramAnonymousObject;
                  paramAnonymousObject = localObject4;
                  localObject4 = localObject1;
                }
                for (;;)
                {
                  ((kotlin.g.b.ah.f)localObject3).aqH = ((ay)localObject4);
                  localObject1 = localObject2;
                  break;
                  if (localObject1 != null)
                  {
                    localObject2 = ((ah.a)localObject1).bOg;
                    if (localObject2 != null)
                    {
                      this.L$0 = localObject1;
                      this.Uf = paramAnonymousObject;
                      this.VC = null;
                      this.YF = bool;
                      this.label = 3;
                      localObject2 = ((ai)localObject2).j(this);
                      if (localObject2 != locala) {
                        break label877;
                      }
                      AppMethodBeat.o(196861);
                      return locala;
                      bool = this.YF;
                      localObject3 = (kotlin.g.b.ah.f)this.Uf;
                      localObject1 = (ah.a)this.L$0;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                      localObject2 = paramAnonymousObject;
                      paramAnonymousObject = localObject3;
                    }
                  }
                  label527:
                  label575:
                  label586:
                  label596:
                  label854:
                  label863:
                  label869:
                  label874:
                  label877:
                  for (;;)
                  {
                    localObject3 = (ba)localObject2;
                    localObject2 = localObject1;
                    localObject1 = paramAnonymousObject;
                    paramAnonymousObject = localObject3;
                    label503:
                    int i;
                    if (paramAnonymousObject != null)
                    {
                      localObject3 = paramAnonymousObject.bNN;
                      localObject3 = (Collection)localObject3;
                      if ((localObject3 != null) && (!((Collection)localObject3).isEmpty())) {
                        break label844;
                      }
                      i = 1;
                      if (i == 0) {
                        break label874;
                      }
                      if (localObject2 == null) {
                        break label854;
                      }
                      localObject3 = ((ah.a)localObject2).bOh;
                      if (localObject3 == null) {
                        break label854;
                      }
                      localObject3 = ((ba)localObject3).bNN;
                      if (localObject3 == null) {
                        break label854;
                      }
                      if (((Collection)localObject3).isEmpty()) {
                        break label849;
                      }
                      i = 1;
                      if (i != 1) {
                        break label874;
                      }
                      paramAnonymousObject = ((ah.a)localObject2).bOh;
                    }
                    for (;;)
                    {
                      if (paramAnonymousObject != null)
                      {
                        localObject4 = paramAnonymousObject.bQN;
                        localObject3 = paramAnonymousObject;
                        if (localObject4 == null)
                        {
                          if (localObject2 == null) {
                            break label863;
                          }
                          localObject3 = ((ah.a)localObject2).bOh;
                          if (localObject3 == null) {
                            break label863;
                          }
                          localObject4 = ((ba)localObject3).bQN;
                          label628:
                          localObject3 = paramAnonymousObject;
                          if (localObject4 != null) {
                            localObject3 = ((ah.a)localObject2).bOh;
                          }
                        }
                        if (localObject3 != null)
                        {
                          localObject4 = ((ay)((kotlin.g.b.ah.f)localObject1).aqH).a((ba)localObject3);
                          paramAnonymousObject = localObject4;
                          if (localObject4 != null) {}
                        }
                        else
                        {
                          paramAnonymousObject = ah.d(this.bOm.bOk);
                        }
                        if (localObject2 != null)
                        {
                          localObject2 = ((ah.a)localObject2).bOg;
                          if (localObject2 != null) {
                            ((cb)((ai)localObject2).bOE).a(null);
                          }
                        }
                        localObject1 = (ay)((kotlin.g.b.ah.f)localObject1).aqH;
                        localObject2 = ah.e(this.bOm.bOk);
                        localObject4 = ah.f(this.bOm.bOk).bLH;
                        if (!bool) {
                          break label869;
                        }
                      }
                      for (bool = true;; bool = false)
                      {
                        paramAnonymousObject = new ah.a(new ai(paramAnonymousObject, (ay)localObject1, (au)localObject2, (g)localObject4, bool, (bf)paramObject, (ba)localObject3, (kotlin.g.a.a)new kotlin.g.b.q() {}), (ba)localObject3);
                        AppMethodBeat.o(196861);
                        return paramAnonymousObject;
                        localObject4 = null;
                        localObject2 = paramAnonymousObject;
                        localObject3 = localObject1;
                        paramAnonymousObject = localObject4;
                        localObject1 = localObject2;
                        localObject2 = localObject3;
                        break;
                        localObject3 = null;
                        break label503;
                        i = 0;
                        break label527;
                        i = 0;
                        break label575;
                        break label586;
                        localObject4 = null;
                        break label596;
                        localObject4 = null;
                        break label628;
                      }
                    }
                  }
                  label844:
                  label849:
                  label880:
                  localObject3 = paramAnonymousObject;
                  localObject2 = localObject1;
                }
                localObject1 = paramAnonymousObject;
                localObject3 = localObject1;
                localObject1 = localObject4;
              }
            }
          })), (kotlin.g.a.q)new b(null, this, paramObject));
          localObject = (h)new a((bh)localObject);
          this.label = 1;
          if (paramObject.a((h)localObject, this) != locala) {
            break;
          }
          AppMethodBeat.o(196807);
          return locala;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(196807);
      return paramObject;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 4, 2})
    public static final class a
      implements h<av<Value>>
    {
      public a(bh parambh) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(196719);
        paramObject = (av)paramObject;
        paramObject = this.bOn.b(paramObject, paramd);
        if (paramObject == kotlin.d.a.a.aiwj)
        {
          AppMethodBeat.o(196719);
          return paramObject;
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(196719);
        return paramObject;
      }
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "androidx/paging/FlowExtKt$simpleMapLatest$1"}, k=3, mv={1, 4, 2})
    public static final class b
      extends kotlin.d.b.a.k
      implements kotlin.g.a.q<h<? super av<Value>>, ah.a<Key, Value>, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      public b(kotlin.d.d paramd, ah.c paramc, be parambe)
      {
        super(paramd);
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2, Object paramObject3)
      {
        AppMethodBeat.i(196750);
        paramObject1 = (h)paramObject1;
        paramObject3 = (kotlin.d.d)paramObject3;
        s.u(paramObject1, "$this$create");
        s.u(paramObject3, "continuation");
        paramObject3 = new b(paramObject3, jdField_this, paramObject);
        paramObject3.L$0 = paramObject1;
        paramObject3.Uf = paramObject2;
        paramObject1 = ((b)paramObject3).invokeSuspend(kotlin.ah.aiuX);
        AppMethodBeat.o(196750);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(196739);
        kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(196739);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (h)this.L$0;
          Object localObject = (ah.a)this.Uf;
          localObject = new av(ah.a(((ah.a)localObject).bOg, paramObject), (bo)new ah.b(jdField_this.bOk, ((ah.a)localObject).bOg, ah.f(jdField_this.bOk)));
          this.label = 1;
          if (paramObject.a(localObject, this) == locala)
          {
            AppMethodBeat.o(196739);
            return locala;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = kotlin.ah.aiuX;
        AppMethodBeat.o(196739);
        return paramObject;
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"generateNewPagingSource", "", "Key", "Value", "previousPagingSource", "Landroidx/paging/PagingSource;", "continuation", "Lkotlin/coroutines/Continuation;"}, k=3, mv={1, 4, 2})
  static final class d
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    d(ah paramah, kotlin.d.d paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(196794);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.bOk.a(null, this);
      AppMethodBeat.o(196794);
      return paramObject;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "Key", "", "Value", "Landroidx/paging/SimpleProducerScope;", "Landroidx/paging/PageEvent;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k=3, mv={1, 4, 2})
  static final class g
    extends kotlin.d.b.a.k
    implements m<bh<ag<Value>>, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    g(ai paramai, be parambe, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(196825);
      s.u(paramd, "completion");
      paramd = new g(this.bOp, this.bOq, paramd);
      paramd.L$0 = paramObject;
      AppMethodBeat.o(196825);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(196831);
      paramObject1 = ((g)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.ah.aiuX);
      AppMethodBeat.o(196831);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(196820);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(196820);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (bh)this.L$0;
        final af localaf = new af();
        Object localObject = new kotlin.d.b.a.k(paramObject, null)
        {
          int label;
          
          private kotlin.d.d<kotlin.ah> a(ad paramAnonymousad, aa paramAnonymousaa, kotlin.d.d<? super kotlin.ah> paramAnonymousd)
          {
            AppMethodBeat.i(196832);
            s.u(paramAnonymousad, "type");
            s.u(paramAnonymousaa, "state");
            s.u(paramAnonymousd, "continuation");
            paramAnonymousd = new 1(this.bLh, paramAnonymousd);
            paramAnonymousd.L$0 = paramAnonymousad;
            paramAnonymousd.Uf = paramAnonymousaa;
            AppMethodBeat.o(196832);
            return paramAnonymousd;
          }
          
          public final Object b(ad paramAnonymousad, aa paramAnonymousaa, kotlin.d.d<? super kotlin.ah> paramAnonymousd)
          {
            AppMethodBeat.i(196855);
            paramAnonymousad = ((1)a(paramAnonymousad, paramAnonymousaa, paramAnonymousd)).invokeSuspend(kotlin.ah.aiuX);
            AppMethodBeat.o(196855);
            return paramAnonymousad;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(196852);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196852);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = (ad)this.L$0;
              aa localaa = (aa)this.Uf;
              Object localObject = ag.c.bNZ;
              if (ag.c.a.a(localaa, true))
              {
                localObject = this.bLh;
                paramAnonymousObject = new ag.c(paramAnonymousObject, true, localaa);
                this.L$0 = null;
                this.label = 1;
                if (((bh)localObject).b(paramAnonymousObject, this) == locala)
                {
                  AppMethodBeat.o(196852);
                  return locala;
                }
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(196852);
            return paramAnonymousObject;
          }
        };
        kotlinx.coroutines.j.a((aq)paramObject, null, null, (m)new kotlin.d.b.a.k(localaf, (1)localObject)
        {
          int label;
          
          public final kotlin.d.d<kotlin.ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(196834);
            s.u(paramAnonymousd, "completion");
            paramAnonymousObject = new 2(this.bOr, localaf, this.bOt, paramAnonymousd);
            AppMethodBeat.o(196834);
            return paramAnonymousObject;
          }
          
          public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
          {
            AppMethodBeat.i(196840);
            paramAnonymousObject1 = ((2)create(paramAnonymousObject1, (kotlin.d.d)paramAnonymousObject2)).invokeSuspend(kotlin.ah.aiuX);
            AppMethodBeat.o(196840);
            return paramAnonymousObject1;
          }
          
          public final Object invokeSuspend(final Object paramAnonymousObject)
          {
            AppMethodBeat.i(196826);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(196826);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = new kotlin.g.b.ah.f();
              Object localObject = ab.bNB;
              paramAnonymousObject.aqH = ab.HN();
              localObject = (g)this.bOr.bOq.Ih();
              paramAnonymousObject = (h)new a(this, paramAnonymousObject);
              this.label = 1;
              if (((g)localObject).a(paramAnonymousObject, this) == locala)
              {
                AppMethodBeat.o(196826);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            paramAnonymousObject = kotlin.ah.aiuX;
            AppMethodBeat.o(196826);
            return paramAnonymousObject;
          }
          
          @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 4, 2})
          public static final class a
            implements h<ab>
          {
            public a(ah.g.2 param2, kotlin.g.b.ah.f paramf) {}
            
            public final Object a(Object paramObject, kotlin.d.d paramd)
            {
              AppMethodBeat.i(196619);
              kotlin.d.b.a.d local1;
              if ((paramd instanceof 1))
              {
                local1 = (1)paramd;
                if ((local1.label & 0x80000000) != 0) {
                  local1.label += -2147483648;
                }
              }
              Object localObject3;
              kotlin.d.a.a locala;
              for (;;)
              {
                localObject3 = local1.result;
                locala = kotlin.d.a.a.aiwj;
                switch (local1.label)
                {
                default: 
                  paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(196619);
                  throw paramObject;
                  local1 = new kotlin.d.b.a.d(paramd)
                  {
                    Object L$0;
                    Object Uf;
                    int label;
                    
                    public final Object invokeSuspend(Object paramAnonymousObject)
                    {
                      AppMethodBeat.i(196954);
                      this.result = paramAnonymousObject;
                      this.label |= 0x80000000;
                      paramAnonymousObject = this.bOw.a(null, this);
                      AppMethodBeat.o(196954);
                      return paramAnonymousObject;
                    }
                  };
                }
              }
              ResultKt.throwOnFailure(localObject3);
              paramObject = (ab)paramObject;
              Object localObject2 = this;
              paramd = paramObject;
              Object localObject4;
              if ((s.p(((ab)paramAnonymousObject.aqH).bLz, paramObject.bLz) ^ true))
              {
                this.bOu.bOs.a(ad.bNC, true, paramObject.bLz);
                localObject1 = this.bOu.bOt;
                localObject3 = ad.bNC;
                localObject4 = paramObject.bLz;
                local1.L$0 = this;
                local1.Uf = paramObject;
                local1.label = 1;
                localObject2 = this;
                paramd = paramObject;
                if (((ah.g.1)localObject1).b((ad)localObject3, (aa)localObject4, local1) == locala)
                {
                  AppMethodBeat.o(196619);
                  return locala;
                  paramd = (ab)local1.Uf;
                  localObject2 = (a)local1.L$0;
                  ResultKt.throwOnFailure(localObject3);
                }
              }
              Object localObject1 = localObject2;
              paramObject = paramd;
              aa localaa;
              if ((s.p(((ab)paramAnonymousObject.aqH).bLA, paramd.bLA) ^ true))
              {
                ((a)localObject2).bOu.bOs.a(ad.bND, true, paramd.bLA);
                localObject3 = ((a)localObject2).bOu.bOt;
                localObject4 = ad.bND;
                localaa = paramd.bLA;
                local1.L$0 = localObject2;
                local1.Uf = paramd;
                local1.label = 2;
                localObject1 = localObject2;
                paramObject = paramd;
                if (((ah.g.1)localObject3).b((ad)localObject4, localaa, local1) == locala)
                {
                  AppMethodBeat.o(196619);
                  return locala;
                  paramObject = (ab)local1.Uf;
                  localObject1 = (a)local1.L$0;
                  ResultKt.throwOnFailure(localObject3);
                }
              }
              localObject2 = localObject1;
              paramd = paramObject;
              if ((s.p(((ab)paramAnonymousObject.aqH).bLB, paramObject.bLB) ^ true))
              {
                ((a)localObject1).bOu.bOs.a(ad.bNE, true, paramObject.bLB);
                localObject3 = ((a)localObject1).bOu.bOt;
                localObject4 = ad.bNE;
                localaa = paramObject.bLB;
                local1.L$0 = localObject1;
                local1.Uf = paramObject;
                local1.label = 3;
                localObject2 = localObject1;
                paramd = paramObject;
                if (((ah.g.1)localObject3).b((ad)localObject4, localaa, local1) == locala)
                {
                  AppMethodBeat.o(196619);
                  return locala;
                  paramd = (ab)local1.Uf;
                  localObject2 = (a)local1.L$0;
                  ResultKt.throwOnFailure(localObject3);
                }
              }
              paramAnonymousObject.aqH = paramd;
              paramObject = kotlin.ah.aiuX;
              AppMethodBeat.o(196619);
              return paramObject;
            }
          }
        }, 3);
        localObject = this.bOp.bOF;
        paramObject = (h)new a(this, paramObject, localaf);
        this.label = 1;
        if (((g)localObject).a(paramObject, this) == locala)
        {
          AppMethodBeat.o(196820);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(196820);
      return paramObject;
    }
    
    @Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 4, 2})
    public static final class a
      implements h<ag<Value>>
    {
      public a(ah.g paramg, bh parambh, af paramaf) {}
      
      public final Object a(Object paramObject, kotlin.d.d paramd)
      {
        AppMethodBeat.i(196680);
        Object localObject1;
        if ((paramd instanceof 1))
        {
          localObject1 = (1)paramd;
          if ((((1)localObject1).label & 0x80000000) != 0) {
            ((1)localObject1).label += -2147483648;
          }
        }
        Object localObject2;
        for (paramd = (kotlin.d.d)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
            {
              int label;
              
              public final Object invokeSuspend(Object paramAnonymousObject)
              {
                AppMethodBeat.i(197076);
                this.result = paramAnonymousObject;
                this.label |= 0x80000000;
                paramAnonymousObject = this.bOy.a(null, this);
                AppMethodBeat.o(197076);
                return paramAnonymousObject;
              }
            })
        {
          localObject2 = paramd.result;
          localObject1 = kotlin.d.a.a.aiwj;
          switch (paramd.label)
          {
          default: 
            paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(196680);
            throw paramObject;
          }
        }
        ResultKt.throwOnFailure(localObject2);
        paramObject = (ag)paramObject;
        Object localObject3;
        Object localObject4;
        if ((paramObject instanceof ag.b))
        {
          localObject2 = localaf;
          localObject3 = ((ag.b)paramObject).bNO.bLC;
          localObject4 = (ab)this.bOr.bOq.Ih().getValue();
          s.u(localObject3, "sourceLoadStates");
          ((af)localObject2).bLC = ((ab)localObject3);
          ((af)localObject2).bLD = ((ab)localObject4);
          ((af)localObject2).HP();
          localObject2 = paramObject;
          paramObject = ag.b.a((ag.b)paramObject, localaf.HO());
          paramd.label = 1;
          if (((bh)localObject2).b(paramObject, paramd) == localObject1)
          {
            AppMethodBeat.o(196680);
            return localObject1;
            ResultKt.throwOnFailure(localObject2);
          }
        }
        for (;;)
        {
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(196680);
          return paramObject;
          if ((paramObject instanceof ag.a))
          {
            localObject2 = localaf;
            localObject3 = ((ag.a)paramObject).bKC;
            localObject4 = aa.c.bNz;
            ((af)localObject2).a((ad)localObject3, false, (aa)aa.c.HM());
            localObject2 = paramObject;
            paramd.label = 2;
            if (((bh)localObject2).b(paramObject, paramd) == localObject1)
            {
              AppMethodBeat.o(196680);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
          }
          else if ((paramObject instanceof ag.c))
          {
            localaf.a(((ag.c)paramObject).bKC, ((ag.c)paramObject).bNX, ((ag.c)paramObject).bNY);
            localObject2 = paramObject;
            paramd.label = 3;
            if (((bh)localObject2).b(paramObject, paramd) == localObject1)
            {
              AppMethodBeat.o(196680);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.ah
 * JD-Core Version:    0.7.0.1
 */