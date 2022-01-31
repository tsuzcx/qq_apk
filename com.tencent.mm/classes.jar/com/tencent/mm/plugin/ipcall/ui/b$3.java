package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

final class b$3
  implements DialPad.a
{
  b$3(b paramb) {}
  
  public final void Rh(String paramString)
  {
    AppMethodBeat.i(21972);
    this.nQQ.nQG = this.nQQ.nQy.getText().toString();
    if (this.nQQ.nQK)
    {
      this.nQQ.nQF += paramString;
      this.nQQ.nQx.setText(this.nQQ.nQF);
      if ((a.RD(this.nQQ.nQF.replace("+", ""))) || (this.nQQ.nQF.replace("+", "").length() >= 4))
      {
        h.qsU.e(12061, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        this.nQQ.nQK = false;
        this.nQQ.nQE = a.RA(this.nQQ.nQF.replace("+", ""));
        this.nQQ.nQG = b.eT(this.nQQ.nQF.replace("+", ""), this.nQQ.nQG);
        this.nQQ.cy(this.nQQ.nQG, -1);
        AppMethodBeat.o(21972);
      }
    }
    else
    {
      String str = this.nQQ.nQx.getText().toString().replace("+", "");
      if (!this.nQQ.nQN) {
        break label726;
      }
      StringBuffer localStringBuffer = new StringBuffer(this.nQQ.nQG);
      localStringBuffer.insert(this.nQQ.nQy.getSelectionStart(), paramString);
      this.nQQ.nQG = localStringBuffer.toString();
      if (this.nQQ.nQG.equals("00"))
      {
        this.nQQ.nQx.setText("+");
        this.nQQ.nQK = true;
        this.nQQ.nQF = "+";
        this.nQQ.nQG = "";
      }
      if (a.RD(this.nQQ.nQF.replace("+", "") + this.nQQ.nQG))
      {
        this.nQQ.nQx.setText("+" + this.nQQ.nQF.replace("+", "") + this.nQQ.nQG);
        this.nQQ.nQE = a.RA(this.nQQ.nQF.replace("+", ""));
        this.nQQ.nQK = false;
        this.nQQ.nQF = (this.nQQ.nQF.replace("+", "") + this.nQQ.nQG);
        this.nQQ.nQG = "";
      }
      paramString = this.nQQ.nQG;
      this.nQQ.nQG = b.eT(str, this.nQQ.nQG);
      if (!this.nQQ.nQN) {
        break label868;
      }
      if (paramString.length() >= this.nQQ.nQG.length()) {
        break label760;
      }
      this.nQQ.cy(this.nQQ.nQG, this.nQQ.nQy.getSelectionEnd() + 2);
    }
    label726:
    label868:
    for (;;)
    {
      this.nQQ.nQJ = System.currentTimeMillis();
      if ((this.nQQ.nQG.length() > a.nXt) && (!bo.isNullOrNil(this.nQQ.nQF + this.nQQ.nQG))) {
        this.nQQ.bJZ();
      }
      AppMethodBeat.o(21972);
      return;
      this.nQQ.nQG += paramString;
      break;
      label760:
      if (paramString.length() == this.nQQ.nQG.length())
      {
        this.nQQ.cy(this.nQQ.nQG, this.nQQ.nQy.getSelectionEnd() + 1);
      }
      else if (paramString.length() > this.nQQ.nQG.length())
      {
        this.nQQ.cy(this.nQQ.nQG, this.nQQ.nQy.getSelectionEnd() + 1 - (paramString.length() - this.nQQ.nQG.length()));
        continue;
        this.nQQ.cy(this.nQQ.nQG, -1);
      }
    }
  }
  
  public final void Ri(String paramString)
  {
    AppMethodBeat.i(21973);
    if (paramString.equals("0"))
    {
      this.nQQ.nQx.setText("+");
      this.nQQ.nQK = true;
      this.nQQ.nQF = "+";
    }
    AppMethodBeat.o(21973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.3
 * JD-Core Version:    0.7.0.1
 */