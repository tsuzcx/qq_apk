package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.f.a.b;
import a.f.b.j;
import a.f.b.u.b;
import a.f.b.u.d;
import a.l;
import a.v;
import a.y;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.w;
import java.lang.ref.WeakReference;
import org.xwalk.core.XWalkEnvironment;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager;", "", "()V", "TAG", "", "initAdWebView", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewWithJsApi;", "webView", "publishId", "setDensity", "Lkotlin/Function1;", "", "", "resize", "", "getA8KeyScene", "sendScrollEvent", "scrollViewHeight", "subViewOffsetTop", "plugin-brandservice_release"})
public final class a
{
  public static final a keW;
  
  static
  {
    AppMethodBeat.i(15118);
    keW = new a();
    AppMethodBeat.o(15118);
  }
  
  public static MMWebViewWithJsApi a(MMWebViewWithJsApi paramMMWebViewWithJsApi, String paramString, b<? super Float, y> paramb, b<? super Integer, y> paramb1, int paramInt)
  {
    AppMethodBeat.i(15117);
    j.q(paramMMWebViewWithJsApi, "webView");
    j.q(paramString, "publishId");
    j.q(paramb, "setDensity");
    j.q(paramb1, "resize");
    u.d locald = new u.d();
    Object localObject = paramMMWebViewWithJsApi.getContext();
    if (localObject == null)
    {
      paramMMWebViewWithJsApi = new v("null cannot be cast to non-null type com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplShareWebViewToolUI");
      AppMethodBeat.o(15117);
      throw paramMMWebViewWithJsApi;
    }
    locald.BNq = new WeakReference((TmplShareWebViewToolUI)localObject);
    localObject = new u.d();
    ((u.d)localObject).BNq = new WeakReference((View)paramMMWebViewWithJsApi);
    final u.b localb = new u.b();
    localb.BNo = com.tencent.mm.cc.a.dqZ();
    if ((paramMMWebViewWithJsApi.getWebCoreType() == WebView.d.BEq) && (XWalkEnvironment.getUsingCustomContext()))
    {
      Resources localResources = paramMMWebViewWithJsApi.getResources();
      j.p(localResources, "webView.resources");
      localb.BNo = localResources.getDisplayMetrics().density;
    }
    paramb.S(Float.valueOf(localb.BNo));
    paramMMWebViewWithJsApi.setBackgroundColor(0);
    paramMMWebViewWithJsApi.setWebViewClient((w)new a.a(new a.c(locald, paramString, (u.d)localObject, paramb1, localb), paramInt, paramMMWebViewWithJsApi, (MMWebView)paramMMWebViewWithJsApi));
    paramMMWebViewWithJsApi.addJavascriptInterface(new b(paramMMWebViewWithJsApi, localb), "__mp_ad_webview");
    ab.i("MicroMsg.AdWebViewManager", "init:".concat(String.valueOf(paramString)));
    AppMethodBeat.o(15117);
    return paramMMWebViewWithJsApi;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$2", "", "adWidth", "", "getAdWidth", "()I", "plugin-brandservice_release"})
  public static final class b
  {
    b(MMWebViewWithJsApi paramMMWebViewWithJsApi, u.b paramb) {}
    
    @android.webkit.JavascriptInterface
    @org.xwalk.core.JavascriptInterface
    public final int getAdWidth()
    {
      AppMethodBeat.i(15112);
      int i = (int)(this.keZ.getMeasuredWidth() / localb.BNo);
      AppMethodBeat.o(15112);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a
 * JD-Core Version:    0.7.0.1
 */