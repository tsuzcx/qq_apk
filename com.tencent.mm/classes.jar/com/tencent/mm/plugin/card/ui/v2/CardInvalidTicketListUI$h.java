package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.ui.base.h;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardInvalidTicketListUI$h
  implements MenuItem.OnMenuItemClickListener
{
  CardInvalidTicketListUI$h(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112488);
    h.a((Context)this.oSw.getContext(), false, this.oSw.getString(2131756897), "", this.oSw.getString(2131757560), this.oSw.getString(2131757558), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(112485);
        CardInvalidTicketListUI.bZq();
        g.yxI.f(16322, new Object[] { Integer.valueOf(11) });
        AppMethodBeat.o(112485);
      }
    }, (DialogInterface.OnClickListener)2.oSB);
    g.yxI.f(16322, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(112488);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */