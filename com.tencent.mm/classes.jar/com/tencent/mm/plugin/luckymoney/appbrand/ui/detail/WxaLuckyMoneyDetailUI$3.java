package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WxaLuckyMoneyDetailUI$3
  implements DialogInterface.OnCancelListener
{
  WxaLuckyMoneyDetailUI$3(WxaLuckyMoneyDetailUI paramWxaLuckyMoneyDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(42026);
    this.ojy.bMO();
    if ((WxaLuckyMoneyDetailUI.d(this.ojy).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(this.ojy).getVisibility() == 4))
    {
      ab.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
      this.ojy.e(-1, null);
    }
    AppMethodBeat.o(42026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.3
 * JD-Core Version:    0.7.0.1
 */