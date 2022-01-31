package com.tencent.mm.plugin.honey_pay.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class HoneyPayModifyQuotaUI$1
  implements TextWatcher
{
  HoneyPayModifyQuotaUI$1(HoneyPayModifyQuotaUI paramHoneyPayModifyQuotaUI) {}
  
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
    HoneyPayModifyQuotaUI.a(this.llR);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayModifyQuotaUI.1
 * JD-Core Version:    0.7.0.1
 */