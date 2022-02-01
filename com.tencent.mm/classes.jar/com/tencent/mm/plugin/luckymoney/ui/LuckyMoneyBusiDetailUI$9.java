package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.a;

final class LuckyMoneyBusiDetailUI$9
  implements MMEditText.a
{
  LuckyMoneyBusiDetailUI$9(LuckyMoneyBusiDetailUI paramLuckyMoneyBusiDetailUI) {}
  
  public final void onBack()
  {
    AppMethodBeat.i(65458);
    if (LuckyMoneyBusiDetailUI.f(this.zcr).getVisibility() == 0)
    {
      LuckyMoneyBusiDetailUI.f(this.zcr).setVisibility(8);
      AppMethodBeat.o(65458);
      return;
    }
    this.zcr.getContext().finish();
    AppMethodBeat.o(65458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBusiDetailUI.9
 * JD-Core Version:    0.7.0.1
 */