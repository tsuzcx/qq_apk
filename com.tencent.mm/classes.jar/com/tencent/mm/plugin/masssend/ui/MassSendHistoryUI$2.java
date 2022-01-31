package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.masssend.a;
import com.tencent.mm.pluginsdk.n;

final class MassSendHistoryUI$2
  implements MenuItem.OnMenuItemClickListener
{
  MassSendHistoryUI$2(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22795);
    if (MassSendHistoryUI.g(this.oCd)) {
      this.oCd.finish();
    }
    for (;;)
    {
      AppMethodBeat.o(22795);
      return true;
      paramMenuItem = new Intent();
      paramMenuItem.addFlags(67108864);
      a.gmO.p(paramMenuItem, this.oCd);
      this.oCd.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.2
 * JD-Core Version:    0.7.0.1
 */