package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;

final class MallIndexUIv2$6
  implements q.g
{
  MallIndexUIv2$6(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(274223);
    paramMenuItem = (t)MallIndexUIv2.g(this.ERS).gaO.get(paramMenuItem.getItemId());
    Log.i("MicorMsg.MallIndexUIv2", "selected pay manga label, jump type = " + paramMenuItem.jumpType);
    switch (paramMenuItem.jumpType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(274223);
      return;
      if (!Util.isNullOrNil(paramMenuItem.jumpUrl))
      {
        g.o(this.ERS.getContext(), paramMenuItem.jumpUrl, false);
        AppMethodBeat.o(274223);
        return;
        if (!Util.isNullOrNil(paramMenuItem.username))
        {
          xw localxw = new xw();
          localxw.fWN.userName = paramMenuItem.username;
          localxw.fWN.fWP = Util.nullAs(paramMenuItem.path, "");
          localxw.fWN.scene = 1066;
          localxw.fWN.fWQ = 0;
          EventCenter.instance.publish(localxw);
          AppMethodBeat.o(274223);
          return;
          h.IzE.a(23388, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          c.f(this.ERS.getContext(), "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(274223);
          return;
          h.IzE.a(23388, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          c.ad(this.ERS.getContext(), "mall", ".ui.MallFunctionSettingsUI");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.6
 * JD-Core Version:    0.7.0.1
 */