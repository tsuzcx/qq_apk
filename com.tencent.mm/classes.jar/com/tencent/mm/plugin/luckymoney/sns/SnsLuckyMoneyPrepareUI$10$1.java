package com.tencent.mm.plugin.luckymoney.sns;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class SnsLuckyMoneyPrepareUI$10$1
  implements Runnable
{
  SnsLuckyMoneyPrepareUI$10$1(SnsLuckyMoneyPrepareUI.10 param10, View paramView) {}
  
  public final void run()
  {
    if ((!this.lTL.lTI.lMr.isShown()) && (this.val$view.isShown())) {
      SnsLuckyMoneyPrepareUI.k(this.lTL.lTI);
    }
    SnsLuckyMoneyPrepareUI.b(this.lTL.lTI, this.lTL.eYk);
    this.lTL.lTI.mKeyboard.setInputEditText((EditText)this.val$view);
    ((InputMethodManager)this.lTL.lTI.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyPrepareUI.10.1
 * JD-Core Version:    0.7.0.1
 */