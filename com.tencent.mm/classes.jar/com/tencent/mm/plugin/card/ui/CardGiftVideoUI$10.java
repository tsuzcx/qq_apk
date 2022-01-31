package com.tencent.mm.plugin.card.ui;

import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.am.a;

final class CardGiftVideoUI$10
  implements am.a
{
  CardGiftVideoUI$10(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final boolean tC()
  {
    if (CardGiftVideoUI.e(this.iuJ).isPlaying())
    {
      CardGiftVideoUI localCardGiftVideoUI = this.iuJ;
      int i = CardGiftVideoUI.e(this.iuJ).getCurrentPosition() / 1000;
      if ((localCardGiftVideoUI.iuF != null) && (localCardGiftVideoUI.duration > 0))
      {
        int j = localCardGiftVideoUI.duration - i;
        i = j;
        if (j < 0) {
          i = 0;
        }
        localCardGiftVideoUI.iuF.setText(i + "\"");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.10
 * JD-Core Version:    0.7.0.1
 */