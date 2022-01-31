package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ac;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.d;

final class LuckyMoneyPrepareUI$27
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$27(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, ag paramag) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142080);
    LuckyMoneyPrepareUI.a(this.owL, new ac());
    LuckyMoneyPrepareUI.h(this.owL).cRI = 2L;
    LuckyMoneyPrepareUI.h(this.owL).ake();
    boolean bool = bo.z(paramView.getTag(), "delete");
    if ((!bool) && (!bo.hl(this.oqO.opo, 1)))
    {
      LuckyMoneyPrepareUI.b(this.owL, 2);
      LuckyMoneyPrepareUI.y(this.owL);
      AppMethodBeat.o(142080);
      return;
    }
    paramView = new d(this.owL.getContext(), 1, false);
    paramView.sao = new LuckyMoneyPrepareUI.27.1(this, bool);
    paramView.sap = new LuckyMoneyPrepareUI.27.2(this);
    paramView.crd();
    AppMethodBeat.o(142080);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.27
 * JD-Core Version:    0.7.0.1
 */