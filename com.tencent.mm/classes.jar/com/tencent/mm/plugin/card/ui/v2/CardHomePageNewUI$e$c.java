package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.v;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$setModel$1$headerClickListener$1"})
final class CardHomePageNewUI$e$c
  implements View.OnClickListener
{
  CardHomePageNewUI$e$c(on paramon1, CardHomePageNewUI.e parame, on paramon2, int paramInt, CardHomePageNewUI.a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89193);
    ab.i("MicroMsg.CardHomePageNewUI", "click header");
    CardHomePageNewUI.j(this.kzM.kzs);
    CardHomePageNewUI.a(this.kzM.kzs, 0);
    CardHomePageNewUI.a(this.kzM.kzs, this.kzR);
    switch (this.kzQ.wEO)
    {
    }
    for (;;)
    {
      h.qsU.e(16324, new Object[] { Integer.valueOf(1), this.kzQ.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(this.iWi), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
      AppMethodBeat.o(89193);
      return;
      paramView = this.kzM.aku;
      j.p(paramView, "itemView");
      paramView = paramView.getContext();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(89193);
        throw paramView;
      }
      b.a((MMActivity)paramView, this.kzQ.wEP);
      continue;
      paramView = this.kzQ.wEQ;
      b.x(paramView.ugl, paramView.uaL, paramView.urD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.e.c
 * JD-Core Version:    0.7.0.1
 */