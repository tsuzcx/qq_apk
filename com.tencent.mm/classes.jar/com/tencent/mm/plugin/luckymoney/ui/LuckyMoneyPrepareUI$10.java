package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$10
  implements n.d
{
  LuckyMoneyPrepareUI$10(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(65836);
    if (paramInt == 0)
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClass(this.tpT.getContext(), LuckyMoneyMyRecordUI.class);
      ((Intent)localObject).putExtra("key_type", 2);
      paramMenuItem = this.tpT;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$18", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramMenuItem, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyPrepareUI$18", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(65836);
      return;
    }
    if (paramInt == 1)
    {
      h.vKh.f(15511, new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.y(this.tpT)), Integer.valueOf(1) });
      if (LuckyMoneyPrepareUI.y(this.tpT) == 1)
      {
        e.p(this.tpT.getContext(), "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
        AppMethodBeat.o(65836);
        return;
      }
      if (LuckyMoneyPrepareUI.e(this.tpT) != null) {}
      for (paramMenuItem = LuckyMoneyPrepareUI.e(this.tpT).tdc;; paramMenuItem = "")
      {
        ad.i("MicroMsg.LuckyMoneyPrepareUI", "show qa foreign, config url: %s", new Object[] { paramMenuItem });
        if ((LuckyMoneyPrepareUI.e(this.tpT) == null) || (bt.isNullOrNil(LuckyMoneyPrepareUI.e(this.tpT).tdc))) {
          break;
        }
        e.p(this.tpT.getContext(), LuckyMoneyPrepareUI.e(this.tpT).tdc, false);
        AppMethodBeat.o(65836);
        return;
      }
      e.p(this.tpT.getContext(), "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
    }
    AppMethodBeat.o(65836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.10
 * JD-Core Version:    0.7.0.1
 */