package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

final class HoneyPayMainUI$6
  implements q.a
{
  HoneyPayMainUI$6(HoneyPayMainUI paramHoneyPayMainUI, cfh paramcfh) {}
  
  public final void dK(View paramView)
  {
    AppMethodBeat.i(64775);
    if (!bs.isNullOrNil(this.tED.FtM)) {
      e.n(this.tEA.getContext(), this.tED.FtM, true);
    }
    h.wUl.f(15191, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(64775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.6
 * JD-Core Version:    0.7.0.1
 */