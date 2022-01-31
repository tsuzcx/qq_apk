package com.tencent.mm.plugin.card.sharecard.ui;

import com.tencent.mm.sdk.platformtools.y;

final class ShareCardListUI$5
  implements Runnable
{
  ShareCardListUI$5(ShareCardListUI paramShareCardListUI) {}
  
  public final void run()
  {
    ShareCardListUI.i(this.iqI);
    if (!this.iqI.isFinishing())
    {
      ShareCardListUI.j(this.iqI);
      return;
    }
    y.w("MicroMsg.ShareCardListUI", "Activity is finished!!!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI.5
 * JD-Core Version:    0.7.0.1
 */