package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.protocal.protobuf.ou;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/card/ui/v2/CardHomePageNewUI$HomePageVH$showMiniAppLayout$1$1"})
final class CardHomePageNewUI$e$i
  implements View.OnClickListener
{
  CardHomePageNewUI$e$i(on paramon, CardHomePageNewUI.e parame, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89198);
    if (this.kzQ.wEV != null) {
      if (this.kzQ.wEV == null) {
        break label225;
      }
    }
    label225:
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
      CardHomePageNewUI.j(this.kzM.kzs);
      CardHomePageNewUI.a(this.kzM.kzs, 0);
      CardHomePageNewUI.a(this.kzM.kzs, this.kzQ);
      b.x(this.kzQ.wEV.ugl, this.kzQ.wEV.uaL, this.kzQ.wEV.urD);
      paramView = h.qsU;
      Object localObject = this.kzM.kzL;
      if (localObject == null) {
        j.ebi();
      }
      localObject = ((CardHomePageNewUI.a)localObject).kzm;
      if (localObject == null) {
        j.ebi();
      }
      paramView.e(16324, new Object[] { Integer.valueOf(1), ((on)localObject).wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(6), Integer.valueOf(this.iWi), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
      AppMethodBeat.o(89198);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.e.i
 * JD-Core Version:    0.7.0.1
 */