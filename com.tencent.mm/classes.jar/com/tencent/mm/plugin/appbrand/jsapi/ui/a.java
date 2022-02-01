package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aw;
import com.tencent.mm.plugin.appbrand.page.c;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.ui.aa;
import com.tencent.mm.plugin.appbrand.ui.af;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.bv;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends aw
{
  @Deprecated
  public static final a lom;
  private aa lol;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    lom = new a((byte)0);
    if (bv.fpT()) {
      bool = true;
    }
    aw.gl(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final aa h(r paramr)
  {
    AppMethodBeat.i(175186);
    d.g.b.p.h(paramr, "service");
    if (((a)this).lol == null)
    {
      paramr = paramr.getRuntime();
      if (paramr == null)
      {
        paramr = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramr;
      }
      Object localObject = (com.tencent.mm.plugin.appbrand.p)paramr;
      paramr = ((com.tencent.mm.plugin.appbrand.p)localObject).aXl();
      localObject = ((com.tencent.mm.plugin.appbrand.p)localObject).getAppContext();
      d.g.b.p.g(localObject, "rt.appContext");
      this.lol = ((aa)new af(paramr.d((Context)localObject, b.class)));
    }
    paramr = this.lol;
    if (paramr == null) {
      d.g.b.p.bdF("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return paramr;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$Companion;", "", "()V", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */