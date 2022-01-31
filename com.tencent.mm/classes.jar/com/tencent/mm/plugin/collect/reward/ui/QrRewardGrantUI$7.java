package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class QrRewardGrantUI$7
  implements a.a
{
  QrRewardGrantUI$7(QrRewardGrantUI paramQrRewardGrantUI, e parame) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41069);
    QrRewardGrantUI.a(this.kPo, this.kPp.kOJ.cwk);
    QrRewardGrantUI.b(this.kPo, this.kPp.kOJ.wIM);
    QrRewardGrantUI.c(this.kPo, this.kPp.kOJ.wpq);
    QrRewardGrantUI.d(this.kPo, this.kPp.kOJ.wIK);
    QrRewardGrantUI.e(this.kPo, this.kPp.kOJ.wIJ);
    ab.i("MicroMsg.QrRewardGrantUI", "remind str: %s", new Object[] { this.kPp.kOJ.wIV });
    if (!bo.isNullOrNil(this.kPp.kOJ.wIV))
    {
      h.d(this.kPo.getContext(), this.kPp.kOJ.wIV, "", this.kPo.getString(2131302540), this.kPo.getString(2131296888), new QrRewardGrantUI.7.1(this), new QrRewardGrantUI.7.2(this));
      AppMethodBeat.o(41069);
      return;
    }
    QrRewardGrantUI.f(this.kPo);
    AppMethodBeat.o(41069);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.7
 * JD-Core Version:    0.7.0.1
 */