package com.tencent.mm.plugin.game.media.preview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.a;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.modeltools.g;

final class c$4
  implements Runnable
{
  c$4(c paramc, WebViewJSSDKVideoItem paramWebViewJSSDKVideoItem) {}
  
  public final void run()
  {
    AppMethodBeat.i(41333);
    if (!c.a(this.rUL))
    {
      g.emE().a("", this.rUM.diQ, a.fne, 214, 2, c.b(this.rUL));
      c.a(this.rUL, System.currentTimeMillis());
    }
    AppMethodBeat.o(41333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.c.4
 * JD-Core Version:    0.7.0.1
 */