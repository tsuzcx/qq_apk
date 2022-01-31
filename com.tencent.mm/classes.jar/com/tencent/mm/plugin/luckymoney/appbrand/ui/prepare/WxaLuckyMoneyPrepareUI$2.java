package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$2
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$2(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lMx.J(WxaLuckyMoneyPrepareUI.b(this.lMx), 2);
    this.lMx.J(WxaLuckyMoneyPrepareUI.c(this.lMx), 0);
    this.lMx.mKeyboard.setXMode(2);
    this.lMx.mKeyboard.setInputEditText((EditText)paramView);
    this.lMx.lMr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.2
 * JD-Core Version:    0.7.0.1
 */