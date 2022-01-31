package com.tencent.mm.plugin.collect.reward.ui;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.collect.reward.a.a.a;
import com.tencent.mm.plugin.collect.reward.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.a;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.qc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class QrRewardMainUI$15
  implements a.a
{
  QrRewardMainUI$15(QrRewardMainUI paramQrRewardMainUI, b paramb) {}
  
  public final void h(m paramm)
  {
    boolean bool = true;
    AppMethodBeat.i(41099);
    ab.e("MicroMsg.QrRewardMainUI", "get code error: %s, %s", new Object[] { Integer.valueOf(this.kPS.kOF.cnK), this.kPS.kOF.kNv });
    if (this.kPS.kOF.cnK == 416)
    {
      if (this.kPS.kOF.wIk == null) {}
      for (;;)
      {
        ab.d("MicroMsg.QrRewardMainUI", "realNameInfo:%s", new Object[] { Boolean.valueOf(bool) });
        QrRewardMainUI.g(this.kPN).setVisibility(4);
        paramm = new Bundle();
        paramm.putString("realname_verify_process_jump_activity", ".reward.ui.CollectMainUI");
        paramm.putString("realname_verify_process_jump_plugin", "collect");
        QrRewardMainUI localQrRewardMainUI = this.kPN;
        int i = this.kPS.kOF.cnK;
        bry localbry = this.kPS.kOF.wIk;
        new QrRewardMainUI.15.1(this);
        a.a(localQrRewardMainUI, i, localbry, paramm, 1011);
        AppMethodBeat.o(41099);
        return;
        bool = false;
      }
    }
    if (!bo.isNullOrNil(this.kPS.kOF.kNv)) {
      Toast.makeText(this.kPN, this.kPS.kOF.kNv, 0).show();
    }
    if (!this.kPS.kOG) {
      QrRewardMainUI.b(this.kPN, false);
    }
    AppMethodBeat.o(41099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.reward.ui.QrRewardMainUI.15
 * JD-Core Version:    0.7.0.1
 */