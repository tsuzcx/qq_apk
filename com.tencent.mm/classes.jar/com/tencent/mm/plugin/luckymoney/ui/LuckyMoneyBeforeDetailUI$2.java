package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;

final class LuckyMoneyBeforeDetailUI$2
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyBeforeDetailUI$2(LuckyMoneyBeforeDetailUI paramLuckyMoneyBeforeDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42577);
    if ((LuckyMoneyBeforeDetailUI.a(this.orA) != null) && (LuckyMoneyBeforeDetailUI.a(this.orA).isShowing())) {
      LuckyMoneyBeforeDetailUI.a(this.orA).dismiss();
    }
    this.orA.orz.forceCancel();
    if ((LuckyMoneyBeforeDetailUI.b(this.orA).getVisibility() == 8) || (LuckyMoneyBeforeDetailUI.c(this.orA).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
      this.orA.finish();
    }
    AppMethodBeat.o(42577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI.2
 * JD-Core Version:    0.7.0.1
 */