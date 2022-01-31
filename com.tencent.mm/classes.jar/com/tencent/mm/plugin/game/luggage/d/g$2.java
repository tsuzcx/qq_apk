package com.tencent.mm.plugin.game.luggage.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;

final class g$2
  implements Runnable
{
  g$2(g paramg) {}
  
  public final void run()
  {
    AppMethodBeat.i(135995);
    if (this.nkQ.getWebView() != null)
    {
      String str = this.nkQ.getWebView().getTitle();
      if (!bo.isNullOrNil(str)) {
        this.nkQ.cr(str, 0);
      }
    }
    AppMethodBeat.o(135995);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.d.g.2
 * JD-Core Version:    0.7.0.1
 */