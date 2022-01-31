package com.tencent.mm.plugin.account.bind.ui;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mm.sdk.platformtools.bk;

final class BindMContactVerifyUI$1
  implements InputFilter
{
  BindMContactVerifyUI$1(BindMContactVerifyUI paramBindMContactVerifyUI) {}
  
  public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    return bk.M(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.1
 * JD-Core Version:    0.7.0.1
 */