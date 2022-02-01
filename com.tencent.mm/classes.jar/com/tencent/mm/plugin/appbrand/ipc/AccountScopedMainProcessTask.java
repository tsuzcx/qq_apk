package com.tencent.mm.plugin.appbrand.ipc;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ipc/AccountScopedMainProcessTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/MainProcessTask;", "()V", "callAccountNotReadyDefaultHandler", "", "onAccountNotReady", "runInAccountScope", "runInMainProcess", "waitForAccount", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitForKernel", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class AccountScopedMainProcessTask
  extends MainProcessTask
{
  private static Object R(kotlin.d.d<? super ah> paramd)
  {
    if (com.tencent.mm.kernel.h.baF().mDl.mDG) {
      paramd = ah.aiuX;
    }
    Object localObject;
    do
    {
      return paramd;
      localObject = new kotlin.d.h(kotlin.d.a.b.au(paramd));
      kotlin.d.d locald = (kotlin.d.d)localObject;
      com.tencent.mm.kernel.h.baF().a((g)new c(locald));
      localObject = ((kotlin.d.h)localObject).kli();
      if (localObject == kotlin.d.a.a.aiwj) {
        s.u(paramd, "frame");
      }
      paramd = (kotlin.d.d<? super ah>)localObject;
    } while (localObject == kotlin.d.a.a.aiwj);
    return ah.aiuX;
  }
  
  public static void cps()
  {
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)a.rut);
  }
  
  public final void asn()
  {
    j.a((aq)bu.ajwo, null, null, (m)new b(this, null), 3);
  }
  
  public abstract void cpq();
  
  public void cpr() {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final a rut;
    
    static
    {
      AppMethodBeat.i(319401);
      rut = new a();
      AppMethodBeat.o(319401);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(AccountScopedMainProcessTask paramAccountScopedMainProcessTask, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(319408);
      paramObject = (kotlin.d.d)new b(this.ruu, paramd);
      AppMethodBeat.o(319408);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(319403);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(319403);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        if (AccountScopedMainProcessTask.S(paramObject) == locala)
        {
          AppMethodBeat.o(319403);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      try
      {
        paramObject = (kotlin.d.d)this;
        this.label = 2;
        paramObject = AccountScopedMainProcessTask.T(paramObject);
        if (paramObject == locala)
        {
          AppMethodBeat.o(319403);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
        this.ruu.cpq();
      }
      catch (com.tencent.mm.model.b paramObject)
      {
        for (;;)
        {
          this.ruu.cpr();
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(319403);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ipc/AccountScopedMainProcessTask$waitForKernel$2$1", "Lcom/tencent/mm/kernel/api/IKernelCallback;", "onExit", "", "killService", "", "onStartupDone", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    c(kotlin.d.d<? super ah> paramd) {}
    
    public final void aDv()
    {
      AppMethodBeat.i(319400);
      kotlin.d.d locald = this.msc;
      ah localah = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localah));
      AppMethodBeat.o(319400);
    }
    
    public final void dZ(boolean paramBoolean)
    {
      AppMethodBeat.i(319404);
      com.tencent.mm.kernel.h.baF().b((g)this);
      AppMethodBeat.o(319404);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.AccountScopedMainProcessTask
 * JD-Core Version:    0.7.0.1
 */