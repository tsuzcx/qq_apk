package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$10
  implements n.d
{
  LuckyMoneyPrepareUI$10(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(142063);
    if (paramInt == 0)
    {
      paramMenuItem = new Intent();
      paramMenuItem.setClass(this.owL.getContext(), LuckyMoneyMyRecordUI.class);
      paramMenuItem.putExtra("key_type", 2);
      this.owL.startActivity(paramMenuItem);
      AppMethodBeat.o(142063);
      return;
    }
    if (paramInt == 1)
    {
      h.qsU.e(15511, new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.w(this.owL)), Integer.valueOf(1) });
      if (LuckyMoneyPrepareUI.w(this.owL) == 1)
      {
        e.m(this.owL.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
        AppMethodBeat.o(142063);
        return;
      }
      if (LuckyMoneyPrepareUI.e(this.owL) != null) {}
      for (paramMenuItem = LuckyMoneyPrepareUI.e(this.owL).onm;; paramMenuItem = "")
      {
        ab.i("MicroMsg.LuckyMoneyPrepareUI", "show qa foreign, config url: %s", new Object[] { paramMenuItem });
        if ((LuckyMoneyPrepareUI.e(this.owL) == null) || (bo.isNullOrNil(LuckyMoneyPrepareUI.e(this.owL).onm))) {
          break;
        }
        e.m(this.owL.getContext(), LuckyMoneyPrepareUI.e(this.owL).onm, false);
        AppMethodBeat.o(142063);
        return;
      }
      e.m(this.owL.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
    }
    AppMethodBeat.o(142063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */