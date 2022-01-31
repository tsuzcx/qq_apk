package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class CardGiftVideoUI$12
  implements Runnable
{
  CardGiftVideoUI$12(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void run()
  {
    y.d("MicroMsg.CardGiftVideoUI", "hide loading.");
    if ((CardGiftVideoUI.g(this.iuJ) != null) && (CardGiftVideoUI.g(this.iuJ).getVisibility() != 8)) {
      CardGiftVideoUI.g(this.iuJ).setVisibility(8);
    }
    if ((CardGiftVideoUI.h(this.iuJ) != null) && (CardGiftVideoUI.h(this.iuJ).getVisibility() != 8)) {
      CardGiftVideoUI.h(this.iuJ).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.12
 * JD-Core Version:    0.7.0.1
 */