package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class i$2
  implements DialPad.a
{
  i$2(i parami) {}
  
  public final void aJd(String paramString)
  {
    AppMethodBeat.i(26023);
    String str2 = this.JQT.JQu.getText().toString();
    if (Util.isNullOrNil(str2)) {
      this.JQT.JQK = System.currentTimeMillis();
    }
    long l = System.currentTimeMillis();
    String str1 = str2;
    if (l - this.JQT.JQK >= 3000L) {
      str1 = str2 + " ";
    }
    str1 = str1 + paramString;
    this.JQT.JQK = l;
    this.JQT.jL(str1, "");
    c.aIR(paramString);
    h.OAn.b(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1) });
    AppMethodBeat.o(26023);
  }
  
  public final void aJe(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.i.2
 * JD-Core Version:    0.7.0.1
 */