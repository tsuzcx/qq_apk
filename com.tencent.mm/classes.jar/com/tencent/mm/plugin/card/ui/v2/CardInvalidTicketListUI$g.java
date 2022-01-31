package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
final class CardInvalidTicketListUI$g
  implements MRecyclerView.b
{
  CardInvalidTicketListUI$g(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final boolean O(View paramView, int paramInt)
  {
    AppMethodBeat.i(89258);
    ab.i("MicroMsg.CardInvalidTicketListUI", "long click item");
    paramView = this.kAh.bfk().ts(paramInt);
    if (paramView != null) {
      switch (paramView.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89258);
      return false;
      com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l((Context)this.kAh.getContext());
      locall.a((n.c)new CardInvalidTicketListUI.g.a(this, paramView));
      locall.a((n.d)new CardInvalidTicketListUI.g.b(this, paramView));
      locall.cwt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.g
 * JD-Core Version:    0.7.0.1
 */