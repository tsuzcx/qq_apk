package com.tencent.mm.plugin.appbrand.task;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/task/AppBrandMiniProgramProcess$preload$1", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallbackEx;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "onBridgeNotFound", "", "onCallback", "data", "onCaughtInvokeException", "e", "Ljava/lang/Exception;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d$b
  implements g<IPCVoid>
{
  d$b(d paramd) {}
  
  public final void aYr()
  {
    AppMethodBeat.i(318578);
    com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandMiniProgramProcess", "onBridgeNotFound: proc [%s]", new Object[] { this.tVQ.getProcessName() });
    AppMethodBeat.o(318578);
  }
  
  public final void h(Exception paramException)
  {
    AppMethodBeat.i(318584);
    com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.AppBrandMiniProgramProcess", "onCaughtInvokeException: %s, process %s", new Object[] { android.util.Log.getStackTraceString((Throwable)paramException), this.tVQ.getProcessName() });
    AppMethodBeat.o(318584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.d.b
 * JD-Core Version:    0.7.0.1
 */