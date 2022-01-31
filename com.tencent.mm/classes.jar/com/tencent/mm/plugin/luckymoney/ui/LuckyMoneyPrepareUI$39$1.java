package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$39$1
  implements Runnable
{
  LuckyMoneyPrepareUI$39$1(LuckyMoneyPrepareUI.39 param39) {}
  
  public final void run()
  {
    AppMethodBeat.i(142093);
    this.owV.owL.mKBLayout.setVisibility(0);
    this.owV.val$parent.requestFocus();
    if (this.owV.owL.mKeyboard != null) {
      this.owV.owL.mKeyboard.setInputEditText(this.owV.val$hintTv);
    }
    LuckyMoneyPrepareUI.c(this.owV.owL, this.owV.val$editMode);
    AppMethodBeat.o(142093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.39.1
 * JD-Core Version:    0.7.0.1
 */