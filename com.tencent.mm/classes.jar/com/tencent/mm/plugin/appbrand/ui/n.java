package com.tencent.mm.plugin.appbrand.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify;", "", "()V", "doNotify", "", "processName", "", "appBrandUiName", "IPC_Notify", "plugin-appbrand-integration_release"})
public final class n
{
  public static final n meU;
  
  static
  {
    AppMethodBeat.i(51152);
    meU = new n();
    AppMethodBeat.o(51152);
  }
  
  public static void eg(String paramString1, String paramString2)
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIEnterAnimationCompleteIPCNotify$IPC_Notify;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
  static final class a
    implements b<IPCString, IPCVoid>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.n
 * JD-Core Version:    0.7.0.1
 */