package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/expt/hellhound/ext/finder/monitor/RLBeginCallback$mRLBeginListener$1", "Lcom/tencent/mm/hellhoundlib/method/IHellMethodMonitorCallback;", "runOnEnter", "", "className", "", "methodName", "methodDec", "caller", "", "args", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V", "runOnExit", "retVal", "plugin-expt_release"})
public final class i$b
  implements c
{
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject1, Object paramObject2) {}
  
  public final void a(String paramString1, String paramString2, String paramString3, Object paramObject, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(220959);
    if ((p.j(paramString2, "onRefreshBegin")) && (p.j(paramString3, "(I)V")))
    {
      k.sFY.cOE();
      AppMethodBeat.o(220959);
      return;
    }
    if ((p.j(paramString2, "onLoadMoreBegin")) && (p.j(paramString3, "()V"))) {
      k.sFY.cxo();
    }
    AppMethodBeat.o(220959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.i.b
 * JD-Core Version:    0.7.0.1
 */