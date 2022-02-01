package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.y.a;
import com.tencent.mm.plugin.appbrand.jsapi.y.a.a;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class at
  implements e
{
  public static final a lEG;
  private a lEE;
  private final e lEF;
  private boolean rM;
  
  static
  {
    AppMethodBeat.i(50936);
    lEG = new a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public at(e parame)
  {
    AppMethodBeat.i(50935);
    this.lEF = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(ae paramae, a parama)
  {
    AppMethodBeat.i(50938);
    k.h(paramae, "page");
    if (ap.isMainThread())
    {
      localObject = paramae.Q(e.class);
      paramae = (ae)localObject;
      if (!(localObject instanceof at)) {
        paramae = null;
      }
      paramae = (at)paramae;
      if (paramae != null)
      {
        paramae.k(parama);
        AppMethodBeat.o(50938);
        return;
      }
      AppMethodBeat.o(50938);
      return;
    }
    Object localObject = paramae.getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new at.a.a(parama, paramae));
      AppMethodBeat.o(50938);
      return;
    }
    AppMethodBeat.o(50938);
  }
  
  private final void brk()
  {
    AppMethodBeat.i(50934);
    if (this.rM)
    {
      blp();
      AppMethodBeat.o(50934);
      return;
    }
    blo();
    if (this.lEE != null) {
      this.lEF.blp();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void blo()
  {
    AppMethodBeat.i(50932);
    this.rM = false;
    a locala = this.lEE;
    if ((locala != null) && (locala.getVisibility() == 0))
    {
      locala = this.lEE;
      if (locala == null) {
        k.fOy();
      }
      locala.blo();
      AppMethodBeat.o(50932);
      return;
    }
    this.lEF.blo();
    AppMethodBeat.o(50932);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(50933);
    this.rM = true;
    a locala = this.lEE;
    if (locala != null) {
      locala.blp();
    }
    this.lEF.blp();
    AppMethodBeat.o(50933);
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(50931);
    if ((k.g(this.lEE, parama) ^ true))
    {
      this.lEE = parama;
      brk();
      if (parama != null)
      {
        parama.a((a.a)new b(this));
        AppMethodBeat.o(50931);
        return;
      }
    }
    AppMethodBeat.o(50931);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper$Companion;", "", "()V", "TAG", "", "notifyHtmlViewChanged", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "htmlView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
    public static final class a
      implements Runnable
    {
      public a(a parama, ae paramae) {}
      
      public final void run()
      {
        AppMethodBeat.i(50929);
        Object localObject2 = this.lEI.Q(e.class);
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof at)) {
          localObject1 = null;
        }
        localObject1 = (at)localObject1;
        if (localObject1 != null)
        {
          ((at)localObject1).k(this.lEH);
          AppMethodBeat.o(50929);
          return;
        }
        AppMethodBeat.o(50929);
      }
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements a.a
  {
    b(at paramat) {}
    
    public final void blv()
    {
      AppMethodBeat.i(50930);
      at.a(this.lEJ);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at
 * JD-Core Version:    0.7.0.1
 */