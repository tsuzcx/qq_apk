package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPrepareUI$3
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyPrepareUI$3(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42943);
    ab.i("MicroMsg.LuckyMoneyPrepareUI", "coperationTipDialogNoTransparent onCancel()");
    LuckyMoneyPrepareUI.m(this.owL);
    LuckyMoneyPrepareUI.n(this.owL);
    if ((LuckyMoneyPrepareUI.o(this.owL) != null) && (LuckyMoneyPrepareUI.o(this.owL).isShowing())) {
      LuckyMoneyPrepareUI.o(this.owL).dismiss();
    }
    if ((LuckyMoneyPrepareUI.p(this.owL).getVisibility() == 8) || (LuckyMoneyPrepareUI.q(this.owL).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
      this.owL.finish();
    }
    this.owL.orz.forceCancel();
    AppMethodBeat.o(42943);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.3
 * JD-Core Version:    0.7.0.1
 */