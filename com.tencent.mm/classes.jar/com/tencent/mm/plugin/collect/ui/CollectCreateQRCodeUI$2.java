package com.tencent.mm.plugin.collect.ui;

import android.text.Editable;
import android.text.TextWatcher;

final class CollectCreateQRCodeUI$2
  implements TextWatcher
{
  CollectCreateQRCodeUI$2(CollectCreateQRCodeUI paramCollectCreateQRCodeUI) {}
  
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
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.2
 * JD-Core Version:    0.7.0.1
 */