package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyPrepareUI$4
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyPrepareUI$4(LuckyMoneyPrepareUI paramLuckyMoneyPrepareUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(142058);
    if ((LuckyMoneyPrepareUI.r(this.owL) != null) && (LuckyMoneyPrepareUI.r(this.owL).isShowing())) {
      LuckyMoneyPrepareUI.r(this.owL).dismiss();
    }
    if ((LuckyMoneyPrepareUI.s(this.owL).getVisibility() == 8) || (LuckyMoneyPrepareUI.t(this.owL).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
      this.owL.finish();
    }
    this.owL.orz.forceCancel();
    AppMethodBeat.o(142058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyPrepareUI.4
 * JD-Core Version:    0.7.0.1
 */