package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

final class LuckyMoneyPrepareUI$5
  implements TextWatcher
{
  LuckyMoneyPrepareUI$5(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.lMy.setContentDescription(paramEditable.toString());
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.5
 * JD-Core Version:    0.7.0.1
 */