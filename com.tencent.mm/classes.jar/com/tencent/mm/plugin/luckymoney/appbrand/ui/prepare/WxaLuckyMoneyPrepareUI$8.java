package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$8
  implements View.OnClickListener
{
  WxaLuckyMoneyPrepareUI$8(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, EditText paramEditText, View paramView, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if ((this.lMx.lMr.isShown()) && (!this.eYg)) {
      if (this.lMx.mKeyboard != null) {
        this.lMx.mKeyboard.setInputEditText(this.eYi);
      }
    }
    do
    {
      return;
      if ((!this.lMx.lMr.isShown()) && (!this.eYg))
      {
        ((InputMethodManager)this.lMx.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
        new ah().postDelayed(new WxaLuckyMoneyPrepareUI.8.1(this), 200L);
        return;
      }
    } while (!this.eYg);
    this.lMx.lMr.setVisibility(8);
    ((InputMethodManager)this.lMx.mController.uMN.getSystemService("input_method")).showSoftInput(this.eYi, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.8
 * JD-Core Version:    0.7.0.1
 */