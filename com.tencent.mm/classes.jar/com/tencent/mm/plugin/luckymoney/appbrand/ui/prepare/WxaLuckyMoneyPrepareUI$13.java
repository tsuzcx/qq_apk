package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.e;

final class WxaLuckyMoneyPrepareUI$13
  implements MenuItem.OnMenuItemClickListener
{
  WxaLuckyMoneyPrepareUI$13(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(42068);
    e.m(this.ojQ.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
    AppMethodBeat.o(42068);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.13
 * JD-Core Version:    0.7.0.1
 */