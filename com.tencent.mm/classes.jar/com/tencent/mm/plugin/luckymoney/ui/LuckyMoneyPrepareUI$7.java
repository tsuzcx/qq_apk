package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$7
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$7(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lXg.J(LuckyMoneyPrepareUI.b(this.lXg), 2);
    this.lXg.J(LuckyMoneyPrepareUI.a(this.lXg), 0);
    this.lXg.mKeyboard.setXMode(2);
    this.lXg.mKeyboard.setInputEditText(this.eYi);
    this.lXg.lMr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.7
 * JD-Core Version:    0.7.0.1
 */