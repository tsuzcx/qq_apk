package com.tencent.mm.plugin.honey_pay.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class HoneyPayGiveCardUI$1
  implements TextWatcher
{
  HoneyPayGiveCardUI$1(HoneyPayGiveCardUI paramHoneyPayGiveCardUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(41859);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 2)) {
      paramEditable.delete(i + 3, j);
    }
    HoneyPayGiveCardUI.a(this.nIX);
    AppMethodBeat.o(41859);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayGiveCardUI.1
 * JD-Core Version:    0.7.0.1
 */