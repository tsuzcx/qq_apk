package com.tencent.mm.plugin.game.luggage.d;

import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.c.b;
import com.tencent.mm.plugin.wepkg.c;
import com.tencent.xweb.WebView;

public final class e$a
  extends com.tencent.mm.plugin.webview.luggage.d
{
  public e$a(e parame) {}
  
  public final void d(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(135934);
    com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onReceivedTitle, title = %s", new Object[] { paramString });
    if (!b.Fl(paramString)) {
      e.a(this.nkA, paramString);
    }
    super.d(paramWebView, paramString);
    AppMethodBeat.o(135934);
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(135935);
    if (e.h(this.nkA) != null) {
      e.h(this.nkA).a(paramConsoleMessage);
    }
    if (paramConsoleMessage != null) {}
    for (String str = paramConsoleMessage.message();; str = "")
    {
      if ((str.contains("luggage_err")) || (str.contains("luggageBridge is not defined")))
      {
        com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "luggage bridge error");
        e.j(this.nkA).eAv = str;
      }
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(135935);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.e.a
 * JD-Core Version:    0.7.0.1
 */