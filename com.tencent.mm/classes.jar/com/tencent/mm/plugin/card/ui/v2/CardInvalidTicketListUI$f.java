package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
final class CardInvalidTicketListUI$f
  implements MRecyclerView.a
{
  CardInvalidTicketListUI$f(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(89255);
    ab.i("MicroMsg.CardInvalidTicketListUI", "click item");
    paramView = this.kAh.bfk().ts(paramInt);
    if (paramView != null)
    {
      switch (paramView.type)
      {
      }
      do
      {
        AppMethodBeat.o(89255);
        return;
        localObject = paramView.kAB;
      } while (localObject == null);
      paramView = this.kAh;
      Object localObject = ((bkj)localObject).wmm;
      j.p(localObject, "user_card_id");
      CardInvalidTicketListUI.a(paramView, (String)localObject);
      AppMethodBeat.o(89255);
      return;
    }
    AppMethodBeat.o(89255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI.f
 * JD-Core Version:    0.7.0.1
 */