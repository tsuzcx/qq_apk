package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WxaLuckyMoneyPrepareUI$6$2
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$6$2(WxaLuckyMoneyPrepareUI.6 param6) {}
  
  public final void run()
  {
    AppMethodBeat.i(42059);
    this.ojS.ojQ.hideTenpayKB();
    ((InputMethodManager)this.ojS.ojQ.getContext().getSystemService("input_method")).showSoftInput(this.ojS.val$hintTv, 0);
    AppMethodBeat.o(42059);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6.2
 * JD-Core Version:    0.7.0.1
 */