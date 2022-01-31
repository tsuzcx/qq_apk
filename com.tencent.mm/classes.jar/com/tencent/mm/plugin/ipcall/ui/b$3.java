package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

final class b$3
  implements DialPad.a
{
  b$3(b paramb) {}
  
  public final void FF(String paramString)
  {
    this.ltx.ltn = this.ltx.ltf.getText().toString();
    if (this.ltx.ltr)
    {
      this.ltx.ltm += paramString;
      this.ltx.lte.setText(this.ltx.ltm);
      if ((a.Gb(this.ltx.ltm.replace("+", ""))) || (this.ltx.ltm.replace("+", "").length() >= 4))
      {
        h.nFQ.f(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        this.ltx.ltr = false;
        this.ltx.ltl = a.FY(this.ltx.ltm.replace("+", ""));
        this.ltx.ltn = b.dB(this.ltx.ltm.replace("+", ""), this.ltx.ltn);
        this.ltx.bL(this.ltx.ltn, -1);
      }
      return;
    }
    String str = this.ltx.lte.getText().toString().replace("+", "");
    if (this.ltx.ltu)
    {
      StringBuffer localStringBuffer = new StringBuffer(this.ltx.ltn);
      localStringBuffer.insert(this.ltx.ltf.getSelectionStart(), paramString);
      this.ltx.ltn = localStringBuffer.toString();
      label329:
      if (this.ltx.ltn.equals("00"))
      {
        this.ltx.lte.setText("+");
        this.ltx.ltr = true;
        this.ltx.ltm = "+";
        this.ltx.ltn = "";
      }
      if (a.Gb(this.ltx.ltm.replace("+", "") + this.ltx.ltn))
      {
        this.ltx.lte.setText("+" + this.ltx.ltm.replace("+", "") + this.ltx.ltn);
        this.ltx.ltl = a.FY(this.ltx.ltm.replace("+", ""));
        this.ltx.ltr = false;
        this.ltx.ltm = (this.ltx.ltm.replace("+", "") + this.ltx.ltn);
        this.ltx.ltn = "";
      }
      paramString = this.ltx.ltn;
      this.ltx.ltn = b.dB(str, this.ltx.ltn);
      if (!this.ltx.ltu) {
        break label850;
      }
      if (paramString.length() >= this.ltx.ltn.length()) {
        break label742;
      }
      this.ltx.bL(this.ltx.ltn, this.ltx.ltf.getSelectionEnd() + 2);
    }
    label850:
    for (;;)
    {
      this.ltx.ltq = System.currentTimeMillis();
      if ((this.ltx.ltn.length() <= a.lAh) || (bk.bl(this.ltx.ltm + this.ltx.ltn))) {
        break;
      }
      this.ltx.bcQ();
      return;
      this.ltx.ltn += paramString;
      break label329;
      label742:
      if (paramString.length() == this.ltx.ltn.length())
      {
        this.ltx.bL(this.ltx.ltn, this.ltx.ltf.getSelectionEnd() + 1);
      }
      else if (paramString.length() > this.ltx.ltn.length())
      {
        this.ltx.bL(this.ltx.ltn, this.ltx.ltf.getSelectionEnd() + 1 - (paramString.length() - this.ltx.ltn.length()));
        continue;
        this.ltx.bL(this.ltx.ltn, -1);
      }
    }
  }
  
  public final void FG(String paramString)
  {
    if (paramString.equals("0"))
    {
      this.ltx.lte.setText("+");
      this.ltx.ltr = true;
      this.ltx.ltm = "+";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.3
 * JD-Core Version:    0.7.0.1
 */