package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.model.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.a;

final class MallIndexBaseUI$4
  implements h.d
{
  MallIndexBaseUI$4(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void bF(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return;
    case 0: 
      com.tencent.mm.plugin.report.service.h.nFQ.f(11458, new Object[] { Integer.valueOf(2) });
      if (q.Gw())
      {
        a.b(this.lZE.mController.uMN, "PayURemittanceProcess", null);
        return;
      }
      a.b(this.lZE.mController.uMN, "RemittanceProcess", null);
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(11458, new Object[] { Integer.valueOf(3) });
    com.tencent.mm.pluginsdk.wallet.h.X(this.lZE, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.4
 * JD-Core Version:    0.7.0.1
 */