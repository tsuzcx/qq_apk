package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.o;

final class RegSetInfoUI$31
  implements TextWatcher
{
  RegSetInfoUI$31(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(125537);
    if (!RegSetInfoUI.m(this.gJQ).dtj()) {
      RegSetInfoUI.m(this.gJQ).stopTimer();
    }
    paramEditable = RegSetInfoUI.a(this.gJQ).getText().toString().trim();
    if (bo.isNullOrNil(paramEditable))
    {
      RegSetInfoUI.r(this.gJQ).setText(this.gJQ.getString(2131302501));
      RegSetInfoUI.s(this.gJQ);
      if (RegSetInfoUI.t(this.gJQ) != null)
      {
        RegSetInfoUI.t(this.gJQ).dismiss();
        RegSetInfoUI.u(this.gJQ);
      }
      RegSetInfoUI.a(this.gJQ).postDelayed(new RegSetInfoUI.31.1(this), 50L);
    }
    if ((!bo.isNullOrNil(paramEditable)) && ((RegSetInfoUI.c(this.gJQ)) || (!paramEditable.equals(RegSetInfoUI.v(this.gJQ)))))
    {
      RegSetInfoUI.s(this.gJQ);
      RegSetInfoUI.m(this.gJQ).ag(500L, 500L);
    }
    RegSetInfoUI.a(this.gJQ, paramEditable);
    AppMethodBeat.o(125537);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.31
 * JD-Core Version:    0.7.0.1
 */