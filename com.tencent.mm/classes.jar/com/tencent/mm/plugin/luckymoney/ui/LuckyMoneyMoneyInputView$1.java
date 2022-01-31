package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyMoneyInputView$1
  implements TextWatcher
{
  LuckyMoneyMoneyInputView$1(LuckyMoneyMoneyInputView paramLuckyMoneyMoneyInputView) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(42739);
    if (LuckyMoneyMoneyInputView.a(this.otO) != null)
    {
      paramEditable = LuckyMoneyMoneyInputView.a(this.otO);
      this.otO.getInputViewId();
      paramEditable.bMQ();
    }
    AppMethodBeat.o(42739);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView.1
 * JD-Core Version:    0.7.0.1
 */