package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify;", "", "()V", "doNotify", "", "processName", "", "appBrandUiName", "IPC_Notify", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v ufg;
  
  static
  {
    AppMethodBeat.i(51152);
    ufg = new v();
    AppMethodBeat.o(51152);
  }
  
  public static void fp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(51151);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(51151);
      return;
    }
    localObject = paramString2;
    if (paramString2 == null) {
      localObject = "null";
    }
    XIPCInvoker.a(paramString1, new IPCString((String)localObject), a.class, null);
    AppMethodBeat.o(51151);
  }
  
  @a
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify$IPC_Notify;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeCallbackOnceTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements c<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.v
 * JD-Core Version:    0.7.0.1
 */