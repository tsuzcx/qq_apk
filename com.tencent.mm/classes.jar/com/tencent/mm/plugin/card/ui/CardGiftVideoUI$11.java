package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;

final class CardGiftVideoUI$11
  implements Runnable
{
  CardGiftVideoUI$11(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void run()
  {
    y.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(this.iuJ.hashCode()), Boolean.valueOf(this.iuL) });
    if (this.iuL)
    {
      ((View)CardGiftVideoUI.e(this.iuJ)).setVisibility(0);
      CardGiftVideoUI.f(this.iuJ).setVisibility(8);
      return;
    }
    ((View)CardGiftVideoUI.e(this.iuJ)).setVisibility(8);
    CardGiftVideoUI.f(this.iuJ).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.11
 * JD-Core Version:    0.7.0.1
 */