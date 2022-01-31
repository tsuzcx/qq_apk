package com.tencent.mm.plugin.collect.reward.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.g;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class QrRewardSetMoneyUI$3
  implements a.a
{
  QrRewardSetMoneyUI$3(QrRewardSetMoneyUI paramQrRewardSetMoneyUI, g paramg) {}
  
  public final void h(m paramm)
  {
    AppMethodBeat.i(41151);
    ab.e("MicroMsg.QrRewardSetMoneyUI", "set code error: %s, %s", new Object[] { Integer.valueOf(this.kQv.kOL.cnK), this.kQv.kOL.kNv });
    if (!bo.isNullOrNil(this.kQv.kOL.kNv))
    {
      Toast.makeText(this.kQu, this.kQv.kOL.kNv, 1).show();
      AppMethodBeat.o(41151);
      return;
    }
    Toast.makeText(this.kQu, 2131302227, 1).show();
    AppMethodBeat.o(41151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardSetMoneyUI.3
 * JD-Core Version:    0.7.0.1
 */