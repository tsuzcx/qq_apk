package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class LuckyMoneyMoneyInputView$1
  implements TextWatcher
{
  LuckyMoneyMoneyInputView$1(LuckyMoneyMoneyInputView paramLuckyMoneyMoneyInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (LuckyMoneyMoneyInputView.a(this.lVK) != null)
    {
      paramEditable = LuckyMoneyMoneyInputView.a(this.lVK);
      this.lVK.getInputViewId();
      paramEditable.bfq();
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView.1
 * JD-Core Version:    0.7.0.1
 */