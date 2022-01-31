package com.tencent.mm.plugin.ipcall.ui;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.bk;

final class b$4
  implements View.OnClickListener
{
  b$4(b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.ltx.ltf.getText().toString();
    if (bk.bl(paramView))
    {
      paramView = this.ltx.lte.getText().toString();
      if (!bk.bl(paramView))
      {
        paramView = paramView.substring(0, paramView.length() - 1);
        if ((!bk.bl(paramView)) && (!paramView.equals("+")))
        {
          this.ltx.lte.setText(paramView);
          this.ltx.ltm = paramView;
        }
      }
      else
      {
        return;
      }
      this.ltx.lte.setText("+");
      this.ltx.ltm = "+";
      this.ltx.ltr = true;
      return;
    }
    int i = this.ltx.ltf.getSelectionStart();
    String str;
    if ((this.ltx.ltu) && (i - 1 >= 0))
    {
      paramView = this.ltx.ltf.getText();
      paramView.delete(i - 1, i);
      paramView = paramView.toString();
      if (bk.bl(paramView)) {
        break label344;
      }
      str = this.ltx.lte.getText().toString().replace("+", "");
      if (!this.ltx.ltu) {
        break label313;
      }
      this.ltx.ltn = b.dB(str, paramView);
      int j = this.ltx.ltn.length();
      int k = paramView.length();
      this.ltx.bL(this.ltx.ltn, j - k + (i - 1));
      label269:
      this.ltx.bcQ();
    }
    for (;;)
    {
      this.ltx.lto = "";
      this.ltx.eYn.setText("");
      return;
      paramView = paramView.substring(0, paramView.length() - 1);
      break;
      label313:
      this.ltx.ltn = b.dB(str, paramView);
      this.ltx.bL(this.ltx.ltn, -1);
      break label269;
      label344:
      this.ltx.ltn = "";
      this.ltx.bL("", -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.4
 * JD-Core Version:    0.7.0.1
 */