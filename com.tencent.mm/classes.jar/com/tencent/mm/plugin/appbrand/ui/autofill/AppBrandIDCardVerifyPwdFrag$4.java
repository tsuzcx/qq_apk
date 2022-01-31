package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMFormVerifyCodeInputView;

final class AppBrandIDCardVerifyPwdFrag$4
  implements TextWatcher
{
  AppBrandIDCardVerifyPwdFrag$4(AppBrandIDCardVerifyPwdFrag paramAppBrandIDCardVerifyPwdFrag) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(133256);
    if (AppBrandIDCardVerifyPwdFrag.e(this.iQF).getText().toString().length() > 0)
    {
      AppBrandIDCardVerifyPwdFrag.f(this.iQF).setEnabled(true);
      AppMethodBeat.o(133256);
      return;
    }
    AppBrandIDCardVerifyPwdFrag.f(this.iQF).setEnabled(false);
    AppMethodBeat.o(133256);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.4
 * JD-Core Version:    0.7.0.1
 */