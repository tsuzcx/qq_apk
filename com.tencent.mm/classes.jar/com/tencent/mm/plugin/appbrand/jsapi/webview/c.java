package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/VIEW;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class c
{
  private static final SparseArray<g.c> pGf;
  public static final c pGg;
  
  static
  {
    AppMethodBeat.i(175192);
    pGg = new c();
    pGf = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static g.c Bj(int paramInt)
  {
    AppMethodBeat.i(283979);
    synchronized (pGf)
    {
      g.c localc = (g.c)pGf.get(paramInt);
      AppMethodBeat.o(283979);
      return localc;
    }
  }
  
  public static void a(g.c paramc)
  {
    AppMethodBeat.i(283977);
    p.k(paramc, "webview");
    synchronized (pGf)
    {
      pGf.put(paramc.getBinderID(), paramc);
      paramc = x.aazN;
      AppMethodBeat.o(283977);
      return;
    }
  }
  
  public static void b(g.c paramc)
  {
    AppMethodBeat.i(283978);
    p.k(paramc, "webview");
    synchronized (pGf)
    {
      pGf.remove(paramc.getBinderID());
      paramc = x.aazN;
      AppMethodBeat.o(283978);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.c
 * JD-Core Version:    0.7.0.1
 */