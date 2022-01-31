package com.tencent.mm.plugin.game.luggage;

import android.webkit.ConsoleMessage;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.luggage.d.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;

public final class c$a
  extends d
{
  public c$a(c paramc) {}
  
  public final void d(WebView paramWebView, String paramString)
  {
    com.tencent.luggage.j.c.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
    if (!b.wD(paramString)) {
      c.a(this.kMw, paramString);
    }
    super.d(paramWebView, paramString);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message(); (!bk.bl(str)) && (str.equalsIgnoreCase("weixin://whiteScreenEnd")); str = null)
    {
      y.d("MicroMsg.GameWebCoreImpl", "whiteScreenEnd");
      if (c.c(this.kMw) != null) {
        c.c(this.kMw).rNX = true;
      }
      return true;
    }
    return super.onConsoleMessage(paramConsoleMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.c.a
 * JD-Core Version:    0.7.0.1
 */