package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIOnStartEventIPCNotify;", "", "()V", "doNotify", "", "processName", "", "appId", "IPC_Notify", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
{
  public static final z ufw;
  
  static
  {
    AppMethodBeat.i(322153);
    ufw = new z();
    AppMethodBeat.o(322153);
  }
  
  @a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIOnStartEventIPCNotify$IPC_Notify;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeCallbackOnceTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements c<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.z
 * JD-Core Version:    0.7.0.1
 */