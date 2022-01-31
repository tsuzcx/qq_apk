package com.tencent.mm.plugin.honey_pay.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.e;
import com.tencent.mm.plugin.honey_pay.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.alj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayReceiveCardUI$7
  implements p.a
{
  HoneyPayReceiveCardUI$7(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI, e parame) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41939);
    if (this.nJG.nHf.wKi != null)
    {
      ab.i(this.nJF.TAG, "do real name");
      paramString = new Bundle();
      paramString.putString("realname_verify_process_jump_activity", ".ui.HoneyPayReceiveCardUI");
      c.a(this.nJF, paramString, this.nJG.nHf.wKi, false);
    }
    h.qsU.j(875L, 5L, 1L);
    AppMethodBeat.o(41939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.7
 * JD-Core Version:    0.7.0.1
 */