package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class CardGiftVideoUI$2
  implements Runnable
{
  CardGiftVideoUI$2(CardGiftVideoUI paramCardGiftVideoUI, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(88449);
    if (CardGiftVideoUI.h(this.kvN) != null)
    {
      if (this.fFB == 0)
      {
        CardGiftVideoUI.h(this.kvN).setVisibility(8);
        AppMethodBeat.o(88449);
        return;
      }
      if (CardGiftVideoUI.h(this.kvN).getVisibility() != 0) {
        CardGiftVideoUI.h(this.kvN).setVisibility(0);
      }
      ab.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", new Object[] { Integer.valueOf(this.fzv), Integer.valueOf(this.fFB) });
      if ((CardGiftVideoUI.h(this.kvN).getMax() != this.fFB) && (this.fFB > 0)) {
        CardGiftVideoUI.h(this.kvN).setMax(this.fFB);
      }
      CardGiftVideoUI.h(this.kvN).setProgress(this.fzv);
    }
    AppMethodBeat.o(88449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.2
 * JD-Core Version:    0.7.0.1
 */