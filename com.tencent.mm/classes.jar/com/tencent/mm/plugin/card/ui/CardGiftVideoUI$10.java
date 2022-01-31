package com.tencent.mm.plugin.card.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.sdk.platformtools.ap.a;

final class CardGiftVideoUI$10
  implements ap.a
{
  CardGiftVideoUI$10(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(88458);
    if (CardGiftVideoUI.e(this.kvN).isPlaying())
    {
      CardGiftVideoUI localCardGiftVideoUI = this.kvN;
      int i = CardGiftVideoUI.e(this.kvN).getCurrentPosition() / 1000;
      if ((localCardGiftVideoUI.kvJ != null) && (localCardGiftVideoUI.duration > 0))
      {
        int j = localCardGiftVideoUI.duration - i;
        i = j;
        if (j < 0) {
          i = 0;
        }
        localCardGiftVideoUI.kvJ.setText(i + "\"");
      }
    }
    AppMethodBeat.o(88458);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.10
 * JD-Core Version:    0.7.0.1
 */