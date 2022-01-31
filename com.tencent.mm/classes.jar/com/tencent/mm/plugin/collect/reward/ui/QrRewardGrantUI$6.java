package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.e;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class QrRewardGrantUI$6
  implements a.a
{
  QrRewardGrantUI$6(QrRewardGrantUI paramQrRewardGrantUI, e parame) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41067);
    ab.e("MicroMsg.QrRewardGrantUI", "place order error: %s, %s", new Object[] { Integer.valueOf(this.kPp.kOJ.cnK), this.kPp.kOJ.kNv });
    if (!bo.isNullOrNil(this.kPp.kOJ.kNv)) {
      Toast.makeText(this.kPo, this.kPp.kOJ.kNv, 0).show();
    }
    if (QrRewardGrantUI.e(this.kPo)) {
      this.kPo.hideLoading();
    }
    AppMethodBeat.o(41067);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardGrantUI.6
 * JD-Core Version:    0.7.0.1
 */