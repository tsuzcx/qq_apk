package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$7
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$7(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    if ((!this.lMx.lMr.isShown()) && (!this.eYg))
    {
      this.lMx.lMr.setVisibility(0);
      this.lMx.mKeyboard.setInputEditText((EditText)paramView);
      WxaLuckyMoneyPrepareUI.b(this.lMx, this.eYk);
    }
    while (!this.eYg) {
      return;
    }
    this.lMx.lMr.setVisibility(8);
    ((InputMethodManager)this.lMx.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.7
 * JD-Core Version:    0.7.0.1
 */