package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.MutableContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ac.b;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.storage.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "tlJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;)V", "createCanvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "checkDrawChanged", "", "updateHeight", "enterHotZone", "", "exitHotZone", "Companion", "plugin-brandservice_release"})
public final class ab
  extends k
{
  public static final ab.a pwI;
  
  static
  {
    AppMethodBeat.i(195452);
    pwI = new ab.a((byte)0);
    AppMethodBeat.o(195452);
  }
  
  public ab(x paramx, com.tencent.mm.plugin.appbrand.appcache.p paramp1, com.tencent.mm.plugin.appbrand.appcache.p paramp2, b paramb)
  {
    super((c)paramx, paramp1, paramp2, paramb);
    AppMethodBeat.i(195451);
    AppMethodBeat.o(195451);
  }
  
  public final com.tencent.mm.plugin.webcanvas.a a(String paramString, MutableContextWrapper paramMutableContextWrapper, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195450);
    kotlin.g.b.p.h(paramString, "canvasId");
    kotlin.g.b.p.h(paramMutableContextWrapper, "contextWrapper");
    paramMutableContextWrapper = super.a(paramString, paramMutableContextWrapper, paramBoolean1, paramBoolean2);
    if (kotlin.g.b.p.j(paramString, "__biz_video_channel_canvas_id__"))
    {
      paramMutableContextWrapper.IyV = ((kotlin.g.a.a)c.pwK);
      paramMutableContextWrapper.IyW = ((kotlin.g.a.a)d.pwL);
    }
    r localr = r.NPl;
    if ((r.gzN()) && (n.J(paramString, "__ad_card_", false))) {
      paramMutableContextWrapper.IyX = ((kotlin.g.a.a)new b(paramString));
    }
    AppMethodBeat.o(195450);
    return paramMutableContextWrapper;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$createCanvasContext$1$3"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Float>
  {
    public static final c pwK;
    
    static
    {
      AppMethodBeat.i(195447);
      pwK = new c();
      AppMethodBeat.o(195447);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Float>
  {
    public static final d pwL;
    
    static
    {
      AppMethodBeat.i(195449);
      pwL = new d();
      AppMethodBeat.o(195449);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ab
 * JD-Core Version:    0.7.0.1
 */