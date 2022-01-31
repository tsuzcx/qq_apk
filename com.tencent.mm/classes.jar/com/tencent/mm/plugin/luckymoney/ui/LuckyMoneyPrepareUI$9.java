package com.tencent.mm.plugin.luckymoney.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

final class LuckyMoneyPrepareUI$9
  implements View.OnFocusChangeListener
{
  LuckyMoneyPrepareUI$9(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText1, EditText paramEditText2) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    this.eYi.setOnClickListener(null);
    this.lMy.setOnClickListener(null);
    this.lXg.J(LuckyMoneyPrepareUI.b(this.lXg), 2);
    this.lXg.J(LuckyMoneyPrepareUI.a(this.lXg), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.9
 * JD-Core Version:    0.7.0.1
 */