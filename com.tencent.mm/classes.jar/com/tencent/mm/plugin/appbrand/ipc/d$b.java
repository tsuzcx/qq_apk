package com.tencent.mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.utils.u;
import com.tencent.mm.vending.e.b;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandRuntimeLaunchConditionForMainProcessIPC$IPCInvokerConnectorAutoReleaseCallback;", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "block", "Lkotlin/Function0;", "", "lifecycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "(Lkotlin/jvm/functions/Function0;Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;)V", "dead", "onCallback", "data", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d$b
  implements f<IPCVoid>, com.tencent.mm.vending.e.a
{
  private kotlin.g.a.a<ah> nsP;
  private b<? super com.tencent.mm.vending.e.a> rvf;
  
  public d$b(kotlin.g.a.a<ah> parama, b<? super com.tencent.mm.vending.e.a> paramb)
  {
    AppMethodBeat.i(319405);
    this.nsP = parama;
    this.rvf = paramb;
    if (paramb != null) {
      paramb.keep((com.tencent.mm.vending.e.a)this);
    }
    AppMethodBeat.o(319405);
  }
  
  public final void dead()
  {
    AppMethodBeat.i(319411);
    this.nsP = null;
    Object localObject = this.rvf;
    if ((localObject instanceof u)) {}
    for (localObject = (u)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((u)localObject).a((com.tencent.mm.vending.e.a)this);
      }
      this.rvf = null;
      AppMethodBeat.o(319411);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.d.b
 * JD-Core Version:    0.7.0.1
 */