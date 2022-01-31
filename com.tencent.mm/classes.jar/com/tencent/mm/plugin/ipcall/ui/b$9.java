package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bo;

final class b$9
  implements TextWatcher
{
  b$9(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21979);
    String str = bo.RK(paramCharSequence.toString());
    if (str.contains(" "))
    {
      paramCharSequence = str.replace(" ", "");
      this.nQQ.nQy.setText(bo.ab(paramCharSequence));
      if (!a.RE(paramCharSequence)) {
        break label209;
      }
      str = a.RC(paramCharSequence);
      if (!bo.isNullOrNil(str))
      {
        this.nQQ.nQx.setText("+".concat(String.valueOf(str)));
        this.nQQ.nQy.setText(a.RH(paramCharSequence));
      }
    }
    for (;;)
    {
      if (this.nQQ.nQv != null) {
        this.nQQ.nQv.Rl(this.nQQ.nQy.getText().toString());
      }
      AppMethodBeat.o(21979);
      return;
      if (this.nQQ.nQP.equals(str))
      {
        paramCharSequence = str;
        if (paramInt3 <= 0) {
          break;
        }
      }
      paramCharSequence = str;
      if (!bo.isNullOrNil(str)) {
        break;
      }
      this.nQQ.nQP = str;
      this.nQQ.nQy.setText("");
      paramCharSequence = str;
      break;
      label209:
      if (!paramCharSequence.equals(this.nQQ.nQP))
      {
        this.nQQ.nQP = paramCharSequence;
        this.nQQ.nQy.setText(paramCharSequence);
        if (bo.isNullOrNil(this.nQQ.nQx.getText().toString())) {
          this.nQQ.nQx.setText("+" + a.bKI());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.9
 * JD-Core Version:    0.7.0.1
 */