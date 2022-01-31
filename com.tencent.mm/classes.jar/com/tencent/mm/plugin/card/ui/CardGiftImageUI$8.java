package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardGiftImageUI$8
  implements Runnable
{
  CardGiftImageUI$8(CardGiftImageUI paramCardGiftImageUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(88401);
    if (CardGiftImageUI.f(this.kuL).getVisibility() != 8) {
      CardGiftImageUI.f(this.kuL).setVisibility(8);
    }
    CardGiftImageUI.a(this.kuL, this.val$filePath);
    CardGiftImageUI.g(this.kuL);
    CardGiftImageUI.h(this.kuL).notifyDataSetChanged();
    AppMethodBeat.o(88401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.8
 * JD-Core Version:    0.7.0.1
 */