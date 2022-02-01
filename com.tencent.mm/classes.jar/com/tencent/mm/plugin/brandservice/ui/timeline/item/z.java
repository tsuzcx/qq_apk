package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.content.MutableContextWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.q;
import com.tencent.mm.plugin.ay.b;
import com.tencent.mm.plugin.webcanvas.c;
import com.tencent.mm.plugin.webcanvas.i;
import com.tencent.mm.storage.r;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine;", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasRenderJsEngine;", "tlJsEngine", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;", "bizPkg", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;", "wxaPkg", "performanceReporter", "Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;", "(Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardJsEngine;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkg;Lcom/tencent/mm/plugin/webjsengine/WebCanvasPerformanceReporter;)V", "createCanvasContext", "Lcom/tencent/mm/plugin/webcanvas/WebCanvasContext;", "canvasId", "", "contextWrapper", "Landroid/content/MutableContextWrapper;", "checkDrawChanged", "", "updateHeight", "enterHotZone", "", "exitHotZone", "getEngineName", "onScreenShot", "Companion", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends i
{
  public static final a vLE;
  
  static
  {
    AppMethodBeat.i(302769);
    vLE = new a((byte)0);
    AppMethodBeat.o(302769);
  }
  
  public z(BizTLRecCardJsEngine paramBizTLRecCardJsEngine, q paramq1, q paramq2, b paramb)
  {
    super((c)paramBizTLRecCardJsEngine, paramq1, paramq2, paramb);
    AppMethodBeat.i(302763);
    AppMethodBeat.o(302763);
  }
  
  public final com.tencent.mm.plugin.webcanvas.a a(String paramString, MutableContextWrapper paramMutableContextWrapper, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(302777);
    s.u(paramString, "canvasId");
    s.u(paramMutableContextWrapper, "contextWrapper");
    paramMutableContextWrapper = super.a(paramString, paramMutableContextWrapper, paramBoolean1, paramBoolean2);
    if (s.p(paramString, "__biz_video_channel_canvas_id__"))
    {
      paramMutableContextWrapper.WjQ = ((kotlin.g.a.a)b.vLF);
      paramMutableContextWrapper.WjR = ((kotlin.g.a.a)c.vLG);
    }
    r localr = r.acDM;
    if ((r.iXp()) && (n.U(paramString, "__ad_card_", false))) {
      paramMutableContextWrapper.WjS = ((kotlin.g.a.a)new d(paramString));
    }
    AppMethodBeat.o(302777);
    return paramMutableContextWrapper;
  }
  
  public final void ajb(String paramString)
  {
    AppMethodBeat.i(369884);
    s.u(paramString, "canvasId");
    i.a((i)this, "exitHotZone", paramString);
    AppMethodBeat.o(369884);
  }
  
  public final String ddM()
  {
    return "BizRenderJsEngine";
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardRenderJsEngine$Companion;", "", "()V", "limitFontSize", "", "getLimitFontSize", "()F", "plugin-brandservice_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Float>
  {
    public static final b vLF;
    
    static
    {
      AppMethodBeat.i(302842);
      vLF = new b();
      AppMethodBeat.o(302842);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<Float>
  {
    public static final c vLG;
    
    static
    {
      AppMethodBeat.i(302837);
      vLG = new c();
      AppMethodBeat.o(302837);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    d(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.z
 * JD-Core Version:    0.7.0.1
 */