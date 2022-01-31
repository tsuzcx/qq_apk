package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class CardGiftVideoUI$2
  implements Runnable
{
  CardGiftVideoUI$2(CardGiftVideoUI paramCardGiftVideoUI, int paramInt) {}
  
  public final void run()
  {
    if (CardGiftVideoUI.h(this.iuJ) != null)
    {
      if (this.epd == 0) {
        CardGiftVideoUI.h(this.iuJ).setVisibility(8);
      }
    }
    else {
      return;
    }
    if (CardGiftVideoUI.h(this.iuJ).getVisibility() != 0) {
      CardGiftVideoUI.h(this.iuJ).setVisibility(0);
    }
    y.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(this.ejr), Integer.valueOf(this.epd) });
    if ((CardGiftVideoUI.h(this.iuJ).getMax() != this.epd) && (this.epd > 0)) {
      CardGiftVideoUI.h(this.iuJ).setMax(this.epd);
    }
    CardGiftVideoUI.h(this.iuJ).setProgress(this.ejr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.2
 * JD-Core Version:    0.7.0.1
 */