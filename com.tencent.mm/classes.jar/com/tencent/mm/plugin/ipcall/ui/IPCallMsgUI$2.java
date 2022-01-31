package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.g;

final class IPCallMsgUI$2
  implements MMSlideDelView.g
{
  IPCallMsgUI$2(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final void r(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22187);
    IPCallMsgUI.a(this.nTV).performItemClick(paramView, paramInt1, paramInt2);
    AppMethodBeat.o(22187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.2
 * JD-Core Version:    0.7.0.1
 */