package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.ui.base.h.c;

final class CardNewMsgUI$7
  implements h.c
{
  CardNewMsgUI$7(CardNewMsgUI paramCardNewMsgUI, int paramInt) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    }
    g localg;
    do
    {
      return;
      localg = (g)CardNewMsgUI.a(this.iwh).getItem(this.ffJ);
    } while (localg == null);
    am.aAw().yf(localg.field_msg_id);
    CardNewMsgUI.g(this.iwh);
    CardNewMsgUI.a(this.iwh).a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardNewMsgUI.7
 * JD-Core Version:    0.7.0.1
 */