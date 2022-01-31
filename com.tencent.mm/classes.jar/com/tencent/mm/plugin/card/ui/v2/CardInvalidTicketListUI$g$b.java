package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.ui.base.n.d;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$2"})
final class CardInvalidTicketListUI$g$b
  implements n.d
{
  CardInvalidTicketListUI$g$b(CardInvalidTicketListUI.g paramg, d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(89257);
    j.p(paramMenuItem, "menuItem");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(89257);
      return;
      paramMenuItem = this.kAj.kAh;
      Object localObject = this.kAk.kAB;
      if (localObject == null) {
        j.ebi();
      }
      localObject = ((bkj)localObject).wmm;
      j.p(localObject, "model.ticketElement!!.user_card_id");
      CardInvalidTicketListUI.b(paramMenuItem, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.g.b
 * JD-Core Version:    0.7.0.1
 */