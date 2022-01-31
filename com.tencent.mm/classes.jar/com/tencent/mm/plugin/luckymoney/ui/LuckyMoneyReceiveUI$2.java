package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.p;

final class LuckyMoneyReceiveUI$2
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyReceiveUI$2(LuckyMoneyReceiveUI paramLuckyMoneyReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((LuckyMoneyReceiveUI.a(this.lXA) != null) && (LuckyMoneyReceiveUI.a(this.lXA).isShowing())) {
      LuckyMoneyReceiveUI.a(this.lXA).dismiss();
    }
    this.lXA.lUq.bfH();
    if ((LuckyMoneyReceiveUI.b(this.lXA).getVisibility() == 8) || (LuckyMoneyReceiveUI.c(this.lXA).getVisibility() == 4))
    {
      y.i("MicroMsg.LuckyMoneyReceiveUI", "user cancel & finish");
      this.lXA.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyReceiveUI.2
 * JD-Core Version:    0.7.0.1
 */