package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardGiftReceiveUI$4$1
  implements Runnable
{
  CardGiftReceiveUI$4$1(CardGiftReceiveUI.4 param4) {}
  
  public final void run()
  {
    AppMethodBeat.i(88418);
    if (CardGiftReceiveUI.f(this.kvB.kvA).getVisibility() != 0) {
      CardGiftReceiveUI.f(this.kvB.kvA).setVisibility(0);
    }
    AppMethodBeat.o(88418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.4.1
 * JD-Core Version:    0.7.0.1
 */