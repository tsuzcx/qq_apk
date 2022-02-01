package com.tencent.mm.plugin.mall.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.wallet_core.ui.i;
import java.util.ArrayList;

final class MallIndexUIv2$8
  implements u.i
{
  MallIndexUIv2$8(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(262409);
    paramMenuItem = (t)MallIndexUIv2.k(this.KMs).get(paramMenuItem.getItemId());
    Log.i("MicorMsg.MallIndexUIv2", "selected pay manga label, jump type = " + paramMenuItem.jumpType);
    switch (paramMenuItem.jumpType)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(262409);
      return;
      if (!Util.isNullOrNil(paramMenuItem.jumpUrl))
      {
        i.o(this.KMs.getContext(), paramMenuItem.jumpUrl, false);
        AppMethodBeat.o(262409);
        return;
        if (!Util.isNullOrNil(paramMenuItem.username))
        {
          zp localzp = new zp();
          localzp.icM.userName = paramMenuItem.username;
          localzp.icM.icO = Util.nullAs(paramMenuItem.path, "");
          localzp.icM.scene = 1066;
          localzp.icM.icP = 0;
          localzp.publish();
          AppMethodBeat.o(262409);
          return;
          h.OAn.b(23388, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          c.g(this.KMs.getContext(), "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
          AppMethodBeat.o(262409);
          return;
          h.OAn.b(23388, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          c.ai(this.KMs.getContext(), "mall", ".ui.MallFunctionSettingsUI");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.8
 * JD-Core Version:    0.7.0.1
 */