package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;

@a.l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
final class CardHomePageNewUI$m
  implements MRecyclerView.b
{
  CardHomePageNewUI$m(CardHomePageNewUI paramCardHomePageNewUI) {}
  
  public final boolean O(View paramView, int paramInt)
  {
    AppMethodBeat.i(89226);
    paramView = CardHomePageNewUI.p(this.kzs).to(paramInt);
    if (paramView != null)
    {
      ab.i("MicroMsg.CardHomePageNewUI", "long click type: %s", new Object[] { Integer.valueOf(paramView.type) });
      switch (paramView.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(89226);
      return false;
      Object localObject = new com.tencent.mm.ui.tools.l((Context)this.kzs.getContext());
      ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new CardHomePageNewUI.m.a(this, paramInt));
      ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new CardHomePageNewUI.m.b(paramView, this, paramInt));
      ((com.tencent.mm.ui.tools.l)localObject).cwt();
      localObject = h.qsU;
      paramView = paramView.kzm;
      if (paramView == null) {
        j.ebi();
      }
      ((h)localObject).e(16324, new Object[] { Integer.valueOf(2), paramView.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(7), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.l(this.kzs)) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.m
 * JD-Core Version:    0.7.0.1
 */