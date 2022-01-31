package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import a.f.b.j;
import a.l;
import a.l.m;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"com/tencent/mm/plugin/brandservice/ui/timeline/preload/ui/TmplWebViewToolUI$tempWebViewClient$1", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI$DefaultWebViewClient;", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUI;", "canIntercept", "", "url", "", "doUpdateVisitedHistory", "", "view", "Lcom/tencent/xweb/WebView;", "isReload", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "shouldInterceptRequest", "Lcom/tencent/xweb/WebResourceResponse;", "request", "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "plugin-brandservice_release"})
public final class TmplWebViewToolUI$i
  extends WebViewUI.h
{
  TmplWebViewToolUI$i()
  {
    super(localWebViewUI);
  }
  
  private final boolean Ho(String paramString)
  {
    AppMethodBeat.i(15078);
    if ((j.e(paramString, TmplWebViewToolUI.b(this.keI).keN)) || (m.jw(paramString, com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b.getPrefix())))
    {
      AppMethodBeat.o(15078);
      return true;
    }
    AppMethodBeat.o(15078);
    return false;
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(15080);
    j.q(paramWebView, "view");
    j.q(paramr, "request");
    Object localObject = paramr.getUrl().toString();
    j.p(localObject, "request.url.toString()");
    ab.v(TmplWebViewToolUI.c(this.keI), "shouldInterceptRequest url:" + (String)localObject + ", isReady:" + TmplWebViewToolUI.b(this.keI).isReady());
    if (Ho((String)localObject))
    {
      localObject = TmplWebViewToolUI.b(this.keI).getWebViewClient();
      if (localObject != null)
      {
        paramWebView = ((w)localObject).a(paramWebView, paramr);
        AppMethodBeat.o(15080);
        return paramWebView;
      }
      AppMethodBeat.o(15080);
      return null;
    }
    paramWebView = super.a(paramWebView, paramr);
    AppMethodBeat.o(15080);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(15081);
    j.q(paramWebView, "view");
    j.q(paramr, "request");
    j.q(paramBundle, "bundle");
    String str = paramr.getUrl().toString();
    j.p(str, "request.url.toString()");
    ab.v(TmplWebViewToolUI.c(this.keI), "shouldInterceptRequest url:" + str + ", isReady:" + TmplWebViewToolUI.b(this.keI).isReady());
    if (Ho(str))
    {
      paramBundle = TmplWebViewToolUI.b(this.keI).getWebViewClient();
      if (paramBundle != null)
      {
        paramWebView = paramBundle.a(paramWebView, paramr);
        AppMethodBeat.o(15081);
        return paramWebView;
      }
      AppMethodBeat.o(15081);
      return null;
    }
    paramWebView = super.a(paramWebView, paramr, paramBundle);
    AppMethodBeat.o(15081);
    return paramWebView;
  }
  
  public final void a(WebView paramWebView, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(15075);
    ab.i(TmplWebViewToolUI.c(this.keI), "doUpdateVisitedHistory url:" + paramString + ", isReady:" + TmplWebViewToolUI.b(this.keI).isReady());
    if (j.e(paramString, TmplWebViewToolUI.b(this.keI).keN))
    {
      AppMethodBeat.o(15075);
      return;
    }
    if (TmplWebViewToolUI.t(this.keI))
    {
      TmplWebViewToolUI.u(this.keI);
      if (paramWebView == null) {
        j.ebi();
      }
      paramWebView.clearHistory();
    }
    for (;;)
    {
      super.a(paramWebView, paramString, paramBoolean);
      AppMethodBeat.o(15075);
      return;
      if (((paramWebView instanceof b)) && (((b)paramWebView).getNeedClearHistory()))
      {
        ((b)paramWebView).setNeedClearHistory(false);
        paramWebView.clearHistory();
      }
    }
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(15077);
    ab.i(TmplWebViewToolUI.c(this.keI), "onPageFinished url:" + paramString + " isReady:" + TmplWebViewToolUI.b(this.keI).isReady() + " state:" + TmplWebViewToolUI.b(this.keI).getState());
    if (j.e(paramString, TmplWebViewToolUI.b(this.keI).keN))
    {
      w localw = TmplWebViewToolUI.b(this.keI).getWebViewClient();
      if (localw != null)
      {
        localw.b(paramWebView, paramString);
        AppMethodBeat.o(15077);
        return;
      }
      AppMethodBeat.o(15077);
      return;
    }
    super.b(paramWebView, paramString);
    AppMethodBeat.o(15077);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(15076);
    ab.i(TmplWebViewToolUI.c(this.keI), "onPageStarted url:" + paramString + ", isReady:" + TmplWebViewToolUI.b(this.keI).isReady());
    if (j.e(paramString, TmplWebViewToolUI.b(this.keI).keN))
    {
      w localw = TmplWebViewToolUI.b(this.keI).getWebViewClient();
      if (localw != null)
      {
        localw.b(paramWebView, paramString, paramBitmap);
        AppMethodBeat.o(15076);
        return;
      }
      AppMethodBeat.o(15076);
      return;
    }
    if (TmplWebViewToolUI.o(this.keI) != null)
    {
      TmplWebViewToolUI.o(this.keI).dgr();
      this.keI.a((a)new a.a());
    }
    super.b(paramWebView, paramString, paramBitmap);
    AppMethodBeat.o(15076);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(15079);
    j.q(paramWebView, "view");
    j.q(paramString, "url");
    if (!TmplWebViewToolUI.h(this.keI))
    {
      ab.v(TmplWebViewToolUI.c(this.keI), "shouldInterceptRequest url:" + paramString + ", isReady:" + TmplWebViewToolUI.b(this.keI).isReady());
      if (Ho(paramString))
      {
        w localw = TmplWebViewToolUI.b(this.keI).getWebViewClient();
        if (localw != null)
        {
          paramWebView = localw.c(paramWebView, paramString);
          AppMethodBeat.o(15079);
          return paramWebView;
        }
        AppMethodBeat.o(15079);
        return null;
      }
    }
    paramWebView = super.c(paramWebView, paramString);
    AppMethodBeat.o(15079);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.TmplWebViewToolUI.i
 * JD-Core Version:    0.7.0.1
 */