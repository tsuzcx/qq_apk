package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.ac;
import com.tencent.mm.plugin.appbrand.ui.x;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.v;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends au
{
  @Deprecated
  public static final a kNl;
  private x kNk;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    kNl = new a((byte)0);
    if (bt.eWo()) {
      bool = true;
    }
    au.gi(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final x h(q paramq)
  {
    AppMethodBeat.i(175186);
    k.h(paramq, "service");
    if (((a)this).kNk == null)
    {
      paramq = paramq.getRuntime();
      if (paramq == null)
      {
        paramq = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramq;
      }
      Object localObject = (o)paramq;
      paramq = ((o)localObject).aTG();
      localObject = ((o)localObject).getAppContext();
      k.g(localObject, "rt.appContext");
      this.kNk = ((x)new ac(paramq.d((Context)localObject, b.class)));
    }
    paramq = this.kNk;
    if (paramq == null) {
      k.aVY("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return paramq;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC$Companion;", "", "()V", "plugin-appbrand-integration_release"})
  static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */