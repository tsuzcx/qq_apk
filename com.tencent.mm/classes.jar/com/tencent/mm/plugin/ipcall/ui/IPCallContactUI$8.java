package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.model.a;

final class IPCallContactUI$8
  implements Runnable
{
  IPCallContactUI$8(IPCallContactUI paramIPCallContactUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(25698);
    a.dgh().a(IPCallContactUI.g(this.vcn), false);
    AppMethodBeat.o(25698);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallContactUI.8
 * JD-Core Version:    0.7.0.1
 */