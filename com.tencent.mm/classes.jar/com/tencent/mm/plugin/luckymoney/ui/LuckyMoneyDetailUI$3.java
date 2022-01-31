package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMEditText.a;

final class LuckyMoneyDetailUI$3
  implements MMEditText.a
{
  LuckyMoneyDetailUI$3(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void bNU()
  {
    AppMethodBeat.i(42648);
    if (LuckyMoneyDetailUI.t(this.otz).getVisibility() == 0)
    {
      LuckyMoneyDetailUI.t(this.otz).setVisibility(8);
      AppMethodBeat.o(42648);
      return;
    }
    this.otz.getContext().finish();
    AppMethodBeat.o(42648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.3
 * JD-Core Version:    0.7.0.1
 */