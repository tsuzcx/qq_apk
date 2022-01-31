package com.tencent.mm.plugin.appbrand.widget.i;

import a.f.b.j;
import a.l;
import a.l.m;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r;
import java.util.HashMap;
import java.util.Map;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"})
public final class f
{
  final HashMap<Integer, d> jxg;
  
  public f()
  {
    AppMethodBeat.i(87611);
    this.jxg = new HashMap();
    AppMethodBeat.o(87611);
  }
  
  private static boolean Gd(String paramString)
  {
    AppMethodBeat.i(87610);
    if ((m.jx(paramString, ".png")) || (m.jx(paramString, ".jpg")) || (m.jx(paramString, ".bmp")) || (m.jx(paramString, ".gif")))
    {
      AppMethodBeat.o(87610);
      return true;
    }
    AppMethodBeat.o(87610);
    return false;
  }
  
  private static d a(String paramString, c paramc, r paramr)
  {
    AppMethodBeat.i(87609);
    if ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))) {}
    for (int i = 1; 1 == i; i = 0)
    {
      paramString = (d)new g(paramString, paramc, paramr);
      AppMethodBeat.o(87609);
      return paramString;
    }
    if (true == m.jw(paramString, "wxfile://"))
    {
      paramString = (d)new i(paramString, paramc, paramr);
      AppMethodBeat.o(87609);
      return paramString;
    }
    if (true == Gd(paramString))
    {
      paramString = (d)new h(paramString, paramc, paramr);
      AppMethodBeat.o(87609);
      return paramString;
    }
    paramString = (d)new b(paramString, paramc);
    AppMethodBeat.o(87609);
    return paramString;
  }
  
  public final d a(String paramString, c paramc, r paramr, int paramInt)
  {
    AppMethodBeat.i(87608);
    j.q(paramString, "iconPath");
    j.q(paramc, "errorHandler");
    j.q(paramr, "service");
    paramString = a(paramString, paramc, paramr);
    paramString.setIndex(paramInt);
    paramString.a((d.a)new a(this));
    paramc = (d)this.jxg.get(Integer.valueOf(paramInt));
    if (paramc != null) {
      paramc.cancel();
    }
    ((Map)this.jxg).put(Integer.valueOf(paramInt), paramString);
    AppMethodBeat.o(87608);
    return paramString;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "", "destroy"})
  static final class a
    implements d.a
  {
    a(f paramf) {}
    
    public final void destroy(int paramInt)
    {
      AppMethodBeat.i(87607);
      if (paramInt >= 0) {
        ((Map)this.jxh.jxg).put(Integer.valueOf(paramInt), null);
      }
      AppMethodBeat.o(87607);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.f
 * JD-Core Version:    0.7.0.1
 */