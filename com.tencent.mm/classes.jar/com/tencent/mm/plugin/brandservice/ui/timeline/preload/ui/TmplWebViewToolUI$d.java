package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g;
import com.tencent.xweb.WebView;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$getWebChromeClient$1", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebChromeClient;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "progress", "", "plugin-brandservice_release"})
public final class TmplWebViewToolUI$d
  extends WebViewUI.g
{
  TmplWebViewToolUI$d()
  {
    super(localWebViewUI);
  }
  
  public final void a(WebView paramWebView, int paramInt)
  {
    AppMethodBeat.i(154587);
    if (paramInt == 100) {
      this.keI.aJe();
    }
    super.a(paramWebView, paramInt);
    AppMethodBeat.o(154587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.d
 * JD-Core Version:    0.7.0.1
 */