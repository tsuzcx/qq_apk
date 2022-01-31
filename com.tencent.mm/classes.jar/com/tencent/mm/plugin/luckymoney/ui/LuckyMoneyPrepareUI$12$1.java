package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.e;

final class LuckyMoneyPrepareUI$12$1
  implements DialogInterface.OnClickListener
{
  LuckyMoneyPrepareUI$12$1(LuckyMoneyPrepareUI.12 param12, a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    y.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[] { this.lXh.iHx });
    e.l(this.lXi.lXg.mController.uMN, this.lXh.iHx, false);
    LuckyMoneyPrepareUI.a(this.lXi.lXg, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.12.1
 * JD-Core Version:    0.7.0.1
 */