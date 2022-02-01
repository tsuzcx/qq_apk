package com.tencent.mm.plugin.appbrand.jsapi.z;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b
{
  private static final SparseArray<a> kwY;
  public static final b kwZ;
  
  static
  {
    AppMethodBeat.i(175192);
    kwZ = new b();
    kwY = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(175189);
    k.h(parama, "webview");
    synchronized (kwY)
    {
      kwY.put(parama.getBinderID(), parama);
      parama = y.JfV;
      AppMethodBeat.o(175189);
      return;
    }
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(175190);
    k.h(parama, "webview");
    synchronized (kwY)
    {
      kwY.remove(parama.getBinderID());
      parama = y.JfV;
      AppMethodBeat.o(175190);
      return;
    }
  }
  
  public static a so(int paramInt)
  {
    AppMethodBeat.i(175191);
    synchronized (kwY)
    {
      a locala = (a)kwY.get(paramInt);
      AppMethodBeat.o(175191);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b
 * JD-Core Version:    0.7.0.1
 */