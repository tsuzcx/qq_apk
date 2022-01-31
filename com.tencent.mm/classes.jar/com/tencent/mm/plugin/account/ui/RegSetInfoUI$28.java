package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.am;

final class RegSetInfoUI$28
  implements TextWatcher
{
  RegSetInfoUI$28(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = RegSetInfoUI.b(this.fso).getText().toString().trim();
    if ((paramEditable != null) && (paramEditable.length() > 16)) {
      RegSetInfoUI.b(this.fso).setText(paramEditable.substring(0, 16));
    }
    do
    {
      return;
      if (!RegSetInfoUI.m(this.fso).crl()) {
        RegSetInfoUI.m(this.fso).stopTimer();
      }
      RegSetInfoUI.n(this.fso);
    } while (RegSetInfoUI.o(this.fso));
    RegSetInfoUI.a(this.fso).setText(paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.28
 * JD-Core Version:    0.7.0.1
 */