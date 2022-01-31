package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.ac;
import com.tencent.mm.plugin.luckymoney.model.e;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.sdk.platformtools.bo;

final class LuckyMoneyBusiReceiveUI$7
  implements View.OnClickListener
{
  LuckyMoneyBusiReceiveUI$7(LuckyMoneyBusiReceiveUI paramLuckyMoneyBusiReceiveUI, ac paramac) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42624);
    LuckyMoneyBusiReceiveUI.k(this.osi).setVisibility(4);
    LuckyMoneyBusiReceiveUI.l(this.osi).setVisibility(8);
    LuckyMoneyBusiReceiveUI.m(this.osi).setVisibility(8);
    if ((this.osk.onF != null) && (!bo.isNullOrNil(this.osk.onF.onb))) {}
    for (paramView = this.osk.onF.onb;; paramView = this.osi.getString(2131301321))
    {
      LuckyMoneyBusiReceiveUI.n(this.osi).setText(paramView);
      LuckyMoneyBusiReceiveUI.o(this.osi).setText(this.osk.ooH);
      LuckyMoneyBusiReceiveUI.p(this.osi).setVisibility(0);
      LuckyMoneyBusiReceiveUI.n(this.osi).setOnClickListener(new LuckyMoneyBusiReceiveUI.7.1(this));
      x.a(LuckyMoneyBusiReceiveUI.k(this.osi), new LuckyMoneyBusiReceiveUI.7.2(this));
      AppMethodBeat.o(42624);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiReceiveUI.7
 * JD-Core Version:    0.7.0.1
 */