package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.mm.ui.tools.e;

final class CardGiftVideoUI$8
  implements ViewTreeObserver.OnPreDrawListener
{
  CardGiftVideoUI$8(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final boolean onPreDraw()
  {
    CardGiftVideoUI.b(this.iuJ).getViewTreeObserver().removeOnPreDrawListener(this);
    CardGiftVideoUI.d(this.iuJ).a(CardGiftVideoUI.b(this.iuJ), CardGiftVideoUI.c(this.iuJ), null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.8
 * JD-Core Version:    0.7.0.1
 */