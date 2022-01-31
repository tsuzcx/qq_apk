package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.o.a;
import com.tencent.mm.protocal.protobuf.bmg;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$6
  implements o.a
{
  HoneyPayMainUI$6(HoneyPayMainUI paramHoneyPayMainUI, bmg parambmg) {}
  
  public final void dj(View paramView)
  {
    AppMethodBeat.i(41886);
    if (!bo.isNullOrNil(this.nJh.xAK)) {
      e.m(this.nJe.getContext(), this.nJh.xAK, true);
    }
    h.qsU.e(15191, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(41886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.6
 * JD-Core Version:    0.7.0.1
 */