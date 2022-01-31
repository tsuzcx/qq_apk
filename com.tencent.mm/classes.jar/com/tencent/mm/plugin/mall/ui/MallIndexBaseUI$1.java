package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.y;

final class MallIndexBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexBaseUI$1(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("preferred_tab", 3);
    d.e(this.lZE, "com.tencent.mm.ui.LauncherUI", paramMenuItem);
    this.lZE.finish();
    if (!f.cow())
    {
      h.nFQ.f(14954, new Object[] { f.cox(), "open_wcpay_specific_view:ok" });
      f.coy();
    }
    h.nFQ.f(14419, new Object[] { this.lZE.dCX, Integer.valueOf(6) });
    y.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.1
 * JD-Core Version:    0.7.0.1
 */