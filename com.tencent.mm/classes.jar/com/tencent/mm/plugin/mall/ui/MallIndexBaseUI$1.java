package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.platformtools.ab;

final class MallIndexBaseUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexBaseUI$1(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(43165);
    paramMenuItem = new Intent();
    paramMenuItem.addFlags(67108864);
    paramMenuItem.putExtra("preferred_tab", 3);
    d.f(this.ozC, "com.tencent.mm.ui.LauncherUI", paramMenuItem);
    this.ozC.finish();
    if (!g.dpN())
    {
      h.qsU.e(14954, new Object[] { g.dpO(), "open_wcpay_specific_view:ok" });
      g.dpP();
    }
    h.qsU.e(14419, new Object[] { this.ozC.eAx, Integer.valueOf(6) });
    ab.i("MicroMsg.MallIndexBaseUI", "set BackBtn");
    AppMethodBeat.o(43165);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.1
 * JD-Core Version:    0.7.0.1
 */