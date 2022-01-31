package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.on;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class CardHomePageNewUI$e$h
  implements View.OnClickListener
{
  CardHomePageNewUI$e$h(CardHomePageNewUI.e parame, int paramInt, on paramon) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(89197);
    ab.d("MicroMsg.CardHomePageNewUI", "do expand coupon layout");
    CardHomePageNewUI.e.a(this.kzM, this.euX);
    paramView = this.kzM.kzL;
    if (paramView != null) {
      paramView.kzp = true;
    }
    paramView = h.qsU;
    on localon = this.kzN;
    if (localon == null) {
      j.ebi();
    }
    paramView.e(16324, new Object[] { Integer.valueOf(1), localon.wEJ, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(this.euX), Integer.valueOf(CardHomePageNewUI.l(this.kzM.kzs)) });
    AppMethodBeat.o(89197);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardHomePageNewUI.e.h
 * JD-Core Version:    0.7.0.1
 */