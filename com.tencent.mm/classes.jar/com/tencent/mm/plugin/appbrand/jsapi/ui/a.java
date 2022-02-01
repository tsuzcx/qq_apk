package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.ad;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.k;
import d.l;
import d.v;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends au
{
  @Deprecated
  public static final a klT;
  private y klS;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    klT = new a((byte)0);
    if (bu.eGT()) {
      bool = true;
    }
    au.fM(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final y h(q paramq)
  {
    AppMethodBeat.i(175186);
    k.h(paramq, "service");
    if (((a)this).klS == null)
    {
      paramq = paramq.getRuntime();
      if (paramq == null)
      {
        paramq = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramq;
      }
      Object localObject = (o)paramq;
      paramq = ((o)localObject).aMQ();
      localObject = ((o)localObject).getAppContext();
      k.g(localObject, "rt.appContext");
      this.klS = ((y)new ad(paramq.d((Context)localObject, b.class)));
    }
    paramq = this.klS;
    if (paramq == null) {
      k.aPZ("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return paramq;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$Companion;", "", "()V", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */