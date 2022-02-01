package com.tencent.mm.plugin.card.ui.v2;

import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
final class CardTicketListUI$j
  implements o.f
{
  CardTicketListUI$j(CardTicketListUI paramCardTicketListUI) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(201406);
    paramm.a(1, this.qgN.getResources().getColor(2131100996), (CharSequence)this.qgN.getString(2131755778));
    AppMethodBeat.o(201406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.j
 * JD-Core Version:    0.7.0.1
 */