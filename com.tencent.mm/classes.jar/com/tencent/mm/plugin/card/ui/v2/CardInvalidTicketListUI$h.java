package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardInvalidTicketListUI$h
  implements MenuItem.OnMenuItemClickListener
{
  CardInvalidTicketListUI$h(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112488);
    com.tencent.mm.ui.base.h.a((Context)this.nFz.getContext(), false, this.nFz.getString(2131756897), "", this.nFz.getString(2131757560), this.nFz.getString(2131757558), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(112485);
        CardInvalidTicketListUI.bMj();
        com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(11) });
        AppMethodBeat.o(112485);
      }
    }, (DialogInterface.OnClickListener)2.nFE);
    com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(112488);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */