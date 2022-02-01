package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ab.a;
import com.tencent.mm.plugin.appbrand.jsapi.ab.a.a;
import com.tencent.mm.plugin.appbrand.page.b.e;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/AppBrandHTMLWebView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class at
  implements e
{
  public static final at.a mek;
  private a mei;
  private final e mej;
  private boolean tG;
  
  static
  {
    AppMethodBeat.i(50936);
    mek = new at.a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public at(e parame)
  {
    AppMethodBeat.i(50935);
    this.mej = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(final ae paramae, a parama)
  {
    AppMethodBeat.i(50938);
    p.h(paramae, "page");
    Object localObject = (c)paramae;
    if (aq.isMainThread())
    {
      localObject = paramae.Q(e.class);
      paramae = (ae)localObject;
      if (!(localObject instanceof at)) {
        paramae = null;
      }
      paramae = (at)paramae;
      if (paramae != null)
      {
        paramae.m(parama);
        AppMethodBeat.o(50938);
        return;
      }
      AppMethodBeat.o(50938);
      return;
    }
    localObject = ((c)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new a.a(parama, paramae));
      AppMethodBeat.o(50938);
      return;
    }
    AppMethodBeat.o(50938);
  }
  
  private final void bvl()
  {
    AppMethodBeat.i(50934);
    if (this.tG)
    {
      bpa();
      AppMethodBeat.o(50934);
      return;
    }
    boZ();
    if (this.mei != null) {
      this.mej.bpa();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void boZ()
  {
    AppMethodBeat.i(50932);
    this.tG = false;
    a locala = this.mei;
    if ((locala != null) && (locala.getVisibility() == 0))
    {
      locala = this.mei;
      if (locala == null) {
        p.gfZ();
      }
      locala.boZ();
      AppMethodBeat.o(50932);
      return;
    }
    this.mej.boZ();
    AppMethodBeat.o(50932);
  }
  
  public final void bpa()
  {
    AppMethodBeat.i(50933);
    this.tG = true;
    a locala = this.mei;
    if (locala != null) {
      locala.bpa();
    }
    this.mej.bpa();
    AppMethodBeat.o(50933);
  }
  
  public final void m(a parama)
  {
    AppMethodBeat.i(50931);
    if ((p.i(this.mei, parama) ^ true))
    {
      this.mei = parama;
      bvl();
      if (parama != null)
      {
        parama.a((a.a)new b(this));
        AppMethodBeat.o(50931);
        return;
      }
    }
    AppMethodBeat.o(50931);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a$a
    implements Runnable
  {
    public a$a(a parama, ae paramae) {}
    
    public final void run()
    {
      AppMethodBeat.i(50929);
      Object localObject2 = paramae.Q(e.class);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof at)) {
        localObject1 = null;
      }
      localObject1 = (at)localObject1;
      if (localObject1 != null)
      {
        ((at)localObject1).m(this.mel);
        AppMethodBeat.o(50929);
        return;
      }
      AppMethodBeat.o(50929);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements a.a
  {
    b(at paramat) {}
    
    public final void bpg()
    {
      AppMethodBeat.i(50930);
      at.a(this.men);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.at
 * JD-Core Version:    0.7.0.1
 */