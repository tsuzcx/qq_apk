package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class LuckyMoneyNewYearReceiveUI$5
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyNewYearReceiveUI$5(LuckyMoneyNewYearReceiveUI paramLuckyMoneyNewYearReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42788);
    if ((LuckyMoneyNewYearReceiveUI.f(this.ouD) != null) && (LuckyMoneyNewYearReceiveUI.f(this.ouD).isShowing())) {
      LuckyMoneyNewYearReceiveUI.f(this.ouD).dismiss();
    }
    this.ouD.orz.forceCancel();
    if ((LuckyMoneyNewYearReceiveUI.g(this.ouD).getVisibility() == 8) || (LuckyMoneyNewYearReceiveUI.h(this.ouD).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyNewYearReceiveUI", "usr cancel, & visibility not visiable, so finish");
      this.ouD.finish();
    }
    AppMethodBeat.o(42788);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNewYearReceiveUI.5
 * JD-Core Version:    0.7.0.1
 */