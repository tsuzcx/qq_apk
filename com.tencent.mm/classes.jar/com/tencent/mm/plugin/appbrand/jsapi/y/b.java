package com.tencent.mm.plugin.appbrand.jsapi.y;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b
{
  private static final SparseArray<a> kYm;
  public static final b kYn;
  
  static
  {
    AppMethodBeat.i(175192);
    kYn = new b();
    kYm = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static void i(a parama)
  {
    AppMethodBeat.i(175189);
    k.h(parama, "webview");
    synchronized (kYm)
    {
      kYm.put(parama.getBinderID(), parama);
      parama = y.KTp;
      AppMethodBeat.o(175189);
      return;
    }
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(175190);
    k.h(parama, "webview");
    synchronized (kYm)
    {
      kYm.remove(parama.getBinderID());
      parama = y.KTp;
      AppMethodBeat.o(175190);
      return;
    }
  }
  
  public static a te(int paramInt)
  {
    AppMethodBeat.i(175191);
    synchronized (kYm)
    {
      a locala = (a)kYm.get(paramInt);
      AppMethodBeat.o(175191);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.y.b
 * JD-Core Version:    0.7.0.1
 */