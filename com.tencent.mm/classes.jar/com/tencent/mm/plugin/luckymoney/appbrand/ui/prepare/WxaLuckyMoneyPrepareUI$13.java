package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.f;

final class WxaLuckyMoneyPrepareUI$13
  implements MenuItem.OnMenuItemClickListener
{
  WxaLuckyMoneyPrepareUI$13(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(64959);
    f.p(this.yQV.getContext(), WxaLuckyMoneyPrepareUI.boU(), false);
    AppMethodBeat.o(64959);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.13
 * JD-Core Version:    0.7.0.1
 */