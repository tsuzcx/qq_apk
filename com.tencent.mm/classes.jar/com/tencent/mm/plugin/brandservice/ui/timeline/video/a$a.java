package com.tencent.mm.plugin.brandservice.ui.timeline.video;

import a.l;
import a.v;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.model.a;
import com.tencent.mm.plugin.webview.ui.tools.b;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/video/AdWebViewManager$initAdWebView$1", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewClient;", "getA8KeyScene", "", "getWebViewStubCallback", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "mmOnPageFinished", "", "view", "Lcom/tencent/xweb/WebView;", "url", "", "mmOnPageStarted", "favicon", "Landroid/graphics/Bitmap;", "plugin-brandservice_release"})
public final class a$a
  extends k
{
  a$a(a.c paramc, int paramInt, MMWebViewWithJsApi paramMMWebViewWithJsApi, MMWebView paramMMWebView)
  {
    super(paramMMWebView);
  }
  
  public final void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(152768);
    super.a(paramWebView, paramString, paramBitmap);
    if (paramWebView == null)
    {
      paramWebView = new v("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMWebView");
      AppMethodBeat.o(152768);
      throw paramWebView;
    }
    a.c((MMWebView)paramWebView);
    AppMethodBeat.o(152768);
  }
  
  public final m aGm()
  {
    return (m)this.keX;
  }
  
  public final int aGn()
  {
    return this.keY;
  }
  
  public final void e(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(152769);
    super.e(paramWebView, paramString);
    b.Ko(29);
    AppMethodBeat.o(152769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a
 * JD-Core Version:    0.7.0.1
 */