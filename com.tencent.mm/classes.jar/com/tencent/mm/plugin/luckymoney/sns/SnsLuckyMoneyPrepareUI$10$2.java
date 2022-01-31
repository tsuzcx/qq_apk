package com.tencent.mm.plugin.luckymoney.sns;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SnsLuckyMoneyPrepareUI$10$2
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$10$2(SnsLuckyMoneyPrepareUI.10 param10) {}
  
  public final void run()
  {
    AppMethodBeat.i(42518);
    this.oqQ.oqN.hideTenpayKB();
    ((InputMethodManager)this.oqQ.oqN.getContext().getSystemService("input_method")).showSoftInput(this.oqQ.val$hintTv, 0);
    AppMethodBeat.o(42518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10.2
 * JD-Core Version:    0.7.0.1
 */