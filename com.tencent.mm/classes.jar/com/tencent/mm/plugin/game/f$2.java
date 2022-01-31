package com.tencent.mm.plugin.game;

import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.MMWebView;

final class f$2
  implements Runnable
{
  f$2(f paramf) {}
  
  public final void run()
  {
    if (this.kLU.rbA != null)
    {
      String str = this.kLU.rbA.getTitle();
      if (!bk.bl(str)) {
        this.kLU.rbE.setTitleText(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.2
 * JD-Core Version:    0.7.0.1
 */