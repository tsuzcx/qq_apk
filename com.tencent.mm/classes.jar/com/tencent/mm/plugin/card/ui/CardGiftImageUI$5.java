package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.tools.e;

final class CardGiftImageUI$5
  implements ViewTreeObserver.OnPreDrawListener
{
  CardGiftImageUI$5(CardGiftImageUI paramCardGiftImageUI) {}
  
  public final boolean onPreDraw()
  {
    CardGiftImageUI.c(this.itG).getViewTreeObserver().removeOnPreDrawListener(this);
    CardGiftImageUI.e(this.itG).a(CardGiftImageUI.c(this.itG), CardGiftImageUI.d(this.itG), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.5
 * JD-Core Version:    0.7.0.1
 */