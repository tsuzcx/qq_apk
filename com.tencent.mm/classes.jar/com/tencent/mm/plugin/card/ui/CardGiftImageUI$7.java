package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardGiftImageUI$7
  implements Runnable
{
  CardGiftImageUI$7(CardGiftImageUI paramCardGiftImageUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(88400);
    if (CardGiftImageUI.f(this.kuL).getVisibility() != 0) {
      CardGiftImageUI.f(this.kuL).setVisibility(0);
    }
    AppMethodBeat.o(88400);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.7
 * JD-Core Version:    0.7.0.1
 */