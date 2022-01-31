package com.tencent.mm.plugin.luckymoney.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.p;

final class LuckyMoneyNotHookReceiveUI$8
  implements DialogInterface.OnCancelListener
{
  LuckyMoneyNotHookReceiveUI$8(LuckyMoneyNotHookReceiveUI paramLuckyMoneyNotHookReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42855);
    if ((LuckyMoneyNotHookReceiveUI.e(this.ovv) != null) && (LuckyMoneyNotHookReceiveUI.e(this.ovv).isShowing())) {
      LuckyMoneyNotHookReceiveUI.e(this.ovv).dismiss();
    }
    this.ovv.orz.forceCancel();
    if ((LuckyMoneyNotHookReceiveUI.f(this.ovv).getVisibility() == 8) || (LuckyMoneyNotHookReceiveUI.g(this.ovv).getVisibility() == 4))
    {
      ab.i("MicroMsg.LuckyMoneyNotHookReceiveUI", "user cancel & finish");
      this.ovv.finish();
    }
    AppMethodBeat.o(42855);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNotHookReceiveUI.8
 * JD-Core Version:    0.7.0.1
 */