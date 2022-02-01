package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.modeltools.g;

final class c$4
  implements Runnable
{
  c$4(c paramc, WebViewJSSDKVideoItem paramWebViewJSSDKVideoItem) {}
  
  public final void run()
  {
    AppMethodBeat.i(41333);
    if (!c.a(this.IBY))
    {
      g.ivY().a("", this.IBZ.hHB, a.lwi, 214, 2, c.b(this.IBY));
      c.a(this.IBY, System.currentTimeMillis());
    }
    AppMethodBeat.o(41333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.c.4
 * JD-Core Version:    0.7.0.1
 */