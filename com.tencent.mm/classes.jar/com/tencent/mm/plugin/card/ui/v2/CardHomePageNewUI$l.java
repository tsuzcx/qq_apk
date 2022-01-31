package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
final class CardHomePageNewUI$l
  implements MRecyclerView.a
{
  CardHomePageNewUI$l(CardHomePageNewUI paramCardHomePageNewUI) {}
  
  public final void N(View paramView, int paramInt)
  {
    AppMethodBeat.i(89222);
    paramView = CardHomePageNewUI.p(this.kzs).to(paramInt);
    if (paramView != null)
    {
      ab.i("MicroMsg.CardHomePageNewUI", "click type: %s", new Object[] { Integer.valueOf(paramView.type) });
      Object localObject2;
      switch (paramView.type)
      {
      case 3: 
      default: 
        AppMethodBeat.o(89222);
        return;
      case 2: 
        CardHomePageNewUI.j(this.kzs);
        CardHomePageNewUI.a(this.kzs, 1);
        CardHomePageNewUI.a(this.kzs, paramView.kzm);
        localObject1 = paramView.kzm;
        if (localObject1 == null) {
          j.ebi();
        }
        switch (((on)localObject1).wEO)
        {
        }
        for (;;)
        {
          localObject1 = h.qsU;
          paramView = paramView.kzm;
          if (paramView == null) {
            j.ebi();
          }
          ((h)localObject1).e(16324, new Object[] { Integer.valueOf(2), paramView.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(paramInt), Integer.valueOf(CardHomePageNewUI.l(this.kzs)) });
          AppMethodBeat.o(89222);
          return;
          localObject1 = (MMActivity)this.kzs;
          localObject2 = paramView.kzm;
          if (localObject2 == null) {
            j.ebi();
          }
          b.a((MMActivity)localObject1, ((on)localObject2).wEP);
          continue;
          localObject1 = paramView.kzm;
          if (localObject1 == null) {
            j.ebi();
          }
          localObject1 = ((on)localObject1).wEQ;
          b.x(((ou)localObject1).ugl, ((ou)localObject1).uaL, ((ou)localObject1).urD);
        }
      case 4: 
        ab.i("MicroMsg.CardHomePageNewUI", "click ticket item");
        paramView = new Intent((Context)this.kzs, CardTicketListUI.class);
        this.kzs.startActivity(paramView);
        h.qsU.e(16322, new Object[] { Integer.valueOf(5) });
        AppMethodBeat.o(89222);
        return;
      case 5: 
        h.qsU.e(16322, new Object[] { Integer.valueOf(13) });
        AppMethodBeat.o(89222);
        return;
      }
      Object localObject1 = paramView.kzq;
      if (localObject1 == null) {
        j.ebi();
      }
      switch (((oq)localObject1).wFj)
      {
      }
      for (;;)
      {
        localObject1 = paramView.kzq;
        if (localObject1 == null) {
          j.ebi();
        }
        ((oq)localObject1).wFo = 0;
        paramView = paramView.kzq;
        if (paramView == null) {
          j.ebi();
        }
        paramView.wFn = 0;
        CardHomePageNewUI.p(this.kzs).bR(paramInt);
        break;
        localObject1 = (MMActivity)this.kzs;
        localObject2 = paramView.kzq;
        if (localObject2 == null) {
          j.ebi();
        }
        b.a((MMActivity)localObject1, ((oq)localObject2).wFk);
        CardHomePageNewUI.r(this.kzs);
        continue;
        localObject1 = paramView.kzq;
        if (localObject1 == null) {
          j.ebi();
        }
        localObject1 = ((oq)localObject1).wFl;
        b.x(((ou)localObject1).ugl, ((ou)localObject1).uaL, ((ou)localObject1).urD);
        CardHomePageNewUI.r(this.kzs);
        continue;
        localObject1 = new StringBuilder("click native url: ");
        localObject2 = paramView.kzq;
        if (localObject2 == null) {
          j.ebi();
        }
        ab.i("MicroMsg.CardHomePageNewUI", ((oq)localObject2).wFm);
        localObject1 = paramView.kzq;
        if (localObject1 == null) {
          j.ebi();
        }
        if (j.e("weixin://mktcard/cert", ((oq)localObject1).wFm))
        {
          localObject1 = new Intent((Context)this.kzs, CardTicketListUI.class);
          this.kzs.startActivity((Intent)localObject1);
          CardHomePageNewUI.r(this.kzs);
        }
      }
    }
    AppMethodBeat.o(89222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.l
 * JD-Core Version:    0.7.0.1
 */