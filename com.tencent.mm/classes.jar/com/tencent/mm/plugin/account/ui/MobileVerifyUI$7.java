package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bk;

final class MobileVerifyUI$7
  implements TextWatcher
{
  MobileVerifyUI$7(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (bk.bl(this.fpS.fcd.getText().toString()))
    {
      this.fpS.fcd.setTextSize(15.0F);
      this.fpS.fcd.setGravity(16);
    }
    while ((this.fpS.fcd.getText() != null) && (this.fpS.fcd.getText().toString().length() > 0))
    {
      this.fpS.fpF.setEnabled(true);
      return;
      this.fpS.fcd.setTextSize(24.0F);
      this.fpS.fcd.setGravity(16);
    }
    this.fpS.fpF.setEnabled(false);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.7
 * JD-Core Version:    0.7.0.1
 */