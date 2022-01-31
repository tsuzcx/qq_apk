package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$6
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyPrepareUI$6(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(142059);
    if ((LuckyMoneyPrepareUI.e(this.owL) != null) && (!bo.isNullOrNil(LuckyMoneyPrepareUI.e(this.owL).onm))) {
      e.m(this.owL.getContext(), LuckyMoneyPrepareUI.e(this.owL).onm, false);
    }
    for (;;)
    {
      AppMethodBeat.o(142059);
      return true;
      e.m(this.owL.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */