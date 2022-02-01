package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;

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
    c.f(this.EQI, "com.tencent.mm.ui.LauncherUI", paramMenuItem);
    this.EQI.finish();
    if (!e.hod())
    {
      h.IzE.a(14954, new Object[] { e.hoe(), "open_wcpay_specific_view:ok" });
      e.hof();
    }
    h.IzE.a(14419, new Object[] { this.EQI.uuid, Integer.valueOf(6) });
    Log.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
    AppMethodBeat.o(66063);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.1
 * JD-Core Version:    0.7.0.1
 */