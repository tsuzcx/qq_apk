package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.ag;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends bg
{
  @Deprecated
  public static final a muS;
  private ag muR;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    muS = new a((byte)0);
    if (WeChatEnvironment.hasDebugger()) {
      bool = true;
    }
    bg.hi(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final ag j(final s params)
  {
    AppMethodBeat.i(175186);
    p.h(params, "service");
    if (((a)this).muR == null)
    {
      params = params.getRuntime();
      if (params == null)
      {
        params = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw params;
      }
      params = (q)params;
      e locale = params.bsn();
      Context localContext = params.getAppContext();
      p.g(localContext, "rt.appContext");
      this.muR = ((ag)new b(locale.c(localContext, b.class), params, (AppBrandRuntime)params));
    }
    params = this.muR;
    if (params == null) {
      p.btv("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return params;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$Companion;", "", "()V", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$provideLayoutPropertiesProvider$2$1", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "plugin-appbrand-integration_release"})
  public static final class b
    extends al
  {
    b(Context paramContext, q paramq, AppBrandRuntime paramAppBrandRuntime)
    {
      super();
    }
    
    public final Context getContext()
    {
      return this.muT;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */