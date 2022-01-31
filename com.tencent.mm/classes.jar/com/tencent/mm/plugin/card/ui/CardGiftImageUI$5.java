package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.e;

final class CardGiftImageUI$5
  implements ViewTreeObserver.OnPreDrawListener
{
  CardGiftImageUI$5(CardGiftImageUI paramCardGiftImageUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(88397);
    CardGiftImageUI.c(this.kuL).getViewTreeObserver().removeOnPreDrawListener(this);
    CardGiftImageUI.e(this.kuL).a(CardGiftImageUI.c(this.kuL), CardGiftImageUI.d(this.kuL), null);
    AppMethodBeat.o(88397);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.5
 * JD-Core Version:    0.7.0.1
 */