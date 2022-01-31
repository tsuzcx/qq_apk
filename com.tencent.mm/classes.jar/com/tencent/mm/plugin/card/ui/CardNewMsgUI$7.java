package com.tencent.mm.plugin.card.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.ui.base.h.c;

final class CardNewMsgUI$7
  implements h.c
{
  CardNewMsgUI$7(CardNewMsgUI paramCardNewMsgUI, int paramInt) {}
  
  public final void iA(int paramInt)
  {
    AppMethodBeat.i(88598);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(88598);
      return;
      g localg = (g)CardNewMsgUI.a(this.kxl).getItem(this.gxr);
      if (localg != null)
      {
        am.bch().HG(localg.field_msg_id);
        CardNewMsgUI.g(this.kxl);
        CardNewMsgUI.a(this.kxl).a(null, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.7
 * JD-Core Version:    0.7.0.1
 */