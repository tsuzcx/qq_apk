package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c.a;
import com.tencent.mm.plugin.appbrand.page.a.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"})
public final class ax
  implements e
{
  public static final ax.a quR;
  private boolean lzZ;
  private g.c quP;
  private final e quQ;
  
  static
  {
    AppMethodBeat.i(50936);
    quR = new ax.a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public ax(e parame)
  {
    AppMethodBeat.i(50935);
    this.quQ = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(final ah paramah, g.c paramc)
  {
    AppMethodBeat.i(284464);
    p.k(paramah, "page");
    Object localObject = (d)paramah;
    if (MMHandlerThread.isMainThread())
    {
      localObject = paramah.R(e.class);
      paramah = (ah)localObject;
      if (!(localObject instanceof ax)) {
        paramah = null;
      }
      paramah = (ax)paramah;
      if (paramah != null)
      {
        paramah.d(paramc);
        AppMethodBeat.o(284464);
        return;
      }
      AppMethodBeat.o(284464);
      return;
    }
    localObject = ((d)localObject).getContentView();
    if (localObject != null)
    {
      ((View)localObject).post((Runnable)new a.a(paramc, paramah));
      AppMethodBeat.o(284464);
      return;
    }
    AppMethodBeat.o(284464);
  }
  
  private final void ceY()
  {
    AppMethodBeat.i(50934);
    if (this.lzZ)
    {
      bXr();
      AppMethodBeat.o(50934);
      return;
    }
    bXq();
    if (this.quP != null) {
      this.quQ.bXr();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void bXq()
  {
    AppMethodBeat.i(50932);
    this.lzZ = false;
    Object localObject = this.quP;
    if (localObject != null)
    {
      localObject = ((g.c)localObject).getAndroidView();
      if ((localObject != null) && (((View)localObject).getVisibility() == 0))
      {
        localObject = this.quP;
        if (localObject == null) {
          p.iCn();
        }
        ((g.c)localObject).bXq();
        AppMethodBeat.o(50932);
        return;
      }
    }
    this.quQ.bXq();
    AppMethodBeat.o(50932);
  }
  
  public final void bXr()
  {
    AppMethodBeat.i(50933);
    this.lzZ = true;
    g.c localc = this.quP;
    if (localc != null) {
      localc.bXr();
    }
    this.quQ.bXr();
    AppMethodBeat.o(50933);
  }
  
  public final void d(g.c paramc)
  {
    AppMethodBeat.i(284463);
    if ((p.h(this.quP, paramc) ^ true))
    {
      this.quP = paramc;
      ceY();
      if (paramc != null)
      {
        paramc.a((g.c.a)new b(this));
        AppMethodBeat.o(284463);
        return;
      }
    }
    AppMethodBeat.o(284463);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa$runOnUiThread$1"})
  public static final class a$a
    implements Runnable
  {
    public a$a(g.c paramc, ah paramah) {}
    
    public final void run()
    {
      AppMethodBeat.i(50929);
      Object localObject2 = paramah.R(e.class);
      Object localObject1 = localObject2;
      if (!(localObject2 instanceof ax)) {
        localObject1 = null;
      }
      localObject1 = (ax)localObject1;
      if (localObject1 != null)
      {
        ((ax)localObject1).d(this.quS);
        AppMethodBeat.o(50929);
        return;
      }
      AppMethodBeat.o(50929);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "onVisibilityChanged"})
  static final class b
    implements g.c.a
  {
    b(ax paramax) {}
    
    public final void bXz()
    {
      AppMethodBeat.i(50930);
      ax.a(this.quU);
      AppMethodBeat.o(50930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax
 * JD-Core Version:    0.7.0.1
 */