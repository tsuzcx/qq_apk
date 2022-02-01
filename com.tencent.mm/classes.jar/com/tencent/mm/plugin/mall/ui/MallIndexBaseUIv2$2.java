package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.Log;

final class MallIndexBaseUIv2$2
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexBaseUIv2$2(MallIndexBaseUIv2 paramMallIndexBaseUIv2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(206536);
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("preferred_tab", 3);
    c.f(this.EQO, "com.tencent.mm.ui.LauncherUI", paramMenuItem);
    this.EQO.finish();
    if (!e.hod())
    {
      h.IzE.a(14954, new Object[] { e.hoe(), "open_wcpay_specific_view:ok" });
      e.hof();
    }
    h.IzE.a(14419, new Object[] { this.EQO.uuid, Integer.valueOf(6) });
    Log.i("MicorMsg.MallIndexBaseUIv2", "set BackBtn");
    AppMethodBeat.o(206536);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUIv2.2
 * JD-Core Version:    0.7.0.1
 */