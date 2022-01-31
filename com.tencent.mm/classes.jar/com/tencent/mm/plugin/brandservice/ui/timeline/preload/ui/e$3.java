package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.b.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.n;
import com.tencent.mm.plugin.webview.preload.TmplParams;
import com.tencent.mm.plugin.webview.preload.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.sdk.f.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.r;
import com.tencent.xweb.s;
import com.tencent.xweb.w;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

final class e$3
  extends w
{
  e$3(e parame) {}
  
  private s f(WebView paramWebView, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(154557);
    ab.i(e.a(this.keT), "getResourceResponse, requrl:%s, url:%s", new Object[] { paramString, this.keT.keN });
    if (paramString.equals(this.keT.keN)) {
      paramString = this.keT.keP;
    }
    for (;;)
    {
      ab.v(e.a(this.keT), "response path:" + bo.bf(paramString, "null"));
      paramWebView = g(paramWebView, paramString);
      if (paramWebView == null) {
        break label235;
      }
      ab.i(e.a(this.keT), "return intercepted success");
      AppMethodBeat.o(154557);
      return paramWebView;
      if (paramString.startsWith(b.aXS()))
      {
        paramString = n.q(this.keT.jZV.kbM, this.keT.jZV.kbP, paramString.replaceFirst(b.aXS(), ""));
        i = 1;
      }
      else
      {
        if (!paramString.startsWith(b.getPrefix())) {
          break;
        }
        paramString = n.q(this.keT.jZV.kbM, this.keT.jZV.kbP, paramString.replaceFirst(b.getPrefix(), ""));
        i = 1;
      }
    }
    ab.e(e.a(this.keT), "return null");
    AppMethodBeat.o(154557);
    return null;
    label235:
    ab.e(e.a(this.keT), "return intercepted null");
    a.d(this.keT.jZV.uYL, 126, 1, true);
    if (i != 0) {
      a.d(this.keT.jZV.uYL, 233, 1, true);
    }
    AppMethodBeat.o(154557);
    return null;
  }
  
  private s g(WebView paramWebView, String paramString)
  {
    Object localObject1 = null;
    AppMethodBeat.i(154558);
    Object localObject2 = c.amX(paramString);
    if ((paramString.endsWith(".js")) && (f.c(paramWebView)))
    {
      paramWebView = new aa(3, 256, paramWebView);
      paramWebView.ja(paramString, "path");
      paramWebView = paramWebView.toString();
      localObject1 = new s((String)localObject2, "UTF-8", new ByteArrayInputStream(paramWebView.getBytes(StandardCharsets.UTF_8)));
    }
    for (;;)
    {
      localObject2 = new HashMap();
      String str = Integer.toHexString(paramString.hashCode() & 0xFFFFFFFF).toLowerCase();
      ((Map)localObject2).put("Cache-Control", "max-age=31536000");
      ((Map)localObject2).put("ETag", str);
      if (paramWebView != null) {
        ((Map)localObject2).put("RunLocalJS", paramWebView);
      }
      ((s)localObject1).mResponseHeaders = ((Map)localObject2);
      ab.i("MicroMsg.TmplWxJsWebView", "readFileWebResp:%s\nETag:%s", new Object[] { paramString, str });
      AppMethodBeat.o(154558);
      return localObject1;
      try
      {
        paramWebView = new FileInputStream(paramString);
        if (paramWebView == null)
        {
          ab.e(e.a(this.keT), "stream is null, err");
          AppMethodBeat.o(154558);
          return null;
        }
      }
      catch (FileNotFoundException paramWebView)
      {
        for (;;)
        {
          ab.printErrStackTrace(e.a(this.keT), paramWebView, "", new Object[0]);
          paramWebView = null;
        }
        localObject2 = new s((String)localObject2, "UTF-8", paramWebView);
        paramWebView = (WebView)localObject1;
        localObject1 = localObject2;
      }
    }
  }
  
  public final s a(WebView paramWebView, r paramr)
  {
    AppMethodBeat.i(154561);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      ab.e(e.a(this.keT), "shouldInterceptRequest, url is null");
      AppMethodBeat.o(154561);
      return null;
    }
    ab.v(e.a(this.keT), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
    paramWebView = f(paramWebView, paramr.getUrl().toString());
    AppMethodBeat.o(154561);
    return paramWebView;
  }
  
  public final s a(WebView paramWebView, r paramr, Bundle paramBundle)
  {
    AppMethodBeat.i(154560);
    if ((paramr == null) || (paramr.getUrl() == null) || (bo.isNullOrNil(paramr.getUrl().toString())))
    {
      ab.e(e.a(this.keT), "shouldInterceptRequest, webResourceRequest is null");
      AppMethodBeat.o(154560);
      return null;
    }
    ab.v(e.a(this.keT), "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[] { paramr.getUrl(), paramr.getMethod(), Boolean.valueOf(paramr.isForMainFrame()) });
    paramr = paramr.getUrl().toString();
    ab.v(e.a(this.keT), "shouldInterceptRequest, url = %s", new Object[] { paramr });
    paramWebView = f(paramWebView, paramr);
    AppMethodBeat.o(154560);
    return paramWebView;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(154556);
    ab.i(e.a(this.keT), "[onPageFinished] url:%s", new Object[] { paramString });
    super.b(paramWebView, paramString);
    AppMethodBeat.o(154556);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(154555);
    ab.i(e.a(this.keT), "[onPageStarted] url:%s", new Object[] { paramString });
    super.b(paramWebView, paramString, paramBitmap);
    e.b(this.keT);
    AppMethodBeat.o(154555);
  }
  
  public final s c(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(154559);
    if (bo.isNullOrNil(paramString))
    {
      ab.i(e.a(this.keT), "shouldInterceptRequest, url is null");
      AppMethodBeat.o(154559);
      return null;
    }
    ab.v(e.a(this.keT), "shouldInterceptRequest, url = %s", new Object[] { paramString });
    paramWebView = f(paramWebView, paramString);
    AppMethodBeat.o(154559);
    return paramWebView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui.e.3
 * JD-Core Version:    0.7.0.1
 */