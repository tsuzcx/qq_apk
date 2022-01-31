package com.tencent.mm.plugin.mall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.w;

final class MallIndexUI$13
  implements View.OnClickListener
{
  MallIndexUI$13(MallIndexUI paramMallIndexUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("key_from_scene", 1);
    d.b(this.mau.mController.uMN, "offline", ".ui.WalletOfflineEntranceUI", paramView);
    w.fT(9, 0);
    h.nFQ.f(11850, new Object[] { Integer.valueOf(5), Integer.valueOf(0) });
    h.nFQ.f(14419, new Object[] { this.mau.dCX, Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.13
 * JD-Core Version:    0.7.0.1
 */