package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$6
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyPrepareUI$6(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(65832);
    if ((LuckyMoneyPrepareUI.e(this.tpT) != null) && (!bt.isNullOrNil(LuckyMoneyPrepareUI.e(this.tpT).tdc))) {
      e.p(this.tpT.getContext(), LuckyMoneyPrepareUI.e(this.tpT).tdc, false);
    }
    for (;;)
    {
      AppMethodBeat.o(65832);
      return true;
      e.p(this.tpT.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */