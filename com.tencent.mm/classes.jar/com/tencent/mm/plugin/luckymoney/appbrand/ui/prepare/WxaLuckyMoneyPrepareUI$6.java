package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

final class WxaLuckyMoneyPrepareUI$6
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyPrepareUI$6(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramView.isFocused()) && (!this.eYg))
    {
      ((InputMethodManager)this.lMx.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ah().postDelayed(new WxaLuckyMoneyPrepareUI.6.1(this, paramView), 300L);
      return;
    }
    new ah().postDelayed(new WxaLuckyMoneyPrepareUI.6.2(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */