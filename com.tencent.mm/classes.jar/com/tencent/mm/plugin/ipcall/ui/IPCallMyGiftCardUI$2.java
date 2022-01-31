package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;

final class IPCallMyGiftCardUI$2
  implements MenuItem.OnMenuItemClickListener
{
  IPCallMyGiftCardUI$2(IPCallMyGiftCardUI paramIPCallMyGiftCardUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", this.lwO.getString(R.l.ip_call_exchange_coupon_url));
    paramMenuItem.putExtra("showShare", false);
    d.b(this.lwO, "webview", ".ui.tools.WebViewUI", paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI.2
 * JD-Core Version:    0.7.0.1
 */