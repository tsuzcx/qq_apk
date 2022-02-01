package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.f;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper;", "Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;", "originExtension", "(Lcom/tencent/mm/plugin/appbrand/page/extensions/AppBrandPageViewPauseRenderingExtension;)V", "value", "Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "htmlView", "getHtmlView", "()Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;", "setHtmlView", "(Lcom/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewContract$IView;)V", "paused", "", "pauseRendering", "", "resetRenderingState", "restoreRendering", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ax
  implements e
{
  public static final ax.a tzG;
  private boolean orA;
  private final e tzH;
  private g.c tzI;
  
  static
  {
    AppMethodBeat.i(50936);
    tzG = new ax.a((byte)0);
    AppMethodBeat.o(50936);
  }
  
  public ax(e parame)
  {
    AppMethodBeat.i(50935);
    this.tzH = parame;
    AppMethodBeat.o(50935);
  }
  
  public static final void a(ah paramah, final g.c paramc)
  {
    AppMethodBeat.i(325191);
    s.u(paramah, "page");
    paramah.a((i.f)new a.a(paramah, paramc));
    AppMethodBeat.o(325191);
  }
  
  private static final void a(ax paramax, int paramInt)
  {
    AppMethodBeat.i(325188);
    s.u(paramax, "this$0");
    paramax.cFN();
    AppMethodBeat.o(325188);
  }
  
  private final void cFN()
  {
    AppMethodBeat.i(50934);
    if (this.orA)
    {
      cxD();
      AppMethodBeat.o(50934);
      return;
    }
    cxC();
    if (this.tzI != null) {
      this.tzH.cxD();
    }
    AppMethodBeat.o(50934);
  }
  
  public final void cxC()
  {
    int j = 0;
    AppMethodBeat.i(50932);
    this.orA = false;
    Object localObject = this.tzI;
    int i = j;
    if (localObject != null)
    {
      localObject = ((g.c)localObject).getAndroidView();
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((View)localObject).getVisibility() == 0) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      localObject = this.tzI;
      s.checkNotNull(localObject);
      ((g.c)localObject).cxC();
      AppMethodBeat.o(50932);
      return;
    }
    this.tzH.cxC();
    AppMethodBeat.o(50932);
  }
  
  public final void cxD()
  {
    AppMethodBeat.i(50933);
    this.orA = true;
    g.c localc = this.tzI;
    if (localc != null) {
      localc.cxD();
    }
    this.tzH.cxD();
    AppMethodBeat.o(50933);
  }
  
  public final void d(g.c paramc)
  {
    AppMethodBeat.i(325195);
    if (!s.p(this.tzI, paramc))
    {
      this.tzI = paramc;
      cFN();
      if (paramc != null) {
        paramc.a(new ax..ExternalSyntheticLambda0(this));
      }
    }
    AppMethodBeat.o(325195);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/page/CustomPauseRenderingExtensionWrapper$Companion$notifyHtmlViewChanged$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "onReady", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a$a
    implements i.f
  {
    a$a(ah paramah, g.c paramc) {}
    
    public final void onReady()
    {
      AppMethodBeat.i(324883);
      Object localObject = this.ryq.aa(e.class);
      if ((localObject instanceof ax)) {}
      for (localObject = (ax)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((ax)localObject).d(paramc);
        }
        this.ryq.b((i.f)this);
        AppMethodBeat.o(324883);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ax
 * JD-Core Version:    0.7.0.1
 */