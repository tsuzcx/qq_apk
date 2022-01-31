package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class QrRewardSelectMoneyUI$5
  implements a.a
{
  QrRewardSelectMoneyUI$5(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, f paramf) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41136);
    ab.d("MicroMsg.QrRewardSelectMoneyUI", "callback succ");
    QrRewardSelectMoneyUI.a(this.kQf, this.kQg.kOK.wIN);
    QrRewardSelectMoneyUI.b(this.kQf, this.kQg.kOK.qjK);
    QrRewardSelectMoneyUI.a(this.kQf, this.kQg.kOK.wIA);
    QrRewardSelectMoneyUI.c(this.kQf, this.kQg.kOK.wIK);
    QrRewardSelectMoneyUI.d(this.kQf, this.kQg.kOK.desc);
    QrRewardSelectMoneyUI.e(this.kQf, this.kQg.kOK.wIS);
    QrRewardSelectMoneyUI.f(this.kQf, this.kQg.kOK.wIT);
    QrRewardSelectMoneyUI.g(this.kQf, this.kQg.kOK.wIQ);
    QrRewardSelectMoneyUI.h(this.kQf, this.kQg.kOK.wIW);
    QrRewardSelectMoneyUI.a(this.kQf, this.kQg.kOK.wIy);
    if (QrRewardSelectMoneyUI.a(this.kQf) == null)
    {
      ab.i("MicroMsg.QrRewardSelectMoneyUI", "amt_list is null");
      QrRewardSelectMoneyUI.a(this.kQf, new LinkedList());
    }
    QrRewardSelectMoneyUI.b(this.kQf);
    AppMethodBeat.o(41136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.5
 * JD-Core Version:    0.7.0.1
 */