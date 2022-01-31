package com.tencent.mm.plugin.card.ui;

import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.sdk.platformtools.ab;

final class CardHomePageUI$9
  implements MessageQueue.IdleHandler
{
  CardHomePageUI$9(CardHomePageUI paramCardHomePageUI) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(88491);
    if (CardHomePageUI.g(this.kwf) != null)
    {
      CardHomePageUI.g(this.kwf);
      if (b.bcH())
      {
        ab.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
        CardHomePageUI.h(this.kwf);
      }
    }
    AppMethodBeat.o(88491);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.9
 * JD-Core Version:    0.7.0.1
 */