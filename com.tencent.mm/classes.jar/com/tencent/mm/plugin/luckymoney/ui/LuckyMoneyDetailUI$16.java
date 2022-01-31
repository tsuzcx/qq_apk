package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyDetailUI$16
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyDetailUI$16(LuckyMoneyDetailUI paramLuckyMoneyDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42665);
    if ((LuckyMoneyDetailUI.F(this.otz) != null) && (LuckyMoneyDetailUI.F(this.otz).isShowing())) {
      LuckyMoneyDetailUI.F(this.otz).dismiss();
    }
    this.otz.orz.forceCancel();
    if ((LuckyMoneyDetailUI.G(this.otz).getVisibility() == 8) || (LuckyMoneyDetailUI.H(this.otz).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyDetailUI", "user cancel & finish");
      this.otz.finish();
    }
    AppMethodBeat.o(42665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.16
 * JD-Core Version:    0.7.0.1
 */