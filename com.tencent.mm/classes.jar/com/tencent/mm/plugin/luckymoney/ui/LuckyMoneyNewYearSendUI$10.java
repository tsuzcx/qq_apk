package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyNewYearSendUI$10
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyNewYearSendUI$10(LuckyMoneyNewYearSendUI paramLuckyMoneyNewYearSendUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42818);
    if ((LuckyMoneyNewYearSendUI.o(this.ovl) != null) && (LuckyMoneyNewYearSendUI.o(this.ovl).isShowing())) {
      LuckyMoneyNewYearSendUI.o(this.ovl).dismiss();
    }
    if ((LuckyMoneyNewYearSendUI.p(this.ovl).getVisibility() == 8) || (LuckyMoneyNewYearSendUI.q(this.ovl).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyNewYearSendUI", "usr cancel, & visibility not visiable, so finish");
      this.ovl.finish();
    }
    this.ovl.orz.forceCancel();
    AppMethodBeat.o(42818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearSendUI.10
 * JD-Core Version:    0.7.0.1
 */