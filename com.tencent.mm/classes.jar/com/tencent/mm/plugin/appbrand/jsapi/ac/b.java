package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b
{
  private static final SparseArray<a> lzM;
  public static final b lzN;
  
  static
  {
    AppMethodBeat.i(175192);
    lzN = new b();
    lzM = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(175189);
    p.h(parama, "webview");
    synchronized (lzM)
    {
      lzM.put(parama.getBinderID(), parama);
      parama = z.Nhr;
      AppMethodBeat.o(175189);
      return;
    }
  }
  
  public static void k(a parama)
  {
    AppMethodBeat.i(175190);
    p.h(parama, "webview");
    synchronized (lzM)
    {
      lzM.remove(parama.getBinderID());
      parama = z.Nhr;
      AppMethodBeat.o(175190);
      return;
    }
  }
  
  public static a tN(int paramInt)
  {
    AppMethodBeat.i(175191);
    synchronized (lzM)
    {
      a locala = (a)lzM.get(paramInt);
      AppMethodBeat.o(175191);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b
 * JD-Core Version:    0.7.0.1
 */