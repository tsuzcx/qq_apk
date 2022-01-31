package com.tencent.mm.plugin.card.ui;

import android.widget.ProgressBar;

final class CardGiftImageUI$8
  implements Runnable
{
  CardGiftImageUI$8(CardGiftImageUI paramCardGiftImageUI, String paramString) {}
  
  public final void run()
  {
    if (CardGiftImageUI.f(this.itG).getVisibility() != 8) {
      CardGiftImageUI.f(this.itG).setVisibility(8);
    }
    CardGiftImageUI.a(this.itG, this.val$filePath);
    CardGiftImageUI.g(this.itG);
    CardGiftImageUI.h(this.itG).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.8
 * JD-Core Version:    0.7.0.1
 */