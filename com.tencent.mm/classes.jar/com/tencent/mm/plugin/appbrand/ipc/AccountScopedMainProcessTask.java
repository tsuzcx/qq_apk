package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.cs;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ipc/AccountScopedMainProcessTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "callAccountNotReadyDefaultHandler", "", "onAccountNotReady", "runInAccountScope", "runInMainProcess", "waitForAccount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForKernel", "plugin-appbrand-integration_release"})
public abstract class AccountScopedMainProcessTask
  extends MainProcessTask
{
  public static void bPd()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)a.oqA);
  }
  
  public final void RW()
  {
    kotlinx.coroutines.g.b((ak)br.abxo, null, (m)new b(this, null), 3);
  }
  
  public abstract void bPb();
  
  public void bPc() {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public static final a oqA;
    
    static
    {
      AppMethodBeat.i(279824);
      oqA = new a();
      AppMethodBeat.o(279824);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class b
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    b(AccountScopedMainProcessTask paramAccountScopedMainProcessTask, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(278939);
      p.k(paramd, "completion");
      paramd = new b(this.oqB, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(278939);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(278941);
      paramObject1 = ((b)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(278941);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(278938);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(278938);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        this.L$0 = paramObject;
        this.label = 1;
        if (AccountScopedMainProcessTask.a(this) == locala)
        {
          AppMethodBeat.o(278938);
          return locala;
        }
        break;
      case 1: 
        ak localak = (ak)this.L$0;
        ResultKt.throwOnFailure(paramObject);
        paramObject = localak;
      }
      try
      {
        this.L$0 = paramObject;
        this.label = 2;
        paramObject = AccountScopedMainProcessTask.b(this);
        if (paramObject == locala)
        {
          AppMethodBeat.o(278938);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        this.oqB.bPb();
      }
      catch (b paramObject)
      {
        for (;;)
        {
          this.oqB.bPc();
        }
      }
      paramObject = x.aazN;
      AppMethodBeat.o(278938);
      return paramObject;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ipc/AccountScopedMainProcessTask$waitForAccount$2$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"})
  public static final class c
    extends IListener<cs>
  {
    c(kotlin.d.d paramd) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ipc/AccountScopedMainProcessTask$waitForKernel$2$1", "Lcom/tencent/mm/kernel/api/IKernelCallback;", "onExit", "", "killService", "", "onStartupDone", "plugin-appbrand-integration_release"})
  public static final class d
    implements com.tencent.mm.kernel.api.g
  {
    d(kotlin.d.d paramd) {}
    
    public final void abB()
    {
      AppMethodBeat.i(279637);
      kotlin.d.d locald = this.oqC;
      x localx = x.aazN;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localx));
      AppMethodBeat.o(279637);
    }
    
    public final void dn(boolean paramBoolean)
    {
      AppMethodBeat.i(279638);
      h.aHH().b((com.tencent.mm.kernel.api.g)this);
      AppMethodBeat.o(279638);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AccountScopedMainProcessTask
 * JD-Core Version:    0.7.0.1
 */