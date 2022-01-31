package com.tencent.mm.plugin.account.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.o;

final class RegSetInfoUI$31
  implements TextWatcher
{
  RegSetInfoUI$31(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if (!RegSetInfoUI.m(this.fso).crl()) {
      RegSetInfoUI.m(this.fso).stopTimer();
    }
    paramEditable = RegSetInfoUI.a(this.fso).getText().toString().trim();
    if (bk.bl(paramEditable))
    {
      RegSetInfoUI.r(this.fso).setText(this.fso.getString(q.j.regsetinfo_tip));
      RegSetInfoUI.s(this.fso);
      if (RegSetInfoUI.t(this.fso) != null)
      {
        RegSetInfoUI.t(this.fso).dismiss();
        RegSetInfoUI.u(this.fso);
      }
      RegSetInfoUI.a(this.fso).postDelayed(new RegSetInfoUI.31.1(this), 50L);
    }
    if ((!bk.bl(paramEditable)) && ((RegSetInfoUI.c(this.fso)) || (!paramEditable.equals(RegSetInfoUI.v(this.fso)))))
    {
      RegSetInfoUI.s(this.fso);
      RegSetInfoUI.m(this.fso).S(500L, 500L);
    }
    RegSetInfoUI.a(this.fso, paramEditable);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.31
 * JD-Core Version:    0.7.0.1
 */