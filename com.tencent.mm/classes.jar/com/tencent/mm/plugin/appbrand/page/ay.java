package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.a;
import com.tencent.mm.plugin.appbrand.jsapi.z.a.a;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class ay
  implements e
{
  public static final ay.a leQ;
  private a leO;
  private final e leP;
  private boolean qM;
  
  static
  {
    AppMethodBeat.i(50936);
    leQ = new ay.a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public ay(e parame)
  {
    AppMethodBeat.i(50935);
    this.leP = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(final ae paramae, a parama)
  {
    AppMethodBeat.i(50938);
    k.h(paramae, "page");
    if (aq.isMainThread())
    {
      localObject = paramae.Q(e.class);
      paramae = (ae)localObject;
      if (!(localObject instanceof ay)) {
        paramae = null;
      }
      paramae = (ay)paramae;
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
      ((View)localObject).post((Runnable)new a.a(parama, paramae));
      AppMethodBeat.o(50938);
      return;
    }
    AppMethodBeat.o(50938);
  }
  
  private final void bkv()
  {
    AppMethodBeat.i(50934);
    if (this.qM)
    {
      bev();
      AppMethodBeat.o(50934);
      return;
    }
    beu();
    if (this.leO != null) {
      this.leP.bev();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void beu()
  {
    AppMethodBeat.i(50932);
    this.qM = false;
    a locala = this.leO;
    if ((locala != null) && (locala.getVisibility() == 0))
    {
      locala = this.leO;
      if (locala == null) {
        k.fvU();
      }
      locala.beu();
      AppMethodBeat.o(50932);
      return;
    }
    this.leP.beu();
    AppMethodBeat.o(50932);
  }
  
  public final void bev()
  {
    AppMethodBeat.i(50933);
    this.qM = true;
    a locala = this.leO;
    if (locala != null) {
      locala.bev();
    }
    this.leP.bev();
    AppMethodBeat.o(50933);
  }
  
  public final void k(a parama)
  {
    AppMethodBeat.i(50931);
    if ((k.g(this.leO, parama) ^ true))
    {
      this.leO = parama;
      bkv();
      if (parama != null)
      {
        parama.a((a.a)new b(this));
        AppMethodBeat.o(50931);
        return;
      }
    }
    AppMethodBeat.o(50931);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a$a
    implements Runnable
  {
    public a$a(a parama, ae paramae) {}
    
    public final void run()
    {
      AppMethodBeat.i(50929);
      Object localObject2 = paramae.Q(e.class);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ay)) {
        localObject1 = null;
      }
      localObject1 = (ay)localObject1;
      if (localObject1 != null)
      {
        ((ay)localObject1).k(this.leR);
        AppMethodBeat.o(50929);
        return;
      }
      AppMethodBeat.o(50929);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements a.a
  {
    b(ay paramay) {}
    
    public final void beB()
    {
      AppMethodBeat.i(50930);
      ay.a(this.leT);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ay
 * JD-Core Version:    0.7.0.1
 */