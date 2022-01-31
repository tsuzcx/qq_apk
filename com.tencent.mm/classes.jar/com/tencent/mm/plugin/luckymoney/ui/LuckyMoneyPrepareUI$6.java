package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class LuckyMoneyPrepareUI$6
  implements View.OnClickListener
{
  LuckyMoneyPrepareUI$6(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onClick(View paramView)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lXg.J(LuckyMoneyPrepareUI.b(this.lXg), 2);
    this.lXg.J(LuckyMoneyPrepareUI.a(this.lXg), 0);
    this.lXg.mKeyboard.setXMode(2);
    this.lXg.mKeyboard.setInputEditText((EditText)paramView);
    this.lXg.lMr.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */