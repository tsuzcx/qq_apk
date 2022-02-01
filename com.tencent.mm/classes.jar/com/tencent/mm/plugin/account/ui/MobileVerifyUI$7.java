package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

final class MobileVerifyUI$7
  implements TextWatcher
{
  MobileVerifyUI$7(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(128444);
    if (bs.isNullOrNil(this.iUU.iGY.getText().toString()))
    {
      this.iUU.iGY.setTextSize(15.0F);
      this.iUU.iGY.setGravity(16);
    }
    while ((this.iUU.iGY.getText() != null) && (this.iUU.iGY.getText().toString().length() > 0))
    {
      this.iUU.fwU.setEnabled(true);
      AppMethodBeat.o(128444);
      return;
      this.iUU.iGY.setTextSize(24.0F);
      this.iUU.iGY.setGravity(16);
    }
    this.iUU.fwU.setEnabled(false);
    AppMethodBeat.o(128444);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.7
 * JD-Core Version:    0.7.0.1
 */