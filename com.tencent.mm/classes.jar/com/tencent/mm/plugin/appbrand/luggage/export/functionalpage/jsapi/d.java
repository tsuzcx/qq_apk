package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"runInMMActivity", "", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "ProxyFunction", "plugin-appbrand-integration_release"})
public final class d
{
  public static final void b(Context paramContext, b<? super MMActivity, z> paramb)
  {
    AppMethodBeat.i(223676);
    p.h(paramb, "block");
    int i = paramb.hashCode();
    a locala = a.lTE;
    a.btc().put(paramb.hashCode(), paramb);
    if (ak.isAppBrandProcess())
    {
      paramb = paramContext;
      if (paramContext == null) {
        paramb = ak.getContext();
      }
      com.tencent.mm.plugin.appbrand.ipc.a.b(paramb, (AppBrandProxyUIProcessTask.ProcessRequest)new ProxyRequest(i), null);
      AppMethodBeat.o(223676);
      return;
    }
    paramb = paramContext;
    if (paramContext == null) {
      paramb = ak.getContext();
    }
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramb, (AppBrandProxyUIProcessTask.ProcessRequest)new ProxyRequest(i), null);
    AppMethodBeat.o(223676);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.d
 * JD-Core Version:    0.7.0.1
 */