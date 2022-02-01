package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MTimerHandler;

final class RegSetInfoUI$28
  implements TextWatcher
{
  RegSetInfoUI$28(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(128694);
    paramEditable = RegSetInfoUI.b(this.njA).getText().toString().trim();
    if ((paramEditable != null) && (paramEditable.length() > 16))
    {
      RegSetInfoUI.b(this.njA).setText(paramEditable.substring(0, 16));
      AppMethodBeat.o(128694);
      return;
    }
    if (!RegSetInfoUI.m(this.njA).stopped()) {
      RegSetInfoUI.m(this.njA).stopTimer();
    }
    RegSetInfoUI.n(this.njA);
    if (!RegSetInfoUI.o(this.njA)) {
      RegSetInfoUI.a(this.njA).setText(paramEditable);
    }
    AppMethodBeat.o(128694);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.28
 * JD-Core Version:    0.7.0.1
 */