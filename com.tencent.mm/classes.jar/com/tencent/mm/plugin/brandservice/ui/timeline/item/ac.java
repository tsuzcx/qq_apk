package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.MutableContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.aw.b;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.k;
import com.tencent.mm.storage.r;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "tlJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;)V", "createCanvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "checkDrawChanged", "", "updateHeight", "enterHotZone", "", "exitHotZone", "getEngineName", "onScreenShot", "Companion", "plugin-brandservice_release"})
public final class ac
  extends k
{
  public static final a sGe;
  
  static
  {
    AppMethodBeat.i(265221);
    sGe = new a((byte)0);
    AppMethodBeat.o(265221);
  }
  
  public ac(y paramy, com.tencent.mm.plugin.appbrand.appcache.p paramp1, com.tencent.mm.plugin.appbrand.appcache.p paramp2, b paramb)
  {
    super((c)paramy, paramp1, paramp2, paramb);
    AppMethodBeat.i(265220);
    AppMethodBeat.o(265220);
  }
  
  public final com.tencent.mm.plugin.webcanvas.a a(String paramString, MutableContextWrapper paramMutableContextWrapper, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(265218);
    kotlin.g.b.p.k(paramString, "canvasId");
    kotlin.g.b.p.k(paramMutableContextWrapper, "contextWrapper");
    paramMutableContextWrapper = super.a(paramString, paramMutableContextWrapper, paramBoolean1, paramBoolean2);
    if (kotlin.g.b.p.h(paramString, "__biz_video_channel_canvas_id__"))
    {
      paramMutableContextWrapper.PsY = ((kotlin.g.a.a)c.sGg);
      paramMutableContextWrapper.PsZ = ((kotlin.g.a.a)d.sGh);
    }
    r localr = r.VcW;
    if ((r.hvQ()) && (n.M(paramString, "__ad_card_", false))) {
      paramMutableContextWrapper.Pta = ((kotlin.g.a.a)new b(paramString));
    }
    AppMethodBeat.o(265218);
    return paramMutableContextWrapper;
  }
  
  public final String cAJ()
  {
    return "BizRenderJsEngine";
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$Companion;", "", "()V", "limitFontSize", "", "getLimitFontSize", "()F", "plugin-brandservice_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$createCanvasContext$1$3"})
  static final class b
    extends q
    implements kotlin.g.a.a<Boolean>
  {
    b(String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<Float>
  {
    public static final c sGg;
    
    static
    {
      AppMethodBeat.i(265889);
      sGg = new c();
      AppMethodBeat.o(265889);
    }
    
    c()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Float>
  {
    public static final d sGh;
    
    static
    {
      AppMethodBeat.i(265780);
      sGh = new d();
      AppMethodBeat.o(265780);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac
 * JD-Core Version:    0.7.0.1
 */