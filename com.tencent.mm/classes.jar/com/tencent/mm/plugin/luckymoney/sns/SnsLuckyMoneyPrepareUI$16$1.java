package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.sdk.platformtools.ab;

final class SnsLuckyMoneyPrepareUI$16$1
  implements DialogInterface.OnCancelListener
{
  SnsLuckyMoneyPrepareUI$16$1(SnsLuckyMoneyPrepareUI.16 param16) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42525);
    if ((this.oqR.oqN.gKM != null) && (this.oqR.oqN.gKM.isShowing())) {
      this.oqR.oqN.gKM.hide();
    }
    if ((SnsLuckyMoneyPrepareUI.g(this.oqR.oqN).getVisibility() == 8) || (SnsLuckyMoneyPrepareUI.h(this.oqR.oqN).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
      this.oqR.oqN.finish();
    }
    this.oqR.oqN.orz.forceCancel();
    AppMethodBeat.o(42525);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.16.1
 * JD-Core Version:    0.7.0.1
 */