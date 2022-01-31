package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyTextInputView$2
  implements View.OnClickListener
{
  LuckyMoneyTextInputView$2(LuckyMoneyTextInputView paramLuckyMoneyTextInputView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43037);
    if (LuckyMoneyTextInputView.b(this.oxf) != null) {
      LuckyMoneyTextInputView.b(this.oxf).onClick(paramView);
    }
    AppMethodBeat.o(43037);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView.2
 * JD-Core Version:    0.7.0.1
 */