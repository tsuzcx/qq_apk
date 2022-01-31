package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$4
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$4(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(42056);
    this.val$hintTv.setOnClickListener(null);
    this.ojR.setOnClickListener(null);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.b(this.ojQ), 2);
    this.ojQ.Z(WxaLuckyMoneyPrepareUI.c(this.ojQ), 0);
    this.ojQ.mKeyboard.setXMode(0);
    this.ojQ.mKeyboard.setInputEditText((EditText)paramView);
    this.ojQ.mKBLayout.setVisibility(0);
    AppMethodBeat.o(42056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */