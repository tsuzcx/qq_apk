package com.tencent.mm.plugin.honey_pay.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class HoneyPayGiveCardUI$1
  implements TextWatcher
{
  HoneyPayGiveCardUI$1(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 2)) {
      paramEditable.delete(i + 3, j);
    }
    HoneyPayGiveCardUI.a(this.llB);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.1
 * JD-Core Version:    0.7.0.1
 */