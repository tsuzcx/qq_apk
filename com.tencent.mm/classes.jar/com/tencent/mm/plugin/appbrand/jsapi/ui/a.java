package com.tencent.mm.plugin.appbrand.jsapi.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aw;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.d;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.ui.ae;
import com.tencent.mm.plugin.appbrand.ui.z;
import com.tencent.mm.plugin.appbrand.widget.actionbar.b;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/ui/JsApiGetMenuButtonBoundingClientRectWC;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiGetMenuButtonBoundingClientRect;", "()V", "wechatIMPL", "Lcom/tencent/mm/plugin/appbrand/ui/IMenuButtonLayoutPropertiesProvider;", "provideLayoutPropertiesProvider", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "Companion", "plugin-appbrand-integration_release"})
public final class a
  extends aw
{
  @Deprecated
  public static final a.a ljO;
  private z ljN;
  
  static
  {
    boolean bool = false;
    AppMethodBeat.i(180478);
    ljO = new a.a((byte)0);
    if (bu.flY()) {
      bool = true;
    }
    aw.gn(bool);
    AppMethodBeat.o(180478);
  }
  
  public a()
  {
    AppMethodBeat.i(175187);
    AppMethodBeat.o(175187);
  }
  
  public final z h(q paramq)
  {
    AppMethodBeat.i(175186);
    p.h(paramq, "service");
    if (((a)this).ljN == null)
    {
      paramq = paramq.getRuntime();
      if (paramq == null)
      {
        paramq = new v("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.AppBrandRuntimeWC");
        AppMethodBeat.o(175186);
        throw paramq;
      }
      Object localObject = (o)paramq;
      paramq = ((o)localObject).aWQ();
      localObject = ((o)localObject).getAppContext();
      p.g(localObject, "rt.appContext");
      this.ljN = ((z)new ae(paramq.d((Context)localObject, b.class)));
    }
    paramq = this.ljN;
    if (paramq == null) {
      p.bcb("wechatIMPL");
    }
    AppMethodBeat.o(175186);
    return paramq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ui.a
 * JD-Core Version:    0.7.0.1
 */