package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cvp;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import java.util.LinkedList;

final class MallIndexOSUI$5
  implements MenuItem.OnMenuItemClickListener
{
  MallIndexOSUI$5(MallIndexOSUI paramMallIndexOSUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(43186);
    final cvo localcvo = MallIndexOSUI.f(this.ozV).ulB;
    final boolean bool = MallIndexOSUI.f(this.ozV).ulC;
    if (bool)
    {
      paramMenuItem = new String[localcvo.wZn.size() + 1];
      paramMenuItem[localcvo.wZn.size()] = this.ozV.getString(2131305124);
    }
    for (;;)
    {
      int i = 0;
      while (i < localcvo.wZn.size())
      {
        paramMenuItem[i] = aa.a(((cvp)localcvo.wZn.get(i)).ydO);
        i += 1;
      }
      paramMenuItem = new String[localcvo.wZn.size()];
    }
    h.a(this.ozV.getContext(), null, paramMenuItem, null, false, new h.c()
    {
      public final void iA(int paramAnonymousInt)
      {
        AppMethodBeat.i(43185);
        if (paramAnonymousInt < localcvo.wZn.size())
        {
          Intent localIntent = new Intent();
          localIntent.putExtra("rawUrl", aa.a(((cvp)localcvo.wZn.get(paramAnonymousInt)).ydY));
          d.b(MallIndexOSUI.5.this.ozV, "webview", ".ui.tools.WebViewUI", localIntent);
          AppMethodBeat.o(43185);
          return;
        }
        if (bool) {
          d.c(MallIndexOSUI.5.this.ozV, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 1);
        }
        AppMethodBeat.o(43185);
      }
    });
    AppMethodBeat.o(43186);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexOSUI.5
 * JD-Core Version:    0.7.0.1
 */