package com.tencent.mm.plugin.fts.ui.webview;

import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage.MessageLevel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import com.tencent.xweb.x;

public final class a
  extends x
{
  public final void a(WebView paramWebView, int paramInt) {}
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(176917);
    ae.i("MicroMsg.FTS.PardusWebChromeClient", "onJsAlert %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(176917);
    return bool;
  }
  
  public final boolean a(WebView paramWebView, String paramString1, String paramString2, String paramString3, o paramo)
  {
    AppMethodBeat.i(176916);
    ae.i("MicroMsg.FTS.PardusWebChromeClient", "onJsPrompt %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.a(paramWebView, paramString1, paramString2, paramString3, paramo);
    AppMethodBeat.o(176916);
    return bool;
  }
  
  public final boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    AppMethodBeat.i(176915);
    ae.i("MicroMsg.FTS.PardusWebChromeClient", "onJsConfirm %s %s", new Object[] { paramString1, paramString2 });
    boolean bool = super.b(paramWebView, paramString1, paramString2, paramJsResult);
    AppMethodBeat.o(176915);
    return bool;
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(176918);
    ae.i("MicroMsg.FTS.PardusWebChromeClient", "onConsoleMessage %d %s %s %s", new Object[] { Integer.valueOf(paramConsoleMessage.lineNumber()), paramConsoleMessage.messageLevel().name(), paramConsoleMessage.message(), paramConsoleMessage.sourceId() });
    if ((paramConsoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) && (!bu.isNullOrNil(paramConsoleMessage.message())))
    {
      e.ywz.f(19153, new Object[] { Integer.valueOf(ad.WL(5)), paramConsoleMessage.messageLevel(), Integer.valueOf(2) });
      if (!paramConsoleMessage.message().contains("SyntaxError")) {
        paramConsoleMessage.message().contains("Maximum call stack size exceeded");
      }
    }
    boolean bool = super.onConsoleMessage(paramConsoleMessage);
    AppMethodBeat.o(176918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.webview.a
 * JD-Core Version:    0.7.0.1
 */