package com.tencent.mm.plugin.livebase.redux;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/livebase/redux/ReduxStore;", "State", "", "initState", "reducer", "Lcom/tencent/mm/plugin/livebase/redux/IReduxReducer;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/livebase/redux/IReduxReducer;Landroidx/lifecycle/LifecycleOwner;)V", "_state", "Ljava/lang/Object;", "_subscriberLiveData", "Landroidx/lifecycle/MutableLiveData;", "getInitState", "()Ljava/lang/Object;", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "lifecycleScope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "getLifecycleScope", "()Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "lifecycleScope$delegate", "Lkotlin/Lazy;", "getReducer", "()Lcom/tencent/mm/plugin/livebase/redux/IReduxReducer;", "subscriberLiveData", "Landroidx/lifecycle/LiveData;", "getSubscriberLiveData", "()Landroidx/lifecycle/LiveData;", "dispatch", "", "action", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "getState", "Companion", "plugin-livebase_release"})
public final class c<State>
{
  public static final c.a EhA;
  private final f Ehv;
  private final r<State> Ehw;
  public final LiveData<State> Ehx;
  private final State Ehy;
  final b<State> Ehz;
  public State _state;
  final androidx.lifecycle.l lifecycleOwner;
  
  static
  {
    AppMethodBeat.i(187578);
    EhA = new c.a((byte)0);
    AppMethodBeat.o(187578);
  }
  
  public c(State paramState, b<State> paramb, androidx.lifecycle.l paraml)
  {
    AppMethodBeat.i(187575);
    this.Ehy = paramState;
    this.Ehz = paramb;
    this.lifecycleOwner = paraml;
    this._state = this.Ehy;
    this.Ehv = g.ar((kotlin.g.a.a)new c(this));
    this.Ehw = new r();
    paramState = this.Ehw;
    if (paramState == null)
    {
      paramState = new t("null cannot be cast to non-null type androidx.lifecycle.LiveData<State>");
      AppMethodBeat.o(187575);
      throw paramState;
    }
    this.Ehx = ((LiveData)paramState);
    AppMethodBeat.o(187575);
  }
  
  private final LifecycleScope eLN()
  {
    AppMethodBeat.i(187573);
    LifecycleScope localLifecycleScope = (LifecycleScope)this.Ehv.getValue();
    AppMethodBeat.o(187573);
    return localLifecycleScope;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(187574);
    p.k(parama, "action");
    Log.i("MicroMsg.Redux.ReduxStore", "dispatch action:".concat(String.valueOf(parama)));
    LifecycleScope.launch$default(eLN(), null, (m)new b(this, parama, null), 1, null);
    AppMethodBeat.o(187574);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "State", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    b(c paramc, a parama, d paramd)
    {
      super(paramd);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(187622);
      p.k(paramd, "completion");
      paramd = new b(this.EhB, parama, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(187622);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(187624);
      paramObject1 = ((b)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(187624);
      return paramObject1;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(187617);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(187617);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.EhB.Ehz.a(c.a(this.EhB), c.b(this.EhB), parama);
      LifecycleScope.launch$default(c.a(this.EhB), null, (m)new j(paramObject, null)
      {
        Object L$0;
        int label;
        Object oDA;
        private ak p$;
        
        public final d<x> create(Object paramAnonymousObject, d<?> paramAnonymousd)
        {
          AppMethodBeat.i(187564);
          p.k(paramAnonymousd, "completion");
          paramAnonymousd = new 1(this.EhD, paramObject, paramAnonymousd);
          paramAnonymousd.p$ = ((ak)paramAnonymousObject);
          AppMethodBeat.o(187564);
          return paramAnonymousd;
        }
        
        public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(187565);
          paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (d)paramAnonymousObject2)).invokeSuspend(x.aazN);
          AppMethodBeat.o(187565);
          return paramAnonymousObject1;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(187561);
          kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(187561);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
            paramAnonymousObject = this.p$;
            kotlinx.coroutines.b.b localb = paramObject;
            kotlinx.coroutines.b.c localc = (kotlinx.coroutines.b.c)new a(this);
            this.L$0 = paramAnonymousObject;
            this.oDA = localb;
            this.label = 1;
            if (localb.a(localc, this) == locala)
            {
              AppMethodBeat.o(187561);
              return locala;
            }
            break;
          case 1: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          paramAnonymousObject = x.aazN;
          AppMethodBeat.o(187561);
          return paramAnonymousObject;
        }
        
        @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"})
        public static final class a
          implements kotlinx.coroutines.b.c<State>
        {
          public a(c.b.1 param1) {}
          
          public final Object a(Object paramObject, d paramd)
          {
            AppMethodBeat.i(187582);
            Log.i("MicroMsg.Redux.ReduxStore", "stateFlow collect ".concat(String.valueOf(paramObject)));
            c.a(this.EhF.EhD.EhB, paramObject);
            c.c(this.EhF.EhD.EhB).L(paramObject);
            paramObject = x.aazN;
            AppMethodBeat.o(187582);
            return paramObject;
          }
        }
      }, 1, null);
      paramObject = x.aazN;
      AppMethodBeat.o(187617);
      return paramObject;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "State", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<LifecycleScope>
  {
    c(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.livebase.redux.c
 * JD-Core Version:    0.7.0.1
 */