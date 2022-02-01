package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.q;
import d.g.b.p;
import d.l;
import d.n.n;
import java.util.HashMap;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"})
public final class f
{
  final HashMap<Integer, d> npU;
  
  public f()
  {
    AppMethodBeat.i(135628);
    this.npU = new HashMap();
    AppMethodBeat.o(135628);
  }
  
  private static boolean VG(String paramString)
  {
    AppMethodBeat.i(135627);
    if ((n.nA(paramString, ".png")) || (n.nA(paramString, ".jpg")) || (n.nA(paramString, ".bmp")) || (n.nA(paramString, ".gif")))
    {
      AppMethodBeat.o(135627);
      return true;
    }
    AppMethodBeat.o(135627);
    return false;
  }
  
  private static d a(String paramString, c paramc, q paramq)
  {
    AppMethodBeat.i(135626);
    if ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))) {}
    for (int i = 1; 1 == i; i = 0)
    {
      paramString = (d)new g(paramString, paramc, paramq);
      AppMethodBeat.o(135626);
      return paramString;
    }
    if (true == n.nz(paramString, "wxfile://"))
    {
      paramString = (d)new i(paramString, paramc, paramq);
      AppMethodBeat.o(135626);
      return paramString;
    }
    if (true == VG(paramString))
    {
      paramString = (d)new h(paramString, paramc, paramq);
      AppMethodBeat.o(135626);
      return paramString;
    }
    paramString = (d)new b(paramString, paramc);
    AppMethodBeat.o(135626);
    return paramString;
  }
  
  public final d a(String paramString, c paramc, q paramq, int paramInt)
  {
    AppMethodBeat.i(135625);
    p.h(paramString, "iconPath");
    p.h(paramc, "errorHandler");
    p.h(paramq, "service");
    paramString = a(paramString, paramc, paramq);
    paramString.setIndex(paramInt);
    paramString.a((d.a)new a(this));
    paramc = (d)this.npU.get(Integer.valueOf(paramInt));
    if (paramc != null) {
      paramc.cancel();
    }
    ((Map)this.npU).put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(135625);
    return paramString;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "destroy"})
  static final class a
    implements d.a
  {
    a(f paramf) {}
    
    public final void destroy(int paramInt)
    {
      AppMethodBeat.i(135624);
      if (paramInt >= 0) {
        ((Map)this.npV.npU).put(Integer.valueOf(paramInt), null);
      }
      AppMethodBeat.o(135624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.f
 * JD-Core Version:    0.7.0.1
 */