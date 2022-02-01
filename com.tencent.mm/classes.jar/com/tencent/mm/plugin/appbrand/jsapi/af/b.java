package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebViewStore;", "", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "add", "", "webview", "get", "binderID", "", "remove", "plugin-appbrand-integration_release"})
public final class b
{
  private static final SparseArray<a> mHa;
  public static final b mHb;
  
  static
  {
    AppMethodBeat.i(175192);
    mHb = new b();
    mHa = new SparseArray();
    AppMethodBeat.o(175192);
  }
  
  public static void j(a parama)
  {
    AppMethodBeat.i(175189);
    p.h(parama, "webview");
    synchronized (mHa)
    {
      mHa.put(parama.getBinderID(), parama);
      parama = x.SXb;
      AppMethodBeat.o(175189);
      return;
    }
  }
  
  public static void k(a parama)
  {
    AppMethodBeat.i(175190);
    p.h(parama, "webview");
    synchronized (mHa)
    {
      mHa.remove(parama.getBinderID());
      parama = x.SXb;
      AppMethodBeat.o(175190);
      return;
    }
  }
  
  public static a xL(int paramInt)
  {
    AppMethodBeat.i(175191);
    synchronized (mHa)
    {
      a locala = (a)mHa.get(paramInt);
      AppMethodBeat.o(175191);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.b
 * JD-Core Version:    0.7.0.1
 */