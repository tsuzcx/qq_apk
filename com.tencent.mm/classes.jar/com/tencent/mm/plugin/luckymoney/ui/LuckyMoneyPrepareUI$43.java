package com.tencent.mm.plugin.luckymoney.ui;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.a.a.a;

final class LuckyMoneyPrepareUI$43
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$43(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, SpannableString paramSpannableString, j paramj1, j paramj2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(142096);
    if (!a.a.dDt().dDs())
    {
      AppMethodBeat.o(142096);
      return;
    }
    if (LuckyMoneyPrepareUI.f(this.owL).getText().toString().equals(this.ojW.toString()))
    {
      this.owW.onClick(paramView);
      AppMethodBeat.o(142096);
      return;
    }
    this.owX.onClick(paramView);
    AppMethodBeat.o(142096);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.43
 * JD-Core Version:    0.7.0.1
 */