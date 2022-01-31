package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$3
  implements n.d
{
  LuckyMoneyPrepareUI$3(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt == 0)
    {
      paramMenuItem = new Intent();
      paramMenuItem.setClass(this.lXg.mController.uMN, LuckyMoneyMyRecordUI.class);
      paramMenuItem.putExtra("key_type", 2);
      this.lXg.startActivity(paramMenuItem);
    }
    while (paramInt != 1) {
      return;
    }
    h.nFQ.f(15511, new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.g(this.lXg)), Integer.valueOf(1) });
    if (LuckyMoneyPrepareUI.g(this.lXg) == 1)
    {
      e.l(this.lXg.mController.uMN, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
      return;
    }
    if (LuckyMoneyPrepareUI.d(this.lXg) != null) {}
    for (paramMenuItem = LuckyMoneyPrepareUI.d(this.lXg).lPP;; paramMenuItem = "")
    {
      y.i("MicroMsg.LuckyMoneyPrepareUI", "show qa foreign, config url: %s", new Object[] { paramMenuItem });
      if ((LuckyMoneyPrepareUI.d(this.lXg) == null) || (bk.bl(LuckyMoneyPrepareUI.d(this.lXg).lPP))) {
        break;
      }
      e.l(this.lXg.mController.uMN, LuckyMoneyPrepareUI.d(this.lXg).lPP, false);
      return;
    }
    e.l(this.lXg.mController.uMN, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */