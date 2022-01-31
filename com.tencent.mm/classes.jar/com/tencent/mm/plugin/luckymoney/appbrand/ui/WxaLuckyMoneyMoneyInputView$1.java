package com.tencent.mm.plugin.luckymoney.appbrand.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.plugin.luckymoney.ui.f;

final class WxaLuckyMoneyMoneyInputView$1
  implements TextWatcher
{
  WxaLuckyMoneyMoneyInputView$1(WxaLuckyMoneyMoneyInputView paramWxaLuckyMoneyMoneyInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (WxaLuckyMoneyMoneyInputView.a(this.lLF) != null)
    {
      paramEditable = WxaLuckyMoneyMoneyInputView.a(this.lLF);
      this.lLF.getInputViewId();
      paramEditable.bfq();
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.WxaLuckyMoneyMoneyInputView.1
 * JD-Core Version:    0.7.0.1
 */