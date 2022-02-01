package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"runInMMActivity", "", "context", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "ProxyFunction", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final void b(Context paramContext, b<? super MMActivity, ah> paramb)
  {
    AppMethodBeat.i(320118);
    s.u(paramb, "block");
    int i = paramb.hashCode();
    a locala = a.tgy;
    a.cBs().put(paramb.hashCode(), paramb);
    if (MMApplicationContext.isAppBrandProcess())
    {
      paramb = paramContext;
      if (paramContext == null) {
        paramb = MMApplicationContext.getContext();
      }
      com.tencent.mm.plugin.appbrand.ipc.a.b(paramb, (AppBrandProxyUIProcessTask.ProcessRequest)new ProxyRequest(i), null);
      AppMethodBeat.o(320118);
      return;
    }
    paramb = paramContext;
    if (paramContext == null) {
      paramb = MMApplicationContext.getContext();
    }
    com.tencent.mm.plugin.appbrand.ipc.a.a(paramb, (AppBrandProxyUIProcessTask.ProcessRequest)new ProxyRequest(i), null);
    AppMethodBeat.o(320118);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.d
 * JD-Core Version:    0.7.0.1
 */