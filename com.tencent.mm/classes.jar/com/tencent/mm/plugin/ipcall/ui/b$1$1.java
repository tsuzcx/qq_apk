package com.tencent.mm.plugin.ipcall.ui;

import android.widget.TextView;
import com.tencent.mm.plugin.ipcall.a.g.c;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, c paramc) {}
  
  public final void run()
  {
    if ((this.lty != null) && (this.lty.ujK != -1L))
    {
      this.ltz.ltx.eYn.setText(this.lty.field_systemAddressBookUsername);
      return;
    }
    this.ltz.ltx.eYn.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.1.1
 * JD-Core Version:    0.7.0.1
 */