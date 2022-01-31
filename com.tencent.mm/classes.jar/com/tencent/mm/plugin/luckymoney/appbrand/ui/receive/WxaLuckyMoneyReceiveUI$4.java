package com.tencent.mm.plugin.luckymoney.appbrand.ui.receive;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class WxaLuckyMoneyReceiveUI$4
  implements DialogInterface.OnCancelListener
{
  WxaLuckyMoneyReceiveUI$4(WxaLuckyMoneyReceiveUI paramWxaLuckyMoneyReceiveUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.lMS.bfo();
    if ((WxaLuckyMoneyReceiveUI.e(this.lMS).getVisibility() == 8) || (WxaLuckyMoneyReceiveUI.f(this.lMS).getVisibility() == 4))
    {
      y.i("MicroMsg.WxaLuckyMoneyReceiveUI", "user cancel & finish");
      WxaLuckyMoneyReceiveUI.d(this.lMS);
      this.lMS.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.receive.WxaLuckyMoneyReceiveUI.4
 * JD-Core Version:    0.7.0.1
 */