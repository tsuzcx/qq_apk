package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.protocal.c.nn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class QrRewardSelectMoneyUI$5
  implements a.a
{
  QrRewardSelectMoneyUI$5(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, f paramf) {}
  
  public final void i(m paramm)
  {
    y.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
    QrRewardSelectMoneyUI.a(this.iJz, this.iJA.iIf.sKY);
    QrRewardSelectMoneyUI.b(this.iJz, this.iJA.iIf.nyK);
    QrRewardSelectMoneyUI.a(this.iJz, this.iJA.iIf.sKK);
    QrRewardSelectMoneyUI.c(this.iJz, this.iJA.iIf.sKV);
    QrRewardSelectMoneyUI.d(this.iJz, this.iJA.iIf.desc);
    QrRewardSelectMoneyUI.e(this.iJz, this.iJA.iIf.sLe);
    QrRewardSelectMoneyUI.f(this.iJz, this.iJA.iIf.sLf);
    QrRewardSelectMoneyUI.g(this.iJz, this.iJA.iIf.sLb);
    QrRewardSelectMoneyUI.h(this.iJz, this.iJA.iIf.sLi);
    QrRewardSelectMoneyUI.a(this.iJz, this.iJA.iIf.sKI);
    if (QrRewardSelectMoneyUI.a(this.iJz) == null)
    {
      y.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
      QrRewardSelectMoneyUI.a(this.iJz, new LinkedList());
    }
    QrRewardSelectMoneyUI.b(this.iJz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.5
 * JD-Core Version:    0.7.0.1
 */