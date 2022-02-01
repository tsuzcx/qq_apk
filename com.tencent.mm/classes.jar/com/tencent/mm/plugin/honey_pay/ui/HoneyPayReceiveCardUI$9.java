package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.coo;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayReceiveCardUI$9
  implements q.a
{
  HoneyPayReceiveCardUI$9(HoneyPayReceiveCardUI paramHoneyPayReceiveCardUI, coo paramcoo) {}
  
  public final void dN(View paramView)
  {
    AppMethodBeat.i(64830);
    if (!bt.isNullOrNil(this.uHL.HdR)) {
      e.o(this.uHJ.getContext(), this.uHL.HdR, false);
    }
    g.yhR.f(15191, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(64830);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayReceiveCardUI.9
 * JD-Core Version:    0.7.0.1
 */