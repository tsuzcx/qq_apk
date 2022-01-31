package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class IPCallMyGiftCardUI$2
  implements MenuItem.OnMenuItemClickListener
{
  IPCallMyGiftCardUI$2(IPCallMyGiftCardUI paramIPCallMyGiftCardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(22210);
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", this.nUb.getString(2131300844));
    paramMenuItem.putExtra("showShare", false);
    d.b(this.nUb, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(22210);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.2
 * JD-Core Version:    0.7.0.1
 */