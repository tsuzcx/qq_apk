package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.page.f;
import com.tencent.mm.plugin.appbrand.ui.am;
import com.tencent.mm.plugin.appbrand.ui.at;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends bg
{
  private static final a.a syB;
  private am syC;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    syB = new a.a((byte)0);
    if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger())) {
      bool = true;
    }
    bg.iX(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final am k(final y paramy)
  {
    AppMethodBeat.i(175186);
    s.u(paramy, "service");
    Object localObject;
    if (this.syC == null)
    {
      paramy = paramy.getRuntime();
      if (paramy == null)
      {
        paramy = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramy;
      }
      paramy = (w)paramy;
      localObject = paramy.ccx();
      Context localContext = paramy.mContext;
      s.s(localContext, "rt.appContext");
      localObject = ((f)localObject).d(localContext, b.class);
      if (!paramy.aqJ()) {
        break label122;
      }
    }
    label122:
    for (paramy = (at)new b((Context)localObject, paramy);; paramy = (at)new c((Context)localObject, paramy))
    {
      this.syC = ((am)paramy);
      paramy = this.syC;
      if (paramy != null) {
        break;
      }
      s.bIx("wechatIMPL");
      AppMethodBeat.o(175186);
      return null;
    }
    AppMethodBeat.o(175186);
    return paramy;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$provideLayoutPropertiesProvider$2$1", "Lcom/tencent/luggage/game/ui/WAGameButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends com.tencent.luggage.game.f.a
  {
    b(Context paramContext, w paramw)
    {
      super();
      AppMethodBeat.i(326106);
      AppMethodBeat.o(326106);
    }
    
    public final Context getContext()
    {
      return this.syD;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$provideLayoutPropertiesProvider$2$2", "Lcom/tencent/mm/plugin/appbrand/ui/WxaMenuButtonLayoutPropertiesProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends at
  {
    c(Context paramContext, w paramw)
    {
      super();
      AppMethodBeat.i(326109);
      AppMethodBeat.o(326109);
    }
    
    public final Context getContext()
    {
      return this.syD;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */