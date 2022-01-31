package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.bk;

final class b$9
  implements TextWatcher
{
  b$9(b paramb) {}
  
  public final void afterTextChanged(Editable paramEditable) {}
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    String str = bk.Gi(paramCharSequence.toString());
    if (str.contains(" "))
    {
      paramCharSequence = str.replace(" ", "");
      this.ltx.ltf.setText(bk.M(paramCharSequence));
      if (!a.Gc(paramCharSequence)) {
        break label204;
      }
      str = a.Ga(paramCharSequence);
      if (!bk.bl(str))
      {
        this.ltx.lte.setText("+" + str);
        this.ltx.ltf.setText(a.Gf(paramCharSequence));
      }
    }
    for (;;)
    {
      if (this.ltx.ltc != null) {
        this.ltx.ltc.FJ(this.ltx.ltf.getText().toString());
      }
      return;
      if (this.ltx.ltw.equals(str))
      {
        paramCharSequence = str;
        if (paramInt3 <= 0) {
          break;
        }
      }
      paramCharSequence = str;
      if (!bk.bl(str)) {
        break;
      }
      this.ltx.ltw = str;
      this.ltx.ltf.setText("");
      paramCharSequence = str;
      break;
      label204:
      if (!paramCharSequence.equals(this.ltx.ltw))
      {
        this.ltx.ltw = paramCharSequence;
        this.ltx.ltf.setText(paramCharSequence);
        if (bk.bl(this.ltx.lte.getText().toString())) {
          this.ltx.lte.setText("+" + a.bdo());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.9
 * JD-Core Version:    0.7.0.1
 */