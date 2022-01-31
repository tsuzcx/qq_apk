package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
final class CardTicketListUI$h
  implements MRecyclerView.b
{
  CardTicketListUI$h(CardTicketListUI paramCardTicketListUI) {}
  
  public final boolean O(View paramView, int paramInt)
  {
    AppMethodBeat.i(89308);
    ab.i("MicroMsg.CardTicketListUI", "long click item");
    Object localObject = CardTicketListUI.b(this.kAE).ts(paramInt);
    if (localObject != null)
    {
      paramView = ((d)localObject).kAB;
      switch (((d)localObject).type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89308);
      return false;
      localObject = new com.tencent.mm.ui.tools.l((Context)this.kAE.getContext());
      ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new CardTicketListUI.h.1(this));
      ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new CardTicketListUI.h.2(this, paramView));
      ((com.tencent.mm.ui.tools.l)localObject).cwt();
      if (paramView != null)
      {
        localObject = h.qsU;
        paramInt = paramView.xyT;
        String str1 = paramView.wmm;
        c localc = CardTicketListUI.b(this.kAE);
        String str2 = paramView.wmm;
        j.p(str2, "user_card_id");
        ((h)localObject).e(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(localc.bP(str2, paramView.xyT)), Integer.valueOf(2) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.h
 * JD-Core Version:    0.7.0.1
 */