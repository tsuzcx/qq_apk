package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.a;

final class LuckyMoneyBusiDetailUI$9
  implements MMEditText.a
{
  LuckyMoneyBusiDetailUI$9(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void bNU()
  {
    AppMethodBeat.i(42591);
    if (LuckyMoneyBusiDetailUI.f(this.orQ).getVisibility() == 0)
    {
      LuckyMoneyBusiDetailUI.f(this.orQ).setVisibility(8);
      AppMethodBeat.o(42591);
      return;
    }
    this.orQ.getContext().finish();
    AppMethodBeat.o(42591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.9
 * JD-Core Version:    0.7.0.1
 */