package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MMSlideDelView.c;

final class IPCallMsgUI$1
  implements MMSlideDelView.c
{
  IPCallMsgUI$1(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final int dc(View paramView)
  {
    AppMethodBeat.i(22186);
    int i = IPCallMsgUI.a(this.nTV).getPositionForView(paramView);
    AppMethodBeat.o(22186);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.1
 * JD-Core Version:    0.7.0.1
 */