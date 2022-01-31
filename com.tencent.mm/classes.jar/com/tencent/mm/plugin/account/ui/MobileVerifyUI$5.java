package com.tencent.mm.plugin.account.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class MobileVerifyUI$5
  implements InputFilter
{
  MobileVerifyUI$5(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(125270);
    paramCharSequence = bo.ab(paramCharSequence);
    AppMethodBeat.o(125270);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.5
 * JD-Core Version:    0.7.0.1
 */