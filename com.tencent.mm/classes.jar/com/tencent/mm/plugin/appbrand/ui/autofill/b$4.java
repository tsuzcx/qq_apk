package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class b$4
  implements TextWatcher
{
  b$4(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (b.e(this.hfr).getText().toString().length() > 0)
    {
      b.f(this.hfr).setEnabled(true);
      return;
    }
    b.f(this.hfr).setEnabled(false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.4
 * JD-Core Version:    0.7.0.1
 */