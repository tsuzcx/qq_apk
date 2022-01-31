package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardInvalidTicketListUI$i
  implements MenuItem.OnMenuItemClickListener
{
  CardInvalidTicketListUI$i(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(89263);
    com.tencent.mm.ui.base.h.a((Context)this.kAh.getContext(), false, this.kAh.getString(2131297955), "", this.kAh.getString(2131298501), this.kAh.getString(2131298499), (DialogInterface.OnClickListener)new CardInvalidTicketListUI.i.1(this), (DialogInterface.OnClickListener)CardInvalidTicketListUI.i.2.kAm);
    com.tencent.mm.plugin.report.service.h.qsU.e(16322, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(89263);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.i
 * JD-Core Version:    0.7.0.1
 */