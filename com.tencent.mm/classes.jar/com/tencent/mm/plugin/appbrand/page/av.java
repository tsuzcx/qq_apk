package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.af.a;
import com.tencent.mm.plugin.appbrand.jsapi.af.a.a;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class av
  implements e
{
  public static final a nsY;
  private a nsW;
  private final e nsX;
  private boolean tN;
  
  static
  {
    AppMethodBeat.i(50936);
    nsY = new a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public av(e parame)
  {
    AppMethodBeat.i(50935);
    this.nsX = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(ag paramag, a parama)
  {
    AppMethodBeat.i(50938);
    p.h(paramag, "page");
    Object localObject = (d)paramag;
    if (MMHandlerThread.isMainThread())
    {
      localObject = paramag.S(e.class);
      paramag = (ag)localObject;
      if (!(localObject instanceof av)) {
        paramag = null;
      }
      paramag = (av)paramag;
      if (paramag != null)
      {
        paramag.m(parama);
        AppMethodBeat.o(50938);
        return;
      }
      AppMethodBeat.o(50938);
      return;
    }
    localObject = ((d)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new av.a.a(parama, paramag));
      AppMethodBeat.o(50938);
      return;
    }
    AppMethodBeat.o(50938);
  }
  
  private final void bSb()
  {
    AppMethodBeat.i(50934);
    if (this.tN)
    {
      bLq();
      AppMethodBeat.o(50934);
      return;
    }
    bLp();
    if (this.nsW != null) {
      this.nsX.bLq();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void bLp()
  {
    AppMethodBeat.i(50932);
    this.tN = false;
    a locala = this.nsW;
    if ((locala != null) && (locala.getVisibility() == 0))
    {
      locala = this.nsW;
      if (locala == null) {
        p.hyc();
      }
      locala.bLp();
      AppMethodBeat.o(50932);
      return;
    }
    this.nsX.bLp();
    AppMethodBeat.o(50932);
  }
  
  public final void bLq()
  {
    AppMethodBeat.i(50933);
    this.tN = true;
    a locala = this.nsW;
    if (locala != null) {
      locala.bLq();
    }
    this.nsX.bLq();
    AppMethodBeat.o(50933);
  }
  
  public final void m(a parama)
  {
    AppMethodBeat.i(50931);
    if ((p.j(this.nsW, parama) ^ true))
    {
      this.nsW = parama;
      bSb();
      if (parama != null)
      {
        parama.a((a.a)new b(this));
        AppMethodBeat.o(50931);
        return;
      }
    }
    AppMethodBeat.o(50931);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper$Companion;", "", "()V", "TAG", "", "notifyHtmlViewChanged", "", "page", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageViewWC;", "htmlView", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "plugin-appbrand-integration_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
    public static final class a
      implements Runnable
    {
      public a(a parama, ag paramag) {}
      
      public final void run()
      {
        AppMethodBeat.i(50929);
        Object localObject2 = this.nta.S(e.class);
        Object localObject1 = localObject2;
        if (!(localObject2 instanceof av)) {
          localObject1 = null;
        }
        localObject1 = (av)localObject1;
        if (localObject1 != null)
        {
          ((av)localObject1).m(this.nsZ);
          AppMethodBeat.o(50929);
          return;
        }
        AppMethodBeat.o(50929);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements a.a
  {
    b(av paramav) {}
    
    public final void bLw()
    {
      AppMethodBeat.i(50930);
      av.a(this.ntb);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.av
 * JD-Core Version:    0.7.0.1
 */