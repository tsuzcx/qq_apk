package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.plugin.luckymoney.b.j;
import com.tencent.mm.sdk.platformtools.y;

final class LuckyMoneyPrepareUI$28$1
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyPrepareUI$28$1(LuckyMoneyPrepareUI.28 param28) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((LuckyMoneyPrepareUI.m(this.lXo.lXg) != null) && (LuckyMoneyPrepareUI.m(this.lXo.lXg).isShowing())) {
      LuckyMoneyPrepareUI.m(this.lXo.lXg).dismiss();
    }
    if ((LuckyMoneyPrepareUI.n(this.lXo.lXg).getVisibility() == 8) || (LuckyMoneyPrepareUI.o(this.lXo.lXg).getVisibility() == 4))
    {
      y.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
      this.lXo.lXg.finish();
    }
    this.lXo.lXg.lUq.bfH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.28.1
 * JD-Core Version:    0.7.0.1
 */