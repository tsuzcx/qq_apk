package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.a;
import com.tencent.mm.plugin.card.model.am;

final class CardListSelectedUI$2
  implements MenuItem.OnMenuItemClickListener
{
  CardListSelectedUI$2(CardListSelectedUI paramCardListSelectedUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(88556);
    if ((!this.kwP.kwB) && (CardListSelectedUI.b(this.kwP).kmw))
    {
      this.kwP.fV(true);
      am.bcp().W(CardListSelectedUI.b(this.kwP).kmr, l.IH(CardListSelectedUI.b(this.kwP).userName), 3);
    }
    for (;;)
    {
      AppMethodBeat.o(88556);
      return true;
      CardListSelectedUI.a(this.kwP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.CardListSelectedUI.2
 * JD-Core Version:    0.7.0.1
 */