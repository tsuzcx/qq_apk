package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.bps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayProxyUI$6
  implements p.a
{
  HoneyPayProxyUI$6(HoneyPayProxyUI paramHoneyPayProxyUI, com.tencent.mm.plugin.honey_pay.a.m paramm) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41928);
    ab.i(this.nJp.TAG, "state: %s", new Object[] { Integer.valueOf(this.nJr.nHo.xci.state) });
    if (this.nJr.nHo.xci.state == 1) {
      HoneyPayProxyUI.a(this.nJp, this.nJr.nHo);
    }
    for (;;)
    {
      this.nJp.finish();
      AppMethodBeat.o(41928);
      return;
      HoneyPayProxyUI.b(this.nJp, this.nJr.nHo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.6
 * JD-Core Version:    0.7.0.1
 */