package com.tencent.kinda.framework.widget.base;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.kinda.gen.KMoneyInputTextOnTextChangedCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class MMMoneyInputText$2
  implements TextWatcher
{
  MMMoneyInputText$2(MMMoneyInputText paramMMMoneyInputText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(19287);
    if (paramEditable.toString().startsWith(".")) {
      paramEditable.insert(0, "0");
    }
    String str = paramEditable.toString();
    int i = str.indexOf(".");
    int j = str.length();
    if ((i >= 0) && (j - i > 2)) {
      paramEditable.delete(i + 3, j);
    }
    if (MMMoneyInputText.access$000(this.this$0) != null) {
      MMMoneyInputText.access$000(this.this$0).onTextChanged(paramEditable.toString());
    }
    AppMethodBeat.o(19287);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMMoneyInputText.2
 * JD-Core Version:    0.7.0.1
 */