package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.honey_pay.a.l;
import com.tencent.mm.protocal.c.apg;
import com.tencent.mm.protocal.c.bhg;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayProxyUI$3
  implements n.a
{
  HoneyPayProxyUI$3(HoneyPayProxyUI paramHoneyPayProxyUI, l paraml) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i(this.llT.TAG, "state: %s", new Object[] { Integer.valueOf(this.llU.ljR.sQe.state) });
    HoneyPayProxyUI.a(this.llT, this.llU.ljR);
    this.llT.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.3
 * JD-Core Version:    0.7.0.1
 */