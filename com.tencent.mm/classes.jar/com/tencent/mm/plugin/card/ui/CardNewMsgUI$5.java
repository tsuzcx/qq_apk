package com.tencent.mm.plugin.card.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.h;
import com.tencent.mm.ui.p.a;

final class CardNewMsgUI$5
  implements p.a
{
  CardNewMsgUI$5(CardNewMsgUI paramCardNewMsgUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(88596);
    CardNewMsgUI.g(this.kxl);
    if ((CardNewMsgUI.a(this.kxl).bem()) && (am.bcf().bbZ() == 0)) {
      CardNewMsgUI.c(this.kxl).setVisibility(8);
    }
    AppMethodBeat.o(88596);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.5
 * JD-Core Version:    0.7.0.1
 */