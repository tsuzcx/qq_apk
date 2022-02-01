package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoaderManager;", "", "()V", "iconLoaderMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoader;", "Lkotlin/collections/HashMap;", "getIconLoaderInner", "iconPath", "", "errorHandler", "Lcom/tencent/mm/plugin/appbrand/widget/tabbar/IconLoadErrorHandler;", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "getSpecificLoader", "index", "isPackageIcon", "", "luggage-wxa-app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private final HashMap<Integer, d> uSi;
  
  public f()
  {
    AppMethodBeat.i(135628);
    this.uSi = new HashMap();
    AppMethodBeat.o(135628);
  }
  
  private static final void a(f paramf, int paramInt)
  {
    AppMethodBeat.i(324113);
    s.u(paramf, "this$0");
    if (paramInt >= 0) {
      ((Map)paramf.uSi).put(Integer.valueOf(paramInt), null);
    }
    AppMethodBeat.o(324113);
  }
  
  public final d a(String paramString, c paramc, y paramy, int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(135625);
    s.u(paramString, "iconPath");
    s.u(paramc, "errorHandler");
    s.u(paramy, "service");
    int i;
    if ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString)))
    {
      i = 1;
      if (1 != i) {
        break label137;
      }
      paramString = (d)new g(paramString, paramc, paramy);
    }
    for (;;)
    {
      paramString.index = paramInt;
      paramString.uSg = new f..ExternalSyntheticLambda0(this);
      paramc = (d)this.uSi.get(Integer.valueOf(paramInt));
      if (paramc != null) {
        paramc.cancel();
      }
      ((Map)this.uSi).put(Integer.valueOf(paramInt), paramString);
      AppMethodBeat.o(135625);
      return paramString;
      i = 0;
      break;
      label137:
      if (true == n.U(paramString, "wxfile://", false))
      {
        paramString = (d)new i(paramString, paramc, paramy);
      }
      else
      {
        if ((!n.rs(paramString, ".png")) && (!n.rs(paramString, ".jpg")) && (!n.rs(paramString, ".bmp")))
        {
          i = j;
          if (!n.rs(paramString, ".gif")) {}
        }
        else
        {
          i = 1;
        }
        if (1 == i) {
          paramString = (d)new h(paramString, paramc, paramy);
        } else {
          paramString = (d)new b(paramString, paramc);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.f
 * JD-Core Version:    0.7.0.1
 */