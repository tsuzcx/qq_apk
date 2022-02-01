package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/VIEW;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c sLo;
  private static final SparseArray<g.c> sLp;
  
  static
  {
    AppMethodBeat.i(175192);
    sLo = new c();
    sLp = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static g.c Bw(int paramInt)
  {
    AppMethodBeat.i(327473);
    synchronized (sLp)
    {
      g.c localc = (g.c)sLp.get(paramInt);
      AppMethodBeat.o(327473);
      return localc;
    }
  }
  
  public static void a(g.c paramc)
  {
    AppMethodBeat.i(327468);
    s.u(paramc, "webview");
    synchronized (sLp)
    {
      sLp.put(paramc.getBinderID(), paramc);
      paramc = ah.aiuX;
      AppMethodBeat.o(327468);
      return;
    }
  }
  
  public static void b(g.c paramc)
  {
    AppMethodBeat.i(327471);
    s.u(paramc, "webview");
    synchronized (sLp)
    {
      sLp.remove(paramc.getBinderID());
      paramc = ah.aiuX;
      AppMethodBeat.o(327471);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.c
 * JD-Core Version:    0.7.0.1
 */