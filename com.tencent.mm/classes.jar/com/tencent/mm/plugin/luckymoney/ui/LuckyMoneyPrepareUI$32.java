package com.tencent.mm.plugin.luckymoney.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$32
  implements MenuItem.OnMenuItemClickListener
{
  LuckyMoneyPrepareUI$32(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if ((LuckyMoneyPrepareUI.d(this.lXg) != null) && (!bk.bl(LuckyMoneyPrepareUI.d(this.lXg).lPP))) {
      e.l(this.lXg.mController.uMN, LuckyMoneyPrepareUI.d(this.lXg).lPP, false);
    }
    for (;;)
    {
      return true;
      e.l(this.lXg.mController.uMN, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.32
 * JD-Core Version:    0.7.0.1
 */