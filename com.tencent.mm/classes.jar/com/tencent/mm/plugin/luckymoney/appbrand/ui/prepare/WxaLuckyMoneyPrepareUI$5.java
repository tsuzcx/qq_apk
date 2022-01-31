package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

final class WxaLuckyMoneyPrepareUI$5
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyPrepareUI$5(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lMx.J(WxaLuckyMoneyPrepareUI.b(this.lMx), 2);
    this.lMx.J(WxaLuckyMoneyPrepareUI.c(this.lMx), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.5
 * JD-Core Version:    0.7.0.1
 */