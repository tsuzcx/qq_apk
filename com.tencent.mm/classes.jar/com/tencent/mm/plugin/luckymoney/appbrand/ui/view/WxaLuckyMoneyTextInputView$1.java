package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.luckymoney.ui.f;

final class WxaLuckyMoneyTextInputView$1
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyTextInputView$1(WxaLuckyMoneyTextInputView paramWxaLuckyMoneyTextInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (WxaLuckyMoneyTextInputView.a(this.lMZ) != null)
    {
      paramView = WxaLuckyMoneyTextInputView.a(this.lMZ);
      this.lMZ.getInputViewId();
      paramView.bfq();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView.1
 * JD-Core Version:    0.7.0.1
 */