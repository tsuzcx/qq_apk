package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CardGiftVideoUI$11
  implements Runnable
{
  CardGiftVideoUI$11(CardGiftVideoUI paramCardGiftVideoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(88459);
    ab.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", new Object[] { Integer.valueOf(this.kvN.hashCode()), Boolean.valueOf(this.kvP) });
    if (this.kvP)
    {
      ((View)CardGiftVideoUI.e(this.kvN)).setVisibility(0);
      CardGiftVideoUI.f(this.kvN).setVisibility(8);
      AppMethodBeat.o(88459);
      return;
    }
    ((View)CardGiftVideoUI.e(this.kvN)).setVisibility(8);
    CardGiftVideoUI.f(this.kvN).setVisibility(0);
    AppMethodBeat.o(88459);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.11
 * JD-Core Version:    0.7.0.1
 */