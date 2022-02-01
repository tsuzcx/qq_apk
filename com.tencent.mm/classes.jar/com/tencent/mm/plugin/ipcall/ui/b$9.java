package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Util;

final class b$9
  implements TextWatcher
{
  b$9(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25596);
    String str = Util.trimPhoneNumber(paramCharSequence.toString());
    if (str.contains(" "))
    {
      paramCharSequence = str.replace(" ", "");
      this.ytr.ysZ.setText(Util.filterNumber(paramCharSequence));
      if (!a.aCy(paramCharSequence)) {
        break label209;
      }
      str = a.extractCountryCode(paramCharSequence);
      if (!Util.isNullOrNil(str))
      {
        this.ytr.ysY.setText("+".concat(String.valueOf(str)));
        this.ytr.ysZ.setText(a.aCB(paramCharSequence));
      }
    }
    for (;;)
    {
      if (this.ytr.ysW != null) {
        this.ytr.ysW.aCg(this.ytr.ysZ.getText().toString());
      }
      AppMethodBeat.o(25596);
      return;
      if (this.ytr.ytq.equals(str))
      {
        paramCharSequence = str;
        if (paramInt3 <= 0) {
          break;
        }
      }
      paramCharSequence = str;
      if (!Util.isNullOrNil(str)) {
        break;
      }
      this.ytr.ytq = str;
      this.ytr.ysZ.setText("");
      paramCharSequence = str;
      break;
      label209:
      if (!paramCharSequence.equals(this.ytr.ytq))
      {
        this.ytr.ytq = paramCharSequence;
        this.ytr.ysZ.setText(paramCharSequence);
        if (Util.isNullOrNil(this.ytr.ysY.getText().toString())) {
          this.ytr.ysY.setText("+" + a.ebK());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.9
 * JD-Core Version:    0.7.0.1
 */