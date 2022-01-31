package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.tools.e;

final class CardGiftVideoUI$8
  implements ViewTreeObserver.OnPreDrawListener
{
  CardGiftVideoUI$8(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(88455);
    CardGiftVideoUI.b(this.kvN).getViewTreeObserver().removeOnPreDrawListener(this);
    CardGiftVideoUI.d(this.kvN).a(CardGiftVideoUI.b(this.kvN), CardGiftVideoUI.c(this.kvN), null);
    AppMethodBeat.o(88455);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.8
 * JD-Core Version:    0.7.0.1
 */