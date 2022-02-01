package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bd;
import com.tencent.mm.plugin.appbrand.page.e;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.ui.al;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends bd
{
  @Deprecated
  public static final a.a ptp;
  private af pto;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    ptp = new a.a((byte)0);
    if (WeChatEnvironment.hasDebugger()) {
      bool = true;
    }
    bd.hY(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final af j(final v paramv)
  {
    AppMethodBeat.i(175186);
    p.k(paramv, "service");
    if (((a)this).pto == null)
    {
      paramv = paramv.getRuntime();
      if (paramv == null)
      {
        paramv = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramv;
      }
      paramv = (com.tencent.mm.plugin.appbrand.t)paramv;
      e locale = paramv.bDh();
      Context localContext = paramv.getAppContext();
      p.j(localContext, "rt.appContext");
      this.pto = ((af)new b(locale.c(localContext, b.class), paramv, (AppBrandRuntime)paramv));
    }
    paramv = this.pto;
    if (paramv == null) {
      p.bGy("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return paramv;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$provideLayoutPropertiesProvider$2$1", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "plugin-appbrand-integration_release"})
  public static final class b
    extends al
  {
    b(Context paramContext, com.tencent.mm.plugin.appbrand.t paramt, AppBrandRuntime paramAppBrandRuntime)
    {
      super();
    }
    
    public final Context getContext()
    {
      return this.ptq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */