package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

final class MobileVerifyUI$7
  implements TextWatcher
{
  MobileVerifyUI$7(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(128444);
    if (bt.isNullOrNil(this.jod.jah.getText().toString()))
    {
      this.jod.jah.setTextSize(15.0F);
      this.jod.jah.setGravity(16);
    }
    while ((this.jod.jah.getText() != null) && (this.jod.jah.getText().toString().length() > 0))
    {
      this.jod.fQh.setEnabled(true);
      AppMethodBeat.o(128444);
      return;
      this.jod.jah.setTextSize(24.0F);
      this.jod.jah.setGravity(16);
    }
    this.jod.fQh.setEnabled(false);
    AppMethodBeat.o(128444);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.7
 * JD-Core Version:    0.7.0.1
 */