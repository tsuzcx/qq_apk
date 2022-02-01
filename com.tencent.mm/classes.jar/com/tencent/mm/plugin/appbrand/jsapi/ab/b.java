package com.tencent.mm.plugin.appbrand.jsapi.ab;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b
{
  private static final SparseArray<a> lvo;
  public static final b lvp;
  
  static
  {
    AppMethodBeat.i(175192);
    lvp = new b();
    lvo = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(175189);
    p.h(parama, "webview");
    synchronized (lvo)
    {
      lvo.put(parama.getBinderID(), parama);
      parama = z.MKo;
      AppMethodBeat.o(175189);
      return;
    }
  }
  
  public static void k(a parama)
  {
    AppMethodBeat.i(175190);
    p.h(parama, "webview");
    synchronized (lvo)
    {
      lvo.remove(parama.getBinderID());
      parama = z.MKo;
      AppMethodBeat.o(175190);
      return;
    }
  }
  
  public static a tI(int paramInt)
  {
    AppMethodBeat.i(175191);
    synchronized (lvo)
    {
      a locala = (a)lvo.get(paramInt);
      AppMethodBeat.o(175191);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.b
 * JD-Core Version:    0.7.0.1
 */