package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.protocal.protobuf.avf;
import com.tencent.mm.protocal.protobuf.bpq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.p.a;

final class HoneyPayProxyUI$3
  implements p.a
{
  HoneyPayProxyUI$3(HoneyPayProxyUI paramHoneyPayProxyUI, l paraml) {}
  
  public final void d(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41926);
    if (this.nJq.nHn.wOz != null) {
      ab.i(this.nJp.TAG, "state: %s", new Object[] { Integer.valueOf(this.nJq.nHn.wOz.state) });
    }
    HoneyPayProxyUI.a(this.nJp, this.nJq.nHn);
    this.nJp.finish();
    AppMethodBeat.o(41926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.3
 * JD-Core Version:    0.7.0.1
 */