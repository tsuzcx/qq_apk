package com.tencent.mm.plugin.luckymoney.appbrand.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.mm.sdk.platformtools.y;

final class WxaLuckyMoneyDetailUI$3
  implements DialogInterface.OnCancelListener
{
  WxaLuckyMoneyDetailUI$3(WxaLuckyMoneyDetailUI paramWxaLuckyMoneyDetailUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.lMe.bfo();
    if ((WxaLuckyMoneyDetailUI.d(this.lMe).getVisibility() == 8) || (WxaLuckyMoneyDetailUI.e(this.lMe).getVisibility() == 4))
    {
      y.i("MicroMsg.WxaLuckyMoneyDetailUI", "user cancel & finish");
      this.lMe.b(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.detail.WxaLuckyMoneyDetailUI.3
 * JD-Core Version:    0.7.0.1
 */