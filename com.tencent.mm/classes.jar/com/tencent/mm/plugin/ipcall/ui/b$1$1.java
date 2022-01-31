package com.tencent.mm.plugin.ipcall.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.g.c;

final class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, c paramc) {}
  
  public final void run()
  {
    AppMethodBeat.i(21967);
    if ((this.nQR != null) && (this.nQR.systemRowid != -1L))
    {
      this.nQS.nQQ.gqe.setText(this.nQR.field_systemAddressBookUsername);
      AppMethodBeat.o(21967);
      return;
    }
    this.nQS.nQQ.gqe.setText("");
    AppMethodBeat.o(21967);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.b.1.1
 * JD-Core Version:    0.7.0.1
 */