package com.tencent.mm.plugin.collect.reward.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ab;

final class QrRewardMainUI$16
  implements a.a
{
  QrRewardMainUI$16(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41100);
    QrRewardMainUI.a(this.kPN, this.kPS.kOF.jVh);
    QrRewardMainUI.a(this.kPN, this.kPS.kOF.wIB);
    QrRewardMainUI.b(this.kPN, this.kPS.kOF.wIx);
    QrRewardMainUI.b(this.kPN, this.kPS.kOF.desc);
    QrRewardMainUI.c(this.kPN, this.kPS.kOF.ueu);
    paramm = this.kPN;
    boolean bool;
    if (!this.kPS.kOF.wIv)
    {
      bool = true;
      QrRewardMainUI.c(paramm, bool);
      QrRewardMainUI.d(this.kPN, this.kPS.kOF.knU);
      QrRewardMainUI.e(this.kPN, this.kPS.kOF.wIz);
      QrRewardMainUI.h(this.kPN);
      QrRewardMainUI.i(this.kPN);
      if (QrRewardMainUI.j(this.kPN)) {
        break label242;
      }
      QrRewardMainUI.k(this.kPN);
    }
    for (;;)
    {
      QrRewardMainUI.f(this.kPN, this.kPS.kOF.qiN);
      QrRewardMainUI.bif();
      ab.d("MicroMsg.QrRewardMainUI", "url: %s", new Object[] { QrRewardMainUI.n(this.kPN) });
      AppMethodBeat.o(41100);
      return;
      bool = false;
      break;
      label242:
      QrRewardMainUI.a(this.kPN, this.kPS.kOF.qiN, this.kPS.kOF.wIw);
      QrRewardMainUI.l(this.kPN);
      QrRewardMainUI.m(this.kPN);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.16
 * JD-Core Version:    0.7.0.1
 */