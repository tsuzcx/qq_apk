package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;

final class MallIndexUI$11
  implements View.OnClickListener
{
  MallIndexUI$11(MallIndexUI paramMallIndexUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.mau;
    if (q.Gw()) {
      d.x(paramView, "wallet_payu", ".bind.ui.WalletPayUBankcardManageUI");
    }
    for (;;)
    {
      e.Jc(5);
      h.nFQ.f(14419, new Object[] { this.mau.dCX, Integer.valueOf(3) });
      c.BS().c(ac.a.uxq, ac.a.uxr);
      return;
      d.x(paramView, "wallet", ".bind.ui.WalletBankcardManageUI");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.11
 * JD-Core Version:    0.7.0.1
 */