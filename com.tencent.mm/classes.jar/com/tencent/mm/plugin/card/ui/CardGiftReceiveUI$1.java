package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.ScrollView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class CardGiftReceiveUI$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  CardGiftReceiveUI$1(CardGiftReceiveUI paramCardGiftReceiveUI) {}
  
  public final void onGlobalLayout()
  {
    int i = a.fromDPToPix(this.iuv.mController.uMN, 67);
    int j = CardGiftReceiveUI.a(this.iuv).getChildAt(0).getHeight() + i;
    int k = this.iuv.getWindow().findViewById(16908290).getHeight();
    y.i("MicroMsg.CardGiftReceiveUI", "bottomHeight: %d  totalViewHeight:%d  screenHeight:%d ", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
    CardGiftReceiveUI.a(this.iuv).setFillViewport(true);
    if (j > k) {
      CardGiftReceiveUI.a(this.iuv, true);
    }
    for (;;)
    {
      CardGiftReceiveUI.a(this.iuv).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      return;
      CardGiftReceiveUI.a(this.iuv, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftReceiveUI.1
 * JD-Core Version:    0.7.0.1
 */