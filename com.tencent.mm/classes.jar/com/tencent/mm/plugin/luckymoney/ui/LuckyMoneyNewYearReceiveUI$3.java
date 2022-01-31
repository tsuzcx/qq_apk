package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class LuckyMoneyNewYearReceiveUI$3
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyNewYearReceiveUI$3(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((LuckyMoneyNewYearReceiveUI.b(this.lWq) != null) && (LuckyMoneyNewYearReceiveUI.b(this.lWq).isShowing())) {
      LuckyMoneyNewYearReceiveUI.b(this.lWq).dismiss();
    }
    this.lWq.lUq.bfH();
    if ((LuckyMoneyNewYearReceiveUI.c(this.lWq).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.d(this.lWq).getVisibility() == 4))
    {
      y.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
      this.lWq.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.3
 * JD-Core Version:    0.7.0.1
 */