package com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WxaLuckyMoneyPrepareUI$6$1
  implements Runnable
{
  WxaLuckyMoneyPrepareUI$6$1(WxaLuckyMoneyPrepareUI.6 param6, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(42058);
    if ((!this.ojS.ojQ.mKBLayout.isShown()) && (this.val$view.isShown())) {
      this.ojS.ojQ.mKBLayout.setVisibility(0);
    }
    WxaLuckyMoneyPrepareUI.b(this.ojS.ojQ, this.ojS.val$editMode);
    this.ojS.ojQ.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.ojS.ojQ.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    AppMethodBeat.o(42058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.appbrand.ui.prepare.WxaLuckyMoneyPrepareUI.6.1
 * JD-Core Version:    0.7.0.1
 */