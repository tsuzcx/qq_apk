package com.tencent.mm.plugin.luckymoney.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$37$2
  implements Runnable
{
  LuckyMoneyPrepareUI$37$2(LuckyMoneyPrepareUI.37 param37) {}
  
  public final void run()
  {
    AppMethodBeat.i(142090);
    LuckyMoneyPrepareUI.F(this.owU.owL).setVisibility(0);
    this.owU.owL.hideTenpayKB();
    ((InputMethodManager)this.owU.owL.getContext().getSystemService("input_method")).showSoftInput(this.owU.val$hintTv, 0);
    AppMethodBeat.o(142090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.37.2
 * JD-Core Version:    0.7.0.1
 */