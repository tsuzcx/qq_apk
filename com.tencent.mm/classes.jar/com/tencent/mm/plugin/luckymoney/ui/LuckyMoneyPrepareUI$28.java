package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.f2f.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.u;

final class LuckyMoneyPrepareUI$28
  extends u
{
  LuckyMoneyPrepareUI$28(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void aEI()
  {
    h.nFQ.f(11701, new Object[] { Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(LuckyMoneyPrepareUI.f(this.lXg)), Integer.valueOf(4) });
    h.nFQ.f(15511, new Object[] { Integer.valueOf(LuckyMoneyPrepareUI.g(this.lXg)), Integer.valueOf(2) });
    if (LuckyMoneyPrepareUI.b(this.lXg).bfp() != 0)
    {
      com.tencent.mm.ui.base.s.makeText(this.lXg.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
      return;
    }
    int i = LuckyMoneyPrepareUI.a(this.lXg).getInput();
    double d = LuckyMoneyPrepareUI.b(this.lXg).getInput();
    long l2 = 0L;
    long l1;
    if (LuckyMoneyPrepareUI.c(this.lXg) == 1)
    {
      l1 = com.tencent.mm.wallet_core.ui.e.C(d);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(356354, Integer.valueOf(i));
      str = LuckyMoneyPrepareUI.h(this.lXg).getInput();
      localObject = str;
      if (bk.bl(str)) {
        if (!bk.bl(LuckyMoneyPrepareUI.i(this.lXg))) {
          break label340;
        }
      }
    }
    label340:
    for (Object localObject = this.lXg.getString(a.i.lucky_money_default_wish);; localObject = LuckyMoneyPrepareUI.i(this.lXg))
    {
      this.lXg.VH();
      if (LuckyMoneyPrepareUI.j(this.lXg) != 2) {
        break label352;
      }
      localObject = new d(i, (int)l1, LuckyMoneyPrepareUI.c(this.lXg), (int)l2);
      this.lXg.b((m)localObject, false);
      if (LuckyMoneyPrepareUI.m(this.lXg) == null) {
        break label651;
      }
      LuckyMoneyPrepareUI.m(this.lXg).show();
      return;
      l1 = com.tencent.mm.wallet_core.ui.e.C(i * d);
      l2 = com.tencent.mm.wallet_core.ui.e.C(d);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(356353, Integer.valueOf(i));
      break;
    }
    label352:
    String str = this.lXg.getIntent().getStringExtra("key_username");
    if (LuckyMoneyPrepareUI.g(this.lXg) == 1)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
      if ((LuckyMoneyPrepareUI.k(this.lXg)) && (!bk.bl(str))) {}
      for (localObject = new ae(i, l1, l2, LuckyMoneyPrepareUI.c(this.lXg), (String)localObject, o.bfL(), str, o.gU(str), q.Gj(), q.Gl(), LuckyMoneyPrepareUI.l(this.lXg));; localObject = new ae(i, l1, l2, LuckyMoneyPrepareUI.c(this.lXg), (String)localObject, o.bfL(), null, null, q.Gj(), q.Gl(), LuckyMoneyPrepareUI.l(this.lXg)))
      {
        this.lXg.b((m)localObject, false);
        break;
      }
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + LuckyMoneyPrepareUI.g(this.lXg));
    this.lXg.kh(1645);
    if ((LuckyMoneyPrepareUI.k(this.lXg)) && (!bk.bl(str))) {}
    for (localObject = new com.tencent.mm.plugin.luckymoney.b.y(i, l1, l2, LuckyMoneyPrepareUI.c(this.lXg), (String)localObject, str, o.bfL(), q.Gj(), LuckyMoneyPrepareUI.g(this.lXg));; localObject = new com.tencent.mm.plugin.luckymoney.b.y(i, l1, l2, LuckyMoneyPrepareUI.c(this.lXg), (String)localObject, null, o.bfL(), q.Gj(), LuckyMoneyPrepareUI.g(this.lXg)))
    {
      this.lXg.b((m)localObject, false);
      break;
    }
    label651:
    LuckyMoneyPrepareUI.a(this.lXg, com.tencent.mm.wallet_core.ui.g.a(this.lXg.mController.uMN, true, new LuckyMoneyPrepareUI.28.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.28
 * JD-Core Version:    0.7.0.1
 */