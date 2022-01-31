package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.p.a;

final class IPCallMsgUI$3
  implements p.a
{
  IPCallMsgUI$3(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void apT()
  {
    AppMethodBeat.i(22188);
    if (IPCallMsgUI.b(this.nTV).getCount() == 0)
    {
      IPCallMsgUI.a(this.nTV).setVisibility(8);
      IPCallMsgUI.c(this.nTV).setVisibility(0);
      AppMethodBeat.o(22188);
      return;
    }
    IPCallMsgUI.a(this.nTV).setVisibility(0);
    IPCallMsgUI.c(this.nTV).setVisibility(8);
    AppMethodBeat.o(22188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.3
 * JD-Core Version:    0.7.0.1
 */