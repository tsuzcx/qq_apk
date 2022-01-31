package com.tencent.mm.plugin.game.luggage;

import com.tencent.mm.ui.widget.MMWebView;

final class h$1
  implements Runnable
{
  h$1(h paramh) {}
  
  public final void run()
  {
    ((MMWebView)this.kMU.qp()).evaluateJavascript("javascript:(function() {window.__preloadWXGameCore__=true;})();", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.1
 * JD-Core Version:    0.7.0.1
 */