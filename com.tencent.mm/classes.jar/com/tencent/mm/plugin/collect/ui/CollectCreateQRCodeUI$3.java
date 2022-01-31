package com.tencent.mm.plugin.collect.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.collect.b.m;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class CollectCreateQRCodeUI$3
  implements View.OnClickListener
{
  CollectCreateQRCodeUI$3(CollectCreateQRCodeUI paramCollectCreateQRCodeUI) {}
  
  public final void onClick(View paramView)
  {
    double d = bk.getDouble(CollectCreateQRCodeUI.a(this.iKI).getText(), 0.0D);
    g.DQ();
    int i = ((Integer)g.DP().Dz().get(ac.a.usE, Integer.valueOf(0))).intValue();
    y.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", new Object[] { Integer.valueOf(i) });
    if (!CollectCreateQRCodeUI.a(this.iKI).YL())
    {
      com.tencent.mm.ui.base.s.makeText(this.iKI.mController.uMN, a.i.wallet_balance_save_input_invalid, 0).show();
      return;
    }
    if (d < 0.01D)
    {
      com.tencent.mm.ui.base.s.makeText(this.iKI.mController.uMN, a.i.remittance_amount_lowest_limit, 0).show();
      return;
    }
    if (i == 8)
    {
      this.iKI.a(new m(Math.round(d * 100.0D), CollectCreateQRCodeUI.b(this.iKI), q.Gq()), true, false);
      return;
    }
    this.iKI.a(new com.tencent.mm.plugin.collect.b.s(d, "1", CollectCreateQRCodeUI.b(this.iKI)), true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI.3
 * JD-Core Version:    0.7.0.1
 */