package com.tencent.mm.plugin.appbrand.jsapi.ui.launcher;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.c.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareTask;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareRequest;", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class API_openWeAppSearch$b
  implements d<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult>
{
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"performCallback", "", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/ui/launcher/API_openWeAppSearch$IPC_AppBrandSearchUIParamsPrepareResult;", "invoke"})
  static final class a
    extends kotlin.g.b.q
    implements b<API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult, x>
  {
    a(PBool paramPBool, f paramf)
    {
      super();
    }
    
    public final void a(API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult paramIPC_AppBrandSearchUIParamsPrepareResult)
    {
      AppMethodBeat.i(50711);
      p.k(paramIPC_AppBrandSearchUIParamsPrepareResult, "result");
      if (this.ptG.value)
      {
        AppMethodBeat.o(50711);
        return;
      }
      this.nyL.aH(paramIPC_AppBrandSearchUIParamsPrepareResult);
      this.ptG.value = true;
      AppMethodBeat.o(50711);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(PBool paramPBool, API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareRequest paramIPC_AppBrandSearchUIParamsPrepareRequest, API_openWeAppSearch.b.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(50712);
      if (this.ptG.value)
      {
        AppMethodBeat.o(50712);
        return;
      }
      Object localObject = a.nVA;
      localObject = a.P(MMApplicationContext.getContext(), this.ptH.ptD);
      API_openWeAppSearch.b.a locala = this.ptI;
      API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult localIPC_AppBrandSearchUIParamsPrepareResult = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
      ((Intent)localObject).setExtrasClassLoader(JsapiPermissionWrapper.class.getClassLoader());
      localIPC_AppBrandSearchUIParamsPrepareResult.resultCode = -1;
      localIPC_AppBrandSearchUIParamsPrepareResult.intent = ((Intent)localObject);
      locala.a(localIPC_AppBrandSearchUIParamsPrepareResult);
      AppMethodBeat.o(50712);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "<anonymous parameter 2>", "", "kotlin.jvm.PlatformType", "<anonymous parameter 3>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class c
    implements com.tencent.mm.an.i
  {
    c(PBool paramPBool, API_openWeAppSearch.b.a parama) {}
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(50713);
      if (this.ptG.value)
      {
        AppMethodBeat.o(50713);
        return;
      }
      paramString = h.ae(com.tencent.mm.plugin.websearch.api.i.class);
      p.j(paramString, "MMKernel.service(IWebSearchPrivacyMgr::class.java)");
      if (!((com.tencent.mm.plugin.websearch.api.i)paramString).gQj())
      {
        paramString = this.ptI;
        paramq = new API_openWeAppSearch.IPC_AppBrandSearchUIParamsPrepareResult();
        paramq.resultCode = 1;
        paramString.a(paramq);
      }
      AppMethodBeat.o(50713);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.API_openWeAppSearch.b
 * JD-Core Version:    0.7.0.1
 */