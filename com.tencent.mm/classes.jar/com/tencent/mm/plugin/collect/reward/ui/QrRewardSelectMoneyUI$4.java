package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.f;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class QrRewardSelectMoneyUI$4
  implements a.a
{
  QrRewardSelectMoneyUI$4(QrRewardSelectMoneyUI paramQrRewardSelectMoneyUI, f paramf) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41135);
    ab.e("MicroMsg.QrRewardSelectMoneyUI", "scan response error");
    if (!bo.isNullOrNil(this.kQg.kOK.kNv)) {
      Toast.makeText(this.kQf, this.kQg.kOK.kNv, 1).show();
    }
    this.kQf.finish();
    AppMethodBeat.o(41135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSelectMoneyUI.4
 * JD-Core Version:    0.7.0.1
 */