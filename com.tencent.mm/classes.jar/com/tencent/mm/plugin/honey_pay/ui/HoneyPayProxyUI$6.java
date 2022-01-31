package com.tencent.mm.plugin.honey_pay.ui;

import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.n.a;

final class HoneyPayProxyUI$6
  implements n.a
{
  HoneyPayProxyUI$6(HoneyPayProxyUI paramHoneyPayProxyUI, com.tencent.mm.plugin.honey_pay.a.m paramm) {}
  
  public final void f(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i(this.llT.TAG, "state: %s", new Object[] { Integer.valueOf(this.llV.ljS.tei.state) });
    if (this.llV.ljS.tei.state == 1) {
      HoneyPayProxyUI.a(this.llT, this.llV.ljS);
    }
    for (;;)
    {
      this.llT.finish();
      return;
      HoneyPayProxyUI.b(this.llT, this.llV.ljS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.honey_pay.ui.HoneyPayProxyUI.6
 * JD-Core Version:    0.7.0.1
 */