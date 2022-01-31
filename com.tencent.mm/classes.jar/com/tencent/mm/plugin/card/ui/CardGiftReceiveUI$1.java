package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

final class CardGiftReceiveUI$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  CardGiftReceiveUI$1(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(88415);
    int i = a.fromDPToPix(this.kvA.getContext(), 67);
    int j = CardGiftReceiveUI.a(this.kvA).getChildAt(0).getHeight() + i;
    int k = this.kvA.getWindow().findViewById(16908290).getHeight();
    ab.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    CardGiftReceiveUI.a(this.kvA).setFillViewport(true);
    if (j > k) {
      CardGiftReceiveUI.a(this.kvA, true);
    }
    for (;;)
    {
      CardGiftReceiveUI.a(this.kvA).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      AppMethodBeat.o(88415);
      return;
      CardGiftReceiveUI.a(this.kvA, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.1
 * JD-Core Version:    0.7.0.1
 */