package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

final class CardGiftVideoUI$12
  implements Runnable
{
  CardGiftVideoUI$12(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(88460);
    ab.d("MicroMsg.CardGiftVideoUI", "hide loading.");
    if ((CardGiftVideoUI.g(this.kvN) != null) && (CardGiftVideoUI.g(this.kvN).getVisibility() != 8)) {
      CardGiftVideoUI.g(this.kvN).setVisibility(8);
    }
    if ((CardGiftVideoUI.h(this.kvN) != null) && (CardGiftVideoUI.h(this.kvN).getVisibility() != 8)) {
      CardGiftVideoUI.h(this.kvN).setVisibility(8);
    }
    AppMethodBeat.o(88460);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.12
 * JD-Core Version:    0.7.0.1
 */