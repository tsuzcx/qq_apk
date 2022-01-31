package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$3
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$3(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lMx.J(WxaLuckyMoneyPrepareUI.b(this.lMx), 2);
    this.lMx.J(WxaLuckyMoneyPrepareUI.c(this.lMx), 0);
    this.lMx.mKeyboard.setXMode(2);
    this.lMx.mKeyboard.setInputEditText(this.eYi);
    this.lMx.lMr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */