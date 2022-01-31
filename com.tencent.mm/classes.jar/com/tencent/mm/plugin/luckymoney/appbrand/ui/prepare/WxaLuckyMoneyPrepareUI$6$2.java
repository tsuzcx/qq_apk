package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WxaLuckyMoneyPrepareUI$6$2
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$6$2(WxaLuckyMoneyPrepareUI.6 param6) {}
  
  public final void run()
  {
    this.lMz.lMx.VH();
    ((InputMethodManager)this.lMz.lMx.mController.uMN.getSystemService("input_method")).showSoftInput(this.lMz.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6.2
 * JD-Core Version:    0.7.0.1
 */