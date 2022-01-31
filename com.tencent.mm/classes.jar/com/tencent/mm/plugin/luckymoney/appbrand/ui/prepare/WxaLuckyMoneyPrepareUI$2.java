package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$2
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$2(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42054);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.b(this.ojQ), 2);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.c(this.ojQ), 0);
    this.ojQ.mKeyboard.setXMode(2);
    this.ojQ.mKeyboard.setInputEditText((EditText)paramView);
    this.ojQ.mKBLayout.setVisibility(0);
    AppMethodBeat.o(42054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */