package com.tencent.mm.plugin.luckymoney.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

final class LuckyMoneyPrepareUI$4
  implements TextWatcher
{
  LuckyMoneyPrepareUI$4(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI, EditText paramEditText) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 3)) {
      paramEditable.delete(i + 3, j);
    }
    for (;;)
    {
      this.eYi.setContentDescription(paramEditable.toString());
      return;
      if (i > 6) {
        paramEditable.delete(6, i);
      } else if ((i == -1) && (j > 6)) {
        paramEditable.delete(6, j);
      }
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */