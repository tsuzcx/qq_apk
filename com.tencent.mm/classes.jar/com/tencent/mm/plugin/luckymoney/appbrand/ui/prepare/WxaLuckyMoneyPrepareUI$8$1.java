package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$8$1
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$8$1(WxaLuckyMoneyPrepareUI.8 param8) {}
  
  public final void run()
  {
    AppMethodBeat.i(42062);
    this.ojT.ojQ.mKBLayout.setVisibility(0);
    this.ojT.val$parent.requestFocus();
    if (this.ojT.ojQ.mKeyboard != null) {
      this.ojT.ojQ.mKeyboard.setInputEditText(this.ojT.val$hintTv);
    }
    WxaLuckyMoneyPrepareUI.b(this.ojT.ojQ, this.ojT.val$editMode);
    AppMethodBeat.o(42062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.8.1
 * JD-Core Version:    0.7.0.1
 */