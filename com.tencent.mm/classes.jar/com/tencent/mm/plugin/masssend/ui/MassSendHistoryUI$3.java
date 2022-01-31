package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.n;

final class MassSendHistoryUI$3
  implements MenuItem.OnMenuItemClickListener
{
  MassSendHistoryUI$3(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22796);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Contact_User", "masssendapp");
    a.gmO.c(paramMenuItem, this.oCd);
    AppMethodBeat.o(22796);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.3
 * JD-Core Version:    0.7.0.1
 */