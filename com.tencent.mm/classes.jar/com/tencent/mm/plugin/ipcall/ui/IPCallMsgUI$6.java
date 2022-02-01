package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class IPCallMsgUI$6
  implements MenuItem.OnMenuItemClickListener
{
  IPCallMsgUI$6(IPCallMsgUI paramIPCallMsgUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(25810);
    this.JNI.finish();
    AppMethodBeat.o(25810);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMsgUI.6
 * JD-Core Version:    0.7.0.1
 */