package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.view.View;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$8$1
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$8$1(WxaLuckyMoneyPrepareUI.8 param8) {}
  
  public final void run()
  {
    this.lMA.lMx.lMr.setVisibility(0);
    this.lMA.eYj.requestFocus();
    if (this.lMA.lMx.mKeyboard != null) {
      this.lMA.lMx.mKeyboard.setInputEditText(this.lMA.eYi);
    }
    WxaLuckyMoneyPrepareUI.b(this.lMA.lMx, this.lMA.eYk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.8.1
 * JD-Core Version:    0.7.0.1
 */