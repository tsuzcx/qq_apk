package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
final class CardTicketListUI$g
  implements MRecyclerView.a
{
  CardTicketListUI$g(CardTicketListUI paramCardTicketListUI) {}
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(89303);
    ab.i("MicroMsg.CardTicketListUI", "click item");
    paramView = CardTicketListUI.b(this.kAE).ts(paramInt);
    if (paramView != null)
    {
      switch (paramView.type)
      {
      }
      do
      {
        AppMethodBeat.o(89303);
        return;
        paramView = paramView.kAA;
        if (paramView != null) {
          switch (paramView.xza)
          {
          }
        }
        for (;;)
        {
          h.qsU.e(16322, new Object[] { Integer.valueOf(7) });
          AppMethodBeat.o(89303);
          return;
          b.a((MMActivity)this.kAE, paramView.xzb);
          continue;
          paramView = paramView.xzc;
          if (paramView != null) {
            b.x(paramView.ugl, paramView.uaL, paramView.urD);
          }
        }
        paramView = paramView.kAB;
      } while (paramView == null);
      Object localObject = this.kAE;
      String str1 = paramView.wmm;
      j.p(str1, "user_card_id");
      CardTicketListUI.a((CardTicketListUI)localObject, str1);
      h.qsU.e(16322, new Object[] { Integer.valueOf(10) });
      localObject = h.qsU;
      paramInt = paramView.xyT;
      str1 = paramView.wmm;
      c localc = CardTicketListUI.b(this.kAE);
      String str2 = paramView.wmm;
      j.p(str2, "user_card_id");
      ((h)localObject).e(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(localc.bP(str2, paramView.xyT)), Integer.valueOf(1) });
      AppMethodBeat.o(89303);
      return;
    }
    AppMethodBeat.o(89303);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI.g
 * JD-Core Version:    0.7.0.1
 */