package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
public final class i$b
  implements d
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
  
  public final void b(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(253162);
    if ((p.h(paramString2, "onRefreshBegin")) && (p.h(paramString3, "(I)V")))
    {
      k.wlT.ddw();
      AppMethodBeat.o(253162);
      return;
    }
    if ((p.h(paramString2, "onLoadMoreBegin")) && (p.h(paramString3, "()V"))) {
      k.wlT.cKQ();
    }
    AppMethodBeat.o(253162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.i.b
 * JD-Core Version:    0.7.0.1
 */