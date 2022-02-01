package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"})
public final class f
{
  final HashMap<Integer, d> oFi;
  
  public f()
  {
    AppMethodBeat.i(135628);
    this.oFi = new HashMap();
    AppMethodBeat.o(135628);
  }
  
  private static d a(String paramString, c paramc, s params)
  {
    AppMethodBeat.i(135626);
    if ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))) {}
    for (int i = 1; 1 == i; i = 0)
    {
      paramString = (d)new g(paramString, paramc, params);
      AppMethodBeat.o(135626);
      return paramString;
    }
    if (true == n.J(paramString, "wxfile://", false))
    {
      paramString = (d)new i(paramString, paramc, params);
      AppMethodBeat.o(135626);
      return paramString;
    }
    if (true == agl(paramString))
    {
      paramString = (d)new h(paramString, paramc, params);
      AppMethodBeat.o(135626);
      return paramString;
    }
    paramString = (d)new b(paramString, paramc);
    AppMethodBeat.o(135626);
    return paramString;
  }
  
  private static boolean agl(String paramString)
  {
    AppMethodBeat.i(135627);
    if ((n.K(paramString, ".png", false)) || (n.K(paramString, ".jpg", false)) || (n.K(paramString, ".bmp", false)) || (n.K(paramString, ".gif", false)))
    {
      AppMethodBeat.o(135627);
      return true;
    }
    AppMethodBeat.o(135627);
    return false;
  }
  
  public final d a(String paramString, c paramc, s params, int paramInt)
  {
    AppMethodBeat.i(135625);
    p.h(paramString, "iconPath");
    p.h(paramc, "errorHandler");
    p.h(params, "service");
    paramString = a(paramString, paramc, params);
    paramString.setIndex(paramInt);
    paramString.a((d.a)new a(this));
    paramc = (d)this.oFi.get(Integer.valueOf(paramInt));
    if (paramc != null) {
      paramc.cancel();
    }
    ((Map)this.oFi).put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(135625);
    return paramString;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "destroy"})
  static final class a
    implements d.a
  {
    a(f paramf) {}
    
    public final void destroy(int paramInt)
    {
      AppMethodBeat.i(135624);
      if (paramInt >= 0) {
        ((Map)this.oFj.oFi).put(Integer.valueOf(paramInt), null);
      }
      AppMethodBeat.o(135624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.f
 * JD-Core Version:    0.7.0.1
 */