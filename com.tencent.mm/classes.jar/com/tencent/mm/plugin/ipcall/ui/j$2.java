package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;

final class j$2
  implements DialPad.a
{
  j$2(j paramj) {}
  
  public final void FF(String paramString)
  {
    String str2 = this.lAg.lzJ.getText().toString();
    if (bk.bl(str2)) {
      this.lAg.lzZ = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    String str1 = str2;
    if (l - this.lAg.lzZ >= 3000L) {
      str1 = str2 + " ";
    }
    str1 = str1 + paramString;
    this.lAg.lzZ = l;
    this.lAg.dD(str1, "");
    c.Fw(paramString);
    h.nFQ.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
  }
  
  public final void FG(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.2
 * JD-Core Version:    0.7.0.1
 */