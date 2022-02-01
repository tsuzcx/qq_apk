package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.ad;

final class MallIndexBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexBaseUI$1(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(66063);
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("preferred_tab", 3);
    d.e(this.tuc, "com.tencent.mm.ui.LauncherUI", paramMenuItem);
    this.tuc.finish();
    if (!e.eBc())
    {
      h.vKh.f(14954, new Object[] { e.eBd(), "open_wcpay_specific_view:ok" });
      e.eBe();
    }
    h.vKh.f(14419, new Object[] { this.tuc.uuid, Integer.valueOf(6) });
    ad.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
    AppMethodBeat.o(66063);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.1
 * JD-Core Version:    0.7.0.1
 */