package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class MobileVerifyUI$7
  implements TextWatcher
{
  MobileVerifyUI$7(MobileVerifyUI paramMobileVerifyUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125272);
    if (bo.isNullOrNil(this.gHp.gtO.getText().toString()))
    {
      this.gHp.gtO.setTextSize(15.0F);
      this.gHp.gtO.setGravity(16);
    }
    while ((this.gHp.gtO.getText() != null) && (this.gHp.gtO.getText().toString().length() > 0))
    {
      this.gHp.gHb.setEnabled(true);
      AppMethodBeat.o(125272);
      return;
      this.gHp.gtO.setTextSize(24.0F);
      this.gHp.gtO.setGravity(16);
    }
    this.gHp.gHb.setEnabled(false);
    AppMethodBeat.o(125272);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MobileVerifyUI.7
 * JD-Core Version:    0.7.0.1
 */