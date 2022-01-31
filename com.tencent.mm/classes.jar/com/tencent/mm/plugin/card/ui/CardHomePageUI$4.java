package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class CardHomePageUI$4
  implements Runnable
{
  CardHomePageUI$4(CardHomePageUI paramCardHomePageUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(88486);
    CardHomePageUI.c(this.kwf);
    CardHomePageUI.d(this.kwf);
    this.kwf.krO = true;
    ab.d("MicroMsg.CardHomePageUI", "initLocation end");
    AppMethodBeat.o(88486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardHomePageUI.4
 * JD-Core Version:    0.7.0.1
 */