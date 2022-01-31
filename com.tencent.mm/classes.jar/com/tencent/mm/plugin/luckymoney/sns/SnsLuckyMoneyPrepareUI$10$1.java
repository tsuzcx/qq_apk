package com.tencent.mm.plugin.luckymoney.sns;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$10$1
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$10$1(SnsLuckyMoneyPrepareUI.10 param10, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(42517);
    if ((!this.oqQ.oqN.mKBLayout.isShown()) && (this.val$view.isShown())) {
      SnsLuckyMoneyPrepareUI.k(this.oqQ.oqN);
    }
    SnsLuckyMoneyPrepareUI.b(this.oqQ.oqN, this.oqQ.val$editMode);
    this.oqQ.oqN.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.oqQ.oqN.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
    AppMethodBeat.o(42517);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10.1
 * JD-Core Version:    0.7.0.1
 */