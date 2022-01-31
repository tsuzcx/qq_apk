package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;

final class RegSetInfoUI$28
  implements TextWatcher
{
  RegSetInfoUI$28(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125533);
    paramEditable = RegSetInfoUI.b(this.gJQ).getText().toString().trim();
    if ((paramEditable != null) && (paramEditable.length() > 16))
    {
      RegSetInfoUI.b(this.gJQ).setText(paramEditable.substring(0, 16));
      AppMethodBeat.o(125533);
      return;
    }
    if (!RegSetInfoUI.m(this.gJQ).dtj()) {
      RegSetInfoUI.m(this.gJQ).stopTimer();
    }
    RegSetInfoUI.n(this.gJQ);
    if (!RegSetInfoUI.o(this.gJQ)) {
      RegSetInfoUI.a(this.gJQ).setText(paramEditable);
    }
    AppMethodBeat.o(125533);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.28
 * JD-Core Version:    0.7.0.1
 */