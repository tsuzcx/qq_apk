package com.tencent.mm.plugin.card.ui;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class CardGiftVideoUI$3
  implements Runnable
{
  CardGiftVideoUI$3(CardGiftVideoUI paramCardGiftVideoUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(88450);
    CardGiftVideoUI.f(this.kvN).setVisibility(8);
    CardGiftVideoUI.a(this.kvN, this.val$filePath);
    CardGiftVideoUI.b(this.kvN, CardGiftVideoUI.a(this.kvN));
    CardGiftVideoUI.i(this.kvN);
    AppMethodBeat.o(88450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftVideoUI.3
 * JD-Core Version:    0.7.0.1
 */