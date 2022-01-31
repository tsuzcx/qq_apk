package com.tencent.mm.plugin.luckymoney.appbrand.ui.view;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.ui.g;

final class WxaLuckyMoneyTextInputView$1
  implements View.OnFocusChangeListener
{
  WxaLuckyMoneyTextInputView$1(WxaLuckyMoneyTextInputView paramWxaLuckyMoneyTextInputView) {}
  
  public final void onFocusChange(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(42135);
    if (WxaLuckyMoneyTextInputView.a(this.oks) != null)
    {
      paramView = WxaLuckyMoneyTextInputView.a(this.oks);
      this.oks.getInputViewId();
      paramView.bMQ();
    }
    AppMethodBeat.o(42135);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.view.WxaLuckyMoneyTextInputView.1
 * JD-Core Version:    0.7.0.1
 */