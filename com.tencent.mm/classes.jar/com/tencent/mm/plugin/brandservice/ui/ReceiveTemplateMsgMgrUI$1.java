package com.tencent.mm.plugin.brandservice.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReceiveTemplateMsgMgrUI$1
  implements MenuItem.OnMenuItemClickListener
{
  ReceiveTemplateMsgMgrUI$1(ReceiveTemplateMsgMgrUI paramReceiveTemplateMsgMgrUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(14021);
    this.jUK.finish();
    AppMethodBeat.o(14021);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.ReceiveTemplateMsgMgrUI.1
 * JD-Core Version:    0.7.0.1
 */