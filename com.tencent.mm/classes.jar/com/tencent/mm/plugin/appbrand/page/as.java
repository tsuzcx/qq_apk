package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.a;
import com.tencent.mm.plugin.appbrand.jsapi.ac.a.a;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.sdk.platformtools.ar;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class as
  implements e
{
  public static final a miE;
  private a miC;
  private final e miD;
  private boolean tG;
  
  static
  {
    AppMethodBeat.i(50936);
    miE = new a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public as(e parame)
  {
    AppMethodBeat.i(50935);
    this.miD = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(ad paramad, a parama)
  {
    AppMethodBeat.i(50938);
    p.h(paramad, "page");
    Object localObject = (b)paramad;
    if (ar.isMainThread())
    {
      localObject = paramad.Q(e.class);
      paramad = (ad)localObject;
      if (!(localObject instanceof as)) {
        paramad = null;
      }
      paramad = (as)paramad;
      if (paramad != null)
      {
        paramad.m(parama);
        AppMethodBeat.o(50938);
        return;
      }
      AppMethodBeat.o(50938);
      return;
    }
    localObject = ((b)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new as.a.a(parama, paramad));
      AppMethodBeat.o(50938);
      return;
    }
    AppMethodBeat.o(50938);
  }
  
  private final void bvW()
  {
    AppMethodBeat.i(50934);
    if (this.tG)
    {
      bpK();
      AppMethodBeat.o(50934);
      return;
    }
    bpJ();
    if (this.miC != null) {
      this.miD.bpK();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void bpJ()
  {
    AppMethodBeat.i(50932);
    this.tG = false;
    a locala = this.miC;
    if ((locala != null) && (locala.getVisibility() == 0))
    {
      locala = this.miC;
      if (locala == null) {
        p.gkB();
      }
      locala.bpJ();
      AppMethodBeat.o(50932);
      return;
    }
    this.miD.bpJ();
    AppMethodBeat.o(50932);
  }
  
  public final void bpK()
  {
    AppMethodBeat.i(50933);
    this.tG = true;
    a locala = this.miC;
    if (locala != null) {
      locala.bpK();
    }
    this.miD.bpK();
    AppMethodBeat.o(50933);
  }
  
  public final void m(a parama)
  {
    AppMethodBeat.i(50931);
    if ((p.i(this.miC, parama) ^ true))
    {
      this.miC = parama;
      bvW();
      if (parama != null)
      {
        parama.a((a.a)new b(this));
        AppMethodBeat.o(50931);
        return;
      }
    }
    AppMethodBeat.o(50931);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper$Companion;", "", "()V", "TAG", "", "notifyHtmlViewChanged", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "htmlView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
    public static final class a
      implements Runnable
    {
      public a(a parama, ad paramad) {}
      
      public final void run()
      {
        AppMethodBeat.i(50929);
        Object localObject2 = this.miG.Q(e.class);
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof as)) {
          localObject1 = null;
        }
        localObject1 = (as)localObject1;
        if (localObject1 != null)
        {
          ((as)localObject1).m(this.miF);
          AppMethodBeat.o(50929);
          return;
        }
        AppMethodBeat.o(50929);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements a.a
  {
    b(as paramas) {}
    
    public final void bpQ()
    {
      AppMethodBeat.i(50930);
      as.a(this.miH);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.as
 * JD-Core Version:    0.7.0.1
 */