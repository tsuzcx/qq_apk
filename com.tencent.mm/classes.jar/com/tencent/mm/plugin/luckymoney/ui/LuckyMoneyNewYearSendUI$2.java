package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyNewYearSendUI$2
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyNewYearSendUI$2(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((LuckyMoneyNewYearSendUI.k(this.lWH) != null) && (LuckyMoneyNewYearSendUI.k(this.lWH).isShowing())) {
      LuckyMoneyNewYearSendUI.k(this.lWH).hide();
    }
    if ((LuckyMoneyNewYearSendUI.q(this.lWH).getVisibility() == 8) || (LuckyMoneyNewYearSendUI.r(this.lWH).getVisibility() == 4))
    {
      y.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
      this.lWH.finish();
    }
    this.lWH.lUq.bfH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.2
 * JD-Core Version:    0.7.0.1
 */