package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.tools.e.b;

final class CardGiftImageUI$6
  implements e.b
{
  CardGiftImageUI$6(CardGiftImageUI paramCardGiftImageUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(88399);
    new ak().post(new CardGiftImageUI.6.1(this));
    AppMethodBeat.o(88399);
  }
  
  public final void onAnimationStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardGiftImageUI.6
 * JD-Core Version:    0.7.0.1
 */