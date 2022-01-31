package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class WxaLuckyMoneyPrepareUI$6
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyPrepareUI$6(WxaLuckyMoneyPrepareUI paramWxaLuckyMoneyPrepareUI, int paramInt, EditText paramEditText) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(42060);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.ojQ.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new ak().postDelayed(new WxaLuckyMoneyPrepareUI.6.1(this, paramView), 300L);
      AppMethodBeat.o(42060);
      return;
    }
    new ak().postDelayed(new WxaLuckyMoneyPrepareUI.6.2(this), 200L);
    AppMethodBeat.o(42060);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6
 * JD-Core Version:    0.7.0.1
 */