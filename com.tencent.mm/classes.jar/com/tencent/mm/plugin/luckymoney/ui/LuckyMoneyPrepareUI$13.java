package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class LuckyMoneyPrepareUI$13
  implements TextWatcher
{
  LuckyMoneyPrepareUI$13(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(65839);
    this.vkC.setContentDescription(paramEditable.toString());
    AppMethodBeat.o(65839);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.13
 * JD-Core Version:    0.7.0.1
 */