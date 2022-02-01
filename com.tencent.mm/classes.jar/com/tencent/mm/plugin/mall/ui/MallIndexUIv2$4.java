package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.abc.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.m;
import java.util.ArrayList;

final class MallIndexUIv2$4
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexUIv2$4(MallIndexUIv2 paramMallIndexUIv2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(196636);
    h.IzE.a(14872, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0) });
    h.IzE.a(16500, new Object[] { Integer.valueOf(3) });
    paramMenuItem = u.gJo().gJY();
    boolean bool;
    Object localObject;
    if ((paramMenuItem.OTR & 0x4000000) > 0)
    {
      bool = true;
      Log.i("MicroMsg.WalletSwitchConfig", "isSupportNewPayManage, ret = %s switchBit %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMenuItem.OTR) });
      if ((!bool) || (MallIndexUIv2.g(this.ERS).gaO == null) || (MallIndexUIv2.g(this.ERS).gaO.size() <= 0)) {
        break label214;
      }
      paramMenuItem = this.ERS;
      Log.i("MicorMsg.MallIndexUIv2", "openNewPayManageMenu");
      localObject = new m(paramMenuItem.getContext());
      ((m)localObject).ODT = new MallIndexUIv2.5(paramMenuItem);
      ((m)localObject).ODU = new MallIndexUIv2.6(paramMenuItem);
      ((m)localObject).hYu();
    }
    for (;;)
    {
      AppMethodBeat.o(196636);
      return true;
      bool = false;
      break;
      label214:
      paramMenuItem = this.ERS;
      bool = MallIndexUIv2.g(this.ERS).gas;
      localObject = new Intent();
      ((Intent)localObject).putExtra("key_default_show_currency", bool);
      c.b(paramMenuItem, "wallet", ".pwd.ui.WalletPasswordSettingUI", (Intent)localObject, 6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.4
 * JD-Core Version:    0.7.0.1
 */