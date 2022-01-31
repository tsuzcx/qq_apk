package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$6$1
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$6$1(WxaLuckyMoneyPrepareUI.6 param6, View paramView) {}
  
  public final void run()
  {
    if ((!this.lMz.lMx.lMr.isShown()) && (this.val$view.isShown())) {
      this.lMz.lMx.lMr.setVisibility(0);
    }
    WxaLuckyMoneyPrepareUI.b(this.lMz.lMx, this.lMz.eYk);
    this.lMz.lMx.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.lMz.lMx.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6.1
 * JD-Core Version:    0.7.0.1
 */