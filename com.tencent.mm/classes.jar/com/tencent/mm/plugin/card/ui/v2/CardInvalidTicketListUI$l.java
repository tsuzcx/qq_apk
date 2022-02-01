package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
final class CardInvalidTicketListUI$l
  implements MenuItem.OnMenuItemClickListener
{
  CardInvalidTicketListUI$l(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(112488);
    com.tencent.mm.ui.base.h.a((Context)this.qgk.getContext(), false, this.qgk.getString(2131757067), "", this.qgk.getString(2131757787), this.qgk.getString(2131757785), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(112485);
        CardInvalidTicketListUI.cxg();
        com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(11) });
        AppMethodBeat.o(112485);
      }
    }, (DialogInterface.OnClickListener)2.qgq);
    com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(112488);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.l
 * JD-Core Version:    0.7.0.1
 */