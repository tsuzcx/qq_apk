package com.tencent.mm.plugin.account.bind.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class BindMContactVerifyUI$1
  implements InputFilter
{
  BindMContactVerifyUI$1(BindMContactVerifyUI paramBindMContactVerifyUI) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(13479);
    paramCharSequence = bo.ab(paramCharSequence);
    AppMethodBeat.o(13479);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */