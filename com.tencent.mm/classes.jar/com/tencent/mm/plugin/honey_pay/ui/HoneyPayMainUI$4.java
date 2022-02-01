package com.tencent.mm.plugin.honey_pay.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.s.a;
import com.tencent.mm.protocal.protobuf.edh;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

final class HoneyPayMainUI$4
  implements s.a
{
  HoneyPayMainUI$4(HoneyPayMainUI paramHoneyPayMainUI, edh paramedh) {}
  
  public final void eS(View paramView)
  {
    AppMethodBeat.i(64775);
    if (!Util.isNullOrNil(this.JCK.abiB)) {
      i.o(this.JCI.getContext(), this.JCK.abiB, true);
    }
    h.OAn.b(15191, new Object[] { Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(64775);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayMainUI.4
 * JD-Core Version:    0.7.0.1
 */